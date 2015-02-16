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

public class ReaperUtil extends KitUtil {
	
	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.WOOD_HOE));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Hit your enemies with your");
			ex.add(ChatColor.GRAY + "Death Scythe and they will");
			ex.add(ChatColor.GRAY + "recieve 3 seconds of Wither I");
			ex.add(ChatColor.GRAY + "You will have a 10 second cooldown");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Wither Time: " + ChatColor.ITALIC + "3s");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Wither Level: " + ChatColor.ITALIC + "Wither I");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "10s");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Hit your enemies with your");
			ex.add(ChatColor.GRAY + "Death Scythe and they will");
			ex.add(ChatColor.GRAY + "recieve 4 seconds of Wither I");
			ex.add(ChatColor.GRAY + "You will have a 7 second cooldown");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Wither Time: " + ChatColor.ITALIC + "4s");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Wither Level: " + ChatColor.ITALIC + "Wither I");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "7s");	
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Hit your enemies with your");
			ex.add(ChatColor.GRAY + "Death Scythe and they will");
			ex.add(ChatColor.GRAY + "recieve 5 seconds of Wither I");
			ex.add(ChatColor.GRAY + "You will have a 7 second cooldown");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Wither Time: " + ChatColor.ITALIC + "5s");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Wither Level: " + ChatColor.ITALIC + "Wither I");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "7s");	
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Hit your enemies with your");
			ex.add(ChatColor.GRAY + "Death Scythe and they will");
			ex.add(ChatColor.GRAY + "recieve 5 seconds of Wither II");
			ex.add(ChatColor.GRAY + "You will have a 5 second cooldown");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Wither Time: " + ChatColor.ITALIC + "5s");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Wither Level: " + ChatColor.ITALIC + "Wither II");	
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "5s");		
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);
		
		soup(p.getInventory());
		KitHandler.setKit(p, KitType.REAPER);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.REAPER));
		sendKit(p, KitType.REAPER);
		p.updateInventory();
	}
}
