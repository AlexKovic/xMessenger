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
import com.experiencepvp.preferences.PreferencesUtil;

public class SwitcherUtil extends KitUtil {

	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.SNOW_BALL));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){ 
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "You will start with 8 Switcher");
			ex.add(ChatColor.GRAY + "Balls. Throw a Switcher Ball at");
			ex.add(ChatColor.GRAY + "an enemy to switch places with him");
			ex.add(ChatColor.GRAY + "him! You will recieve a 20 second");
			ex.add(ChatColor.GRAY + "cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Switcher Balls: " + ChatColor.ITALIC + "8");	
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "20s");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "You will start with 12 Switcher");
			ex.add(ChatColor.GRAY + "Balls. Throw a Switcher Ball at");
			ex.add(ChatColor.GRAY + "an enemy to switch places with him");
			ex.add(ChatColor.GRAY + "him! You will recieve a 15 second");
			ex.add(ChatColor.GRAY + "cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Switcher Balls: " + ChatColor.ITALIC + "12");	
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "15s");	
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "You will start with 12 Switcher");
			ex.add(ChatColor.GRAY + "Balls. Throw a Switcher Ball at");
			ex.add(ChatColor.GRAY + "an enemy to switch places with him");
			ex.add(ChatColor.GRAY + "him! You will recieve a 10 second");
			ex.add(ChatColor.GRAY + "cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Switcher Balls: " + ChatColor.ITALIC + "12");	
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "10s");	
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "You will start with 16 Switcher");
			ex.add(ChatColor.GRAY + "Balls. Throw a Switcher Ball at");
			ex.add(ChatColor.GRAY + "an enemy to switch places with him");
			ex.add(ChatColor.GRAY + "him! You will recieve a 5 second");
			ex.add(ChatColor.GRAY + "cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Switcher Balls: " + ChatColor.ITALIC + "16");	
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "5s");		
		}
		return ex;
	}
	
	public void giveKit(Player p, KitType type) {
		clearInventory(p);
		
		soup(p.getInventory());
		if(LevelUtil.getLevel(p, KitType.SWITCHER) == 1){
			p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.SNOW_BALL, 8), "�9Switcher's balls"));
		}else if(LevelUtil.getLevel(p, KitType.SWITCHER) == 2){
			p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.SNOW_BALL, 10), "�9Switcher's balls"));
		}else if(LevelUtil.getLevel(p, KitType.SWITCHER) == 3){
			p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.SNOW_BALL, 12), "�9Switcher's balls"));
		}else if(LevelUtil.getLevel(p, KitType.SWITCHER) == 4){
			p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.SNOW_BALL, 16), "�9Switcher's balls"));
		}
		
		KitHandler.setKit(p, KitType.SWITCHER);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.SWITCHER));
		sendKit(p, KitType.SWITCHER);
		p.updateInventory();
	}
}
