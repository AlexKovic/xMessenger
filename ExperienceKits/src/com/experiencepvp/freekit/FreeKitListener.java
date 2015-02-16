package com.experiencepvp.freekit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class FreeKitListener implements Listener {

	
	@EventHandler
	public void onSignClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block b = e.getClickedBlock();
			if (b.getType() == Material.WALL_SIGN || b.getType() == Material.SIGN_POST) {
				Sign sign = (Sign) b.getState();
				if (sign.getLine(1).equalsIgnoreCase(ChatColor.stripColor("Free Kit")) && sign.getLine(2).equalsIgnoreCase(ChatColor.stripColor("Selector"))) {
					if (FreeKitMain.canGetFreeKit(p)) {
						FreeKitMain.giveTempFreeKit(p);
					} else {
						p.sendMessage("§cSorry, but you've already chosen a kit today!");
					}
				}
			}
		}
	}
}
