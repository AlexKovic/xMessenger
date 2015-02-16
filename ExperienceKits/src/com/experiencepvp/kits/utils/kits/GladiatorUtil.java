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

public class GladiatorUtil extends KitUtil {
	
	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.IRON_FENCE));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "When you click someone with");
			ex.add(ChatColor.GRAY + "your iron bars, you will both");
			ex.add(ChatColor.GRAY + "be teleported to a glass box");
			ex.add(ChatColor.GRAY + "up in the sky for a fair 1v1.");
			ex.add(ChatColor.GRAY + "You will not recieve regeneration");
			ex.add(ChatColor.GRAY + "and have no adventage over your");
			ex.add(ChatColor.GRAY + "opponent!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Seconds of Regen: " + ChatColor.ITALIC + "0s");	
			ex.add(ChatColor.GRAY + "•  Regen Level: " + ChatColor.ITALIC + "None");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "When you click someone with");
			ex.add(ChatColor.GRAY + "your iron bars, you will both");
			ex.add(ChatColor.GRAY + "be teleported to a glass box");
			ex.add(ChatColor.GRAY + "up in the sky for a fair 1v1.");
			ex.add(ChatColor.GRAY + "You will recieve 5 seconds of");
			ex.add(ChatColor.GRAY + "regeneration I as an adventage");
			ex.add(ChatColor.GRAY + "over your opponent!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Seconds of Regen: " + ChatColor.ITALIC + "5s");	
			ex.add(ChatColor.GRAY + "•  Regen Level: " + ChatColor.ITALIC + "Regeneration I");	
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "When you click someone with");
			ex.add(ChatColor.GRAY + "your iron bars, you will both");
			ex.add(ChatColor.GRAY + "be teleported to a glass box");
			ex.add(ChatColor.GRAY + "up in the sky for a fair 1v1.");
			ex.add(ChatColor.GRAY + "You will recieve 7 seconds of");
			ex.add(ChatColor.GRAY + "regeneration I as an adventage");
			ex.add(ChatColor.GRAY + "over your opponent!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Seconds of Regen: " + ChatColor.ITALIC + "7s");	
			ex.add(ChatColor.GRAY + "•  Regen Level: " + ChatColor.ITALIC + "Regeneration I");	
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "When you click someone with");
			ex.add(ChatColor.GRAY + "your iron bars, you will both");
			ex.add(ChatColor.GRAY + "be teleported to a glass box");
			ex.add(ChatColor.GRAY + "up in the sky for a fair 1v1.");
			ex.add(ChatColor.GRAY + "You will recieve 10 seconds of");
			ex.add(ChatColor.GRAY + "regeneration II as an adventage");
			ex.add(ChatColor.GRAY + "over your opponent!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Seconds of Regen: " + ChatColor.ITALIC + "10s");	
			ex.add(ChatColor.GRAY + "•  Regen Level: " + ChatColor.ITALIC + "Regeneration II");			
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());
		p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.IRON_FENCE), "§9Gladiator's bar"));
		
		KitHandler.setKit(p, KitType.GLADIATOR);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.GLADIATOR));
		sendKit(p, KitType.GLADIATOR);
		p.updateInventory();
	}
}
