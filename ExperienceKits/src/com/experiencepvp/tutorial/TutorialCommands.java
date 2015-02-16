package com.experiencepvp.tutorial;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.experiencepvp.kits.Main;

public class TutorialCommands implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You may not run this cmd!");
		}

		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("tutorial")) {
			if(!p.hasPermission("experiencepvp.tutorial")){
				p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission!");
				return false;
			}
			if(args.length == 0){
				p.openInventory(TutorialInventory.getConfirmInv(p));
			}else{
				p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /tutorial");				
			}
			
		}
		return false;
	}
	
}
