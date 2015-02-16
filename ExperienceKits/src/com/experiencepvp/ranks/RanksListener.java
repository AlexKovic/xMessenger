package com.experiencepvp.ranks;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.experiencepvp.kits.SettingsManager ;

public class RanksListener implements Listener{

	public SettingsManager settings = SettingsManager.getInstance();
	
//	@EventHandler
//	public void onDeathGiveRank(PlayerDeathEvent e){
//		if(e.getEntity().getKiller() instanceof Player){
//			Player p = e.getEntity().getKiller();
//			int kills = settings.getData().getInt("stats." + p.getUniqueId() + ".kills");
//			Rank rank = RankUtil.getRankByMinKills(kills);
//			//SP Rank System
//			if(settings.getData().contains("rank." + p.getUniqueId())){
//				if(rank == null){
//					return;
//				}
//				
//				if(rank.getName().equalsIgnoreCase(settings.getData().getString("rank." + p.getUniqueId()))){
//					return;
//				}
//				
//				settings.getData().set("rank." + p.getUniqueId(), rank.getName());
//				Bukkit.getServer().broadcastMessage(RankUtil.pref + ChatColor.YELLOW + p.getName() + " just recieved the " + ChatColor.BOLD + "" + ChatColor.GOLD + rank.getName() + ChatColor.RESET + "" + ChatColor.GOLD + " (" + rank.getMinKills() + " kills)" + ChatColor.YELLOW + " rank!");
//
//				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddv " + p.getName() + " prefix " + rank.getSymbol() + "&r");
//			}else{
//				if(rank == null){
//					return;
//				}
//				
//				settings.getData().set("rank." + p.getUniqueId(), rank.getName());
//				RankUtil.giveRank(p, rank);
//				Bukkit.getServer().broadcastMessage(RankUtil.pref + ChatColor.YELLOW + p.getName() + " just recieved the " + ChatColor.BOLD + "" + ChatColor.GOLD + rank.getName() + ChatColor.RESET + "" + ChatColor.GOLD + " (" + rank.getMinKills() + " kills)" + ChatColor.YELLOW + " rank!");
//				
//				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddv " + p.getName() + " prefix " + rank.getSymbol() + "&r");
//			}
//			
//			int totalkills = RankUtil.getClanKills(p.getName());
//			ClanRank crank = RankUtil.getClanRankByMinKills(totalkills);
//			
//			//Clan Rank system
//			if(Clan.getRank(Clan.getClanName(p.getName())) != null){
//				if(crank == null){
//					return;
//				}
//				
//				if(crank.getName().equalsIgnoreCase(Clan.getRank(Clan.getClanName(p.getName())).getName())){
//					return;
//				}
//				
//				Clan.setRank(Clan.getClanName(p.getName()), crank);
//				Bukkit.getServer().broadcastMessage(RankUtil.pref + "The " + ChatColor.GOLD + Clan.getClanName(p.getName()) + " clan just recieved the " + ChatColor.BOLD + "" + ChatColor.GOLD + crank.getName() + ChatColor.RESET + "" + ChatColor.GOLD + " (" + crank.getMinKills() + " kills)" + ChatColor.YELLOW + " rank!");
//			}else{
//				if(crank == null){
//					return;
//				}
//
//				Clan.setRank(Clan.getClanName(p.getName()), crank);
//				Bukkit.getServer().broadcastMessage(RankUtil.pref + ChatColor.YELLOW + "The " + ChatColor.GOLD + Clan.getClanName(p.getName()) + ChatColor.YELLOW + " clan just recieved the " + ChatColor.GOLD + crank.getName() + " (" + crank.getMinKills() + " kills)" + ChatColor.YELLOW + " rank!");
//			}
//			
//		}
//	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onClickInv(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getTitle().equalsIgnoreCase(RankUI.getChooseInv().getTitle())){
//			e.setCancelled(true);
//			if(e.getCurrentItem().getType() == Material.MONSTER_EGG){
//				p.closeInventory();
//				p.openInventory(RankUI.getSingleRankInv(p));
//			}else if(e.getCurrentItem().getType() == Material.QUARTZ_ORE){
//				p.closeInventory();
//				p.openInventory(RankUI.getClanRankInv(p));
//			}
		}else if(e.getInventory().getTitle().equalsIgnoreCase(RankUI.getSingleRankInv(p).getTitle())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.REDSTONE){
				p.closeInventory();
				p.openInventory(RankUI.getChooseInv());
			}
//		}else if(e.getInventory().getTitle().equalsIgnoreCase(RankUI.getClanRankInv(p).getTitle())){
//			e.setCancelled(true);
//			if(e.getCurrentItem().getType() == Material.REDSTONE){
//				p.closeInventory();
//				p.openInventory(RankUI.getChooseInv());
//			}
		}
	}
	
}
