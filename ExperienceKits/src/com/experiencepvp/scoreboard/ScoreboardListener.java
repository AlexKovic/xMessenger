package com.experiencepvp.scoreboard;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.experiencepvp.preferences.PreferencesUtil;

public class ScoreboardListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (PreferencesUtil.wantsScoreboard(p)) {
			ScoreboardMain.setScoreboard(p);
		} else {
			return;
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		ScoreboardMain.removeScoreboard(p);
	}

}
