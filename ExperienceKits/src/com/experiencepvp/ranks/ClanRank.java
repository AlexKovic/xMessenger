package com.experiencepvp.ranks;

import org.bukkit.ChatColor;

public enum ClanRank {
	
	COAL(2, "Coal", 1000, ChatColor.BLACK, 500),
	IRON(3, "Iron", 2500, ChatColor.WHITE, 500),
	REDSTONE(4, "Redstone", 5000, ChatColor.DARK_RED, 500),
	LAPIS(5, "Lapis", 10000, ChatColor.DARK_BLUE, 1000),
	GOLD(6, "Gold", 15000, ChatColor.GOLD, 1000),
	EMERALD(7, "Emerald", 20000, ChatColor.GREEN, 1000),
	DIAMOND(8, "Diamond", 30000, ChatColor.AQUA, 1500),
	PLATINUM(9, "Platinum", 40000, ChatColor.LIGHT_PURPLE, 1500),
	QUARTZ(10, "Quartz", 50000, ChatColor.BLUE, 1500),
	;
	
	private String name;
	private int id;
	private int minkills;
	private ChatColor color;
	private int coins;
	
	private ClanRank(int id, String name, int minkills, ChatColor color, int coins) {
		this.id = id;
		this.name = name;
		this.minkills = minkills;
		this.color = color;
		this.coins = coins;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return id;
	}
	
	public int getMinKills() {
		return minkills;
	}
	
	public ChatColor getColor() {
		return color;
	}
	
	public int getCoins() {
		return coins;
	}
}