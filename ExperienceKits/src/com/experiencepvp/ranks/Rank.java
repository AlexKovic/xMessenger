package com.experiencepvp.ranks;

public enum Rank {
	
	AQUA(2, "Aqua", 250, "&0◆", 500),
	HYRO(3, "Hyro", 700, "&fℭ", 500),
	HERUS(4, "Herus", 1000, "&c❀", 500),
	DOMINATOR(5, "Dominator", 1400, "&1❂", 1000),
	DRYGUN(6, "Drygun", 2000, "&6☀", 1000),
	LOTIUM(7, "Lotium", 2750, "&a❋", 1000),
	NYTRO(8, "Nytro", 3750, "&3♗", 1500),
	TERRA(9, "Terra", 5000, "&b✯", 1500),
	ZEATH(10, "Zeath", 6500, "&8✇", 1500),
	;
	
	private String name;
	private int id;
	private int minkills;
	private String symbol;
	private int coins;
	
	private Rank(int id, String name, int minkills, String symbol, int coins) {
		this.id = id;
		this.name = name;
		this.minkills = minkills;
		this.symbol = symbol;
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
	
	public String getSymbol() {
		return symbol;
	}
	
	public int getCoins() {
		return coins;
	}
}