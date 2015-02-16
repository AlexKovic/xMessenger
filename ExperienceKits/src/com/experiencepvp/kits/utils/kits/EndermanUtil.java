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

public class EndermanUtil extends KitUtil {

	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.ENDER_PEARL));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Teleport like a real Enderman");
			ex.add(ChatColor.GRAY + "with your Enderpearls!");
			ex.add(ChatColor.GRAY + "You will recieve a new pearl");
			ex.add(ChatColor.GRAY + "every 30 seconds");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  New Pearl: " + ChatColor.ITALIC + "30s");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Teleport like a real Enderman");
			ex.add(ChatColor.GRAY + "with your Enderpearls!");
			ex.add(ChatColor.GRAY + "You will recieve a new pearl");
			ex.add(ChatColor.GRAY + "every 30 seconds");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  New Pearl: " + ChatColor.ITALIC + "20s");
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Teleport like a real Enderman");
			ex.add(ChatColor.GRAY + "with your Enderpearls!");
			ex.add(ChatColor.GRAY + "You will recieve a new pearl");
			ex.add(ChatColor.GRAY + "every 30 seconds");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  New Pearl: " + ChatColor.ITALIC + "15s");
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Teleport like a real Enderman");
			ex.add(ChatColor.GRAY + "with your Enderpearls!");
			ex.add(ChatColor.GRAY + "You will recieve a new pearl");
			ex.add(ChatColor.GRAY + "every 30 seconds");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  New Pearl: " + ChatColor.ITALIC + "10s");	
		}
		return ex;
	}

	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());
		p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.ENDER_PEARL), "§9Enderman's pearls"));

		KitHandler.setKit(p, KitType.ENDERMAN);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.ENDERMAN));
		sendKit(p, KitType.ENDERMAN);
		p.updateInventory();
	}
}
