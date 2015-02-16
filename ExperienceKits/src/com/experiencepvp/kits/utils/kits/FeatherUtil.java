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

public class FeatherUtil extends KitUtil {

	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.FEATHER));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shift to fall down slowly and");
			ex.add(ChatColor.GRAY + "reduce fall damage!");
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shift to fall down slowly and");
			ex.add(ChatColor.GRAY + "reduce fall damage!");
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shift to fall down slowly and");
			ex.add(ChatColor.GRAY + "reduce fall damage!");
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shift to fall down slowly and");
			ex.add(ChatColor.GRAY + "reduce fall damage!");		
		}
		return ex;
	}

	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());

		KitHandler.setKit(p, KitType.FEATHER);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.FEATHER));
		sendKit(p, KitType.FEATHER);
		p.updateInventory();
	}
}
