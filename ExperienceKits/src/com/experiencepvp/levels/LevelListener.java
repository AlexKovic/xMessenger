package com.experiencepvp.levels;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.experiencepvp.coins.CoinsUtil;
import com.experiencepvp.kits.Main;
import com.experiencepvp.kits.utils.KitType;
import com.experiencepvp.ranks.RankUI;
import com.experiencepvp.scoreboard.ScoreboardMain;

public class LevelListener implements Listener {
	
	public static HashMap<String, KitType> choosekit = new HashMap<String, KitType>();
	public static HashMap<String, Integer> chooselvl = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chooseprice = new HashMap<String, Integer>();
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getTitle().equalsIgnoreCase(LevelUI.getBuyKitsGUI(p, 1).getTitle())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.IRON_PLATE){
				p.closeInventory();
				p.openInventory(LevelUI.getBuyKitsGUI(p, 2));
			}else if(e.getCurrentItem().getType() == Material.SKULL_ITEM){
				p.closeInventory();
				p.openInventory(LevelUI.getOwnKitsToUpgrade(p, 1));
			}else if(e.getCurrentItem().getType() == Material.REDSTONE){
				p.closeInventory();
				p.openInventory(LevelUI.getChooseBuyOrUpGUI(p));
			}else{
				if(!e.getInventory().getItem(e.getRawSlot()).hasItemMeta()
						|| e.getInventory().getItem(e.getRawSlot()).getItemMeta()
								.getDisplayName().equalsIgnoreCase("")
						|| e.getInventory().getItem(e.getRawSlot()).getItemMeta()
								.getDisplayName().length() < 3)
					return;
				String cmd = e.getInventory().getItem(e.getRawSlot()).getItemMeta()
						.getDisplayName().substring(2);
				for(KitType kit : KitType.values()){
					if(kit.getName().equalsIgnoreCase(cmd)){if(LevelUtil.getLevel(p, kit) == 0){
						if(!kit.isFree()){
							if(CoinsUtil.getCoins(p) >= kit.getPrice() || CoinsUtil.getCoins(p) == kit.getPrice()){
								p.closeInventory();
								choosekit.put(p.getName(), kit);
								chooselvl.put(p.getName(), 1);
								chooseprice.put(p.getName(), kit.getPrice());
								p.openInventory(LevelUI.getChooseBuyGUI(p));
							}else{
								p.sendMessage(Main.pref + ChatColor.RED + "You only have " + ChatColor.GOLD + CoinsUtil.getCoins(p) + "$" + ChatColor.RED + " while this kit costs " + ChatColor.GOLD + kit.getPrice() + "$" + ChatColor.RED + "!");
							}
						}else{
							p.sendMessage(Main.pref + ChatColor.RED + "You can't buy a free kit!");
						}
					}else if(LevelUtil.getLevel(p, kit) > 0){
						p.sendMessage(Main.pref + ChatColor.RED + "You already upgraded your " + ChatColor.GOLD + kit.getName() + ChatColor.RED + " kit to level " + ChatColor.GOLD + "1" + ChatColor.RED + "!");
					}
					}
				}
			}
		}else if(e.getInventory().getTitle().equalsIgnoreCase(LevelUI.getBuyKitsGUI(p, 2).getTitle())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.IRON_PLATE){
				p.closeInventory();
				p.openInventory(LevelUI.getBuyKitsGUI(p, 1));
			}else if(e.getCurrentItem().getType() == Material.REDSTONE){
				p.closeInventory();
				p.openInventory(LevelUI.getChooseBuyOrUpGUI(p));
			}else if(e.getCurrentItem().getType() == Material.SKULL_ITEM){
				p.closeInventory();
				p.openInventory(LevelUI.getOwnKitsToUpgrade(p, 1));
			}else{
				if(!e.getInventory().getItem(e.getRawSlot()).hasItemMeta()
						|| e.getInventory().getItem(e.getRawSlot()).getItemMeta()
								.getDisplayName().equalsIgnoreCase("")
						|| e.getInventory().getItem(e.getRawSlot()).getItemMeta()
								.getDisplayName().length() < 3)
					return;
				String cmd = e.getInventory().getItem(e.getRawSlot()).getItemMeta()
						.getDisplayName().substring(2);
				for(KitType kit : KitType.values()){
					if(kit.getName().equalsIgnoreCase(cmd)){if(LevelUtil.getLevel(p, kit) == 0){
						if(!kit.isFree()){
							if(CoinsUtil.getCoins(p) >= kit.getPrice()){
								p.closeInventory();
								choosekit.put(p.getName(), kit);
								chooselvl.put(p.getName(), 1);
								chooseprice.put(p.getName(), kit.getPrice());
								p.openInventory(LevelUI.getChooseBuyGUI(p));
							}else{
								p.sendMessage(Main.pref + ChatColor.RED + "You only have " + ChatColor.GOLD + CoinsUtil.getCoins(p) + "$" + ChatColor.RED + " while this kit costs " + ChatColor.GOLD + kit.getPrice() + "$" + ChatColor.RED + "!");
							}
						}else{
							p.sendMessage(Main.pref + ChatColor.RED + "You can't buy a free kit!");
						}
					}else if(LevelUtil.getLevel(p, kit) > 0){
						p.sendMessage(Main.pref + ChatColor.RED + "You already upgraded your " + ChatColor.GOLD + kit.getName() + ChatColor.RED + " kit to level " + ChatColor.GOLD + "1" + ChatColor.RED + "!");
					}
					}
				}
			}
		}else if(e.getInventory().getTitle().equalsIgnoreCase(LevelUI.getOwnKitsGUI(p, 1).getTitle())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.IRON_PLATE){
				p.closeInventory();
				p.openInventory(LevelUI.getOwnKitsGUI(p, 2));
			}else{
				if(!e.getInventory().getItem(e.getSlot()).hasItemMeta()
						|| e.getInventory().getItem(e.getSlot()).getItemMeta()
								.getDisplayName().equalsIgnoreCase("")
						|| e.getInventory().getItem(e.getSlot()).getItemMeta()
								.getDisplayName().length() < 3)
					return;
				String cmd = e.getInventory().getItem(e.getRawSlot()).getItemMeta()
						.getDisplayName().substring(2);
				for(KitType kit : KitType.values()){
					if(kit.getName().equalsIgnoreCase(cmd)){
						if(LevelUtil.getLevel(p, kit) > 0){
							p.closeInventory();
							p.performCommand(cmd.replaceAll(" ", ""));
						}else{
							p.sendMessage(Main.pref + ChatColor.RED + "You don't have this kit, buy it at the shop!");
						}
					}
				}
			}
		}else if(e.getInventory().getTitle().equalsIgnoreCase(LevelUI.getOwnKitsGUI(p, 2).getTitle())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.IRON_PLATE){
				p.closeInventory();
				p.openInventory(LevelUI.getOwnKitsGUI(p, 1));
			}else{
				if(!e.getInventory().getItem(e.getRawSlot()).hasItemMeta()
						|| e.getInventory().getItem(e.getRawSlot()).getItemMeta()
								.getDisplayName().equalsIgnoreCase("")
						|| e.getInventory().getItem(e.getRawSlot()).getItemMeta()
								.getDisplayName().length() < 3)
					return;
				String cmd = e.getInventory().getItem(e.getRawSlot()).getItemMeta()
						.getDisplayName().substring(2);
				for(KitType kit : KitType.values()){
					if(kit.getName().equalsIgnoreCase(cmd)){
						if(LevelUtil.getLevel(p, kit) > 0){
							p.closeInventory();
							p.performCommand(cmd.replaceAll(" ", ""));
						}else{
							p.sendMessage(Main.pref + ChatColor.RED + "You don't have this kit, buy it at the shop!");
						}
					}
				}
			}
		}else if(e.getInventory().getTitle().equalsIgnoreCase(LevelUI.getUpgradeInventory(p, KitType.PHANTOM).getTitle())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.REDSTONE){
				p.closeInventory();
				p.openInventory(LevelUI.getOwnKitsToUpgrade(p, 1));
			}else{
				if(!e.getInventory().getItem(e.getRawSlot()).hasItemMeta()
						|| e.getInventory().getItem(e.getRawSlot()).getItemMeta()
								.getDisplayName().equalsIgnoreCase("")
						|| e.getInventory().getItem(e.getRawSlot()).getItemMeta()
								.getDisplayName().length() < 3)
					return;
				String cmd = e.getInventory().getItem(e.getRawSlot()).getItemMeta()
						.getDisplayName().substring(4);
				for(KitType kit : KitType.values()){
					if((kit.getName() + ": Level 1").equalsIgnoreCase(cmd)){
						if(LevelUtil.getLevel(p, kit) == 0){
							if(!kit.isFree()){
								if(CoinsUtil.getCoins(p) >= kit.getPrice()){
									p.closeInventory();
									choosekit.put(p.getName(), kit);
									chooselvl.put(p.getName(), 1);
									chooseprice.put(p.getName(),  kit.getPrice());
									
									p.openInventory(LevelUI.getChooseBuyGUI(p));
								}else{
									p.sendMessage(Main.pref + ChatColor.RED + "You only have " + ChatColor.GOLD + CoinsUtil.getCoins(p) + "$" + ChatColor.RED + " while this kit costs " + ChatColor.GOLD + kit.getPrice() + "$" + ChatColor.RED + "!");
								}
							}else{
								p.sendMessage(Main.pref + ChatColor.RED + "You can't buy a free kit!");
							}
						}else if(LevelUtil.getLevel(p, kit) > 0){
							p.sendMessage(Main.pref + ChatColor.RED + "You already upgraded your " + ChatColor.GOLD + kit.getName() + ChatColor.RED + " kit to level " + ChatColor.GOLD + "1" + ChatColor.RED + "!");
						}
					}else if((kit.getName() + ": Level 2").equalsIgnoreCase(cmd)){
						if(LevelUtil.getLevel(p, kit) == 1){
							if(!kit.isFree()){
								if(CoinsUtil.getCoins(p) >= 1000){
									p.closeInventory();
									choosekit.put(p.getName(), kit);
									chooselvl.put(p.getName(), 2);
									chooseprice.put(p.getName(), (p.hasPermission("experiencepvp.rank.gold") ? 1000 - 100 : 1000)); 
									
									p.openInventory(LevelUI.getChooseBuyGUI(p));
									//LevelUtil.buyKit(p, kit, 1);
								}else{
									int price = 1000;
									p.sendMessage(Main.pref + ChatColor.RED + "You only have " + ChatColor.GOLD + CoinsUtil.getCoins(p) + "$" + ChatColor.RED + " while this upgrade costs " + ChatColor.GOLD + price + "$" + ChatColor.RED + "!");
								}
							}else{
								p.sendMessage(Main.pref + ChatColor.RED + "You can't buy a free kit!");
							}
						}else if(LevelUtil.getLevel(p, kit) > 1){
							p.sendMessage(Main.pref + ChatColor.RED + "You already upgraded your " + ChatColor.GOLD + kit.getName() + ChatColor.RED + " kit to level " + ChatColor.GOLD + "2" + ChatColor.RED + "!");
						}else if(LevelUtil.getLevel(p, kit) < 1){
							p.sendMessage(Main.pref + ChatColor.RED + "Upgrade your " + ChatColor.GOLD + kit.getName() + ChatColor.RED + " kit to level " + ChatColor.GOLD + "1" + ChatColor.RED + " first!");
						}
					}else if((kit.getName() + ": Level 3").equalsIgnoreCase(cmd)){
						if(LevelUtil.getLevel(p, kit) == 2){
							if(!kit.isFree()){
								if(CoinsUtil.getCoins(p) >= 1000){
									p.closeInventory();
									choosekit.put(p.getName(), kit);
									chooselvl.put(p.getName(), 3);
									chooseprice.put(p.getName(), (p.hasPermission("experiencepvp.rank.gold") ? 1000 - 100 : 1000)); 
									
									p.openInventory(LevelUI.getChooseBuyGUI(p));
									//LevelUtil.buyKit(p, kit, 1);
								}else{
									int price = 1000;
									p.sendMessage(Main.pref + ChatColor.RED + "You only have " + ChatColor.GOLD + CoinsUtil.getCoins(p) + "$" + ChatColor.RED + " while this upgrade costs " + ChatColor.GOLD + price + "$" + ChatColor.RED + "!");
								}
							}else{
								p.sendMessage(Main.pref + ChatColor.RED + "You can't buy a free kit!");
							}
						}else if(LevelUtil.getLevel(p, kit) > 2){
							p.sendMessage(Main.pref + ChatColor.RED + "You already upgraded your " + ChatColor.GOLD + kit.getName() + ChatColor.RED + " kit to level " + ChatColor.GOLD + "3" + ChatColor.RED + "!");
						}else if(LevelUtil.getLevel(p, kit) < 2){
							if(LevelUtil.getLevel(p, kit) == 0){
								p.sendMessage(Main.pref + ChatColor.RED + "Upgrade your " + ChatColor.GOLD + kit.getName() + ChatColor.RED + " kit to level " + ChatColor.GOLD + "1" + ChatColor.RED + " first!");
							}else if(LevelUtil.getLevel(p, kit) == 1){
								p.sendMessage(Main.pref + ChatColor.RED + "Upgrade your " + ChatColor.GOLD + kit.getName() + ChatColor.RED + " kit to level " + ChatColor.GOLD + "2" + ChatColor.RED + " first!");
							}
						}
					}else if((kit.getName() + ": Level 4").equalsIgnoreCase(cmd)){
						if(LevelUtil.getLevel(p, kit) == 3){
							if(!kit.isFree()){
								if(CoinsUtil.getCoins(p) >= 1500){
									p.closeInventory();
									choosekit.put(p.getName(), kit);
									chooselvl.put(p.getName(), 4);
									chooseprice.put(p.getName(), (p.hasPermission("experiencepvp.rank.gold") ? 1500 - 100 : 1500)); 
									
									p.openInventory(LevelUI.getChooseBuyGUI(p));
									//LevelUtil.buyKit(p, kit, 1);
								}else{
									int price = 1500;
									p.sendMessage(Main.pref + ChatColor.RED + "You only have " + ChatColor.GOLD + CoinsUtil.getCoins(p) + "$" + ChatColor.RED + " while this upgrade costs " + ChatColor.GOLD + price + "$" + ChatColor.RED + "!");
								}
							}else{
								p.sendMessage(Main.pref + ChatColor.RED + "You can't buy a free kit!");
							}
						}else if(LevelUtil.getLevel(p, kit) > 3){
							p.sendMessage(Main.pref + ChatColor.RED + "You already upgraded your " + ChatColor.GOLD + kit.getName() + ChatColor.RED + " kit to the maximum level " + ChatColor.GOLD + "(4)" + ChatColor.RED + "!");
						}else if(LevelUtil.getLevel(p, kit) < 2){
							if(LevelUtil.getLevel(p, kit) == 0){
								p.sendMessage(Main.pref + ChatColor.RED + "Upgrade your " + ChatColor.GOLD + kit.getName() + ChatColor.RED + " kit to level " + ChatColor.GOLD + "1" + ChatColor.RED + " first!");
							}else if(LevelUtil.getLevel(p, kit) == 1){
								p.sendMessage(Main.pref + ChatColor.RED + "Upgrade your " + ChatColor.GOLD + kit.getName() + ChatColor.RED + " kit to level " + ChatColor.GOLD + "2" + ChatColor.RED + " first!");
							}else if(LevelUtil.getLevel(p, kit) == 2){
								p.sendMessage(Main.pref + ChatColor.RED + "Upgrade your " + ChatColor.GOLD + kit.getName() + ChatColor.RED + " kit to level " + ChatColor.GOLD + "3" + ChatColor.RED + " first!");
							}
						}
					}
				}
			}
		}else if(e.getInventory().getTitle().equalsIgnoreCase(LevelUI.getChooseBuyOrUpGUI(p).getTitle())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.DIAMOND){
				p.closeInventory();
				p.openInventory(LevelUI.getBuyKitsGUI(p, 1));
			}else if(e.getCurrentItem().getType() == Material.EMERALD){
				p.closeInventory();
				p.openInventory(LevelUI.getOwnKitsToUpgrade(p, 1));
			}
		}else if(e.getInventory().getTitle().equalsIgnoreCase(LevelUI.getOwnKitsToUpgrade(p, 1).getTitle())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.IRON_PLATE){
				p.closeInventory();
				p.openInventory(LevelUI.getOwnKitsToUpgrade(p, 2));
			}else if(e.getCurrentItem().getType() == Material.SKULL){
				p.closeInventory();
				p.openInventory(LevelUI.getBuyKitsGUI(p, 1));
			}else if(e.getCurrentItem().getType() == Material.REDSTONE){
				p.closeInventory();
				p.openInventory(LevelUI.getChooseBuyOrUpGUI(p));
			}else{
				if(!e.getInventory().getItem(e.getRawSlot()).hasItemMeta()
						|| e.getInventory().getItem(e.getRawSlot()).getItemMeta()
								.getDisplayName().equalsIgnoreCase("")
						|| e.getInventory().getItem(e.getRawSlot()).getItemMeta()
								.getDisplayName().length() < 3)
					return;
				String cmd = e.getInventory().getItem(e.getRawSlot()).getItemMeta()
						.getDisplayName().substring(2);
				for(KitType kit : KitType.values()){
					if(kit.getName().equalsIgnoreCase(cmd)){
						p.closeInventory();
						p.openInventory(LevelUI.getUpgradeInventory(p, kit));
					}
				}
			}
		}else if(e.getInventory().getTitle().equalsIgnoreCase(LevelUI.getOwnKitsToUpgrade(p, 2).getTitle())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.IRON_PLATE){
				p.closeInventory();
				p.openInventory(LevelUI.getOwnKitsToUpgrade(p, 1));
			}else if(e.getCurrentItem().getType() == Material.SKULL){
				p.closeInventory();
				p.openInventory(LevelUI.getBuyKitsGUI(p, 1));
			}else if(e.getCurrentItem().getType() == Material.REDSTONE){
				p.closeInventory();
				p.openInventory(LevelUI.getChooseBuyOrUpGUI(p));
			}else{
				if(!e.getInventory().getItem(e.getRawSlot()).hasItemMeta()
						|| e.getInventory().getItem(e.getRawSlot()).getItemMeta()
								.getDisplayName().equalsIgnoreCase("")
						|| e.getInventory().getItem(e.getRawSlot()).getItemMeta()
								.getDisplayName().length() < 3)
					return;
				String cmd = e.getInventory().getItem(e.getRawSlot()).getItemMeta()
						.getDisplayName().substring(2);
				for(KitType kit : KitType.values()){
					if(kit.getName().equalsIgnoreCase(cmd)){
						p.closeInventory();
						p.openInventory(LevelUI.getUpgradeInventory(p, kit));
					}
				}
			}
		}else if(e.getInventory().getTitle().equalsIgnoreCase(LevelUI.getChooseBuyGUI(p).getTitle())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.GOLD_INGOT){
				p.closeInventory();//check gwn of chooselvl.get(p.getName()) >= 2) en dan weet je dat het upgrade is nee, het is hier follow mij
				LevelUtil.buyKit(p, choosekit.get(p.getName()), chooselvl.get(p.getName()));
			}else if(e.getCurrentItem().getType() == Material.REDSTONE){
				p.closeInventory();
				if(chooseprice.remove(p.getName()) == choosekit.get(p.getName()).getPrice()){
					p.openInventory(LevelUI.getBuyKitsGUI(p, 1));
				}else{
					p.openInventory(LevelUI.getUpgradeInventory(p, choosekit.get(p.getName())));					
				}
				choosekit.remove(p.getName());
				chooselvl.remove(p.getName());
				chooseprice.remove(p.getName());
			}
		}
		ScoreboardMain.updateScoreboard(p);
	}
	
}
