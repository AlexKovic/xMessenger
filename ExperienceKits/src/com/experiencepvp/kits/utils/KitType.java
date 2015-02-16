package com.experiencepvp.kits.utils;

import java.util.Random;

public enum KitType {
	
	  PVP("PvP", "experiencepvp.kit.pvp", Kits.pvp, true, 0), FEATHER("Feather", "experiencepvp.kit.feather", Kits.feather, true, 0), GAMBLER("Gambler", "experiencepvp.kit.gambler", Kits.gambler, true, 0), FISHERMAN("Fisherman", "experiencepvp.kit.fisherman", Kits.fisherman, true, 0), GRANDPA("Grandpa", "experiencepvp.kit.grandpa", Kits.grandpa, true, 0), ARCHER("Archer", "experiencepvp.kit.archer", Kits.archer, false, 1250)
	,  ENDERMAN("Enderman", "experiencepvp.kit.enderman", Kits.enderman, false, 1250), SWITCHER("Switcher", "experiencepvp.kit.switcher", Kits.switcher, false, 1250)
	, KANGAROO("Kangaroo", "experiencepvp.kit.kangaroo", Kits.kangaroo, false, 2000), THOR("Thor", "experiencepvp.kit.thor", Kits.thor, false, 1500), VIPER("Viper", "experiencepvp.kit.viper", Kits.viper, false, 2000), PHANTOM("Phantom", "experiencepvp.kit.phantom", Kits.phantom, false, 1500), SNAIL("Snail", "experiencepvp.kit.snail", Kits.snail, false, 2000)
	, NINJA("Ninja", "experiencepvp.kit.ninja", Kits.ninja, false, 1500), REAPER("Reaper", "experiencepvp.kit.reaper", Kits.reaper, false, 1250), HULK("Hulk", "experiencepvp.kit.hulk", Kits.hulk, false, 1500),  TURTLE("Turtle", "experiencepvp.kit.turtle", Kits.turtle, false, 1000), GLADIATOR("Gladiator", "experiencepvp.kit.gladiator", Kits.gladiator, false, 1500)
	, STOMPER("Stomper", "experiencepvp.kit.stomper", Kits.stomper, false, 2000), SAMURAI("Samurai", "experiencepvp.kit.samurai", Kits.samurai, false, 1750)
	, GRAPPLER("Grappler", "experiencepvp.kit.grappler", Kits.grappler, false, 1500), JELLYFISH("Jellyfish", "experiencepvp.kit.jellyfish", Kits.jellyfish, false, 1250) 
	, SPECIALIST("Specialist", "experiencepvp.kit.specialist", Kits.specialist, false, 2000), POSEIDON("Poseidon", "experiencepvp.kit.poseidon", Kits.poseidon, false, 1250)
	, ANCHOR("Anchor", "experiencepvp.kit.anchor", Kits.anchor, false, 1500), ROGUE("Rogue", "experiencepvp.kit.rogue", Kits.rogue, false, 1250), SONIC("Sonic", "experiencepvp.kit.sonic", Kits.sonic, false, 1250)
	, FLASH("Flash", "experiencepvp.kit.flash", Kits.flash, false, 1500), TANK("Tank", "experiencepvp.kit.tank", Kits.tank, false, 1500), ANTISTOMPER("AntiStomper", "experiencepvp.kit.antistomper", Kits.antistomper, false, 1750), ELEMENTAL("Elemental", "experiencepvp.kit.elemental", Kits.elemental, false, 999999999), GOD("God", "experiencepvp.kit.god", Kits.god, false, 999999999), TURRET("Turret", "experiencepvp.kit.turret", Kits.turret, false, 999999999), CATCHER("Catcher", "experiencepvp.kit.catcher", Kits.catcher, false, 999999999)
	;
	
	private String perm;
	private String name;
	private KitUtil util;
	private boolean free;
	private int price;
	
	private KitType(String name, String perm, KitUtil util, boolean free, int price) {
		this.name = name;
		this.perm = perm;
		this.util = util;
		this.free = free;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPerm() {
		return this.perm;
	}
	
	public KitUtil getUtil() {
		return this.util;
	}
	
    public static KitType getRandomKit() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
    
    public boolean isFree(){
    	return free;
    }
    
    public int getPrice(){
    	return price;
    }
}
