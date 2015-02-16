package com.experiencepvp.kits;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.kits.listeners.PlayerListener;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.oneversusone.OneVOneListener;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Spawn implements Listener, CommandExecutor {

	static SettingsManager settings = SettingsManager.getInstance();

	HashMap<String, Location> teleport = new HashMap<String, Location>();

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (sender instanceof Player) {
			final Player p = (Player) sender;
			if (label.equalsIgnoreCase("setspawn")) {
				if (p.isOp()) {
					Location ploc = p.getLocation();
					settings.getConfig().set("spawn.world",
							p.getWorld().getName());
					settings.getConfig().set("spawn.x", ploc.getX());
					settings.getConfig().set("spawn.y", ploc.getY());
					settings.getConfig().set("spawn.z", ploc.getZ());
					settings.getConfig().set("spawn.yaw", ploc.getYaw());
					settings.getConfig().set("spawn.pitch", ploc.getPitch());
					settings.saveConfig();
					p.getWorld().setSpawnLocation(
							settings.getConfig().getInt("spawn.x"),
							settings.getConfig().getInt("spawn.y"),
							settings.getConfig().getInt("spawn.z"));
					p.sendMessage(ChatColor.GREEN
							+ "The spawn has been successfully set at your location!");
				} else {
					String string = settings.getConfig().getString(
							"messages.prefix");
					p.sendMessage(string.replaceAll("&", "§"));
				}
			}
			if (label.equalsIgnoreCase("spawn")) {
				if (sender instanceof Player) {
					if (settings.getConfig().getConfigurationSection("spawn") == null) {
						p.sendMessage(ChatColor.BLUE + "ExperiencePvP> "
								+ ChatColor.WHITE
								+ "No spawn has been set yet!");
						return true;
					}
					
					if(OneVOneListener.lobby1v1.contains(p.getName())){
						p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't use this command while in the 1v1 lobby. Use " + ChatColor.GOLD + "/1v1" + ChatColor.RED + " to leave the 1v1 lobby!");
						return false;
					}
					
					if(OneVOneListener.fighting.contains(p.getName())){
						p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't use this command while in a 1v1. Kill your opponent or log out to use this command!");
						return false;
					}

//					final World w = Bukkit.getWorld(settings.getConfig()
//							.getString("spawn.world"));
//					final double x = settings.getConfig().getDouble("spawn.x");
//					final double y = settings.getConfig().getDouble("spawn.y");
//					final double z = settings.getConfig().getDouble("spawn.z");
//					final float yaw = settings.getConfig().getInt("spawn.yaw");
//					final float pitch = settings.getConfig().getInt(
//							"spawn.pitch");
//					final Location spawn = new Location(w, x, y, z, yaw, pitch);
//					
					if(p.isOp()){
						p.teleport(getSpawnLoc());
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "Teleported!");
						return true;
					}
					
					teleport.put(p.getName(), p.getLocation());
					String message = settings.getConfig().getString(
							"messages.prefix");
					p.sendMessage(message.replaceAll("&", "§")
							+ "You will be teleported in 3 seconds, dont move!");
					new BukkitRunnable() {
						public void run() {
							if (teleport.containsKey(p.getName())) {
								p.teleport(getSpawnLoc());
								KitHandler.delKit(p);
								p.getInventory().clear();
								PlayerListener.setUpSpawnItems(p);
								p.setAllowFlight(false);
								p.setFlying(false);
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix")) + "Teleported!");
								teleport.remove(p.getName());
							}
						}
					}.runTaskLater(Main.getPlugin(), 60);
				}
			}
			return true;
		}
		return true;
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (teleport.containsKey(p.getName())) {
			if (e.getFrom().getBlockX() != teleport.get(p.getName()).getBlockX() || e.getFrom().getBlockZ() != teleport.get(p.getName()).getBlockZ()) {
				teleport.remove(p.getName());
				p.sendMessage(Main.pref + "Teleportation cancelled!");
			}
		}
	}
	
	public static Location getSpawnLoc(){
		Location loc = new Location(Bukkit.getWorld("experiencepvp"), 9892.5, 22, 9692.5);
		return loc;
		
//		World w = Bukkit.getWorld(settings.getConfig().getString("spawn.world"));
//		double x = settings.getConfig().getDouble("spawn.x");
//		double y = settings.getConfig().getDouble("spawn.y");
//		double z = settings.getConfig().getDouble("spawn.z");
//		float yaw = settings.getConfig().getInt("spawn.yaw");
//		float pitch = settings.getConfig().getInt("spawn.pitch");
//		return new Location(w, x, y, z, yaw, pitch);
	}
}
