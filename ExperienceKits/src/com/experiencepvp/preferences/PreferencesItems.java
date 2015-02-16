package com.experiencepvp.preferences;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.experiencepvp.kits.SettingsManager;

public class PreferencesItems {

	public static SettingsManager settings = SettingsManager.getInstance();
	
	public static ItemStack anvil(Player p) {
		ItemStack anvil = new ItemStack(Material.ANVIL);
		ItemMeta meta = anvil.getItemMeta();
		meta.setDisplayName("§9§nScoreboard");
		List<String> lore = new ArrayList<String>();
		lore.add("§7Turns the scoreboard on/off");
		lore.add("");
		if (settings.getData().getBoolean("preferences." + p.getUniqueId() + ".scoreboard") == true) {
			lore.add("§7Scoreboard: On");
		} else {
			lore.add("§7Scoreboard: Off");
		}
		lore.add("");
		lore.add("§7Click to turn the scoreboard on/off");
		meta.setLore(lore);
		anvil.setItemMeta(meta);
		return anvil;
	}
	
	public static ItemStack lead(Player p) {
		ItemStack anvil = new ItemStack(Material.LEASH);
		ItemMeta meta = anvil.getItemMeta();
		meta.setDisplayName("§9§nKit Item Slot");
		List<String> lore = new ArrayList<String>();
		lore.add("§7Changes the slot of the kit item");
		lore.add("");
		lore.add("§7Kit item slot: " + settings.getData().getInt("preferences." + p.getUniqueId() + ".kititem"));
		lore.add("");
		lore.add("§7Click right to higher the slot and");
		lore.add("§7click left to lower the slot.");
		meta.setLore(lore);
		anvil.setItemMeta(meta);
		return anvil;
	}
	
	public static ItemStack sword(Player p) {
		ItemStack anvil = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = anvil.getItemMeta();
		meta.setDisplayName("§9§nSword Slot");
		List<String> lore = new ArrayList<String>();
		lore.add("§7Changes the slot of the sword");
		lore.add("");
		lore.add("§7Sword slot: " + settings.getData().getInt("preferences." + p.getUniqueId() + ".sword"));
		lore.add("");
		lore.add("§7Click right to higher the slot and");
		lore.add("§7click left to lower the slot.");
		meta.setLore(lore);
		anvil.setItemMeta(meta);
		return anvil;
	}
}
