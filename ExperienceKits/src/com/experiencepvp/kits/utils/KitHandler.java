package com.experiencepvp.kits.utils;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class KitHandler {
	
	private static HashMap<String, KitType> kits = new HashMap<String, KitType>();
	private static HashMap<String, Integer> kitlvl = new HashMap<String, Integer>();

	public static HashMap<String, KitType> getKits() {
		return kits;
	}

	public static boolean hasKit(String name) {
		return kits.containsKey(name);
	}

	public static KitType getKit(String name) {
		if (!hasKit(name)) {
			return null;
		}

		return (KitType) kits.get(name);
	}
	
	public static int getLevel(String name) {
		if (!hasKit(name)) {
			return 0;
		}

		return kitlvl.get(name);
	}
	
	public static boolean hasKit(String name, KitType type) {
		return kits.get(name) == type;
	}

	public static void setKit(Player player, KitType type) {
		kits.put(player.getName(), type);
	}
	
	public static void setLevel(Player player, int i) {
		kitlvl.put(player.getName(), i);
	}

	public static void delKit(Player player) {
		kits.remove(player.getName());
		kitlvl.remove(player.getName());
	}
}
