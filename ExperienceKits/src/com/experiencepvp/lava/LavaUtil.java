package com.experiencepvp.lava;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.oneinthechamber.OITCMap;

public class LavaUtil {

public static SettingsManager settings = SettingsManager.getInstance();
	
	public static Location getLocation(int id) {
		if(id == 1){
			return new Location(Bukkit.getWorld("experiencepvp"), -9977, 2, -158);
		}else if(id == 2){
			return new Location(Bukkit.getWorld("experiencepvp"), 3482, 5, 435155);			
		}else if(id == 3){
			return new Location(Bukkit.getWorld("experiencepvp"), 3688, 2, 435058);			
		}else if(id == 4){
			return new Location(Bukkit.getWorld("experiencepvp"), 3678, 6, 435130);
		}else if(id == 5){
			return new Location(Bukkit.getWorld("experiencepvp"), 3549, 3, 435111);			
		}
		return new Location(Bukkit.getServer().getWorld("experiencepvp"), -5240, 4, -5631);
		
//		if((!settings.getData().contains("lava." + id + ".location.world")) && (!settings.getData().contains("lava." + id + ".location.x"))
//				&& (!settings.getData().contains("lava." + id + ".location.y")) && (!settings.getData().contains("lava." + id + ".location.x"))){
//			return new Location(Bukkit.getServer().getWorld("experiencepvp"), -5240, 4, -5631);
//		}
//		World w = Bukkit.getWorld(settings.getData().getString("lava" + id + ".location.world"));
//		double x = settings.getData().getDouble("lava." + id + ".location.x");
//		double y = settings.getData().getDouble("lava." + id + ".location.y");
//		double z = settings.getData().getDouble("lava." + id + ".location.z");
//		Location loc = new Location(w, x, y, z);
//		return loc;
	}
	
	public static int getMaxPlayers(int id){
		if(!settings.getData().contains("lava." + id + ".maxplayers")){
			return 25;
		}
		
		int max = settings.getData().getInt("lava." + id + ".maxplayers");
		return max;
	}
	
	public static void setMaxPlayers(int id, int max) {
		settings.getData().set("lava." + id + ".maxplayers", max);
		settings.saveTourneys();
	}
	
	public static void setLocation(int id, Location loc) {
		settings.getData().set("lava." + id + ".location.world", loc.getWorld().getName());
		settings.getData().set("lava." + id + ".location.x", loc.getX());
		settings.getData().set("lava." + id + ".location.y", loc.getY());
		settings.getData().set("lava." + id + ".location.z", loc.getZ());
		settings.saveTourneys();
	}
	
	public static void startTimer(final LavaMap map) {
		Bukkit.broadcastMessage(Main.pref + "§7A §9Lava Challenge §7event is being hosted on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (30 seconds left!)");
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(Main.pref + "§7A §9Lava Challenge §7event is being hosted on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (20 seconds left!)");
			}
		}.runTaskLater(Main.getPlugin(), 200);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(Main.pref + "§7A §9Lava Challenge §7event is being hosted on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (10 seconds left!)");
			}
		}.runTaskLater(Main.getPlugin(), 400);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(Main.pref + "§7A §9Lava Challenge §7event is being hosted on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (5 seconds left!)");
			}
		}.runTaskLater(Main.getPlugin(), 580);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(Main.pref + " §6Lava Challenge event started! Good luck!");
			}
		}.runTaskLater(Main.getPlugin(), 600);
	}
	
}
