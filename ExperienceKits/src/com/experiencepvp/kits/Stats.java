package com.experiencepvp.kits;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.experiencepvp.kits.tournaments.TourneyMain;
import com.experiencepvp.scoreboard.ScoreboardMain;

public class Stats implements Listener, CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();

	String prefix = settings.getConfig().getString("messages.prefix");

	FileConfiguration data = settings.getData();

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (settings.getData().getConfigurationSection(
				"stats." + p.getUniqueId()) == null) {
			settings.getData().set("stats." + p.getUniqueId() + ".deaths",
					(int) 0);
			settings.getData().set("stats." + p.getUniqueId() + ".kills",
					(int) 0);
			settings.getData()
					.set("stats." + p.getUniqueId() + ".tli", (int) 0);
			settings.saveData();
			
		if(!settings.getData().contains("stats." + p.getUniqueId() + ".wins")){
			settings.getData().set("stats." + p.getUniqueId() + ".wins",
					(int) 0);
		}
			Bukkit.getLogger()
					.info("Section for player " + p.getName()
							+ " successfully created in settings.getData().yml");
		} else {
			settings.getData().set(
					"stats." + p.getUniqueId() + ".tli",
					settings.getData().getInt(
							"stats." + p.getUniqueId() + ".tli") + 1);
			settings.saveData();
			return;
		}
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("stats")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You are not a player!");
			}
			Player p = (Player) sender;
			if (settings.getData().getConfigurationSection(
					"stats." + p.getUniqueId()) == null) {
				p.sendMessage(prefix.replaceAll("&", "§")
						+ "There is no section available for you!");
				return true;
			}
			if (args.length == 1) {
				if(args[0].equalsIgnoreCase("reset")){
					if(!p.isOp()){
						return false;
					}
					for(String s : settings.getData().getConfigurationSection("stats").getKeys(false)){
						settings.getData().set("stats." + s + ".kills", 0);
						settings.getData().set("stats." + s + ".deaths", 0);
						settings.getData().set("stats." + s + ".tli", 0);
						settings.getData().set("stats." + s + ".wins", 0);
					}
					
					p.sendMessage("Stats deleted!");
				}
				if (p.hasPermission("experiencepvp.stats.other")) {
					OfflinePlayer check = Bukkit.getOfflinePlayer(args[0]);
					int deaths = settings.getData().getInt(
							"stats." + check.getUniqueId() + ".deaths");
					int kills = settings.getData().getInt(
							"stats." + check.getUniqueId() + ".kills");
					double kd = (double) Math
							.round(((deaths > 0 ? (kills * 1.0)
									/ (deaths * 1.0) : 9001)) * 100) / 100;
					int tli = settings.getData().getInt(
							"stats." + check.getUniqueId() + ".tli");
					int wins = settings.getData().getInt("stats." + check.getUniqueId() + ".wins");
					
					p.sendMessage("Showing stats for " + check.getName());
					p.sendMessage("- Tourney Wins: " + wins);
					p.sendMessage("- Kills: " + kills);
					p.sendMessage("- Deaths: " + deaths);
					p.sendMessage("- KDR: " + kd);
					p.sendMessage("- Times played: " + tli);
					return true;
				}
			}else if(args.length == 2){
				if(args[0].equalsIgnoreCase("edit")){
					if(args[1].equalsIgnoreCase("help")){
						p.sendMessage(ChatColor.RED + "Use /stats edit [player] [kills|deaths|wins] [set|add|remove] [amount]");
					}
				}
				return false;
			}else if(args.length == 5){
				if(args[0].equalsIgnoreCase("edit")){
					if(args[2].equalsIgnoreCase("kills") || args[2].equalsIgnoreCase("deaths") || args[2].equalsIgnoreCase("wins")){
						Player check = Bukkit.getServer().getPlayer(args[1]);
						if(check == null){
							p.sendMessage(ChatColor.RED + args[1] + " is not online!");
							return false;
						}
						
						if(!TourneyMain.isInt(args[4])){
							p.sendMessage(ChatColor.RED + "Your amount must be a number!");
							return false;
						}
						
						int amount = Integer.parseInt(args[4]);

						int deaths = settings.getData().getInt("stats." + check.getUniqueId() + ".deaths");
						int kills = settings.getData().getInt("stats." + check.getUniqueId() + ".kills");
						int wins = settings.getData().getInt("stats." + check.getUniqueId() + ".wins");
						
						if(args[3].equalsIgnoreCase("add")){
							settings.getData().set("stats." + check.getUniqueId() + "." + args[2], settings.getData().getInt("stats." + check.getUniqueId() + "." + args[2]) + amount);
						}else if(args[3].equalsIgnoreCase("remove")){
							settings.getData().set("stats." + check.getUniqueId() + "." + args[2], settings.getData().getInt("stats." + check.getUniqueId() + "." + args[2]) - amount);							
						}else if(args[3].equalsIgnoreCase("set")){
							settings.getData().set("stats." + check.getUniqueId() + "." + args[2], amount);							
						}else{
							p.sendMessage(ChatColor.RED + "Wrong usage: /stats edit help");
						}
					}else{
						p.sendMessage(ChatColor.RED + "Wrong usage: /stats edit help");
					}
				}
				return false;
			}

			int deaths = settings.getData().getInt(
					"stats." + p.getUniqueId() + ".deaths");
			int kills = settings.getData().getInt(
					"stats." + p.getUniqueId() + ".kills");
			double kd = (double) Math.round(((deaths > 0 ? (kills * 1.0)
					/ (deaths * 1.0) : 9001)) * 100) / 100;
			int tli = settings.getData().getInt(
					"stats." + p.getUniqueId() + ".tli");

			int wins = settings.getData().getInt("stats." + p.getUniqueId() + ".wins");

			p.sendMessage("Showing stats for " + p.getName());
			p.sendMessage("- Tourney Wins: " + wins);
			p.sendMessage("- Kills: " + kills);
			p.sendMessage("- Deaths: " + deaths);
			p.sendMessage("- KDR: " + kd);
			p.sendMessage("- Times played: " + tli);
			return true;
		}
		return true;
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();

		e.setDeathMessage("");
		if (settings.getData().getConfigurationSection(
				"stats." + p.getUniqueId()) == null) {
			p.sendMessage(prefix.replaceAll("&", "§")
					+ "There is no section available for you!");
		}
		if (p.getKiller() != null) {
			double kdk = ((double) settings.getData().getInt(
					"stats." + p.getKiller().getUniqueId() + ".kills"))
					/ settings.getData().getInt(
							"stats." + p.getKiller().getUniqueId() + ".deaths");
			Player killer = p.getKiller();
			settings.getData().set(
					"stats." + killer.getUniqueId() + ".kills",
					settings.getData().getInt(
							"stats." + killer.getUniqueId() + ".kills") + 1);
			settings.getData().set(
					"stats." + p.getUniqueId() + ".deaths",
					settings.getData().getInt(
							"stats." + p.getUniqueId() + ".deaths")
							+ (int) 1);
			settings.getData().set(
					"stats." + p.getKiller().getUniqueId() + ".kd", kdk);
			settings.saveData();

			killer.sendMessage(ChatColor.GREEN + "Congratulations on killing "
					+ ChatColor.BLUE + p.getName() + "!");
			ScoreboardMain.updateScoreboard(p);
			ScoreboardMain.updateScoreboard(killer);
		}
		if (p.getKiller() == null) {
			settings.getData().set(
					"stats." + p.getUniqueId() + ".deaths",
					settings.getData().getInt(
							"stats." + p.getUniqueId() + ".deaths")
							+ (int) 1);
			settings.saveData();
			ScoreboardMain.updateScoreboard(p);
		}
	}
}
