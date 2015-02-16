package com.experiencepvp.oneversusone;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.kits.GUI;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;

public class OneVOneMain {
	
	
	
	public static Inventory getTypeInventory(){
		Inventory inv = Bukkit.createInventory(null, 9, "§9Choose 1v1 Type");
		
		inv.setItem(1, new ItemStack(Material.THIN_GLASS));
		inv.setItem(3, new ItemStack(Material.THIN_GLASS));
		inv.setItem(5, new ItemStack(Material.THIN_GLASS));
		inv.setItem(7, new ItemStack(Material.THIN_GLASS));
		
		inv.setItem(0, Type1v1.EHG.getIcon());
		inv.setItem(2, Type1v1.KIT.getIcon());
		inv.setItem(4, Type1v1.HARDCORE.getIcon());
		inv.setItem(6, Type1v1.NORMALREFS.getIcon());
		inv.setItem(8, Type1v1.NORMALNOREFS.getIcon());
		
		return inv;
	}
	
	public static Inventory getMapInventory(){
		Inventory inv = Bukkit.createInventory(null, 9, "§9Choose 1v1 Map");
		
		for (Maps m : Maps.values()) {
			inv.addItem(m.getMapIcon());
		}
		
		for(int i = 0; i < 8; i++){
			if(inv.getItem(i) == null){
				inv.setItem(i, new ItemStack(Material.THIN_GLASS));
			}else if(inv.getItem(i).getType() == Material.AIR){
				inv.setItem(i, new ItemStack(Material.THIN_GLASS));
			}
			
		}
		
		return inv;
	}
	
	public static void challengePlayer(final Player asker, final Player asked){
		OneVOneListener.asked1v1player.put(asker.getName(), OneVOneListener.player1v1player.get(asker.getName()));
		OneVOneListener.player1v1player.remove(asker.getName());
		
		asked.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "You have been challenged by " + ChatColor.GOLD + asker.getName() + ChatColor.BLUE + " for a "
				+ ChatColor.GOLD + OneVOneListener.player1v1type.get(asker.getName()).getName() + ChatColor.BLUE + " on " + ChatColor.GOLD +
				OneVOneListener.player1v1maps.get(asker.getName()).getName() + ChatColor.BLUE + "!");
		
