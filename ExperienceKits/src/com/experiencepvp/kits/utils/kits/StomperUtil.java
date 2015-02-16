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

public class StomperUtil extends KitUtil {

	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.IRON_BOOTS));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){ 
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Jump down on your enemies and");
			ex.add(ChatColor.GRAY + "all enemies in a 3 block radius");
			ex.add(ChatColor.GRAY + "will take the amount of damage");
			ex.add(ChatColor.GRAY + "you would've gotten from the fall");
			ex.add(ChatColor.GRAY + "while you will only take 2 hearts");
			ex.add(ChatColor.GRAY + "of damage! The damage to the enemies");
			ex.add(ChatColor.GRAY + "will be capped at 5 hearts.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Radius: " + ChatColor.ITALIC + "3 Blocks");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Max Damage: " + ChatColor.ITALIC + "5♥");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Jump down on your enemies and");
			ex.add(ChatColor.GRAY + "all enemies in a 4 block radius");
			ex.add(ChatColor.GRAY + "will take the amount of damage");
			ex.add(ChatColor.GRAY + "you would've gotten from the fall");
			ex.add(ChatColor.GRAY + "while you will only take 2 hearts");
			ex.add(ChatColor.GRAY + "of damage! The damage to the enemies");
			ex.add(ChatColor.GRAY + "will be capped at 6 hearts.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Radius: " + ChatColor.ITALIC + "4 Blocks");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Max Damage: " + ChatColor.ITALIC + "6♥");	
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Jump down on your enemies and");
			ex.add(ChatColor.GRAY + "all enemies in a 4 block radius");
			ex.add(ChatColor.GRAY + "will take the amount of damage");
			ex.add(ChatColor.GRAY + "you would've gotten from the fall");
			ex.add(ChatColor.GRAY + "while you will only take 2 hearts");
			ex.add(ChatColor.GRAY + "of damage! The damage to the enemies");
			ex.add(ChatColor.GRAY + "will be capped at 8 hearts.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Radius: " + ChatColor.ITALIC + "4 Blocks");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Max Damage: " + ChatColor.ITALIC + "8♥");	
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Jump down on your enemies and");
			ex.add(ChatColor.GRAY + "all enemies in a 5 block radius");
			ex.add(ChatColor.GRAY + "will take the amount of damage");
			ex.add(ChatColor.GRAY + "you would've gotten from the fall");
			ex.add(ChatColor.GRAY + "while you will only take 2 hearts");
			ex.add(ChatColor.GRAY + "of damage! The damage to the enemies");
			ex.add(ChatColor.GRAY + "will not be capped.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Radius: " + ChatColor.ITALIC + "5 Blocks");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Max Damage: " + ChatColor.ITALIC + "Unlimited");		
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);
		
		soup(p.getInventory());
		KitHandler.setKit(p, KitType.STOMPER);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.STOMPER));
		sendKit(p, KitType.STOMPER);
		p.updateInventory();
	}
}
