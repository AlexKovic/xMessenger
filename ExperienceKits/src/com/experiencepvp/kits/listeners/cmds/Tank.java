package com.experiencepvp.kits.listeners.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Tank implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("tank")) {
			if (LevelUtil.getLevel(p, KitType.TANK) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.TANK.getUtil().giveKit(p, KitType.TANK);
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
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if (p.getKiller() != null) {
			if (p.getKiller() instanceof Player) {
				Player k = p.getKiller();
				if (KitHandler.getKit(k.getName()) == KitType.TANK) {
					if(KitHandler.getLevel(p.getName()) == 1){
						p.getWorld().createExplosion(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ(), (float) 2.0, false, false);
					}else if(KitHandler.getLevel(p.getName()) == 2){
						p.getWorld().createExplosion(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ(), (float) 3.0, false, false);
					}else if(KitHandler.getLevel(p.getName()) == 3){
						p.getWorld().createExplosion(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ(), (float) 4.0, false, false);
					}else if(KitHandler.getLevel(p.getName()) == 4){
						p.getWorld().createExplosion(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ(), (float) 8.0, false, false);
					}					
				}
			}
		}
	}
	
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (KitHandler.getKit(p.getName()) == KitType.TANK) {
				if (e.getCause() == DamageCause.BLOCK_EXPLOSION || e.getCause() == DamageCause.ENTITY_EXPLOSION) {
					e.setCancelled(true);
				}
			}
		}
	}
}
