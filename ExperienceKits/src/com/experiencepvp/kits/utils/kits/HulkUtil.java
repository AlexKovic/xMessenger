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

public class HulkUtil extends KitUtil {
	
	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.SADDLE));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Strong as you are, you can pick");
			ex.add(ChatColor.GRAY + "players up and throw them away");
			ex.add(ChatColor.GRAY + "or carry them with you! You will");
			ex.add(ChatColor.GRAY + "recieve a 10 second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "10s");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Strong as you are, you can pick");
			ex.add(ChatColor.GRAY + "players up and throw them away");
			ex.add(ChatColor.GRAY + "or carry them with you! You will");
			ex.add(ChatColor.GRAY + "recieve a 7 second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "7s");	
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Strong as you are, you can pick");
			ex.add(ChatColor.GRAY + "players up and throw them away");
			ex.add(ChatColor.GRAY + "or carry them with you! You will");
			ex.add(ChatColor.GRAY + "recieve a 5 second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "5s");	
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Strong as you are, you can pick");
			ex.add(ChatColor.GRAY + "players up and throw them away");
			ex.add(ChatColor.GRAY + "or carry them with you! You will");
			ex.add(ChatColor.GRAY + "recieve a 2 second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "2s");		
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());
		p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.SADDLE), "§9Hulk Tool"));
		
		KitHandler.setKit(p, KitType.HULK);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.HULK));
		sendKit(p, KitType.HULK);
		p.updateInventory();
	}
}
