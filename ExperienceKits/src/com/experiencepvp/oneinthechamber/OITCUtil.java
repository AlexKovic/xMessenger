package com.experiencepvp.oneinthechamber;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;

public class OITCUtil {

	public static SettingsManager settings = SettingsManager.getInstance();
	
	public static Location getLocation(int id) {
		if(id == 1){
			return new Location(Bukkit.getServer().getWorld("experiencepvp"), -5067, 4, -5558);
		}else if(id == 2){
			return new Location(Bukkit.getServer().getWorld("experiencepvp"), 1323, 7, 9515);
		}
		
		
		if((!settings.getTourneys().contains("tourneys." + id + ".location.world")) && (!settings.getTourneys().contains("tourneys." + id + ".location.x"))
				&& (!settings.getTourneys().contains("tourneys." + id + ".location.y")) && (!settings.getTourneys().contains("tourneys." + id + ".location.x"))){
			return new Location(Bukkit.getServer().getWorld("experiencepvp"), -5240, 4, -5631);
		}
		World w = Bukkit.getWorld(settings.getTourneys().getString("tourneys." + id + ".location.world"));
		double x = settings.getTourneys().getDouble("tourneys." + id + ".location.x");
		double y = settings.getTourneys().getDouble("tourneys." + id + ".location.y");
		double z = settings.getTourneys().getDouble("tourneys." + id + ".location.z");
		Location loc = new Location(w, x, y, z);
		return loc;
	}
	
	public static int getMaxPlayers(int id){
		if(!settings.getTourneys().contains("tourneys." + id + ".maxplayers")){
			return 25;
		}
		
		int max = settings.getTourneys().getInt("tourneys." + id + ".maxplayers");
		return max;
	}
	
	public static void setMaxPlayers(int id, int max) {
		settings.getTourneys().set("tourneys." + id + ".maxplayers", max);
		settings.saveTourneys();
	}
	
	public static void setLocation(int id, Location loc) {
		settings.getTourneys().set("tourneys." + id + ".location.world", loc.getWorld().getName());
		settings.getTourneys().set("tourneys." + id + ".location.x", loc.getX());
		settings.getTourneys().set("tourneys." + id + ".location.y", loc.getY());
		settings.getTourneys().set("tourneys." + id + ".location.z", loc.getZ());
		settings.saveTourneys();
	}
	
	public static void startTimer(final OITCMap map) {
		Bukkit.broadcastMessage(Main.pref + "§7A §9One In The Chamber §7event is being hosted on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (30 seconds left!)");
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(Main.pref + "§7A §9One In The Chamber §7event is being hosted on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (20 seconds left!)");
			}
		}.runTaskLater(Main.getPlugin(), 200);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(Main.pref + "§7A §9One In The Chamber §7event is being hosted on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (10 seconds left!)");
			}
		}.runTaskLater(Main.getPlugin(), 400);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(Main.pref + "§7A §9One In The Chamber §7event is being hosted on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (5 seconds left!)");
			}
		}.runTaskLater(Main.getPlugin(), 580);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(Main.pref + " §6One In The Chamber event started! Good luck!");
			}
		}.runTaskLater(Main.getPlugin(), 600);
	}
}
