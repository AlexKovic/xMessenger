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

public class TankUtil extends KitUtil{

	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.TNT));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){ 
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "When you kill a player, an");
			ex.add(ChatColor.GRAY + "explosion with the power of");
			ex.add(ChatColor.GRAY + "1/2 TnT will occur at the place");
			ex.add(ChatColor.GRAY + "of death. This explosion will");
			ex.add(ChatColor.GRAY + "only hurt your enemies!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Explosion Power: " + ChatColor.ITALIC + "1/2 TnT");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "When you kill a player, an");
			ex.add(ChatColor.GRAY + "explosion with the power of");
			ex.add(ChatColor.GRAY + "3/4 TnT will occur at the place");
			ex.add(ChatColor.GRAY + "of death. This explosion will");
			ex.add(ChatColor.GRAY + "only hurt your enemies!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Explosion Power: " + ChatColor.ITALIC + "3/4 TnT");	
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "When you kill a player, an");
			ex.add(ChatColor.GRAY + "explosion with the power of");
			ex.add(ChatColor.GRAY + "1 TnT will occur at the place");
			ex.add(ChatColor.GRAY + "of death. This explosion will");
			ex.add(ChatColor.GRAY + "only hurt your enemies!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Explosion Power: " + ChatColor.ITALIC + "1 TnT");	
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "When you kill a player, an");
			ex.add(ChatColor.GRAY + "explosion with the power of");
			ex.add(ChatColor.GRAY + "2 TnT's will occur at the place");
			ex.add(ChatColor.GRAY + "of death. This explosion will");
			ex.add(ChatColor.GRAY + "only hurt your enemies!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "� " + ChatColor.GRAY + " Explosion Power: " + ChatColor.ITALIC + "2 TnT's");	
		}
		return ex;
	}

	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());

		KitHandler.setKit(p, KitType.TANK);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.TANK));
		sendKit(p, KitType.TANK);
		p.updateInventory();
	}
}
