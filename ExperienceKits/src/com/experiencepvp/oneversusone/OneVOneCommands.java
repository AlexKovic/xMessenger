package com.experiencepvp.oneversusone;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.experiencepvp.kits.Spawn;
import com.experiencepvp.kits.listeners.PlayerListener;
import com.experiencepvp.kits.utils.KitHandler;

public class OneVOneCommands implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You may not run this cmd!");
		}

		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("1v1")) {
			if(args.length == 0){
			if(p.hasPermission("experiencepvp.1v1")){
				if(OneVOneListener.lobby1v1.contains(p.getName())){
					if(!OneVOneListener.fighting.contains(p.getName())){
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						KitHandler.delKit(p);
						OneVOneListener.lobby1v1.remove(p.getName());

						OneVOneListener.asked1v1player.remove(p.getName());
						OneVOneListener.cantmove.remove(p.getName());
						OneVOneListener.fighting.remove(p.getName());
						OneVOneListener.fightingwith.remove(p.getName());
						OneVOneListener.player1v1maps.remove(p.getName());
						OneVOneListener.player1v1player.remove(p.getName());
						OneVOneListener.player1v1type.remove(p.getName());
						OneVOneListener.kit1v1.remove(p.getName());
						
						p.teleport(Spawn.getSpawnLoc());
						PlayerListener.setUpSpawnItems(p);
						p.sendMessage(OneVOneUtil.pref + ChatColor.GOLD + "You have left the 1v1 lobby");
					}else{
						p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't leave the 1v1 lobby while you are in a fight!");
					}
				}else{
					p.teleport(OneVOneUtil.getSpawn());
					OneVOneUtil.give1v1Items(p);
					OneVOneListener.lobby1v1.add(p.getName());

					OneVOneListener.asked1v1player.remove(p.getName());
					OneVOneListener.kit1v1.remove(p.getName());
					OneVOneListener.cantmove.remove(p.getName());
					OneVOneListener.fighting.remove(p.getName());
					OneVOneListener.fightingwith.remove(p.getName());
					OneVOneListener.player1v1maps.remove(p.getName());
					OneVOneListener.player1v1player.remove(p.getName());
					OneVOneListener.player1v1type.remove(p.getName());
			
					p.sendMessage(OneVOneUtil.pref + ChatColor.GOLD + "You have been teleported to the 1v1 lobby!");
				}
			}else{
				p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You do not have permission to join the 1v1 lobby!");
			}
			}else if(args.length == 3){
				if(args[0].equalsIgnoreCase("setloc")){
					int id = Integer.parseInt(args[1]);
					int loc = Integer.parseInt(args[2]);
					
					OneVOneUtil.setLocation(id, loc, p.getLocation());
					
					p.sendMessage(ChatColor.GREEN + "Location " + ChatColor.BOLD + loc + ChatColor.RESET + "" + ChatColor.GREEN + " has been set for the map with ID "+ ChatColor.BOLD + id + ChatColor.RESET + "" + ChatColor.GREEN + "!");
				}
			}
		}
		return false;
	}
}
