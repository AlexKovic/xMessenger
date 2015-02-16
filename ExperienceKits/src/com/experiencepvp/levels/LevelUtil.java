package com.experiencepvp.levels;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.experiencepvp.coins.CoinsUtil;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.utils.KitType;

import de.slikey.effectlib.effect.AnimatedBallEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class LevelUtil {

	public static SettingsManager settings = SettingsManager.getInstance();
	
	public static int getLevel(Player p, KitType kit){
		if(settings.getData().contains("levels." + kit.getName().replaceAll(" ", "") + "." + p.getUniqueId())){
			return settings.getData().getInt("levels." + kit.getName() + "." + p.getUniqueId());
		}else if(p.hasPermission(kit.getPerm())){
			return 1;
		}else if(kit.isFree()){
			return 1;
		}else if(p.hasPermission("experiencepvp.kit.all")){
			return 1;
		}else{
			return 0;
		}
	}
	
	public static int getLevel(UUID id, KitType kit){
		if(settings.getData().contains("levels." + kit.getName().replaceAll(" ", "") + "." + id)){
			return settings.getData().getInt("levels." + kit.getName() + "." + id);
		}else if(kit.isFree()){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	public static void setLevel(Player p, KitType kit, int level){
		settings.getData().set("levels." + kit.getName().replaceAll(" ", "") + "." + p.getUniqueId(), level);
	}
	
	public static void setLevel(UUID id, KitType kit, int level){
		settings.getData().set("levels." + kit.getName().replaceAll(" ", "") + "." + id, level);
	}
	
	public static void removeLevel(Player p, KitType kit){
		settings.getData().set("levels." + kit.getName().replaceAll(" ", "") + "." + p.getUniqueId(), 0);
	}
	
	public static HashMap<String, Integer> flyint = new HashMap<String, Integer>();
	
	public static void buyKit(final Player p, final KitType kit, final int lvl){
    	p.sendMessage(Main.pref + ChatColor.AQUA + "Charging...");
    	
    	flyint.put(p.getName(), 0);
    	new BukkitRunnable(){
    		public void run(){
    			p.setVelocity(new Vector(0, 0.1, 0));
    			flyint.put(p.getName(), flyint.get(p.getName()) + 1);
    			if(flyint.get(p.getName()) >= 30){
    				p.setFallDistance(5.0F);
    				this.cancel();
    			}
    		}
    	}.runTaskTimer(Main.getPlugin(), 2, 2);
		  
    	final AnimatedBallEffect eff = new AnimatedBallEffect(Main.em);
    	eff.setLocation(p.getLocation());
    	eff.particle = ParticleEffect.FLAME;
    	
    	final AnimatedBallEffect eff2 = new AnimatedBallEffect(Main.em);
    	eff2.setLocation(p.getLocation());
    	eff2.particle = ParticleEffect.ENCHANTMENT_TABLE;
		  
    	final AnimatedBallEffect eff3 = new AnimatedBallEffect(Main.em);
    	eff3.particle = ParticleEffect.FLAME;
    	
    	final AnimatedBallEffect eff4 = new AnimatedBallEffect(Main.em);
    	eff4.particle = ParticleEffect.ENCHANTMENT_TABLE;
		  
    	final AnimatedBallEffect eff5 = new AnimatedBallEffect(Main.em);
    	eff5.particle = ParticleEffect.FLAME;
		  
    	final AnimatedBallEffect eff6 = new AnimatedBallEffect(Main.em);
    	eff6.particle = ParticleEffect.ENCHANTMENT_TABLE;
		  
    	eff.start();
    	eff2.start();
    	
    	new BukkitRunnable(){
    		public void run(){
    			eff.cancel();
    			eff3.setLocation(p.getLocation());
    			eff3.start();
    		}
    	}.runTaskLater(Main.getPlugin(), 20);
    	
    	new BukkitRunnable(){
    		public void run(){
    			eff2.cancel();
    			eff4.setLocation(p.getLocation());
    			eff4.start();
    		}
    	}.runTaskLater(Main.getPlugin(), 25);
    	
    	new BukkitRunnable(){
    		public void run(){
    			eff3.cancel();
    			eff5.setLocation(p.getLocation());
    			eff5.start();
    		}
    	}.runTaskLater(Main.getPlugin(), 40);
    	
    	new BukkitRunnable(){
    		public void run(){
    			eff4.cancel();
    			eff6.setLocation(p.getLocation());
    			eff6.start();
    		}
    	}.runTaskLater(Main.getPlugin(), 40);
    	
    	new BukkitRunnable(){
    		public void run(){
    			eff5.cancel();
    			eff6.cancel();
    			setLevel(p, kit, lvl);
    			if(lvl == 1){
    				CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) - kit.getPrice());
    				p.sendMessage(Main.pref + ChatColor.AQUA + "Succesfully bought the " + ChatColor.BLUE + kit.getName() + " (Level 1)" + ChatColor.AQUA + " kit for " + ChatColor.BLUE + LevelListener.chooseprice.get(p.getName()) + "$" + ChatColor.AQUA + " !");
    			}else if(lvl == 2){
    				int price = 1000;
    				CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) - price);
    				p.sendMessage(Main.pref + ChatColor.AQUA + "Succesfully upgraded your " + ChatColor.BLUE + kit.getName() + " kit" + " to " + ChatColor.BLUE + " Level " + lvl + ChatColor.AQUA + " for " + ChatColor.BLUE + LevelListener.chooseprice.get(p.getName()) + "$" + ChatColor.AQUA + " !");
    			}else if(lvl == 3){
    				int price = 1000;
    				CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) - price);
    				p.sendMessage(Main.pref + ChatColor.AQUA + "Succesfully upgraded your " + ChatColor.BLUE + kit.getName() + " kit" + " to " + ChatColor.BLUE + " Level " + lvl + ChatColor.AQUA + " for " + ChatColor.BLUE + LevelListener.chooseprice.get(p.getName()) + "$" + ChatColor.AQUA + " !");
    			}else if(lvl == 4){
    				int price = 1500;
    				CoinsUtil.setCoins(p, CoinsUtil.getCoins(p) - price);
    				p.sendMessage(Main.pref + ChatColor.AQUA + "Succesfully upgraded your " + ChatColor.BLUE + kit.getName() + " kit" + " to " + ChatColor.BLUE + " Level " + lvl + ChatColor.AQUA + " for " + ChatColor.BLUE + LevelListener.chooseprice.get(p.getName()) + "$" + ChatColor.AQUA + " !");
    			}
    		}
    	}.runTaskLater(Main.getPlugin(), 60);
	}
	
	public static ItemStack removeEnch(ItemStack is){
		ItemStack i = is;
		for(Enchantment e : i.getEnchantments().keySet()){
			i.removeEnchantment(e);
		}
		
		return i;
	}
	
	public static int getKitsAmount(Player p){
		int kits = 0;		
		for(KitType kit : KitType.values()){
			if(getLevel(p, kit) > 0 || kit.isFree()){
				kits++;
			}
		}		
		return kits - 4;		
	}
	
	public static int getPremiumKitsAmount(){
		int kits = 0;		
		for(KitType kit : KitType.values()){
			if(!kit.isFree()){
				kits++;
			}
		}		
		return kits - 4;		
	}
	
	public static int getFreeKitsAmount(){
		int kits = 0;
		for(KitType kit : KitType.values()){
			if(kit.isFree()){
				kits++;
			}
		}		
		return kits;		
	}
}