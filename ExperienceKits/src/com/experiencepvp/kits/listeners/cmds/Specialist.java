package com.experiencepvp.kits.listeners.cmds;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Specialist implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("specialist")) {
			if (LevelUtil.getLevel(p, KitType.SPECIALIST) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.SPECIALIST.getUtil().giveKit(p, KitType.SPECIALIST);
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
	public void onPlayerDeathEventSpecialist(PlayerDeathEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = e.getEntity();
			if (p.getKiller() instanceof Player) {
				Player killer = p.getKiller();
				if(KitHandler.getKit(killer.getName()) == KitType.SPECIALIST) {
					killer.getInventory().addItem(new ItemStack(Material.EXP_BOTTLE));
					e.setDroppedExp(10);
				}
			}
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		ItemStack item = e.getPlayer().getItemInHand();
		if (item != null && item.getType() == Material.BOOK)
			if (KitHandler.getKit(e.getPlayer().getName()) == KitType.SPECIALIST)
				e.getPlayer().openEnchanting(e.getPlayer().getLocation(), true);
	}
}
