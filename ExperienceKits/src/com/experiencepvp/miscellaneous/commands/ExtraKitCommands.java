package com.experiencepvp.miscellaneous.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.listeners.PlayerListener;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;

public class ExtraKitCommands implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You may not run this cmd!");
		}

		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("ckit")) {
			if(args.length == 0){
				if(p.hasPermission("experiencepvp.clearkit")){
					p.getInventory().clear();
					p.getInventory().setArmorContents(null);
					KitHandler.delKit(p);
					PlayerListener.setUpSpawnItems(p);
					p.sendMessage(Main.pref + ChatColor.BLUE + "Your kit has been cleared!");
				}else{
					p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission to clear your kit!");
				}
			}else if(args.length == 1){
				if(p.hasPermission("experiencepvp.clearkitother")){
					Player on = Bukkit.getServer().getPlayer(args[0]);
					if(on == null){
						p.sendMessage(Main.pref + ChatColor.GOLD + args[0] + ChatColor.BLUE + " is not online!");
						return false;
					}
					on.getInventory().clear();
					on.getInventory().setArmorContents(null);
					KitHandler.delKit(on);
					PlayerListener.setUpSpawnItems(p);
					p.sendMessage(Main.pref + ChatColor.GOLD + on.getName() + "'s" + ChatColor.BLUE + " kit has been cleared!");
					on.sendMessage(Main.pref + ChatColor.BLUE + "Your kit has been cleared!");
				}else{
					p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission to clear someone else's kit!");
				}
			}else{
				p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: Use " + ChatColor.GOLD + "/ckit" + ChatColor.RED + " or " + ChatColor.GOLD + "/ckit [Player]" + ChatColor.RED + "!");
			}
		}else if(cmd.getName().equalsIgnoreCase("skit")) {
			if(args.length == 0){
				if(p.hasPermission("experiencepvp.seekit")){
					KitType kt = KitHandler.getKit(p.getName());
					if(kt == null){
						p.sendMessage(Main.pref + ChatColor.BLUE + "You are currently playing with the " + ChatColor.GOLD + "None" + ChatColor.BLUE + " kit!");
						return false;
					}
					String name = kt.getName();
					p.sendMessage(Main.pref + ChatColor.BLUE + "You are currently playing with the " + ChatColor.GOLD + name + ChatColor.BLUE + " kit!");
				}else{
					p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission to see your kit!");
				}
			}else if(args.length == 1){
				if(p.hasPermission("experiencepvp.seekitother")){
					Player on = Bukkit.getServer().getPlayer(args[0]);
					if(on == null){
						p.sendMessage(Main.pref + ChatColor.GOLD + args[0] + ChatColor.BLUE + " is not online!");
						return false;
					}
					

					KitType kt = KitHandler.getKit(on.getName());
					if(kt == null){
						p.sendMessage(Main.pref + ChatColor.BLUE + on.getName() + " is currently playing with the " + ChatColor.GOLD + "None" + ChatColor.BLUE + " kit!");
						return false;
					}
					
					String name = kt.getName();
					p.sendMessage(Main.pref + ChatColor.GOLD + on.getName() + ChatColor.BLUE + " is currently playing with the " + ChatColor.GOLD + name + ChatColor.BLUE + " kit!");
				}else{
					p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission to see someone else's kit!");
				}
			}else{
				p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: Use " + ChatColor.GOLD + "/skit" + ChatColor.RED + " or " + ChatColor.GOLD + "/skit [Player]" + ChatColor.RED + "!");
			}
		}
		return true;
	}

}
