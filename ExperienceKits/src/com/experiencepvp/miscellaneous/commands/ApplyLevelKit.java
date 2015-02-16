package com.experiencepvp.miscellaneous.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.experiencepvp.coins.CoinsUtil;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.Spawn;
import com.experiencepvp.kits.tournaments.TourneyMain;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;

public class ApplyLevelKit implements CommandExecutor {
	
	public static SettingsManager settings = SettingsManager.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You may not run this cmd!");
		}

		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("setlevel")) {
			if(!p.hasPermission("experiencepvp.setlevel")){
				p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission!");
				return false;
			}
			if(args.length != 3){
				p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /setlevel [Player] [Kit] [Level]");
			}else{
				KitType kit = null;
				for(KitType kits : KitType.values()){
					if(kits.getName().replace(" ", "").equalsIgnoreCase(args[1])){
						kit = kits;
					}
				}
				
				if(kit == null){
					p.sendMessage(Main.pref + ChatColor.RED + args[1] + " is not a kit!");
					return false;
				}
				
				UUID id = Bukkit.getOfflinePlayer(args[0]).getUniqueId();
				
				
				if(!TourneyMain.isInt(args[2])){
					p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /setlevel [Player] [Kit] [Level]");
					return false;
				}
				
				LevelUtil.setLevel(id, kit, Integer.parseInt(args[2]));
				p.sendMessage(Main.pref + ChatColor.GRAY + "Succesfully set " + ChatColor.GOLD + args[0] + "'s " + kit.getName() + ChatColor.GRAY + " kit to level " + args[2] + ChatColor.GRAY + "!");
			}
		}else if (cmd.getName().equalsIgnoreCase("getlevel")) {
			if(!p.hasPermission("experiencepvp.setlevel")){
				p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission!");
				return false;
			}
			if(args.length != 2){
				p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /getlevel [Player] [Kit]");
			}else{
				KitType kit = null;
				for(KitType kits : KitType.values()){
					if(kit.getName().replaceAll(" ", "").equalsIgnoreCase(args[1])){
						kit = kits;
					}
				}
				
				if(kit == null){
					p.sendMessage(Main.pref + ChatColor.RED + args[1] + " is not a kit!");
					return false;
				}
				
				Player on = Bukkit.getServer().getPlayer(args[0]);
				
				if(on == null){
					UUID id = Bukkit.getOfflinePlayer(args[0]).getUniqueId();
				
					int lvl = LevelUtil.getLevel(id, kit);
					p.sendMessage(Main.pref + ChatColor.GOLD + args[0] + "'s " + kit.getName() + ChatColor.GRAY + " kit is currently level " + ChatColor.GOLD + lvl + ChatColor.GRAY + "!");
					p.sendMessage(Main.pref + ChatColor.RED + "" + ChatColor.BOLD + "This result may be inacurate! Please check if " + args[0] + " has perms for this kit by doing: /manuhasp " + args[0] + " " + kit.getPerm() + "!");
				}else{
					int lvl = LevelUtil.getLevel(on, kit);
					p.sendMessage(Main.pref + ChatColor.GOLD + on.getName() + "'s " + kit.getName() + ChatColor.GRAY + " kit is currently level " + ChatColor.GOLD + lvl + ChatColor.GRAY + "!");
				}
			}
		}else if (cmd.getName().equalsIgnoreCase("listlevel")) {
			if(!p.hasPermission("experiencepvp.listlevel")){
				p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission!");
				return false;
			}
			if(args.length != 1){
				p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /listlevel [Player]");
			}else{
				Player on = Bukkit.getServer().getPlayer(args[0]);
				if(on == null){
					UUID id = Bukkit.getOfflinePlayer(args[0]).getUniqueId();
					p.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Kit Info - " + args[0] + ":");
					for(KitType kit : KitType.values()){
						if(kit.isFree()){
							p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + kit.getName() + ": " + ChatColor.BLUE + "Free");
						}else{
							if(LevelUtil.getLevel(id, kit) == 0){
								p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + kit.getName() + ": " + ChatColor.BLUE + "0" + ChatColor.GRAY + "/" + ChatColor.BLUE + "1" + ChatColor.GRAY + " (Check if player has perm: " + kit.getPerm() + ")");
							}else{
								p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + kit.getName() + ": " + ChatColor.BLUE + LevelUtil.getLevel(id, kit));
							}
						}
					}
				}else{
					p.sendMessage(ChatColor.BLUE + "Kit Info - " + on.getName() + ":");
					for(KitType kit : KitType.values()){
						if(kit.isFree()){
							p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + kit.getName() + ": " + ChatColor.BLUE + "Free");
						}else{
							p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + kit.getName() + ": " + ChatColor.BLUE + LevelUtil.getLevel(on, kit));
						}
					}
				}
			}
		}else if (cmd.getName().equalsIgnoreCase("fixcoins")) {
			if(!p.hasPermission("experiencepvp.fixcoins")){
				p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission!");
				return false;
			}
			if(args.length != 1 && args.length != 0){
				p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /fixcoins or /fixcoins [Player]");
			}else if(args.length == 0){
				int i = 0;
				for(String s : settings.getData().getConfigurationSection("coins").getKeys(false)){
					if(CoinsUtil.getCoins(UUID.fromString(s)) < 0){
						CoinsUtil.setCoins(UUID.fromString(s), 0);
						i++;
					}
				}
				p.sendMessage(Main.pref + ChatColor.GOLD + "" + ChatColor.BOLD + "Fixed " + i + " negative coins problems!");
			}else if(args.length == 1){
				UUID id = Bukkit.getServer().getOfflinePlayer(args[0]).getUniqueId();
				if(CoinsUtil.getCoins(id) < 0){
					CoinsUtil.setCoins(id, 0);
					p.sendMessage(Main.pref + ChatColor.GREEN + args[0] + " coins amount has been fixed!");
				}else{
					p.sendMessage(Main.pref + ChatColor.RED + args[0] + " coins amount was not negative. His balance is " + CoinsUtil.getCoins(id) + "!");
				}
			}
		}else if (cmd.getName().equalsIgnoreCase("listcorrupt")) {
			if(!p.hasPermission("experiencepvp.listcorrupt")){
				p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission!");
				return false;
			}
			if(args.length != 0){
				p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /listcorrupt");
			}else{
				p.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Suspected Players:");
				for(String s : settings.getData().getConfigurationSection("coins").getKeys(false)){ 
					if(CoinsUtil.getCoins(UUID.fromString(s)) > 100000){
						p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + Bukkit.getServer().getOfflinePlayer(UUID.fromString(s)).getName() + " - Reason: " + ChatColor.BLUE + CoinsUtil.getCoins(UUID.fromString(s)) + " coins.");
					}
				}
				for(String kit : settings.getData().getConfigurationSection("level").getKeys(false)){ 
					int i = 0;
					for(String id : settings.getData().getConfigurationSection("level." + kit).getKeys(false)){
						KitType kittype = null;
						for(KitType kt : KitType.values()){
							if(kt.getName().replaceAll(" ", "").equalsIgnoreCase(kit)){
								kittype = kt;
							}
						}
						if(kittype != null){
							if(LevelUtil.getLevel(UUID.fromString(id), kittype) == 4){
								i++;
							}
						}
						if(i > 20){
							p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + Bukkit.getServer().getOfflinePlayer(UUID.fromString(id)).getName() + " - Reason: " + ChatColor.BLUE + i + " Level 4 kits.");
						}
					}
				}
			}
		}else if (cmd.getName().equalsIgnoreCase("resetlevel")) {
			if(!p.hasPermission("experiencepvp.resetlevel")){
				p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission!");
				return false;
			}
			if(args.length != 1){
				p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /resetlevel [Player]");
			}else{
				for(KitType kit : KitType.values()){
					LevelUtil.setLevel(Bukkit.getOfflinePlayer(args[0]).getUniqueId(), kit, 0);
				}
				p.sendMessage(Main.pref + ChatColor.GREEN + "All " + args[0] + "'s kits have been reset!");
			}
		}
		return true;
	}
	
}
