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

public class PvPUtil extends KitUtil {

	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.STONE_SWORD));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "A sword and soups, these are");
			ex.add(ChatColor.GRAY + "the only things you need to");
			ex.add(ChatColor.GRAY + "become a perfect pvp'er!");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "A sword and soups, these are");
			ex.add(ChatColor.GRAY + "the only things you need to");
			ex.add(ChatColor.GRAY + "become a perfect pvp'er!");
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "A sword and soups, these are");
			ex.add(ChatColor.GRAY + "the only things you need to");
			ex.add(ChatColor.GRAY + "become a perfect pvp'er!");
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "A sword and soups, these are");
			ex.add(ChatColor.GRAY + "the only things you need to");
			ex.add(ChatColor.GRAY + "become a perfect pvp'er!");	
		}
		return ex;
	}

	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);


		soup(p.getInventory());
		KitHandler.setLevel(p, 1);
		KitHandler.setKit(p, KitType.PVP);
		sendKit(p, KitType.PVP);
		p.updateInventory();
	}
}
