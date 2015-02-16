package com.experiencepvp.kits.listeners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.experiencepvp.kits.GUI;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.Spawn;
import com.experiencepvp.kits.listeners.cmds.Rogue;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitUtil;
import com.experiencepvp.levels.LevelUI;
import com.experiencepvp.ranks.RankUI;

public class PlayerListener implements Listener {

	SettingsManager settings = SettingsManager.getInstance();
	
	
	public double launcherStrength = 2.6D;

	/**
	 * Sponges
	 */
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		try {
			Block b = event.getTo().getBlock();
			Location temp = b.getLocation();
			temp.setY(temp.getY() - 1.0D);
			Block b2 = temp.getBlock();
			if (b2.getType() == Material.SPONGE) {
				p.setVelocity(new Vector(0, launcherStrength, 0));
				p.setFallDistance(-50);
			} else if (p.getFallDistance() <= 0 && b2.getType() != Material.AIR) {
				p.setFallDistance(0);
			}
		} catch (Exception localException) {
		}
	}

	@EventHandler
	public void onItemDamage(PlayerItemDamageEvent event) {
		event.setCancelled(true);
	}

	/**
	 * Nerf teh crits
	 */
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.LOW)
	public void nerfCrits(EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player) {
			if (event.getEntity() instanceof Player)
				if (((Player) event.getEntity()).getNoDamageTicks() > 10) {
					event.setCancelled(true);
					return;
				}
			Player damager = (Player) event.getDamager();
			ItemStack item = damager.getItemInHand();
			if (item != null) {
				if (item.getType() == Material.WOOD_SWORD)
					event.setDamage(4.0);
				else if (damager.getItemInHand().getType() == Material.STONE_SWORD)
					event.setDamage(5);
			}
			if (!damager.isOnGround() && damager.getFallDistance() > 0) {
				// double damage = event.getDamage() / 150;
				// damage = 100 * damage;
				event.setDamage(event.getDamage() + 1);
			}
			if (event.getDamage() > 6)
				event.setDamage(6);
		}
	}

	private HashMap<String, Long> msgcooldown = new HashMap<String, Long>();

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		if (!event.getPlayer().isOp())
			if (msgcooldown.containsKey(event.getPlayer().getName())
					&& msgcooldown.get(event.getPlayer().getName()) > System
							.currentTimeMillis()) {
				event.setCancelled(true);
				event.getPlayer()
						.sendMessage(
								ChatColor.RED
										+ "You can only send a message every 2 seconds.");
				return;
			}
		msgcooldown.put(event.getPlayer().getName(),
				System.currentTimeMillis() + 2000);
		if (event.getMessage().contains("@")) {
			for (String s : event.getMessage().split(" ")) {
				if (s.startsWith("@"))
					if (Bukkit.getPlayer(s.replace("@", "")) != null) {
						Player target = Bukkit.getPlayer(s.replace("@", ""));
						target.playSound(target.getLocation(), Sound.CAT_MEOW,
								1, 1);
					}
			}
		}
	}
		
	
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent event) {
		if (event.getPlayer().getGameMode() != GameMode.CREATIVE
				|| !(event.getRightClicked() instanceof Player))
			return;
		event.getPlayer().openInventory(
				((Player) event.getRightClicked()).getInventory());
	}

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if (e.getLine(1).equalsIgnoreCase("Kit")
				&& e.getLine(2).equalsIgnoreCase("Selector")) {
			e.setLine(1, "§lKit");
			e.setLine(2, "§9Selector");
		}
	}

	@EventHandler
	public void onPlayerInteract1(PlayerInteractEvent e) {
		if (e.getClickedBlock() != null
				&& e.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE)
			e.setCancelled(true);

		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block b = e.getClickedBlock();
			if (b.getType() == Material.WALL_SIGN
					|| b.getType() == Material.SIGN_POST) {
				Sign sign = (Sign) b.getState();
				if (sign.getLine(1).equalsIgnoreCase("§lKit")
						&& sign.getLine(2).equalsIgnoreCase("§9Selector")) {
					e.getPlayer().openInventory(GUI.getKitGui(e.getPlayer()));
				}
			}
		}
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if (e.getPlayer().getGameMode().equals(GameMode.SURVIVAL))
			e.setCancelled(true);
	}

	@EventHandler
	public void onPlaceBlock(BlockPlaceEvent e) {
		if (e.getPlayer().getGameMode().equals(GameMode.SURVIVAL))
			e.setCancelled(true);
	}

	@EventHandler
	public void onJoin2(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.getInventory().clear();
	}

	public static HashMap<String, Integer> killstreaks = new HashMap<String, Integer>();
	private static Integer[] ints = new Integer[] { 10, 20, 30, 50, 69, 100,
			250 };

	/**
	 * Disable mute obeying
	 */
	@EventHandler
	public void oncmd(PlayerCommandPreprocessEvent event) {
		if (event.getMessage().equalsIgnoreCase("/bukkit:me") || event.getMessage().equalsIgnoreCase("/bukkit:pl")){
			event.setCancelled(true);
		}
	}

	/**
	 * Killstreaks
	 */
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		final Player p = e.getEntity();
		KitHandler.delKit(p);
		if (e.getEntity().getKiller() != null) {
			String name = e.getEntity().getKiller().getName();
			if (killstreaks.containsKey(name))
				killstreaks.put(name, killstreaks.get(name) + 1);
			else
				killstreaks.put(name, 1);
			int kills = killstreaks.get(name);
			if (Arrays.asList(ints).contains(kills)) {
				Bukkit.getServer().broadcastMessage(
						ChatColor.GOLD + name + ChatColor.BLUE
								+ " has reached a killstreak of §6" + kills
								+ ChatColor.BLUE + "!");
			}
		}
	}

	/*
	 * Soup
	 */
	@EventHandler
	public void onSoup(PlayerInteractEvent event) {
		ItemStack is = event.getPlayer().getItemInHand();
		if (is == null
				|| is.getType() != Material.MUSHROOM_SOUP
				|| !event.getAction().toString().toLowerCase()
						.contains("right"))
			return;
		Player p = event.getPlayer();
		Damageable pd = (Damageable) p;
		if (pd.getHealth() == 20.0)
			return;
		double health = pd.getHealth();
		p.setHealth(health + 7.0 > 20.0 ? 20.0 : health + 7);
		is.setType(Material.BOWL);
		is.setItemMeta(null);
		p.setItemInHand(is);
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		KitHandler.delKit(p);
		killstreaks.remove(e.getPlayer().getName());
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		p.getInventory().clear();
		killstreaks.put(e.getPlayer().getName(), 0);
		PlayerListener.setUpSpawnItems(p);
		p.teleport(Spawn.getSpawnLoc());
	}

	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onDrop(final PlayerDropItemEvent e) {
		if (isKitItem(e.getItemDrop().getItemStack())) {
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.LOW)
	public void onDeathDrop(PlayerDeathEvent e) {
		Player p = e.getEntity();
		for (ItemStack item : e.getDrops()) {
			if (!isKitItem(item) && Main.correctRegion(p.getLocation())) {
				final Item droppedItem = p.getWorld().dropItemNaturally(
						p.getLocation().add(0.5D, 0.5D, 0.5D), item);
				droppedItem.setVelocity(new Vector(0, 0, 0));
				droppedItem.setPickupDelay(20);
			}
		}
		e.getDrops().clear();
	}

	public boolean isKitItem(ItemStack item) {
		Material[] nope = { Material.BOW, Material.WATCH,
				Material.FIREWORK, Material.FISHING_ROD, Material.WOOD_AXE,
				Material.FEATHER, Material.WOOD_HOE, Material.ENDER_PEARL,
				Material.IRON_FENCE, Material.IRON_SWORD,
				Material.DIAMOND_SWORD, Material.IRON_AXE, Material.LEASH,
				Material.BLAZE_POWDER, Material.SNOW_BALL, Material.ANVIL };

		return Arrays.asList(nope).contains(item.getType());
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (p.getItemInHand().getType().equals(Material.STONE_SWORD)) {

				// NORMAL HIT
				e.setDamage(5D);
				if (!p.isOnGround()) {
					// NORMAL CRIT
					e.setDamage(6D);
					if (p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)
							|| p.getItemInHand().containsEnchantment(
									Enchantment.DAMAGE_ALL)) {
						// SHARP CRIT
						e.setDamage(7D);
					}
				}
				if (p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)
						|| p.getItemInHand().containsEnchantment(
								Enchantment.DAMAGE_ALL)) {
					// SHARP HIT
					e.setDamage(6D);
				}
			}
		}
	}

	public ArrayList<String> chestcd = new ArrayList<String>();
	
	@EventHandler
	public void onChest(PlayerInteractEvent e) {
		final Player player = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getClickedBlock() != null) {
				if (e.getClickedBlock().getType() == Material.CHEST) {
					e.setCancelled(true);
					
					if(isInSpawnRegion(e.getClickedBlock().getLocation())){
						player.openInventory(LevelUI.getChooseBuyOrUpGUI(player));
						return;
					}

					if(isInLavaRegion(e.getClickedBlock().getLocation())){
						return;
					}
					
					if(chestcd.contains(player.getName())){
						player.sendMessage(Main.pref + ChatColor.RED + "You can't open a Soup Chest yet!");
						return;
					}
					
					player.openInventory(generateSoupInventory());
					
					chestcd.add(player.getName());
					new BukkitRunnable(){
						public void run(){
							chestcd.remove(player.getName());
							player.sendMessage(Main.pref + ChatColor.GOLD + "You can open a Soup Chest again!");
						}
					}.runTaskLater(Main.getPlugin(), 600);
				}
			}
		}
	}
	
	@EventHandler
	public void onDeathChestCD(PlayerDeathEvent e){
		Player p = e.getEntity();
		if(chestcd.contains(p.getName())){
			chestcd.remove(p.getName());
		}
	}

	private Inventory generateSoupInventory() {
		Inventory result = Bukkit.createInventory(null, 54, "§9Refill chest!");
		for (int i = 0; i < 54; i++) {
			result.addItem(KitUtil.setName(
					new ItemStack(Material.MUSHROOM_SOUP), "§9Soup"));
		}
		return result;
	}

	/*
	 * @EventHandler public void onAutoRespawn(PlayerDeathEvent e) { 770 final
	 * Player p = e.getEntity(); 772 if ((p instanceof Player)) { 773
	 * Bukkit.getScheduler().scheduleSyncDelayedTask( Main.getPlugin(), new
	 * Runnable() { public void run() { 776 PacketPlayInClientCommand packet =
	 * new PacketPlayInClientCommand(); try { 778 Field a =
	 * PacketPlayInClientCommand.class .getDeclaredField("a"); 779
	 * a.setAccessible(true); 780 p.teleport(p.getLocation().getWorld()
	 * .getSpawnLocation()); 781 a.set(packet,
	 * EnumClientCommand.PERFORM_RESPAWN); } catch (NoSuchFieldException e) {
	 * 783 e.printStackTrace(); } catch (SecurityException e) { 785
	 * e.printStackTrace(); } catch (IllegalArgumentException e) { 787
	 * e.printStackTrace(); } catch (IllegalAccessException e) { 789
	 * e.printStackTrace(); } 791 ((CraftPlayer) p).getHandle().playerConnection
	 * .a(packet); }
	 * 
	 * } , 1L); } }
	 */

	@EventHandler
	public void onChange(BlockBurnEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onIgnite(BlockIgniteEvent e) {
		if (e.getCause() == IgniteCause.SPREAD) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onFireSpawn(BlockPlaceEvent e) {
		if (e.getBlockAgainst().getType() == Material.CHEST) {
			e.setCancelled(true);
		}
	}
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onConnect(ServerListPingEvent e) {
		List<String> motds = settings.getConfig().getStringList("motds");
		Random r = new Random();
		int index = r.nextInt(motds.size());
		e.setMotd(motds.get(index).replaceAll("&", "\u00A7"));
	}
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		p.setGameMode(GameMode.SURVIVAL);
		
		p.getInventory().clear();
		
		setUpSpawnItems(p);
		
		final World w = Bukkit.getWorld(settings.getConfig().getString("spawn.world"));
		final double x = settings.getConfig().getDouble("spawn.x");
		final double y = settings.getConfig().getDouble("spawn.y");
		final double z = settings.getConfig().getDouble("spawn.z");
		final float yaw = settings.getConfig().getInt("spawn.yaw");
		final float pitch = settings.getConfig().getInt("spawn.pitch");
		final Location spawn = new Location(w, x, y, z, yaw, pitch);
		
		p.setGameMode(GameMode.SURVIVAL);
		
		p.teleport(spawn);
		
		p.setAllowFlight(false);
		p.setFlying(false);
		
		if(p.hasPermission("experiencepvp.rank")) {
		e.setJoinMessage((settings.getConfig().getString("messages.joinleftrank").replaceAll("<name>", p.getName()).replaceAll("&", "§")).replaceAll("<type>", "joined"));
		} else {
		e.setJoinMessage((settings.getConfig().getString("messages.joinleftnormal").replaceAll("<name>", p.getName()).replaceAll("&", "§")).replaceAll("<type>", "joined"));
		}
	}
	
	
	public static void setUpSpawnItems(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		
		ItemStack paper = new ItemStack(Material.PAPER);
		ItemMeta paperim = paper.getItemMeta();
		paperim.setDisplayName(ChatColor.BOLD + "" + ChatColor.BLUE + "Kit Selector");
		paper.setItemMeta(paperim);
		
		ItemStack blaze = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta blazeim = blaze.getItemMeta();
		blazeim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + "Ranks");
		blaze.setItemMeta(blazeim);
		
		ItemStack pref = new ItemStack(Material.REDSTONE_COMPARATOR);
		ItemMeta prefim = pref.getItemMeta();
		prefim.setDisplayName("§7Preferences");
		pref.setItemMeta(prefim);
		
		p.getInventory().setItem(0, paper);
		p.getInventory().setItem(4, blaze);
		p.getInventory().setItem(8, pref);
	}
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onClickItemInHotbar(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(!KitHandler.hasKit(p.getName())){
				if(p.getInventory().getItemInHand().getType() == Material.PAPER){
					p.openInventory(LevelUI.getOwnKitsGUI(p, 1));
				}else if(p.getInventory().getItemInHand().getType() == Material.BLAZE_POWDER){
					p.openInventory(RankUI.getChooseInv());
				}
			}
		}
	}
	
	
	@EventHandler
	public void playerQuit(PlayerQuitEvent e) { 
		Player p = e.getPlayer();
		if(p.hasPermission("experiencepvp.rank")) {
			if(settings.getConfig().contains("messages.joinleftrank")){
				e.setQuitMessage((settings.getConfig().getString("messages.joinleftrank").replaceAll("<name>", p.getName()).replaceAll("&", "§")).replaceAll("<type>", "left"));
			}
		} else {
			if(settings.getConfig().contains("messages.joinleftnormal")){
				e.setQuitMessage((settings.getConfig().getString("messages.joinleftnormal").replaceAll("<name>", p.getName()).replaceAll("&", "§")).replaceAll("<type>", "left"));
			}
		}
		p.getInventory().clear();
	}
	
	
	public static boolean isInLavaRegion(Location l){
		if(l.getX() < 3766 && l.getX() > 3703){
			if(l.getZ() < 435525 && l.getZ() > 435466){
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isInSpawnRegion(Location l){
//		if(l.getX() < 9907 && l.getX() > 9858){
//			if(l.getZ() < 9716 && l.getZ() > 9622){
//				return true;
//			}
//		}
		
		return Main.correctRegion(l);
	}
	
	public static ArrayList<Location> prot = new ArrayList<Location>();
}