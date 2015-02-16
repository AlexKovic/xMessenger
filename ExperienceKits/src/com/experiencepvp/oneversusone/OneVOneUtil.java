package com.experiencepvp.oneversusone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.utils.KitUtil;

public class OneVOneUtil {

	public static SettingsManager settings = SettingsManager.getInstance(); 

	public static String pref = ChatColor.BOLD + "" + ChatColor.ITALIC + ChatColor.BLUE + "1v1" + ChatColor.WHITE + " >> ";
	
	public static Material potmat = new Potion(PotionType.STRENGTH).toItemStack(1).getType();
	
	public static ItemStack getIcon(int id){
		if(id == 1){
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.BOLD + "" + ChatColor.WHITE + "Info:");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Sword: " + ChatColor.GRAY + "Stone");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Helmet: " + ChatColor.GRAY + "None");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Chestplate: " + ChatColor.GRAY + "None");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Leggings: " + ChatColor.GRAY + "None");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Boots: " + ChatColor.GRAY + "None");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Refills: " + ChatColor.GRAY + "Yes");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Effects: " + ChatColor.GRAY + "None");
			return setNameAndLore(new ItemStack(Material.STONE_SWORD), ChatColor.BOLD + "" + ChatColor.BLUE + "♦ EHG 1v1 ♦", ls);
		}else if(id == 2){
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.BOLD + "" + ChatColor.WHITE + "Info:");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Sword: " + ChatColor.GRAY + "Stone");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Helmet: " + ChatColor.GRAY + "None");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Chestplate: " + ChatColor.GRAY + "None");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Leggings: " + ChatColor.GRAY + "None");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Boots: " + ChatColor.GRAY + "None");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Refills: " + ChatColor.GRAY + "Yes");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Effects: " + ChatColor.GRAY + "None");
			return setNameAndLore(new ItemStack(Material.PAPER), ChatColor.BOLD + "" + ChatColor.BLUE + "♦ Kit 1v1 ♦", ls);
		}else if(id == 3){
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.BOLD + "" + ChatColor.WHITE + "Info:");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Sword: " + ChatColor.GRAY + "Diamond - Sharp I");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Helmet: " + ChatColor.GRAY + "Iron");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Chestplate: " + ChatColor.GRAY + "Iron");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Leggings: " + ChatColor.GRAY + "Iron");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Boots: " + ChatColor.GRAY + "Iron");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Refills: " + ChatColor.GRAY + "No");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Effects: " + ChatColor.GRAY + "Strength II - Speed II");
			ItemStack pot = new Potion(PotionType.STRENGTH, 1).toItemStack(1);
			return setNameAndLore(pot, ChatColor.BOLD + "" + ChatColor.BLUE + "♦ Hardcore 1v1 ♦", ls);
		}else if(id == 4){
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.BOLD + "" + ChatColor.WHITE + "Info:");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Sword: " + ChatColor.GRAY + "Diamond - Sharp I");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Helmet: " + ChatColor.GRAY + "Iron");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Chestplate: " + ChatColor.GRAY + "Iron");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Leggings: " + ChatColor.GRAY + "Iron");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Boots: " + ChatColor.GRAY + "Iron");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Refills: " + ChatColor.GRAY + "Yes");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Effects: " + ChatColor.GRAY + "None");
			return setNameAndLore(new ItemStack(Material.MUSHROOM_SOUP), ChatColor.BOLD + "" + ChatColor.BLUE + "♦ Normal 1v1 (Refills) ♦", ls);
		}else if(id == 5){
			List<String> ls = new ArrayList<String>();
			ls.add(ChatColor.BOLD + "" + ChatColor.WHITE + "Info:");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Sword: " + ChatColor.GRAY + "Diamond - Sharp I");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Helmet: " + ChatColor.GRAY + "Iron");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Chestplate: " + ChatColor.GRAY + "Iron");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Leggings: " + ChatColor.GRAY + "Iron");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Boots: " + ChatColor.GRAY + "Iron");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Refills: " + ChatColor.GRAY + "No");
			ls.add(ChatColor.BLUE + "•" + ChatColor.WHITE + "Effects: " + ChatColor.GRAY + "None");
			return setNameAndLore(new ItemStack(Material.DIAMOND_SWORD), ChatColor.BOLD + "" + ChatColor.BLUE + "♦ Normal 1v1 (No Refills) ♦", ls);
		}
		
		return null;
	}
	
	public static ItemStack getMapIcon(int id){
		if (id == 1) {
			ItemStack item = new ItemStack(Material.IRON_AXE);				
			ItemMeta im = item.getItemMeta();
			im.setDisplayName("§7Castle Map");
			im.setLore(Arrays.asList("§7Click here to choose", "§7the §6Castle §7map!"));
			item.setItemMeta(im);
			return item;
		}
		
		return null;
	}
	
	public static void setInv(int id, Player p){
		PlayerInventory inv = p.getInventory();
		inv.clear();
		for(PotionEffect eff : p.getActivePotionEffects()){
			p.removePotionEffect(eff.getType());
		}
		if(id == 1){
			ItemStack ss = new ItemStack(Material.STONE_SWORD);
			ss.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			inv.addItem(ss);
			soupRecrafts(inv);			
		}else if(id == 2){
			inv.addItem(new ItemStack(Material.STONE_SWORD));
			soupRecrafts(inv);			
		}else if(id == 3){
			ItemStack dsword = new ItemStack(Material.DIAMOND_SWORD);
			dsword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999999, 1));
			
			inv.setHelmet(new ItemStack(Material.IRON_HELMET));
			inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			inv.setBoots(new ItemStack(Material.IRON_BOOTS));
			
			inv.addItem(dsword);
			
			soupHotbar(inv);
		}else if(id == 4){
			ItemStack dsword = new ItemStack(Material.DIAMOND_SWORD);
			dsword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			
			inv.setHelmet(new ItemStack(Material.IRON_HELMET));
			inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			inv.setBoots(new ItemStack(Material.IRON_BOOTS));
			
			inv.addItem(dsword);
			soupRefs(inv);
		}else if(id == 5){
			ItemStack dsword = new ItemStack(Material.DIAMOND_SWORD);
			dsword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			
			inv.setHelmet(new ItemStack(Material.IRON_HELMET));
			inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			inv.setBoots(new ItemStack(Material.IRON_BOOTS));
			
			inv.addItem(dsword);
			
			soupHotbar(inv);
		}
	}
	
	public static ItemStack setNameAndLore(ItemStack is, String name, List<String> lore){
		ItemMeta im = is.getItemMeta();
		if(name != null)
			im.setDisplayName(name);
		if(lore != null)
			im.setLore(lore);
		is.setItemMeta(im);
		return is;
	}
	
	public static void soupRecrafts(PlayerInventory inv) {
		ItemStack soup = KitUtil.setName(new ItemStack(Material.MUSHROOM_SOUP), "§9Soup");
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
	
	public static void soupRefs(PlayerInventory inv) {
		ItemStack soup = KitUtil.setName(new ItemStack(Material.MUSHROOM_SOUP), "§9Soup");
		for (int i = 0; i < 35; i++) {
			inv.addItem(soup);
		}
	}
	
	public static void soupHotbar(PlayerInventory inv) {
		ItemStack soup = KitUtil.setName(new ItemStack(Material.MUSHROOM_SOUP), "§9Soup");
		for (int i = 0; i < 8; i++) {
			inv.addItem(soup);
		}
	}
	
	public static Location getLocation1(int id) {
		if(id == 1){
			Location loc = new Location(Bukkit.getWorld("experiencepvp"), -5466, 5, -5469);
			return loc;
		}
		World world = Bukkit.getWorld(settings.getData().getString("1v1." + id + ".location.1.world"));
		double x = settings.getData().getDouble("1v1." + id + ".location.1.x");
		double y = settings.getData().getDouble("1v1." + id + ".location.1.y");
		double z = settings.getData().getDouble("1v1." + id + ".location.1.z");
		Location loc = new Location(world, x, y, z);
		return loc;
	}
	
	public static Location getLocation2(int id) {
		if(id == 1){
			Location loc = new Location(Bukkit.getWorld("experiencepvp"), -5466, 5, -5453);
			loc.setPitch(180);
			return loc;
		}
		World world = Bukkit.getWorld(settings.getData().getString("1v1." + id + ".location.2.world"));
		double x = settings.getData().getDouble("1v1." + id + ".location.2.x");
		double y = settings.getData().getDouble("1v1." + id + ".location.2.y");
		double z = settings.getData().getDouble("1v1." + id + ".location.2.z");
		Location loc = new Location(world, x, y, z);
		return loc;
	}
	
	public static void setLocation(int id, int loc, Location ploc){
		settings.getData().set("1v1." + id + ".location." + loc + ".world", ploc.getWorld().getName());
		settings.getData().set("1v1." + id + ".location." + loc + ".x", ploc.getX());
		settings.getData().set("1v1." + id + ".location." + loc + ".y", ploc.getY());
		settings.getData().set("1v1." + id + ".location." + loc + ".z", ploc.getZ());
	}
	
	public static Location getSpawn(){
		World world = Bukkit.getServer().getWorlds().get(0);
		double x = -5466.5;
		double y = 5.0;
		double z = -5461.5;
		Location loc = new Location(world, x, y, z);
		return loc;
	}
	

	public static void give1v1Items(Player p){
		PlayerInventory inv = p.getInventory();
		inv.clear();
		inv.setArmorContents(null);
		
		for(PotionEffect eff : p.getActivePotionEffects()){
			p.removePotionEffect(eff.getType());
		}
		
		List<String> ls = new ArrayList<String>();
		ls.add(ChatColor.GRAY + "Click someone to challenge him");
		ls.add(ChatColor.GRAY + "for a 1v1!");
		p.getInventory().addItem(setNameAndLore(new ItemStack(Material.BLAZE_ROD), ChatColor.BOLD + "" + ChatColor.BLUE + "♦ 1v1 Stick ♦", ls));
	}
	
	@SuppressWarnings("deprecation")
	public static void handleInvis(Player p1, Player p2){
		for(Player on : Bukkit.getServer().getOnlinePlayers()){
			if(on != p2){
				p1.hidePlayer(on);
				on.hidePlayer(p1);
			}
		}
		
		for(Player on : Bukkit.getServer().getOnlinePlayers()){
			if(on != p1){
				p2.hidePlayer(on);
				on.hidePlayer(p2);
			}
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public static void resetInvis(Player p1, Player p2){
		for(Player on : Bukkit.getServer().getOnlinePlayers()){
			p1.showPlayer(on);
			on.showPlayer(p1);
		}
		
		for(Player on : Bukkit.getServer().getOnlinePlayers()){
			p2.showPlayer(on);
			on.showPlayer(p2);
		}
	}
	
	public static boolean canGetKitIn1v1(Player p){
		if(OneVOneListener.lobby1v1.contains(p.getName())){
			return false;
		}else{
			if(OneVOneListener.fighting.contains(p.getName())){
				if(OneVOneListener.kit1v1.contains(p.getName())){
					return true;
				}else{
					return false;
				}
			}else{
				return true;
			}
		}
	}
	
}
