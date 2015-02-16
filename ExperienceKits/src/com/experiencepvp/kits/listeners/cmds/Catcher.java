package com.experiencepvp.kits.listeners.cmds;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.listeners.PlayerListener;
import com.experiencepvp.kits.utils.KitHandler;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.levels.LevelUtil;
import com.experiencepvp.oneversusone.OneVOneUtil;

public class Catcher implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cYou may not use this command since you are not a player!");
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("catcher")) {
			if (LevelUtil.getLevel(p, KitType.CATCHER) > 0 && p.isOp()){
				
				if(!OneVOneUtil.canGetKitIn1v1(p)){
					p.sendMessage(OneVOneUtil.pref + ChatColor.RED + "You can't choose a kit here!");
					return false;
				}
				
				if (!KitHandler.hasKit(p.getName())) {
					KitType.CATCHER.getUtil().giveKit(p, KitType.CATCHER);
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
	
	public ArrayList<String> cd = new ArrayList<String>();
	public HashMap<Location, Material> mat = new HashMap<Location, Material>();
	public HashMap<Location, Byte> dat = new HashMap<Location, Byte>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClickAnvil(PlayerInteractEvent e){
		final Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR){
			if(p.getInventory().getItemInHand().getType() == Material.GLASS){
				if(!cd.contains(p.getName())){
					if(p.getNearbyEntities(20, 20, 20).isEmpty()){
						p.sendMessage(Main.pref + ChatColor.RED + "No enemies near you!");
						return;
					}
					cd.add(p.getName());
					for(Entity ent : p.getNearbyEntities(20, 20, 20)){
						if(ent instanceof Player){
							final Location l = ent.getLocation();
							final Location l1 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() - 1, l.getBlockZ());
							final Location l2 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() - 1, l.getBlockZ());
							final Location l3 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() - 1, l.getBlockZ());
							final Location l4 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() - 1, l.getBlockZ() + 1);
							final Location l5 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() - 1, l.getBlockZ() + 1);
							final Location l6 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() - 1, l.getBlockZ() + 1);
							final Location l7 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() - 1, l.getBlockZ() - 1);
							final Location l8 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() - 1, l.getBlockZ() - 1);
							final Location l9 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() - 1, l.getBlockZ() + 1);
							
							final Location l10 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 2, l.getBlockZ());
							final Location l11 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 2, l.getBlockZ());
							final Location l12 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 2, l.getBlockZ());
							final Location l13 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 2, l.getBlockZ() + 1);
							final Location l14 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 2, l.getBlockZ() + 1);
							final Location l15 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 2, l.getBlockZ() + 1);
							final Location l16 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 2, l.getBlockZ() - 1);
							final Location l17 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 2, l.getBlockZ() - 1);
							final Location l18 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 2, l.getBlockZ() + 1);

							final Location l35 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY(), l.getBlockZ());
							final Location l19 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY(), l.getBlockZ());
							final Location l20 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY(), l.getBlockZ());
							final Location l21 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY(), l.getBlockZ() + 1);
							final Location l22 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY(), l.getBlockZ() + 1);
							final Location l23 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY(), l.getBlockZ() + 1);
							final Location l24 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY(), l.getBlockZ() - 1);
							final Location l25 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY(), l.getBlockZ() - 1);
							final Location l26 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY(), l.getBlockZ() + 1);
							
							final Location l36 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 1, l.getBlockZ());
							final Location l27 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 1, l.getBlockZ());
							final Location l28 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 1, l.getBlockZ());
							final Location l29 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 1, l.getBlockZ() + 1);
							final Location l30 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() + 1, l.getBlockZ() + 1);
							final Location l31 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 1, l.getBlockZ() + 1);
							final Location l32 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 1, l.getBlockZ() - 1);
							final Location l33 = new Location(l.getWorld(), l.getBlockX() + 1, l.getBlockY() + 1, l.getBlockZ() - 1);
							final Location l34 = new Location(l.getWorld(), l.getBlockX() - 1, l.getBlockY() + 1, l.getBlockZ() + 1);
							
							if(PlayerListener.prot.contains(l1) && !PlayerListener.prot.contains(l2) && !PlayerListener.prot.contains(l3) && !PlayerListener.prot.contains(l4) && !PlayerListener.prot.contains(l5) && !PlayerListener.prot.contains(l6) && !PlayerListener.prot.contains(l7) && !PlayerListener.prot.contains(l8) && !PlayerListener.prot.contains(l9) && !PlayerListener.prot.contains(l10) && !PlayerListener.prot.contains(l11) && !PlayerListener.prot.contains(l12) && !PlayerListener.prot.contains(l13) && !PlayerListener.prot.contains(l14) && !PlayerListener.prot.contains(l15) && !PlayerListener.prot.contains(l16) && !PlayerListener.prot.contains(l17) && !PlayerListener.prot.contains(l18) && !PlayerListener.prot.contains(l19) && !PlayerListener.prot.contains(l20) && !PlayerListener.prot.contains(l21) && !PlayerListener.prot.contains(l22) && !PlayerListener.prot.contains(l23) && !PlayerListener.prot.contains(l24) && !PlayerListener.prot.contains(l25) && !PlayerListener.prot.contains(l26) && !PlayerListener.prot.contains(l27) && !PlayerListener.prot.contains(l28) && !PlayerListener.prot.contains(l29) && !PlayerListener.prot.contains(l30) && !PlayerListener.prot.contains(l31) && !PlayerListener.prot.contains(l32) && !PlayerListener.prot.contains(l33) && !PlayerListener.prot.contains(l34) && !PlayerListener.prot.contains(l35) && !PlayerListener.prot.contains(l36)){
								mat.put(l1, l1.getBlock().getType());
								mat.put(l2, l2.getBlock().getType());
								mat.put(l3, l3.getBlock().getType());
								mat.put(l4, l4.getBlock().getType());
								mat.put(l5, l5.getBlock().getType());
								mat.put(l6, l6.getBlock().getType());
								mat.put(l7, l7.getBlock().getType());
								mat.put(l8, l8.getBlock().getType());
								mat.put(l9, l9.getBlock().getType());
								mat.put(l10, l10.getBlock().getType());
								mat.put(l11, l11.getBlock().getType());
								mat.put(l12, l12.getBlock().getType());
								mat.put(l13, l13.getBlock().getType());
								mat.put(l14, l14.getBlock().getType());
								mat.put(l15, l15.getBlock().getType());
								mat.put(l16, l16.getBlock().getType());
								mat.put(l17, l17.getBlock().getType());
								mat.put(l18, l18.getBlock().getType());
								mat.put(l19, l19.getBlock().getType());
								mat.put(l20, l20.getBlock().getType());
								mat.put(l21, l21.getBlock().getType());
								mat.put(l22, l22.getBlock().getType());
								mat.put(l23, l23.getBlock().getType());
								mat.put(l24, l24.getBlock().getType());
								mat.put(l25, l25.getBlock().getType());
								mat.put(l26, l26.getBlock().getType());
								mat.put(l27, l27.getBlock().getType());
								mat.put(l28, l28.getBlock().getType());
								mat.put(l29, l29.getBlock().getType());
								mat.put(l30, l30.getBlock().getType());
								mat.put(l31, l31.getBlock().getType());
								mat.put(l32, l32.getBlock().getType());
								mat.put(l33, l33.getBlock().getType());
								mat.put(l34, l34.getBlock().getType());
								mat.put(l35, l35.getBlock().getType());
								mat.put(l36, l36.getBlock().getType());
								
								dat.put(l1, l1.getBlock().getData());
								dat.put(l2, l2.getBlock().getData());
								dat.put(l3, l3.getBlock().getData());
								dat.put(l4, l4.getBlock().getData());
								dat.put(l5, l5.getBlock().getData());
								dat.put(l6, l6.getBlock().getData());
								dat.put(l7, l7.getBlock().getData());
								dat.put(l8, l8.getBlock().getData());
								dat.put(l9, l9.getBlock().getData());
								dat.put(l10, l10.getBlock().getData());
								dat.put(l11, l11.getBlock().getData());
								dat.put(l12, l12.getBlock().getData());
								dat.put(l13, l13.getBlock().getData());
								dat.put(l14, l14.getBlock().getData());
								dat.put(l15, l15.getBlock().getData());
								dat.put(l16, l16.getBlock().getData());
								dat.put(l17, l17.getBlock().getData());
								dat.put(l18, l18.getBlock().getData());
								dat.put(l19, l19.getBlock().getData());
								dat.put(l20, l20.getBlock().getData());
								dat.put(l21, l21.getBlock().getData());
								dat.put(l22, l22.getBlock().getData());
								dat.put(l23, l23.getBlock().getData());
								dat.put(l24, l24.getBlock().getData());
								dat.put(l25, l25.getBlock().getData());
								dat.put(l26, l26.getBlock().getData());
								dat.put(l27, l27.getBlock().getData());
								dat.put(l28, l28.getBlock().getData());
								dat.put(l29, l29.getBlock().getData());
								dat.put(l30, l30.getBlock().getData());
								dat.put(l31, l31.getBlock().getData());
								dat.put(l32, l32.getBlock().getData());
								dat.put(l33, l33.getBlock().getData());
								dat.put(l34, l34.getBlock().getData());
								dat.put(l35, l35.getBlock().getData());
								dat.put(l36, l36.getBlock().getData());
								
								dat.put(l1, l1.getBlock().getData());
								dat.put(l2, l2.getBlock().getData());
								dat.put(l3, l3.getBlock().getData());
								dat.put(l4, l4.getBlock().getData());
								dat.put(l5, l5.getBlock().getData());
								dat.put(l6, l6.getBlock().getData());
								dat.put(l7, l7.getBlock().getData());
								dat.put(l8, l8.getBlock().getData());
								dat.put(l9, l9.getBlock().getData());
								dat.put(l10, l10.getBlock().getData());
								dat.put(l11, l11.getBlock().getData());
								dat.put(l12, l12.getBlock().getData());
								dat.put(l13, l13.getBlock().getData());
								dat.put(l14, l14.getBlock().getData());
								dat.put(l15, l15.getBlock().getData());
								dat.put(l16, l16.getBlock().getData());
								dat.put(l17, l17.getBlock().getData());
								dat.put(l18, l18.getBlock().getData());
								dat.put(l19, l19.getBlock().getData());
								dat.put(l20, l20.getBlock().getData());
								dat.put(l21, l21.getBlock().getData());
								dat.put(l22, l22.getBlock().getData());
								dat.put(l23, l23.getBlock().getData());
								dat.put(l24, l24.getBlock().getData());
								dat.put(l25, l25.getBlock().getData());
								dat.put(l26, l26.getBlock().getData());
								dat.put(l27, l27.getBlock().getData());
								dat.put(l28, l28.getBlock().getData());
								dat.put(l29, l29.getBlock().getData());
								dat.put(l30, l30.getBlock().getData());
								dat.put(l31, l31.getBlock().getData());
								dat.put(l32, l32.getBlock().getData());
								dat.put(l33, l33.getBlock().getData());
								dat.put(l34, l34.getBlock().getData());
								dat.put(l35, l35.getBlock().getData());
								dat.put(l36, l36.getBlock().getData());

								PlayerListener.prot.add(l1);
								PlayerListener.prot.add(l2);
								PlayerListener.prot.add(l3);
								PlayerListener.prot.add(l4);
								PlayerListener.prot.add(l5);
								PlayerListener.prot.add(l6);
								PlayerListener.prot.add(l7);
								PlayerListener.prot.add(l8);
								PlayerListener.prot.add(l9);
								PlayerListener.prot.add(l10);
								PlayerListener.prot.add(l11);
								PlayerListener.prot.add(l12);
								PlayerListener.prot.add(l13);
								PlayerListener.prot.add(l14);
								PlayerListener.prot.add(l15);
								PlayerListener.prot.add(l16);
								PlayerListener.prot.add(l17);
								PlayerListener.prot.add(l18);
								PlayerListener.prot.add(l19);
								PlayerListener.prot.add(l20);
								PlayerListener.prot.add(l21);
								PlayerListener.prot.add(l22);
								PlayerListener.prot.add(l23);
								PlayerListener.prot.add(l24);
								PlayerListener.prot.add(l25);
								PlayerListener.prot.add(l26);
								PlayerListener.prot.add(l27);
								PlayerListener.prot.add(l28);
								PlayerListener.prot.add(l29);
								PlayerListener.prot.add(l30);
								PlayerListener.prot.add(l31);
								PlayerListener.prot.add(l32);
								PlayerListener.prot.add(l33);
								PlayerListener.prot.add(l34);
								PlayerListener.prot.add(l35);
								PlayerListener.prot.add(l36);
								
								l1.getBlock().setType(Material.GLASS);
								l2.getBlock().setType(Material.GLASS);
								l3.getBlock().setType(Material.GLASS);
								l4.getBlock().setType(Material.GLASS);
								l5.getBlock().setType(Material.GLASS);
								l6.getBlock().setType(Material.GLASS);
								l7.getBlock().setType(Material.GLASS);
								l8.getBlock().setType(Material.GLASS);
								l9.getBlock().setType(Material.GLASS);
								l10.getBlock().setType(Material.GLASS);
								l11.getBlock().setType(Material.GLASS);
								l12.getBlock().setType(Material.GLASS);
								l13.getBlock().setType(Material.GLASS);
								l14.getBlock().setType(Material.GLASS);
								l15.getBlock().setType(Material.GLASS);
								l16.getBlock().setType(Material.GLASS);
								l17.getBlock().setType(Material.GLASS);
								l18.getBlock().setType(Material.GLASS);
								l19.getBlock().setType(Material.GLASS);
								l20.getBlock().setType(Material.GLASS);
								l21.getBlock().setType(Material.GLASS);
								l22.getBlock().setType(Material.GLASS);
								l23.getBlock().setType(Material.GLASS);
								l24.getBlock().setType(Material.GLASS);
								l25.getBlock().setType(Material.GLASS);
								l26.getBlock().setType(Material.GLASS);
								l27.getBlock().setType(Material.GLASS);
								l28.getBlock().setType(Material.GLASS);
								l29.getBlock().setType(Material.GLASS);
								l30.getBlock().setType(Material.GLASS);
								l31.getBlock().setType(Material.GLASS);
								l32.getBlock().setType(Material.GLASS);
								l33.getBlock().setType(Material.GLASS);
								l34.getBlock().setType(Material.GLASS);
								l35.getBlock().setType(Material.STATIONARY_LAVA);
								l36.getBlock().setType(Material.STATIONARY_LAVA);
								
								ent.teleport(new Location(l.getWorld(), l.getBlockX() + 0.5, l.getBlockY() + 0.5, l.getBlockZ() + 0.5));
								
								new BukkitRunnable(){
									public void run(){
										l1.getBlock().setType(mat.get(l1));
										l2.getBlock().setType(mat.get(l2));
										l3.getBlock().setType(mat.get(l3));
										l4.getBlock().setType(mat.get(l4));
										l5.getBlock().setType(mat.get(l5));
										l6.getBlock().setType(mat.get(l6));
										l7.getBlock().setType(mat.get(l7));
										l8.getBlock().setType(mat.get(l8));
										l9.getBlock().setType(mat.get(l9));
										l10.getBlock().setType(mat.get(l10));
										l11.getBlock().setType(mat.get(l11));
										l12.getBlock().setType(mat.get(l12));
										l13.getBlock().setType(mat.get(l13));
										l14.getBlock().setType(mat.get(l14));
										l15.getBlock().setType(mat.get(l15));
										l16.getBlock().setType(mat.get(l16));
										l17.getBlock().setType(mat.get(l17));
										l18.getBlock().setType(mat.get(l18));
										l19.getBlock().setType(mat.get(l19));
										l20.getBlock().setType(mat.get(l20));
										l21.getBlock().setType(mat.get(l21));
										l22.getBlock().setType(mat.get(l22));
										l23.getBlock().setType(mat.get(l23));
										l24.getBlock().setType(mat.get(l24));
										l25.getBlock().setType(mat.get(l25));
										l26.getBlock().setType(mat.get(l26));
										l27.getBlock().setType(mat.get(l27));
										l28.getBlock().setType(mat.get(l28));
										l29.getBlock().setType(mat.get(l29));
										l30.getBlock().setType(mat.get(l30));
										l31.getBlock().setType(mat.get(l31));
										l32.getBlock().setType(mat.get(l32));
										l33.getBlock().setType(mat.get(l33));
										l34.getBlock().setType(mat.get(l34));
										l35.getBlock().setType(mat.get(l35));
										l36.getBlock().setType(mat.get(l36));
										
										l1.getBlock().setData(dat.get(l1));
										l2.getBlock().setData(dat.get(l2));
										l3.getBlock().setData(dat.get(l3));
										l4.getBlock().setData(dat.get(l4));
										l5.getBlock().setData(dat.get(l5));
										l6.getBlock().setData(dat.get(l6));
										l7.getBlock().setData(dat.get(l7));
										l8.getBlock().setData(dat.get(l8));
										l9.getBlock().setData(dat.get(l9));
										l10.getBlock().setData(dat.get(l10));
										l11.getBlock().setData(dat.get(l11));
										l12.getBlock().setData(dat.get(l12));
										l13.getBlock().setData(dat.get(l13));
										l14.getBlock().setData(dat.get(l14));
										l15.getBlock().setData(dat.get(l15));
										l16.getBlock().setData(dat.get(l16));
										l17.getBlock().setData(dat.get(l17));
										l18.getBlock().setData(dat.get(l18));
										l19.getBlock().setData(dat.get(l19));
										l20.getBlock().setData(dat.get(l20));
										l21.getBlock().setData(dat.get(l21));
										l22.getBlock().setData(dat.get(l22));
										l23.getBlock().setData(dat.get(l23));
										l24.getBlock().setData(dat.get(l24));
										l25.getBlock().setData(dat.get(l25));
										l26.getBlock().setData(dat.get(l26));
										l27.getBlock().setData(dat.get(l27));
										l28.getBlock().setData(dat.get(l28));
										l29.getBlock().setData(dat.get(l29));
										l30.getBlock().setData(dat.get(l30));
										l31.getBlock().setData(dat.get(l31));
										l32.getBlock().setData(dat.get(l32));
										l33.getBlock().setData(dat.get(l33));
										l34.getBlock().setData(dat.get(l34));
										l35.getBlock().setData(dat.get(l35));
										l36.getBlock().setData(dat.get(l36));
										
										PlayerListener.prot.remove(l1);
										PlayerListener.prot.remove(l2);
										PlayerListener.prot.remove(l3);
										PlayerListener.prot.remove(l4);
										PlayerListener.prot.remove(l5);
										PlayerListener.prot.remove(l6);
										PlayerListener.prot.remove(l7);
										PlayerListener.prot.remove(l8);
										PlayerListener.prot.remove(l9);
										PlayerListener.prot.remove(l10);
										PlayerListener.prot.remove(l11);
										PlayerListener.prot.remove(l12);
										PlayerListener.prot.remove(l13);
										PlayerListener.prot.remove(l14);
										PlayerListener.prot.remove(l15);
										PlayerListener.prot.remove(l16);
										PlayerListener.prot.remove(l17);
										PlayerListener.prot.remove(l18);
										PlayerListener.prot.remove(l19);
										PlayerListener.prot.remove(l20);
										PlayerListener.prot.remove(l21);
										PlayerListener.prot.remove(l22);
										PlayerListener.prot.remove(l23);
										PlayerListener.prot.remove(l24);
										PlayerListener.prot.remove(l25);
										PlayerListener.prot.remove(l26);
										PlayerListener.prot.remove(l27);
										PlayerListener.prot.remove(l28);
										PlayerListener.prot.remove(l29);
										PlayerListener.prot.remove(l30);
										PlayerListener.prot.remove(l31);
										PlayerListener.prot.remove(l32);
										PlayerListener.prot.remove(l33);
										PlayerListener.prot.remove(l34);
										PlayerListener.prot.remove(l35);
										PlayerListener.prot.remove(l36);
									}
								}.runTaskLater(Main.getPlugin(), 140);
							}
						}
					}
					new BukkitRunnable(){
						public void run(){
							cd.remove(p.getName());
						}
					}.runTaskLater(Main.getPlugin(), 900);
				}
			}
		}
	}
}