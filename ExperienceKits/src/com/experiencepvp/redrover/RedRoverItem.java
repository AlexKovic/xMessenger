package com.experiencepvp.redrover;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RedRoverItem {
	
	public static ItemStack castle() {
		ItemStack mine = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta minem = mine.getItemMeta();
		minem.setDisplayName("§9Castle");
		minem.setLore(Arrays.asList("§7Click here to host the", "§7Castle map!"));
		mine.setDurability((short) 7);
		mine.setItemMeta(minem);
		return mine;
	}
}
