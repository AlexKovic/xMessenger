package com.experiencepvp.coins;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;

public class CoinsListener implements Listener {
	
	public SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(!settings.getData().contains("coins." + p.getUniqueId())){
			settings.getData().set("coins." + p.getUniqueId(), 0);
		}
		
//		if(!p.hasPermission("experiencepvp.rank.gold")) return;
//		
//		if(!settings.getData().contains("coins." + p.getUniqueId() + ".addtime")){
//			settings.getData().set("coins." + p.getUniqueId() + ".addtime", System.currentTimeMillis());
//			CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) + 50);
//			p.sendMessage(Main.pref + ChatColor.GRAY + "You recieved " + ChatColor.GOLD + "50$" + ChatColor.GRAY + " for joining the server today!");
//			return;
//		}
//		
//		long b4 = settings.getData().getLong("coins." + p.getUniqueId() + ".addtime");
//		long now = System.currentTimeMillis();
//		if((now - b4) >= 24 * 60 * 60 * 1000){
//			settings.getData().set("coins." + p.getUniqueId(), ".addtime");
//			CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) + 50);
//			p.sendMessage(Main.pref + ChatColor.GRAY + "You recieved " + ChatColor.GOLD + "50$" + ChatColor.GRAY + " for joining the server today!");			
//		}
	}
	
	@EventHandler
	public void onDeath(final PlayerDeathEvent e){
		if(e.getEntity().getKiller() instanceof Player){
			final Player p = e.getEntity().getKiller();
			int ckills = settings.getData().getInt("coins." + p.getUniqueId());
			settings.getData().set("coins." + p.getUniqueId(), ckills + (p.hasPermission("experiencepvp.rank.gold") ? 10 : 5));
			new BukkitRunnable(){
				public void run(){
					p.sendMessage(Main.pref + ChatColor.BLUE + "You recieved " + ChatColor.AQUA + (p.hasPermission("experiencepvp.rank.gold") ? "10" : "5") + "$" + ChatColor.BLUE + " for killing " + ChatColor.AQUA + e.getEntity().getName() + ChatColor.BLUE + "!");
				}
			}.runTaskLater(Main.getPlugin(), 1);
		}
	}
	
}
