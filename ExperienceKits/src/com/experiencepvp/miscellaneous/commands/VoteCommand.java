package com.experiencepvp.miscellaneous.commands;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.Spawn;
import com.experiencepvp.oneversusone.OneVOneListener;

@SuppressWarnings("deprecation")
public class VoteCommand implements CommandExecutor, Listener {
	
	public static SettingsManager settings = SettingsManager.getInstance();
	
	public HashMap<String, Integer> voting = new HashMap<String, Integer>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You may not run this cmd!");
		}

		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("votespawn")) {
			if(!p.hasPermission("experiencepvp.votespawn")){
				p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission!");
				return false;
			}
			if(args.length != 1){
				p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /votespawn [1 / 2]");
			}else{
				if(OneVOneListener.lobby1v1.contains(p.getName())){
					p.sendMessage(Main.pref + ChatColor.RED + "You can't use this command here!");
					return false;
				}
				
				if(args[0].equalsIgnoreCase("1")){
					voting.put(p.getName(), 1);
					p.teleport(new Location(p.getWorld(), 455334, 6, 321));
					
					p.sendMessage(Main.pref + ChatColor.BLUE + "" + ChatColor.BOLD + "Are you sure you want to vote on this spawn (Spawn 1) ?");				
					p.sendMessage(Main.pref + ChatColor.BLUE + "" + ChatColor.BOLD + "Type " + ChatColor.GREEN + "" + ChatColor.BOLD + "yes" + ChatColor.BLUE + "" + ChatColor.BOLD + " to vote for Spawn 1 or type " + ChatColor.RED + "" + ChatColor.RED + "" + ChatColor.BOLD + "No" + ChatColor.BLUE + "" + ChatColor.BOLD + " to cancel!");	
				}else if(args[0].equalsIgnoreCase("2")){
					voting.put(p.getName(), 2);
					p.teleport(new Location(p.getWorld(), 99894, 7, 100290));
					
					p.sendMessage(Main.pref + ChatColor.BLUE + "" + ChatColor.BOLD + "Are you sure you want to vote on this spawn (Spawn 2) ?");
					p.sendMessage(Main.pref + ChatColor.BLUE + "" + ChatColor.BOLD + "Type " + ChatColor.GREEN + "" + ChatColor.BOLD + "yes" + ChatColor.BLUE + "" + ChatColor.BOLD + " to vote for Spawn 2 or type " + ChatColor.RED + "" + ChatColor.RED + "" + ChatColor.BOLD + "No" + ChatColor.BLUE + "" + ChatColor.BOLD + " to cancel!");
				}else{
					p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /votespawn [1 / 2]");
					return false;					
				}
			}
		}else if (cmd.getName().equalsIgnoreCase("seespawn")) {
			if(!p.hasPermission("experiencepvp.seespawn")){
				p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission!");
				return false;
			}
			if(args.length != 1){
				p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /seespawn [1 / 2]");
			}else{
				if(hasAlreadyVoted(p.getUniqueId())){
					p.sendMessage(Main.pref + ChatColor.RED + "You already voted!");
					return false;
				}
				
				if(OneVOneListener.lobby1v1.contains(p.getName())){
					p.sendMessage(Main.pref + ChatColor.RED + "You can't use this command here!");
					return false;
				}
				
				if(args[0].equalsIgnoreCase("1")){
					p.teleport(new Location(p.getWorld(), 455334, 6, 321));
					p.sendMessage(Main.pref + ChatColor.BLUE + "" + ChatColor.BOLD + "Vote on this spawn by typing: /votespawn 1");
					p.sendMessage(Main.pref + ChatColor.BLUE + "" + ChatColor.BOLD + "Look at the other spawn by typing: /seespawn 2");
				}else if(args[0].equalsIgnoreCase("2")){
					p.teleport(new Location(p.getWorld(), 99894, 7, 100290));
					p.sendMessage(Main.pref + ChatColor.BLUE + "" + ChatColor.BOLD + "Vote on this spawn by typing: /votespawn 2");
					p.sendMessage(Main.pref + ChatColor.BLUE + "" + ChatColor.BOLD + "Look at the other spawn by typing: /seespawn 1");
				}else{
					p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /seespawn [1 / 2]");
					return false;					
				}
			}
		}else if (cmd.getName().equalsIgnoreCase("listspawn")) {
			if(!p.hasPermission("experiencepvp.listspawn")){
				p.sendMessage(Main.pref + ChatColor.RED + "You don't have permission!");
				return false;
			}
			if(args.length != 0){
				p.sendMessage(Main.pref + ChatColor.RED + "Wrong usage: /listspawn");
			}else{
				p.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Spawn Votes:");
				p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + "Spawn 1: " + ChatColor.BLUE + getVote(1));
				p.sendMessage(ChatColor.BLUE + "- " + ChatColor.GRAY + "Spawn 2: " + ChatColor.BLUE + getVote(2));
			}
		}
		return false;
	}
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onChat(PlayerChatEvent e){
		Player p = e.getPlayer();
		if(voting.containsKey(p.getName())){
			if(e.getMessage().equalsIgnoreCase("yes")){
				addVote(p.getUniqueId(), voting.get(p.getName()));

				voting.remove(p.getName());
				p.teleport(Spawn.getSpawnLoc());
				p.sendMessage(Main.pref + ChatColor.GREEN + "" + ChatColor.BOLD + "Succesfully voted on Spawn " + voting.get(p.getName()) + " !");
			}else if(e.getMessage().equalsIgnoreCase("no")){
				voting.remove(p.getName());
				p.teleport(Spawn.getSpawnLoc());
				p.sendMessage(Main.pref + ChatColor.RED + "" + ChatColor.BOLD + "Succesfully cancelled voting!");
			}else{
				e.setCancelled(true);
				p.sendMessage(Main.pref + ChatColor.BLUE + "" + ChatColor.BOLD + "Type " + ChatColor.GREEN + "" + ChatColor.BOLD + "yes" + ChatColor.BLUE + "" + ChatColor.BOLD + " to vote for Spawn" + voting.get(p.getName()) + "or type " + ChatColor.RED + "" + ChatColor.RED + "" + ChatColor.BOLD + "No" + ChatColor.BLUE + "" + ChatColor.BOLD + " to cancel!");
			}
		}
	}
	
	@EventHandler
	public void onClickSign(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getClickedBlock() != null){
			if(e.getClickedBlock().getType() == Material.SIGN || e.getClickedBlock().getType() == Material.SIGN_POST){
				Sign sign = (Sign) e.getClickedBlock().getState();
				if(sign.getLine(1).equalsIgnoreCase(ChatColor.BLUE + "Look at:") && sign.getLine(1).equalsIgnoreCase(ChatColor.BLUE + "Spawn 1")){
					p.performCommand("seespawn 1");
				}else if(sign.getLine(1).equalsIgnoreCase(ChatColor.BLUE + "Look at:") && sign.getLine(1).equalsIgnoreCase(ChatColor.BLUE + "Spawn 2")){
					p.performCommand("seespawn 2");
				}
			}
		}
	}
	
	public void addVote(UUID id, int i){
		if(i == 1){
			settings.getData().set("playervotespawn." + id, true);
			settings.getData().set("votespawn.1", getVote(1) + 1);
			settings.saveData();
		}else if(i == 2){
			settings.getData().set("playervotespawn." + id, true);
			settings.getData().set("votespawn.2", getVote(2) + 1);
			settings.saveData();
		}
	}
	
	public int getVote(int i){
		if(i == 1){
			if(!settings.getData().contains("votespawn.1")) return 0;
			return settings.getData().getInt("votespawn.1");
		}else if(i == 2){
			if(!settings.getData().contains("votespawn.2")) return 0;
			return settings.getData().getInt("votespawn.2");			
		}
		
		return 0;
	}
	
	public boolean hasAlreadyVoted(UUID id){
		if(!settings.getData().contains("playervotespawn." + id)) return false;
		return settings.getData().getBoolean("playervotespawn." + id);
	}
}
