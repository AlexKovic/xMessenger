package com.experiencepvp.preferences;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.scoreboard.ScoreboardMain;

public class PreferencesListener implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (settings.getData().getConfigurationSection("preferences." + p.getUniqueId()) == null) {
			settings.getData().set("preferences." + p.getUniqueId() + ".scoreboard", true);
			settings.getData().set("preferences." + p.getUniqueId() + ".kititem", 9);
			settings.getData().set("preferences." + p.getUniqueId() + ".sword", 1);
		}
	}

	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		if (e.getWhoClicked() instanceof Player) {
			final Player p = (Player) e.getWhoClicked();
			if (e.getInventory().getTitle().equalsIgnoreCase(PreferencesUI.getPrefencesInv(p).getTitle())) {
				e.setCancelled(true);
				
				//SCOREBOARD
				if (e.getCurrentItem().getType() == Material.ANVIL) {
					if (PreferencesUtil.wantsScoreboard(p)) {
						PreferencesUtil.setScoreboard(p);
						ScoreboardMain.removeScoreboard(p);
						for(int i = 0; i < 45; i++){
							e.getInventory().setItem(i, PreferencesUI.getPrefencesInv(p).getItem(i)); 
						}
					} else {
						PreferencesUtil.setScoreboard(p);
						ScoreboardMain.setScoreboard(p);
//						p.closeInventory();
//						new BukkitRunnable() {
//							public void run() {
//								p.openInventory(PreferencesUI.getPrefencesInv(p));
//							} 
//						}.runTaskLater(Main.getPlugin(), 1L);
						for(int i = 0; i < 45; i++){
							e.getInventory().setItem(i, PreferencesUI.getPrefencesInv(p).getItem(i));
						}
					}
					
					// KIT ITEM
				} else if (e.getCurrentItem().getType() == Material.LEASH) {
					// RIGHT
					if (e.getClick() == ClickType.RIGHT) {
						if (PreferencesUtil.getKitItemSlot(p) < 9) {
							PreferencesUtil.setKitItemSlot(p, PreferencesUtil.getKitItemSlot(p) + 1);
							for(int i = 0; i < 45; i++){
								e.getInventory().setItem(i, PreferencesUI.getPrefencesInv(p).getItem(i));
							}
						} else if (PreferencesUtil.getKitItemSlot(p) == 9) {
							PreferencesUtil.setKitItemSlot(p, 1);
							for(int i = 0; i < 45; i++){
								e.getInventory().setItem(i, PreferencesUI.getPrefencesInv(p).getItem(i));
							}
						} 
						
					// LEFT	
					} else if (e.getClick() == ClickType.LEFT) {
						if (PreferencesUtil.getKitItemSlot(p) > 1) {
							PreferencesUtil.setKitItemSlot(p, PreferencesUtil.getSwordSlot(p) - 1);
							for(int i = 0; i < 45; i++){
								e.getInventory().setItem(i, PreferencesUI.getPrefencesInv(p).getItem(i));
							}
						} else if (PreferencesUtil.getKitItemSlot(p) == 1) {
							PreferencesUtil.setKitItemSlot(p, 9);
							for(int i = 0; i < 45; i++){
								e.getInventory().setItem(i, PreferencesUI.getPrefencesInv(p).getItem(i));
							}
						}
					}
					
				// SWORD
				} else if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
					// RIGHT
					if (e.getClick() == ClickType.RIGHT) {
						if (PreferencesUtil.getSwordSlot(p) < 9) {
							PreferencesUtil.setSwordSlot(p, PreferencesUtil.getSwordSlot(p) + 1);
							p.closeInventory();
							new BukkitRunnable() {
								public void run() {
									p.openInventory(PreferencesUI.getPrefencesInv(p));
								}
							}.runTaskLater(Main.getPlugin(), 1L);
						} else if (PreferencesUtil.getSwordSlot(p) == 9) {
							PreferencesUtil.setSwordSlot(p, 1);
							p.closeInventory();
							new BukkitRunnable() {
								public void run() {
									p.openInventory(PreferencesUI.getPrefencesInv(p));
								}
							}.runTaskLater(Main.getPlugin(), 1L);
						} 
						
					// LEFT	
					} else if (e.getClick() == ClickType.LEFT) {
						if (PreferencesUtil.getSwordSlot(p) > 1) {
							PreferencesUtil.setSwordSlot(p, PreferencesUtil.getSwordSlot(p) - 1);
							p.closeInventory();
							new BukkitRunnable() {
								public void run() {
									p.openInventory(PreferencesUI.getPrefencesInv(p));
								}
							}.runTaskLater(Main.getPlugin(), 1L);
						} else if (PreferencesUtil.getSwordSlot(p) == 1) {
							PreferencesUtil.setSwordSlot(p, 9);
							p.closeInventory();
							new BukkitRunnable() {
								public void run() {
									p.openInventory(PreferencesUI.getPrefencesInv(p));
								}
							}.runTaskLater(Main.getPlugin(), 1L);
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand() != null && p.getItemInHand().getType() == Material.REDSTONE_COMPARATOR) {
			p.openInventory(PreferencesUI.getPrefencesInv(p));
		}
	}
}
