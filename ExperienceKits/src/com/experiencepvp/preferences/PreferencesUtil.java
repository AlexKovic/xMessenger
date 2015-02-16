package com.experiencepvp.preferences;

import org.bukkit.entity.Player;

import com.experiencepvp.kits.SettingsManager;

public class PreferencesUtil {

	public static SettingsManager settings = SettingsManager.getInstance();
	
	public static boolean wantsScoreboard(Player p) {
		return (settings.getData().getBoolean("preferences." + p.getUniqueId() + ".scoreboard"));
	}
	
	public static int getKitItemSlot(Player p) {
		return (settings.getData().getInt("preferences." + p.getUniqueId() + ".kititem"));
	}
	
	public static int getSwordSlot(Player p) {
		return (settings.getData().getInt("preferences." + p.getUniqueId() + ".sword"));
	}
	
	public static void setScoreboard(Player p) {
		settings.getData().set("preferences." + p.getUniqueId() + ".scoreboard", !settings.getData().getBoolean("preferences." + p.getUniqueId() + ".scoreboard"));
		settings.saveData();
	}
	
	public static void setKitItemSlot(Player p, int slot) {
		settings.getData().set("preferences." + p.getUniqueId() + ".kititem", slot);
		settings.saveData();
	}
	
	public static void setSwordSlot(Player p, int slot) {
		settings.getData().set("preferences." + p.getUniqueId() + ".sword", slot);
	}


}
