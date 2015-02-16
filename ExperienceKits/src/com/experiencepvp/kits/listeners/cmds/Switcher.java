package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.server.v1_7_R4.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.kits.utils.KitUtil;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Switcher implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("switcher")) {
			if (LevelUtil.getLevel(p, KitType.SWITCHER) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.SWITCHER.getUtil().giveKit(p, KitType.SWITCHER);
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

	private ArrayList<String> cooldowns = new ArrayList<String>();
	private List<Snowball> balls = new ArrayList<Snowball>();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLaunch(final ProjectileLaunchEvent event) {
		if (!(event.getEntity() instanceof Snowball))
			return;
		if (!(event.getEntity().getShooter() instanceof Player))
			return;
		final Player p = (Player) event.getEntity().getShooter();
		if (KitHandler.getKit(p.getName()) == KitType.SWITCHER && Main.correctRegion(p.getLocation())) {
			if (cooldowns.contains(p.getName())) {
				p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
				event.setCancelled(true);
			} else {
				Snowball ball = (Snowball) event.getEntity();
				balls.add(ball);
				cooldowns.add(p.getName());
				
				if(KitHandler.getLevel(p.getName()) == 1){
					new BukkitRunnable(){
						public void run(){
							cooldowns.remove(p.getName());
							p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
						}
					}.runTaskLater(Main.getPlugin(), 400);
				}else if(KitHandler.getLevel(p.getName()) == 2){
					new BukkitRunnable(){
						public void run(){
							cooldowns.remove(p.getName());
							p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
						}
					}.runTaskLater(Main.getPlugin(), 300);
				}else if(KitHandler.getLevel(p.getName()) == 3){
					new BukkitRunnable(){
						public void run(){
							cooldowns.remove(p.getName());
							p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
						}
					}.runTaskLater(Main.getPlugin(), 200);
				}else if(KitHandler.getLevel(p.getName()) == 4){
					new BukkitRunnable(){
						public void run(){
							cooldowns.remove(p.getName());
							p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
						}
					}.runTaskLater(Main.getPlugin(), 100);
				}
				
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.getEntityType() == EntityType.PLAYER && e.getDamager().getType() == EntityType.SNOWBALL) {
			Player hit = (Player) e.getEntity();
			Snowball b = (Snowball) e.getDamager();
			if (!balls.contains(b))
				return;
			if (b.getShooter() instanceof Player) {
				Player p = (Player) b.getShooter();
				if (KitHandler.getKit(p.getName()) == KitType.SWITCHER && Main.correctRegion(hit.getLocation()) && Main.correctRegion(p.getLocation())) {
					Location hitloc = hit.getLocation();
					Location ploc = p.getLocation();
					hit.teleport(ploc);
					p.teleport(hitloc);
					b.remove();
					balls.remove(b);
				}
			}
		}
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if (cooldowns.contains(e.getEntity().getName()))
			cooldowns.remove(e.getEntity().getName());
	}
}
