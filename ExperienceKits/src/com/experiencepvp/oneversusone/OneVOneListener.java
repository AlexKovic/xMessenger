package com.experiencepvp.oneversusone;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class OneVOneListener implements Listener {

	public static ArrayList<String> lobby1v1 = new ArrayList<String>();
	public static ArrayList<String> fighting = new ArrayList<String>();
	public static ArrayList<String> cantmove = new ArrayList<String>();
	public static ArrayList<String> kit1v1 = new ArrayList<String>();
	
	public static HashMap<String, String> fightingwith = new HashMap<String, String>();
	public static HashMap<String, String> asked1v1player = new HashMap<String, String>();
	public static HashMap<String, String> player1v1player = new HashMap<String, String>();
	public static HashMap<String, Type1v1> player1v1type = new HashMap<String, Type1v1>();
	public static HashMap<String, Maps> player1v1maps = new HashMap<String, Maps>();
	
	@EventHandler
	public void onClick1v1(PlayerInteractEntityEvent e){
		Player p = e.getPlayer();
		if(!(e.getRightClicked() instanceof Player)){
			return;
		}
		
		Player clicked = (Player) e.getRightClicked();
		
		if(!lobby1v1.contains(p.getName()) || !lobby1v1.contains(p.getName())){
			return;
		}
		
		if(p.getInventory().getItemInHand().getType() != Material.BLAZE_ROD){
			return;
		}
		
		if(asked1v1player.containsKey(clicked.getName())){
			if(asked1v1player.get(clicked.getName()).equalsIgnoreCase(p.getName())){
				//accepted
				OneVOneMain.accept1v1(clicked, p);
			}
		}else{
			if(asked1v1player.containsKey(p.getName())){
				p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "Please wait until your request to " + ChatColor.GOLD + asked1v1player.get(p.getName()) + ChatColor.BLUE + " expires!");
				return;
			}
			player1v1player.put(p.getName(), clicked.getName());
			p.openInventory(OneVOneMain.getTypeInventory());
		}
		
	}
	
	@EventHandler
	public void onClick1v1Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equalsIgnoreCase(OneVOneMain.getTypeInventory().getTitle())){
			e.setCancelled(true);
			
			if(e.getCurrentItem().getType() == Material.STONE_SWORD){
				player1v1type.put(p.getName(), Type1v1.EHG);
				p.closeInventory();
				p.openInventory(OneVOneMain.getMapInventory());
			}else if(e.getCurrentItem().getType() == Material.PAPER){
				player1v1type.put(p.getName(), Type1v1.KIT);
				p.closeInventory();
				p.openInventory(OneVOneMain.getMapInventory());
			}else if(e.getCurrentItem().getType() == Material.MUSHROOM_SOUP){
				player1v1type.put(p.getName(), Type1v1.NORMALREFS);
				p.closeInventory();
				p.openInventory(OneVOneMain.getMapInventory());
			}else if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD){
				player1v1type.put(p.getName(), Type1v1.NORMALNOREFS);
				p.closeInventory();
				p.openInventory(OneVOneMain.getMapInventory());
			}else if(e.getCurrentItem().getType() == OneVOneUtil.potmat){
				player1v1type.put(p.getName(), Type1v1.HARDCORE);
				p.closeInventory();
				p.openInventory(OneVOneMain.getMapInventory());
			}
			
		}else if(e.getInventory().getTitle().equalsIgnoreCase(OneVOneMain.getMapInventory().getTitle())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.IRON_AXE){
				player1v1maps.put(p.getName(), Maps.CASTLE);
				OneVOneMain.challengePlayer(p, Bukkit.getServer().getPlayer(player1v1player.get(p.getName())));
				p.closeInventory();
			}
		}
	}
	
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		
		if(cantmove.contains(p.getName())){
			if(e.getFrom().getBlock().getLocation().getBlockX() != e.getTo().getBlock().getLocation().getBlockX() || e.getFrom().getBlock().getLocation().getBlockZ() != e.getTo().getBlock().getLocation().getBlockZ()){
				p.teleport(e.getFrom());
			}
		}
	}
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			Player p = (Player) e.getEntity();
			Player d = (Player) e.getDamager();
			if(cantmove.contains(p.getName()) || cantmove.contains(d.getName())){
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player ent = e.getEntity();
		
		if(fighting.contains(ent.getName())){
			Player p = Bukkit.getServer().getPlayer(fightingwith.get(ent.getName()));
			OneVOneMain.handleWin(p, ent.getName());
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player ent = e.getPlayer();
		OneVOneListener.asked1v1player.remove(ent.getName());
		OneVOneListener.cantmove.remove(ent.getName());
		OneVOneListener.fighting.remove(ent.getName());
		OneVOneListener.fightingwith.remove(ent.getName());
		OneVOneListener.lobby1v1.remove(ent.getName());
		OneVOneListener.player1v1maps.remove(ent.getName());
		OneVOneListener.player1v1player.remove(ent.getName());
		OneVOneListener.player1v1type.remove(ent.getName());
		OneVOneListener.kit1v1.remove(ent.getName());
		if(fighting.contains(ent.getName())){
			Player p = Bukkit.getServer().getPlayer(fightingwith.get(ent.getName()));
			OneVOneMain.handleWin(p, ent.getName());
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		for(String s : fighting){
			Player f = Bukkit.getServer().getPlayer(s);
			f.hidePlayer(p);
			p.hidePlayer(f);
		}
		
		for(Player on : Bukkit.getServer().getOnlinePlayers()){
			if(!OneVOneListener.fighting.contains(on.getName())){
				on.showPlayer(p);
				p.showPlayer(on);
			}
		}
	}
	
	@EventHandler
	public void onHitInLobby(EntityDamageEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(lobby1v1.contains(p.getName())){
				e.setCancelled(true);
			}
		}
	}
	
}
























