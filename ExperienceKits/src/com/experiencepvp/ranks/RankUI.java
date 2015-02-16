package com.experiencepvp.ranks;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RankUI {

	public static Inventory getSingleRankInv(Player p){
		Inventory inv = Bukkit.createInventory(p, 27, ChatColor.BLUE + "SP Ranks");
		inv.setMaxStackSize(1);
		inv.setItem(0, new ItemStack(Material.THIN_GLASS));
		inv.setItem(1, new ItemStack(Material.THIN_GLASS));
		inv.setItem(2, new ItemStack(Material.THIN_GLASS));
		inv.setItem(3, new ItemStack(Material.THIN_GLASS));
		inv.setItem(4, new ItemStack(Material.REDSTONE));
		inv.setItem(5, new ItemStack(Material.THIN_GLASS));
		inv.setItem(6, new ItemStack(Material.THIN_GLASS));
		inv.setItem(7, new ItemStack(Material.THIN_GLASS));
		inv.setItem(8, new ItemStack(Material.THIN_GLASS));
		
		for(Rank r : Rank.values()){
			ItemStack is = RankUtil.getKitItem(r);
			if(RankUtil.getPlayerRank(p) != null){
				if(RankUtil.getPlayerRank(p).getId() >= r.getId()){
					is.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				}
			}
			inv.addItem(is);
		}
		
		inv.setItem(18, new ItemStack(Material.THIN_GLASS));
		inv.setItem(19, new ItemStack(Material.THIN_GLASS));
		inv.setItem(20, new ItemStack(Material.THIN_GLASS));
		inv.setItem(21, new ItemStack(Material.THIN_GLASS));
		inv.setItem(22, new ItemStack(Material.THIN_GLASS));
		inv.setItem(23, new ItemStack(Material.THIN_GLASS));
		inv.setItem(24, new ItemStack(Material.THIN_GLASS));
		inv.setItem(25, new ItemStack(Material.THIN_GLASS));
		inv.setItem(26, new ItemStack(Material.THIN_GLASS));
		
		return inv;
	}
	
	
//	public static Inventory getClanRankInv(Player p){
//		Inventory inv = Bukkit.createInventory(p, 27, ChatColor.BLUE + "Clan Ranks");
//		inv.setMaxStackSize(1);
//		inv.setItem(0, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(1, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(2, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(3, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(4, new ItemStack(Material.REDSTONE));
//		inv.setItem(5, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(6, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(7, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(8, new ItemStack(Material.THIN_GLASS));
//		
//		for(ClanRank r : ClanRank.values()){
//			ItemStack is = RankUtil.getClanItem(r);
//			if(Clan.getRank(Clan.getClanName(p.getName())) != null){
//				if(Clan.getRank(Clan.getClanName(p.getName())).getId() >= r.getId()){
//					is.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
//				}
//			}
//			inv.addItem(is);
//		}
//		
//		inv.setItem(18, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(19, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(20, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(21, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(22, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(23, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(24, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(25, new ItemStack(Material.THIN_GLASS));
//		inv.setItem(26, new ItemStack(Material.THIN_GLASS));
//		
//		return inv;
//	}
	
	
	@SuppressWarnings("deprecation")
	public static Inventory getChooseInv(){
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.BLUE + "Category's");
		inv.setMaxStackSize(1);
		inv.setItem(0, new ItemStack(Material.THIN_GLASS));
		inv.setItem(1, new ItemStack(Material.THIN_GLASS));
		inv.setItem(2, new ItemStack(Material.THIN_GLASS));
		inv.setItem(3, new ItemStack(Material.THIN_GLASS));
		inv.setItem(4, new ItemStack(Material.THIN_GLASS));
		inv.setItem(5, new ItemStack(Material.THIN_GLASS));
		inv.setItem(6, new ItemStack(Material.THIN_GLASS));
		inv.setItem(7, new ItemStack(Material.THIN_GLASS));
		inv.setItem(8, new ItemStack(Material.THIN_GLASS));
		inv.setItem(9, new ItemStack(Material.THIN_GLASS));
		inv.setItem(10, new ItemStack(Material.THIN_GLASS));
		
		ItemStack quartz = new ItemStack(Material.QUARTZ_ORE);
		ItemMeta quartzim = quartz.getItemMeta();
		quartzim.setDisplayName(ChatColor.BLUE + "Clan Ranks");
		quartz.setItemMeta(quartzim);
		inv.setItem(11, quartz);
		
		inv.setItem(12, new ItemStack(Material.THIN_GLASS));
		inv.setItem(13, new ItemStack(Material.THIN_GLASS));
		inv.setItem(14, new ItemStack(Material.THIN_GLASS));

		ItemStack spider = new ItemStack(Material.MONSTER_EGG, 1, EntityType.SPIDER.getTypeId());
		ItemMeta spiderim = spider.getItemMeta();
		spiderim.setDisplayName(ChatColor.BLUE + "Single Player Ranks");
		spider.setItemMeta(spiderim);
		inv.setItem(15, spider);

		inv.setItem(16, new ItemStack(Material.THIN_GLASS));
		inv.setItem(17, new ItemStack(Material.THIN_GLASS));
		inv.setItem(18, new ItemStack(Material.THIN_GLASS));
		inv.setItem(19, new ItemStack(Material.THIN_GLASS));
		inv.setItem(20, new ItemStack(Material.THIN_GLASS));
		inv.setItem(21, new ItemStack(Material.THIN_GLASS));
		inv.setItem(22, new ItemStack(Material.THIN_GLASS));
		inv.setItem(23, new ItemStack(Material.THIN_GLASS));
		inv.setItem(24, new ItemStack(Material.THIN_GLASS));
		inv.setItem(25, new ItemStack(Material.THIN_GLASS));
		inv.setItem(26, new ItemStack(Material.THIN_GLASS));
		
		return inv;
	}
}
