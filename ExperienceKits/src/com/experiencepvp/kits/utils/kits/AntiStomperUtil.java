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

public class AntiStomperUtil extends KitUtil {

	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.IRON_HELMET));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){ 
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Stompers will do no damage to");
			ex.add(ChatColor.GRAY + "you as long as you play this");
			ex.add(ChatColor.GRAY + "kit! The stomper will take no");
			ex.add(ChatColor.GRAY + "extra damage!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Damage to Stomper: " + ChatColor.ITALIC + "None");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Stompers will do no damage to");
			ex.add(ChatColor.GRAY + "you as long as you play this");
			ex.add(ChatColor.GRAY + "kit! The stomper will also take");
			ex.add(ChatColor.GRAY + "2 extra hearts of damage");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Damage to Stomper: " + ChatColor.ITALIC + "2♥");
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Stompers will do no damage to");
			ex.add(ChatColor.GRAY + "you as long as you play this");
			ex.add(ChatColor.GRAY + "kit! The stomper will also take");
			ex.add(ChatColor.GRAY + "4 extra hearts of damage");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Damage to Stomper: " + ChatColor.ITALIC + "4♥");
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Stompers will do no damage to");
			ex.add(ChatColor.GRAY + "you as long as you play this");
			ex.add(ChatColor.GRAY + "kit! The stomper will also take");
			ex.add(ChatColor.GRAY + "7 extra hearts of damage");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Damage to Stomper: " + ChatColor.ITALIC + "7♥");		
		}
		return ex;
	}
	
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());
		
		KitHandler.setKit(p, KitType.ANTISTOMPER);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.ANTISTOMPER));
		sendKit(p, KitType.ANTISTOMPER);
		p.updateInventory();
	}
}