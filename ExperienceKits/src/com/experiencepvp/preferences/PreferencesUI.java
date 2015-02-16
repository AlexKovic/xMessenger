package com.experiencepvp.preferences;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.utils.KitUtil;

public class PreferencesUI {

	public static SettingsManager settings = SettingsManager.getInstance();
	
	@SuppressWarnings("deprecation")
	public static Inventory getPrefencesInv(Player p) {
		Inventory inv = Bukkit.createInventory(null, 45, "§9Preferences");
		for (int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, KitUtil.setName(new ItemStack(Material.STAINED_GLASS_PANE), " "));
		}
		
		ItemStack redglass = new ItemStack(Material.STAINED_GLASS_PANE);
		redglass.setDurability(DyeColor.RED.getData());
		
		for(int i = 0; i < 9; i++){
			inv.setItem(i, redglass);
		}
		
		for(int i = 36; i < 45; i++){
			inv.setItem(i, redglass);
		}

		inv.setItem(9, redglass);
		inv.setItem(18, redglass);
		inv.setItem(27, redglass);

		inv.setItem(17, redglass);
		inv.setItem(26, redglass);
		inv.setItem(35, redglass);

		
		inv.setItem(20, PreferencesItems.anvil(p));
		inv.setItem(22, PreferencesItems.lead(p));
		inv.setItem(24, PreferencesItems.sword(p));
		return inv;
	} //gaan eten, laat saros kk , ik ga wel ff wat doen idk what :D
	
}
