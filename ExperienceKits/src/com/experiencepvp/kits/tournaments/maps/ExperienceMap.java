package com.experiencepvp.kits.tournaments.maps;


import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.tournaments.TourneyUtil;

public enum ExperienceMap {
	
	GOLDMINE(1, "Gold Mine", TourneyUtil.getLocation(1), TourneyUtil.getMaxPlayers(1)), //check
	SYPTOWNVILLAGE(2, "Syptown Village", TourneyUtil.getLocation(2), TourneyUtil.getMaxPlayers(2)), // check
	WARLOCK(3, "Warlock", TourneyUtil.getLocation(3), TourneyUtil.getMaxPlayers(3)), //check
	OMAHABEACH(4, "Omaha Beach", TourneyUtil.getLocation(4), TourneyUtil.getMaxPlayers(4)), //check
	ADRENALINE(5, "Adrenaline", TourneyUtil.getLocation(5), TourneyUtil.getMaxPlayers(5)),
	ICEARENA(6, "Ice Arena", TourneyUtil.getLocation(6), TourneyUtil.getMaxPlayers(6)),
	VIKING(7, "Viking", TourneyUtil.getLocation(7), TourneyUtil.getMaxPlayers(7)), 
	HOUSE(8, "House", TourneyUtil.getLocation(8), TourneyUtil.getMaxPlayers(8)), 
	YACHT(9, "Yacht", TourneyUtil.getLocation(9), TourneyUtil.getMaxPlayers(9)),
	FALLENVILLAGE(10, "Fallen Village", TourneyUtil.getLocation(10), TourneyUtil.getMaxPlayers(10)),
	MEDIEVAL(11, "Medieval", TourneyUtil.getLocation(11), TourneyUtil.getMaxPlayers(11))
	; 
	
	public static SettingsManager settings = SettingsManager.getInstance();
	
	private String name;
	private int id;
	private Location loc;
	private int maxplayers;
	
	private ExperienceMap(int id, String name, Location loc, int maxplayers) {
		this.id = id;
		this.name = name;
		this.loc = loc;
		this.maxplayers = maxplayers;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Location getSpawnpoint(){
		return TourneyUtil.getLocation(id);
	}
	
	public void setSpawnpoint(Location loc) {
		TourneyUtil.setLocation(id, loc);
	}
	
	public int getMaxPlayers() {
		return maxplayers;
	}
	
	public void setMaxPlayers(int max) {
		TourneyUtil.setMaxPlayers(id, max);
	}
	
	public void startTimer() {
		TourneyUtil.startTimer(this);
	}
	
	public int getId(){
		return this.id;
	}
	
	public static ExperienceMap getMapById(int id) {
		for(ExperienceMap map : ExperienceMap.values()){
			if(map.getId() == id){
				return map;
			}
		}
		return null;
	}
}




















