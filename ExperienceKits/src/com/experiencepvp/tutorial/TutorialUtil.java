package com.experiencepvp.tutorial;

import java.util.UUID;

import org.bukkit.entity.Player;

import com.experiencepvp.kits.SettingsManager;

public class TutorialUtil {
	
	static SettingsManager settings = SettingsManager.getInstance();
	
	public static boolean hasFollowedTutorial(UUID id){
		if(!settings.getData().contains("tutorial." + id)){
			return false;
		}
		return settings.getData().getBoolean("tutorial." + id);
	}
	
	public static void setFollowedTutorial(UUID id, boolean hasFollowed){
		settings.getData().set("tutorial." + id, hasFollowed);
	}
	
	public static boolean isOn(Player p){
		if(p == null) return false;
		return true;
	}

}
