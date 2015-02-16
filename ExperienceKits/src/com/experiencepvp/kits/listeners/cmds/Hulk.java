package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.experiencepvp.effects.GladiatorEffect;
import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

import de.slikey.effectlib.util.ParticleEffect;

public class Hulk implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("hulk")) {
			if (LevelUtil.getLevel(p, KitType.HULK) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.HULK.getUtil().giveKit(p, KitType.HULK);
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
	public void hulk(PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (!(e.getRightClicked() instanceof Player))
			return;
		
		if(p.getInventory().getItemInHand().getType() != Material.SADDLE){
			return;
		}
		
		Player r = (Player) e.getRightClicked();
		final String pName = p.getName();
		if (KitHandler.getKit(pName) == KitType.HULK
				&& Main.correctRegion(p.getLocation())) {
			if (p.getPassenger() == null || !r.isInsideVehicle()) {
				if (!cooldown.contains(p.getName())) {
					p.setPassenger(r);
					GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.HAPPY_VILLAGER);
					eff.setEntity(r);
					eff.start();
					cooldown.add(p.getName());
					if(KitHandler.getLevel(p.getName()) == 1){
						new BukkitRunnable() {
							public void run() {
								if (cooldown.contains(p.getName())) {
									cooldown.remove(p.getName());
									p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
								}
							}
						}.runTaskLater(Main.getPlugin(), 200);
					}else if(KitHandler.getLevel(p.getName()) == 2){
						new BukkitRunnable() {
							public void run() {
								if (cooldown.contains(p.getName())) {
									cooldown.remove(p.getName());
									p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
								}
							}
						}.runTaskLater(Main.getPlugin(), 140);
					}else if(KitHandler.getLevel(p.getName()) == 3){
						new BukkitRunnable() {
							public void run() {
								if (cooldown.contains(p.getName())) {
									cooldown.remove(p.getName());
									p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
								}
							}
						}.runTaskLater(Main.getPlugin(), 100);
					}else if(KitHandler.getLevel(p.getName()) == 4){
						new BukkitRunnable() {
							public void run() {
								if (cooldown.contains(p.getName())) {
									cooldown.remove(p.getName());
									p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
								}
							}
						}.runTaskLater(Main.getPlugin(), 40);
					}
					
				} else {
					p.sendMessage(Main.pref + ChatColor.RED + " You are still on cooldown!");
				}
			}
		}
	}
	
	@EventHandler
	public void hitPassenger(EntityDamageByEntityEvent e){
		if((e.getEntity() instanceof Player) && (e.getDamager() instanceof Player)){
			Player p = (Player) e.getDamager();
			Player ent = (Player) e.getEntity();
			
			if(KitHandler.hasKit(p.getName(), KitType.HULK)){
				if(p.getPassenger() == ent) {
					e.setCancelled(true);
				}
			}
		}
	}

	@EventHandler
	public void ejectPassenger(PlayerInteractEvent event) {
		if (event.getAction().equals(Action.LEFT_CLICK_AIR)
				|| (event.getAction().equals(Action.LEFT_CLICK_BLOCK))) {
			Player thrower = event.getPlayer();
			Player toThrow = (Player) thrower.getPassenger();
			if (toThrow == null)
				return;
			final String pName = thrower.getName();
			if (KitHandler.getKit(pName) == KitType.HULK
					&& Main.correctRegion(thrower.getLocation())) {
				Vector dir = thrower.getLocation().getDirection();
				Vector vec = new Vector(dir.getX(), dir.getY(), dir.getZ());
				thrower.eject();
				toThrow.setVelocity(vec);
			}
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if (cooldown.contains(p.getName())) {
			cooldown.remove(p.getName());
		}
		if(p.getPassenger() != null){
			p.eject();
			p.getPassenger().eject();
		}
		if(p.getVehicle() != null){
			p.eject();
			p.getVehicle().eject();
		}
	}
}
