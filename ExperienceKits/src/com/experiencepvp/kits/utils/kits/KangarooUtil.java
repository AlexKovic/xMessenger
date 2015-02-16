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

public class KangarooUtil extends KitUtil {
	
	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.FIREWORK));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Jump arround like a real kangaroo");
			ex.add(ChatColor.GRAY + "by clicking your Kangaroo Rocket.");
			ex.add(ChatColor.GRAY + "By jumping you can easly get away");
			ex.add(ChatColor.GRAY + "or chase enemies! You will recieve");
			ex.add(ChatColor.GRAY + "a 10 second cooldown after jumping");
			ex.add(ChatColor.GRAY + "3 times.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Amount of Jumps: " + ChatColor.ITALIC + "3");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "10s");
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Jump arround like a real kangaroo");
			ex.add(ChatColor.GRAY + "by clicking your Kangaroo Rocket.");
			ex.add(ChatColor.GRAY + "By jumping you can easly get away");
			ex.add(ChatColor.GRAY + "or chase enemies! You will recieve");
			ex.add(ChatColor.GRAY + "a 10 second cooldown after jumping");
			ex.add(ChatColor.GRAY + "5 times.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Amount of Jumps: " + ChatColor.ITALIC + "5");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "10s");
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Jump arround like a real kangaroo");
			ex.add(ChatColor.GRAY + "by clicking your Kangaroo Rocket.");
			ex.add(ChatColor.GRAY + "By jumping you can easly get away");
			ex.add(ChatColor.GRAY + "or chase enemies! You will recieve");
			ex.add(ChatColor.GRAY + "a 5 second cooldown after jumping");
			ex.add(ChatColor.GRAY + "7 times.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Amount of Jumps: " + ChatColor.ITALIC + "7");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "5s");
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Jump arround like a real kangaroo");
			ex.add(ChatColor.GRAY + "by clicking your Kangaroo Rocket.");
			ex.add(ChatColor.GRAY + "By jumping you can easly get away");
			ex.add(ChatColor.GRAY + "or chase enemies! You will recieve");
			ex.add(ChatColor.GRAY + "no cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Amount of Jumps: " + ChatColor.ITALIC + "Unlimited");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "None");
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());
		p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.FIREWORK), "§9Kangaroo's Firework"));
		
		KitHandler.setKit(p, KitType.KANGAROO);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.KANGAROO));
		sendKit(p, KitType.KANGAROO);
		p.updateInventory();
	}
}
