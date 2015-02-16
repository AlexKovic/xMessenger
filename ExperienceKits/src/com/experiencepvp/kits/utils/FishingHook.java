package com.experiencepvp.kits.utils;


import net.minecraft.server.v1_7_R4.EntityHuman;
import net.minecraft.server.v1_7_R4.PacketPlayOutEntityDestroy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftSnowball;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;

import com.experiencepvp.kits.listeners.cmds.Grappler;

public class FishingHook extends net.minecraft.server.v1_7_R4.EntityFishingHook {

	public FishingHook(World world, EntityHuman entityhuman) {
		super(((CraftWorld) world).getHandle(), entityhuman);
		this.owner = entityhuman;
	}

	private net.minecraft.server.v1_7_R4.EntitySnowball controller;
	public int a;
	public net.minecraft.server.v1_7_R4.EntityHuman owner;
	public org.bukkit.entity.Entity hooked;
	public boolean lastControllerDead;
	public boolean isHooked;

	protected void c() {
	}

	public void h() {
		if (!this.lastControllerDead && controller.dead) {
			((Player) this.owner.getBukkitEntity()).sendMessage(ChatColor.GREEN + "Your hook is now attached!");
		}
		this.lastControllerDead = controller.dead;
		for (org.bukkit.entity.Entity entity : controller.world.getWorld().getEntities()) {
			if (entity.getType() == EntityType.PLAYER && ((Player) entity).getGameMode() == GameMode.CREATIVE) {
			} else {
				if (entity.getEntityId() != this.getBukkitEntity().getEntityId() && entity.getEntityId() != this.owner.getBukkitEntity().getEntityId() && entity.getEntityId() != this.controller.getBukkitEntity().getEntityId() && entity.getType() != EntityType.FISHING_HOOK) {
					if (entity.getLocation().distance(this.controller.getBukkitEntity().getLocation()) < 2 || (entity instanceof Player && ((Player) entity).getEyeLocation().distance(this.controller.getBukkitEntity().getLocation()) < 2)) {
						this.controller.locX = entity.getLocation().getX();
						this.controller.locY = entity.getLocation().getY();
						this.controller.locZ = entity.getLocation().getZ();
						this.locX = entity.getLocation().getX();
						this.locY = entity.getLocation().getY();
						this.locZ = entity.getLocation().getZ();
						this.motX = 0;
						this.motY = 0.04;
						this.motZ = 0;
					}
				}
			}
		}
		try {
			this.locX = this.hooked.getLocation().getX();
			this.locY = this.hooked.getLocation().getY();
			this.locZ = this.hooked.getLocation().getZ();
			this.motX = 0;
			this.motY = 0.04;
			this.motZ = 0;
			this.isHooked = true;
		} catch (Exception e) {
			if (this.controller.dead)
				this.isHooked = true;
			this.locX = this.controller.locX;
			this.locY = this.controller.locY;
			this.locZ = this.controller.locZ;
		}

	}

	public void die() {
	}

	public void remove() {
		super.die();
	}

	public void spawn(Location location) {
		Snowball sb = this.owner.getBukkitEntity().launchProjectile(Snowball.class);
		this.controller = ((CraftSnowball) sb).getHandle();
		Grappler.controllers.add((Projectile) sb);
		PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(controller.getId());
		for (Player p : Bukkit.getOnlinePlayers())
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
		((CraftWorld) location.getWorld()).getHandle().addEntity(this);
	}

	public boolean isHooked() {
		return this.isHooked;
	}

	public void setHookedEntity(org.bukkit.entity.Entity damaged) {
		this.hooked = damaged;
	}
}
