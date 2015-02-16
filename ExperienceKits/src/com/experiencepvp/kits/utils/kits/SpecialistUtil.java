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

public class SpecialistUtil extends KitUtil {

	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.EXP_BOTTLE));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){ 
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "For every player you kill, you");
			ex.add(ChatColor.GRAY + "you will recieve 1 bottle of");
			ex.add(ChatColor.GRAY + "enchanting. Throw the bottle");
			ex.add(ChatColor.GRAY + "and it will fill 1/10th of your");
			ex.add(ChatColor.GRAY + "XP Bar. You can enchant your");
			ex.add(ChatColor.GRAY + "weapon by clicking your kit item.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " XP in Bottle: " + ChatColor.ITALIC + "1/10th of XP Bar");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "For every player you kill, you");
			ex.add(ChatColor.GRAY + "you will recieve 1 bottle of");
			ex.add(ChatColor.GRAY + "enchanting. Throw the bottle");
			ex.add(ChatColor.GRAY + "and it will fill 1/7th of your");
			ex.add(ChatColor.GRAY + "XP Bar. You can enchant your");
			ex.add(ChatColor.GRAY + "weapon by clicking your kit item.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " XP in Bottle: " + ChatColor.ITALIC + "1/7th of XP Bar");
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "For every player you kill, you");
			ex.add(ChatColor.GRAY + "you will recieve 1 bottle of");
			ex.add(ChatColor.GRAY + "enchanting. Throw the bottle");
			ex.add(ChatColor.GRAY + "and it will fill 1/5th of your");
			ex.add(ChatColor.GRAY + "XP Bar. You can enchant your");
			ex.add(ChatColor.GRAY + "weapon by clicking your kit item.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " XP in Bottle: " + ChatColor.ITALIC + "1/5th of XP Bar");
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "For every player you kill, you");
			ex.add(ChatColor.GRAY + "you will recieve 1 bottle of");
			ex.add(ChatColor.GRAY + "enchanting. Throw the bottle");
			ex.add(ChatColor.GRAY + "and it will fill 1/3th of your");
			ex.add(ChatColor.GRAY + "XP Bar. You can enchant your");
			ex.add(ChatColor.GRAY + "weapon by clicking your kit item.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " XP in Bottle: " + ChatColor.ITALIC + "1/3th of XP Bar");	
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());
		p.getInventory().setItem(PreferencesUtil.getSwordSlot(p) - 1, new ItemStack(Material.STONE_SWORD));
		p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(addUnbreaking(new ItemStack(Material.BOOK)), "§9Specialist's book"));
		
		KitHandler.setKit(p, KitType.SPECIALIST);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.SPECIALIST));
		sendKit(p, KitType.SPECIALIST);
		p.updateInventory();
	}
}
