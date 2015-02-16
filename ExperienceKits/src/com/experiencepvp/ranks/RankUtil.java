package com.experiencepvp.ranks;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.experiencepvp.coins.CoinsUtil;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.sheduledcommands.ScheduledCommandsMain;

public class RankUtil {	
	
	public static SettingsManager settings = SettingsManager.getInstance();
	public static String pref = ChatColor.BOLD + "" + ChatColor.AQUA + "Ranks" + ChatColor.RESET + ">> ";
	
	public static Rank getRank(int i){
		Rank r = null;
		
		return r;
	}
	
	public static Rank getPlayerRank(Player p){
		Rank rank = null;
		if(!settings.getData().contains("rank." + p.getUniqueId())){
			return null;
		}
		for(Rank r : Rank.values()){
			if(r.getName().equalsIgnoreCase(settings.getData().getString("rank." + p.getUniqueId()))){
				rank = r;
			}
		}
		
		return rank;
	}
	
	
	public static Rank getRankByMinKills(int i){
		Rank rank = null;
		for(Rank r : Rank.values()){
			if(i >= r.getMinKills()){
				rank = r;
			}
		}
		
		return rank;
	}
	
	public static ClanRank getClanRankByMinKills(int i){
		ClanRank crank = null;
		for(ClanRank cr : ClanRank.values()){
			if(i >= cr.getMinKills()){
				crank = cr;
			}
		}
		
		return crank;
	}
	
	public static Rank getRankById(int id) {
		Rank rank = null;
		for(Rank r : Rank.values()){
			if(id >= r.getId()){
				rank = r;
			}
		}
		return rank;
	}
	
	public static Rank getRankByName(String name){
		Rank rank = null;
		for(Rank r : Rank.values()){
			if(r.getName().equalsIgnoreCase(name)){
				rank = r;
			}
		}
		return rank;
	}
	
	public static ClanRank getClanRankByName(String name){
		ClanRank crank = null;
		for(ClanRank cr : ClanRank.values()){
			if(cr.getName().equalsIgnoreCase(name)){
				crank = cr;
			}
		}
		return crank;
	}
	
//	@SuppressWarnings("deprecation")
//	public static int getClanKills(String name){
//		List<String> pList = Clan.getPlayers(Clan.getClanName(name));
//		int tkills = 0;
//		
//		for(String s : pList){
//			OfflinePlayer op = Bukkit.getServer().getOfflinePlayer(s);
//			tkills += settings.getData().getInt("stats." + op.getUniqueId() + ".kills");
//		}
//		
//		return tkills;
//	}
	
