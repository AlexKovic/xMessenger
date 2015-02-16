package com.experiencepvp.kits.listeners.cmds;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Snail implements Listener, CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("snail")) {
			if (LevelUtil.getLevel(p, KitType.SNAIL) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.SNAIL.getUtil().giveKit(p, KitType.SNAIL);
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
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player p = (Player) e.getEntity();
			Player dmg = (Player) e.getDamager();
			if (KitHandler.getKit(dmg.getName()) == KitType.SNAIL && Main.correctRegion(dmg.getLocation()) && Main.correctRegion(p.getLocation())) {
				Random r = new Random();
				int chance = r.nextInt(2);
				if (chance == 0) {
					if(KitHandler.getLevel(p.getName()) == 1){
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 0));
					}else if(KitHandler.getLevel(p.getName()) == 2){
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 0));						
					}else if(KitHandler.getLevel(p.getName()) == 3){
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0));						
					}else if(KitHandler.getLevel(p.getName()) == 4){
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));	
					}
				}
			}
		}
	}
}
