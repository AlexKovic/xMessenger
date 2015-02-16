package com.experiencepvp.miscellaneous.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.tournaments.TourneyMain;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;

public class HacksCheck implements Listener, CommandExecutor {

	public ArrayList<String> checking = new ArrayList<String>();
	public HashMap<String, Integer> zombieint = new HashMap<String, Integer>();
	public HashMap<String, Entity> zombie1 = new HashMap<String, Entity>();
	public HashMap<String, Entity> zombie2 = new HashMap<String, Entity>();
	public HashMap<String, Entity> zombie3 = new HashMap<String, Entity>();
	public HashMap<String, Entity> zombie4 = new HashMap<String, Entity>();
	public HashMap<String, Boolean> zombie1b = new HashMap<String, Boolean>();
	public HashMap<String, Boolean> zombie2b = new HashMap<String, Boolean>();
	public HashMap<String, Boolean> zombie3b = new HashMap<String, Boolean>();
	public HashMap<String, Boolean> zombie4b = new HashMap<String, Boolean>();
	public HashMap<String, String> checkingp = new HashMap<String, String>();
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You may not run this cmd!");
		}

		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("checkff")) {
			if(!p.hasPermission("experiencepvp.checkff")){
				p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission!");
				return false;
			}
			if(args.length != 1){
				p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /checkff [Player]");
			}else{
				Player on = Bukkit.getServer().getPlayer(args[0]);
				if(on == null){
					p.sendMessage(Main.pref + ChatColor.RED + args[0] + " is not online!");
					return false;
				}
				
				checking.add(on.getName());
				
				p.sendMessage(Main.pref + ChatColor.GRAY + "Check " + on.getName() + " for ForceField/KillAura hacks. Process will take 15 seconds!");
				
				startFFCheck(on);
			}
		}
		return false;
	}
	
	public void startFFCheck(final Player p){
		zombie1b.put(p.getName(), false);
		zombie1b.put(p.getName(), false);
		zombie1b.put(p.getName(), false);
		zombie1b.put(p.getName(), false);
		final Location loc = p.getLocation().toVector().add(p.getLocation().getDirection().multiply(-3)).toLocation(p.getWorld());
		zombie1.put(p.getName(), p.getWorld().spawnEntity(loc, EntityType.ZOMBIE));
		new BukkitRunnable(){
			public void run(){
				zombie1.get(p.getName()).remove();
			}
		}.runTaskLater(Main.getPlugin(), 5);
		
		new BukkitRunnable(){
			public void run(){
				zombie2.put(p.getName(), p.getWorld().spawnEntity(loc, EntityType.ZOMBIE));
			}
		}.runTaskLater(Main.getPlugin(), 100);
		new BukkitRunnable(){
			public void run(){
				zombie2.get(p.getName()).remove();
			}
		}.runTaskLater(Main.getPlugin(), 105);
		
		new BukkitRunnable(){
			public void run(){
				zombie3.put(p.getName(), p.getWorld().spawnEntity(loc, EntityType.ZOMBIE));				
			}
		}.runTaskLater(Main.getPlugin(), 200);
		new BukkitRunnable(){
			public void run(){
				zombie3.get(p.getName()).remove();				
			}
		}.runTaskLater(Main.getPlugin(), 205);
		
		new BukkitRunnable(){
			public void run(){
				zombie4.put(p.getName(), p.getWorld().spawnEntity(loc, EntityType.ZOMBIE));
			}
		}.runTaskLater(Main.getPlugin(), 300);
		new BukkitRunnable(){
			public void run(){
				zombie4.get(p.getName()).remove();
				checking.remove(p.getName());
				Bukkit.getPlayer(checkingp.get(p.getName())).sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Report - " + p.getName() + ":");
				Bukkit.getPlayer(checkingp.get(p.getName())).sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + "Zombie 1: " + ChatColor.BLUE + zombie1b.get(p.getName()).toString());
				Bukkit.getPlayer(checkingp.get(p.getName())).sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + "Zombie 2: " + ChatColor.BLUE + zombie2b.get(p.getName()).toString());
				Bukkit.getPlayer(checkingp.get(p.getName())).sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + "Zombie 3: " + ChatColor.BLUE + zombie3b.get(p.getName()).toString());
				Bukkit.getPlayer(checkingp.get(p.getName())).sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + "Zombie 4: " + ChatColor.BLUE + zombie4b.get(p.getName()).toString());
			}
		}.runTaskLater(Main.getPlugin(), 305);
	}
	
	@EventHandler
	public void onHitFFZombie(EntityDamageByEntityEvent e){
		if(e.getEntity().getType() == EntityType.ZOMBIE && e.getDamager() instanceof Player){
			Player p = (Player) e.getDamager();
			if(checking.contains(p.getName())){
				if(zombie1.get(p.getName()) == e.getEntity()){
					zombie1b.put(p.getName(), true);
				}else if(zombie1.get(p.getName()) == e.getEntity()){
					zombie2b.put(p.getName(), true);
				}else if(zombie1.get(p.getName()) == e.getEntity()){
					zombie3b.put(p.getName(), true);
				}else if(zombie1.get(p.getName()) == e.getEntity()){
					zombie4b.put(p.getName(), true);
				}
			}
		}
	}
	
}
