package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
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

public class Turtle implements Listener, CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("turtle")) {
			if (LevelUtil.getLevel(p, KitType.TURTLE) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.TURTLE.getUtil().giveKit(p, KitType.TURTLE);
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
	
	public HashMap<String, Integer> secsneak = new HashMap<String, Integer>();
	public HashMap<String, Boolean> timerb = new HashMap<String, Boolean>();
	public HashMap<String, PhantomEffect> effhash = new HashMap<String, PhantomEffect>();
	public ArrayList<String> cd = new ArrayList<String>();
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (KitHandler.getKit(p.getName()) == KitType.TURTLE && Main.correctRegion(p.getLocation())) {
				if ((e.getCause() == DamageCause.BLOCK_EXPLOSION) || 
				(e.getCause() == DamageCause.CONTACT) || 
				(e.getCause() == DamageCause.CUSTOM) ||
				(e.getCause() ==  DamageCause.DROWNING ||
				(e.getCause() == DamageCause.ENTITY_ATTACK) ||
				(e.getCause() == DamageCause.ENTITY_EXPLOSION) ||
				(e.getCause() == DamageCause.FALL) ||
				(e.getCause() == DamageCause.FALLING_BLOCK) ||
				(e.getCause() == DamageCause.FIRE) ||
				(e.getCause() == DamageCause.FIRE_TICK) ||
				(e.getCause() == DamageCause.LAVA) || 
				(e.getCause() == DamageCause.LIGHTNING) ||
				(e.getCause() == DamageCause.MAGIC) ||
				(e.getCause() == DamageCause.MELTING) ||
				(e.getCause() == DamageCause.POISON) ||
				(e.getCause() == DamageCause.PROJECTILE) ||
				(e.getCause() == DamageCause.STARVATION) ||
				(e.getCause() == DamageCause.SUFFOCATION) || 
				(e.getCause() == DamageCause.SUICIDE) ||
				(e.getCause() == DamageCause.THORNS) ||
				(e.getCause() == DamageCause.VOID) ||
				(e.getCause() == DamageCause.WITHER))) {
					if(p.isSneaking()) {
						if(cd.contains(p.getName())){
							p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
							return;
						}
						e.setDamage(2D);
						if(!secsneak.containsKey(p.getName())){
							secsneak.put(p.getName(), 0);
						}
						
						if(KitHandler.getLevel(p.getName()) != 4 && !timerb.get(p.getName())){
							new BukkitRunnable(){
								public void run(){
									timerb.put(p.getName(), true);
									if(p.isSneaking()){
										if(effhash.containsKey(p.getName())){
											effhash.get(p.getName()).cancel();
											effhash.remove(p.getName());
										}
										effhash.put(p.getName(), new PhantomEffect(Main.em, ParticleEffect.SLIME));
										effhash.get(p.getName()).setEntity(p);
										effhash.get(p.getName()).start();
										secsneak.put(p.getName(), secsneak.get(p.getName()) + 1);
										if(KitHandler.getLevel(p.getName()) == 1){
											if(secsneak.get(p.getName()) >= 10){
												cd.add(p.getName());
												p.sendMessage(Main.pref + ChatColor.RED + "You are now on cooldown for 20 seconds!");
												if(effhash.containsKey(p.getName())){
													effhash.get(p.getName()).cancel();
													effhash.remove(p.getName());
												}
												new BukkitRunnable(){
													public void run(){
														cd.remove(p.getName());
														p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
													}
												}.runTaskLater(Main.getPlugin(), 400);
												timerb.put(p.getName(), false);
												this.cancel();
											}
										}else if(KitHandler.getLevel(p.getName()) == 2){
											if(secsneak.get(p.getName()) >= 10){
												cd.add(p.getName());
												p.sendMessage(Main.pref + ChatColor.RED + "You are now on cooldown for 20 seconds!");
												if(effhash.containsKey(p.getName())){
													effhash.get(p.getName()).cancel();
													effhash.remove(p.getName());
												}
												new BukkitRunnable(){
													public void run(){
														cd.remove(p.getName());
														p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
													}
												}.runTaskLater(Main.getPlugin(), 400);
												timerb.put(p.getName(), false);
												this.cancel();
											}
										}else if(KitHandler.getLevel(p.getName()) == 3){
											if(secsneak.get(p.getName()) >= 10){
												cd.add(p.getName());
												p.sendMessage(Main.pref + ChatColor.RED + "You are now on cooldown for 20 seconds!");
												if(effhash.containsKey(p.getName())){
													effhash.get(p.getName()).cancel();
													effhash.remove(p.getName());
												}
												new BukkitRunnable(){
													public void run(){
														cd.remove(p.getName());
														p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
													}
												}.runTaskLater(Main.getPlugin(), 400);
												timerb.put(p.getName(), false);
												this.cancel();
											}
										}
									}else{
										timerb.put(p.getName(), false);
										this.cancel();
										if(effhash.containsKey(p.getName())){
											effhash.get(p.getName()).cancel();
											effhash.remove(p.getName());
										}
									}
								}
							}.runTaskTimer(Main.getPlugin(), 10, 20);
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
		if (e.getEntityType() == EntityType.PLAYER && e.getDamager().getType() == EntityType.PLAYER) {
			Player dmg = (Player) e.getDamager();
			if (KitHandler.getKit(dmg.getName()) == KitType.TURTLE) {
				if (dmg.isSneaking()) {
					e.setCancelled(true);
				}
			}
		}
	}
}
