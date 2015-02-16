package com.experiencepvp.kits.listeners.cmds;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.experiencepvp.effects.GladiatorEffect;
import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.tournaments.TourneyMain;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

import de.slikey.effectlib.util.ParticleEffect;

public class Stomper implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("stomper")) {
			if (LevelUtil.getLevel(p, KitType.STOMPER) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.STOMPER.getUtil().giveKit(p, KitType.STOMPER);
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

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if ((e.getEntity() instanceof Player)) {
			Player p = (Player) e.getEntity();
			Damageable neard = (Damageable) p;
			if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
				if (KitHandler.getKit(p.getName()) == KitType.STOMPER && Main.correctRegion(p.getLocation())) {
					GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.LAVA);
					eff.setLocation(p.getLocation());
					eff.start();
					List<Entity> ents = null;
					if(KitHandler.getLevel(p.getName()) == 1){
						ents = p.getNearbyEntities(3.0D, 3.0D, 3.0D);
					}else if(KitHandler.getLevel(p.getName()) == 2){
						ents = p.getNearbyEntities(4.0D, 4.0D, 4.0D);
					}else if(KitHandler.getLevel(p.getName()) == 3){
						ents = p.getNearbyEntities(4.0D, 4.0D, 4.0D);
					}else if(KitHandler.getLevel(p.getName()) == 4){
						ents = p.getNearbyEntities(5.0D, 5.0D, 5.0D);
					}
					for (Entity entity : ents) {
						if ((entity instanceof Player)) {
							Player near = (Player) entity;
							if(!TourneyMain.invincible.contains(p.getName())){
								if(!KitHandler.hasKit(near.getName(), KitType.ANTISTOMPER)){
									if(KitHandler.getLevel(p.getName()) == 1){
										double cdmg = 0.0;
										if(e.getDamage() > 5.0){
											cdmg = 5.0;
										}else{
											cdmg = e.getDamage();
										}
										
										if (!near.isSneaking()) {
											near.damage(0.0, p);
											near.setHealth(neard.getHealth() - cdmg < 0.0 ? 0.0 : neard.getHealth() - cdmg);
										}
									}else if(KitHandler.getLevel(p.getName()) == 2){
										double cdmg = 0.0;
										if(e.getDamage() > 6.0){
											cdmg = 6.0;
										}else{
											cdmg = e.getDamage();
										}
										
										if (!near.isSneaking()) {
											near.damage(0.0, p);
											near.setHealth(neard.getHealth() - cdmg < 0.0 ? 0.0 : neard.getHealth() - cdmg);
										}
									}else if(KitHandler.getLevel(p.getName()) == 3){
										double cdmg = 0.0;
										if(e.getDamage() > 8.0){
											cdmg = 8.0;
										}else{
											cdmg = e.getDamage();
										}
										
										if (!near.isSneaking()) {
											near.damage(0.0, p);
											near.setHealth(neard.getHealth() - cdmg < 0.0 ? 0.0 : neard.getHealth() - cdmg);
										}
									}else if(KitHandler.getLevel(p.getName()) == 4){
										if (!near.isSneaking()) {
											near.damage(0.0, p);
											near.setHealth(neard.getHealth() - e.getDamage() < 0.0 ? 0.0 : neard.getHealth() - e.getDamage());
										}
									}
									
									
								}else{
									if(KitHandler.getLevel(near.getName()) == 1){
										p.sendMessage(Main.pref + ChatColor.GOLD + near.getName() + ChatColor.RED + " was a AntiStomper!");
										near.sendMessage(Main.pref + ChatColor.GOLD + p.getName() + ChatColor.BLUE + " tried to stomp you!");
									}else if(KitHandler.getLevel(near.getName()) == 2){
										p.damage(0.0, near);
										p.setHealth(neard.getHealth() - 2.0);
										p.sendMessage(Main.pref + ChatColor.GOLD + near.getName() + ChatColor.RED + " was a AntiStomper, you took 2 extra hearts of damage!");
										near.sendMessage(Main.pref + ChatColor.GOLD + p.getName() + ChatColor.BLUE + " tried to stomp you and took 2 hearts of damage!");										
									}else if(KitHandler.getLevel(near.getName()) == 3){
										p.damage(0.0, near);
										p.setHealth(neard.getHealth() - 4.0);
										p.sendMessage(Main.pref + ChatColor.GOLD + near.getName() + ChatColor.RED + " was a AntiStomper, you took 4 extra hearts of damage!");
										near.sendMessage(Main.pref + ChatColor.GOLD + p.getName() + ChatColor.BLUE + " tried to stomp you and took 4 extra hearts of damage!");											
									}else if(KitHandler.getLevel(near.getName()) == 4){
										p.damage(0.0, near);
										p.setHealth(neard.getHealth() - 7.0);
										p.sendMessage(Main.pref + ChatColor.GOLD + near.getName() + ChatColor.RED + " was a AntiStomper, you took 7 extra hearts of damage!");
										near.sendMessage(Main.pref + ChatColor.GOLD + p.getName() + ChatColor.BLUE + " tried to stomp you and took 7 extra hearts of damage!");											
									}
								}
							}
						}
					}
					if (e.getDamage() > 4.0D)
						e.setDamage(4.0D);
				}
			}
		}
	}
}
