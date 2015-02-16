package com.experiencepvp.scoreboard;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.listeners.PlayerListener;

public class ScoreboardMain implements Listener {
	
	static ScoreboardManager manager = Bukkit.getScoreboardManager();
	static SettingsManager settings = SettingsManager.getInstance();
	static HashMap<String, Boolean> has = new HashMap<String, Boolean>();
	
	
	public static void setScoreboard(Player p){
		int deaths = settings.getData().getInt(
				"stats." + p.getUniqueId() + ".deaths");
		int kills = settings.getData().getInt(
				"stats." + p.getUniqueId() + ".kills");
		int win = settings.getData().getInt(
				"stats." + p.getUniqueId() + ".wins");
		int money = settings.getData().getInt(
				"coins." + p.getUniqueId());
		
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("stats", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		objective.setDisplayName("§o§b" + p.getName());
		
		Score killss = objective.getScore("§9Kills");
		killss.setScore(kills);
		
		Score death = objective.getScore("§9Deaths");
		death.setScore(deaths);
		
		Score wins = objective.getScore("§9Tourney Wins");
		wins.setScore(win);
		
		Score bal = objective.getScore("§9Coins");
		bal.setScore(money);
		
		has.put(p.getName(), true);
		p.setScoreboard(board);
	}
	
	public static void removeScoreboard(Player p){ 
		p.setScoreboard(manager.getNewScoreboard());
		has.put(p.getName(), false);
	}
	
	public static void updateScoreboard(Player p) {
		removeScoreboard(p);
		setScoreboard(p);
	}
}
