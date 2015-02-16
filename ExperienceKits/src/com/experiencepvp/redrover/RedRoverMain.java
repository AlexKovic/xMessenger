package com.experiencepvp.redrover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.events.EventsHandler;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitUtil;

public class RedRoverMain {

	public static RedRoverMap runningmap = null;
	
	public static int players = 0;
	
	public static boolean open;
	
	public static boolean playing;
	
	public static HashMap<String, RedRoverMap> inqueue = new HashMap<String, RedRoverMap>();
	
	public static ArrayList<String> runners = new ArrayList<String>();
	
	public static ArrayList<String> taggers = new ArrayList<String>();
	
	public static ArrayList<String> invincible = new ArrayList<String>();
	
	public static HashMap<String, RedRoverMap> maps = new HashMap<String, RedRoverMap>();
	
	public static SettingsManager settings = SettingsManager.getInstance();
	
	public static ArrayList<String> random = new ArrayList<String>();
	
	public static void startTourney(final RedRoverMap map, Player p){
		playing = true;
		open = true;
		runningmap = map;
		EventsHandler.runningevent = "combo";
		EventsHandler.running = true;
		inqueue.put(p.getName(), map);
		RedRoverUtil.startTimer(p, map);
		players = players + 1;
		p.sendMessage("§aYou have successfully joined the §lqueue! §7(" + players + "/" + map.getMaxPlayers() + ")");
		new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				for(String s : inqueue.keySet()){
					if(Bukkit.getServer().getPlayer(s) != null){
						maps.put(s, inqueue.get(s));
					}
				}

				inqueue.clear();
				
				if(maps.size() < 2){
					runningmap = null;
					players = 0;
					playing = false;
					open = false;
					maps.clear();
					inqueue.clear();
					EventsHandler.runningevent = "";
					EventsHandler.running = false;
					return;
				}				
				
				open = false;
				for (Player on : Bukkit.getOnlinePlayers()) {
					if(maps.containsKey(on.getName())){
						if (maps.get(on.getName()) == map) {
							for (String s : maps.keySet()) 
								random.add(s);
							
							Random r = new Random();
							int index = r.nextInt(random.size());
							Player tag = Bukkit.getPlayer(random.get(index));
							taggers.add(tag.getName());
							tag.sendMessage("§aYou are the tagger!");
							setupTagger(tag);
							random.clear();
							tag.teleport(map.getTagLocation());
							
							if (!taggers.contains(on.getName())) {
								on.sendMessage("§aPlayer " + tag.getName() + " is the tagger!");
								runners.add(on.getName());
							}
							
							on.teleport(map.getStartLoc());
							
							setupKits(on);
						}
					}
				}										
			}
		}.runTaskLater(Main.getPlugin(), 600);
		
		new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				for (Player on : Bukkit.getOnlinePlayers()) {
					if (invincible.contains(on.getName()) && maps.get(on.getName()) == map) {
						invincible.remove(on.getName());
						on.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You are no longer invincible!");
					}
				}
			}
		}.runTaskLater(Main.getPlugin(), 800);
	}
	
	public static void setupKits(Player p) {
		KitHandler.delKit(p);
		KitUtil.clearInventory(p);
	}
	
	public static void setupTagger(Player p) {
		p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
		p.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
		p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
		
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999, -10));
	}
}
