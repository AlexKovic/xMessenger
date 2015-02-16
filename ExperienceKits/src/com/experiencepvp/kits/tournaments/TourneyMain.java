package com.experiencepvp.kits.tournaments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.block.Skull;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.events.EventsHandler;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.tournaments.maps.ExperienceMap;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.oneversusone.OneVOneListener;

public class TourneyMain {

	/*
	 * Maps:
	 * 1: Mine
	 * 2: Beach
	 */
	
	static SettingsManager settings = SettingsManager.getInstance();
	
	public static HashMap<String, ExperienceMap> inqueue = new HashMap<String, ExperienceMap>();
	
	public static boolean open;
	
	public static ExperienceMap runningmap = null;
	
	public static int players;
	
	public static HashMap<String, ExperienceMap> maps = new HashMap<String, ExperienceMap>();
	
	public static ArrayList<String> invincible = new ArrayList<String>();
	
	
	public static Integer playersIn(){
		int i = 0;
		for(String s : maps.keySet()){
			if(Bukkit.getServer().getPlayer(s) != null){
				i++;
			}
		}
		
		return i;
	}
	
	public static boolean isInt(String s) {
	    try {
	        Integer.parseInt(s);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static void setupKits(Player p) {
		if (!KitHandler.hasKit(p.getName())) {
			KitType.PVP.getUtil().giveKit(p, KitType.PVP);
		}
	}
	
	public static void spawnFirework(Player p) {
		Location l1 = p.getLocation().add(5, 0, 0);
		Location l2 = p.getLocation().add(0, 0, 5);
		Location l3 = p.getLocation().subtract(5, 0, 0);
		Location l4 = p.getLocation().subtract(0, 0, 5);
		
		Firework f1 = (Firework) p.getWorld().spawn(l1, Firework.class);
		FireworkMeta fm1 = f1.getFireworkMeta();
		fm1.addEffect(FireworkEffect.builder().flicker(false).withColor(Color.WHITE).withFade(Color.RED).build());
		fm1.setPower(3);
		f1.setFireworkMeta(fm1);
		
		Firework f2 = (Firework) p.getWorld().spawn(l2, Firework.class);
		FireworkMeta fm2 = f2.getFireworkMeta();
		fm2.addEffect(FireworkEffect.builder().flicker(false).withColor(Color.WHITE).withFade(Color.RED).build());
		fm2.setPower(3);
		f2.setFireworkMeta(fm2);
		
		Firework f3 = (Firework) p.getWorld().spawn(l3, Firework.class);
		FireworkMeta fm3 = f3.getFireworkMeta();
		fm3.addEffect(FireworkEffect.builder().flicker(false).withColor(Color.WHITE).withFade(Color.RED).build());
		fm3.setPower(3);
		f3.setFireworkMeta(fm3);
		
		Firework f4 = (Firework) p.getWorld().spawn(l4, Firework.class);
		FireworkMeta fm4 = f4.getFireworkMeta();
		fm4.addEffect(FireworkEffect.builder().flicker(false).withColor(Color.WHITE).withFade(Color.RED).build());
		fm4.setPower(3);
		f4.setFireworkMeta(fm4);
	}
	
	@SuppressWarnings("deprecation")
	public static void testHead(){
		OfflinePlayer[] offlineplayers = Bukkit.getServer().getOfflinePlayers();
		ArrayList<OfflinePlayer> oplayers = new ArrayList<OfflinePlayer>();
		
		for(OfflinePlayer op : offlineplayers){
			oplayers.add(op);
		}
		
		OfflinePlayer op1 = null;
		OfflinePlayer op2 = null;
		OfflinePlayer op3 = null;
		
		String w1 = "";
		String w2 = "";
		String w3 = "";
		
		int wins1 = 0;
		int wins2 = 0;
		int wins3 = 0;
		
		for(OfflinePlayer oPlayer : oplayers){
			if(SettingsManager.getInstance().getData().contains("stats." + oPlayer.getUniqueId() + ".wins")){
				if(SettingsManager.getInstance().getData().getInt("stats." + oPlayer.getUniqueId() + ".wins") >= wins1){
					op1 = oPlayer;
					w1 = oPlayer.getName();
					wins1 = SettingsManager.getInstance().getData().getInt("stats." + oPlayer.getUniqueId() + ".wins");
				}
			}
		}
		
		oplayers.remove(op1);
		
		for(OfflinePlayer oPlayer : oplayers){
			if(SettingsManager.getInstance().getData().contains("stats." + oPlayer.getUniqueId() + ".wins")){
				if(SettingsManager.getInstance().getData().getInt("stats." + oPlayer.getUniqueId() + ".wins") >= wins2){
					op2 = oPlayer;
					w2 = oPlayer.getName();
					wins2 = SettingsManager.getInstance().getData().getInt("stats." + oPlayer.getUniqueId() + ".wins");
				}
			}
		}
		
		oplayers.remove(op2);
		
		for(OfflinePlayer oPlayer : oplayers){
			if(SettingsManager.getInstance().getData().contains("stats." + oPlayer.getUniqueId() + ".wins")){
				if(SettingsManager.getInstance().getData().getInt("stats." + oPlayer.getUniqueId() + ".wins") >= wins3){
					op3 = oPlayer;
					w3 = oPlayer.getName();
					wins3 = SettingsManager.getInstance().getData().getInt("stats." + oPlayer.getUniqueId() + ".wins");
				}
			}
		}
		
		oplayers.remove(op3);
		
		Location loc1 = new Location(Bukkit.getServer().getWorlds().get(0), -5153, 10, -5242);
		Location loc2 = new Location(Bukkit.getServer().getWorlds().get(0), -5152, 10, -5242);
		Location loc3 = new Location(Bukkit.getServer().getWorlds().get(0), -5151, 10, -5242);
		
		loc1.getBlock().setType(Material.SKULL);
		loc1.getBlock().setData((byte) 3);
		Skull skull1 = (Skull) loc1.getBlock().getState();
		skull1.setOwner(w1);
		skull1.setRotation(BlockFace.SOUTH);
		skull1.update();
		
		loc2.getBlock().setType(Material.SKULL);
		loc2.getBlock().setData((byte) 3);
		Skull skull2 = (Skull) loc2.getBlock().getState();
		skull2.setOwner(w2);
		skull2.setRotation(BlockFace.SOUTH);
		skull2.update();
		
		loc3.getBlock().setType(Material.SKULL);
		loc3.getBlock().setData((byte) 3);
		Skull skull3 = (Skull) loc3.getBlock().getState();
		skull3.setOwner(w3);
		skull1.setRotation(BlockFace.SOUTH);
		skull3.update();
		
		Location sl1 = new Location(Bukkit.getServer().getWorlds().get(0), -5153, 9, -5241);
		Location sl2 = new Location(Bukkit.getServer().getWorlds().get(0), -5152, 9, -5241);
		Location sl3 = new Location(Bukkit.getServer().getWorlds().get(0), -5151, 9, -5241);
		
		sl1.getBlock().setType(Material.WALL_SIGN);
		if(sl1.getBlock().getState() instanceof Sign){
			Sign s1 = (Sign) sl1.getBlock().getState();
			s1.setLine(0, "== 1st Place ==");
			s1.setLine(1, w1);
			s1.setLine(2, "Wins: " + SettingsManager.getInstance().getData().getInt("stats." + op1.getUniqueId() + ".wins"));
			s1.setLine(3, "================");
			org.bukkit.material.Sign matSign =  new org.bukkit.material.Sign(Material.WALL_SIGN);
			matSign.setFacingDirection(BlockFace.SOUTH);
			s1.setData(matSign);
			s1.update();
		}else{
			if(Bukkit.getServer().getPlayer("alexkovic") != null){
				Bukkit.getServer().getPlayer("alexkovic").sendMessage("" + sl1.getBlock().getState().toString());
			}
		}
		
		sl2.getBlock().setType(Material.WALL_SIGN);
		if(sl2.getBlock().getState() instanceof Sign){
			Sign s2 = (Sign) sl2.getBlock().getState();
			s2.setLine(0, "== 2nd Place ==");
			s2.setLine(1, w2);
			s2.setLine(2, "Wins: " + SettingsManager.getInstance().getData().getInt("stats." + op2.getUniqueId() + ".wins"));
			s2.setLine(3, "================");
			org.bukkit.material.Sign matSign =  new org.bukkit.material.Sign(Material.WALL_SIGN);
			matSign.setFacingDirection(BlockFace.SOUTH);
			s2.setData(matSign);
			s2.update();
		}
		
		sl3.getBlock().setType(Material.WALL_SIGN);
		if(sl3.getBlock().getState() instanceof Sign){
			Sign s3 = (Sign) sl3.getBlock().getState();
			s3.setLine(0, "== 3rd Place ==");
			s3.setLine(1, w3);
			s3.setLine(2, "Wins: " + SettingsManager.getInstance().getData().getInt("stats." + op3.getUniqueId() + ".wins"));
			s3.setLine(3, "================");
			org.bukkit.material.Sign matSign =  new org.bukkit.material.Sign(Material.WALL_SIGN);
			matSign.setFacingDirection(BlockFace.SOUTH);
			s3.setData(matSign);
			s3.update();
		}
	}
	
	
	public static void startTourney(final ExperienceMap map){
		EventsHandler.running = true;
		EventsHandler.runningevent = "tourney";
		TourneyMain.open = true;
		TourneyMain.runningmap = map;
		map.startTimer();
		new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				for(String s : TourneyMain.inqueue.keySet()){
					if(Bukkit.getServer().getPlayer(s) != null){
						TourneyMain.maps.put(s, TourneyMain.inqueue.get(s));
					}
				}

				TourneyMain.inqueue.clear();
				
				if(TourneyMain.maps.size() < 2){
					TourneyMain.runningmap = null;
					TourneyMain.players = 0;
					EventsHandler.running = false;
					EventsHandler.runningevent = "";
					TourneyMain.open = false;
					TourneyMain.maps.clear();
					TourneyMain.inqueue.clear();
					return;
				}				
				
				TourneyMain.open = false;
				for (Player on : Bukkit.getOnlinePlayers()) {
					if(TourneyMain.maps.containsKey(on.getName())){
						if (TourneyMain.maps.get(on.getName()) == map) {
							on.teleport(map.getSpawnpoint());
							TourneyMain.invincible.add(on.getName());
							on.sendMessage("§aYou are now invincible for 10 seconds!");
							
							KitType kt = KitType.PVP;
							if(!KitHandler.hasKit(on.getName())){
								kt = KitType.PVP;
							}else{
								kt = KitHandler.getKit(on.getName());
							}
							
							kt.getUtil().giveKit(on, kt);
						}
					}
				}										
			}
		}.runTaskLater(Main.getPlugin(), 600);
		
		new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				for (Player on : Bukkit.getOnlinePlayers()) {
					if (TourneyMain.invincible.contains(on.getName()) && TourneyMain.maps.get(on.getName()) == map) {
						TourneyMain.invincible.remove(on.getName());
						on.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You are no longer invincible!");
					}
				}
			}
		}.runTaskLater(Main.getPlugin(), 800);
	}
	
	
	@SuppressWarnings("deprecation")
	public static void joinTourney(Player p){
		OneVOneListener.asked1v1player.remove(p.getName());
		OneVOneListener.cantmove.remove(p.getName());
		OneVOneListener.fighting.remove(p.getName());
		OneVOneListener.fightingwith.remove(p.getName());
		OneVOneListener.lobby1v1.remove(p.getName());
		OneVOneListener.player1v1maps.remove(p.getName());
		OneVOneListener.player1v1player.remove(p.getName());
		OneVOneListener.player1v1type.remove(p.getName());
		TourneyMain.inqueue.put(p.getName(), runningmap);
		TourneyMain.players = TourneyMain.players + 1;
		p.sendMessage("§aYou have successfully joined the §lqueue! §7(" + TourneyMain.players + "/" + runningmap.getMaxPlayers() + ")");
		p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Tourney's are currently in Beta! Please report any bugs to the staff members!");
		for(Player on : Bukkit.getServer().getOnlinePlayers()){
			if(TourneyMain.inqueue.containsKey(on.getName())){
				if(TourneyMain.inqueue.get(on.getName()) == runningmap){
					on.sendMessage("§a§l" + p.getName() + "§f§a has joined the queue! §7(" + TourneyMain.players + "/" + runningmap.getMaxPlayers() + ")"); 
				}
			}
		}
	}
	
	
}
