package com.experiencepvp.kits.tournaments.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.events.EventsHandler;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.tournaments.TourneyMain;
import com.experiencepvp.kits.tournaments.TourneyUtil;
import com.experiencepvp.kits.tournaments.maps.ExperienceMap;


public class TourneyCommands implements CommandExecutor{ 
	

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
		
		if(cmd.getName().equalsIgnoreCase("tourney")){
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
									if (ExperienceMap.getMapById(map) != null) {
										ExperienceMap m = ExperienceMap.getMapById(map);
										TourneyMain.startTourney(m);
									} else {
										sender.sendMessage("§cMap " + map + " has not been found!");
									}
								}
							}else {
								sender.sendMessage("§cThere is already a tourney going on!");
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
//									TourneyUtil.setLocation(map, p.getLocation());
//									p.sendMessage("§aThe location of the map with ID §l" + map + " §f§ahas been succesfully set at your location!");
//								}
//							}
//						}
//					}else if (args[0].equalsIgnoreCase("setmaxplayers")) {
//						if (args.length == 1 || args.length == 2) {
//							p.sendMessage("§cWrong syntax; use §l/tourney setmaxplayers <map> <amount>");
//						}
//						if (args.length > 2) {
//							if (TourneyMain.isInt(args[2])) {
//								int max = Integer.parseInt(args[2]);
//								if (TourneyMain.isInt(args[1])) {
//									int map = Integer.parseInt(args[1]);
//										TourneyUtil.setMaxPlayers(map, max);
//										p.sendMessage("§aThe maximum amount of players of the map with ID §l" + map + " §f§ahas been set to §l" + max + "§f§a!");
//								}
//							}
//						}
//					} else if (args[0].equalsIgnoreCase("help")) {
//						p.sendMessage("§aMaps:");
//						p.sendMessage("§a1: The Mine §7(Usage: /tourney <command> 1)");
//						p.sendMessage("§a2: Beach §7(Usage: /tourney <command> 2)");
//					} 
//				}
			}
		return false;
	}
}
