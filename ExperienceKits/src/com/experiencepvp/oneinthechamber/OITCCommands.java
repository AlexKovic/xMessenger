package com.experiencepvp.oneinthechamber;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.experiencepvp.events.EventsHandler;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.tournaments.TourneyMain;

public class OITCCommands implements CommandExecutor {

public static SettingsManager settings = SettingsManager.getInstance();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			sender.sendMessage("You may not run this cmd!");
			return false;
		}
		
//		if(cmd.getName().equalsIgnoreCase("join")) {
//			if(TourneyMain.runningmap != null) {
//				if(TourneyMain.open == true) {
//					if(TourneyMain.players < TourneyMain.runningmap.getMaxPlayers()) {
//						if(!TourneyMain.inqueue.containsKey(p.getName())){
//							TourneyMain.joinTourney(p);
//						}else{
//							p.sendMessage("§cYou are already in the queue!");
//						}
//					}else{
//						p.sendMessage("§cSorry, but the queue is full!");
//					}
//					
//				}else {
//					p.sendMessage("§cYou can't join right now!");
//				}
//			}else{
//				p.sendMessage("§cThere is no event running at this point!");
//			}
//		}
		
		if(cmd.getName().equalsIgnoreCase("oitc")){
			if (args.length == 0) {
				sender.sendMessage("§aUse §l/event help §f§afor more help!");
			}
			//HOSTER PART
			if (args.length > 1) {
				if (args[0].equalsIgnoreCase("host")) {
					if (EventsHandler.canHost) {
							if (EventsHandler.running == false) {
								if (TourneyMain.isInt(args[1])) {
									int map = Integer.parseInt(args[1]);
									if (OITCMap.getMapById(map) != null) {
										OITCMap m = OITCMap.getMapById(map);
										OITCMain.startTourney(m);
									} else {
										sender.sendMessage("§cMap " + map + " has not been found!");
									}
								}
							}else {
								sender.sendMessage("§cThere is already an event going on!");
							}
					}
				}
			}
			
			
			// ADMIN PART
//				if (args.length != 1 && !(args.length < 1)) {
//					if (args[0].equalsIgnoreCase("setloc")) {
//						if (p.isOp()) {
//							if (args.length > 1) {
//								if (TourneyMain.isInt(args[1])) { 
//									int map = Integer.parseInt(args[1]);
//									OITCUtil.setLocation(map, p.getLocation());
//									p.sendMessage("§aThe location of the map with ID §l" + map + " §f§ahas been succesfully set at your location!");
//								}
//							}
//						}
//					}else if (args[0].equalsIgnoreCase("setmaxplayers")) {
//						if (args.length == 1 || args.length == 2) {
//							p.sendMessage("§cWrong syntax; use §l/oitc setmaxplayers <map> <amount>");
//						}
//						if (args.length > 2) {
//							if (TourneyMain.isInt(args[2])) {
//								int max = Integer.parseInt(args[2]);
//								if (TourneyMain.isInt(args[1])) {
//									int map = Integer.parseInt(args[1]);
//										OITCUtil.setMaxPlayers(map, max);
//										p.sendMessage("§aThe maximum amount of players of the map with ID §l" + map + " §f§ahas been set to §l" + max + "§f§a!");
//								}
//							}
//						}
//					}
//			}
		}
		return false;
	}
	
}