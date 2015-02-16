package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.kits.utils.Tornado;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Elemental implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("elemental")) {
			if (LevelUtil.getLevel(p, KitType.ELEMENTAL) > 0 && p.isOp()){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.ELEMENTAL.getUtil().giveKit(p, KitType.ELEMENTAL);
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
	
	public ArrayList<String> cd = new ArrayList<String>();
	
	@EventHandler
	public void onSpawnTornado(PlayerInteractEvent e){
		final Player p = e.getPlayer();
		if(e.getPlayer().getItemInHand().getType() == Material.EMERALD && KitHandler.getKit(p.getName()) == KitType.ELEMENTAL && e.getClickedBlock() != null && e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(!cd.contains(p.getName())){
				cd.add(p.getName());
				Location loc = e.getClickedBlock().getLocation();
				Random r = new Random();
				Vector vec = new Vector(2, 0, 2);
				double speed = 0.3;
				
				if((r.nextInt(4) + 1) == 1){
					vec = new Vector(2, 0, 2);
					speed = 0.3;
				}else if((r.nextInt(4) + 1) == 2){
					vec = new Vector(-2, 0, 2);
					speed = 0.4;
				}else if((r.nextInt(4) + 1) == 3){
					vec = new Vector(2, 0, -2);
					speed = 0.5;
				}else if((r.nextInt(4) + 1) == 4){
					vec = new Vector(-2, 0, -2);
					speed = 0.6;
				}
				Tornado.spawnTornado((JavaPlugin) Main.getPlugin(), 
						loc, 
						Material.DIRT, (byte) 0, 
						vec, 
						speed,
						300, 
						400, 
						false, 
						false,
						(Entity) p);
				
				new BukkitRunnable(){
					public void run(){
						cd.remove(p.getName());
					}
				}.runTaskLater(Main.getPlugin(), 900);
			}else{
				p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
			}
		}
	}
	
}
