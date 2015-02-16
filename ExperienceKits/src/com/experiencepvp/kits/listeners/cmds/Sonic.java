package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Color;
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
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.effects.PhantomEffect;
import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

import de.slikey.effectlib.util.ParticleEffect;

public class Sonic implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("sonic")) {
			if (LevelUtil.getLevel(p, KitType.SONIC) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.SONIC.getUtil().giveKit(p, KitType.SONIC);
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
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		
		final ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		meta.setColor(Color.fromRGB(0, 128, 255));
		item.setItemMeta(meta);
		
		if (KitHandler.getKit(p.getName()) == KitType.SONIC && Main.correctRegion(p.getLocation())) {
			if (p.getItemInHand() != null) {
				if (p.getItemInHand().getType() == Material.LEATHER_BOOTS) {
					if (!cooldown.contains(p.getName())){
						p.setWalkSpeed(0.5F);
						
						final PhantomEffect eff = new PhantomEffect(Main.em, ParticleEffect.SPELL);
						eff.setEntity(p);
						eff.start();
						
						p.getInventory().setItem(8, item);
						cooldown.add(p.getName());
						p.sendMessage(Main.pref + ChatColor.BLUE + "You've recieved your massive speed boost!");
							
						if(KitHandler.getLevel(p.getName()) == 1){
							new BukkitRunnable() {
								public void run() {
									p.setWalkSpeed(0.2F);
									p.sendMessage(Main.pref + ChatColor.RED + "You've lost your massive speed boost!");
									p.getInventory().setBoots(null);
									p.getInventory().setItem(8, item);
									eff.cancel();
									
								}
							}.runTaskLater(Main.getPlugin(), 100);
								
							new BukkitRunnable() {
								public void run() {
									if (cooldown.contains(p.getName())) {
										cooldown.remove(p.getName());
										p.sendMessage(Main.pref + ChatColor.BLUE + "No longer on cooldown!");
									}
								}
							}.runTaskLater(Main.getPlugin(), 700);
						}else if(KitHandler.getLevel(p.getName()) == 2){
							new BukkitRunnable() {
								public void run() {
									p.setWalkSpeed(0.2F);
									p.sendMessage(Main.pref + ChatColor.RED + "You've lost your massive speed boost!");
									p.getInventory().setBoots(null);
									p.getInventory().setItem(8, item);
									eff.cancel();
								}
							}.runTaskLater(Main.getPlugin(), 140);
								
							new BukkitRunnable() {
								public void run() {
									if (cooldown.contains(p.getName())) {
										cooldown.remove(p.getName());
										p.sendMessage(Main.pref + ChatColor.BLUE + "No longer on cooldown!");
									}
								}
							}.runTaskLater(Main.getPlugin(), 600);
						}else if(KitHandler.getLevel(p.getName()) == 3){
							new BukkitRunnable() {
								public void run() {
									p.setWalkSpeed(0.2F);
									p.sendMessage(Main.pref + ChatColor.RED + "You've lost your massive speed boost!");
									p.getInventory().setBoots(null);
									p.getInventory().setItem(8, item); 
									eff.cancel();
								}
							}.runTaskLater(Main.getPlugin(), 140);
								
							new BukkitRunnable() {
								public void run() {
									if (cooldown.contains(p.getName())) {
										cooldown.remove(p.getName());
										p.sendMessage(Main.pref + ChatColor.BLUE + "No longer on cooldown!");
									}
								}
							}.runTaskLater(Main.getPlugin(), 500);
						}else if(KitHandler.getLevel(p.getName()) == 4){
							new BukkitRunnable() {
								public void run() {
									p.setWalkSpeed(0.2F);
									p.sendMessage(Main.pref + ChatColor.RED + "You've lost your massive speed boost!");
									p.getInventory().setBoots(null);
									p.getInventory().setItem(8, item);
									eff.cancel();
								}
							}.runTaskLater(Main.getPlugin(), 200);
								
							new BukkitRunnable() {
								public void run() {
									if (cooldown.contains(p.getName())) {
										cooldown.remove(p.getName());
										p.sendMessage(Main.pref + ChatColor.BLUE + "No longer on cooldown!");
									}
								}
							}.runTaskLater(Main.getPlugin(), 400);
						}
							
					} else {
						p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
						
						e.setCancelled(true);
						p.updateInventory();
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if (cooldown.contains(p.getName())) {
			cooldown.remove(p.getName());
		}
	}
}
