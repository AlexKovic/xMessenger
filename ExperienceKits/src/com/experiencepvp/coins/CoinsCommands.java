package com.experiencepvp.coins;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.tournaments.TourneyMain;
import com.experiencepvp.scoreboard.ScoreboardMain;

public class CoinsCommands implements CommandExecutor {

	public SettingsManager settings = SettingsManager.getInstance();
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage("You may not execute this command!");
			return false;
		}
		
		Player p = (Player) sender;
		
		//coins alexkovic add 200
		if(cmd.getName().equalsIgnoreCase("coins") || cmd.getName().equalsIgnoreCase("bal") || cmd.getName().equalsIgnoreCase("balance") || cmd.getName().equalsIgnoreCase("eco")){
			if (p.hasPermission("experiencepvp.coins")) {
				if(args.length == 0){
					p.sendMessage(Main.pref + ChatColor.GRAY + "Your balance: " + ChatColor.BLUE + CoinsUtil.getCoins(p) + "$" + ChatColor.GRAY + "!");
				}else if(args.length == 1){
					p.sendMessage(Main.pref + ChatColor.GRAY + args[0] + "'s balance: " + ChatColor.BLUE + CoinsUtil.getCoins(Bukkit.getOfflinePlayer(args[0]).getUniqueId()) + "$" + ChatColor.GRAY + "!");
				}else if(args.length == 3){
					Player on = Bukkit.getServer().getPlayer(args[0]);
					
					if(on == null){
						p.sendMessage(Main.pref + ChatColor.RED + args[0] + " is not online!");
					}
					
					if(!TourneyMain.isInt(args[2])){
						p.sendMessage(Main.pref + ChatColor.RED + "Your amount should be a number!");
						return false;
					}
					
					int amount  = Integer.parseInt(args[2]);
					
					if(args[1].equalsIgnoreCase("add")){
						int ccoins = settings.getData().getInt("coins." + on.getUniqueId());
						settings.getData().set("coins." + on.getUniqueId(), ccoins + amount);
						p.sendMessage(Main.pref + ChatColor.GRAY + "Succesfully added " + ChatColor.BLUE + amount + "$" + ChatColor.GRAY + " to " + ChatColor.BLUE + on.getName() + "'s" + ChatColor.GRAY + " balance. " + ChatColor.BLUE + on.getName() + "'s" + ChatColor.GRAY + " current balance is " + ChatColor.BLUE + CoinsUtil.getCoins(p) + ChatColor.GRAY + "!");
						ScoreboardMain.updateScoreboard(on);
					}else if(args[1].equalsIgnoreCase("remove")){
						int ccoins = settings.getData().getInt("coins." + on.getUniqueId());
						settings.getData().set("coins." + on.getUniqueId(), ccoins - amount);
						p.sendMessage(Main.pref + ChatColor.GRAY + "Succesfully removed " + ChatColor.BLUE + amount + "$" + ChatColor.GRAY + " from " + ChatColor.BLUE + on.getName() + "'s" + ChatColor.GRAY + " balance. " + ChatColor.BLUE + on.getName() + "'s" + ChatColor.GRAY + " current balance is " + ChatColor.BLUE + CoinsUtil.getCoins(p) + ChatColor.GRAY + "!");
						ScoreboardMain.updateScoreboard(on);
					}else if(args[1].equalsIgnoreCase("set")){
						settings.getData().set("coins." + on.getUniqueId(), amount);
						p.sendMessage(Main.pref + ChatColor.GRAY + "Succesfully set " + on.getName() + "'s balance to " + ChatColor.BLUE + amount + ChatColor.GRAY + "!");
						ScoreboardMain.updateScoreboard(on);
					}else{
						p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /coins [Player] [add|remove|set] [amount]");
					}
				}else{
					p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /coins [Player] [add|remove|set] [amount]");
				}
			}
		}else if(cmd.getName().equalsIgnoreCase("pay")){
			if(args.length == 2){
				if(!TourneyMain.isInt(args[1])){
					p.sendMessage(Main.pref + ChatColor.GRAY + "Wrong usage: /pay [Player] [Amount]");
					return false;
				}

				int amount = Integer.parseInt(args[1]);
				
				if(amount < 0){
					p.sendMessage(Main.pref + ChatColor.RED + "You can't pay negative amounts!");
					return false;
				}
				
				if(amount == 0){
					p.sendMessage(Main.pref + ChatColor.RED + "What is the purpose of paying 0$ ?!");
					return false;
				}
				
				if(amount > CoinsUtil.getCoins(p)){
					p.sendMessage(Main.pref + ChatColor.RED + "You don't have " + amount + "$ !");
					return false;
				}
				
				OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
				
				if(!CoinsUtil.hasStats(op.getUniqueId())){
					p.sendMessage(Main.pref + ChatColor.GRAY + "Player '" + op.getName() + "' has never logged in!");
					return false;
				}
				
				CoinsUtil.setCoins(op.getUniqueId(), CoinsUtil.getCoins(op.getUniqueId()) + amount);
				CoinsUtil.setCoins(p.getUniqueId(), CoinsUtil.getCoins(p.getUniqueId()) - amount);
				
				p.sendMessage(Main.pref + ChatColor.GRAY + "You have given " + ChatColor.BLUE + amount + "$" + ChatColor.GRAY + " to " + ChatColor.BLUE + op.getName() + ChatColor.GRAY + "!");
				if(Bukkit.getServer().getPlayer(args[1]) != null){
					Bukkit.getServer().getPlayer(args[1]).sendMessage(Main.pref + ChatColor.GRAY + "You have recieved " + ChatColor.BLUE + amount + "$" + ChatColor.GRAY + " from " + ChatColor.BLUE + p.getName() + ChatColor.GRAY + "!");
				}
			}
		}
		
		return false;
	}

}
