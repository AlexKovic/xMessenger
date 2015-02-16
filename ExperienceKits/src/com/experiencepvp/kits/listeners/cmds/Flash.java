package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.kits.utils.KitUtil;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

import de.slikey.effectlib.effect.LineEffect;

public class Flash implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("flash")) {
			if (LevelUtil.getLevel(p, KitType.FLASH) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())){
					KitType.FLASH.getUtil().giveKit(p, KitType.FLASH);
					return true;
				} else {
					p.sendMessage("§cYou can only have one kit a life!");
					return true;
				}
			} else {
				p.sendMessage("§cYou don't have the permission for this kit!");
				return true;
			}
		}
		return true;
	}
	
	public ArrayList<String> cooldown = new ArrayList<String>();
	public HashMap<String, Location> flashloc = new HashMap<String, Location>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitHandler.getKit(p.getName()) == KitType.FLASH && Main.correctRegion(p.getLocation())) {
			if (p.getItemInHand() != null) {
				if (p.getItemInHand().getType() == Material.REDSTONE_TORCH_ON) {
					if (!cooldown.contains(p.getName())) {
						if(KitHandler.getLevel(p.getName()) == 1){
							Location loc = p.getTargetBlock(null, 30).getLocation();
							if (loc.getBlock().getType() != Material.AIR) {
								if(loc.getBlock().getType() == Material.GLASS && new Location(loc.getWorld(), loc.getBlockX(), loc.getBlockY() + 5, loc.getBlockZ()).getBlock().getType() == Material.GLASS){
									p.sendMessage(Main.pref + ChatColor.RED + "You are not allowed to go there!");
									return;
								}
								flashloc.put(p.getName(), p.getLocation());
								p.teleport(loc.add(0, 1, 0));
								final LineEffect line = new LineEffect(Main.em);
								line.setLocation(flashloc.get(p.getName()).add(0, 1, 0));
								line.setTarget(loc.add(0, 2, 0));
								line.start();
								p.getInventory().setItem(8, KitUtil.setName(new ItemStack(Material.REDSTONE_TORCH_OFF), "§9Flash's torch"));
								p.updateInventory();
								cooldown.add(p.getName());
								//int distance = (int) Math.round(p.getLocation().distance(loc) / 2);
								//p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, distance, 0));
								new BukkitRunnable() {
									public void run() {
										if (cooldown.contains(p.getName())) {
											cooldown.remove(p.getName());
											p.sendMessage("§aNo longer on cooldown!");
											p.getInventory().setItem(8, KitUtil.setName(new ItemStack(Material.REDSTONE_TORCH_ON), "§9Flash's torch"));
										}
									}
								}.runTaskLater(Main.getPlugin(), 600L);
							}
						}else if(KitHandler.getLevel(p.getName()) == 2){
							Location loc = p.getTargetBlock(null, 40).getLocation();
							if (loc.getBlock().getType() != Material.AIR) {
								flashloc.put(p.getName(), p.getLocation());
								p.teleport(loc.add(0, 1, 0));
								final LineEffect line = new LineEffect(Main.em);
								line.setLocation(flashloc.get(p.getName()).add(0, 1, 0));
								line.setTarget(loc.add(0, 2, 0));
								line.start();
								p.getInventory().setItem(8, KitUtil.setName(new ItemStack(Material.REDSTONE_TORCH_OFF), "§9Flash's torch"));
								p.updateInventory();
								cooldown.add(p.getName());
								//int distance = (int) Math.round(p.getLocation().distance(loc) / 2);
								//p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, distance, 0));
								new BukkitRunnable() {
									public void run() {
										if (cooldown.contains(p.getName())) {
											cooldown.remove(p.getName());
											p.sendMessage("§aNo longer on cooldown!");
											p.getInventory().setItem(8, KitUtil.setName(new ItemStack(Material.REDSTONE_TORCH_ON), "§9Flash's torch"));
										}
									}
								}.runTaskLater(Main.getPlugin(), 500L);
							}
						}else if(KitHandler.getLevel(p.getName()) == 3){
							Location loc = p.getTargetBlock(null, 40).getLocation();
							if (loc.getBlock().getType() != Material.AIR) {
								flashloc.put(p.getName(), p.getLocation());
								p.teleport(loc.add(0, 1, 0));
								final LineEffect line = new LineEffect(Main.em);
								line.setLocation(flashloc.get(p.getName()).add(0, 1, 0));
								line.setTarget(loc.add(0, 2, 0));
								line.start();
								p.getInventory().setItem(8, KitUtil.setName(new ItemStack(Material.REDSTONE_TORCH_OFF), "§9Flash's torch"));
								p.updateInventory();
								cooldown.add(p.getName());
								//int distance = (int) Math.round(p.getLocation().distance(loc) / 2);
								//p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, distance, 0));
								new BukkitRunnable() {
									public void run() {
										if (cooldown.contains(p.getName())) {
											cooldown.remove(p.getName());
											p.sendMessage("§aNo longer on cooldown!");
											p.getInventory().setItem(8, KitUtil.setName(new ItemStack(Material.REDSTONE_TORCH_ON), "§9Flash's torch"));
										}
									}
								}.runTaskLater(Main.getPlugin(), 400L);
							}
						}else if(KitHandler.getLevel(p.getName()) == 4){
							Location loc = p.getTargetBlock(null, 500).getLocation();
							if (loc.getBlock().getType() != Material.AIR) {
								flashloc.put(p.getName(), p.getLocation());
								p.teleport(loc.add(0, 1, 0));
								final LineEffect line = new LineEffect(Main.em);
								line.setLocation(flashloc.get(p.getName()).add(0, 1, 0));
								line.setTarget(loc.add(0, 2, 0));
								p.getInventory().setItem(8, KitUtil.setName(new ItemStack(Material.REDSTONE_TORCH_OFF), "§9Flash's torch"));
								p.updateInventory();
								cooldown.add(p.getName());
								//int distance = (int) Math.round(p.getLocation().distance(loc) / 2);
								//p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, distance, 0));
								new BukkitRunnable() {
									public void run() {
										if (cooldown.contains(p.getName())) {
											cooldown.remove(p.getName());
											p.sendMessage("§aNo longer on cooldown!");
											p.getInventory().setItem(8, KitUtil.setName(new ItemStack(Material.REDSTONE_TORCH_ON), "§9Flash's torch"));
										}
									}
								}.runTaskLater(Main.getPlugin(), 300L);
							}
						}
						
						
					} else {
						p.sendMessage("§cStill on cooldown!");
					}
				}
			}
		}
	}
	
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if (cooldown.contains(e.getEntity().getName())) {
			cooldown.remove(e.getEntity().getName());
		}
	}
}
