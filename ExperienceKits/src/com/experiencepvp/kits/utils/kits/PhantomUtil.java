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

public class PhantomUtil extends KitUtil {

	
	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.FEATHER));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Click your feather and you will");
			ex.add(ChatColor.GRAY + "be able to fly as long as your");
			ex.add(ChatColor.GRAY + "wings are able to hold you! You");
			ex.add(ChatColor.GRAY + "will recieve a 30 second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Fly Time: " + ChatColor.ITALIC + "5s");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "30s");
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Click your feather and you will");
			ex.add(ChatColor.GRAY + "be able to fly as long as your");
			ex.add(ChatColor.GRAY + "wings are able to hold you! You");
			ex.add(ChatColor.GRAY + "will recieve a 25 second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Fly Time: " + ChatColor.ITALIC + "7s");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "25s");
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Click your feather and you will");
			ex.add(ChatColor.GRAY + "be able to fly as long as your");
			ex.add(ChatColor.GRAY + "wings are able to hold you! You");
			ex.add(ChatColor.GRAY + "will recieve a 20 second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Fly Time: " + ChatColor.ITALIC + "7s");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "20s");
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Click your feather and you will");
			ex.add(ChatColor.GRAY + "be able to fly as long as your");
			ex.add(ChatColor.GRAY + "wings are able to hold you! You");
			ex.add(ChatColor.GRAY + "will recieve a 15 second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Fly Time: " + ChatColor.ITALIC + "10s");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "15s");	
		}
		return ex;
	}
	
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());
		p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.FEATHER), "§9Phantom's feather"));
		
		KitHandler.setKit(p, KitType.PHANTOM);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.PHANTOM));
		sendKit(p, KitType.PHANTOM);
		p.updateInventory();
	}
}
