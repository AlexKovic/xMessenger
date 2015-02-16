package com.experiencepvp.drops;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.kits.Main;

public class DropsMain {
	
	public static int x1 = 906;
	public static int x2 = 1045;
	public static int z1 = 9897;
	public static int z2 = 10049;

	public static ArrayList<Location> dropchests = new ArrayList<Location>();
	
	public static Location mainloc = null;
	
	public static void startDrops(){
		mainloc = getRandomLoc();
		new BukkitRunnable(){
			public void run(){
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.AQUA + "A Drop is spawning in 1 minute at " + mainloc.getBlockX() + ", " + mainloc.getBlockY() + ", " + mainloc.getBlockZ() + " !");
			}
		}.runTaskLater(Main.getPlugin(), 6000);
		
		new BukkitRunnable(){
			public void run(){
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.AQUA + "A Drop is spawning in 30 seconds at " + mainloc.getBlockX() + ", " + mainloc.getBlockY() + ", " + mainloc.getBlockZ() + " !");
			}
		}.runTaskLater(Main.getPlugin(), 6600);
		
		new BukkitRunnable(){
			public void run(){
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.AQUA + "A Drop is spawning in 20 seconds at " + mainloc.getBlockX() + ", " + mainloc.getBlockY() + ", " + mainloc.getBlockZ() + " !");
			}
		}.runTaskLater(Main.getPlugin(), 6800);
		
		new BukkitRunnable(){
			public void run(){
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.AQUA + "A Drop is spawning in 10 seconds at " + mainloc.getBlockX() + ", " + mainloc.getBlockY() + ", " + mainloc.getBlockZ() + " !");
			}
		}.runTaskLater(Main.getPlugin(), 7000);
		
		new BukkitRunnable(){
			public void run(){
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.AQUA + "A Drop is spawning in 5 seconds at " + mainloc.getBlockX() + ", " + mainloc.getBlockY() + ", " + mainloc.getBlockZ() + " !");
			}
		}.runTaskLater(Main.getPlugin(), 7100);
		
		new BukkitRunnable(){
			public void run(){
				Bukkit.getServer().broadcastMessage(Main.pref + ChatColor.AQUA + "A Drop spawned at " + mainloc.getBlockX() + ", " + mainloc.getBlockY() + ", " + mainloc.getBlockZ() + " !");
				buildDrop(mainloc);
			}
		}.runTaskLater(Main.getPlugin(), 7200);
	}
	
	
	public static Location getRandomLoc(){
		int xsize = (x2 - x1) + 1;
		int zsize = (z2 - z1) + 1;
		
		Random r1 = new Random();
		Random r2 = new Random();
		
		int px = r1.nextInt(xsize);
		int pz = r2.nextInt(zsize);
		
		int x = px + x1;
		int z = pz + z2;
		
		Location reloc = fixLoc(new Location(Bukkit.getWorld("experiencepvp"), x, 0, z));
		
		while(reloc.getY() > 25){
			Random rr1 = new Random();
			Random rr2 = new Random();
			
			int ppx = rr1.nextInt(xsize);
			int ppz = rr2.nextInt(zsize);
			
			int xx = ppx + x1;
			int zz = ppz + z2;
			
			reloc = fixLoc(new Location(Bukkit.getWorld("experiencepvp"), xx, 0, zz));
		}
		
		return reloc;
	}
	
	public static Location fixLoc(Location l){
		for(int i = 0; i < 30; i++){
			Location newloc = new Location(Bukkit.getWorld("experiencepvp"), l.getX(), l.getY() + i, l.getZ());
			int x = 0;
			for(Location lc : getDropLocs(newloc)){
				if(lc.getBlock().getType() == Material.AIR){
					x++;
				}
			}
			if(x == getDropLocs(newloc).size()){
				return newloc;
			}
		}
		
		return new Location(Bukkit.getWorld("experiencepvp"), l.getX(), l.getY() + 100, l.getZ());
	}
	
	public static List<Location> getDropLocs(Location l){
		List<Location> locs = new ArrayList<Location>();
		
		locs.add(l);
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 1, l.getY(), l.getZ()));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 2, l.getY(), l.getZ()));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 1, l.getY(), l.getZ()));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 2, l.getY(), l.getZ()));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX(), l.getY(), l.getZ() + 1));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX(), l.getY(), l.getZ() + 2));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX(), l.getY(), l.getZ() - 1));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX(), l.getY(), l.getZ() - 2));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 1, l.getY(), l.getZ() + 1));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 1, l.getY(), l.getZ() - 1));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 1, l.getY(), l.getZ() - 1));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 1, l.getY(), l.getZ() + 1));

		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 2, l.getY(), l.getZ() + 1));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 2, l.getY(), l.getZ() - 1));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 2, l.getY(), l.getZ() + 1));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 2, l.getY(), l.getZ() - 1));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 1, l.getY(), l.getZ() + 2));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 1, l.getY(), l.getZ() + 2));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 1, l.getY(), l.getZ() - 2));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 1, l.getY(), l.getZ() - 2));

		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 1, l.getY() + 1, l.getZ() + 1));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 1, l.getY() + 1, l.getZ() - 1));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 1, l.getY() + 1, l.getZ() - 1));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 1, l.getY() + 1, l.getZ() + 1));
		locs.add(new Location(Bukkit.getWorld("experiencepvp"), l.getX(), l.getY() + 1, l.getZ()));
		
		return locs;
	}

	@SuppressWarnings("deprecation")
	public static void buildDrop(Location l){
		final Location l1 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 1, l.getY(), l.getZ());
		final Location l2 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 2, l.getY(), l.getZ());
		final Location l3 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 1, l.getY(), l.getZ());
		final Location l4 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 2, l.getY(), l.getZ());
		final Location l5= new Location(Bukkit.getWorld("experiencepvp"), l.getX(), l.getY(), l.getZ() + 1);
		final Location l6 = new Location(Bukkit.getWorld("experiencepvp"), l.getX(), l.getY(), l.getZ() + 2);
		final Location l7 = new Location(Bukkit.getWorld("experiencepvp"), l.getX(), l.getY(), l.getZ() - 1);
		final Location l8 = new Location(Bukkit.getWorld("experiencepvp"), l.getX(), l.getY(), l.getZ() - 2);
		
		final Location l9 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 1, l.getY(), l.getZ() + 1);
		final Location l10 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 1, l.getY(), l.getZ() - 1);
		final Location l11 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 1, l.getY(), l.getZ() - 1);
		final Location l12 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 1, l.getY(), l.getZ() + 1);

		final Location l13 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 2, l.getY(), l.getZ() + 1);
		final Location l14 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 2, l.getY(), l.getZ() - 1);
		final Location l15 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 2, l.getY(), l.getZ() + 1);
		final Location l16 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 2, l.getY(), l.getZ() - 1);
		final Location l17 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 1, l.getY(), l.getZ() + 2);
		final Location l18 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 1, l.getY(), l.getZ() + 2);
		final Location l19 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 1, l.getY(), l.getZ() - 2);
		final Location l20 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 1, l.getY(), l.getZ() - 2);

		final Location c1 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 1, l.getY() + 1, l.getZ() + 1);
		final Location c2 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 1, l.getY() + 1, l.getZ() - 1);
		final Location c3 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() + 1, l.getY() + 1, l.getZ() - 1);
		final Location c4 = new Location(Bukkit.getWorld("experiencepvp"), l.getX() - 1, l.getY() + 1, l.getZ() + 1);
		final Location et = new Location(Bukkit.getWorld("experiencepvp"), l.getX(), l.getY() + 1, l.getZ());
		
		l.getBlock().setType(Material.LAPIS_BLOCK);
		
		new BukkitRunnable(){
			public void run(){
				l1.getBlock().setType(Material.STAINED_GLASS);
				l1.getBlock().setData(DyeColor.BLUE.getData());
			}
		}.runTaskLater(Main.getPlugin(), 1);
		new BukkitRunnable(){
			public void run(){
				l2.getBlock().setType(Material.STAINED_GLASS);
				l2.getBlock().setData(DyeColor.LIGHT_BLUE.getData());
			}
		}.runTaskLater(Main.getPlugin(), 2);
		new BukkitRunnable(){
			public void run(){
				l3.getBlock().setType(Material.STAINED_GLASS);
				l3.getBlock().setData(DyeColor.BLUE.getData());
			}
		}.runTaskLater(Main.getPlugin(), 3);
		new BukkitRunnable(){
			public void run(){
				l4.getBlock().setType(Material.STAINED_GLASS);
				l4.getBlock().setData(DyeColor.LIGHT_BLUE.getData());
			}
		}.runTaskLater(Main.getPlugin(), 4);
		new BukkitRunnable(){
			public void run(){
				l5.getBlock().setType(Material.STAINED_GLASS);
				l5.getBlock().setData(DyeColor.BLUE.getData());
			}
		}.runTaskLater(Main.getPlugin(), 5);
		new BukkitRunnable(){
			public void run(){
				l6.getBlock().setType(Material.STAINED_GLASS);
				l6.getBlock().setData(DyeColor.LIGHT_BLUE.getData());
			}
		}.runTaskLater(Main.getPlugin(), 6);
		new BukkitRunnable(){
			public void run(){
				l7.getBlock().setType(Material.STAINED_GLASS);
				l7.getBlock().setData(DyeColor.BLUE.getData());
			}
		}.runTaskLater(Main.getPlugin(), 7);
		new BukkitRunnable(){
			public void run(){
				l8.getBlock().setType(Material.STAINED_GLASS);
				l8.getBlock().setData(DyeColor.LIGHT_BLUE.getData());
			}
		}.runTaskLater(Main.getPlugin(), 8);
		
		new BukkitRunnable(){
			public void run(){
				l9.getBlock().setType(Material.STAINED_GLASS);
				l9.getBlock().setData(DyeColor.LIGHT_BLUE.getData());
			}
		}.runTaskLater(Main.getPlugin(), 9);
		new BukkitRunnable(){
			public void run(){
				l10.getBlock().setType(Material.STAINED_GLASS);
				l10.getBlock().setData(DyeColor.LIGHT_BLUE.getData());
			}
		}.runTaskLater(Main.getPlugin(), 10);
		new BukkitRunnable(){
			public void run(){
				l11.getBlock().setType(Material.STAINED_GLASS);
				l11.getBlock().setData(DyeColor.LIGHT_BLUE.getData());
			}
		}.runTaskLater(Main.getPlugin(), 11);
		new BukkitRunnable(){
			public void run(){
				l12.getBlock().setType(Material.STAINED_GLASS);
				l12.getBlock().setData(DyeColor.LIGHT_BLUE.getData());
			}
		}.runTaskLater(Main.getPlugin(), 12);
		
		new BukkitRunnable(){
			public void run(){
				l13.getBlock().setType(Material.LAPIS_BLOCK);
			}
		}.runTaskLater(Main.getPlugin(), 13);
		new BukkitRunnable(){
			public void run(){
				l14.getBlock().setType(Material.LAPIS_BLOCK);
			}
		}.runTaskLater(Main.getPlugin(), 14);
		new BukkitRunnable(){
			public void run(){
				l15.getBlock().setType(Material.LAPIS_BLOCK);
			}
		}.runTaskLater(Main.getPlugin(), 15);
		new BukkitRunnable(){
			public void run(){
				l16.getBlock().setType(Material.LAPIS_BLOCK);
			}
		}.runTaskLater(Main.getPlugin(), 16);
		new BukkitRunnable(){
			public void run(){
				l17.getBlock().setType(Material.LAPIS_BLOCK);
			}
		}.runTaskLater(Main.getPlugin(), 17);
		new BukkitRunnable(){
			public void run(){
				l18.getBlock().setType(Material.LAPIS_BLOCK);
			}
		}.runTaskLater(Main.getPlugin(), 18);
		new BukkitRunnable(){
			public void run(){
				l19.getBlock().setType(Material.LAPIS_BLOCK);
			}
		}.runTaskLater(Main.getPlugin(), 19);
		new BukkitRunnable(){
			public void run(){
				l20.getBlock().setType(Material.LAPIS_BLOCK);
			}
		}.runTaskLater(Main.getPlugin(), 20);
		
		
	}
	
	public List<ItemStack> getRandomLoot(){
		List<ItemStack> is = new ArrayList<ItemStack>();
		
		Random r1 = new Random();
		Random r2 = new Random();
		Random r3 = new Random();
		Random r4 = new Random();
		Random r5 = new Random();
		Random r6 = new Random();
		Random r7 = new Random();
		Random r8 = new Random();
		Random r9 = new Random();
		Random r10 = new Random();
		Random r11 = new Random();
		Random r12 = new Random();
		Random r13 = new Random();
		Random r14 = new Random();
		Random r15 = new Random();
		Random r16 = new Random();
		Random r17 = new Random();
		
		int ironsword = r1.nextInt(99) + 1;
		int leatherhelmet = r1.nextInt(99) + 1;
		int leatherchestplate = r1.nextInt(99) + 1;
		int leatherleggings = r1.nextInt(99) + 1;
		int leatherboots = r1.nextInt(99) + 1;
		int firecookie = r1.nextInt(99) + 1;
		int bow = r1.nextInt(99) + 1;
		int arrow = r1.nextInt(99) + 1;
		int poison = r1.nextInt(99) + 1;
		int slowness = r1.nextInt(99) + 1;
		int ironhelmet = r1.nextInt(99) + 1;
		int ironchestplate = r1.nextInt(99) + 1;
		int ironleggings = r1.nextInt(99) + 1;
		int ironboots = r1.nextInt(99) + 1;
		int bottle = r1.nextInt(99) + 1;
		int diasword = r1.nextInt(99) + 1;
		int enderpearl = r1.nextInt(99) + 1;
		
		if(ironsword <= 10){
			
		}
		
		return is;
	}
}
