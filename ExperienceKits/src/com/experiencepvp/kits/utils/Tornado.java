package com.experiencepvp.kits.utils;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.experiencepvp.kits.listeners.PlayerListener;

public class Tornado {

	public static void spawnTornado(
	        final JavaPlugin plugin,
	        final Location  location,
	        final Material  material,
	        final byte      data,
	        final Vector    direction,
	        final double    speed,
	        final int        amount_of_blocks,
	        final long      time,
	        final boolean    spew,
	        final boolean    explode,
	        final Entity owner
	) {
	   
		final HashMap<Location, Material> mat = new HashMap<Location, Material>();
		final HashMap<Location, Byte> dat = new HashMap<Location, Byte>();
		
	    class VortexBlock {
	 
	        private Entity entity;
	       
	        public boolean removable = true;
	 
	        private float ticker_vertical = 0.0f;
	        private float ticker_horisontal = (float) (Math.random() * 2 * Math.PI);
	 
	        @SuppressWarnings("deprecation")
	        public VortexBlock(Location l, Material m, byte d) {
	 
	            if (l.getBlock().getType() != Material.AIR && l.getBlock().getType() != Material.STONE && l.getBlock().getType() != Material.BRICK && l.getBlock().getType() != Material.GLASS && l.getBlock().getType() != Material.STAINED_CLAY && l.getBlock().getType() != Material.getMaterial(44) && l.getBlock().getType() != Material.QUARTZ_STAIRS && l.getBlock().getType() != Material.BRICK_STAIRS && l.getBlock().getType() != Material.GLOWSTONE && l.getBlock().getType() != Material.REDSTONE_LAMP_OFF && l.getBlock().getType() != Material.REDSTONE_TORCH_ON && l.getBlock().getType() != Material.COBBLE_WALL && l.getBlock().getType() != Material.FENCE && l.getBlock().getType() != Material.SKULL && l.getBlock().getType() != Material.GRAVEL && l.getBlock().getType() != Material.CHEST) {
	 
	                Block b = l.getBlock();
	                FallingBlock fb = l.getWorld().spawnFallingBlock(l, b.getType(), b.getData());
	                fb.setDropItem(false);
	                entity = fb;
	                
	                if (b.getType() != Material.WATER && b.getType() != Material.LAVA){
	                	mat.put(b.getLocation(), b.getType());
	                	dat.put(b.getLocation(), b.getData());
	                    b.setType(Material.AIR);
	                    PlayerListener.prot.add(b.getLocation());
	                }
	               
	                removable = !spew;
	            }
	            else {
	            	FallingBlock fb = l.getWorld().spawnFallingBlock(l, m, d);
	            	fb.setDropItem(false);
	                entity = fb;
	                removable = !explode;
	            }
	           
	            addMetadata();
	        }
	       
	        public VortexBlock(Entity e) {
	            entity    = e;
	            removable = false;
	            addMetadata();
	        }
	       
	        private void addMetadata() {
	            entity.setMetadata("vortex", new FixedMetadataValue(plugin, "protected"));
	        }
	       
	        public void remove() {
	            if(removable) {
	                entity.remove();
	            }
	            entity.removeMetadata("vortex", plugin);
	        }
	 
	        @SuppressWarnings("deprecation")
	        public HashSet<VortexBlock> tick() {
	           
	            double radius    = Math.sin(verticalTicker()) * 2;
	            float  horisontal = horisontalTicker();
	           
	            Vector v = new Vector(radius * Math.cos(horisontal), 0.5D, radius * Math.sin(horisontal));
	           
	            HashSet<VortexBlock> new_blocks = new HashSet<VortexBlock>();
	           
	            // Pick up blocks
	            Block b = entity.getLocation().add(v.clone().normalize()).getBlock();
	            if(b.getType() != Material.AIR) {
	                new_blocks.add(new VortexBlock(b.getLocation(), b.getType(), b.getData()));
	            }
	           
	            // Pick up other entities
	            List<Entity> entities = entity.getNearbyEntities(1.0D, 1.0D, 1.0D);
	            for(Entity e : entities) {
	                if(!e.hasMetadata("vortex") && e != owner) {
	                    new_blocks.add(new VortexBlock(e));
	                }
	            }
	           
	            setVelocity(v);
	           
	            return new_blocks;
	        }
	 
	        private void setVelocity(Vector v) {
	            entity.setVelocity(v);
	        }
	 
	        private float verticalTicker() {
	            if (ticker_vertical < 1.0f) {
	                ticker_vertical += 0.05f;
	            }
	            return ticker_vertical;
	        }
	 
	        private float horisontalTicker() {
//	                ticker_horisontal = (float) ((ticker_horisontal + 0.8f) % 2*Math.PI);
	            return (ticker_horisontal += 0.8f);
	        }
	    }
	   
	    // Modify the direction vector using the speed argument.
	    if (direction != null) {
	        direction.normalize().multiply(speed);
	    }
	   
	    // This set will contain every block created to make sure the metadata for each and everyone is removed.
	    final HashSet<VortexBlock> clear = new HashSet<VortexBlock>();
	   
	    final int id = new BukkitRunnable() {
	 
	        private ArrayDeque<VortexBlock> blocks = new ArrayDeque<VortexBlock>();
	 
	        public void run() {
	           
	            if (direction != null) {
	                location.add(direction);
	            }
	 
	            // Spawns 10 blocks at the time.
	            for (int i = 0; i < 10; i++) {
	                checkListSize();
	                VortexBlock vb = new VortexBlock(location, material, data);
	                blocks.add(vb);
	                clear.add(vb);
	            }
	           
	            // Make all blocks in the list spin, and pick up any blocks that get in the way.
	            ArrayDeque<VortexBlock> que = new ArrayDeque<VortexBlock>();
	 
	            for (VortexBlock vb : blocks) {
	                HashSet<VortexBlock> new_blocks = vb.tick();
	                for(VortexBlock temp : new_blocks) {
	                    que.add(temp);
	                }
	            }
	           
	            // Add the new blocks
	            for(VortexBlock vb : que) {
	                checkListSize();
	                blocks.add(vb);
	                clear.add(vb);
	            }
	        }
	       
	        // Removes the oldest block if the list goes over the limit.
	        private void checkListSize() {
	            while(blocks.size() >= amount_of_blocks) {
	                VortexBlock vb = blocks.getFirst();
	                vb.remove();
	                blocks.remove(vb);
	                clear.remove(vb);
	            }
	        }
	    }.runTaskTimer(plugin, 5L, 5L).getTaskId();
	 
	    // Stop the "tornado" after the given time.
	    new BukkitRunnable() {
	        public void run() {
	            for(VortexBlock vb : clear) {
	                vb.remove();
	            }
	            plugin.getServer().getScheduler().cancelTask(id);
	        }
	    }.runTaskLater(plugin, time);
	    
	    new BukkitRunnable() {
	        @SuppressWarnings("deprecation")
			public void run() {
	            for(Location l : mat.keySet()){
	            	l.getBlock().setType(mat.get(l));
	            	l.getBlock().setData(dat.get(l));
	            	PlayerListener.prot.remove(l);
	            }
	        }
	    }.runTaskLater(plugin, time + 2);
	}
	
}
