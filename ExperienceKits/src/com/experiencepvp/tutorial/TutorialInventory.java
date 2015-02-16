package com.experiencepvp.tutorial;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TutorialInventory {

	@SuppressWarnings("deprecation")
	public static Inventory getConfirmInv(Player p){
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.YELLOW + "Follow Tutorial?");
		
		ItemStack paper = new ItemStack(Material.PAPER);
		ItemMeta paperim = paper.getItemMeta();
		paperim.setDisplayName(ChatColor.BOLD + "Do you want to followed the tutorial?");
		List<String> ls = new ArrayList<String>();
		if(TutorialUtil.hasFollowedTutorial(p.getUniqueId())){
			ls.add(ChatColor.GRAY + "You won't get any coins after");
			ls.add(ChatColor.GRAY + "completing the tutorial because");
			ls.add(ChatColor.GRAY + "you have already followed the");
			ls.add(ChatColor.GRAY + "tutorial!");
		}else{
			ls.add(ChatColor.GRAY + "You will get 1000 coins after");
			ls.add(ChatColor.GRAY + "completing the tutorial. If you");
			ls.add(ChatColor.GRAY + "quit the tutorial before it ends");
			ls.add(ChatColor.GRAY + "you won't get a prize!");
		}
		paperim.setLore(ls);
		paper.setItemMeta(paperim);
		
		ItemStack next = new ItemStack(Material.EMERALD);
		ItemMeta nextim = next.getItemMeta();
		nextim.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Start the tutorial");
		next.setItemMeta(nextim);
		
		ItemStack prev = new ItemStack(Material.REDSTONE);
		ItemMeta previm = prev.getItemMeta();
		previm.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Cancel the tutorial");
		prev.setItemMeta(previm);
		
		ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta glassim = glass.getItemMeta();
		glassim.setDisplayName(ChatColor.YELLOW + "" + "[]");
		glass.setItemMeta(glassim);
		glass.setDurability(DyeColor.YELLOW.getData());
		
		inv.setItem(0, next);
		inv.setItem(1, glass);
		inv.setItem(2, glass);
		inv.setItem(3, glass);
		inv.setItem(4, paper);
		inv.setItem(5, glass);
		inv.setItem(6, glass);
		inv.setItem(7, glass);
		inv.setItem(8, prev);
		
		return inv;
	}
	
}
