package com.experiencepvp.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.combo.ComboMain;
import com.experiencepvp.combo.ComboMap;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.Spawn;
import com.experiencepvp.kits.tournaments.TourneyMain;
import com.experiencepvp.kits.tournaments.maps.ExperienceMap;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitUtil;
import com.experiencepvp.lava.LavaMain;
import com.experiencepvp.lava.LavaMap;
import com.experiencepvp.oneinthechamber.OITCMain;
import com.experiencepvp.oneinthechamber.OITCMap;

public class EventsHandler implements CommandExecutor {

	public static String runningevent = null;
	
	public static boolean running = false;

	public static boolean canHost = true;
		
	public static SettingsManager settings = SettingsManager.getInstance();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You may not run this cmd!");
		}

		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("join")) {
			if(running) {
				if(runningevent.equalsIgnoreCase("tourney")){
					if(TourneyMain.open == true) {
						if(TourneyMain.players < TourneyMain.runningmap.getMaxPlayers()) {
							if(!TourneyMain.inqueue.containsKey(p.getName())){
								TourneyMain.joinTourney(p);
							}else{
								p.sendMessage("§cYou are already in the queue!");
							}
						}else{
							p.sendMessage("§cSorry, the queue is full!");
						}
					}else {
						p.sendMessage("§cThe event already started!!");
					}
				}else if(runningevent.equalsIgnoreCase("lava")){
					if(LavaMain.open == true) {
						if(LavaMain.players < LavaMain.runningmap.getMaxPlayers()) {
							if(!LavaMain.inqueue.containsKey(p.getName())){
								LavaMain.joinTourney(p);
							}else{
								p.sendMessage("§cYou are already in the queue!");
							}
						}else{
							p.sendMessage("§cSorry, the queue is full!");
						}
					}else {
						p.sendMessage("§cThe event already started!!");
					}
				}else if(runningevent.equalsIgnoreCase("combo")){
					if(ComboMain.open == true) {
						if(ComboMain.players < ComboMain.runningmap.getMaxPlayers()) {
							if(!ComboMain.inqueue.containsKey(p.getName())){
								ComboMain.joinTourney(p);
							}else{
								p.sendMessage("§cYou are already in the queue!");
							}
						}else{
							p.sendMessage("§cSorry, the queue is full!");
						}
					}else {
						p.sendMessage("§cThe event already started!!");
					}
				}else if(runningevent.equalsIgnoreCase("oitc")){
					if(OITCMain.open == true) {
						if(OITCMain.players < OITCMain.runningmap.getMaxPlayers()) {
							if(!OITCMain.inqueue.containsKey(p.getName())){
								OITCMain.joinTourney(p);
							}else{
								p.sendMessage("§cYou are already in the queue!");
							}
						}else{
							p.sendMessage("§cSorry, the queue is full!");
						}
					}else {
						p.sendMessage("§cThe event already started!!");
					}
				}
			}else{
				p.sendMessage("§cThere is no event running at this point!");
			}
			
		}else if(cmd.getName().equalsIgnoreCase("event")){
			if (args.length == 0) {
				p.sendMessage("§aUse §l/event help §f§afor more help!");
			}
			//HOSTER PART
			if(cmd.getName().equalsIgnoreCase("event")){
			
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("info")){
						if(EventsHandler.running == true){
							String event = "None";
							String map = "None";
							int remain = 0;
							if(runningevent != null){
								if(runningevent.equalsIgnoreCase("lava")){
									event = "Lava Challenge";
									map = LavaMain.runningmap.getName();
									remain = LavaMain.players;
								}else if(runningevent.equalsIgnoreCase("tourney")){
									event = "Tourney";
									map = TourneyMain.runningmap.getName();
									remain = TourneyMain.players;
								}else if(runningevent.equalsIgnoreCase("combo")){
									event = "Combo";
									map = ComboMain.runningmap.getName();
									remain = ComboMain.players;
								}else if(runningevent.equalsIgnoreCase("oitc")){
									event = "OITC";
									map = OITCMain.runningmap.getName();
									remain = OITCMain.players;
								}
							}
							p.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Event Info:");
							p.sendMessage(ChatColor.BLUE + "Running: " + ChatColor.GRAY + String.valueOf(running));
							p.sendMessage(ChatColor.BLUE + "Event: " + ChatColor.GRAY + event);
							p.sendMessage(ChatColor.BLUE + "Map: " + ChatColor.GRAY + map);
							p.sendMessage(ChatColor.BLUE + "Players Remaining " + ChatColor.GRAY + "(" + remain + ")" + ChatColor.BLUE + " :" + ChatColor.GRAY + remain);
							
							if(runningevent != null){
								if(runningevent.equalsIgnoreCase("lava")){
									if(LavaMain.maps.isEmpty()){
										p.sendMessage(ChatColor.RED + "Event is running but could not find any players?!");
										return false;
									}
									for(String s : LavaMain.maps.keySet()){
										p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + s);
									}
								}else if(runningevent.equalsIgnoreCase("tourney")){
									if(TourneyMain.maps.isEmpty()){
										p.sendMessage(ChatColor.RED + "Event is running but could not find any players?!");
										return false;
									}
									for(String s : TourneyMain.maps.keySet()){
										p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + s);
									}
								}else if(runningevent.equalsIgnoreCase("combo")){
									if(ComboMain.maps.isEmpty()){
										p.sendMessage(ChatColor.RED + "Event is running but could not find any players?!");
										return false;
									}
									for(String s : ComboMain.maps.keySet()){
										p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + s);
									}
								}else if(runningevent.equalsIgnoreCase("oitc")){
									if(OITCMain.maps.isEmpty()){
										p.sendMessage(ChatColor.RED + "Event is running but could not find any players?!");
										return false;
									}
									for(String s : OITCMain.maps.keySet()){
										p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + s);
									}
								}
							}
						}else{
							p.sendMessage(ChatColor.RED + "No event running!");
						}
					}else if(args[0].equalsIgnoreCase("forcestop")){
						if(p.hasPermission("experiencepvp.tourney.forcestop")){
							if(running == true){
								Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("messages.prefix") + ChatColor.RED + " The event has been forced stopped by " + ChatColor.BOLD + p.getName() + "!"));
								if(runningevent.equalsIgnoreCase("tourney")){
									TourneyMain.runningmap = null;
									TourneyMain.players = 0;
									running = false;
									runningevent = "";
									for(String s : TourneyMain.maps.keySet()){
										Player ps = Bukkit.getServer().getPlayer(s);
										if(ps != null){
											KitUtil.clearInventory(p);
											KitHandler.delKit(p);
											for(PotionEffect pot : ps.getActivePotionEffects()){
												p.removePotionEffect(pot.getType());
											}
											World w = Bukkit.getWorld(settings.getConfig().getString("spawn.world"));
											double x = settings.getConfig().getDouble("spawn.x");
											double y = settings.getConfig().getDouble("spawn.y");
												double z = settings.getConfig().getDouble("spawn.z");
											float yaw = (float) settings.getConfig().getDouble("spawn.yaw");
											float pitch = (float) settings.getConfig().getDouble("spawn.pitch");
											ps.teleport(new Location(w, x, y, z, yaw, pitch));
										}
									}
									TourneyMain.inqueue.clear();
									TourneyMain.maps.clear();
									TourneyMain.invincible.clear();
								}else if(runningevent.equalsIgnoreCase("lava")){
									LavaMain.runningmap = null;
									LavaMain.players = 0;
									running = false;
									runningevent = "";
									for(String s : LavaMain.maps.keySet()){
										Player ps = Bukkit.getServer().getPlayer(s);
										if(ps != null){
											World w = Bukkit.getWorld(settings.getConfig().getString("spawn.world"));
											double x = settings.getConfig().getDouble("spawn.x");
											double y = settings.getConfig().getDouble("spawn.y");
											double z = settings.getConfig().getDouble("spawn.z");
											float yaw = (float) settings.getConfig().getDouble("spawn.yaw");
											float pitch = (float) settings.getConfig().getDouble("spawn.pitch");
											ps.teleport(new Location(w, x, y, z, yaw, pitch));
										}
									}
									LavaMain.inqueue.clear();
									LavaMain.maps.clear();
									LavaMain.invincible.clear();
								}else if(runningevent.equalsIgnoreCase("combo")){
									ComboMain.runningmap = null;
									ComboMain.players = 0;
									running = false;
									runningevent = "";
									for(String s : ComboMain.maps.keySet()){
										Player ps = Bukkit.getServer().getPlayer(s);
										if(ps != null){
											World w = Bukkit.getWorld(settings.getConfig().getString("spawn.world"));
											double x = settings.getConfig().getDouble("spawn.x");
											double y = settings.getConfig().getDouble("spawn.y");
											double z = settings.getConfig().getDouble("spawn.z");
											float yaw = (float) settings.getConfig().getDouble("spawn.yaw");
											float pitch = (float) settings.getConfig().getDouble("spawn.pitch");
											ps.teleport(new Location(w, x, y, z, yaw, pitch));
										}
									}
									ComboMain.inqueue.clear();
									ComboMain.maps.clear();
									ComboMain.invincible.clear();
								}else if(runningevent.equalsIgnoreCase("oitc")){
									OITCMain.runningmap = null;
									OITCMain.players = 0;
									running = false;
									runningevent = "";
									for(String s : OITCMain.maps.keySet()){
										Player ps = Bukkit.getServer().getPlayer(s);
										if(ps != null){
											ps.teleport(Spawn.getSpawnLoc());
										}
									}
									OITCMain.inqueue.clear();
									OITCMain.maps.clear();
									OITCMain.invincible.clear();
								}
							}else{
								p.sendMessage(ChatColor.RED + "No tourney running!");
							}
						}
					}else if(args[0].equalsIgnoreCase("help")){
						if(p.hasPermission("experiencepvp.tourney.help")){
							p.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Event Help:");
							p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + "Tourney: " + ChatColor.BLUE + "/tourney host [1-" + ExperienceMap.values().length + "]");
							p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + "Lava: " + ChatColor.BLUE + "/lava host [1-" + LavaMap.values().length + "]");
							p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + "Combo: " + ChatColor.BLUE + "/combo host [1-" + ComboMap.values().length + "]");
							p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + "OITC: " + ChatColor.BLUE + "/oitc host [1-" + OITCMap.values().length + "]");
						}
					}else if(args[0].equalsIgnoreCase("disable")){
						canHost = false;
						p.sendMessage(Main.pref + ChatColor.GOLD + "Events have been disabled!");
					}else if(args[0].equalsIgnoreCase("enable")){
						canHost = true;
						p.sendMessage(Main.pref + ChatColor.GOLD + "Events have been enabled!");
					}
				}
			}
		}else if(cmd.getName().equalsIgnoreCase("vote")){
			if (args.length == 0) {
				p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /vote [1-3]");
			}else if(args.length == 1){
				if(avoted.contains(p.getName())){
					p.sendMessage(Main.pref + ChatColor.RED + "You already voted!");
					return false;
				}
				
				if(votes.isEmpty()){
					p.sendMessage(Main.pref + ChatColor.RED + "You can't vote for an event at the moment!");
					return false;
				}
				if(args[0].equalsIgnoreCase("1")){
					avoted.add(p.getName());
					votes.put(types[ints.get(0)], votes.get(types[ints.get(0)]) + 1);
					p.sendMessage(Main.pref + ChatColor.GOLD + "Succesfully voted for " + translate(types[ints.get(Integer.parseInt(args[0]) - 1)]) + "!");
				}else if(args[0].equalsIgnoreCase("2")){
					avoted.add(p.getName());
					votes.put(types[ints.get(1)], votes.get(types[ints.get(1)]) + 1);			
					p.sendMessage(Main.pref + ChatColor.GOLD + "Succesfully voted for " + translate(types[ints.get(Integer.parseInt(args[0]) - 1)]) + "!");
				}else if(args[0].equalsIgnoreCase("3")){
					avoted.add(p.getName());
					votes.put(types[ints.get(2)], votes.get(types[ints.get(2)]) + 1);
					p.sendMessage(Main.pref + ChatColor.GOLD + "Succesfully voted for " + translate(types[ints.get(Integer.parseInt(args[0]) - 1)]) + "!");
				}else{
					p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /vote [1 | 2 | 3]");					
				}
			}
		}
		return false;
	}

	
	public static void startCooldownTimer(String late){
		votes.clear();
		ints.clear();
		latest = late;
		if(!canHost){
			return;
		}
		new BukkitRunnable() {
			public void run() {
				ints = getRandoms();
				
				votes.put(types[ints.get(0)], 0);
				votes.put(types[ints.get(1)], 0);
				votes.put(types[ints.get(2)], 0);
				
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.GRAY + "An " + ChatColor.BLUE + "event" + ChatColor.GRAY + " is being hosted in " + ChatColor.BLUE + " 30 " + ChatColor.GRAY + " seconds! "
						+ "Use " + ChatColor.BLUE + "/vote [Number]" + ChatColor.GRAY + " to vote for the event you like!");
				
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.BLUE + "#1" + ChatColor.GRAY + ": " + translate(types[ints.get(0)]) + " - Votes: " + votes.get(types[ints.get(0)]));
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.BLUE + "#2" + ChatColor.GRAY + ": " + translate(types[ints.get(1)]) + " - Votes: " + votes.get(types[ints.get(1)]));
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.BLUE + "#3" + ChatColor.GRAY + ": " + translate(types[ints.get(2)]) + " - Votes: " + votes.get(types[ints.get(2)]));
			}
			
			
		}.runTaskLater(Main.getPlugin(), 12000);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.GRAY + "An " + ChatColor.BLUE + "event" + ChatColor.GRAY + " is being hosted in " + ChatColor.BLUE + " 20 " + ChatColor.GRAY + " seconds! "
						+ "Use " + ChatColor.BLUE + "/vote [Number]" + ChatColor.GRAY + " to vote for the event you like!");
				
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.BLUE + "#1" + ChatColor.GRAY + ": " + translate(types[ints.get(0)]) + " - Votes: " + ChatColor.BLUE + votes.get(types[ints.get(0)]));
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.BLUE + "#2" + ChatColor.GRAY + ": " + translate(types[ints.get(1)]) + " - Votes: " + ChatColor.BLUE + votes.get(types[ints.get(1)]));
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.BLUE + "#3" + ChatColor.GRAY + ": " + translate(types[ints.get(2)]) + " - Votes: " + ChatColor.BLUE + votes.get(types[ints.get(2)]));
			}
			
		}.runTaskLater(Main.getPlugin(), 12200);
		
		new BukkitRunnable() {
			public void run() {
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.GRAY + "An " + ChatColor.BLUE + "event" + ChatColor.GRAY + " is being hosted in " + ChatColor.BLUE + " 10 " + ChatColor.GRAY + " seconds! "
						+ "Use " + ChatColor.BLUE + "/vote [Number]" + ChatColor.GRAY + " to vote for the event you like!");
				
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.BLUE + "#1" + ChatColor.GRAY + ": " + translate(types[ints.get(0)]) + " - Votes: " + ChatColor.BLUE + votes.get(types[ints.get(0)]));
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.BLUE + "#2" + ChatColor.GRAY + ": " + translate(types[ints.get(1)]) + " - Votes: " + ChatColor.BLUE + votes.get(types[ints.get(1)]));
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.BLUE + "#3" + ChatColor.GRAY + ": " + translate(types[ints.get(2)]) + " - Votes: " + ChatColor.BLUE + votes.get(types[ints.get(2)]));
			}
			
		}.runTaskLater(Main.getPlugin(), 12400);
		
		new BukkitRunnable() {
			public void run() {
				String voted = types[ints.get(0)];
				if(votes.get(types[ints.get(1)]) > votes.get(voted)){
					voted = types[ints.get(1)];
				}				
				if(votes.get(types[ints.get(2)]) > votes.get(voted)){
					voted = types[ints.get(2)];
				}
				startTourney(voted);
				votes.clear();
				ints.clear();
			}
			
		}.runTaskLater(Main.getPlugin(), 12600);
		
	}
	
	public static List<Integer> ints = new ArrayList<Integer>();
	
	public static HashMap<String, Integer> votes = new HashMap<String, Integer>();
	
	public static ArrayList<String> avoted = new ArrayList<String>();
	
	public static String latest = "";
	
	public static String[] types = {"tourney", "lava", "combo", "oitc"};
	
	public static List<Integer> getRandoms(){
		List<Integer> ints = new ArrayList<Integer>();
		
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		
		Random r1 = new Random();
		Random r2 = new Random();
		Random r3 = new Random();
		
		i1 = r1.nextInt(types.length - 1) + 1;
		i2 = r2.nextInt(types.length - 1) + 1;
		i3 = r3.nextInt(types.length - 1) + 1;
		
		while(i1 == i2 || i1 == i3 || types[i1].equalsIgnoreCase(latest)){
			Random r = new Random();
			i1 = r.nextInt(types.length - 1) + 1;
		}
		
		while(i2 == i1 || i1 == i3 || types[i2].equalsIgnoreCase(latest)){
			Random r = new Random();
			i2 = r.nextInt(types.length - 1) + 1;
		}
		
		while(i3 == i1 || i1 == i2 || types[i3].equalsIgnoreCase(latest)){
			Random r = new Random();
			i3 = r.nextInt(types.length - 1) + 1;
		}
		
		ints.add(i1);
		ints.add(i2);
		ints.add(i3);
		
		return ints;
	}
	
	public static void startTourney(String s){
		if(s.equalsIgnoreCase("tourney")){
			Random r = new Random();
			int map = r.nextInt(ExperienceMap.values().length - 1) + 1;
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tourney host " + map);
		}else if(s.equalsIgnoreCase("lava")){
			Random r = new Random();
			int map = r.nextInt(LavaMap.values().length - 1) + 1;
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lava host " + map);			
		}else if(s.equalsIgnoreCase("combo")){
			Random r = new Random();
			int map = r.nextInt(ComboMap.values().length - 1) + 1;
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "combo host " + map);			
		}else if(s.equalsIgnoreCase("oitc")){
			Random r = new Random();
			int map = r.nextInt(OITCMap.values().length - 1) + 1;
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "oitc host " + map);			
		}
	}
	
	
	public static String translate(String s){
		String e = "";
		if(s.equalsIgnoreCase("tourney")){
			e = "Tourney";
		}else if(s.equalsIgnoreCase("lava")){
			e = "Lava Challenge";
		}else if(s.equalsIgnoreCase("combo")){
			e = "Combo";
		}else if(s.equalsIgnoreCase("oitc")){
			e = "One In The Chamber";
		}else if(s.equalsIgnoreCase("rr")){
			e = "Red Rover";
		}
		
		return e;
	}
}
