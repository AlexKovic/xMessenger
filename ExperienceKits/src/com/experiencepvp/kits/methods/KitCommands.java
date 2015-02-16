package com.experiencepvp.kits.methods;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.experiencepvp.kits.utils.KitType;

public class KitCommands implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You may not use this command!");
		}
		
		Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("settings")) {
			if (p.isOp()) {
				p.sendMessage(ChatColor.AQUA + "Use /settings help for more info!");
				if (args[0].equalsIgnoreCase("freekit")) {
					String prefix = "&7[&9ExperiencePvP&7] &7".replaceAll("&", "§");
					if (args.length < 3 || args.length > 3)
						if (args.length == 2) {
							if (args[1].equalsIgnoreCase("clear")) {
								try {
									p.sendMessage(prefix + "Clared all free kits.");
									KitMethods.clearFreeKits();
								} catch (Exception e) {
									p.sendMessage(prefix + "Kit not recognised!");
								}
							} else {
								p.sendMessage(prefix + "Usage: /" + label + " freekit <add/remove/clear> <kit>");
							}
						} else {
							p.sendMessage(prefix + "Usage: /" + label + " freekit <add/remove/clear> <kit>");
						}
					else if (args.length == 3)
						if (args[1].equalsIgnoreCase("add")) {
							try {
								KitMethods.addFreeKit(KitType.valueOf(args[2].toUpperCase()));
								p.sendMessage(prefix + "Added " + args[2].toUpperCase() + " to the free kits.");
							} catch (Exception e) {
								p.sendMessage(prefix + "Kit not recognised!");
							}
						} else if (args[1].equalsIgnoreCase("remove")) {
							try {
								KitMethods.removeFreeKit(KitType.valueOf(args[2].toUpperCase()));
								p.sendMessage(prefix + "Removed " + args[2].toUpperCase() + " from the free kits.");
							} catch (Exception e) {
								p.sendMessage(prefix + "Kit not recognised!");
							}
						}
					}	
				return true;
				} else {
					p.sendMessage(ChatColor.RED + "You don't have the permissions to do this!");
					return true;
				}
			}
		return true;
		}
	}
