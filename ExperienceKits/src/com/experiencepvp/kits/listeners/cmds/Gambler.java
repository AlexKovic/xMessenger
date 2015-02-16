package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.effects.GladiatorEffect;
import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

import de.slikey.effectlib.effect.FlameEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class Gambler implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("gambler")) {
			if (LevelUtil.getLevel(p, KitType.GAMBLER) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.GAMBLER.getUtil().giveKit(p, KitType.GAMBLER);
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
	
	List<String> gambler = new ArrayList<String>();
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitHandler.getKit(p.getName()) == KitType.GAMBLER && Main.correctRegion(p.getLocation())) {
			if((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.WATCH) {
				if(!this.gambler.contains(p.getName())) {
					Random rand = new Random();
					int i = rand.nextInt(5);
					GladiatorEffect ge = new GladiatorEffect(Main.em, ParticleEffect.FLAME);
					ge.setEntity(p);
					ge.start();
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 250));
					if(i == 0) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 15 * 20, 0));
						p.sendMessage(ChatColor.GOLD + "You have got the poison effect!");
					} else if(i == 1) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 15 * 20, 0));
						p.sendMessage("" + ChatColor.GOLD + "You have got the regeneration effect!");
					} else if(i == 2) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 15 * 20, 0));
						p.sendMessage("" + ChatColor.GOLD + "You have got the strength effect!");
					} else if(i == 3) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 15 * 20, 0));
						p.sendMessage("" + ChatColor.GOLD + "You have got the weakness effect!");
					} else if(i == 4) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 15 * 20, 0));
						p.sendMessage("" + ChatColor.GOLD + "You have got the speed effect!");
					} else if(i == 5) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 15 * 20, 0));
						p.sendMessage("" + ChatColor.GOLD + "You have got the slowness effect!");
					}
					gambler.add(p.getName());
					Bukkit.getServer().getScheduler().
						scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() { 
							public void run() {
								gambler.remove(p.getName());
								p.sendMessage(ChatColor.GOLD + "You can now use your watch again!");
							}
						}, 30 * 20L);
				} else {
					p.sendMessage(ChatColor.GOLD + "Your gambler watch is still on cooldown!");
				}

			}
		}
	}
	
	@EventHandler
	public void onDeathRemove(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if (gambler.contains(p.getName())) {
			gambler.remove(p.getName());
		}
	}
}
