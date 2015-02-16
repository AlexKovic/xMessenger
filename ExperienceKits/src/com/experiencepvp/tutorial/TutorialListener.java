package com.experiencepvp.tutorial;

import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TutorialListener implements Listener {

	@EventHandler
	public void onDamageVillager(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Villager && e.getDamager() instanceof Player){
			Player p = (Player) e.getDamager();
			p.performCommand("tutorial");
		}
	}
	
	
	@EventHandler
	public void onClickInv(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getTitle().equalsIgnoreCase(TutorialInventory.getConfirmInv(p).getTitle())){
			TutorialMain.startTutorial(p);
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		if(TutorialMain.nomove.contains(e.getPlayer().getName())){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		if(TutorialMain.following.contains(e.getPlayer().getName())){
			TutorialMain.following.remove(e.getPlayer().getName());
		}
	}
}
