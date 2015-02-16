package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.effects.GladiatorEffect;
import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

import de.slikey.effectlib.util.ParticleEffect;

public class Ninja implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("ninja")) {
			if (LevelUtil.getLevel(p, KitType.NINJA) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.NINJA.getUtil().giveKit(p, KitType.NINJA);
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

	private HashMap<String, String> ninja = new HashMap<String, String>();
	private ArrayList<String> cooldown = new ArrayList<String>();

	@EventHandler
	public void onNinja(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			Player damager = (Player) e.getDamager();
			Player entity = (Player) e.getEntity();
			if (KitHandler.getKit(damager.getName()) == KitType.NINJA
					&& Main.correctRegion(damager.getLocation())) {
				this.ninja.put(damager.getName(), entity.getName());
			}
		}
	}
	
	@EventHandler
	public void onNinjaSneak(PlayerToggleSneakEvent e){
		final Player p = e.getPlayer();
		if(e.isSneaking()){
			if(KitHandler.getKit(p.getName()) == KitType.NINJA){
				if(ninja.containsKey(p.getName())){
					Player p2 = Bukkit.getServer().getPlayer(ninja.get(p.getName()));
					if(p2 != null && p2 != p){
						if(Main.correctRegion(p2.getLocation()) && Main.correctRegion(p.getLocation())){
							if(!cooldown.contains(p.getName())){
								GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.LARGE_SMOKE);
								eff.setLocation(p.getLocation());
								eff.start();
								p.teleport(p2.getLocation());
								ninja.remove(p.getName());
								cooldown.add(p.getName());
								if(KitHandler.getLevel(p.getName()) == 1){
									new BukkitRunnable(){
										public void run(){
											cooldown.remove(p.getName());
										}
									}.runTaskLater(Main.getPlugin(), 300);
								}else if(KitHandler.getLevel(p.getName()) == 2){
									new BukkitRunnable(){
										public void run(){
											cooldown.remove(p.getName());
										}
									}.runTaskLater(Main.getPlugin(), 200);
								}else if(KitHandler.getLevel(p.getName()) == 3){
									new BukkitRunnable(){
										public void run(){
											cooldown.remove(p.getName());
										}
									}.runTaskLater(Main.getPlugin(), 140);
								}else if(KitHandler.getLevel(p.getName()) == 4){
									new BukkitRunnable(){
										public void run(){
											cooldown.remove(p.getName());
										}
									}.runTaskLater(Main.getPlugin(), 100);
								}
							}else{
								p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
							}
						}
					}else{
						p.sendMessage(Main.pref + ChatColor.RED + "The player you hit is no longer online!");
					}
				}
			}
		}
	}

	@EventHandler
	public void onCombat(PlayerDeathEvent e) {
		if (ninja.containsKey(e.getEntity())
				|| ninja.containsValue(e.getEntity()))
			ninja.remove(e.getEntity());
	}
}