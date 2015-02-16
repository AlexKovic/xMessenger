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

public class JellyfishUtil extends KitUtil {

	
	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.WATER));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Place water where you want to");
			ex.add(ChatColor.GRAY + "climb up walls or MLG water!");
			ex.add(ChatColor.GRAY + "Your enemies will recieve no");
			ex.add(ChatColor.GRAY + "Poison if they walk into the");
			ex.add(ChatColor.GRAY + "water. You can only place one");
			ex.add(ChatColor.GRAY + "water at a time.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Amount of Waters: " + ChatColor.ITALIC + "1");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Poison Level: " + ChatColor.ITALIC + "None");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Poison Time: " + ChatColor.ITALIC + "None");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Place water where you want to");
			ex.add(ChatColor.GRAY + "climb up walls or MLG water!");
			ex.add(ChatColor.GRAY + "Your enemies will recieve 3s of");
			ex.add(ChatColor.GRAY + "Poison I if they walk into the");
			ex.add(ChatColor.GRAY + "water. You can only place 3");
			ex.add(ChatColor.GRAY + "waters at a time.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Amount of Waters: " + ChatColor.ITALIC + "3");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Poison Level: " + ChatColor.ITALIC + "Poison I");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Poison Time: " + ChatColor.ITALIC + "3s");	
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Place water where you want to");
			ex.add(ChatColor.GRAY + "climb up walls or MLG water!");
			ex.add(ChatColor.GRAY + "Your enemies will recieve 5s of");
			ex.add(ChatColor.GRAY + "Poison I if they walk into the");
			ex.add(ChatColor.GRAY + "water. You can only place 3");
			ex.add(ChatColor.GRAY + "waters at a time.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Amount of Waters: " + ChatColor.ITALIC + "3");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Poison Level: " + ChatColor.ITALIC + "Poison I");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Poison Time: " + ChatColor.ITALIC + "5s");	
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Place water where you want to");
			ex.add(ChatColor.GRAY + "climb up walls or MLG water!");
			ex.add(ChatColor.GRAY + "Your enemies will recieve 5s of");
			ex.add(ChatColor.GRAY + "Poison II if they walk into the");
			ex.add(ChatColor.GRAY + "water. You can only place 5");
			ex.add(ChatColor.GRAY + "waters at a time.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Amount of Waters: " + ChatColor.ITALIC + "5");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Poison Level: " + ChatColor.ITALIC + "Poison II");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Poison Time: " + ChatColor.ITALIC + "5s");		
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());
		p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.BLAZE_POWDER), "§9Jellyfish's powder"));
		
		KitHandler.setKit(p, KitType.JELLYFISH);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.JELLYFISH));
		sendKit(p, KitType.JELLYFISH);
		p.updateInventory();
	}
}
