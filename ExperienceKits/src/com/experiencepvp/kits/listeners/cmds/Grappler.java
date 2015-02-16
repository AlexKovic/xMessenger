package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.FishingHook;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Grappler implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("grappler")) {
			if (LevelUtil.getLevel(p, KitType.GRAPPLER) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.GRAPPLER.getUtil().giveKit(p, KitType.GRAPPLER);
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

	public static List<Projectile> controllers = new ArrayList<Projectile>();
	public static Map<String, FishingHook> hooks = new HashMap<String, FishingHook>();
	public static HashMap<String, Integer> loads = new HashMap<String, Integer>();
	public static ArrayList<String> cooldown = new ArrayList<String>();

	@EventHandler
	public void onSlot(PlayerItemHeldEvent e) {
		if (e.getPreviousSlot() != e.getNewSlot()) {
			if (hooks.containsKey(e.getPlayer().getName())) {
				hooks.get(e.getPlayer().getName()).remove();
				hooks.remove(e.getPlayer().getName());
			}
		}
	}

	@EventHandler
	public void quit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		loads.remove(p.getName());
		if (hooks.containsKey(p.getName())) {
			hooks.get(p.getName()).remove();
			hooks.remove(p.getName());
		}
	}

	@EventHandler
	public void died(PlayerDeathEvent e) {
		Player p = e.getEntity();
		loads.remove(p.getName());
		if (hooks.containsKey(p.getName())) {
			hooks.get(p.getName()).remove();
			hooks.remove(p.getName());
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLeash(PlayerLeashEntityEvent e) {
		e.setCancelled(true);
		e.getPlayer().updateInventory();

		Player p = e.getPlayer();
		if (e.getPlayer().getItemInHand().getType().equals(Material.LEASH) && KitHandler.getKit(p.getName()) == KitType.GRAPPLER) {
			e.setCancelled(true);
			{
				if (!hooks.containsKey(p.getName()))
					return;
				if (!hooks.get(p.getName()).isHooked())
					return;
				double d = hooks.get(p).getBukkitEntity().getLocation().distance(p.getLocation());
				double t = d;
				double v_x = (1.0 + 0.07 * t) * (hooks.get(p).getBukkitEntity().getLocation().getX() - p.getLocation().getX()) / t;
				double v_y = ((1.0 + 0.03 * t) * (hooks.get(p).getBukkitEntity().getLocation().getY() - p.getLocation().getY()) / t);
				double v_z = (1.0 + 0.07 * t) * (hooks.get(p).getBukkitEntity().getLocation().getZ() - p.getLocation().getZ()) / t;

				Vector v = p.getVelocity();
				v.setX(v_x);
				v.setY(v_y);
				v.setZ(v_z);
				p.setVelocity(v);
				p.getWorld().playSound(p.getLocation(), Sound.STEP_GRAVEL, 10, 10);
			}
		}
	}

	@EventHandler
	public void onSnowballHit(EntityDamageByEntityEvent e) {
		Entity damaged = e.getEntity();
		Entity damageEntity = e.getDamager();
		if (damageEntity instanceof Projectile && controllers.contains((Projectile) damageEntity)) {
			controllers.remove((Projectile) damageEntity);
			((Projectile) damageEntity).setBounce(true);
			Player p = (Player) ((Projectile) damageEntity).getShooter();
			if ((damaged instanceof Player) && ((Player) damaged).getName().equals(p.getName())) {
				e.setCancelled(true);
				return;
			}
			if (hooks.containsKey(p.getName())) {
				hooks.get(p.getName()).setHookedEntity(damaged);
			}
			loads.remove(p.getName());
		}
	}
	
	public ArrayList<String> rcd = new ArrayList<String>();
	public ArrayList<String> nofd = new ArrayList<String>();

	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getPlayer().getItemInHand().getType().equals(Material.LEASH) && KitHandler.getKit(p.getName()) == KitType.GRAPPLER) {
				e.setCancelled(true);
				if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
					if (!cooldown.contains(p.getName())) {
						if (hooks.containsKey(p.getName())) {
							hooks.get(p.getName()).remove();
						}
						FishingHook nmsHook = new FishingHook(p.getWorld(), ((CraftPlayer) p).getHandle());
						nmsHook.spawn(p.getEyeLocation().add(p.getLocation().getDirection().getX(), p.getLocation().getDirection().getY(), p.getLocation().getDirection().getZ()));
						
						nmsHook.move(p.getLocation().getDirection().getX() * 5, p.getLocation().getDirection().getY() * 5, p.getLocation().getDirection().getZ() * 5);
						hooks.put(p.getName(), nmsHook);
						cooldown.add(p.getName());
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {

							public void run() {
								cooldown.remove(p.getName());
							}

						}, 20);
						return;
					}
				} else {
					if(!rcd.contains(p.getName())){
					
					if (!hooks.containsKey(p.getName()))
						return;
					if (!hooks.get(p.getName()).isHooked()) {
						hooks.get(p.getName()).remove();
						hooks.remove(p.getName());
						return;
					}

					int l = 0;

					if (loads.containsKey(p.getName())) {
						l = loads.get(p.getName());
					}

					loads.put(p.getName(), l + 1);

					if (hooks.containsKey(p.getName())) {
						final Location loc = p.getLocation();
						final Location to = hooks.get(p.getName()).getBukkitEntity().getLocation();
						//p.setFallDistance((float) -(loc.getY() < to.getY() ? to.getY() - loc.getY() : loc.getY() - to.getY()));
						nofd.add(p.getName());
						p.setVelocity(new Vector(0, 1, 0));
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {

							public void run() {
								double distance = to.distance(loc);
								double vecX = (1.0D + 0.07000000000000001D * distance) * (to.getX() - loc.getX()) / distance;
								double vecY = (1.0D + 0.03D * distance) * (to.getY() - loc.getY()) / distance - -0.04D * distance;
								double vecZ = (1.0D + 0.07000000000000001D * distance) * (to.getZ() - loc.getZ()) / distance;

								Vector vector = p.getVelocity();
								vector.setX(vecX);
								vector.setY(vecY);
								vector.setZ(vecZ);
								p.setVelocity(vector);

								p.getWorld().playSound(p.getLocation(), Sound.STEP_GRAVEL, 10, 10);
							}

						}, 2);
						if(KitHandler.getLevel(p.getName()) == 1){
							rcd.add(p.getName());
							if (hooks.containsKey(p.getName())) {
								hooks.get(p.getName()).remove();
								hooks.remove(p.getName());
							}
							new BukkitRunnable(){
								public void run(){
									rcd.remove(p.getName());
								}
							}.runTaskLater(Main.getPlugin(), 200);
						}else if(KitHandler.getLevel(p.getName()) == 2){
							rcd.add(p.getName());
							if (hooks.containsKey(p.getName())) {
								hooks.get(p.getName()).remove();
								hooks.remove(p.getName());
							}
							new BukkitRunnable(){
								public void run(){
									rcd.remove(p.getName());
								}
							}.runTaskLater(Main.getPlugin(), 140);
						}else if(KitHandler.getLevel(p.getName()) == 3){
							rcd.add(p.getName());
							if (hooks.containsKey(p.getName())) {
								hooks.get(p.getName()).remove();
								hooks.remove(p.getName());
							}
							new BukkitRunnable(){
								public void run(){
									rcd.remove(p.getName());
								}
							}.runTaskLater(Main.getPlugin(), 100);
						}
					}

					if (l + 2 >= 4) {
						loads.remove(p.getName());
						if (hooks.containsKey(p.getName())) {
							hooks.get(p.getName()).remove();
							hooks.remove(p.getName());
						}
					}
				}else{
					p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
				}
				}
			}
		}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		final Player p = e.getPlayer();
		if(p.isOnGround()){
			if(nofd.contains(p.getName())){
				new BukkitRunnable(){
					public void run(){
						if(nofd.contains(p.getName())){
							nofd.remove(p.getName());
						}
					}
				}.runTaskLater(Main.getPlugin(), 2);
			}
		}
	}
	
	@EventHandler
	public void onFallDamage(EntityDamageEvent e){
		if(e.getEntity() instanceof Player && e.getCause() == DamageCause.FALL){
			Player p = (Player) e.getEntity();
			if(nofd.contains(p.getName())){
				e.setCancelled(true);
				nofd.remove(p.getName());
			}
		}
	}

}
