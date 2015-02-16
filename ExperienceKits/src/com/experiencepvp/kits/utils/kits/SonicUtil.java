package com.experiencepvp.kits.utils.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.kits.utils.KitUtil;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.preferences.PreferencesUtil;

public class SonicUtil extends KitUtil {

	public ItemStack getIcon() {
		ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		meta.setColor(Color.fromRGB(0, 128, 255));
		item.setItemMeta(meta);
		return addUnbreaking(item);
	}

	//5,35:7,30:7,25:10,20
	
	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){ 
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Put on your boots to recieve");
			ex.add(ChatColor.GRAY + "a massive speedboost for 5");
			ex.add(ChatColor.GRAY + "seconds! You will recieve a 35");
			ex.add(ChatColor.GRAY + "second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Speed Time: " + ChatColor.ITALIC + "5s");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "35s");	
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Put on your boots to recieve");
			ex.add(ChatColor.GRAY + "a massive speedboost for 7");
			ex.add(ChatColor.GRAY + "seconds! You will recieve a 30");
			ex.add(ChatColor.GRAY + "second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Speed Time: " + ChatColor.ITALIC + "7s");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "30s");	
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Put on your boots to recieve");
			ex.add(ChatColor.GRAY + "a massive speedboost for 7");
			ex.add(ChatColor.GRAY + "seconds! You will recieve a 25");
			ex.add(ChatColor.GRAY + "second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Speed Time: " + ChatColor.ITALIC + "7s");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "25s");	
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Put on your boots to recieve");
			ex.add(ChatColor.GRAY + "a massive speedboost for 10");
			ex.add(ChatColor.GRAY + "seconds! You will recieve a 20");
			ex.add(ChatColor.GRAY + "second cooldown.");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Speed Time: " + ChatColor.ITALIC + "10s");
			ex.add(ChatColor.WHITE + "• " + ChatColor.GRAY + " Cooldown: " + ChatColor.ITALIC + "20s");		
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		meta.setColor(Color.fromRGB(0, 128, 255));
		item.setItemMeta(meta);
		
		soup(p.getInventory());
		p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(item, "§9Sonic boots"));
		
		KitHandler.setKit(p, KitType.SONIC);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.SONIC));
		sendKit(p, KitType.SONIC);
		p.updateInventory();
	}
}
