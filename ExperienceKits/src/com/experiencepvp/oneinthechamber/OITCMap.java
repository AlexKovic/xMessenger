package com.experiencepvp.oneinthechamber;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.experiencepvp.kits.SettingsManager;


public enum OITCMap {

	CLAY_FOREST(1, "Clay Forest", OITCUtil.getLocation(1), OITCUtil.getMaxPlayers(1)),
	CASTLE(1, "Castle", OITCUtil.getLocation(2), OITCUtil.getMaxPlayers(2))
	;
		
	public static SettingsManager settings = SettingsManager.getInstance();
	
	private String name;
	private int id;
	private Location loc;
	private int maxplayers;
		
	private OITCMap(int id, String name, Location loc, int maxplayers) {
		this.id = id;
		this.name = name;
		this.loc = loc;
		this.maxplayers = maxplayers;
	}
		
	public String getName() {
		return name;
	}
		
	public Location getSpawnpoint(){
		return OITCUtil.getLocation(id);
	}
		
	public void setSpawnpoint(Location loc) {
		OITCUtil.setLocation(id, loc);
	}
		
	public int getMaxPlayers() {
		return maxplayers;
	}
		
	public void setMaxPlayers(int max) {
		OITCUtil.setMaxPlayers(id, max);
	}
		
	public void startTimer() {
		OITCUtil.startTimer(this);
	}
		
	public int getId(){
		return id;
	}
		
	public static OITCMap getMapById(int id) {
		for(OITCMap map : OITCMap.values()){
			if(map.getId() == id){
				return map;
			}
		}
		return null;
	}
}