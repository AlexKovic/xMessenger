package com.experiencepvp.nogrow;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class NoGrow implements Listener {
	
	@EventHandler
	public void stopGrow(BlockPhysicsEvent e){
		if(e.getChangedType() == Material.CACTUS){
			e.setCancelled(true);
		}
		
		if(e.getChangedType() == Material.VINE){
			e.setCancelled(true);
		}
	}
	
}
