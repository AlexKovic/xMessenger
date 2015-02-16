package com.experiencepvp.lava;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.coins.CoinsUtil;
import com.experiencepvp.events.EventsHandler;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitUtil;
import com.experiencepvp.scoreboard.ScoreboardMain;

public class LavaListener implements Listener{

public static SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (LavaMain.invincible.contains(p.getName())) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onLavaHit(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			Player p = (Player) e.getEntity();
			Player d = (Player) e.getDamager();
			if(LavaMain.maps.containsKey(p.getName()) || LavaMain.maps.containsKey(d.getName())){
				if(EventsHandler.running){
					if(!LavaMain.open){
						e.setCancelled(true);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onCommandInTourney(PlayerCommandPreprocessEvent e){
			if(LavaMain.maps.containsKey(e.getPlayer().getName())){
				if(EventsHandler.running == true){
					if(LavaMain.open == false){
						if(!e.getPlayer().isOp()){
							e.setCancelled(true);
							e.getPlayer().sendMessage(ChatColor.GRAY + "You can't use commands in the tourney! Relog to leave the tourney!");
						}
					}
				}
			}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLeaveInTourney(PlayerQuitEvent e){
		Player p = e.getPlayer();
		
		if(LavaMain.inqueue.containsKey(p.getName())){
			LavaMain.inqueue.remove(p.getName());
			return;
		}
		
		if(LavaMain.invincible.contains(p.getName())){
			LavaMain.invincible.remove(p.getName());
		}
		
		if(LavaMain.maps.containsKey(p.getName())){
			LavaMain.maps.remove(p.getName());
			LavaMain.players = LavaMain.players - 1;
			LavaMain.invincible.remove(p.getName());
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§6" + p.getName() + "§7 has left the Lava Challenge! §7(" + LavaMain.players + "/20)");
			if (LavaMain.players == 1 || LavaMain.playersIn() == 1) {
				for (final Player on : Bukkit.getOnlinePlayers()) {
					if(LavaMain.maps.containsKey(on.getName())) {
						if (LavaMain.maps.get(on.getName()) == LavaMain.runningmap) {
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix") + "§6" + on.getName() + " §7has won the Lava Challenge!"));
							on.sendMessage("§aCongratulations! You have won the Lava Challange!");
							LavaMain.spawnFirework(on);
							LavaMain.runningmap = null;
							LavaMain.players = 0;
							EventsHandler.running = false;
							EventsHandler.runningevent = "";
							LavaMain.maps.clear();
							EventsHandler.startCooldownTimer("lava");
							settings.getData().set(
									"stats." + on.getUniqueId() + ".wins",
									settings.getData().getInt(
											"stats." + on.getUniqueId() + ".wins") + 1);
							CoinsUtil.setCoins(on, CoinsUtil.getCoins(on) + (on.hasPermission("experiencepvp.rank.gold") ? 150 : 100));
							ScoreboardMain.updateScoreboard(on);
							settings.saveData();
							LavaMain.invincible.clear();
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
		
		if(LavaMain.inqueue.containsKey(p.getName())){
			return;
		}
		
		if (p.getKiller() != null) {
			if(p.getKiller() instanceof Player){
			final Player k = (Player) p.getKiller();
			if (LavaMain.maps.containsKey(p.getName())) {
				LavaMain.maps.remove(p.getName());
				LavaMain.players = LavaMain.players - 1;
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§6" + p.getName() + "§7 has been knocked out of the Lava Challenge by §6"
						+ k.getName() + " §7(" + LavaMain.players + "/20)");
				if (LavaMain.players == 1 || LavaMain.playersIn() == 1) {
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix") + "§6" + k.getName() + " §7has won the Lava Challenge!"));
					k.sendMessage("§aCongratulations! You have won the Lava Challenge!");
					LavaMain.spawnFirework(p);
					LavaMain.runningmap = null;
					LavaMain.players = 0;
					EventsHandler.running = false;
					EventsHandler.runningevent = "";
					LavaMain.maps.clear();
					settings.getData().set(
							"stats." + k.getUniqueId() + ".wins",
							settings.getData().getInt(
									"stats." + k.getUniqueId() + ".wins") + 1);
					CoinsUtil.setCoins(k, CoinsUtil.getCoins(k) + (k.hasPermission("experiencepvp.rank.gold") ? 150 : 100));
					ScoreboardMain.updateScoreboard(k);
					EventsHandler.startCooldownTimer("lava");
					ScoreboardMain.updateScoreboard(k);
					//LavaMain.testHead();
					LavaMain.invincible.clear();
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
			if (LavaMain.maps.containsKey(p.getName())) {
				LavaMain.maps.remove(p.getName());
				LavaMain.players = LavaMain.players - 1;
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§6" + p.getName() + "§7 has died §7(" + LavaMain.players + "/20)");
				if (LavaMain.players == 1 || LavaMain.playersIn() == 1) {
					for (final Player on : Bukkit.getOnlinePlayers()) {
						if(LavaMain.maps.containsKey(on.getName())) {
							if (LavaMain.maps.get(on.getName()) == LavaMain.runningmap) {
								Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix") + "§6" + on.getName() + " §7has won the tournament!"));
								on.sendMessage("§aCongratulations! You have won the tournament!");
								LavaMain.spawnFirework(p);
								LavaMain.runningmap = null;
								LavaMain.players = 0;
								EventsHandler.running = false;
								EventsHandler.runningevent = "";
								LavaMain.maps.clear();
								settings.getData().set(
										"stats." + on.getUniqueId() + ".wins",
										settings.getData().getInt(
												"stats." + on.getUniqueId() + ".wins") + 1);
								CoinsUtil.setCoins(on, CoinsUtil.getCoins(on) + (on.hasPermission("experiencepvp.rank.gold") ? 150 : 100));
								EventsHandler.startCooldownTimer("lava");
								ScoreboardMain.updateScoreboard(on);
								//LavaMain.testHead();
								LavaMain.invincible.clear();
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
