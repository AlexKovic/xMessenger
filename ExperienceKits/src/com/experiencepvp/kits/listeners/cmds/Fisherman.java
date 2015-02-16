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
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Fisherman implements Listener, CommandExecutor {

	public ArrayList<String> fishcd = new ArrayList<String>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("fisherman")) {
			if (LevelUtil.getLevel(p, KitType.FISHERMAN) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())){
					KitType.FISHERMAN.getUtil().giveKit(p, KitType.FISHERMAN);
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
	public void onThrowLine(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(p.getInventory().getItemInHand().getType() == Material.FISHING_ROD){
				if(fishcd.contains(p.getName())){
					e.setCancelled(true);
					p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
				}
			}
		}
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onFish(PlayerFishEvent e) {
		final Player player = e.getPlayer();
		if (KitHandler.getKit(player.getName()) == KitType.FISHERMAN && Main.correctRegion(player.getLocation())) {
			if ((e.getCaught() != null) && (e.getCaught() != player)) {
				e.getCaught().teleport(player);
				player.getItemInHand().setDurability((short) 0);
				
				fishcd.add(player.getName());
				
				new BukkitRunnable(){
					public void run(){
						fishcd.remove(player.getName());
					}
				}.runTaskLater(Main.getPlugin(), 60);
			}
		}
	}
}
