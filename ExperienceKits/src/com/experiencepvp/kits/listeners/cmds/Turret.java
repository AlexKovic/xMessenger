package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.listeners.PlayerListener;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Turret implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("turret")) {
			if (LevelUtil.getLevel(p, KitType.TURRET) > 0 && p.isOp()){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.TURRET.getUtil().giveKit(p, KitType.TURRET);
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

	public HashMap<String, Location> turretloc = new HashMap<String, Location>();
	public HashMap<String, Entity> turretent = new HashMap<String, Entity>();
	public HashMap<Arrow, String> arrows = new HashMap<Arrow, String>();
	public HashMap<String, BukkitTask> runnable = new HashMap<String, BukkitTask>();
	public ArrayList<String> cd = new ArrayList<String>();
	
	@EventHandler
	public void onClickAnvil(PlayerInteractEvent e){
		final Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(p.getInventory().getItemInHand().getType() == Material.DROPPER){
				if(!cd.contains(p.getName()) && !turretloc.containsKey(p.getName())){
					Location l = e.getClickedBlock().getLocation();
					Location l1 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 1, l.getBlockZ() + 1);
					Location l2 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 1, l.getBlockZ() - 1);
					Location l3 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 1, l.getBlockZ());
					Location l4 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 1, l.getBlockZ());
					Location l5 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 1, l.getBlockZ() + 1);
					Location l6 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 1, l.getBlockZ() - 1);
					Location l7 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 1, l.getBlockZ() + 1);
					Location l8 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 1, l.getBlockZ() - 1);
					
					Location l9 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 2, l.getBlockZ());
					Location l10 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 2, l.getBlockZ());
					Location l11 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 2, l.getBlockZ() + 1);
					Location l12 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 2, l.getBlockZ() - 1);

					Location l13 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 3, l.getBlockZ());
					Location l14 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 3, l.getBlockZ());
					Location l15 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 3, l.getBlockZ() + 1);
					Location l16 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 3, l.getBlockZ() - 1);

					Location l17 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 4, l.getBlockZ());
					if((l1.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l1)) && (l2.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l2)) && (l3.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l3)) && (l4.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l4)) && (l5.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l5)) && (l6.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l6)) && (l7.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l7)) && (l8.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l8)) && (l9.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l9)) && (l10.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l10)) && (l11.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l11)) && (l12.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l12)) && (l13.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l13)) && (l14.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l14)) && (l15.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l15)) && (l16.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l16)) && (l17.getBlock().getType() == Material.AIR && !PlayerListener.prot.contains(l17))){
						makeTurret(p, e.getClickedBlock().getLocation());
					}else{
						p.sendMessage(Main.pref + ChatColor.RED + "This isn't a good spot for a Turret. Please choose a 3x3 empty area!");
					}
				}else{
					p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void makeTurret(final Player p, Location loc){
		Location l = loc;
		Location l1 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 1, l.getBlockZ() + 1);
		Location l2 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 1, l.getBlockZ() - 1);
		Location l3 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 1, l.getBlockZ());
		Location l4 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 1, l.getBlockZ());
		Location l5 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 1, l.getBlockZ() + 1);
		Location l6 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 1, l.getBlockZ() - 1);
		Location l7 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 1, l.getBlockZ() + 1);
		Location l8 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 1, l.getBlockZ() - 1);
		
		Location l9 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 2, l.getBlockZ());
		Location l10 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 2, l.getBlockZ());
		Location l11 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 2, l.getBlockZ() + 1);
		Location l12 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 2, l.getBlockZ() - 1);

		Location l13 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 3, l.getBlockZ());
		Location l14 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 3, l.getBlockZ());
		Location l15 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 3, l.getBlockZ() + 1);
		Location l16 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 3, l.getBlockZ() - 1);

		Location l17 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 4, l.getBlockZ());
		
		
		
		l1.getBlock().setType(Material.COBBLESTONE_STAIRS);
		l2.getBlock().setType(Material.COBBLESTONE_STAIRS);
		l3.getBlock().setType(Material.COBBLESTONE_STAIRS);
		l4.getBlock().setType(Material.COBBLESTONE_STAIRS);

		l5.getBlock().setType(Material.getMaterial(44));
		l6.getBlock().setType(Material.getMaterial(44));
		l7.getBlock().setType(Material.getMaterial(44));
		l8.getBlock().setType(Material.getMaterial(44));

		l9.getBlock().setType(Material.COBBLE_WALL);
		l10.getBlock().setType(Material.COBBLE_WALL);
		l11.getBlock().setType(Material.COBBLE_WALL);
		l12.getBlock().setType(Material.COBBLE_WALL);
		

		l13.getBlock().setType(Material.QUARTZ_STAIRS);
		l14.getBlock().setType(Material.QUARTZ_STAIRS);
		l15.getBlock().setType(Material.QUARTZ_STAIRS);
		l16.getBlock().setType(Material.QUARTZ_STAIRS);
		
		l17.getBlock().setType(Material.getMaterial(44));

		l.getWorld().spawnEntity(l, EntityType.ZOMBIE);
		
		turretloc.remove(p.getName());
		turretent.remove(p.getName());
		if(runnable.containsKey(p.getName())){
			runnable.get(p.getName()).cancel();
			runnable.remove(p.getName());
		}
		
		//turretent.put(p.getName(), babyzombie);
		turretloc.put(p.getName(), loc);
		runnable.put(p.getName(), 
		new BukkitRunnable(){
			public void run(){
				if(turretent.containsKey(p.getName()) && turretloc.containsKey(p.getName())){
					for(Entity e : turretent.get(p.getName()).getNearbyEntities(15, 15, 15)){
						if(e instanceof Player){
							Vector v = e.getLocation().toVector().subtract(turretent.get(p.getName()).getLocation().toVector()).multiply(0.4);
							arrows.put(turretent.get(p.getName()).getWorld().spawnArrow(turretent.get(p.getName()).getLocation().add(turretent.get(p.getName()).getLocation().toVector().multiply(2)), v, 0.6f, 12), p.getName());
						}
					}
				}else{
					this.cancel();
					return;
				}
			}
		}.runTaskTimer(Main.getPlugin(), 10, 10));
	}
	
	public void removeTurret(final String s){
		//remove blocks
		if(runnable.containsKey(s)){
			runnable.get(s).cancel();
			runnable.remove(s);
		}
			
		if(turretent.containsKey(s)){
			turretent.get(s).remove();
			turretent.remove(s);
		}
		Location l = turretloc.get(s);
		new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 1, l.getBlockZ() + 1).getBlock().setType(Material.AIR);
		new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 1, l.getBlockZ() - 1).getBlock().setType(Material.AIR);
		new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 1, l.getBlockZ()).getBlock().setType(Material.AIR);
		new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 1, l.getBlockZ()).getBlock().setType(Material.AIR);
		new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 1, l.getBlockZ() + 1).getBlock().setType(Material.AIR);
		new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 1, l.getBlockZ() - 1).getBlock().setType(Material.AIR);
		new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 1, l.getBlockZ() + 1).getBlock().setType(Material.AIR);
		new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 1, l.getBlockZ() - 1).getBlock().setType(Material.AIR);
		
		new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 2, l.getBlockZ()).getBlock().setType(Material.AIR);
		new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 2, l.getBlockZ()).getBlock().setType(Material.AIR);
		new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 2, l.getBlockZ() + 1).getBlock().setType(Material.AIR);
		new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 2, l.getBlockZ() - 1).getBlock().setType(Material.AIR);

		new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 3, l.getBlockZ()).getBlock().setType(Material.AIR);
		new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 3, l.getBlockZ()).getBlock().setType(Material.AIR);
		new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 3, l.getBlockZ() + 1).getBlock().setType(Material.AIR);
		new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 3, l.getBlockZ() - 1).getBlock().setType(Material.AIR);

		new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 4, l.getBlockZ()).getBlock().setType(Material.AIR);	
		
		turretloc.remove(s);
		cd.add(s);
		new BukkitRunnable(){
			public void run(){
				cd.remove(s);
			}
		}.runTaskLater(Main.getPlugin(), 1200);
	}
	
	@EventHandler
	public void onDamageFromTurret(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			if(arrows.containsKey((Arrow) e.getDamager())){
				if(Bukkit.getServer().getPlayer(arrows.get((Arrow) e.getDamager())) != null){
					Player p = (Player) e.getEntity();
					if(((Damageable) p).getHealth() < 2.0){
						e.setDamage(2.0);
					}else{
						p.damage(0.0, Bukkit.getServer().getPlayer(arrows.get((Arrow) e.getDamager())));
						p.setHealth(0.0);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void turretZombieDeath(EntityDeathEvent e){
		if(e.getEntity() instanceof Zombie){
			for(String s : turretent.keySet()){
				if(turretent.get(s) == e.getEntity()){
					removeTurret(s);
				}
			}
		}
	}
}