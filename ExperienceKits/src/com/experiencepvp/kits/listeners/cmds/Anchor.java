package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.tournaments.TourneyMain;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Anchor implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("anchor")) {
			if (LevelUtil.getLevel(p, KitType.ANCHOR) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.ANCHOR.getUtil().giveKit(p, KitType.ANCHOR);
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

	public ArrayList<String> anchormode = new ArrayList<String>();
	public ArrayList<String> anchorcd = new ArrayList<String>();
	
	@EventHandler
	public void onClickAnvil(PlayerInteractEvent e){
		final Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR){
			if(p.getInventory().getItemInHand().getType() == Material.ANVIL){
				if(!anchorcd.contains(p.getName())){
					if(KitHandler.getLevel(p.getName()) == 1){
						anchormode.add(p.getName());
						anchorcd.add(p.getName());
						p.sendMessage(Main.pref + ChatColor.BLUE + "You will no longer be able to take or deal knockback for 10 seconds!");
						new BukkitRunnable(){
							public void run(){
								anchormode.remove(p.getName());
								p.sendMessage(Main.pref + ChatColor.RED + "You can take and deal knockback again!");
							}
						}.runTaskLater(Main.getPlugin(), 200);
						
						new BukkitRunnable(){
							public void run(){
								anchorcd.remove(p.getName());
								p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
							}
						}.runTaskLater(Main.getPlugin(), 400);
					}else if(KitHandler.getLevel(p.getName()) == 2){
						anchormode.add(p.getName());
						anchorcd.add(p.getName());
						p.sendMessage(Main.pref + ChatColor.BLUE + "You will no longer be able to take or deal knockback for 10 seconds!");
						new BukkitRunnable(){
							public void run(){
								anchormode.remove(p.getName());
								p.sendMessage(Main.pref + ChatColor.RED + "You can take and deal knockback again!");
							}
						}.runTaskLater(Main.getPlugin(), 200);
						
						new BukkitRunnable(){
							public void run(){
								anchorcd.remove(p.getName());
								p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
							}
						}.runTaskLater(Main.getPlugin(), 200);
					}else if(KitHandler.getLevel(p.getName()) == 3){
						anchormode.add(p.getName());
						anchorcd.add(p.getName());
						p.sendMessage(Main.pref + ChatColor.BLUE + "You will no longer be able to take or deal knockback for 10 seconds!");
						new BukkitRunnable(){
							public void run(){
								anchormode.remove(p.getName());
								p.sendMessage(Main.pref + ChatColor.RED + "You can take and deal knockback again!");
							}
						}.runTaskLater(Main.getPlugin(), 200);
						
						new BukkitRunnable(){
							public void run(){
								anchorcd.remove(p.getName());
								p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
							}
						}.runTaskLater(Main.getPlugin(), 100);
					}
				}else{
					p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
				}
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDamage(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (KitHandler.getKit(p.getName()) == KitType.ANCHOR) {
				if (Main.correctRegion(p.getLocation())) {
					if(!TourneyMain.invincible.contains(p.getName())){
						if(KitHandler.getLevel(p.getName()) > 0 && KitHandler.getLevel(p.getName()) < 4){
							if(anchormode.contains(p.getName())){
								new BukkitRunnable(){
									public void run(){
										p.setVelocity(new Vector(0, 0, 0));
										p.getWorld().playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
										return;
									}
								}.runTaskLater(Main.getPlugin(), 1);
							}
						}else{
							new BukkitRunnable(){
								public void run(){
									p.setVelocity(new Vector(0, 0, 0));
									p.getWorld().playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
									return;
								}
							}.runTaskLater(Main.getPlugin(), 1);
						}
					}
				}
			}
		}
		if (e.getDamager() instanceof Player) {
			final Player p = (Player) e.getDamager();
			if (KitHandler.getKit(p.getName()) == KitType.ANCHOR) {
				if (Main.correctRegion(p.getLocation())) {
					if (e.getEntity() instanceof Damageable) {
						if(!TourneyMain.invincible.contains(p.getName())){
							if(KitHandler.getLevel(p.getName()) > 0 && KitHandler.getLevel(p.getName()) < 4){
								if(anchormode.contains(p.getName())){
									new BukkitRunnable(){
										public void run(){
											e.getEntity().setVelocity(new Vector(0, 0, 0));
											e.getEntity().getWorld().playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
											return;
										}
									}.runTaskLater(Main.getPlugin(), 1);
								}
							}else{
								new BukkitRunnable(){
									public void run(){
										e.getEntity().setVelocity(new Vector(0, 0, 0));
										e.getEntity().getWorld().playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
										return;
									}
								}.runTaskLater(Main.getPlugin(), 1);
							}
						}
					}
				}
			}
		}
	}
}
