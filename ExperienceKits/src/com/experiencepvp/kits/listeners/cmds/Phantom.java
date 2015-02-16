package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.effects.PhantomEffect;
import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

import de.slikey.effectlib.util.ParticleEffect;

public class Phantom implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("phantom")) {
			if (LevelUtil.getLevel(p, KitType.PHANTOM) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.PHANTOM.getUtil().giveKit(p, KitType.PHANTOM);
					return true;
				} else {
					p.sendMessage("§cYou can only have one kit per life!");
					return true;
				}
			} else {
				p.sendMessage("§cYou haven't bought this kit yet!");
				return true;
			}
		}
		return true;
	}
	
	public List<String> cooldown = new ArrayList<String>();
	
	@EventHandler
	public void onPhantom(PlayerInteractEvent e){
	final Player p = e.getPlayer();
	if ((p.getItemInHand().getType() == Material.FEATHER) && 
		KitHandler.getKit(p.getName()) == KitType.PHANTOM)
		if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK) && Main.correctRegion(p.getLocation()))
			if (!cooldown.contains(p.getName())) {
				cooldown.add(p.getName());
				p.setAllowFlight(true);
				p.setFlying(true);
				final PhantomEffect eff = new PhantomEffect(Main.em, ParticleEffect.FIREWORKS_SPARK);
				eff.setEntity(p);
				eff.start();
				if(KitHandler.getLevel(p.getName()) == 1){
					p.sendMessage(Main.pref + ChatColor.BLUE + "You can now fly for 5 seconds!");
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "4 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 20);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "3 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 40);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "2 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 60);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "1 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 80);
					
					new BukkitRunnable(){
						public void run() {
							p.setAllowFlight(false);
							p.setFlying(false);
							eff.cancel();
							p.sendMessage(Main.pref + ChatColor.RED + "Your wings couldn't hold you anymore!");
						}
					}.runTaskLater(Main.getPlugin(), 100);
					
					new BukkitRunnable(){
						public void run(){
							cooldown.remove(p.getName());
							p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
						}
					}.runTaskLater(Main.getPlugin(), 600);
				}else if(KitHandler.getLevel(p.getName()) == 2){
					p.sendMessage(Main.pref + ChatColor.BLUE + "You can now fly for 7 seconds!");
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "6 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 20);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "5 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 40);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "4 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 60);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "3 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 80);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "2 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 100);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "1 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 120);
					
					new BukkitRunnable(){
						public void run() {
							p.setAllowFlight(false);
							p.setFlying(false);
							eff.cancel();
							p.sendMessage(Main.pref + ChatColor.RED + "Your wings couldn't hold you anymore!");
						}
					}.runTaskLater(Main.getPlugin(), 140);
					
					new BukkitRunnable(){
						public void run(){
							cooldown.remove(p.getName());
							p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
						}
					}.runTaskLater(Main.getPlugin(), 500);
				}else if(KitHandler.getLevel(p.getName()) == 3){
					p.sendMessage(Main.pref + ChatColor.BLUE + "You can now fly for 7 seconds!");
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "6 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 20);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "5 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 40);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "4 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 60);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "3 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 80);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "2 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 100);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "1 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 120);
					
					new BukkitRunnable(){
						public void run() {
							p.setAllowFlight(false);
							p.setFlying(false);
							eff.cancel();
							p.sendMessage(Main.pref + ChatColor.RED + "Your wings couldn't hold you anymore!");
						}
					}.runTaskLater(Main.getPlugin(), 140);
					
					new BukkitRunnable(){
						public void run(){
							cooldown.remove(p.getName());
							p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
						}
					}.runTaskLater(Main.getPlugin(), 400);
				}else if(KitHandler.getLevel(p.getName()) == 4){
					p.sendMessage(Main.pref + ChatColor.BLUE + "You can now fly for 10 seconds!");
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "9 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 20);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "8 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 40);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "7 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 60);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "6 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 80);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "5 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 100);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "4 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 120);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "3 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 140);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "2 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 160);
					
					new BukkitRunnable(){
						public void run(){
							p.sendMessage(Main.pref + ChatColor.BLUE + "1 seconds of flight remaining!");
						}
					}.runTaskLater(Main.getPlugin(), 180);
					
					new BukkitRunnable(){
						public void run() {
							p.setAllowFlight(false);
							p.setFlying(false);
							eff.cancel();
							p.sendMessage(Main.pref + ChatColor.RED + "Your wings couldn't hold you anymore!");
						}
					}.runTaskLater(Main.getPlugin(), 200);
					
					new BukkitRunnable(){
						public void run(){
							cooldown.remove(p.getName());
							p.sendMessage(Main.pref + ChatColor.BLUE + "You are no longer on cooldown!");
						}
					}.runTaskLater(Main.getPlugin(), 400);
				}
				
			}else{
				p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
			}
	 	}
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDeathRemove(PlayerDeathEvent e) {
		e.getEntity().setAllowFlight(false);
		e.getEntity().setFlying(false);
		if (cooldown.contains(e.getEntity().getName())) {
			cooldown.remove(e.getEntity().getName());
		}
	}
}
