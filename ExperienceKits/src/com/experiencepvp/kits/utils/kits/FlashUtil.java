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

public class FlashUtil extends KitUtil {

	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.REDSTONE_TORCH_ON));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Click your torch and flash to");
			ex.add(ChatColor.GRAY + "the block you are looking at");
			ex.add(ChatColor.GRAY + "in a 30 block radius. You'll");
			ex.add(ChatColor.GRAY + "have a 30 second cooldown!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Radius: " + ChatColor.ITALIC + "30 Blocks");
			ex.add(ChatColor.GRAY + "•  Cooldown: " + ChatColor.ITALIC + "30s");
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Click your torch and flash to");
			ex.add(ChatColor.GRAY + "the block you are looking at");
			ex.add(ChatColor.GRAY + "in a 30 block radius. You'll");
			ex.add(ChatColor.GRAY + "have a 30 second cooldown!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Radius: " + ChatColor.ITALIC + "40 Blocks");
			ex.add(ChatColor.GRAY + "•  Cooldown: " + ChatColor.ITALIC + "25s");
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Click your torch and flash to");
			ex.add(ChatColor.GRAY + "the block you are looking at");
			ex.add(ChatColor.GRAY + "in a 30 block radius. You'll");
			ex.add(ChatColor.GRAY + "have a 30 second cooldown!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Radius: " + ChatColor.ITALIC + "40 Blocks");
			ex.add(ChatColor.GRAY + "•  Cooldown: " + ChatColor.ITALIC + "20s");
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Click your torch and flash to");
			ex.add(ChatColor.GRAY + "the block you are looking at");
			ex.add(ChatColor.GRAY + "in a 30 block radius. You'll");
			ex.add(ChatColor.GRAY + "have a 30 second cooldown!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Radius: " + ChatColor.ITALIC + "Unlimited");
			ex.add(ChatColor.GRAY + "•  Cooldown: " + ChatColor.ITALIC + "15s");
		}
		return ex;
	}

	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());
		p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.REDSTONE_TORCH_ON), "§9Flash's torch"));

		KitHandler.setKit(p, KitType.FLASH);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.FLASH));
		sendKit(p, KitType.FLASH);
		p.updateInventory();
	}
}
