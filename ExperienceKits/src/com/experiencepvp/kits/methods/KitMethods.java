package com.experiencepvp.kits.methods;

import com.experiencepvp.kits.SettingsManager;
import com.experiencepvp.kits.utils.KitType;

public class KitMethods {
	
	static SettingsManager settings = SettingsManager.getInstance();

	public static boolean isFreeKit(KitType kit) {
		String s = settings.getConfig().getString("FreeKit") != null ? settings.getConfig().getString("FreeKit") : "";
		return s.contains(kit.name());
	}
	
	public static void addFreeKit(KitType kit) {
		String s = settings.getConfig().getString("FreeKit") != null ? settings.getConfig().getString("FreeKit") : "";
		settings.getConfig().set("FreeKit", s + "," + kit.name());
		settings.saveConfig();
	}
	
	public static void setFreeKitDay(boolean what) {
		SettingsManager.getInstance().getConfig().set("freekitday", what);
	}
	
	public static boolean isFreeKitDay() {
		return SettingsManager.getInstance().getConfig().getBoolean("freekitday");
	}
	
	public static void clearFreeKits() {
		settings.getConfig().set("FreeKit", "");
		settings.saveConfig();
	}
	
	public static void removeFreeKit(KitType kit) {
		String s = settings.getConfig().getString("FreeKit") != null ? settings.getConfig().getString("FreeKit") : "";
		if (s.contains(kit.name())){
			s.replace("," + kit.name(), "");
		}
		settings.getConfig().set("FreeKit", s);
		settings.saveConfig();
	}
}
