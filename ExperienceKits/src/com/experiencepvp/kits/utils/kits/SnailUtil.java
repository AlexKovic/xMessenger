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

public class SnailUtil extends KitUtil {

	public ItemStack getIcon() {
		ItemStack icon = addUnbreaking(new ItemStack(Material.POTION));
		icon.setDurability((short) 10);
		return icon;
	}

	public List<String> getExplaination(int lvl) { 
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){ 
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Your enemies will recieve 3");
			ex.add(ChatColor.GRAY + "seconds of Slowness I when you");
			ex.add(ChatColor.GRAY + "hit them.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Slowness Time: " + ChatColor.ITALIC + "3s");	
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Slowness Level: " + ChatColor.ITALIC + "Slowness I");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Your enemies will recieve 4");
			ex.add(ChatColor.GRAY + "seconds of Slowness I when you");
			ex.add(ChatColor.GRAY + "hit them.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Slowness Time: " + ChatColor.ITALIC + "4s");	
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Slowness Level: " + ChatColor.ITALIC + "Slowness I");
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Your enemies will recieve 5");
			ex.add(ChatColor.GRAY + "seconds of Slowness I when you");
			ex.add(ChatColor.GRAY + "hit them.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Slowness Time: " + ChatColor.ITALIC + "5s");	
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Slowness Level: " + ChatColor.ITALIC + "Slowness I");
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Your enemies will recieve 5");
			ex.add(ChatColor.GRAY + "seconds of Slowness II when you");
			ex.add(ChatColor.GRAY + "hit them.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Slowness Time: " + ChatColor.ITALIC + "5s");	
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Slowness Level: " + ChatColor.ITALIC + "Slowness II");		
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);
		
		soup(p.getInventory());
		KitHandler.setKit(p, KitType.SNAIL);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.SNAIL));
		sendKit(p, KitType.SNAIL);
		p.updateInventory();
	}
}
