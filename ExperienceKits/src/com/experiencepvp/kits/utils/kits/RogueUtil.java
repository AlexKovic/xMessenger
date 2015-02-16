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

public class RogueUtil extends KitUtil {

	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.BLAZE_ROD));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){ 
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "When you click an enemy with");
			ex.add(ChatColor.GRAY + "your Rogue Stick, he will lose");
			ex.add(ChatColor.GRAY + "his kit for 10 seconds! You will");
			ex.add(ChatColor.GRAY + "recieve a 30 second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Radius: " + ChatColor.ITALIC + "Hit Radius");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " No-Kit Time: " + ChatColor.ITALIC + "10s");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "30 seconds");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "When you click your Rogue Stick");
			ex.add(ChatColor.GRAY + "everyone in a 5 block radius will");
			ex.add(ChatColor.GRAY + "lose his kit for 10 seconds! You");
			ex.add(ChatColor.GRAY + "will recieve a 30 second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Radius: " + ChatColor.ITALIC + "5 Blocks");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " No-Kit Time: " + ChatColor.ITALIC + "10s");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "30 seconds");	
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "When you click your Rogue Stick");
			ex.add(ChatColor.GRAY + "everyone in a 7 block radius will");
			ex.add(ChatColor.GRAY + "lose his kit for 10 seconds! You");
			ex.add(ChatColor.GRAY + "will recieve a 20 second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Radius: " + ChatColor.ITALIC + "7 Blocks");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " No-Kit Time: " + ChatColor.ITALIC + "10s");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "20 seconds");	
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "None in a 7 block radius of you");
			ex.add(ChatColor.GRAY + "will be able to use their kit.");
			ex.add(ChatColor.GRAY + "They will recieve their kit back");
			ex.add(ChatColor.GRAY + "when they are at least 8 blocks");
			ex.add(ChatColor.GRAY + "away from you.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Radius: " + ChatColor.ITALIC + "7 Blocks");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " No-Kit Time: " + ChatColor.ITALIC + "Unlimited");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "None");		
		}
		return ex;
	}
	
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());
		if(LevelUtil.getLevel(p, KitType.ROGUE) < 4){
			p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.BLAZE_ROD), "§9Rogue's rod"));
		}
		
		KitHandler.setKit(p, KitType.ROGUE);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.ROGUE));
		sendKit(p, KitType.ROGUE);
		p.updateInventory();
	}
}
