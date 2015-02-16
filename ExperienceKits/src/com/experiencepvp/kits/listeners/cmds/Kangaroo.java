package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Kangaroo implements Listener, CommandExecutor {

	public HashMap<String, Integer> kangajumps = new HashMap<String, Integer>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("kangaroo")) {
			if (LevelUtil.getLevel(p, KitType.KANGAROO) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.KANGAROO.getUtil().giveKit(p, KitType.KANGAROO);
					return true;
				} else {
					p.sendMessage("§cYou can only have one kit a life!");
					return true;
				}
			}else{
				p.sendMessage("§cYou don't have the permission for this kit!");
				return true;
			}
		}
		return true;
	}

	public ArrayList<Player> kanga = new ArrayList<Player>();
	public ArrayList<Player> kangarunnable = new ArrayList<Player>();

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (p.getItemInHand().getType() == Material.FIREWORK) {
			event.setCancelled(true);
			if (KitHandler.hasKit(p.getName(), KitType.KANGAROO)) {
				if (Main.correctRegion(p.getLocation())) {
					if (event.getAction() == Action.LEFT_CLICK_AIR
							|| event.getAction() == Action.LEFT_CLICK_BLOCK
							|| event.getAction() == Action.RIGHT_CLICK_BLOCK
							|| event.getAction() == Action.RIGHT_CLICK_AIR)
					if (!kanga.contains(p)) {
						
						if(KitHandler.getLevel(p.getName()) != 4){
							if(!kangajumps.containsKey(p.getName())){
								kangajumps.put(p.getName(), 0);
							}
						}
						
						if(KitHandler.getLevel(p.getName()) == 1){
							if(kangajumps.get(p.getName()) >= 3){
								p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
								return;
							}
						}else if(KitHandler.getLevel(p.getName()) == 2){

							if(kangajumps.get(p.getName()) >= 5){
								p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
								return;
							}
						}else if(KitHandler.getLevel(p.getName()) == 3){

							if(kangajumps.get(p.getName()) >= 7){
								p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
								return;
							}
						}
						
						if(KitHandler.getLevel(p.getName()) != 4){
							kangajumps.put(p.getName(), kangajumps.get(p.getName()) + 1);
							if(KitHandler.getLevel(p.getName()) == 1){
								if(kangajumps.get(p.getName()) >= 4){
									new BukkitRunnable(){
										public void run(){
											kangajumps.put(p.getName(), 0);
										}
									}.runTaskLater(Main.getPlugin(), 200);
									return;
								}
							}else if(KitHandler.getLevel(p.getName()) == 2){

								if(kangajumps.get(p.getName()) >= 6){
									new BukkitRunnable(){
										public void run(){
											kangajumps.put(p.getName(), 0);
										}
									}.runTaskLater(Main.getPlugin(), 200);
									return;
								}
							}else if(KitHandler.getLevel(p.getName()) == 3){

								if(kangajumps.get(p.getName()) >= 8){
									new BukkitRunnable(){
										public void run(){
											kangajumps.put(p.getName(), 0);
										}
									}.runTaskLater(Main.getPlugin(), 100);
									return;
								}
							}
						}
						
						if (!(p.isSneaking())) {
							p.setFallDistance(-2F);
							Vector vector = p.getEyeLocation().getDirection();
							vector.multiply(0.6F);
							vector.setY(1.2F);
							p.setVelocity(vector);
						} else {
							p.setFallDistance(-2F);
							Vector vector = p.getEyeLocation().getDirection();
							vector.multiply(1.2F);
							vector.setY(0.8);
							p.setVelocity(vector);
						}
						kanga.add(p);
					}
				}
			}
		}
	}

	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		if (kanga.contains(p)) {
			Block b = p.getLocation().getBlock();
			if (b.getType() != Material.AIR
					|| b.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
				kanga.remove(p);
			}

		}
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		if (event.getItemDrop().getItemStack().getType() == Material.FIREWORK) {
			event.setCancelled(true);
		}
	}
	
/*
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		Entity e = event.getEntity();
		if (e instanceof Player) {
			Player player = (Player) e;
			if (event.getEntity() instanceof Player
					&& event.getCause() == DamageCause.FALL
					&& player.getInventory().contains(Material.FIREWORK)) {
				if (event.getDamage() >= 7) {
					event.setDamage(7.0);
				}
			}
		}
	}*/
}
