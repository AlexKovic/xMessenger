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

public class ArcherUtil extends KitUtil {
	
	@Override
	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.BOW));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shoot your enemies with your");
			ex.add(ChatColor.GRAY + "powerful bow!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Arrows: " + ChatColor.ITALIC + "10");
			ex.add(ChatColor.GRAY + "•  Enchantments: " + ChatColor.ITALIC + "None");
		}else if(lvl == 2){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shoot your enemies with your");
			ex.add(ChatColor.GRAY + "powerful bow!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Arrows: " + ChatColor.ITALIC + "15");
			ex.add(ChatColor.GRAY + "•  Enchantments: " + ChatColor.ITALIC + "None");
		}else if(lvl == 3){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shoot your enemies with your");
			ex.add(ChatColor.GRAY + "powerful bow!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Arrows: " + ChatColor.ITALIC + "20");
			ex.add(ChatColor.GRAY + "•  Enchantments: " + ChatColor.ITALIC + "Punch I");
		}else if(lvl == 4){
			ex.add(ChatColor.WHITE + "Info:");
			ex.add(ChatColor.GRAY + "Shoot your enemies with your");
			ex.add(ChatColor.GRAY + "powerful bow!");
			ex.add("");
			ex.add(ChatColor.WHITE + "Features:");
			ex.add(ChatColor.GRAY + "•  Arrows: " + ChatColor.ITALIC + "20");
			ex.add(ChatColor.GRAY + "•  Enchantments: " + ChatColor.ITALIC + "Punch I - Flame I");	
		}
		return ex;
	}

	
	@Override
	public void giveKit(Player p, KitType type) {
		clearInventory(p);
		
		soup(p.getInventory());
		if(LevelUtil.getLevel(p, KitType.ARCHER) == 1){
			ItemStack bow = setName(new ItemStack(Material.BOW), "§9Archer Bow");
			p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, bow);
			p.getInventory().setItem(35, new ItemStack(Material.ARROW, 10));
		}else if(LevelUtil.getLevel(p, KitType.ARCHER) == 2){
			ItemStack bow = setName(new ItemStack(Material.BOW), "§9Archer Bow");
			p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, bow);
			p.getInventory().setItem(35, new ItemStack(Material.ARROW, 15));			
		}else if(LevelUtil.getLevel(p, KitType.ARCHER) == 3){
			ItemStack bow = setName(new ItemStack(Material.BOW), "§9Archer Bow");
			bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
			p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, bow);
			p.getInventory().setItem(35, new ItemStack(Material.ARROW, 20));		
		}else if(LevelUtil.getLevel(p, KitType.ARCHER) == 4){
			ItemStack bow = setName(new ItemStack(Material.BOW), "§9Archer Bow");
			bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
			bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
			p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, bow);
			p.getInventory().setItem(35, new ItemStack(Material.ARROW, 20));	
		}
		
		KitHandler.setKit(p, KitType.ARCHER);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.ARCHER));
		sendKit(p, KitType.ARCHER);
		p.updateInventory();
	}
}
