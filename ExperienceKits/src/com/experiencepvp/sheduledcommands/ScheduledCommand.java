package com.experiencepvp.sheduledcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.tournaments.TourneyMain;

public class ScheduledCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You may not run this cmd!");
			return false;
		}

		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("scheduledtest")) {
			if (p.hasPermission("scheduledtest")) {
				if(args.length != 1){
					p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /scheduledtest [Minutes]");
				}else{
					if(TourneyMain.isInt(args[0])){
						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "msg " + p.getName() + " This is the start of the ScheduledCommand Test!");
						ScheduledCommandsMain.addCommand("msg " + p.getName() + " This is the end ScheduledCommand Test!", Integer.parseInt(args[0]));
					}else{
						p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /scheduledtest [Minutes]");						
					}
				}
			}
		}

		return true;
	}

	
	
}