	public static void giveRank(Player p, Rank rank){
		//check of ze all kits perm hebben of gold rank!
		
		if(rank == Rank.AQUA){
			if(!p.hasPermission("experiencepvp.kit.all")){
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddp " + p.getName() + " experiencepvp.kit.all");
				ScheduledCommandsMain.addCommand("manudelp " + p.getName() + " experiencepvp.kit.all", 60);
			}else{
				CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) + 1000);
				p.sendMessage(Main.pref + ChatColor.RED + "You already have every kit, so you recieved 1000 coins instead!");
			}
		}else if(rank == Rank.HYRO){
			if(!p.hasPermission("experiencepvp.kit.all")){
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddp " + p.getName() + " experiencepvp.kit.all");
				ScheduledCommandsMain.addCommand("manudelp " + p.getName() + " experiencepvp.kit.all", 60);
			}else{
				CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) + 1000);
				p.sendMessage(Main.pref + ChatColor.RED + "You already have every kit, so you recieved 1000 coins instead!");
			}
		}else if(rank == Rank.HERUS){
			if(!p.hasPermission("experiencepvp.rank.gold")){
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuadd " + p.getName() + " Gold");
				ScheduledCommandsMain.addCommand("manuadd " + p.getName() + " Member", 60);
			}else{
				CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) + 1000);
				p.sendMessage(Main.pref + ChatColor.RED + "You already have all permissions of the Gold rank, so you recieved 1000 coins instead!");				
			}
		}else if(rank == Rank.DOMINATOR){
			if(!p.hasPermission("experiencepvp.kit.all")){
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddp " + p.getName() + " experiencepvp.kit.all");
				ScheduledCommandsMain.addCommand("manudelp " + p.getName() + " experiencepvp.kit.all", 60);
			}else{
				CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) + 1000);
				p.sendMessage(Main.pref + ChatColor.RED + "You already have every kit, so you recieved 1000 coins instead!");
			}			
		}else if(rank == Rank.DRYGUN){
			if(!p.hasPermission("experiencepvp.kit.all")){
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddp " + p.getName() + " experiencepvp.kit.all");
				ScheduledCommandsMain.addCommand("manudelp " + p.getName() + " experiencepvp.kit.all", 60);
			}else{
				CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) + 1000);
				p.sendMessage(Main.pref + ChatColor.RED + "You already have every kit, so you recieved 1000 coins instead!");
			}			
		}else if(rank == Rank.LOTIUM){
			if(!p.hasPermission("experiencepvp.kit.all")){
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddp " + p.getName() + " experiencepvp.kit.all");
				ScheduledCommandsMain.addCommand("manudelp " + p.getName() + " experiencepvp.kit.all", 60);
			}else{
				CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) + 1000);
				p.sendMessage(Main.pref + ChatColor.RED + "You already have every kit, so you recieved 1000 coins instead!");
			}			
		}else if(rank == Rank.NYTRO){
			if(!p.hasPermission("experiencepvp.rank.gold")){
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuadd " + p.getName() + " Gold");
				ScheduledCommandsMain.addCommand("manuadd " + p.getName() + " Member", 60);
			}else{
				CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) + 1000);
				p.sendMessage(Main.pref + ChatColor.RED + "You already have all permissions of the Gold rank, so you recieved 1000 coins instead!");				
			}			
		}else if(rank == Rank.TERRA){
			if(!p.hasPermission("experiencepvp.kit.all")){
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddp " + p.getName() + " experiencepvp.kit.all");
				ScheduledCommandsMain.addCommand("manudelp " + p.getName() + " experiencepvp.kit.all", 60);
			}else{
				CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) + 1000);
				p.sendMessage(Main.pref + ChatColor.RED + "You already have every kit, so you recieved 1000 coins instead!");
			}
		}else if(rank == Rank.ZEATH){
			if(!p.hasPermission("experiencepvp.rank.gold")){
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuadd " + p.getName() + " Gold");
				ScheduledCommandsMain.addCommand("manuadd " + p.getName() + " Member", 180);
			}else{
				CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) + 2000);
				p.sendMessage(Main.pref + ChatColor.RED + "You already have all permissions of the Gold rank, so you recieved 2000 coins instead!");				
			}			
		}
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack getKitItem(Rank r){
		ItemStack is = null;
		if(r == Rank.AQUA){
			ItemStack aqua = new ItemStack(Material.MONSTER_EGG, 1, EntityType.SHEEP.getTypeId());
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			//ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Coins: " + ChatColor.GRAY + r.getCoins());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Symbol: " + ChatColor.GRAY + r.getSymbol());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All kits for 1 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
			
			is = aqua;
		}else if(r == Rank.HYRO){
			ItemStack aqua = new ItemStack(Material.MONSTER_EGG, 1, EntityType.ZOMBIE.getTypeId());
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			//ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Coins: " + ChatColor.GRAY + r.getCoins());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Symbol: " + ChatColor.GRAY + r.getSymbol());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All kits for 1 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
		
			is = aqua;
		}else if(r == Rank.HERUS){
			ItemStack aqua = new ItemStack(Material.MONSTER_EGG, 1, EntityType.HORSE.getTypeId());
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			//ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Coins: " + ChatColor.GRAY + r.getCoins());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Symbol: " + ChatColor.GRAY + r.getSymbol());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "Gold Rank for 1 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
		
			is = aqua;
		}else if(r == Rank.DOMINATOR){
			ItemStack aqua = new ItemStack(Material.MONSTER_EGG, 1, EntityType.COW.getTypeId());
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			//ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Coins: " + ChatColor.GRAY + r.getCoins());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Symbol: " + ChatColor.GRAY + r.getSymbol());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All kits for 1 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
			
			is = aqua;
		}else if(r == Rank.DRYGUN){
			ItemStack aqua = new ItemStack(Material.MONSTER_EGG, 1, EntityType.SQUID.getTypeId());
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			//ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Coins: " + ChatColor.GRAY + r.getCoins());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Symbol: " + ChatColor.GRAY + r.getSymbol());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All kits for 1 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
			
			is = aqua;
		}else if(r == Rank.LOTIUM){
			ItemStack aqua = new ItemStack(Material.MONSTER_EGG, 1, EntityType.MUSHROOM_COW.getTypeId());
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			//ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Coins: " + ChatColor.GRAY + r.getCoins());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Symbol: " + ChatColor.GRAY + r.getSymbol());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All kits for 1 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
			
			is = aqua;
		}else if(r == Rank.NYTRO){
			ItemStack aqua = new ItemStack(Material.MONSTER_EGG, 1, EntityType.MAGMA_CUBE.getTypeId());
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			//ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Coins: " + ChatColor.GRAY + r.getCoins());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Symbol: " + ChatColor.GRAY + r.getSymbol());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "Gold Rank for 1 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
			
			is = aqua;
		}else if(r == Rank.TERRA){
			ItemStack aqua = new ItemStack(Material.MONSTER_EGG, 1, EntityType.ENDERMAN.getTypeId());
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			//ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Coins: " + ChatColor.GRAY + r.getCoins());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Symbol: " + ChatColor.GRAY + r.getSymbol());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All kits for 1 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
			
			is = aqua;
		}else if(r == Rank.ZEATH){
			ItemStack aqua = new ItemStack(Material.MONSTER_EGG, 1, EntityType.SPIDER.getTypeId());
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			//ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Coins: " + ChatColor.GRAY + r.getCoins());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Symbol: " + ChatColor.GRAY + r.getSymbol());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "Gold Rank for 3 hours!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
			
			is = aqua;
		}
		
		return is;
	}
	
	public static ItemStack getClanItem(ClanRank r){
		ItemStack is = null;
		if(r == ClanRank.COAL){
			ItemStack aqua = new ItemStack(Material.COAL_ORE);
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Color: " + ChatColor.GRAY + "Black");
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All members get all kits for 3 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
			
			is = aqua;
		}else if(r == ClanRank.IRON){
			ItemStack aqua = new ItemStack(Material.IRON_ORE);
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Color: " + ChatColor.GRAY + "White");
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All members get all kits for 3 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
		
			is = aqua;
		}else if(r == ClanRank.REDSTONE){
			ItemStack aqua = new ItemStack(Material.REDSTONE_ORE);
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Color: " + ChatColor.GRAY + "Dark Red");
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All members get all kits for 3 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
		
			is = aqua;
		}else if(r == ClanRank.LAPIS){
			ItemStack aqua = new ItemStack(Material.LAPIS_ORE);
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Color: " + ChatColor.GRAY + "Dark Blue");
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All members get the Gold Rank for 3 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
			
			is = aqua;
		}else if(r == ClanRank.GOLD){
			ItemStack aqua = new ItemStack(Material.GOLD_ORE);
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Color: " + ChatColor.GRAY + "Gold");
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All members get all kits for 3 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
			
			is = aqua;
		}else if(r == ClanRank.EMERALD){
			ItemStack aqua = new ItemStack(Material.EMERALD_ORE);
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Color: " + ChatColor.GRAY + "Green");
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All members get all kits for 3 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
			
			is = aqua;
		}else if(r == ClanRank.DIAMOND){
			ItemStack aqua = new ItemStack(Material.DIAMOND_ORE);
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Color: " + ChatColor.GRAY + "Aqua");
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All members get all kits for 3 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
			
			is = aqua;
		}else if(r == ClanRank.PLATINUM){
			ItemStack aqua = new ItemStack(Material.GLOWSTONE);
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Color: " + ChatColor.GRAY + "Light Purple");
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All members get all kits for 3 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
			
			is = aqua;
		}else if(r == ClanRank.QUARTZ){
			ItemStack aqua = new ItemStack(Material.QUARTZ_ORE);
			ItemMeta aquaim = aqua.getItemMeta();
			aquaim.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + r.getName());
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Kills: " + ChatColor.GRAY + r.getMinKills());
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Color: " + ChatColor.GRAY + "Blue");
			ls.add(ChatColor.AQUA + "•  " + ChatColor.WHITE + "Prize: " + ChatColor.GRAY + "All members get the Gold Rank for 3 hour!");
			aquaim.setLore(ls);
			aqua.setItemMeta(aquaim);
			
			is = aqua;
		}
		
		return is;
	}
}
