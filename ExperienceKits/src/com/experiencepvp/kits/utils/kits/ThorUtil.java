package com.experiencepvp.kits.utils.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.kits.utils.KitUtil;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.preferences.PreferencesUtil;

public class ThorUtil extends KitUtil {
	
	public ItemStack getIcon() {
		return addUnbreaking(new ItemStack(Material.WOOD_AXE));
	}

	public List<String> getExplaination(int lvl) {
		List<String> ex = new ArrayList<String>();
		if(lvl == 0){
			
		}else if(lvl == 1){
			
		}else if(lvl == 2){
			
		}else if(lvl == 3){
			
		}else if(lvl == 4){
			
		}
		return ex;
	}
	
	@SuppressWarnings("deprecation")
	public void giveKit(Player p, KitType type) {
		clearInventory(p);

		soup(p.getInventory());
		p.getInventory().setItem(PreferencesUtil.getKitItemSlot(p) - 1, setName(new ItemStack(Material.WOOD_AXE), "§9Thor's axe"));
		
		KitHandler.setKit(p, KitType.THOR);
		KitHandler.setLevel(p, LevelUtil.getLevel(p, KitType.THOR));
		sendKit(p, KitType.THOR);
		p.updateInventory();
	}
}