		asker.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "You have challenged " + ChatColor.GOLD + asked.getName() + ChatColor.BLUE + " for a "
				+ ChatColor.GOLD + OneVOneListener.player1v1type.get(asker.getName()).getName() + ChatColor.BLUE + " on " + ChatColor.GOLD +
				OneVOneListener.player1v1maps.get(asker.getName()).getName() + ChatColor.BLUE + "! " + ChatColor.BOLD + "He has 7 seconds to accept!");
		
		new BukkitRunnable(){
			public void run() {
				asker.sendMessage(OneVOneUtil.pref + "Your 1v1 challenge to " + ChatColor.GOLD + asked.getName() + ChatColor.BLUE + " expired. You can now challenge someone else!");
				OneVOneListener.player1v1maps.remove(asker.getName());
				OneVOneListener.player1v1type.remove(asker.getName());
				OneVOneListener.player1v1player.remove(asker.getName());
				OneVOneListener.asked1v1player.remove(asker.getName());
			}			
		}.runTaskLater(Main.getPlugin(), 140);
	}
	
	public static void accept1v1(final Player p1, final Player p2){
		
		p1.sendMessage(OneVOneUtil.pref + ChatColor.GOLD + p2.getName() + ChatColor.BLUE + " accepted your 1v1 request!");
		p2.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "You have accepted " + ChatColor.GOLD + p1.getName() + "'s " + ChatColor.BLUE + "1v1 request!");
		
		Type1v1 type = OneVOneListener.player1v1type.get(p1.getName());
		Maps map = OneVOneListener.player1v1maps.get(p1.getName());
		
		if(type == Type1v1.KIT){
			OneVOneListener.kit1v1.add(p1.getName());
			OneVOneListener.kit1v1.add(p2.getName());
			
			p1.getInventory().clear();
			p1.getInventory().setArmorContents(null);
			p2.getInventory().clear();
			p2.getInventory().setArmorContents(null);
			
			KitHandler.delKit(p1);
			KitHandler.delKit(p2);
			
			OneVOneListener.fighting.add(p1.getName());
			OneVOneListener.fighting.add(p2.getName());
		
			OneVOneListener.fightingwith.put(p1.getName(), p2.getName());
			OneVOneListener.fightingwith.put(p2.getName(), p1.getName());
			
			OneVOneListener.lobby1v1.remove(p1.getName());
			OneVOneListener.lobby1v1.remove(p2.getName());
		
			p1.teleport(map.getLoc1());
			p2.teleport(map.getLoc2());
			
			OneVOneListener.cantmove.add(p1.getName());
			OneVOneListener.cantmove.add(p2.getName());
			
			OneVOneUtil.handleInvis(p1, p2);
			
			if(p1.getGameMode() != GameMode.SURVIVAL){
				p1.setGameMode(GameMode.SURVIVAL);
			}
			if(p2.getGameMode() != GameMode.SURVIVAL){
				p2.setGameMode(GameMode.SURVIVAL);
			}
			
			p1.openInventory(GUI.getKitGui(p1));
			p2.openInventory(GUI.getKitGui(p2));
			
			new BukkitRunnable(){
				public void run(){
					p1.closeInventory();
					p2.closeInventory();
					if(!KitHandler.hasKit(p1.getName())){
						KitType.PVP.getUtil().giveKit(p1, KitType.PVP);
						p1.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "You didn't choose a kit so you have been given the " + ChatColor.GOLD + "PvP" + ChatColor.BLUE + " kit!");
					}
					
					if(!KitHandler.hasKit(p2.getName())){
						KitType.PVP.getUtil().giveKit(p2, KitType.PVP);
						p2.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "You didn't choose a kit so you have been given the " + ChatColor.GOLD + "PvP" + ChatColor.BLUE + " kit!");
					}
				}
			}.runTaskLater(Main.getPlugin(), 200);
			
			new BukkitRunnable(){
				public void run(){
					p1.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "The 1v1 will start in " + ChatColor.GOLD + "3 seconds" + ChatColor.BLUE + "!");
					p2.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "The 1v1 will start in " + ChatColor.GOLD + "3 seconds" + ChatColor.BLUE + "!");
				}
			}.runTaskLater(Main.getPlugin(), 220);
			
			new BukkitRunnable(){
				public void run(){
					p1.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "The 1v1 will start in " + ChatColor.GOLD + "2 seconds" + ChatColor.BLUE + "!");
					p2.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "The 1v1 will start in " + ChatColor.GOLD + "2 seconds" + ChatColor.BLUE + "!");
				}
			}.runTaskLater(Main.getPlugin(), 240);
			
			new BukkitRunnable(){
				public void run(){
					p1.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "The 1v1 will start in " + ChatColor.GOLD + "1 seconds" + ChatColor.BLUE + "!");
					p2.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "The 1v1 will start in " + ChatColor.GOLD + "1 seconds" + ChatColor.BLUE + "!");
				}
			}.runTaskLater(Main.getPlugin(), 260);
			
			new BukkitRunnable(){
				public void run(){
					OneVOneListener.cantmove.remove(p1.getName());
					OneVOneListener.cantmove.remove(p2.getName());
					p1.sendMessage(OneVOneUtil.pref + ChatColor.GOLD + "The 1v1 has started!");
					p2.sendMessage(OneVOneUtil.pref + ChatColor.GOLD + "The 1v1 has started!");
				}
			}.runTaskLater(Main.getPlugin(), 280);
		
			OneVOneListener.player1v1type.remove(p1.getName());
			OneVOneListener.player1v1maps.remove(p1.getName());
			
		}else{
			OneVOneListener.fighting.add(p1.getName());
			OneVOneListener.fighting.add(p2.getName());
		
			OneVOneListener.fightingwith.put(p1.getName(), p2.getName());
			OneVOneListener.fightingwith.put(p2.getName(), p1.getName());
			
			OneVOneListener.lobby1v1.remove(p1.getName());
			OneVOneListener.lobby1v1.remove(p2.getName());
		
			p1.teleport(map.getLoc1());
			p2.teleport(map.getLoc2());
			
			OneVOneListener.cantmove.add(p1.getName());
			OneVOneListener.cantmove.add(p2.getName());
			
			OneVOneUtil.handleInvis(p1, p2);
			
			KitHandler.delKit(p1);
			KitHandler.delKit(p2);
			
			if(p1.getGameMode() != GameMode.SURVIVAL){
				p1.setGameMode(GameMode.SURVIVAL);
			}
			if(p2.getGameMode() != GameMode.SURVIVAL){
				p2.setGameMode(GameMode.SURVIVAL);
			}
			
			OneVOneUtil.setInv(type.getId(), p1);
			OneVOneUtil.setInv(type.getId(), p2);
			
			new BukkitRunnable(){
				public void run(){
					p1.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "The 1v1 will start in " + ChatColor.GOLD + "3 seconds" + ChatColor.BLUE + "!");
					p2.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "The 1v1 will start in " + ChatColor.GOLD + "3 seconds" + ChatColor.BLUE + "!");
				}
			}.runTaskLater(Main.getPlugin(), 20);
			
			new BukkitRunnable(){
				public void run(){
					p1.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "The 1v1 will start in " + ChatColor.GOLD + "2 seconds" + ChatColor.BLUE + "!");
					p2.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "The 1v1 will start in " + ChatColor.GOLD + "2 seconds" + ChatColor.BLUE + "!");
				}
			}.runTaskLater(Main.getPlugin(), 40);
			
			new BukkitRunnable(){
				public void run(){
					p1.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "The 1v1 will start in " + ChatColor.GOLD + "1 seconds" + ChatColor.BLUE + "!");
					p2.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "The 1v1 will start in " + ChatColor.GOLD + "1 seconds" + ChatColor.BLUE + "!");
				}
			}.runTaskLater(Main.getPlugin(), 60);
			
			new BukkitRunnable(){
				public void run(){
					OneVOneListener.cantmove.remove(p1.getName());
					OneVOneListener.cantmove.remove(p2.getName());
					p1.sendMessage(OneVOneUtil.pref + ChatColor.GOLD + "The 1v1 has started!");
					p2.sendMessage(OneVOneUtil.pref + ChatColor.GOLD + "The 1v1 has started!");
				}
			}.runTaskLater(Main.getPlugin(), 80);
		}
		
		OneVOneListener.player1v1type.remove(p1.getName());
		OneVOneListener.player1v1maps.remove(p1.getName());
	}
	
	
	@SuppressWarnings("deprecation")
	public static void handleWin(Player p1, String s2){
		Player p2 = Bukkit.getServer().getPlayer(s2);
		
		if(p1 != null && p2 != null){
			for(Player on : Bukkit.getServer().getOnlinePlayers()){
				if(!OneVOneListener.fighting.contains(on.getName())){
					on.showPlayer(p1);
					p1.showPlayer(on);
				}
			}
			
			
			p1.teleport(OneVOneUtil.getSpawn());
			p1.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "You have won the 1v1 by killing " + ChatColor.GOLD + p2.getName() + ChatColor.BLUE + "!");

			OneVOneListener.asked1v1player.remove(p1.getName());
			OneVOneListener.cantmove.remove(p1.getName());
			OneVOneListener.fighting.remove(p1.getName());
			OneVOneListener.fightingwith.remove(p1.getName());
			OneVOneListener.lobby1v1.add(p1.getName());
			OneVOneListener.player1v1maps.remove(p1.getName());
			OneVOneListener.player1v1player.remove(p1.getName());
			OneVOneListener.player1v1type.remove(p1.getName());
			OneVOneListener.kit1v1.remove(p1.getName());

			KitHandler.delKit(p1);
			OneVOneUtil.give1v1Items(p1);
		}else if(p2 == null){
			p1.teleport(OneVOneUtil.getSpawn());
			p1.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "You have won the 1v1 because " + ChatColor.GOLD + "your opponent"+ ChatColor.BLUE + " logged out!");

			OneVOneListener.asked1v1player.remove(p1.getName());
			OneVOneListener.cantmove.remove(p1.getName());
			OneVOneListener.fighting.remove(p1.getName());
			OneVOneListener.fightingwith.remove(p1.getName());
			OneVOneListener.lobby1v1.add(p1.getName());
			OneVOneListener.player1v1maps.remove(p1.getName());
			OneVOneListener.player1v1player.remove(p1.getName());
			OneVOneListener.player1v1type.remove(p1.getName());
			OneVOneListener.kit1v1.remove(p1.getName());
			
			OneVOneUtil.give1v1Items(p1);
		}
		
		if(p2 != null){
			p2.sendMessage(OneVOneUtil.pref + ChatColor.BLUE + "You got killed by " + ChatColor.GOLD + p1.getName() + ChatColor.BLUE + " and lost the 1v1!");
			
			OneVOneListener.asked1v1player.remove(p2.getName());
			OneVOneListener.cantmove.remove(p2.getName());
			OneVOneListener.fighting.remove(p2.getName());
			OneVOneListener.fightingwith.remove(p2.getName());
			OneVOneListener.lobby1v1.remove(p2.getName());
			OneVOneListener.player1v1maps.remove(p2.getName());
			OneVOneListener.player1v1player.remove(p2.getName());
			OneVOneListener.player1v1type.remove(p2.getName());
			OneVOneListener.kit1v1.remove(p2.getName());
			
			for(Player on : Bukkit.getServer().getOnlinePlayers()){
				if(!OneVOneListener.fighting.contains(on.getName())){
					on.showPlayer(p2);
					p2.showPlayer(on);
				}
			}
			

			KitHandler.delKit(p2);
		}else{
			OneVOneListener.asked1v1player.remove(s2);
			OneVOneListener.cantmove.remove(s2);
			OneVOneListener.fighting.remove(s2);
			OneVOneListener.fightingwith.remove(s2);
			OneVOneListener.lobby1v1.remove(s2);
			OneVOneListener.player1v1maps.remove(s2);
			OneVOneListener.player1v1player.remove(s2);
			OneVOneListener.player1v1type.remove(s2);
			OneVOneListener.kit1v1.remove(s2);
		}
		
		//add stats van p1 (kills) en p2 (deaths)
	}
	
}


























