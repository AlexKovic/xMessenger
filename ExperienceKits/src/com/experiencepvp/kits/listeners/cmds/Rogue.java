package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.effects.GladiatorEffect;
import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.listeners.PlayerListener;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

import de.slikey.effectlib.util.ParticleEffect;

public class Rogue implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("rogue")) {
			if (LevelUtil.getLevel(p, KitType.ROGUE) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.ROGUE.getUtil().giveKit(p, KitType.ROGUE);
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
	
	public HashMap<Player, KitType> kits = new HashMap<Player, KitType>();
	public HashMap<Player, Integer> kitlvl = new HashMap<Player, Integer>();
	
	public ArrayList<String> cooldown = new ArrayList<String>();
	
	@EventHandler
	public void onInteractEntity(PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (e.getRightClicked() instanceof Player) {
			final Player r = (Player) e.getRightClicked();
			if (KitHandler.getKit(p.getName()) == KitType.ROGUE && Main.correctRegion(p.getLocation())) {
				if (p.getItemInHand() != null) {
					if (p.getItemInHand().getType() == Material.BLAZE_ROD) {
						if (!cooldown.contains(p.getName())) {
							if(KitHandler.getLevel(p.getName()) == 1){
								kits.put(r, KitHandler.getKit(r.getName()));
								kitlvl.put(r, KitHandler.getLevel(r.getName()));
								
								GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.ANGRY_VILLAGER);
								eff.setEntity(r);
								eff.start();
								
								KitHandler.delKit(r);
								
								p.sendMessage(Main.pref + ChatColor.BLUE + "You have successfully removed the kit of " + ChatColor.GOLD + r.getName() + ChatColor.BLUE + "!");
								r.sendMessage(Main.pref + ChatColor.RED + "A rogue removed your kit for 10 seconds");;
								
								cooldown.add(p.getName());
								new BukkitRunnable() {
									public void run() {
										if (kits.containsKey(r)) {
											KitHandler.setKit(r, kits.get(r));
											KitHandler.setLevel(r, kitlvl.get(p.getName()));
											r.sendMessage(Main.pref + ChatColor.BLUE+ "You can use your kit again!");
										}
									}
								}.runTaskLater(Main.getPlugin(), 200);
								
								new BukkitRunnable() {
									public void run() {
										if (cooldown.contains(p.getName())) {
											cooldown.remove(p.getName());
											p.sendMessage(Main.pref + ChatColor.BLUE + " You are no longer on cooldown!");
										}
									}
								}.runTaskLater(Main.getPlugin(), 600L);
							}							
						} else {
							p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitHandler.getKit(p.getName()) == KitType.ROGUE && Main.correctRegion(p.getLocation())) {
			if (p.getItemInHand() != null) {
				if (p.getItemInHand().getType() == Material.BLAZE_ROD) {
					if (!cooldown.contains(p.getName())) {
						if(KitHandler.getLevel(p.getName()) == 2){
							for(Entity ent : p.getNearbyEntities(5, 5, 5)){
								if(ent instanceof Player){
									final Player r = (Player) ent;
									kits.put(r, KitHandler.getKit(r.getName()));
									kitlvl.put(r, KitHandler.getLevel(r.getName()));
								
									GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.ANGRY_VILLAGER);
									eff.setEntity(r);
									eff.start();
									
									KitHandler.delKit(r);
								
									p.sendMessage(Main.pref + ChatColor.BLUE + "You have successfully removed the kit of " + ChatColor.GOLD + r.getName() + ChatColor.BLUE + "!");
									r.sendMessage(Main.pref + ChatColor.RED + "A rogue removed your kit for 10 seconds");;
								
									cooldown.add(p.getName());
									new BukkitRunnable() {
										public void run() {
											if (kits.containsKey(r)) {
												KitHandler.setKit(r, kits.get(r));
												KitHandler.setLevel(r, kitlvl.get(p.getName()));
												r.sendMessage(Main.pref + ChatColor.BLUE+ "You can use your kit again!");
											}
										}
									}.runTaskLater(Main.getPlugin(), 200);
								
									new BukkitRunnable() {
										public void run() {
											if (cooldown.contains(p.getName())) {
												cooldown.remove(p.getName());
												p.sendMessage(Main.pref + ChatColor.BLUE + " You are no longer on cooldown!");
											}
										}
									}.runTaskLater(Main.getPlugin(), 600L);
								}	
							}
						}else if(KitHandler.getLevel(p.getName()) == 3){
							for(Entity ent : p.getNearbyEntities(7, 7, 7)){
								if(ent instanceof Player){
									final Player r = (Player) ent;
									kits.put(r, KitHandler.getKit(r.getName()));
									kitlvl.put(r, KitHandler.getLevel(r.getName()));
								
									GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.ANGRY_VILLAGER);
									eff.setEntity(r);
									eff.start();
									
									KitHandler.delKit(r);
								
									p.sendMessage(Main.pref + ChatColor.BLUE + "You have successfully removed the kit of " + ChatColor.GOLD + r.getName() + ChatColor.BLUE + "!");
									r.sendMessage(Main.pref + ChatColor.RED + "A rogue removed your kit for 10 seconds");;
								
									cooldown.add(p.getName());
									new BukkitRunnable() {
										public void run() {
											if (kits.containsKey(r)) {
												KitHandler.setKit(r, kits.get(r));
												KitHandler.setLevel(r, kitlvl.get(p.getName()));
												r.sendMessage(Main.pref + ChatColor.BLUE+ "You can use your kit again!");
											}
										}
									}.runTaskLater(Main.getPlugin(), 200);
								
									new BukkitRunnable() {
										public void run() {
											if (cooldown.contains(p.getName())) {
												cooldown.remove(p.getName());
												p.sendMessage(Main.pref + ChatColor.BLUE + " You are no longer on cooldown!");
											}
										}
									}.runTaskLater(Main.getPlugin(), 400L);
								}	
							}
						}
					}else{
						p.sendMessage(Main.pref + ChatColor.RED + "You are still on cooldown!");
					}
				}
			}
		}
	}
	
	public static HashMap<String, String> rpl = new HashMap<String, String>();
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		final Player p = e.getPlayer();
		if (KitHandler.getKit(p.getName()) == KitType.ROGUE && Main.correctRegion(p.getLocation())) {
			if(KitHandler.getLevel(p.getName()) == 4){
				List<Entity> ents = p.getNearbyEntities(7, 7, 7);
				for(Entity ent : ents){
					if(ent instanceof Player){
						final Player r = (Player) ent;
						if(!rpl.containsKey(r.getName())){
							rpl.put(r.getName(), p.getName());
							kits.put(r, KitHandler.getKit(r.getName()));
							kitlvl.put(r, KitHandler.getLevel(r.getName()));
							
							GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.ANGRY_VILLAGER);
							eff.setEntity(r);
							eff.start();
							
							KitHandler.delKit(r);
							r.sendMessage(Main.pref + ChatColor.RED + "A rogue removed your kit! Your kit will return when you are at least 8 blocks away from him!");;
								
							cooldown.add(p.getName());
						}
					}
				}
				
				for(String s : rpl.keySet()){
					if(rpl.get(s).equalsIgnoreCase(p.getName())){
						Player r = Bukkit.getServer().getPlayer(s);
						if(r != null){
							if(!ents.contains(r)){
								if(!PlayerListener.isInSpawnRegion(r.getLocation())){
									KitHandler.setKit(r, kits.get(r.getName()));
									if(kitlvl.containsKey(r.getName())){
										KitHandler.setLevel(r, kitlvl.get(r.getName()));
									}
									r.sendMessage(Main.pref + ChatColor.BLUE + "You can use your kit again!");
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	@EventHandler
	public void onDeathRemove(PlayerDeathEvent e) {
		if(cooldown.contains(e.getEntity().getName())){
			cooldown.remove(e.getEntity().getName());
		}
		for(String s : rpl.keySet()){
			if(rpl.get(s).equalsIgnoreCase(e.getEntity().getName())){
				Player r = Bukkit.getServer().getPlayer(s);
				if(r != null){
					KitHandler.setKit(r, kits.get(r.getName()));
					KitHandler.setLevel(r, kitlvl.get(r.getName()));
					r.sendMessage(Main.pref + ChatColor.BLUE + "You can use your kit again!");
				}
			}
		}
	}
}
