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

public class GamblerUtil extends KitUtil {

	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.BLAZE_POWDER));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Click your gambler watch to");
			ex.add(ChatColor.GRAY + "recieve a random effect!");
			ex.add(ChatColor.GRAY + "Will it help you or will it");
			ex.add(ChatColor.GRAY + "hurt you?");
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Click your gambler watch to");
			ex.add(ChatColor.GRAY + "recieve a random effect!");
			ex.add(ChatColor.GRAY + "Will it help you or will it");
			ex.add(ChatColor.GRAY + "hurt you?");
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Click your gambler watch to");
			ex.add(ChatColor.GRAY + "recieve a random effect!");
			ex.add(ChatColor.GRAY + "Will it help you or will it");
			ex.add(ChatColor.GRAY + "hurt you?");
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Click your gambler watch to");
			ex.add(ChatColor.GRAY + "recieve a random effect!");
			ex.add(ChatColor.GRAY + "Will it help you or will it");
			ex.add(ChatColor.GRAY + "hurt you?");	
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());
		p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.WATCH), "�9Gambler Watch"));
		
		KitHandler.setKit(p, KitType.GAMBLER);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.GAMBLER));
		sendKit(p, KitType.GAMBLER);
		p.updateInventory();
	}
}
