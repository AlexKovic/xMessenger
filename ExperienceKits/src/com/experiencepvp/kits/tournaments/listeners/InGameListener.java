package com.experiencepvp.kits.tournaments.listeners;

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
import com.experiencepvp.kits.tournaments.TourneyMain;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitUtil;
import com.experiencepvp.scoreboard.ScoreboardMain;

public class InGameListener implements Listener {

	public static SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (TourneyMain.invincible.contains(p.getName())) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onCommandInTourney(PlayerCommandPreprocessEvent e){
			if(TourneyMain.maps.containsKey(e.getPlayer().getName())){
				if(EventsHandler.running == true){
					if(TourneyMain.open == false){
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
		
		if(TourneyMain.inqueue.containsKey(p.getName())){
			TourneyMain.inqueue.remove(p.getName());
			return;
		}
		
		if(TourneyMain.invincible.contains(p.getName())){
			TourneyMain.invincible.remove(p.getName());
		}
		
		if(TourneyMain.maps.containsKey(p.getName())){
			TourneyMain.maps.remove(p.getName());
			TourneyMain.players = TourneyMain.players - 1;
			TourneyMain.invincible.remove(p.getName());
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§6" + p.getName() + "§7 has left the tourney! §7(" + TourneyMain.players + "/20)");
			if (TourneyMain.players == 1 || TourneyMain.playersIn() == 1) {
				for (final Player on : Bukkit.getOnlinePlayers()) {
					if(TourneyMain.maps.containsKey(on.getName())) {
						if (TourneyMain.maps.get(on.getName()) == TourneyMain.runningmap) {
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix") + "§6" + on.getName() + " §7has won the tournament!"));
							on.sendMessage("§aCongratulations! You have won the tournament!");
							TourneyMain.spawnFirework(on);
							TourneyMain.runningmap = null;
							TourneyMain.players = 0;
							EventsHandler.running = false;
							EventsHandler.runningevent = "";
							TourneyMain.maps.clear();
							EventsHandler.startCooldownTimer("tourney");
							settings.getData().set(
									"stats." + on.getUniqueId() + ".wins",
									settings.getData().getInt(
											"stats." + on.getUniqueId() + ".wins") + 1);
							CoinsUtil.setCoins(on, CoinsUtil.getCoins(on) + (on.hasPermission("experiencepvp.rank.gold") ? 150 : 100));
							TourneyMain.invincible.clear();
							ScoreboardMain.updateScoreboard(on);
							TourneyMain.testHead();
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
	
	@EventHandler (priority=EventPriority.HIGHEST)
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		
		if(TourneyMain.inqueue.containsKey(p.getName())){
			return;
		}
		
		if (p.getKiller() != null) {
			if(p.getKiller() instanceof Player){
			final Player k = (Player) p.getKiller();
			if (TourneyMain.maps.containsKey(p.getName())) {
				TourneyMain.maps.remove(p.getName());
				TourneyMain.players = TourneyMain.players - 1;
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§6" + p.getName() + "§7 has been knocked out of the tournament by §6"
						+ k.getName() + " §7(" + TourneyMain.players + "/20)");
				if (TourneyMain.players == 1 || TourneyMain.playersIn() == 1) {
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix") + "§6" + k.getName() + " §7has won the tournament!"));
					k.sendMessage("§aCongratulations! You have won the tournament!");
					TourneyMain.spawnFirework(p);
					TourneyMain.runningmap = null;
					TourneyMain.players = 0;
					EventsHandler.running = false;
					EventsHandler.runningevent = "";
					TourneyMain.maps.clear();
					settings.getData().set(
							"stats." + k.getUniqueId() + ".wins",
							settings.getData().getInt(
									"stats." + k.getUniqueId() + ".wins") + 1);
					CoinsUtil.setCoins(k, CoinsUtil.getCoins(k) + (k.hasPermission("experiencepvp.rank.gold") ? 150 : 100));
					EventsHandler.startCooldownTimer("tourney");
					ScoreboardMain.updateScoreboard(k);
					TourneyMain.testHead();
					TourneyMain.invincible.clear();
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
			if (TourneyMain.maps.containsKey(p.getName())) {
				TourneyMain.maps.remove(p.getName());
				TourneyMain.players = TourneyMain.players - 1;
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§6" + p.getName() + "§7 has died §7(" + TourneyMain.players + "/20)");
				if (TourneyMain.players == 1 || TourneyMain.playersIn() == 1) {
					for (final Player on : Bukkit.getOnlinePlayers()) {
						if(TourneyMain.maps.containsKey(on.getName())) {
							if (TourneyMain.maps.get(on.getName()) == TourneyMain.runningmap) {
								Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix") + "§6" + on.getName() + " §7has won the tournament!"));
								on.sendMessage("§aCongratulations! You have won the tournament!");
								TourneyMain.spawnFirework(p);
								TourneyMain.runningmap = null;
								TourneyMain.players = 0;
								EventsHandler.running = false;
								EventsHandler.runningevent = "";
								TourneyMain.maps.clear();
								settings.getData().set(
										"stats." + on.getUniqueId() + ".wins",
										settings.getData().getInt(
												"stats." + on.getUniqueId() + ".wins") + 1);
								CoinsUtil.setCoins(on, CoinsUtil.getCoins(on) + (on.hasPermission("experiencepvp.rank.gold") ? 150 : 100));
								EventsHandler.startCooldownTimer("tourney");
								ScoreboardMain.updateScoreboard(on);
								TourneyMain.testHead();
								TourneyMain.invincible.clear();
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
