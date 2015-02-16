package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.freekit.FreeKitMain;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.methods.KitMethods;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.kits.utils.KitUtil;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Enderman implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("enderman")) {
			if (LevelUtil.getLevel(p, KitType.ENDERMAN) > 0){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.ENDERMAN.getUtil().giveKit(p, KitType.ENDERMAN);
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

	public HashMap<Player, EnderPearl> pearls = new HashMap<Player, EnderPearl>();

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (KitHandler.getKit(p.getName()) == KitType.ENDERMAN) {
			if (p.getItemInHand().getType() == Material.ENDER_PEARL
					&& Main.correctRegion(p.getLocation())) {
				e.setCancelled(true);
				if (!pearls.containsKey(p)) {
					EnderPearl pearl = p.launchProjectile(EnderPearl.class);
					pearl.setVelocity(pearl.getVelocity().normalize().multiply(1.5D));
					removeInventoryItems(p.getInventory(), Material.ENDER_PEARL, 1);
					pearls.put(p, pearl);
				} else {
					p.sendMessage("§cStill on cooldown!");
				}
			}
		}
	}

	public HashMap<String, Integer> locint = new HashMap<String, Integer>();
	
	@EventHandler
	public void onTeleport(final PlayerTeleportEvent e) {
		final Player p = e.getPlayer();
		if (KitHandler.getKit(p.getName()) == KitType.ENDERMAN) {
			if (e.getCause() == TeleportCause.ENDER_PEARL) {
				e.setCancelled(true);
				try {
					if (pearls.containsKey(p)) {
						p.teleport(e.getTo());
						if(KitHandler.getLevel(p.getName()) == 1){
							new BukkitRunnable() {
								public void run() {
									if (pearls.containsKey(p)) {
										pearls.remove(p);
										p.sendMessage("§aYou are no longer on cooldown!");
										p.getInventory().addItem(KitUtil.setName(new ItemStack(Material.ENDER_PEARL), "§9Enderman's pearls"));
									}
								}
							}.runTaskLater(Main.getPlugin(), 600L);
						}else if(KitHandler.getLevel(p.getName()) == 2){
							new BukkitRunnable() {
								public void run() {
									if (pearls.containsKey(p)) {
										pearls.remove(p);
										p.sendMessage("§aYou are no longer on cooldown!");
										p.getInventory().addItem(KitUtil.setName(new ItemStack(Material.ENDER_PEARL), "§9Enderman's pearls"));
									}
								}
							}.runTaskLater(Main.getPlugin(), 400L);
						}else if(KitHandler.getLevel(p.getName()) == 3){
							new BukkitRunnable() {
								public void run() {
									if (pearls.containsKey(p)) {
										pearls.remove(p);
										p.sendMessage("§aYou are no longer on cooldown!");
										p.getInventory().addItem(KitUtil.setName(new ItemStack(Material.ENDER_PEARL), "§9Enderman's pearls"));
									}
								}
							}.runTaskLater(Main.getPlugin(), 300L);
						}else if(KitHandler.getLevel(p.getName()) == 4){
							new BukkitRunnable() {
								public void run() {
									if (pearls.containsKey(p)) {
										pearls.remove(p);
										p.sendMessage("§aYou are no longer on cooldown!");
										p.getInventory().addItem(KitUtil.setName(new ItemStack(Material.ENDER_PEARL), "§9Enderman's pearls"));
									}
								}
							}.runTaskLater(Main.getPlugin(), 200L);
						}
					}
				} catch (NullPointerException ex) {
					System.out.println("Couldn't teleport!");
				}
			}
		}
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if (pearls.containsKey(p)) {
			pearls.remove(p);
		}
	}

	public static void removeInventoryItems(PlayerInventory inv, Material type,
			int amount) {
		for (ItemStack is : inv.getContents()) {
			if (is != null && is.getType() == type) {
				int newamount = is.getAmount() - amount;
				if (newamount > 0) {
					is.setAmount(newamount);
					break;
				} else {
					inv.remove(is);
					amount = -newamount;
					if (amount == 0)
						break;
				}
			}
		}
	}
	
	public List<Block> blocksFromTwoPoints(Location loc1, Location loc2){
        List<Block> blocks = new ArrayList<Block>();
 
        int topBlockX = (loc1.getBlockX() < loc2.getBlockX() ? loc2.getBlockX() : loc1.getBlockX());
        int bottomBlockX = (loc1.getBlockX() > loc2.getBlockX() ? loc2.getBlockX() : loc1.getBlockX());
 
        int topBlockY = (loc1.getBlockY() < loc2.getBlockY() ? loc2.getBlockY() : loc1.getBlockY());
        int bottomBlockY = (loc1.getBlockY() > loc2.getBlockY() ? loc2.getBlockY() : loc1.getBlockY());
 
        int topBlockZ = (loc1.getBlockZ() < loc2.getBlockZ() ? loc2.getBlockZ() : loc1.getBlockZ());
        int bottomBlockZ = (loc1.getBlockZ() > loc2.getBlockZ() ? loc2.getBlockZ() : loc1.getBlockZ());
 
        for(int x = bottomBlockX; x <= topBlockX; x++){
            for(int z = bottomBlockZ; z <= topBlockZ; z++){
                for(int y = bottomBlockY; y <= topBlockY; y++){
                    Block block = loc1.getWorld().getBlockAt(x, y, z);
                   
                    blocks.add(block);
                }
            }
        }
       
        return blocks;
    }
}
