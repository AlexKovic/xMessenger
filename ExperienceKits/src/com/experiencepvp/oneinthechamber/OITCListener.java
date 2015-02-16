package com.experiencepvp.oneinthechamber;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.coins.CoinsUtil;
import com.experiencepvp.events.EventsHandler;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.Spawn;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitUtil;
import com.experiencepvp.scoreboard.ScoreboardMain;

public class OITCListener implements Listener {

	public static SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (OITCMain.invincible.contains(p.getName())) {
				e.setCancelled(true);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onShootInOITC(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Arrow && e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(((Arrow) e.getDamager()).getShooter() instanceof Player){
				Player d = (Player) ((Arrow) e.getDamager()).getShooter();
				if(OITCMain.maps.containsKey(p.getName()) && OITCMain.maps.containsKey(d.getName()) && EventsHandler.running && !OITCMain.open && !OITCMain.invincible.contains(p.getName()) && !OITCMain.invincible.contains(d.getName())){
					e.setDamage(100);
				}
			}
		}
	}
	
	@EventHandler
	public void onCommandInTourney(PlayerCommandPreprocessEvent e){
			if(OITCMain.maps.containsKey(e.getPlayer().getName())){
				if(EventsHandler.running == true){
					if(OITCMain.open == false){
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
		
		if(OITCMain.inqueue.containsKey(p.getName())){
			OITCMain.inqueue.remove(p.getName());
			return;
		}
		
		if(OITCMain.invincible.contains(p.getName())){
			OITCMain.invincible.remove(p.getName());
		}
		
		if(OITCMain.maps.containsKey(p.getName())){
			OITCMain.maps.remove(p.getName());
			OITCMain.players = OITCMain.players - 1;
			OITCMain.invincible.remove(p.getName());
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§6" + p.getName() + "§7 has left the tourney! §7(" + OITCMain.players + "/20)");
			if (OITCMain.players == 1 || OITCMain.playersIn() == 1) {
				for (final Player on : Bukkit.getOnlinePlayers()) {
					if(OITCMain.maps.containsKey(on.getName())) {
						if (OITCMain.maps.get(on.getName()) == OITCMain.runningmap) {
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix") + "§6" + on.getName() + " §7has won the tournament!"));
							on.sendMessage("§aCongratulations! You have won the tournament!");
							OITCMain.spawnFirework(on);
							OITCMain.runningmap = null;
							OITCMain.players = 0;
							EventsHandler.running = false;
							EventsHandler.runningevent = "";
							OITCMain.maps.clear();
							EventsHandler.startCooldownTimer("oitc");
							settings.getData().set(
									"stats." + on.getUniqueId() + ".wins",
									settings.getData().getInt(
											"stats." + on.getUniqueId() + ".wins") + 1);
							CoinsUtil.setCoins(on, CoinsUtil.getCoins(on) + (on.hasPermission("experiencepvp.rank.gold") ? 150 : 100));
							OITCMain.invincible.clear();
							ScoreboardMain.updateScoreboard(on);
							OITCMain.testHead();
							new BukkitRunnable() {
								public void run() {
									on.teleport(Spawn.getSpawnLoc());
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
		
		if(OITCMain.inqueue.containsKey(p.getName())){
			return;
		}
		
		if (p.getKiller() != null) {
			if(p.getKiller() instanceof Player){
			final Player k = (Player) p.getKiller();
			if (OITCMain.maps.containsKey(p.getName())) {
				OITCMain.maps.remove(p.getName());
				OITCMain.players = OITCMain.players - 1;
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§6" + p.getName() + "§7 has been knocked out of the tournament by §6"
						+ k.getName() + " §7(" + OITCMain.players + "/20)");
				if (OITCMain.players == 1 || OITCMain.playersIn() == 1) {
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix") + "§6" + k.getName() + " §7has won the tournament!"));
					k.sendMessage("§aCongratulations! You have won the tournament!");
					OITCMain.spawnFirework(p);
					OITCMain.runningmap = null;
					OITCMain.players = 0;
					EventsHandler.running = false;
					EventsHandler.runningevent = "";
					OITCMain.maps.clear();
					settings.getData().set(
							"stats." + k.getUniqueId() + ".wins",
							settings.getData().getInt(
									"stats." + k.getUniqueId() + ".wins") + 1);
					CoinsUtil.setCoins(k, CoinsUtil.getCoins(k) + (k.hasPermission("experiencepvp.rank.gold") ? 150 : 100));
					EventsHandler.startCooldownTimer("oitc");
					ScoreboardMain.updateScoreboard(k);
					OITCMain.testHead();
					OITCMain.invincible.clear();
					new BukkitRunnable() {
						public void run() {
							k.teleport(Spawn.getSpawnLoc());
						}
					}.runTaskLater(Main.getPlugin(), 140L);
				}
			}
			}
		} else {
			if (OITCMain.maps.containsKey(p.getName())) {
				OITCMain.maps.remove(p.getName());
				OITCMain.players = OITCMain.players - 1;
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§6" + p.getName() + "§7 has died §7(" + OITCMain.players + "/20)");
				if (OITCMain.players == 1 || OITCMain.playersIn() == 1) {
					for (final Player on : Bukkit.getOnlinePlayers()) {
						if(OITCMain.maps.containsKey(on.getName())) {
							if (OITCMain.maps.get(on.getName()) == OITCMain.runningmap) {
								Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix") + "§6" + on.getName() + " §7has won the tournament!"));
								on.sendMessage("§aCongratulations! You have won the tournament!");
								OITCMain.spawnFirework(p);
								OITCMain.runningmap = null;
								OITCMain.players = 0;
								EventsHandler.running = false;
								EventsHandler.runningevent = "";
								OITCMain.maps.clear();
								settings.getData().set(
										"stats." + on.getUniqueId() + ".wins",
										settings.getData().getInt(
												"stats." + on.getUniqueId() + ".wins") + 1);
								CoinsUtil.setCoins(on, CoinsUtil.getCoins(on) + (on.hasPermission("experiencepvp.rank.gold") ? 150 : 100));
								EventsHandler.startCooldownTimer("oitc");
								ScoreboardMain.updateScoreboard(on);
								OITCMain.testHead();
								OITCMain.invincible.clear();
								new BukkitRunnable() {
									public void run() {
										on.teleport(Spawn.getSpawnLoc());
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