package com.experiencepvp.oneversusone;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public enum Maps {

	CASTLE("Castle", 1, OneVOneUtil.getLocation1(1), OneVOneUtil.getLocation2(1), OneVOneUtil.getMapIcon(1));
	
	private String name;
	private int id;
	private Location loc1;
	private Location loc2;
	private ItemStack mapicon;
	
	private Maps(String name, int id, Location loc1, Location loc2, ItemStack mapicon) {
		this.name = name;
		this.id = id;
		this.loc1 = loc1;
		this.loc2 = loc2;
		this.mapicon = mapicon;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public Location getLoc1() {
		return loc1;
	}
	
	public Location getLoc2() {
		return loc2;
	}
	
	public ItemStack getMapIcon(){
		return mapicon;
	}
}
