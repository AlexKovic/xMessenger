package com.experiencepvp.freekit;

import java.util.Calendar;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.utils.KitType;

public class FreeKitMain {
	
	public static SettingsManager settings = SettingsManager.getInstance();
	
	public static void giveTempFreeKit(final Player p){
		final KitType kit = KitType.getRandomKit();
		final String name = kit.getName();
		
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " " + kit.getPerm());
		p.sendMessage("§7You have recieved the §6" + name + " §7kit!");
		settings.getFreeKits().set("freekits." + p.getName() + ".kit", kit.toString());
		settings.getFreeKits().set("freekits." + p.getName() + ".wait", (int) 60);
		settings.saveFreekits();
		
		new BukkitRunnable() {
			public void run() {
				settings.getFreeKits().set("freekits." + p.getName() + ".wait", settings.getFreeKits().getInt("freekits." + p.getName() + ".wait") - 1);
				settings.saveFreekits();
				
				if (settings.getFreeKits().getInt("freekits." + p.getName() + ".wait") == 0) {
					this.cancel();
					settings.getFreeKits().set("freekits." + p.getName(), null);
					settings.saveFreekits();
					List<String> cant = settings.getFreeKits().getStringList("freekits.cant");
					cant.add(p.getName());
					settings.getFreeKits().set("freekits.cant", cant);
					settings.saveFreekits();
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manudelp " + p.getName() + " " + kit.getPerm());
					if (p.isOnline()) {
						p.sendMessage("§7You no longer have your §6" + name + " §7kit!");
						p.sendMessage("§7Do you want your kit for lifetime? Buy the kit here: §6http://buy.experiencepvp.eu §7!");
					} else {
						return;
					}
				}
			}
		}.runTaskTimer(Main.getPlugin(), 1200, 1200);
		
		new BukkitRunnable() {
			public void run() {
				if (isMidnight()) {
					List<String> cant = settings.getFreeKits().getStringList("freekits.cant");
					cant.remove(p.getName());
					settings.getFreeKits().set("freekits.cant", cant);
					settings.saveFreekits();
					if (p.isOnline()) {
						p.sendMessage("§7You can now choose a §6free kit §7again!");
					}
				}
			}
		}.runTaskTimer(Main.getPlugin(), 1200, 1200);
	}

	public static boolean hasFreeKit(Player p, String s) {
		if (settings.getFreeKits().getString("freekits." + p.getName() + ".kit") == s) {
			return true;
		}
		return false;
	}
	
	public static boolean canGetFreeKit(Player p) {
		if (settings.getFreeKits().getConfigurationSection("freekits." + p.getName()) == null) {
			return true;
		} 
		return false;
	}
	
	public static boolean isMidnight() {
		Calendar myCal = Calendar.getInstance();
		myCal.setTimeInMillis(System.currentTimeMillis());
		return myCal.get(Calendar.HOUR_OF_DAY) == 0
		       && myCal.get(Calendar.MINUTE) == 0;
	}
}
