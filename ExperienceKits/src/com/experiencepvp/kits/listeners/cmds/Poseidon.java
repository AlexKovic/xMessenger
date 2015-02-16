package com.experiencepvp.kits.listeners.cmds;

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
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.experiencepvp.effects.PhantomEffect;
import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

import de.slikey.effectlib.util.ParticleEffect;

public class Poseidon implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("poseidon")) {
			if (LevelUtil.getLevel(p, KitType.POSEIDON) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.POSEIDON.getUtil().giveKit(p, KitType.POSEIDON);
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
	
	public HashMap<String, PhantomEffect> effhash = new HashMap<String, PhantomEffect>();
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (KitHandler.getKit(p.getName()) == KitType.POSEIDON) {
			if (p.getLocation().getBlock().getType() == Material.WATER || p.getLocation().getBlock().getType() == Material.STATIONARY_WATER) {
				if(KitHandler.getLevel(p.getName()) == 1){
					p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0));
					if(effhash.containsKey(p.getName())){
						effhash.get(p.getName()).cancel();
						effhash.remove(p.getName());
					}
					effhash.put(p.getName(), new PhantomEffect(Main.em, ParticleEffect.BUBBLE));
					effhash.get(p.getName()).setEntity(p);
					effhash.get(p.getName()).start();
				}else if(KitHandler.getLevel(p.getName()) == 2){
					p.removePotionEffect(PotionEffectType.SPEED);
					p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 0));
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0));
					if(effhash.containsKey(p.getName())){
						effhash.get(p.getName()).cancel();
						effhash.remove(p.getName());
					}
					effhash.put(p.getName(), new PhantomEffect(Main.em, ParticleEffect.BUBBLE));
					effhash.get(p.getName()).setEntity(p);
					effhash.get(p.getName()).start();
				}else if(KitHandler.getLevel(p.getName()) == 3){
					p.removePotionEffect(PotionEffectType.SPEED);
					p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0));
					if(effhash.containsKey(p.getName())){
						effhash.get(p.getName()).cancel();
						effhash.remove(p.getName());
					}
					effhash.put(p.getName(), new PhantomEffect(Main.em, ParticleEffect.BUBBLE));
					effhash.get(p.getName()).setEntity(p);
					effhash.get(p.getName()).start();
				}else if(KitHandler.getLevel(p.getName()) == 4){
					p.removePotionEffect(PotionEffectType.SPEED);
					p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 1));	
					if(effhash.containsKey(p.getName())){
						effhash.get(p.getName()).cancel();
						effhash.remove(p.getName());
					}
					effhash.put(p.getName(), new PhantomEffect(Main.em, ParticleEffect.BUBBLE));
					effhash.get(p.getName()).setEntity(p);
					effhash.get(p.getName()).start();				
				}
			}
		}
	}
}
