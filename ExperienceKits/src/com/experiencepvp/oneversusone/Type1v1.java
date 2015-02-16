package com.experiencepvp.oneversusone;

import org.bukkit.inventory.ItemStack;
import com.experiencepvp.kits.SettingsManager;

public enum Type1v1 {
	
	EHG(1, "♦ EHG 1v1 ♦", OneVOneUtil.getIcon(1)),
	KIT(2, "♦ Kit 1v1 ♦", OneVOneUtil.getIcon(2)),
	HARDCORE(3, "♦ Hardcore 1v1 ♦", OneVOneUtil.getIcon(3)),
	NORMALREFS(4, "♦ Normal 1v1 (Refills) ♦", OneVOneUtil.getIcon(4)),
	NORMALNOREFS(5, "♦ Normal 1v1 (No Refills) ♦", OneVOneUtil.getIcon(5))
	; 
	
	public static SettingsManager settings = SettingsManager.getInstance();
	
	private int id;
	private String name;
	private ItemStack icon; 
	
	private Type1v1(int id, String name, ItemStack icon) {
		this.id = id;
		this.name = name;
		this.icon = icon;
	}
	
	public int getId(){
		return this.id;
	}
	
	public ItemStack getIcon(){
		return this.icon;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Type1v1 getTypeByName(String s){
		
		for(Type1v1 t : Type1v1.values()){
			if(t.getName().equalsIgnoreCase(s)){
				return t;
			}
		}
		
		return null;		
	}
	
}