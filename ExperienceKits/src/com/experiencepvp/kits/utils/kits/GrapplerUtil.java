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

public class GrapplerUtil extends KitUtil {

	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.LEASH));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shoot out your grappling hook");
			ex.add(ChatColor.GRAY + "and grapple to the place or");
			ex.add(ChatColor.GRAY + "enemy it catches! You will");
			ex.add(ChatColor.GRAY + "recieve a 10s cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Cooldown: " + ChatColor.ITALIC + "10s");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shoot out your grappling hook");
			ex.add(ChatColor.GRAY + "and grapple to the place or");
			ex.add(ChatColor.GRAY + "enemy it catches! You will");
			ex.add(ChatColor.GRAY + "recieve a 7s cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Cooldown: " + ChatColor.ITALIC + "10s");	
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shoot out your grappling hook");
			ex.add(ChatColor.GRAY + "and grapple to the place or");
			ex.add(ChatColor.GRAY + "enemy it catches! You will");
			ex.add(ChatColor.GRAY + "recieve a 5s cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Cooldown: " + ChatColor.ITALIC + "10s");	
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shoot out your grappling hook");
			ex.add(ChatColor.GRAY + "and grapple to the place or");
			ex.add(ChatColor.GRAY + "enemy it catches! You will");
			ex.add(ChatColor.GRAY + "recieve no cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Cooldown: " + ChatColor.ITALIC + "None");		
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());
		p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.LEASH), "§9Grappler's leash"));
		
		KitHandler.setKit(p, KitType.GRAPPLER);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.GRAPPLER));
		sendKit(p, KitType.GRAPPLER);
		p.updateInventory();
	}
}
