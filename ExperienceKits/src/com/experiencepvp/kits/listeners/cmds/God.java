package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class God implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("god")) {
			if (LevelUtil.getLevel(p, KitType.GOD) > 0 && p.isOp()){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.GOD.getUtil().giveKit(p, KitType.GOD);
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
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onGod(PlayerInteractEvent e){
		final Player p = e.getPlayer();
		if(e.getPlayer().getItemInHand().getType() == Material.BLAZE_POWDER && KitHandler.getKit(p.getName()) == KitType.GOD && e.getClickedBlock() != null && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)){
			e.setCancelled(true);
			if (!cd.contains(p.getName())) {
				cd.add(p.getName());
				double y = p.getTargetBlock(null, 300).getY() - 1;
				double x = p.getTargetBlock(null, 300).getX();
				double z = p.getTargetBlock(null, 300).getZ();
				World w = p.getTargetBlock(null, 300).getWorld();
				Location loc = new Location(w, x, y, z);

				w.createExplosion(loc, 8.0F);
				new BukkitRunnable(){
					public void run(){
						cd.remove(p.getName());
					}
				}.runTaskLater(Main.getPlugin(), 400);
			} else {
				p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
			}
		}
	}
}






