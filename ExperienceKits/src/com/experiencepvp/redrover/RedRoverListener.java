package com.experiencepvp.redrover;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.experiencepvp.coins.CoinsUtil;
import com.experiencepvp.combo.ComboMain;
import com.experiencepvp.events.EventsHandler;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.Spawn;
import com.experiencepvp.scoreboard.ScoreboardMain;

public class RedRoverListener {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void onInteractEntity(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		if (RedRoverMain.taggers.contains(p.getName())) {
			if (e.getRightClicked() instanceof Player) {
				Player r = (Player) e.getRightClicked();
				if (RedRoverMain.runners.contains(r.getName())) {
					RedRoverMain.runners.remove(r.getName());
					RedRoverMain.taggers.add(r.getName());
					
					RedRoverMain.setupTagger(r);
					
					r.teleport(RedRoverMain.runningmap.getTagLocation());
					r.sendMessage(Main.pref + "You have been hit by §l" + p.getName());
					Bukkit.broadcastMessage(Main.pref + r.getName() + " has been hit by " + p.getName() + "! §7(" + RedRoverMain.runners.size() + "/" + RedRoverMain.runningmap.getMaxPlayers() + ")");
					if (RedRoverMain.runners.size() == 1) {
						Player w = Bukkit.getPlayer(RedRoverMain.runners.get(RedRoverMain.runners.size()));
						if (w != null) {
							Bukkit.broadcastMessage(Main.pref + "§l" + w.getName() + " §f§9has won the Red Rover Game!");
							for (String s : RedRoverMain.maps.keySet()) {
								Player on = Bukkit.getPlayer(s);
								on.teleport(Spawn.getSpawnLoc());
							}
							
							ComboMain.spawnFirework(w);
							RedRoverMain.runningmap = null;
							RedRoverMain.players = 0;
							EventsHandler.running = false;
							EventsHandler.runningevent = "";
							RedRoverMain.maps.clear();
							RedRoverMain.taggers.clear();
							RedRoverMain.runners.clear();
							EventsHandler.startCooldownTimer("rr");
							
							
							settings.getData().set(
									"stats." + w.getUniqueId() + ".wins",
									settings.getData().getInt(
											"stats." + w.getUniqueId() + ".wins") + 1);
							CoinsUtil.setCoins(w, CoinsUtil.getCoins(w) + (w.hasPermission("experiencepvp.rank.gold") ? 150 : 100));
							w.sendMessage("§aCongratulations, you have won the game and recieved a " + (w.hasPermission("experiencepvp.rank.gold") ? "150" : "100") + " coins!");
							ScoreboardMain.updateScoreboard(w);
							settings.saveData();
						}
					}
				}
			}
		}
	}
}
