package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Gladiator implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("gladiator")) {
			if (LevelUtil.getLevel(p, KitType.GLADIATOR) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.GLADIATOR.getUtil().giveKit(p, KitType.GLADIATOR);
					return true;
				} else {
					p.sendMessage("§cYou can only have one kit a life!");
					return true;
				}
			} else {
				p.sendMessage("§cYou don't have the permission for this kit!");
				return true;
			}
		}
		return true;
	}

	public static HashMap<String, String> GladiatorBattle = new HashMap<String, String>();

	private static HashMap<String, Long> invin = new HashMap<String, Long>();

	public ArrayList<String> nMove = new ArrayList<String>();

	@EventHandler
	public void onGladiator(PlayerInteractEntityEvent e) {
		/* 2679 */final Player clicker = e.getPlayer();
		if (!(e.getRightClicked() instanceof Player))
			return;
		/* 2680 */final Player clicked = (Player) e.getRightClicked();
		/* 2681 */Block loca1 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() + 8, clicker.getLocation()
				.getBlockY() + 100, clicker.getLocation().getBlockZ() + 8)
				.getBlock();
		/* 2682 */Block loca2 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() - 8, clicker.getLocation()
				.getBlockY() + 100, clicker.getLocation().getBlockZ() - 8)
				.getBlock();
		/* 2683 */Block loca3 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() + 8, clicker.getLocation()
				.getBlockY() + 100, clicker.getLocation().getBlockZ() - 8)
				.getBlock();
		/* 2684 */Block loca4 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() - 8, clicker.getLocation()
				.getBlockY() + 100, clicker.getLocation().getBlockZ() + 8)
				.getBlock();
		/* 2685 */Block locb1 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() + 8, clicker.getLocation()
				.getBlockY() + 101, clicker.getLocation().getBlockZ() + 8)
				.getBlock();
		/* 2686 */Block locb2 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() - 8, clicker.getLocation()
				.getBlockY() + 101, clicker.getLocation().getBlockZ() - 8)
				.getBlock();
		/* 2687 */Block locb3 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() + 8, clicker.getLocation()
				.getBlockY() + 101, clicker.getLocation().getBlockZ() - 8)
				.getBlock();
		/* 2688 */Block locb4 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() - 8, clicker.getLocation()
				.getBlockY() + 101, clicker.getLocation().getBlockZ() + 8)
				.getBlock();
		/* 2689 */Block locc1 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() + 8, clicker.getLocation()
				.getBlockY() + 102, clicker.getLocation().getBlockZ() + 8)
				.getBlock();
		/* 2690 */Block locc2 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() - 8, clicker.getLocation()
				.getBlockY() + 102, clicker.getLocation().getBlockZ() - 8)
				.getBlock();
		/* 2691 */Block locc3 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() + 8, clicker.getLocation()
				.getBlockY() + 102, clicker.getLocation().getBlockZ() - 8)
				.getBlock();
		/* 2692 */Block locc4 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() - 8, clicker.getLocation()
				.getBlockY() + 102, clicker.getLocation().getBlockZ() + 8)
				.getBlock();
		/* 2693 */Block locd1 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() + 8, clicker.getLocation()
				.getBlockY() + 103, clicker.getLocation().getBlockZ() + 8)
				.getBlock();
		/* 2694 */Block locd2 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() - 8, clicker.getLocation()
				.getBlockY() + 103, clicker.getLocation().getBlockZ() - 8)
				.getBlock();
		/* 2695 */Block locd3 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() + 8, clicker.getLocation()
				.getBlockY() + 103, clicker.getLocation().getBlockZ() - 8)
				.getBlock();
		/* 2696 */Block locd4 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() - 8, clicker.getLocation()
				.getBlockY() + 103, clicker.getLocation().getBlockZ() + 8)
				.getBlock();
		/* 2697 */Block loce1 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() + 8, clicker.getLocation()
				.getBlockY() + 104, clicker.getLocation().getBlockZ() + 8)
				.getBlock();
		/* 2698 */Block loce2 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() - 8, clicker.getLocation()
				.getBlockY() + 104, clicker.getLocation().getBlockZ() - 8)
				.getBlock();
		/* 2699 */Block loce3 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() + 8, clicker.getLocation()
				.getBlockY() + 104, clicker.getLocation().getBlockZ() - 8)
				.getBlock();
		/* 2700 */Block loce4 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX() - 8, clicker.getLocation()
				.getBlockY() + 104, clicker.getLocation().getBlockZ() - 8)
				.getBlock();
		/* 2701 */Block locf1 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX(),
				clicker.getLocation().getBlockY() + 100, clicker.getLocation()
						.getBlockZ()).getBlock();
		/* 2702 */Block locf2 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX(),
				clicker.getLocation().getBlockY() + 101, clicker.getLocation()
						.getBlockZ()).getBlock();
		/* 2703 */Block locf3 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX(),
				clicker.getLocation().getBlockY() + 102, clicker.getLocation()
						.getBlockZ()).getBlock();
		/* 2704 */Block locf4 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX(),
				clicker.getLocation().getBlockY() + 103, clicker.getLocation()
						.getBlockZ()).getBlock();
		/* 2705 */Block locf5 = new Location(clicker.getWorld(), clicker
				.getLocation().getBlockX(),
				clicker.getLocation().getBlockY() + 104, clicker.getLocation()
						.getBlockZ()).getBlock();
		/* 2706 */if (((e.getRightClicked() instanceof Player)) &&
		/* 2707 */(clicker.getItemInHand().getType() == Material.IRON_FENCE)
				&& Main.correctRegion(clicker.getLocation())
				&& Main.correctRegion(clicked.getLocation()))
			/* 2709 */if ((loca1.getType() == Material.AIR)
					&& (loca2.getType() == Material.AIR)
					&& (loca3.getType() == Material.AIR)
					&& (loca4.getType() == Material.AIR)
					&& (locb1.getType() == Material.AIR)
					&& (locb2.getType() == Material.AIR)
					&& (locb3.getType() == Material.AIR)
					&& (locb4.getType() == Material.AIR)
					&& (locc1.getType() == Material.AIR)
					&& (locc2.getType() == Material.AIR)
					&& (locc3.getType() == Material.AIR)
					&& (locc4.getType() == Material.AIR)
					&& (locd1.getType() == Material.AIR)
					&& (locd2.getType() == Material.AIR)
					&& (locd3.getType() == Material.AIR)
					&& (locd4.getType() == Material.AIR)
					&& (loce1.getType() == Material.AIR)
					&& (loce2.getType() == Material.AIR)
					&& (loce3.getType() == Material.AIR)
					&& (loce4.getType() == Material.AIR)
					&& (locf1.getType() == Material.AIR)
					&& (locf2.getType() == Material.AIR)
					&& (locf3.getType() == Material.AIR)
					&& (locf4.getType() == Material.AIR)
					&& (locf5.getType() == Material.AIR)) {
				/* 2710 */if ((!com.experiencepvp.kits.listeners.cmds.Gladiator.GladiatorBattle
						.containsKey(clicked.getName()))
						&&
						/* 2711 */(!com.experiencepvp.kits.listeners.cmds.Gladiator.GladiatorBattle
								.containsKey(clicker.getName()))
						&&
						/* 2712 */(KitHandler.getKit(clicker.getName()) == KitType.GLADIATOR &&
						/* 2713 */(clicker.getItemInHand().getType() == Material.IRON_FENCE))) {
					e.setCancelled(true);
					/* 2714 */com.experiencepvp.kits.utils.Gladiator.lastLocation.put(clicker.getName(), clicker.getLocation());
					/* 2715 */com.experiencepvp.kits.utils.Gladiator.lastLocation.put(clicked.getName(), clicker.getLocation());
					/* 2716 */com.experiencepvp.kits.utils.Gladiator.SetGladiatorArena(clicker);
					/* 2717 */com.experiencepvp.kits.listeners.cmds.Gladiator.GladiatorBattle.put(clicked.getName(), clicker.getName());
					/* 2718 */com.experiencepvp.kits.listeners.cmds.Gladiator.GladiatorBattle.put(clicker.getName(), clicked.getName());
					/* 2719 */com.experiencepvp.kits.utils.Gladiator.getInstance().teleport(clicker, clicked);
					/* 2720 */clicker.sendMessage("§aYou are now in a 1v1 with §6" + clicked.getName());
					/* 2721 */clicked.sendMessage("§aYou are now in a 1v1 with §6" + clicker.getName());
					/* 2722 */this.nMove.add(clicked.getName());
					/* 2723 */this.nMove.add(clicker.getName());
					/* 2724 */Bukkit.getScheduler().runTaskLater(
							com.experiencepvp.kits.Main.getPlugin(),
							new Runnable() {
								public void run() {
									/* 2726 */clicked
											.sendMessage("§cThe battle will start in: §f ");
									/* 2727 */clicked.sendMessage("§a3..");
									/* 2728 */clicker
											.sendMessage("§cThe battle will start in: §f:");
									/* 2729 */clicker.sendMessage("§a3..");
									/* 2730 */Bukkit.getScheduler()
											.runTaskLater(
													com.experiencepvp.kits.Main
															.getPlugin(),
													new Runnable() {
														public void run() {
															/* 2732 */clicked
																	.sendMessage("§a2..");
															/* 2733 */clicker
																	.sendMessage("§a2..");
															/* 2734 */Bukkit
																	.getScheduler()
																	.runTaskLater(
																			com.experiencepvp.kits.Main
																					.getPlugin(),
																			new Runnable() {
																				public void run() {
																					/* 2736 */clicked.sendMessage("§a1..");
																					/* 2737 */clicker.sendMessage("§a1..");
																					/* 2738 */Bukkit.getScheduler().runTaskLater(com.experiencepvp.kits.Main
																											.getPlugin(),
																									new Runnable() {
																										public void run() {
																											/* 2740 */nMove.remove(clicked.getName());
																											/* 2741 */nMove.remove(clicker.getName());
																											/* 2742 */clicked.sendMessage("§aGo!");
																											/* 2743 */clicker.sendMessage("§aGo!");
																													  if(KitHandler.getLevel(clicker.getName()) == 2){
																															clicker.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 0));
																													  }else if(KitHandler.getLevel(clicker.getName()) == 3){
																															clicker.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 140, 0));																														  
																													  }else if(KitHandler.getLevel(clicker.getName()) == 4){
																															clicker.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));																														  
																													  }
																										}
																									},
																									20L);
																				}
																			},
																			20L);
														}
													}, 20L);
								}
							}, 20L);
				}
			} else {
			}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onGladiatorDeath(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		if(GladiatorBattle.containsKey(p.getName())){
			Invincible(Bukkit.getServer().getPlayer(GladiatorBattle.get(p.getName())));
			GladiatorBattle.remove(p.getName());
			GladiatorBattle.remove(GladiatorBattle.get(p.getName()));
		}
		
		for(ItemStack i : e.getDrops()){
			p.getWorld().dropItemNaturally(com.experiencepvp.kits.utils.Gladiator.lastLocation.get(GladiatorBattle.get(p.getName())), i);
		}
		e.getDrops().clear();
	}

	public void Invincible(final Player p) {
		if (GladiatorBattle.containsKey(p.getName())) {
			p.teleport((Location) com.experiencepvp.kits.utils.Gladiator.lastLocation
					.get(p.getName()));
			com.experiencepvp.kits.utils.Gladiator.DeleteGladiatorArena(p);
			invin.put(p.getName(), System.currentTimeMillis() + 5000);
			GladiatorBattle.remove(p.getName());
			p.sendMessage("§aYou Are Now Invincible For 5 Seconds§c.");
		}
	}

	@EventHandler
	public void sOnMove(PlayerMoveEvent e) {
		/* 2791 */if (nMove.contains(e.getPlayer().getName()))
			/* 2792 */e.setTo(e.getFrom());
	}

	
	//@SuppressWarnings("deprecation")
	//@EventHandler(priority = EventPriority.HIGHEST)
	//public void onPlayerQuit(PlayerQuitEvent e) {
	//	Player p = e.getPlayer();
	//	if (GladiatorBattle.containsKey(p.getName()))
	//		for (Player online : Bukkit.getOnlinePlayers()) {
	//			Player killer = Bukkit
	//					.getPlayerExact((String) GladiatorBattle.get(online));
	//			killer
	//					.teleport((Location) com.experiencepvp.kits.utils.Gladiator.lastLocation
	//							.get(p.getKiller().getName()));
	//			com.experiencepvp.kits.utils.Gladiator
	//					.DeleteGladiatorArena(p);
	//			com.experiencepvp.kits.utils.Gladiator
	//					.DeleteGladiatorArena(killer);
	//		}
	//}
	
	
	@EventHandler
	public void onQuitInBox(PlayerQuitEvent e){
		final Player p = e.getPlayer();
		if(GladiatorBattle.containsKey(p.getName())){
			Invincible(Bukkit.getServer().getPlayer(GladiatorBattle.get(p.getName())));
			GladiatorBattle.remove(p.getName());
			GladiatorBattle.remove(GladiatorBattle.get(p.getName()));
			
			new BukkitRunnable(){
				public void run(){
					for(ItemStack i : p.getInventory().getContents()){
						p.getWorld().dropItemNaturally(Bukkit.getServer().getPlayer(GladiatorBattle.get(p.getName())).getLocation(), i);
					}
				}
			}.runTaskLater(Main.getPlugin(), 2);
		}		
		
	}
	
}
