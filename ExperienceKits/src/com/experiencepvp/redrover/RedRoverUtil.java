package com.experiencepvp.redrover;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.combo.ComboMap;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;

public class RedRoverUtil {

	static SettingsManager settings = SettingsManager.getInstance();
	
	public static Location getStartLocation(int id) {
		if (settings.getTourneys().getConfigurationSection("redrover." + id + ".location.start") != null) {
			World w = Bukkit.getWorld(settings.getTourneys().getString("redrover." + id + ".location.start.world"));
			double x = settings.getTourneys().getDouble("redrover." + id + ".location.start.x");
			double y = settings.getTourneys().getDouble("redrover." + id + ".location.start.y");
			double z = settings.getTourneys().getDouble("redrover." + id + ".location.start.z");
			float yaw = (float) settings.getTourneys().getDouble("redrover." + id + ".location.start.yaw");
			float pitch = (float) settings.getTourneys().getDouble("redrover." + id + ".location.start.pitch");
			Location loc = new Location(w, x, y, z, yaw, pitch);
			return loc;
		}
		return null;
	}
	
	public static Location getEndLocation(int id) {
		if (settings.getTourneys().getConfigurationSection("redrover." + id + ".location.end") != null) {
			World w = Bukkit.getWorld(settings.getTourneys().getString("redrover." + id + ".location.end.world"));
			double x = settings.getTourneys().getDouble("redrover." + id + ".location.end.x");
			double y = settings.getTourneys().getDouble("redrover." + id + ".location.end.y");
			double z = settings.getTourneys().getDouble("redrover." + id + ".location.end.z");
			float yaw = (float) settings.getTourneys().getDouble("redrover." + id + ".location.end.yaw");
			float pitch = (float) settings.getTourneys().getDouble("redrover." + id + ".location.end.pitch");
			Location loc = new Location(w, x, y, z, yaw, pitch);
			return loc;
		}
		return null;
	}
	public static Location getTagLocation(int id) {
		if (settings.getTourneys().getConfigurationSection("redrover." + id + ".location.tag") != null) {
			World w = Bukkit.getWorld(settings.getTourneys().getString("redrover." + id + ".location.tag.world"));
			double x = settings.getTourneys().getDouble("redrover." + id + ".location.tag.x");
			double y = settings.getTourneys().getDouble("redrover." + id + ".location.tag.y");
			double z = settings.getTourneys().getDouble("redrover." + id + ".location.tag.z");
			float yaw = (float) settings.getTourneys().getDouble("redrover." + id + ".location.tag.yaw");
			float pitch = (float) settings.getTourneys().getDouble("redrover." + id + ".location.tag.pitch");
			Location loc = new Location(w, x, y, z, yaw, pitch);
			return loc;
		}
		return null;
	}
	
	public static int getMaxPlayers(int id) {
		if (settings.getTourneys().getConfigurationSection("redrover." + id + ".maxplayers") != null) {
			return settings.getTourneys().getInt("redrover." + id + ".maxplayers");
		}
		return 20;
	}
	
	public static void setStartLocation(int id, Location loc) {
		settings.getTourneys().set("redrover." + id + ".location.start.world", loc.getWorld().getName());
		settings.getTourneys().set("redrover." + id + ".location.start.x", loc.getX());
		settings.getTourneys().set("redrover." + id + ".location.start.y", loc.getY());
		settings.getTourneys().set("redrover." + id + ".location.start.z", loc.getZ());
		settings.getTourneys().set("redrover." + id + ".location.start.yaw", loc.getYaw());
		settings.getTourneys().set("redrover." + id + ".location.start.pitch", loc.getPitch());
	}
	
	public static void setEndLocation(int id, Location loc) {
		settings.getTourneys().set("redrover." + id + ".location.end.world", loc.getWorld().getName());
		settings.getTourneys().set("redrover." + id + ".location.end.x", loc.getX());
		settings.getTourneys().set("redrover." + id + ".location.end.y", loc.getY());
		settings.getTourneys().set("redrover." + id + ".location.end.z", loc.getZ());
		settings.getTourneys().set("redrover." + id + ".location.end.yaw", loc.getYaw());
		settings.getTourneys().set("redrover." + id + ".location.end.pitch", loc.getPitch());
	}
	
	public static void setTagLocation(int id, Location loc) {
		settings.getTourneys().set("redrover." + id + ".location.tag.world", loc.getWorld().getName());
		settings.getTourneys().set("redrover." + id + ".location.tag.x", loc.getX());
		settings.getTourneys().set("redrover." + id + ".location.tag.y", loc.getY());
		settings.getTourneys().set("redrover." + id + ".location.tag.z", loc.getZ());
		settings.getTourneys().set("redrover." + id + ".location.tag.yaw", loc.getYaw());
		settings.getTourneys().set("redrover." + id + ".location.tag.pitch", loc.getPitch());
	}
	
	public static void setMaxPlayers(int id, int max) {
		settings.getTourneys().set("redrover." + id + ".maxplayers", max);
	}
	
	public static void startTimer(final Player p, final RedRoverMap map) {
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§9 " +p.getName() + "§7 is hosting a §9Red Rover Game§7 on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (30 seconds left!)");
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§9 " +p.getName() + "§7 is hosting a §9Red Rover Game§7 on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (20 seconds left!)");
			}
		}.runTaskLater(Main.getPlugin(), 200);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§9 " +p.getName() + "§7 is hosting a §9Red Rover Game§7 on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (15 seconds left!)");
			}
		}.runTaskLater(Main.getPlugin(), 300);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§9 " +p.getName() + "§7 is hosting a §9Red Rover Game§7 on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (10 seconds left!)");
			}
		}.runTaskLater(Main.getPlugin(), 400);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§9 " +p.getName() + "§7 is hosting a §9Red Rover Game§7 on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (5 seconds left!)");
			}
		}.runTaskLater(Main.getPlugin(), 500);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§9 " +p.getName() + "§7 is hosting a §9Red Rover Game§7 on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (4 seconds left!)");
			}
		}.runTaskLater(Main.getPlugin(), 520);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§9 " + p.getName() + "§7 is hosting a §9Red Rover Game§7 on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (3 seconds left!)");
			}
		}.runTaskLater(Main.getPlugin(), 540);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix") + "§9 " +p.getName() + "§7 is hosting a §9Red Rover Game§7 on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event! (2 seconds left!)"));
			}
		}.runTaskLater(Main.getPlugin(), 560);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "§9 " +p.getName() + "§7 is hosting a §9Red Rover Game§7 on §o§9" + map.getName() + "§7. Type: §9/join§7 to join the event (1 seconds left!)");
			}
		}.runTaskLater(Main.getPlugin(), 580);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + " §6Let the games begin!");
			}
		}.runTaskLater(Main.getPlugin(), 600);
	}
}