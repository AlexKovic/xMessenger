package com.experiencepvp.kits.utils;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.kits.Main;
import com.experiencepvp.preferences.PreferencesUtil;

public abstract class KitUtil {
	
	public abstract ItemStack getIcon();
	
	public abstract List<String> getExplaination(int lvl);
	
	public abstract void giveKit(Player p, KitType type);
	
	public static ItemStack setName(ItemStack item, String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
	
	public static void soup(PlayerInventory inv) {
		if (inv.getHolder() instanceof Player) {
			Player p = (Player) inv.getHolder();
			ItemStack soup = setName(new ItemStack(Material.MUSHROOM_SOUP), "§9Soup");
			inv.setItem(PreferencesUtil.getSwordSlot(p) - 1, addUnbreaking(new ItemStack(Material.STONE_SWORD)));
			for (int i = 0; i < 13; i++) {
				inv.addItem(soup);
			}
			
			inv.addItem(new ItemStack(Material.BOWL, 32));
			inv.addItem(new ItemStack(Material.RED_MUSHROOM, 32));
			inv.addItem(new ItemStack(Material.BROWN_MUSHROOM, 32));
			
			for (int i = 0; i < 19; i++) {
				inv.addItem(soup);
			}
		}
	}
	
	public static void sendKit(Player p, KitType type) {
		doKitAnimation(p.getLocation());
		p.sendMessage(Main.pref + ChatColor.GRAY + "You have successfully chosen the " + ChatColor.GOLD + type.getName() + " (Level " + KitHandler.getLevel(p.getName()) + ")" + ChatColor.GRAY + " kit!");
		p.setGameMode(GameMode.SURVIVAL);
	}
	
	public static ItemStack addUnbreaking(ItemStack item) {
		item.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		return item;
	}
	
	public static void clearInventory(Player player) {
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);

		for (PotionEffect pot : player.getActivePotionEffects())
			player.removePotionEffect(pot.getType());
	}
	
	public static void setKit(Player p, KitType type) {
			type.getUtil().giveKit(p, type);
	}
	
	@SuppressWarnings("deprecation")
	public static void doKitAnimation(final Location loc){			  
    	double radius = 0.7;
    	for(double y = 0; y <= 7; y+=0.05) {
    		double x = radius * Math.cos(y);
    		double z = radius * Math.sin(y);
    		net.minecraft.server.v1_7_R4.PacketPlayOutWorldParticles packet = new net.minecraft.server.v1_7_R4.PacketPlayOutWorldParticles("reddust", (float) (loc.getX() + x), (float) (loc.getY() + 0.1), (float) (loc.getZ() + z), 0, 0, 0, 0, 1);
    		for(Player online : Bukkit.getOnlinePlayers()) {
    			((org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer)online).getHandle().playerConnection.sendPacket(packet);
    		}
    	}
    	
    	new BukkitRunnable(){
    		public void run(){
    			double radius = 0.7;
    			for(double y = 0; y <= 7; y+=0.05) {
    				double x = radius * Math.cos(y);
    				double z = radius * Math.sin(y);
    				net.minecraft.server.v1_7_R4.PacketPlayOutWorldParticles packet = new net.minecraft.server.v1_7_R4.PacketPlayOutWorldParticles("reddust", (float) (loc.getX() + x), (float) (loc.getY() + 1.0), (float) (loc.getZ() + z), 0, 0, 0, 0, 1);
    				for(Player online : Bukkit.getOnlinePlayers()) {
    					((org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer)online).getHandle().playerConnection.sendPacket(packet);
    				}
    			}
    		}
    	}.runTaskLater(Main.getPlugin(), 4);
    	
    	new BukkitRunnable(){
    		public void run(){
    			double radius = 0.7;
    			for(double y = 0; y <= 7; y+=0.05) {
    				double x = radius * Math.cos(y);
    				double z = radius * Math.sin(y);
    				net.minecraft.server.v1_7_R4.PacketPlayOutWorldParticles packet = new net.minecraft.server.v1_7_R4.PacketPlayOutWorldParticles("reddust", (float) (loc.getX() + x), (float) (loc.getY() + 1.8), (float) (loc.getZ() + z), 0, 0, 0, 0, 1);
    				for(Player online : Bukkit.getOnlinePlayers()) {
    					((org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer)online).getHandle().playerConnection.sendPacket(packet);
    				}
    			}
    		}
    	}.runTaskLater(Main.getPlugin(), 8);
    }
}
