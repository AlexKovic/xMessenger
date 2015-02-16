package com.experiencepvp.miscellaneous.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.experiencepvp.kits.SettingsManager;

public class ApplyCommand implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You may not run this cmd!");
		}

		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("apply")) {
			if (settings.getConfig().getBoolean("apply.active") == true) {
				if (settings.getConfig().getString("apply.link") != null) {
					p.sendMessage("§aApply here: http://goo.gl/iOfHMy Goodluck!");
				} else {
					p.sendMessage("§cThere is no link available!");
				}
			} else {
				p.sendMessage("§cYou cannot apply at this time!");
			}
		}

		return true;
	}
}
