package com.experiencepvp.miscellaneous.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class AdminCommand implements Listener, CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("admin")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You are not a player!");
			}
			
			
			 
		}
		return false;
	}

}
