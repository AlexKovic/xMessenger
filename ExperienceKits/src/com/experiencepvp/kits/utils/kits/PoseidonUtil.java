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

public class PoseidonUtil extends KitUtil {

	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.WATER));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "You will recieve 5 seconds");
			ex.add(ChatColor.GRAY + "of Strength I while in water!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Strength Level: " + ChatColor.ITALIC + "Strength I");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Speed Level: " + ChatColor.ITALIC + "None");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "You will recieve 5 seconds");
			ex.add(ChatColor.GRAY + "of Strength I and Speed I");
			ex.add(ChatColor.GRAY + "while in water!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Strength Level: " + ChatColor.ITALIC + "Strength I");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Speed Level: " + ChatColor.ITALIC + "Speed I");	
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "You will recieve 5 seconds");
			ex.add(ChatColor.GRAY + "of Strength I and Speed II");
			ex.add(ChatColor.GRAY + "while in water!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Strength Level: " + ChatColor.ITALIC + "Strength I");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Speed Level: " + ChatColor.ITALIC + "Speed II");	
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "You will recieve 5 seconds");
			ex.add(ChatColor.GRAY + "of Strength II and Speed II");
			ex.add(ChatColor.GRAY + "while in water!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Strength Level: " + ChatColor.ITALIC + "Strength II");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Speed Level: " + ChatColor.ITALIC + "Speed II");		
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());
		
		KitHandler.setKit(p, KitType.POSEIDON);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.POSEIDON));
		sendKit(p, KitType.POSEIDON);
		p.updateInventory();
	}
}
