package com.experiencepvp.kits.utils.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.kits.utils.KitUtil;
import com.experiencepvp.levels.LevelUtil;

public class NinjaUtil extends KitUtil {
	
	public ItemStack getIcon() {
		ItemStack item =  addUnbreaking(new ItemStack(Material.NETHER_STAR));
		item.setDurability((short) 15);
		return item;
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shift to teleport to the last");
			ex.add(ChatColor.GRAY + "player you hit in the past 10");
			ex.add(ChatColor.GRAY + "seconds. You will recieve a 15");
			ex.add(ChatColor.GRAY + "second cooldown!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "15s");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shift to teleport to the last");
			ex.add(ChatColor.GRAY + "player you hit in the past 10");
			ex.add(ChatColor.GRAY + "seconds. You will recieve a 10");
			ex.add(ChatColor.GRAY + "second cooldown!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "10s");
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shift to teleport to the last");
			ex.add(ChatColor.GRAY + "player you hit in the past 10");
			ex.add(ChatColor.GRAY + "seconds. You will recieve a 7");
			ex.add(ChatColor.GRAY + "second cooldown!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "7s");
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shift to teleport to the last");
			ex.add(ChatColor.GRAY + "player you hit in the past 10");
			ex.add(ChatColor.GRAY + "seconds. You will recieve a 5");
			ex.add(ChatColor.GRAY + "second cooldown!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "5s");	
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);
		
		soup(p.getInventory());
		KitHandler.setKit(p, KitType.NINJA);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.NINJA));
		sendKit(p, KitType.NINJA);
		p.updateInventory();
	}
}
