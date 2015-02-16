package com.experiencepvp.kits.listeners.cmds;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.experiencepvp.effects.GladiatorEffect;
import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

import de.slikey.effectlib.util.ParticleEffect;

public class Samurai implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("samurai")) {
			if (LevelUtil.getLevel(p, KitType.SAMURAI) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.SAMURAI.getUtil().giveKit(p, KitType.SAMURAI);
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

	public HashMap<String, Integer> samuraikills = new HashMap<String, Integer>();

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player dead = e.getEntity();
		Player kill = dead.getKiller();
		if (kill == null)
			return;
		if (KitHandler.getKit(dead.getName()) == KitType.SAMURAI) {
			if (samuraikills.containsKey(dead.getName())) {
				samuraikills.remove(dead);
			}
		}
		if(KitHandler.getKit(kill.getName()) == KitType.SAMURAI){
			handleSamuraiKill(kill);
		}
	}

	public void handleSamuraiKill(Player p) {
		PlayerInventory inv = p.getInventory();

		if (!samuraikills.containsKey(p.getName()))
			samuraikills.put(p.getName(), Integer.valueOf(1));
		else {
			samuraikills.put(p.getName(),
					Integer.valueOf((samuraikills.get(p.getName())) + 1));
		}
		
		if(KitHandler.getLevel(p.getName()) == 1){
			if(samuraikills.get(p.getName()) == 15){
				inv.remove(Material.STONE_SWORD);
				inv.addItem(new ItemStack(Material.IRON_SWORD));
				GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.INSTANT_SPELL);
				eff.setEntity(p);
				eff.start();
			}
		}else if(KitHandler.getLevel(p.getName()) == 2){
			if(samuraikills.get(p.getName()) == 15){
				inv.remove(Material.STONE_SWORD);
				inv.addItem(new ItemStack(Material.IRON_SWORD));
				GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.INSTANT_SPELL);
				eff.setEntity(p);
				eff.start();
			}else if(samuraikills.get(p.getName()) == 25){
				inv.remove(Material.STONE_SWORD);
				inv.remove(Material.IRON_SWORD);
				inv.addItem(new ItemStack(Material.DIAMOND_SWORD));
				GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.INSTANT_SPELL);
				eff.setEntity(p);
				eff.start();
			}
		}else if(KitHandler.getLevel(p.getName()) == 3){
			if(samuraikills.get(p.getName()) == 10){
				inv.remove(Material.STONE_SWORD);
				inv.addItem(new ItemStack(Material.IRON_SWORD));
				GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.INSTANT_SPELL);
				eff.setEntity(p);
				eff.start();
			}else if(samuraikills.get(p.getName()) == 20){
				inv.remove(Material.STONE_SWORD);
				inv.remove(Material.IRON_SWORD);
				inv.addItem(new ItemStack(Material.DIAMOND_SWORD));
				GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.INSTANT_SPELL);
				eff.setEntity(p);
				eff.start();
			}
		}else if(KitHandler.getLevel(p.getName()) == 4){
			if(samuraikills.get(p.getName()) == 5){
				inv.remove(Material.STONE_SWORD);
				inv.addItem(new ItemStack(Material.IRON_SWORD));
				GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.INSTANT_SPELL);
				eff.setEntity(p);
				eff.start();
			}else if(samuraikills.get(p.getName()) == 15){
				inv.remove(Material.STONE_SWORD);
				inv.remove(Material.IRON_SWORD);
				inv.addItem(new ItemStack(Material.DIAMOND_SWORD));
				GladiatorEffect eff = new GladiatorEffect(Main.em, ParticleEffect.INSTANT_SPELL);
				eff.setEntity(p);
				eff.start();
			}
		}
	}
}
