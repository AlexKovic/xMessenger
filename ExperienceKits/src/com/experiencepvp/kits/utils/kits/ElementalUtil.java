package com.experiencepvp.kits.utils.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.kits.utils.KitUtil;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.preferences.PreferencesUtil;

public class ElementalUtil extends KitUtil {

	public ItemStack getIcon() {
		ItemStack is = new ItemStack(Material.EMERALD);
		is.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		return is;
		
		//return addUnbreaking(new ItemStack(Material.IRON_BLOCK));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "When you click your anvil");
			ex.add(ChatColor.GRAY + "you will no longer be able");
			ex.add(ChatColor.GRAY + "to take or deal any knockback!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Anchor Time: " + ChatColor.ITALIC + "10s");
			ex.add(ChatColor.GRAY + "•  Cooldown: " + ChatColor.ITALIC + "20s");
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "When you click your anvil");
			ex.add(ChatColor.GRAY + "you will no longer be able");
			ex.add(ChatColor.GRAY + "to take or deal any knockback!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Anchor Time: " + ChatColor.ITALIC + "10s");
			ex.add(ChatColor.GRAY + "•  Cooldown: " + ChatColor.ITALIC + "10s");			
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "When you click your anvil");
			ex.add(ChatColor.GRAY + "you will no longer be able");
			ex.add(ChatColor.GRAY + "to take or deal any knockback!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Anchor Time: " + ChatColor.ITALIC + "10s");
			ex.add(ChatColor.GRAY + "•  Cooldown: " + ChatColor.ITALIC + "5s");			
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "You will not be able to take");
			ex.add(ChatColor.GRAY + "or deal any knockback as long");
			ex.add(ChatColor.GRAY + "as your play this kit!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Anchor Time: " + ChatColor.ITALIC + "Unlimited");
			ex.add(ChatColor.GRAY + "•  Cooldown: " + ChatColor.ITALIC + "None");			
		}
		return ex;
	}
	
	
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		KitHandler.setKit(p, KitType.ELEMENTAL);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.ELEMENTAL));
		sendKit(p, KitType.ELEMENTAL);
		p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.EMERALD), "§9Elemental Stone"));
		soup(p.getInventory());
		p.updateInventory();
	}
	

}