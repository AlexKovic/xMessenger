package com.experiencepvp.coins;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.experiencepvp.kits.SettingsManager;

public class CoinsUtil {

	public static SettingsManager settings = SettingsManager.getInstance();
	
	public static int getCoins(Player p){
		if(!settings.getData().contains("coins." + p.getUniqueId())) return 0;
		return settings.getData().getInt("coins." + p.getUniqueId());
	}
	
	public static int getCoins(UUID id){
		if(!settings.getData().contains("coins." + id)) return 0;
		return settings.getData().getInt("coins." + id);
	}

	public static void setCoins(Player p, int amount){
		settings.getData().set("coins." + p.getUniqueId(), amount);
		settings.saveData();
	}

	public static void setCoins(UUID id, int amount) {
		Player p = Bukkit.getPlayer(id);
		setCoins(p, amount);
	}
	
	public static boolean hasStats(UUID id){
		if(!settings.getData().contains("coins." + id)) return false;
		return true;
	}
}
