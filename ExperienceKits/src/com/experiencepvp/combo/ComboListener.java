package com.experiencepvp.combo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.coins.CoinsUtil;
import com.experiencepvp.events.EventsHandler;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitUtil;
import com.experiencepvp.scoreboard.ScoreboardMain;

public class ComboListener implements Listener {
	
public static SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (ComboMain.invincible.contains(p.getName())) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onCommandInTourney(PlayerCommandPreprocessEvent e){
			if(ComboMain.maps.containsKey(e.getPlayer().getName())){
				if(EventsHandler.running == true){
					if(ComboMain.open == false){
						if(!e.getPlayer().isOp()){
							e.setCancelled(true);
							e.getPlayer().sendMessage(ChatColor.GRAY + "You can't use commands in the tourney! Relog to leave the tourney!");
						}
					}
				}
			}
	}
	
	@EventHandler
	public void onCheat(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(ComboMain.maps.containsKey(p.getName()) && !ComboMain.open && EventsHandler.running){
			if(p.getInventory().getItemInHand().getType() != Material.AIR){
				p.getInventory().setItemInHand(new ItemStack(Material.AIR));
				p.sendMessage(Main.pref + ChatColor.RED + "Nice try, but I'm always watching you. -alexkovic");
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLeaveInTourney(PlayerQuitEvent e){
		Player p = e.getPlayer();
		
		if(ComboMain.inqueue.containsKey(p.getName())){
			ComboMain.inqueue.remove(p.getName());
			return;
		}
		
		if(ComboMain.invincible.contains(p.getName())){
			ComboMain.invincible.remove(p.getName());
		}
		
		if(ComboMain.maps.containsKey(p.getName())){
			ComboMain.maps.remove(p.getName());
			ComboMain.players = ComboMain.players - 1;
			ComboMain.invincible.remove(p.getName());
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§6" + p.getName() + "§7 has left the Combo Challenge! §7(" + ComboMain.players + "/20)");
			if (ComboMain.players == 1 || ComboMain.playersIn() == 1) {
				for (final Player on : Bukkit.getOnlinePlayers()) {
					if(ComboMain.maps.containsKey(on.getName())) {
						if (ComboMain.maps.get(on.getName()) == ComboMain.runningmap) {
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix") + "§6" + on.getName() + " §7has won the Combo Challenge!"));
							on.sendMessage(Main.pref + ChatColor.GOLD + "Congratulations! You have won the Combo Challange!");
							ComboMain.spawnFirework(on);
							ComboMain.runningmap = null;
							ComboMain.players = 0;
							EventsHandler.running = false;
							EventsHandler.runningevent = "";
							ComboMain.maps.clear();
							EventsHandler.startCooldownTimer("combo");
							ScoreboardMain.updateScoreboard(on);
							settings.getData().set(
									"stats." + on.getUniqueId() + ".wins",
									settings.getData().getInt(
											"stats." + on.getUniqueId() + ".wins") + 1);
							CoinsUtil.setCoins(on, CoinsUtil.getCoins(on) + (on.hasPermission("experiencepvp.rank.gold") ? 150 : 100));
							settings.saveData();
							ComboMain.invincible.clear();
							//LavaMain.testHead();
							new BukkitRunnable() {
								public void run() {
									World w = Bukkit.getWorld(settings.getConfig().getString("spawn.world"));
									double x = settings.getConfig().getDouble("spawn.x");
									double y = settings.getConfig().getDouble("spawn.y");
									double z = settings.getConfig().getDouble("spawn.z");
									float yaw = (float) settings.getConfig().getDouble("spawn.yaw");
									float pitch = (float) settings.getConfig().getDouble("spawn.pitch");
									on.teleport(new Location(w, x, y, z, yaw, pitch));
									on.sendMessage("§aThanks for playing!");
									KitHandler.delKit(on);
									KitUtil.clearInventory(on);
								}
							}.runTaskLater(Main.getPlugin(), 140L);
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler (priority=EventPriority.HIGHEST)
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		
		if(ComboMain.inqueue.containsKey(p.getName())){
			return;
		}
		
		if (p.getKiller() != null) {
			if(p.getKiller() instanceof Player){
			final Player k = (Player) p.getKiller();
			if (ComboMain.maps.containsKey(p.getName())) {
				ComboMain.maps.remove(p.getName());
				ComboMain.players = ComboMain.players - 1;
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§6" + p.getName() + "§7 has been knocked out of the Combo Challenge by §6"
						+ k.getName() + " §7(" + ComboMain.players + "/20)");
				if (ComboMain.players == 1 || ComboMain.playersIn() == 1) {
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix") + "§6" + k.getName() + " §7has won the Combo Challenge!"));
					k.sendMessage(Main.pref + ChatColor.GOLD + "Congratulations! You have won the Lava Challenge!");
					ComboMain.spawnFirework(p);
					ComboMain.runningmap = null;
					ComboMain.players = 0;
					EventsHandler.running = false;
					EventsHandler.runningevent = "";
					ComboMain.maps.clear();
					settings.getData().set(
							"stats." + k.getUniqueId() + ".wins",
							settings.getData().getInt(
									"stats." + k.getUniqueId() + ".wins") + 1);
					CoinsUtil.setCoins(k, CoinsUtil.getCoins(k) + (k.hasPermission("experiencepvp.rank.gold") ? 150 : 100));
					EventsHandler.startCooldownTimer("combo");
					//LavaMain.testHead();
					ComboMain.invincible.clear();
					new BukkitRunnable() {
						public void run() {
							World w = Bukkit.getWorld(settings.getConfig().getString("spawn.world"));
							double x = settings.getConfig().getDouble("spawn.x");
							double y = settings.getConfig().getDouble("spawn.y");
							double z = settings.getConfig().getDouble("spawn.z");
							float yaw = (float) settings.getConfig().getDouble("spawn.yaw");
							float pitch = (float) settings.getConfig().getDouble("spawn.pitch");
							k.teleport(new Location(w, x, y, z, yaw, pitch));
						}
					}.runTaskLater(Main.getPlugin(), 140L);
				}
			}
			}
		} else {
			if (ComboMain.maps.containsKey(p.getName())) {
				ComboMain.maps.remove(p.getName());
				ComboMain.players = ComboMain.players - 1;
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§6" + p.getName() + "§7 has died §7(" + ComboMain.players + "/20)");
				if (ComboMain.players == 1 || ComboMain.playersIn() == 1) {
					for (final Player on : Bukkit.getOnlinePlayers()) {
						if(ComboMain.maps.containsKey(on.getName())) {
							if (ComboMain.maps.get(on.getName()) == ComboMain.runningmap) {
								Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix") + "§6" + on.getName() + " §7has won the tournament!"));
								on.sendMessage("§aCongratulations! You have won the tournament!");
								ComboMain.spawnFirework(p);
								ComboMain.runningmap = null;
								ComboMain.players = 0;
								EventsHandler.running = false;
								EventsHandler.runningevent = "";
								ComboMain.maps.clear();
								settings.getData().set(
										"stats." + on.getUniqueId() + ".wins",
										settings.getData().getInt(
												"stats." + on.getUniqueId() + ".wins") + 1);
								CoinsUtil.setCoins(on, CoinsUtil.getCoins(on) + (on.hasPermission("experiencepvp.rank.gold") ? 150 : 100));
								EventsHandler.startCooldownTimer("combo");
								//LavaMain.testHead();
								ComboMain.invincible.clear();
								new BukkitRunnable() {
									public void run() {
										World w = Bukkit.getWorld(settings.getConfig().getString("spawn.world"));
										double x = settings.getConfig().getDouble("spawn.x");
										double y = settings.getConfig().getDouble("spawn.y");
										double z = settings.getConfig().getDouble("spawn.z");
										float yaw = (float) settings.getConfig().getDouble("spawn.yaw");
										float pitch = (float) settings.getConfig().getDouble("spawn.pitch");
										on.teleport(new Location(w, x, y, z, yaw, pitch));
										on.sendMessage("§aThanks for playing!");
										KitHandler.delKit(on);
										KitUtil.clearInventory(on);
									}
								}.runTaskLater(Main.getPlugin(), 140L);
							}
						}
					}
				}
			}
		}
	}	
}
