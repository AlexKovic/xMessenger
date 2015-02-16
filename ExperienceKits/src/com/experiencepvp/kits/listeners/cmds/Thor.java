package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.effects.GladiatorEffect;
import com.experiencepvp.effects.PhantomEffect;
import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

import de.slikey.effectlib.util.ParticleEffect;

public class Thor implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("thor")) {
			if (LevelUtil.getLevel(p, KitType.THOR) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.THOR.getUtil().giveKit(p, KitType.THOR);
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

	public List<String> cooldown = new ArrayList<String>();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (KitHandler.getKit(p.getName()) == KitType.THOR && Main.correctRegion(p.getLocation())) {
				if (p.getItemInHand().getType() == Material.WOOD_AXE) {
					if (!cooldown.contains(p.getName())) {
						if(event.getClickedBlock() == null) return;
						Location loc = event.getClickedBlock().getLocation();
						World w = p.getWorld();
						w.strikeLightningEffect(loc);
						final GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.LARGE_SMOKE);
						eff.setLocation(loc);
						eff.start();
						for (Entity e : w.getEntities()) {
							loc.setY(e.getLocation().getY());
							if (e instanceof Player){
								if (e.getLocation().distance(loc) < 4){
									if (!(e == p)){
										if(KitHandler.getLevel(p.getName()) == 1){
											((Player) e).damage(2, p);
										}else if(KitHandler.getLevel(p.getName()) == 2){
											((Player) e).damage(4, p);
										}else if(KitHandler.getLevel(p.getName()) == 3){
											((Player) e).damage(6, p);
										}else if(KitHandler.getLevel(p.getName()) == 4){
											((Player) e).damage(8, p);
										}
										
									}
								}
							}
						}
						cooldown.add(p.getName());
						
						if(KitHandler.getLevel(p.getName()) == 1){
							new BukkitRunnable(){
								public void run(){
									cooldown.remove(p.getName());
								}
							}.runTaskLater(Main.getPlugin(), 200);
						}else if(KitHandler.getLevel(p.getName()) == 1){
							new BukkitRunnable(){
								public void run(){
									cooldown.remove(p.getName());
								}
							}.runTaskLater(Main.getPlugin(), 140);
						}else if(KitHandler.getLevel(p.getName()) == 1){
							new BukkitRunnable(){
								public void run(){
									cooldown.remove(p.getName());
								}
							}.runTaskLater(Main.getPlugin(), 140);
						}else if(KitHandler.getLevel(p.getName()) == 1){
							new BukkitRunnable(){
								public void run(){
									cooldown.remove(p.getName());
								}
							}.runTaskLater(Main.getPlugin(), 100);
						}
						
						cooldown.add(p.getName());
						Bukkit.getScheduler().scheduleSyncDelayedTask(
								Main.getPlugin(), new Runnable() {
									public void run() {
										if (cooldown.contains(p.getName())) {
											cooldown.remove(p.getName());
											p.sendMessage("§aYou are no longer on cooldown!");
										}
									}
								}, 100L);
					} else {
						p.sendMessage("§cYou are still on cooldown!");
					}
				}
			}
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player)
			if (event.getCause() == DamageCause.LIGHTNING) {
				if (KitHandler.getKit(((Player) event.getEntity()).getName()) == KitType.THOR) {
					event.setCancelled(true);
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
