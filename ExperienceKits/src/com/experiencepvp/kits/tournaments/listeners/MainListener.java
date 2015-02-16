package com.experiencepvp.kits.tournaments.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.experiencepvp.kits.tournaments.maps.ExperienceMap;

public class MainListener implements Listener {
	
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if (e.getLine(1).equalsIgnoreCase("Event")
				&& e.getLine(2).equalsIgnoreCase("Selector")) {
			e.setLine(1, "§lEvent");
			e.setLine(2, "§9Selector");
		}
	}
	
	
//	@EventHandler
//	public void onInvClick(InventoryClickEvent e) {
//		if (e.getInventory().getTitle() == TourneyUI.getInv().getTitle()) {
//			e.setCancelled(true);
//		}
//		
//		if (e.getWhoClicked() instanceof Player) {
//			Player p = (Player) e.getWhoClicked();
//			if (e.getInventory().getTitle() ==  TourneyUI.getInv().getTitle()) {
//				for (ExperienceMap m : ExperienceMap.values()) {
//					if (e.getCurrentItem().getDurability() != (short) -1) {
//						if (e.getCurrentItem().getDurability() == m.getItem().getDurability()) {
//							p.closeInventory();
//							Bukkit.dispatchCommand(p, "tourney host " + m.getId());
//						}
//					}
//				}
//			}
//		}
//	}
}
