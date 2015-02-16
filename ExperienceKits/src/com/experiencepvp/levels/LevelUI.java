package com.experiencepvp.levels;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.kits.utils.KitUtil;

public class LevelUI {

	public static Inventory getUpgradeInventory(Player p, KitType kit){
		Inventory inv = Bukkit.createInventory(p, 45, ChatColor.BLUE + "Upgrade Your Kit");
		inv.setMaxStackSize(1);
		
		ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
		//glass.setDurability(DyeColor.GREEN.getData());
		
		inv.setItem(0, glass);
		inv.setItem(1, glass);
		inv.setItem(2, glass);
		inv.setItem(3, glass);
		inv.setItem(4, new ItemStack(Material.REDSTONE));
		inv.setItem(5, glass);
		inv.setItem(6, glass);
		inv.setItem(7, glass);
		inv.setItem(8, glass);
		inv.setItem(9, glass);
		inv.setItem(10, glass);
		inv.setItem(11, glass);
		inv.setItem(12, glass);
		inv.setItem(13, glass);
		inv.setItem(14, glass);
		inv.setItem(15, glass);
		inv.setItem(16, glass);
		inv.setItem(17, glass);
		inv.setItem(18, glass);
		inv.setItem(19, glass);
		inv.setItem(20, glass);
		inv.setItem(21, glass);
		inv.setItem(22, glass);
		inv.setItem(23, glass);
		inv.setItem(24, glass);
		inv.setItem(25, glass);
		inv.setItem(26, glass);
		inv.setItem(27, glass);
		inv.setItem(29, glass);
		inv.setItem(31, glass);
		inv.setItem(33, glass);
		inv.setItem(35, glass);
		inv.setItem(36, glass);
		inv.setItem(37, glass);
		inv.setItem(38, glass);
		inv.setItem(39, glass);
		inv.setItem(40, glass);
		inv.setItem(41, glass);
		inv.setItem(42, glass);
		inv.setItem(43, glass);
		inv.setItem(44, glass);
		
		if(LevelUtil.getLevel(p, kit) > 0){
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.WHITE + "Price: " + ChatColor.GRAY + kit.getPrice());
			ls.add("");
			for(String s : kit.getUtil().getExplaination(1)){
				ls.add(s);
			}
			
			ItemStack is = kit.getUtil().getIcon();
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + kit.getName() + ": Level 1");
			im.setLore(ls);
			is.setItemMeta(im);
			inv.setItem(28, is);
		}else{
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.WHITE + "Price: " + ChatColor.GRAY + kit.getPrice());
			ls.add("");
			for(String s : kit.getUtil().getExplaination(1)){
				ls.add(s);
			}
			ItemStack is = LevelUtil.removeEnch(kit.getUtil().getIcon());
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + kit.getName() + ": Level 1");
			im.setLore(ls);
			is.setItemMeta(im);
			inv.setItem(28, is);
		}
		
		if(LevelUtil.getLevel(p, kit) > 1){
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.WHITE + "Price: " + ChatColor.GRAY + " 1000");
			ls.add("");
			for(String s : kit.getUtil().getExplaination(2)){
				ls.add(s);
			}
			ItemStack is = kit.getUtil().getIcon();
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + kit.getName() + ": Level 2");
			im.setLore(ls);
			is.setItemMeta(im);
			inv.setItem(30, is);
		}else{
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.WHITE + "Price: " + ChatColor.GRAY + "1000");
			ls.add("");
			for(String s : kit.getUtil().getExplaination(2)){
				ls.add(s);
			}
			ItemStack is = LevelUtil.removeEnch(kit.getUtil().getIcon());
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + kit.getName() + ": Level 2");
			im.setLore(ls);
			is.setItemMeta(im);
			inv.setItem(30, is);
		}
		
		if(LevelUtil.getLevel(p, kit) > 2){
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.WHITE + "Price: " + ChatColor.GRAY + "1000");
			ls.add("");
			for(String s : kit.getUtil().getExplaination(3)){
				ls.add(s);
			}
			ItemStack is = kit.getUtil().getIcon();
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + kit.getName() + ": Level 3");
			im.setLore(ls);;
			is.setItemMeta(im);
			inv.setItem(32, is);
		}else{
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.WHITE + "Price: " + ChatColor.GRAY + "1000");
			ls.add("");
			for(String s : kit.getUtil().getExplaination(3)){
				ls.add(s);
			}
			ItemStack is = LevelUtil.removeEnch(kit.getUtil().getIcon());
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + kit.getName() + ": Level 3");
			im.setLore(ls);
			is.setItemMeta(im);
			inv.setItem(32, is);
		}
		
		if(LevelUtil.getLevel(p, kit) > 3){
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.WHITE + "Price: " + ChatColor.GRAY + "1500");
			ls.add("");
			for(String s : kit.getUtil().getExplaination(4)){
				ls.add(s);
			}
			ItemStack is = kit.getUtil().getIcon();
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + kit.getName() + ": Level 4");
			im.setLore(ls);
			is.setItemMeta(im);
			inv.setItem(34, is);
		}else{
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.WHITE + "Price: " + ChatColor.GRAY + "1500");
			ls.add("");
			for(String s : kit.getUtil().getExplaination(4)){
				ls.add(s);
			}
			ItemStack is = LevelUtil.removeEnch(kit.getUtil().getIcon());
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + kit.getName() + ": Level 4");
			im.setLore(ls);
			is.setItemMeta(im);
			inv.setItem(34, is);
		}
		return inv;
	}
	
	@SuppressWarnings("deprecation")
	public static Inventory getOwnKitsToUpgrade(Player p, int state){
		if(state == 1){
			Inventory inv = Bukkit.createInventory(p, 45, ChatColor.BLUE + "Upgrade a kit!");
			inv.setMaxStackSize(1);
			
			ItemStack info = new ItemStack(Material.SIGN);
			ItemMeta infoim = info.getItemMeta();
			infoim.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + "ExperienceKits");
		    List<String> ls1 = new ArrayList<String>();
		    ls1.add(ChatColor.GRAY + "Click on a kit icon to");
		    ls1.add(ChatColor.GRAY + "upgrade that kit!");
		    infoim.setLore(ls1);
		    info.setItemMeta(infoim);
			
			ItemStack previous = new ItemStack(Material.STONE_PLATE);
			ItemMeta previousim = previous.getItemMeta();
			previousim.setDisplayName(ChatColor.DARK_GRAY + "<-- Previous");
			previous.setItemMeta(previousim);
			
			ItemStack back = new ItemStack(Material.REDSTONE);
			ItemMeta backim = back.getItemMeta();
			backim.setDisplayName(ChatColor.DARK_RED + "Back");
			back.setItemMeta(backim);
			    
			ItemStack next = null;
			if((LevelUtil.getKitsAmount(p) - LevelUtil.getFreeKitsAmount()) >= 27){
				next = new ItemStack(Material.IRON_PLATE);
				ItemMeta nextim = next.getItemMeta();
				nextim.setDisplayName(ChatColor.WHITE + "Next -->");
				next.setItemMeta(nextim);
			}else{
				next = new ItemStack(Material.STONE_PLATE);
				ItemMeta nextim = next.getItemMeta();
				nextim.setDisplayName(ChatColor.DARK_GRAY + "Next -->");
				next.setItemMeta(nextim);
			}
			
			ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
			glass.setDurability(DyeColor.GREEN.getData());
			
			inv.setItem(0, previous);
		    inv.setItem(1, glass);
		    inv.setItem(2, glass);
		    inv.setItem(3, glass);
		    inv.setItem(4, info);
		    inv.setItem(5, glass);
		    inv.setItem(6, glass);
		    inv.setItem(7, glass);
		    inv.setItem(8, next);
			
		    int kits = 0;
		    for(KitType kit : KitType.values()){
		    	if((LevelUtil.getLevel(p, kit) > 0 && !kit.isFree()) && kit != KitType.GOD && kit != KitType.CATCHER && kit != KitType.ELEMENTAL && kit != KitType.TURRET){
		    		ItemStack kititem = kit.getUtil().getIcon();
		    		ItemMeta kitim = kititem.getItemMeta();
		    		kitim.setDisplayName("§9" + kit.getName());
		    		kitim.setLore(kit.getUtil().getExplaination(0));
		    		kititem.setItemMeta(kitim);
		    		inv.addItem(kititem);
		    		kits++;
		    		if(kits >= 27){
		    			break;
		    		}
		    	}
		    }
		    
		    if(kits == 0){
		    	ItemStack nokits = new ItemStack(Material.SKULL_ITEM);
		    	ItemMeta nokitsim = nokits.getItemMeta();
		    	nokitsim.setDisplayName(ChatColor.WHITE + "You don't have any premium kits!");
		    	List<String> ls = new ArrayList<String>();
		    	ls.add(ChatColor.GRAY + "You haven't bought any kits.");
		    	ls.add(ChatColor.GRAY + "yet. Click here to go to the");
		    	ls.add(ChatColor.GRAY + "buy menu!");
		    	nokitsim.setLore(ls);
		    	nokits.setItemMeta(nokitsim);
		    	inv.setItem(22, nokits);
		    }
		    
		    inv.setItem(36, glass);
		    inv.setItem(37, glass);
		    inv.setItem(38, glass);
		    inv.setItem(39, glass);
		    inv.setItem(40, back);
		    inv.setItem(41, glass);
		    inv.setItem(42, glass);
		    inv.setItem(43, glass);
		    inv.setItem(44, glass);

		    return inv;
		}else if(state == 2){
			
			Inventory inv = Bukkit.createInventory(p, 45, ChatColor.BLUE + "Upgrade a kit! (2)");
			inv.setMaxStackSize(1);
			
			ItemStack info = new ItemStack(Material.SIGN);
			ItemMeta infoim = info.getItemMeta();
			infoim.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + "ExperienceKits");
		    List<String> ls1 = new ArrayList<String>();
		    ls1.add(ChatColor.GRAY + "Click on a kit icon to");
		    ls1.add(ChatColor.GRAY + "upgrade it!");
		    infoim.setLore(ls1);
		    info.setItemMeta(infoim);
			
			ItemStack previous = new ItemStack(Material.IRON_PLATE);
			ItemMeta previousim = previous.getItemMeta();
			previousim.setDisplayName(ChatColor.DARK_GRAY + "<-- Previous");
			previous.setItemMeta(previousim);
			
			ItemStack back = new ItemStack(Material.REDSTONE);
			ItemMeta backim = back.getItemMeta();
			backim.setDisplayName(ChatColor.DARK_RED + "Back");
			back.setItemMeta(backim);
			
			ItemStack next = new ItemStack(Material.STONE_PLATE);
			ItemMeta nextim = next.getItemMeta();
			nextim.setDisplayName(ChatColor.DARK_GRAY + "Next -->");
			next.setItemMeta(nextim);
			
			ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
			glass.setDurability(DyeColor.BLUE.getData());
			
			inv.setItem(0, previous);
		    inv.setItem(1, glass);
		    inv.setItem(2, glass);
		    inv.setItem(3, glass);
		    inv.setItem(4, info);
		    inv.setItem(5, glass);
		    inv.setItem(6, glass);
		    inv.setItem(7, glass);
		    inv.setItem(8, next);
			
			int kits = 0;
		    for(KitType kit : KitType.values()){
		    	if((LevelUtil.getLevel(p, kit) > 0 || kit.isFree()) && kit != KitType.GOD && kit != KitType.CATCHER && kit != KitType.ELEMENTAL && kit != KitType.TURRET){
			    	kits++;
			    	if(kits > 27){
			    		ItemStack kititem = kit.getUtil().getIcon();
			    		ItemMeta kitim = kititem.getItemMeta();
			    		kitim.setDisplayName("§9" + kit.getName());
			    		kitim.setLore(kit.getUtil().getExplaination(0));
			    		kititem.setItemMeta(kitim);
			    		inv.addItem(kititem);
		    			if(kits >= 54){
		    				break;
		    			}
		    		}
		    	}
		    }
		    
		    inv.setItem(36, glass);
		    inv.setItem(37, glass);
		    inv.setItem(38, glass);
		    inv.setItem(39, glass);
		    inv.setItem(40, back);
		    inv.setItem(41, glass);
		    inv.setItem(42, glass);
		    inv.setItem(43, glass);
		    inv.setItem(44, glass);
		    
		    return inv;
		}else{
			return null;
		}
		
	}
	
	
	public static Inventory getOwnKitsGUI(Player p, int state){
		if(state == 1){
		Inventory inv = Bukkit.createInventory(p, 45, ChatColor.BLUE + "Pick a kit!");
		inv.setMaxStackSize(1);
	    
	    ItemStack previous = new ItemStack(Material.STONE_PLATE);
		ItemMeta previousim = previous.getItemMeta();
		previousim.setDisplayName(ChatColor.DARK_GRAY + "<-- Previous");
	    previous.setItemMeta(previousim);
	    
		ItemStack info = new ItemStack(Material.SIGN);
		ItemMeta infoim = info.getItemMeta();
		infoim.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + "ExperienceKits");
	    List<String> ls1 = new ArrayList<String>();
	    ls1.add(ChatColor.GRAY + "Click on a kit icon to");
	    ls1.add(ChatColor.GRAY + "play with that kit!");
	    infoim.setLore(ls1);
	    info.setItemMeta(infoim);	    
	    
	    ItemStack next;
	    if(LevelUtil.getKitsAmount(p) >= 27){
		    next = new ItemStack(Material.IRON_PLATE);
			ItemMeta nextim = next.getItemMeta();
			nextim.setDisplayName(ChatColor.WHITE + "Next -->");
		    next.setItemMeta(nextim);
	    }else{
		    next = new ItemStack(Material.STONE_PLATE);
			ItemMeta nextim = next.getItemMeta();
			nextim.setDisplayName(ChatColor.DARK_GRAY + "Next -->");
		    next.setItemMeta(nextim);	    	
	    }
	    
	    ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
	    
	    inv.setItem(0, previous);
	    inv.setItem(1, glass);
	    inv.setItem(2, glass);
	    inv.setItem(3, glass);
	    inv.setItem(4, info);
	    inv.setItem(5, glass);
	    inv.setItem(6, glass);
	    inv.setItem(7, glass);
	    inv.setItem(8, next);
	    
	    int kits = 0;
	    for(KitType kit : KitType.values()){
	    	if((LevelUtil.getLevel(p, kit) > 0 || kit.isFree()) && kit != KitType.GOD && kit != KitType.CATCHER && kit != KitType.ELEMENTAL && kit != KitType.TURRET){
	    		ItemStack kititem = kit.getUtil().getIcon();
	    		ItemMeta kitim = kititem.getItemMeta();
	    		kitim.setDisplayName("§9" + kit.getName());
	    		kitim.setLore(kit.getUtil().getExplaination(LevelUtil.getLevel(p, kit)));
	    		kititem.setItemMeta(kitim);
	    		inv.addItem(kititem);
	    		kits++;
	    		if(kits >= 27){
	    			break;
	    		}
	    	}
	    }

	    inv.setItem(36, glass);
	    inv.setItem(37, glass);
	    inv.setItem(38, glass);
	    inv.setItem(39, glass);
	    inv.setItem(39, glass);
	    inv.setItem(40, glass);
	    inv.setItem(41, glass);
	    inv.setItem(42, glass);
	    inv.setItem(43, glass);
	    inv.setItem(44, glass);
		
	    int amount = inv.getSize() - inv.getContents().length;
	    for (int i = 0; i < amount; i++) {
	    	inv.setItem(amount, glass);
	    }
	    
		return inv;
		}else if(state == 2){
			Inventory inv = Bukkit.createInventory(p, 45, ChatColor.BLUE + "Pick a kit! (2)");
			inv.setMaxStackSize(1);
			
			ItemStack previous = new ItemStack(Material.IRON_PLATE);
			ItemMeta previousim = previous.getItemMeta();
			previousim.setDisplayName(ChatColor.WHITE + "<-- Previous");
		    previous.setItemMeta(previousim);
		    
			ItemStack info = new ItemStack(Material.SIGN);
			ItemMeta infoim = info.getItemMeta();
			infoim.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + "ExperienceKits");
		    List<String> ls1 = new ArrayList<String>();
		    ls1.add(ChatColor.GRAY + "Click on a kit icon to");
		    ls1.add(ChatColor.GRAY + "play with that kit!");
		    infoim.setLore(ls1);
		    info.setItemMeta(infoim);	    
		    
		    ItemStack next = new ItemStack(Material.STONE_PLATE);
		    ItemMeta nextim = next.getItemMeta();
		    nextim.setDisplayName(ChatColor.DARK_GRAY + "Next -->");
		    next.setItemMeta(nextim);
		    
		    ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
		    
		    inv.setItem(0, previous);
		    inv.setItem(1, glass);
		    inv.setItem(2, glass);
		    inv.setItem(3, glass);
		    inv.setItem(4, info);
		    inv.setItem(5, glass);
		    inv.setItem(6, glass);
		    inv.setItem(7, glass);
		    inv.setItem(8, next);
		    
		    int kits = 0;
		    for(KitType kit : KitType.values()){
		    	if((LevelUtil.getLevel(p, kit) > 0 || kit.isFree()) && kit != KitType.GOD && kit != KitType.CATCHER && kit != KitType.ELEMENTAL && kit != KitType.TURRET){
			    	kits++;
			    	if(kits > 27){
			    		ItemStack kititem = kit.getUtil().getIcon();
			    		ItemMeta kitim = kititem.getItemMeta();
			    		kitim.setDisplayName("§9" + kit.getName());
			    		kitim.setLore(kit.getUtil().getExplaination(LevelUtil.getLevel(p, kit)));
			    		kititem.setItemMeta(kitim);
			    		inv.addItem(kititem);
		    			if(kits >= 54){
		    				break;
		    			}
		    		}
		    	}
		    }

		    inv.setItem(36, glass);
		    inv.setItem(37, glass);
		    inv.setItem(38, glass);
		    inv.setItem(39, glass);
		    inv.setItem(39, glass);
		    inv.setItem(40, glass);
		    inv.setItem(41, glass);
		    inv.setItem(42, glass);
		    inv.setItem(43, glass);
		    inv.setItem(44, glass);

		    int amount = inv.getSize() - inv.getContents().length;
		    for (int i = 0; i < amount; i++) {
		    	inv.setItem(amount, glass);
		    }
		    
			return inv;
		}else{
			return null;
		}
	}
	
	
	
	@SuppressWarnings("deprecation")
	public static Inventory getBuyKitsGUI(Player p, int state){
		if(state == 1){
			
		Inventory inv = Bukkit.createInventory(p, 45, ChatColor.BLUE + "Buy a kit!");
		inv.setMaxStackSize(1);
	    
		ItemStack previous = new ItemStack(Material.STONE_PLATE);
		ItemMeta previousim = previous.getItemMeta();
		previousim.setDisplayName(ChatColor.DARK_GRAY + "<-- Previous");
	    previous.setItemMeta(previousim);

		ItemStack back = new ItemStack(Material.REDSTONE);
		ItemMeta backim = back.getItemMeta();
		backim.setDisplayName(ChatColor.DARK_RED + "Back");
		back.setItemMeta(backim);
		
		ItemStack info = new ItemStack(Material.SIGN);
		ItemMeta infoim = info.getItemMeta();
		infoim.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + "ExperienceKits");
	    List<String> ls1 = new ArrayList<String>();
	    ls1.add(ChatColor.GRAY + "Click on a kit icon to");
	    ls1.add(ChatColor.GRAY + "buy that kit!");
	    infoim.setLore(ls1);
	    info.setItemMeta(infoim);
	    
	    ItemStack next;
	    if(LevelUtil.getPremiumKitsAmount() - LevelUtil.getKitsAmount(p)  >= 27){
		    next = new ItemStack(Material.IRON_PLATE);
			ItemMeta nextim = next.getItemMeta();
			nextim.setDisplayName(ChatColor.WHITE + "Next -->");
		    next.setItemMeta(nextim);
	    }else{
		    next = new ItemStack(Material.STONE_PLATE);
			ItemMeta nextim = next.getItemMeta();
			nextim.setDisplayName(ChatColor.DARK_GRAY + "Next -->");
		    next.setItemMeta(nextim);	    	
	    }

		ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
		glass.setDurability(DyeColor.BLUE.getData());
	    
	    inv.setItem(0, previous);
	    inv.setItem(1, glass);
	    inv.setItem(2, glass);
	    inv.setItem(3, glass);
	    inv.setItem(4, info);
	    inv.setItem(5, glass);
	    inv.setItem(6, glass);
	    inv.setItem(7, glass);
	    inv.setItem(8, next);
	    
	    int kits = 0;
	    for(KitType kit : KitType.values()){
	    	if(!kit.isFree()){
	    		if(LevelUtil.getLevel(p, kit) == 0 && kit != KitType.GOD && kit != KitType.CATCHER && kit != KitType.ELEMENTAL && kit != KitType.TURRET){
		    		kits++;
		    		List<String> ls = new ArrayList<String>();
					ls.add(ChatColor.WHITE + "Price: " + ChatColor.GRAY + kit.getPrice());
					ls.add("");
					for(String s : kit.getUtil().getExplaination(1)){
						ls.add(s);
					}
	    			ItemStack kititem = kit.getUtil().getIcon();
		    		ItemMeta kitim = kititem.getItemMeta();
		    		kitim.setDisplayName("§9" + kit.getName());
		    		kitim.setLore(ls);
		    		kititem.setItemMeta(kitim);
		    		inv.addItem(kititem);
	    		}
	    		if(kits >= 27){
	    			break;
	    		}
	    	}
	    }
	    
	    if(kits == 0){
	    	ItemStack nokits = new ItemStack(Material.SKULL_ITEM);
	    	ItemMeta nokitsim = nokits.getItemMeta();
	    	nokitsim.setDisplayName(ChatColor.WHITE + "You can't buy any more kits!");
	    	List<String> ls = new ArrayList<String>();
	    	ls.add(ChatColor.GRAY + "You already have every kit.");
	    	ls.add(ChatColor.GRAY + "Click here to go to the");
	    	ls.add(ChatColor.GRAY + "upgrade menu!");
	    	nokitsim.setLore(ls);
	    	nokits.setItemMeta(nokitsim);
	    	inv.setItem(22, nokits);
	    }

	    inv.setItem(36, glass);
	    inv.setItem(37, glass);
	    inv.setItem(38, glass);
	    inv.setItem(39, glass);
	    inv.setItem(40, back);
	    inv.setItem(41, glass);
	    inv.setItem(42, glass);
	    inv.setItem(43, glass);
	    inv.setItem(44, glass);
		
		return inv;
		
		}else if(state == 2){
			Inventory inv = Bukkit.createInventory(p, 45, ChatColor.BLUE + "Buy a kit! (2)");
			inv.setMaxStackSize(1);
			
			ItemStack info = new ItemStack(Material.SIGN);
			ItemMeta infoim = info.getItemMeta();
			infoim.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + "ExperienceKits");
		    List<String> ls1 = new ArrayList<String>();
		    ls1.add(ChatColor.GRAY + "Click on a kit icon to");
		    ls1.add(ChatColor.GRAY + "buy that kit!");
		    infoim.setLore(ls1);
		    info.setItemMeta(infoim);
			
			ItemStack previous = new ItemStack(Material.IRON_PLATE);
			ItemMeta previousim = previous.getItemMeta();
			previousim.setDisplayName(ChatColor.DARK_GRAY + "<-- Previous");
			previous.setItemMeta(previousim);
			
			ItemStack back = new ItemStack(Material.REDSTONE);
			ItemMeta backim = back.getItemMeta();
			backim.setDisplayName(ChatColor.DARK_RED + "Back");
			back.setItemMeta(backim);
			
			ItemStack next = new ItemStack(Material.STONE_PLATE);
			ItemMeta nextim = next.getItemMeta();
			nextim.setDisplayName(ChatColor.DARK_GRAY + "Next -->");
			next.setItemMeta(nextim);
			
			ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
			glass.setDurability(DyeColor.BLUE.getData());
			
			inv.setItem(0, previous);
		    inv.setItem(1, glass);
		    inv.setItem(2, glass);
		    inv.setItem(3, glass);
		    inv.setItem(4, info);
		    inv.setItem(5, glass);
		    inv.setItem(6, glass);
		    inv.setItem(7, glass);
		    inv.setItem(8, next);
		    
		    int kits = 0;
		    for(KitType kit : KitType.values()){
		    	if(!kit.isFree()){
		    		kits++;
		    		if(kits > 27){
		    			if(LevelUtil.getLevel(p, kit) == 0 && kit != KitType.GOD && kit != KitType.CATCHER && kit != KitType.ELEMENTAL && kit != KitType.TURRET){
		    				List<String> ls = new ArrayList<String>();
		    				ls.add(ChatColor.WHITE + "Price: " + ChatColor.GRAY + kit.getPrice());
		    				ls.add("");
		    				for(String s : kit.getUtil().getExplaination(1)){
		    					ls.add(s);
		    				}
			    			ItemStack kititem = kit.getUtil().getIcon();
				    		ItemMeta kitim = kititem.getItemMeta();
				    		kitim.setDisplayName("§9" + kit.getName());
				    		kitim.setLore(ls);
				    		kititem.setItemMeta(kitim);
				    		inv.addItem(kititem);
			    			inv.addItem(kititem);
			    		}
		    			if(kits >= 54){
		    				break;
		    			}
		    		}
		    	}
		    }

		    inv.setItem(36, glass);
		    inv.setItem(37, glass);
		    inv.setItem(38, glass);
		    inv.setItem(39, glass);
		    inv.setItem(40, back);
		    inv.setItem(41, glass);
		    inv.setItem(42, glass);
		    inv.setItem(43, glass);
		    inv.setItem(44, glass);
			
			return inv;
		
		}else{
			return null;
		}
	}
	
	
	
	@SuppressWarnings("deprecation")
	public static Inventory getChooseBuyOrUpGUI(Player p){
		Inventory inv = Bukkit.createInventory(p, 45, ChatColor.BLUE + "Buy or Upgrade?");
		inv.setMaxStackSize(1);
		
		ItemStack buy = new ItemStack(Material.DIAMOND);
		ItemMeta buyim = buy.getItemMeta();
		buyim.setDisplayName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + "Buy a kit");
	    List<String> ls1 = new ArrayList<String>();
	    ls1.add(ChatColor.GRAY + "Buy a kit you don't have.");
	    ls1.add(ChatColor.GRAY + "You will recieve the");
	    ls1.add(ChatColor.GRAY + "level 1 version!");
	    buyim.setLore(ls1);
	    buy.setItemMeta(buyim);
	    
	    ItemStack upgrade = new ItemStack(Material.EMERALD);
		ItemMeta upgradeim = upgrade.getItemMeta();
		upgradeim.setDisplayName(ChatColor.GREEN + "" + ChatColor.UNDERLINE + "Upgrade a kit");
	    List<String> ls2 = new ArrayList<String>();
	    ls2.add(ChatColor.GRAY + "Upgrade a kit you already");
	    ls2.add(ChatColor.GRAY + "bought. Only works if you");
	    ls2.add(ChatColor.GRAY + "already have the level 1");
	    ls2.add(ChatColor.GRAY + "version. You will recieve");
	    ls2.add(ChatColor.GRAY + "the level 2, 3 or 4 version!");
	    upgradeim.setLore(ls2);
	    upgrade.setItemMeta(upgradeim);
		
	    ItemStack glass1 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemStack glass2 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemStack glass3 = new ItemStack(Material.STAINED_GLASS_PANE);
	    glass2.setDurability(DyeColor.BLUE.getData());
	    glass3.setDurability(DyeColor.GREEN.getData());
	    
		inv.setItem(0, glass1);
		inv.setItem(1, glass1);
		inv.setItem(2, glass1);
		inv.setItem(3, glass1);
		inv.setItem(4, glass1);
		inv.setItem(5, glass1);
		inv.setItem(6, glass1);
		inv.setItem(7, glass1);
		inv.setItem(8, glass1);
		inv.setItem(9, glass1);
		inv.setItem(10, glass2);
		inv.setItem(11, glass2);
		inv.setItem(12, glass2);
		inv.setItem(13, glass1);
		inv.setItem(14, glass3);
		inv.setItem(15, glass3);
		inv.setItem(16, glass3);
		inv.setItem(17, glass1);
		inv.setItem(18, glass1);
		inv.setItem(19, glass2);
		inv.setItem(20, buy);
		inv.setItem(21, glass2);
		inv.setItem(22, glass1);
		inv.setItem(23, glass3);
		inv.setItem(24, upgrade);
		inv.setItem(25, glass3);
		inv.setItem(26, glass1);
		inv.setItem(27, glass1);
		inv.setItem(28, glass2);
		inv.setItem(29, glass2);
		inv.setItem(30, glass2);
		inv.setItem(31, glass1);
		inv.setItem(32, glass3);
		inv.setItem(33, glass3);
		inv.setItem(34, glass3);
		inv.setItem(35, glass1);
		inv.setItem(36, glass1);
		inv.setItem(37, glass1);
		inv.setItem(38, glass1);
		inv.setItem(39, glass1);
		inv.setItem(40, glass1);
		inv.setItem(41, glass1);
		inv.setItem(42, glass1);
		inv.setItem(43, glass1);
		inv.setItem(44, glass1);
		
		return inv;
	}
	
	@SuppressWarnings("deprecation")
	public static Inventory getChooseBuyGUI(Player p){
		if(!LevelListener.choosekit.containsKey(p.getName())){
			Inventory inv = Bukkit.createInventory(p, 9, ChatColor.GRAY + "Error!");
			inv.setMaxStackSize(1);

			ItemStack error = new ItemStack(Material.SKULL);
			ItemMeta errorim = error.getItemMeta();
			errorim.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Error");
		    error.setItemMeta(errorim);
			
			inv.setItem(1, new ItemStack(Material.THIN_GLASS));
			inv.setItem(1, new ItemStack(Material.THIN_GLASS));
			inv.setItem(2, new ItemStack(Material.THIN_GLASS));
			inv.setItem(3, new ItemStack(Material.THIN_GLASS));
			inv.setItem(4, error);
			inv.setItem(5, new ItemStack(Material.THIN_GLASS));
			inv.setItem(6, new ItemStack(Material.THIN_GLASS));
			inv.setItem(7, new ItemStack(Material.THIN_GLASS));
			inv.setItem(1, new ItemStack(Material.THIN_GLASS));
			
			return inv;
		}
		
		Inventory inv = Bukkit.createInventory(p, 9, ChatColor.BLUE + "Buy the " + LevelListener.choosekit.get(p.getName()).getName() + " kit!");
		inv.setMaxStackSize(1);
		
		ItemStack buy = new ItemStack(Material.GOLD_INGOT);
		ItemMeta buyim = buy.getItemMeta();
		buyim.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Buy");
	    buy.setItemMeta(buyim);
	    
	    ItemStack cancel = new ItemStack(Material.REDSTONE);
		ItemMeta cancelim = cancel.getItemMeta();
		cancelim.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Cancel");
	    cancel.setItemMeta(cancelim);
	    
	    ItemStack info;
	    if(LevelListener.chooselvl.get(p.getName()) == 1){
	    	info = new ItemStack(Material.PAPER);
			ItemMeta infoim = info.getItemMeta();
			infoim.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Info");
		    List<String> ls2 = new ArrayList<String>();
		    ls2.add(ChatColor.GRAY + "Do you want to buy the " + LevelListener.choosekit.get(p.getName()).getName());
		    ls2.add(ChatColor.GRAY + "kit (Level " + LevelListener.chooselvl.get(p.getName()) + ") ?");
		    ls2.add(ChatColor.GRAY + "This kit costs " + LevelListener.chooseprice.get(p.getName()) + "$ !");
		    infoim.setLore(ls2);
		    info.setItemMeta(infoim);
	    }else{
	    	info = new ItemStack(Material.PAPER);
			ItemMeta infoim = info.getItemMeta();
			infoim.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Info");
		    List<String> ls2 = new ArrayList<String>();
		    ls2.add(ChatColor.GRAY + "Do you want to upgrade your " + LevelListener.choosekit.get(p.getName()).getName());
		    ls2.add(ChatColor.GRAY + "kit to level " + LevelListener.chooselvl.get(p.getName()) + ") ?");
		    ls2.add(ChatColor.GRAY + "This upgrade costs " + LevelListener.chooseprice.get(p.getName()) + "$ !");
		    infoim.setLore(ls2);
		    info.setItemMeta(infoim);
	    }
	    
	    ItemStack glass1 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemStack glass2 = new ItemStack(Material.STAINED_GLASS_PANE);
	    glass1.setDurability(DyeColor.YELLOW.getData());
	    glass2.setDurability(DyeColor.RED.getData());
	    
	    inv.setItem(0, buy);
		inv.setItem(1, glass1);
		inv.setItem(2, glass1);
		inv.setItem(3, glass1);
		inv.setItem(4, info);
		inv.setItem(5, glass2);
		inv.setItem(6, glass2);
		inv.setItem(7, glass2);
	    inv.setItem(8, cancel);
		
		return inv;
	}
	
}
