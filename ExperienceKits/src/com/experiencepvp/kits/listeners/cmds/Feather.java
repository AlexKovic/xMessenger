package com.experiencepvp.kits.listeners.cmds;

import java.util.HashMap;

import net.minecraft.server.v1_7_R4.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.experiencepvp.effects.PhantomEffect;
import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

import de.slikey.effectlib.util.ParticleEffect;

public class Feather implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("feather")) {
			if (LevelUtil.getLevel(p, KitType.FEATHER) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.FEATHER.getUtil().giveKit(p, KitType.FEATHER);
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
	
	
	public static HashMap<String, FeatherTimer> timers = new HashMap<String, FeatherTimer>();
	public static HashMap<String, PhantomEffect> effhash = new HashMap<String, PhantomEffect>();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void move(PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		if (KitHandler.getKit(p.getName()) == KitType.FEATHER) {
			if (p.isSneaking()) {
				if (event.getFrom().getY() > event.getTo().getY()) {
					if (p.getLocation().clone().add(0, -2, 0).getBlock().getType() == Material.AIR || p.getLocation().clone().add(0, -2, 0).getBlock().isLiquid()) {
						p.setVelocity(new Vector(p.getLocation().getDirection().getX() / 2, -0.3, p.getLocation().getDirection().getZ() / 2));
						PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles("fireworksSpark", (float) (p.getLocation().getX()), (float) (p.getLocation().getY()), (float) (p.getLocation().getZ()), 0, 0, 0, 0, 1);
						for(Player on : Bukkit.getServer().getOnlinePlayers()){
							for(int i = 0; i<15; i++){
								((CraftPlayer)on).getHandle().playerConnection.sendPacket(packet);
							}
						}
						
						if (!timers.containsKey(p.getName())) {
							FeatherTimer timer = new FeatherTimer(p);
							timers.put(p.getName(), timer);
							timer.runTaskTimer(Main.getPlugin(), 0, 5);
						}
					} else {
						if (timers.containsKey(p.getName())) {
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {

								public void run() {
									if (timers.containsKey(p.getName())) {
										timers.get(p.getName()).cancel();
										timers.remove(p.getName());
									}
								}

							}, 10);
						}
					}
				}
			} else {
				if (timers.containsKey(p.getName())) {
					p.setFallDistance(0);
					timers.get(p.getName()).cancel();
					timers.remove(p.getName());
				}
			}
		}
	}

	@EventHandler
	public void damage(EntityDamageEvent event) {
		if (event.getEntityType() == EntityType.PLAYER) {
			Player p = (Player) event.getEntity();
			if (KitHandler.getKit(p.getName()) == KitType.FEATHER) {
				if (event.getCause() == DamageCause.FALL) {
					if (timers.containsKey(p.getName())) {
						int startY = timers.get(p.getName()).getStartY();
						int stopY = (int) p.getLocation().getY();
						int diffY = startY - stopY;
						int ticks = timers.get(p.getName()).getTicks();
						if (diffY >= 100) {
							if (ticks >= 53) {
								event.setCancelled(true);
							} else {
								p.setFallDistance(p.getFallDistance() / (ticks > 0 ? ticks : 1));
							}
						} else if (diffY >= 80 && diffY < 100) {
							if (ticks >= 43) {
								event.setCancelled(true);
							} else {
								p.setFallDistance(p.getFallDistance() / (ticks > 0 ? ticks : 1));
							}
						} else if (diffY >= 60 && diffY < 80) {
							if (ticks >= 33) {
								event.setCancelled(true);
							} else {
								p.setFallDistance(p.getFallDistance() / (ticks > 0 ? ticks : 1));
							}
						} else if (diffY >= 40 && diffY < 60) {
							if (ticks >= 23) {
								event.setCancelled(true);
							} else {
								p.setFallDistance(p.getFallDistance() / (ticks > 0 ? ticks : 1));
							}
						} else if (diffY >= 20 && diffY < 40) {
							if (ticks >= 15) {
								event.setCancelled(true);
							} else {
								event.setDamage(p.getFallDistance() / (ticks > 0 ? ticks : 1));
							}
						} else if (diffY > 10 && diffY < 20) {
							if (ticks >= 5) {
								event.setCancelled(true);
							} else {
								event.setDamage(p.getFallDistance() / (ticks > 0 ? ticks : 1));
							}
						} else if (diffY > 3 && diffY < 10) {
							if (ticks >= 2) {
								event.setCancelled(true);
							} else {
								event.setDamage(p.getFallDistance() / (ticks > 0 ? ticks : 1));
							}
						}
						timers.get(p.getName()).cancel();
						timers.remove(p.getName());
					} else {
						event.setCancelled(false);
					}
				} else {
				}
			} else {
			}
		}
	}

	public boolean onGround(Player p) {
		if (p.getLocation().clone().add(0, -1, 0).getBlock().getType() == Material.AIR) {
			return true;
		} else {
			return false;
		}
	}

	@EventHandler
	public void death(PlayerDeathEvent event) {
		Player p = event.getEntity();
		if (KitHandler.getKit(p.getName()) == KitType.FEATHER) {
			if (timers.containsKey(p.getName())) {
				timers.get(p.getName()).cancel();
				timers.remove(p.getName());
			}
		}
	}

	public class FeatherTimer extends BukkitRunnable {

		private int y;
		private Player p;

		public FeatherTimer(Player p) {
			y = (int) p.getLocation().getY();
			this.p = p;
		}

		int x = 0;

		public void run() {
			if (p.isSneaking()) {
				++x;
			}
		}

		public int getTicks() {
			return x;
		}

		public int getStartY() {
			return y;
		}

	}
}
