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

public class SamuraiUtil extends KitUtil {
	
	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.IRON_SWORD));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){ 
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "You will recieve a stronger");
			ex.add(ChatColor.GRAY + "sword when you are on a");
			ex.add(ChatColor.GRAY + "killstreak!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Kills for Iron Sword: " + ChatColor.ITALIC + "15");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Kills for Dia Sword: " + ChatColor.ITALIC + "None");		
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "You will recieve a stronger");
			ex.add(ChatColor.GRAY + "sword when you are on a");
			ex.add(ChatColor.GRAY + "killstreak!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Kills for Iron Sword: " + ChatColor.ITALIC + "15");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Kills for Dia Sword: " + ChatColor.ITALIC + "20");	
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "You will recieve a stronger");
			ex.add(ChatColor.GRAY + "sword when you are on a");
			ex.add(ChatColor.GRAY + "killstreak!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Kills for Iron Sword: " + ChatColor.ITALIC + "10");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Kills for Dia Sword: " + ChatColor.ITALIC + "20");	
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "You will recieve a stronger");
			ex.add(ChatColor.GRAY + "sword when you are on a");
			ex.add(ChatColor.GRAY + "killstreak!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Kills for Iron Sword: " + ChatColor.ITALIC + "5");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Kills for Dia Sword: " + ChatColor.ITALIC + "10");		
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);
		
		soup(p.getInventory());
		KitHandler.setKit(p, KitType.SAMURAI);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.SAMURAI));
		sendKit(p, KitType.SAMURAI);
		p.updateInventory();
	}
}
