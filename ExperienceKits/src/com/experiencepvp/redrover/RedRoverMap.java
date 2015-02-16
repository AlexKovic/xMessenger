package com.experiencepvp.redrover;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public enum RedRoverMap {

	CASTLE(1, "Castle", RedRoverItem.castle(), RedRoverUtil.getStartLocation(1), RedRoverUtil.getEndLocation(1), RedRoverUtil.getTagLocation(1), RedRoverUtil.getMaxPlayers(1));
	
	private String name;
	private int id;
	private ItemStack item;
	private Location start;
	private Location end;
	private Location tag;
	private int maxplayers;
	
	private RedRoverMap(int id, String name, ItemStack item, Location start, Location end, Location tag, int maxplayers) {
		this.id = id;
		this.name = name;
		this.item = item;
		this.start = start;
		this.end = end;
		this.tag = tag;
		this.maxplayers = maxplayers;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public ItemStack getItem() {
		return item;
	}
	
	public Location getStartLoc() {
		return start;
	}
	
	public Location getEndLoc() {
		return end;
	}
	
	public Location getTagLocation() {
		return tag;
	}
	
	public int getMaxPlayers() {
		return maxplayers;
	}
	
	public void setStartLoc(Location loc) {
		RedRoverUtil.setStartLocation(id, loc);
	}
	
	public void setEndLoc(Location loc) {
		RedRoverUtil.setEndLocation(id, loc);
	}
	
	public void setTagLocation(Location loc) {
		RedRoverUtil.setTagLocation(id, loc);
	}
	
	public static RedRoverMap getMapById(int id) {
		for (RedRoverMap m :RedRoverMap.values()) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}
}
