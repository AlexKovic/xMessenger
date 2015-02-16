package com.experiencepvp.kits;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitType;

public class GUI {

	public static ItemStack opener() {
		ItemStack item = new ItemStack(Material.PAPER);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName("§9Choose a kit!");
		item.setItemMeta(im);
		return item;
	}

	public static Inventory getKitGui(Player p) {
		Inventory inv = Bukkit.createInventory(p, 54, " ");
		inv.setMaxStackSize(1);
		@SuppressWarnings("deprecation")
		ItemStack glass = new ItemStack(Material.getMaterial(102), 1);
		ItemMeta glassMeta = glass.getItemMeta();
		glassMeta.setDisplayName(" ");
		glass.setItemMeta(glassMeta);

		inv.setItem(0, glass);
		inv.setItem(1, glass);
		inv.setItem(2, glass);
		inv.setItem(3, glass);

		ItemStack sign = new ItemStack(Material.SIGN);
		ItemMeta im = sign.getItemMeta();
		im.setDisplayName("§9ExperienceKits");
		im.setLore(Arrays.asList("§7Choose your kit"));
		sign.setItemMeta(im);
		inv.addItem(sign);

		inv.setItem(5, glass);
		inv.setItem(6, glass);
		inv.setItem(7, glass);
		inv.setItem(8, glass);

		for (int i = 45; i < 54; i++)
			inv.setItem(i, glass);

		for (KitType type : KitType.values()) {
			if (p.hasPermission(type.getPerm()) || KitMethods.isFreeKit(type)
					|| KitMethods.isFreeKitDay()) {
				ItemStack i = type.getUtil().getIcon();
				ItemMeta itemm = i.getItemMeta();
				itemm.setDisplayName("§9" + type.getName());
				itemm.setLore(type.getUtil().getExplaination(0));
				i.setItemMeta(itemm);
				inv.addItem(i);
			} else {
				inv.setItem(inv.firstEmpty(), glass);
			}
		}
		return inv;
	}
	
	public static Inventory getFreeKitGui(Player p) {
		Inventory inv = Bukkit.createInventory(p, 54, "Choose a free kit!");
		inv.setMaxStackSize(1);
		@SuppressWarnings("deprecation")
		ItemStack glass = new ItemStack(Material.getMaterial(102), 1);
		ItemMeta glassMeta = glass.getItemMeta();
		glassMeta.setDisplayName(" ");
		glass.setItemMeta(glassMeta);

		inv.setItem(0, glass);
		inv.setItem(1, glass);
		inv.setItem(2, glass);
		inv.setItem(3, glass);

		ItemStack sign = new ItemStack(Material.SIGN);
		ItemMeta im = sign.getItemMeta();
		im.setDisplayName("§9ExperienceKits");
		im.setLore(Arrays.asList("§7Choose your kit"));
		sign.setItemMeta(im);
		inv.addItem(sign);

		inv.setItem(5, glass);
		inv.setItem(6, glass);
		inv.setItem(7, glass);
		inv.setItem(8, glass);

		for (int i = 45; i < 54; i++)
			inv.setItem(i, glass);

		for (KitType type : KitType.values()) {
			ItemStack i = type.getUtil().getIcon();
			ItemMeta itemm = i.getItemMeta();
			itemm.setDisplayName("§9" + type.getName());
			itemm.setLore(type.getUtil().getExplaination(0));
			i.setItemMeta(itemm);
			inv.addItem(i);
		}
		return inv;
	}
}
