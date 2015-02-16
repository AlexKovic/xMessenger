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

public class GrandpaUtil extends KitUtil {

	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.STICK));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Knock your opponent away with");
			ex.add(ChatColor.GRAY + "your knockback II stick!");
		}else if(lvl == 2){
			ex.add(ChatColor.GRAY + "Knock your opponent away with");
			ex.add(ChatColor.GRAY + "your knockback II stick!");
		}else if(lvl == 3){
			ex.add(ChatColor.GRAY + "Knock your opponent away with");
			ex.add(ChatColor.GRAY + "your knockback II stick!");
		}else if(lvl == 4){
			ex.add(ChatColor.GRAY + "Knock your opponent away with");
			ex.add(ChatColor.GRAY + "your knockback II stick!");
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		ItemStack grandpa = new ItemStack(Material.STICK);
		grandpa.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);
		
		soup(p.getInventory());
		p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(grandpa, "§9Grandpa's stick"));
		
		KitHandler.setKit(p, KitType.GRANDPA);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.GRANDPA));
		sendKit(p, KitType.GRANDPA);
		p.updateInventory();
	}
}
