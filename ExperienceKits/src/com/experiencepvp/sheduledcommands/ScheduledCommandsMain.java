package com.experiencepvp.sheduledcommands;

import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;

public class ScheduledCommandsMain {
	
	public static SettingsManager settings = SettingsManager.getInstance();

	public static void startTimer(){
		new BukkitRunnable(){
			public void run(){
				if(settings.getData().contains("smcds")){
					for(String s : settings.getData().getConfigurationSection("scmds").getKeys(true)){
						int current = settings.getData().getInt("scmds." + s);
						if((current - 1) <= 0){
							String cmd = s.replace("£", " ");
							Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd);
							settings.getData().set("scmds." + s, null);
							settings.saveData();
						}else{
							settings.getData().set("scmds." + s, current - 1); 						
						}
					}
				}
				
			}
		}.runTaskTimer(Main.getPlugin(), 1200, 1200);
	}
	
	public static void addCommand(String command, int minutes){
		String configcmd = command.replace(" ", "£");
		settings.getData().set("scmds." + configcmd, minutes);
	}
	
}
