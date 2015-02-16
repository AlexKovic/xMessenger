package com.experiencepvp.combo;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.experiencepvp.kits.SettingsManager;

public enum ComboMap {

	  NETHER(1, "Nether", ComboUtil.getLocation(1), ComboUtil.getMaxPlayers(1))
	, FOREST(2, "Forest", ComboUtil.getLocation(2), ComboUtil.getMaxPlayers(2));
	
	
	public static SettingsManager settings = SettingsManager.getInstance();
		
	private String name;
	private int id;
	private Location loc;
	private int maxplayers;
		
	private ComboMap(int id, String name, Location loc, int maxplayers) {
		this.id = id;
		this.name = name;
		this.loc = loc;
		this.maxplayers = maxplayers;
	}
		
	public String getName() {
		return this.name;
	}
		
	public Location getSpawnpoint(){
		return ComboUtil.getLocation(id);
	}
		
	public void setSpawnpoint(Location loc) {
		ComboUtil.setLocation(id, loc);
	}
		
	public int getMaxPlayers() {
		return maxplayers;
	}
		
	public void setMaxPlayers(int max) {
		ComboUtil.setMaxPlayers(id, max);
	}
		
	public void startTimer() {
		ComboUtil.startTimer(this);
	}
		
	public int getId(){
		return this.id;
	}
		
	public static ComboMap getMapById(int id) {
		for(ComboMap map : ComboMap.values()){
			if(map.getId() == id){
				return map;
			}
		}
		return null;
	}
}
