package com.experiencepvp.lava;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.experiencepvp.kits.SettingsManager;

public enum LavaMap {

	DUNGEON(1, "Dungeon", LavaUtil.getLocation(1), LavaUtil.getMaxPlayers(1)),
	NETHER(2, "Nether", LavaUtil.getLocation(2), LavaUtil.getMaxPlayers(2)),
	SNOW(3, "Snow", LavaUtil.getLocation(3), LavaUtil.getMaxPlayers(3)),
	MUSHROOM(4, "Mushroom", LavaUtil.getLocation(4), LavaUtil.getMaxPlayers(4)),
	PLAIN(5, "Plain", LavaUtil.getLocation(5), LavaUtil.getMaxPlayers(5))
	;
		
	public static SettingsManager settings = SettingsManager.getInstance();
	
	private String name;
	private int id;
	private Location loc;
	private int maxplayers;
		
	private LavaMap(int id, String name, Location loc, int maxplayers) {
		this.id = id;
		this.name = name;
		this.loc = loc;
		this.maxplayers = maxplayers;
	}
		
	public String getName() {
		return name;
	}
		
	public Location getSpawnpoint(){
		return LavaUtil.getLocation(id);
	}
		
	public void setSpawnpoint(Location loc) {
		LavaUtil.setLocation(id, loc);
	}
		
	public int getMaxPlayers() {
		return maxplayers;
	}
		
	public void setMaxPlayers(int max) {
		LavaUtil.setMaxPlayers(id, max);
	}
		
	public void startTimer() {
		LavaUtil.startTimer(this);
	}
		
	public int getId(){
		return id;
	}
		
	public static LavaMap getMapById(int id) {
		for(LavaMap map : LavaMap.values()){
			if(map.getId() == id){
				return map;
			}
		}
		return null;
	}
}




















