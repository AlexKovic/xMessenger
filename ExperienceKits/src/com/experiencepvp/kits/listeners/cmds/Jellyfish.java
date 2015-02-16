package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Jellyfish implements Listener, CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("jellyfish")) {
			if (LevelUtil.getLevel(p, KitType.JELLYFISH) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.JELLYFISH.getUtil().giveKit(p, KitType.JELLYFISH);
					return true;
				} else {
					p.sendMessage("§cYou can only have one kit a life!");
					return true;
				}
			} else {
				p.sendMessage("§cYou don't have the permission for this kit!");
				return true;
			}
		}
		return true;
	}
	
	public ArrayList<Block> naoescorrer = new ArrayList<Block>();
	public HashMap<String, Integer> awater = new HashMap<String, Integer>();
	public HashMap<Location, String> waterloc = new HashMap<Location, String>();
	
	/*      */   @EventHandler
	/*      */   public void onJellyFish(PlayerInteractEvent event)
	/*      */   {
	/* 2858 */     final Player p = event.getPlayer();
	/* 2859 */     if (KitHandler.getKit(p.getName()) == KitType.JELLYFISH && Main.correctRegion(p.getLocation()) && 
	/* 2860 */       (p.getItemInHand().getType() == Material.BLAZE_POWDER) && 
	/* 2861 */       (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
		
					if(!awater.containsKey(p.getName())){
						awater.put(p.getName(), 0);
					}
					
					int amount = awater.get(p.getName());
					if(KitHandler.getLevel(p.getName()) == 1){
						if(amount >= 1){
							p.sendMessage(Main.pref + "You can't place any more water!");
							return;
						}
					}else if(KitHandler.getLevel(p.getName()) == 2){
						if(amount >= 3){
							p.sendMessage(Main.pref + "You can't place any more water!");
							return;
						}
					}else if(KitHandler.getLevel(p.getName()) == 3){
						if(amount >= 3){
							p.sendMessage(Main.pref + "You can't place any more water!");
							return;
						}
					}else if(KitHandler.getLevel(p.getName()) == 4){
						if(amount >= 5){
							p.sendMessage(Main.pref + "You can't place any more water!");
							return;
						}
					}
		
	/* 2862 */       Block b = event.getClickedBlock();
	/* 2863 */       BlockFace lado = event.getBlockFace();
	/* 2864 */       int x = b.getLocation().getBlockX();
	/* 2865 */       int y = b.getLocation().getBlockY();
	/* 2866 */       int z = b.getLocation().getBlockZ();
	/* 2867 */       if (lado == BlockFace.DOWN) {
	/* 2868 */         final Block b2 = b.getWorld().getBlockAt(x, y - 1, z);
	/* 2869 */         if (b2.getType() == Material.AIR) {
	/* 2870 */           b2.setType(Material.STATIONARY_WATER);
	/* 2871 */           this.naoescorrer.add(b2);
						awater.put(p.getName(), awater.get(p.getName()) + 1);
						waterloc.put(b2.getLocation(), p.getName());
						if(KitHandler.getLevel(p.getName()) == 1){
							new BukkitRunnable(){
								public void run(){
									b2.setType(Material.AIR);
									naoescorrer.remove(b2);
								    awater.put(p.getName(), awater.get(p.getName()) - 1);
								    waterloc.remove(b2.getLocation());
								}
							}.runTaskLater(Main.getPlugin(), 60);
						}else if(KitHandler.getLevel(p.getName()) == 2){
							new BukkitRunnable(){
								public void run(){
									b2.setType(Material.AIR);
									naoescorrer.remove(b2);
								    awater.put(p.getName(), awater.get(p.getName()) - 1);
								    waterloc.remove(b2.getLocation());
								}
							}.runTaskLater(Main.getPlugin(), 60);
						}else if(KitHandler.getLevel(p.getName()) == 3){
							new BukkitRunnable(){
								public void run(){
									b2.setType(Material.AIR);
									naoescorrer.remove(b2);
								    awater.put(p.getName(), awater.get(p.getName()) - 1);
								    waterloc.remove(b2.getLocation());
								}
							}.runTaskLater(Main.getPlugin(), 100);
						}else if(KitHandler.getLevel(p.getName()) == 4){
							new BukkitRunnable(){
								public void run(){
									b2.setType(Material.AIR);
									naoescorrer.remove(b2);
								    awater.put(p.getName(), awater.get(p.getName()) - 1);
								    waterloc.remove(b2.getLocation());
								}
							}.runTaskLater(Main.getPlugin(), 100);
						}
	/*      */         }
	/*      */ 
	/*      */       }
	/* 2882 */       else if (lado == BlockFace.UP) {
	/* 2883 */         final Block b2 = b.getWorld().getBlockAt(x, y + 1, z);
	/* 2884 */         if (b2.getType() == Material.AIR) {
	/* 2885 */           b2.setType(Material.STATIONARY_WATER);
	/* 2886 */           this.naoescorrer.add(b2);
	/* 2887 */           awater.put(p.getName(), awater.get(p.getName()) + 1);
	waterloc.put(b2.getLocation(), p.getName());
	if(KitHandler.getLevel(p.getName()) == 1){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 60);
	}else if(KitHandler.getLevel(p.getName()) == 2){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 60);
	}else if(KitHandler.getLevel(p.getName()) == 3){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 100);
	}else if(KitHandler.getLevel(p.getName()) == 4){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 100);
	}
	/*      */         }
	/*      */       }
	/* 2896 */       else if (lado == BlockFace.NORTH) {
	/* 2897 */         final Block b2 = b.getWorld().getBlockAt(x, y, z - 1);
	/* 2898 */         if (b2.getType() == Material.AIR) {
	/* 2899 */           b2.setType(Material.STATIONARY_WATER);
	/* 2900 */           this.naoescorrer.add(b2);
	/* 2901 */          awater.put(p.getName(), awater.get(p.getName()) + 1);
	waterloc.put(b2.getLocation(), p.getName());
	if(KitHandler.getLevel(p.getName()) == 1){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 60);
	}else if(KitHandler.getLevel(p.getName()) == 2){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 60);
	}else if(KitHandler.getLevel(p.getName()) == 3){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 100);
	}else if(KitHandler.getLevel(p.getName()) == 4){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 100);
	}
	}
	/*      */ 
	/*      */       }
	/* 2911 */       else if (lado == BlockFace.SOUTH) {
	/* 2912 */         final Block b2 = b.getWorld().getBlockAt(x, y, z + 1);
	/* 2913 */         if (b2.getType() == Material.AIR) {
	/* 2914 */           b2.setType(Material.STATIONARY_WATER);
	/* 2915 */           this.naoescorrer.add(b2);
	/* 2916 */           awater.put(p.getName(), awater.get(p.getName()) + 1);
	waterloc.put(b2.getLocation(), p.getName());
	if(KitHandler.getLevel(p.getName()) == 1){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 60);
	}else if(KitHandler.getLevel(p.getName()) == 2){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 60);
	}else if(KitHandler.getLevel(p.getName()) == 3){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 100);
	}else if(KitHandler.getLevel(p.getName()) == 4){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 100);
	}
	/*      */         }
	/*      */ 
	/*      */       }
	/* 2926 */       else if (lado == BlockFace.WEST) {
	/* 2927 */         final Block b2 = b.getWorld().getBlockAt(x - 1, y, z);
	/* 2928 */         if (b2.getType() == Material.AIR) {
	/* 2929 */           b2.setType(Material.STATIONARY_WATER);
	/* 2930 */           this.naoescorrer.add(b2);
	/* 2931 */          awater.put(p.getName(), awater.get(p.getName()) + 1);
	waterloc.put(b2.getLocation(), p.getName());
	if(KitHandler.getLevel(p.getName()) == 1){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 60);
	}else if(KitHandler.getLevel(p.getName()) == 2){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 60);
	}else if(KitHandler.getLevel(p.getName()) == 3){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 100);
	}else if(KitHandler.getLevel(p.getName()) == 4){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 100);
	}
	/*      */         }
	/*      */ 
	/*      */       }
	/* 2941 */       else if (lado == BlockFace.EAST) {
	/* 2942 */         final Block b2 = b.getWorld().getBlockAt(x + 1, y, z);
	/* 2943 */         if (b2.getType() == Material.AIR) {
	/* 2944 */           b2.setType(Material.STATIONARY_WATER);
	/* 2945 */           this.naoescorrer.add(b2);
	/* 2946 */           awater.put(p.getName(), awater.get(p.getName()) + 1);
	waterloc.put(b2.getLocation(), p.getName());
	if(KitHandler.getLevel(p.getName()) == 1){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 60);
	}else if(KitHandler.getLevel(p.getName()) == 2){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 60);
	}else if(KitHandler.getLevel(p.getName()) == 3){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 100);
	}else if(KitHandler.getLevel(p.getName()) == 4){
		new BukkitRunnable(){
			public void run(){
				b2.setType(Material.AIR);
				naoescorrer.remove(b2);
			    awater.put(p.getName(), awater.get(p.getName()) - 1);
			    waterloc.remove(b2.getLocation());
			}
		}.runTaskLater(Main.getPlugin(), 100);
	}
	/*      */         }
	/*      */       }
	/*      */     }
	/*      */   }
	/*      */ 
	/*      */   @EventHandler
	/*      */   public void onJellyFishBlock(BlockPhysicsEvent event)
	/*      */   {
	/* 2962 */     Block b = event.getBlock();
	/* 2963 */     if ((b.getType() == Material.STATIONARY_WATER) && (this.naoescorrer.contains(b)))
	/* 2964 */       event.setCancelled(true);
	/*      */   }
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		if(e.getTo().getBlock().getType() == Material.STATIONARY_WATER){
			if(KitHandler.getKit(e.getPlayer().getName()) != KitType.JELLYFISH){
				for(Location loc : waterloc.keySet()){
					if(e.getPlayer().getLocation().getBlock().getX() == loc.getBlock().getX() && e.getPlayer().getLocation().getBlock().getZ() == loc.getBlock().getZ() && e.getPlayer().getLocation().getBlock().getY() == loc.getBlock().getY()){
						if(KitHandler.getLevel(waterloc.get(loc)) == 2){
							e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, 60, 0));
						}else if(KitHandler.getLevel(waterloc.get(loc)) == 3){
							e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
						}else if(KitHandler.getLevel(waterloc.get(loc)) == 4){
							e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
						}
					}
				}
			}
		}
	}
}
