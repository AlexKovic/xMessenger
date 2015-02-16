package com.experiencepvp.kits;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.experiencepvp.autorespawn.AutoRespawn;
import com.experiencepvp.coins.CoinsCommands;
import com.experiencepvp.coins.CoinsListener;
import com.experiencepvp.combo.ComboCommands;
import com.experiencepvp.combo.ComboListener;
import com.experiencepvp.events.EventsHandler;
import com.experiencepvp.freekit.FreeKitListener;
import com.experiencepvp.kits.listeners.PlayerListener;
import com.experiencepvp.kits.listeners.cmds.Anchor;
import com.experiencepvp.kits.listeners.cmds.AntiStomper;
import com.experiencepvp.kits.listeners.cmds.Archer;
import com.experiencepvp.kits.listeners.cmds.Catcher;
import com.experiencepvp.kits.listeners.cmds.Elemental;
import com.experiencepvp.kits.listeners.cmds.Enderman;
import com.experiencepvp.kits.listeners.cmds.Feather;
import com.experiencepvp.kits.listeners.cmds.Fisherman;
import com.experiencepvp.kits.listeners.cmds.Flash;
import com.experiencepvp.kits.listeners.cmds.Gambler;
import com.experiencepvp.kits.listeners.cmds.Gladiator;
import com.experiencepvp.kits.listeners.cmds.God;
import com.experiencepvp.kits.listeners.cmds.Grandpa;
import com.experiencepvp.kits.listeners.cmds.Grappler;
import com.experiencepvp.kits.listeners.cmds.Hulk;
import com.experiencepvp.kits.listeners.cmds.Jellyfish;
import com.experiencepvp.kits.listeners.cmds.Kangaroo;
import com.experiencepvp.kits.listeners.cmds.Ninja;
import com.experiencepvp.kits.listeners.cmds.Phantom;
import com.experiencepvp.kits.listeners.cmds.Poseidon;
import com.experiencepvp.kits.listeners.cmds.PvP;
import com.experiencepvp.kits.listeners.cmds.Reaper;
import com.experiencepvp.kits.listeners.cmds.Rogue;
import com.experiencepvp.kits.listeners.cmds.Samurai;
import com.experiencepvp.kits.listeners.cmds.Snail;
import com.experiencepvp.kits.listeners.cmds.Sonic;
import com.experiencepvp.kits.listeners.cmds.Specialist;
import com.experiencepvp.kits.listeners.cmds.Stomper;
import com.experiencepvp.kits.listeners.cmds.Switcher;
import com.experiencepvp.kits.listeners.cmds.Tank;
import com.experiencepvp.kits.listeners.cmds.Thor;
import com.experiencepvp.kits.listeners.cmds.Turtle;
import com.experiencepvp.kits.listeners.cmds.Viper;
import com.experiencepvp.kits.methods.KitCommands;
import com.experiencepvp.kits.tournaments.commands.TourneyCommands;
import com.experiencepvp.kits.tournaments.listeners.InGameListener;
import com.experiencepvp.kits.tournaments.listeners.MainListener;
import com.experiencepvp.lava.LavaCommands;
import com.experiencepvp.lava.LavaListener;
import com.experiencepvp.levels.LevelListener;
import com.experiencepvp.miscellaneous.commands.AdminCommand;
import com.experiencepvp.miscellaneous.commands.ApplyCommand;
import com.experiencepvp.miscellaneous.commands.ApplyLevelKit;
import com.experiencepvp.miscellaneous.commands.ExtraKitCommands;
import com.experiencepvp.miscellaneous.commands.HacksCheck;
import com.experiencepvp.miscellaneous.commands.VoteCommand;
import com.experiencepvp.oneinthechamber.OITCCommands;
import com.experiencepvp.oneversusone.OneVOneCommands;
import com.experiencepvp.oneversusone.OneVOneListener;
import com.experiencepvp.preferences.PreferencesListener;
import com.experiencepvp.ranks.RanksListener;
import com.experiencepvp.scoreboard.ScoreboardListener;
import com.experiencepvp.sheduledcommands.ScheduledCommand;
import com.experiencepvp.sheduledcommands.ScheduledCommandsMain;
import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;

import de.slikey.effectlib.EffectLib;
import de.slikey.effectlib.EffectManager;

public class Main extends JavaPlugin {

	private static Plugin plugin;
	private static Main instance;


	public Logger logger = Logger.getLogger("Minecraft");
	static SettingsManager settings = SettingsManager.getInstance();
	public static String pref = ChatColor.GRAY + "[" + ChatColor.BLUE + "ExperiencePvP" + ChatColor.GRAY + "] ";
	public static EffectManager em;
	
	public void onEnable() {
		
		logger.info(ChatColor.BLUE + "Enabling ExperienceKits!");
		settings.setup(this);
		plugin = this;

	    EffectLib lib = EffectLib.instance();
		em = new EffectManager(lib);
		
		new AutoRespawn(this);
		
		registerEvents(this, new PlayerListener(), new Archer(), new Gambler(),
				new Grappler(), new Stomper(), new Kangaroo(),
				new com.experiencepvp.kits.listeners.cmds.Gladiator(),
				new Hulk(), new Fisherman(), new Jellyfish(), new Thor(),
				new Viper(), new Phantom(), new Snail(), new Ninja(),
				new Reaper(), new Enderman(), new Turtle(), new Switcher(),
				new Samurai(), new Stats(), new Spawn(), new Specialist(), 
				new Grandpa(), new Poseidon(), new Anchor(), new Rogue(),
				new Feather(), new Sonic(), new Flash(), new Tank(), 
				new MainListener(), new InGameListener(), new FreeKitListener(),
				new OneVOneListener(), new RanksListener(), new CoinsListener(),
				new LevelListener(), new ScoreboardListener(), new LavaListener(),
				new ComboListener(), new PreferencesListener(),
				new HacksCheck(), new VoteCommand(), new Elemental(), new God(),
				new Catcher());

		getCommand("pvp").setExecutor(new PvP());
		getCommand("archer").setExecutor(new Archer());
		getCommand("gambler").setExecutor(new Gambler());
		getCommand("stomper").setExecutor(new Stomper());
		getCommand("kangaroo").setExecutor(new Kangaroo());
		getCommand("grappler").setExecutor(new Grappler());
		getCommand("gladiator").setExecutor(new Gladiator());
		getCommand("hulk").setExecutor(new Hulk());
		getCommand("fisherman").setExecutor(new Fisherman());
		getCommand("jellyfish").setExecutor(new Jellyfish());
		getCommand("thor").setExecutor(new Thor());
		getCommand("viper").setExecutor(new Viper());
		getCommand("phantom").setExecutor(new Phantom());
		getCommand("snail").setExecutor(new Snail());
		getCommand("ninja").setExecutor(new Ninja());
		getCommand("reaper").setExecutor(new Reaper());
		getCommand("enderman").setExecutor(new Enderman());
		getCommand("turtle").setExecutor(new Turtle());
		getCommand("switcher").setExecutor(new Switcher());
		getCommand("samurai").setExecutor(new Samurai());
		getCommand("specialist").setExecutor(new Specialist());
		getCommand("grandpa").setExecutor(new Grandpa());
		getCommand("poseidon").setExecutor(new Poseidon());
		getCommand("anchor").setExecutor(new Anchor());
		getCommand("rogue").setExecutor(new Rogue());
		getCommand("feather").setExecutor(new Feather());
		getCommand("sonic").setExecutor(new Sonic());
		getCommand("flash").setExecutor(new Flash());
//		getCommand("tank").setExecutor(new Tank());
//		getCommand("elemental").setExecutor(new Elemental());
//		getCommand("god").setExecutor(new God());
//		getCommand("catcher").setExecutor(new Catcher());
		getCommand("settings").setExecutor(new KitCommands());
		getCommand("stats").setExecutor(new Stats());
		getCommand("setspawn").setExecutor(new Spawn());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("tourney").setExecutor(new TourneyCommands());
		getCommand("join").setExecutor(new EventsHandler());
		getCommand("apply").setExecutor(new ApplyCommand());
		getCommand("1v1").setExecutor(new OneVOneCommands());
		getCommand("ckit").setExecutor(new ExtraKitCommands());
		getCommand("skit").setExecutor(new ExtraKitCommands());
		getCommand("antistomper").setExecutor(new AntiStomper());
		getCommand("admin").setExecutor(new AdminCommand());
		getCommand("coins").setExecutor(new CoinsCommands());
		//getCommand("ban").setExecutor(new BanCommand());
		//getCommand("tempban").setExecutor(new BanCommand());
		getCommand("akit").setExecutor(new ApplyLevelKit());
		getCommand("event").setExecutor(new EventsHandler());
		getCommand("lava").setExecutor(new LavaCommands());
		getCommand("combo").setExecutor(new ComboCommands());
		getCommand("bal").setExecutor(new CoinsCommands());
		getCommand("balance").setExecutor(new CoinsCommands());
		getCommand("getlevel").setExecutor(new ApplyLevelKit());
		getCommand("setlevel").setExecutor(new ApplyLevelKit());
		getCommand("scheduledtest").setExecutor(new ScheduledCommand());
		getCommand("fixcoins").setExecutor(new ApplyLevelKit());
		getCommand("listlevel").setExecutor(new ApplyLevelKit());
		getCommand("listcorrupt").setExecutor(new ApplyLevelKit());
		getCommand("checkff").setExecutor(new HacksCheck());
		getCommand("votespawn").setExecutor(new VoteCommand());
		getCommand("seespawn").setExecutor(new VoteCommand());
		getCommand("listspawn").setExecutor(new VoteCommand());
		getCommand("vote").setExecutor(new EventsHandler());
		getCommand("oitc").setExecutor(new OITCCommands());
		
		ScheduledCommandsMain.startTimer();

		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				try {
					for (Entity e : Bukkit.getWorld("experiencepvp").getEntities()) {
						if (e instanceof Item)
							if (e.getTicksLived() > 160)
								e.remove();
					}
				} catch (Exception e) {
				}
			}
		}, 20, 10);
		
		int delay = settings.getConfig().getInt("messages.delay");

		if(settings.getConfig().contains("messages.broadcast")){
			new BukkitRunnable() {
				public void run() {
					List<String> msgs = settings.getConfig().getStringList("messages.broadcast");
					Random r = new Random();
					int index = r.nextInt(msgs.size());
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msgs.get(index)));
				}
			}.runTaskTimer(this, delay * 20, delay * 20);
		}
		
//		for(final OfflinePlayer oPlayer : Bukkit.getServer().getOfflinePlayers()){
//			if(settings.getData().contains("freekit." + oPlayer.getName() + ".time")){
//				new BukkitRunnable() {
//					public void run() {
//						if(settings.getData().getInt("freekit." + oPlayer.getName() + ".time") < 2){
//							settings.getData().set("freekit." + oPlayer.getName() + ".kit", null);
//							settings.getData().set("freekit." + oPlayer.getName() + ".time", null);
//							this.cancel();
//							return;
//						}
//						
//						settings.getData().set("freekit." + oPlayer.getName() + ".time", settings.getData().getInt("freekit." + oPlayer.getName() + ".time") - 1);
//					}
//				}.runTaskTimer(Main.getPlugin(), 1200, 1200);
//			}
//			
//			if(settings.getData().contains("freekit." + oPlayer.getName() + ".wait")){
//				new BukkitRunnable() {
//					public void run() {
//						if(settings.getData().getInt("freekit." + oPlayer.getName() + ".wait") < 2){
//							settings.getData().set("freekit." + oPlayer.getName() + ".wait", null);
//							this.cancel();
//							return;
//						}
//						
//						settings.getData().set("freekit." + oPlayer.getName() + ".wait", settings.getData().getInt("freekit." + oPlayer.getName() + ".wait") - 1);
//					}
//				}.runTaskTimer(Main.getPlugin(), 1200, 1200);
//			}
//		}
		
		EventsHandler.startCooldownTimer("first");
		
	}

	public void onDisable() {
		em.dispose();
	}

	public static void registerEvents(org.bukkit.plugin.Plugin plugin,
			Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager()
					.registerEvents(listener, plugin);
		}
	}

	public static Plugin getPlugin() {
		return plugin;
	}

	public static Main get() {
		return instance;
	}

	public static WorldGuardPlugin getWorldGuard() {
		Plugin plugin = Bukkit.getServer().getPluginManager()
				.getPlugin("WorldGuard");

		// WorldGuard may not be loaded
		if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
			return null; // Maybe you want throw an exception instead
		}

		return (WorldGuardPlugin) plugin;
	}

	public static boolean correctRegion(Location loc) {
		ApplicableRegionSet set = WGBukkit.getRegionManager(loc.getWorld())
				.getApplicableRegions(loc);
		return (set.allows(DefaultFlag.PVP) && !set
				.allows(DefaultFlag.INVINCIBILITY));
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if(sender instanceof Player) {
    		Player p = (Player) sender;
    		if(cmd.getName().equalsIgnoreCase("experiencepvp")) {
    			if(args[0].equalsIgnoreCase("reload")) {
    				if(p.isOp()) {
    					settings.reloadConfig();
    					settings.reloadData();
    					settings.reload1v1();
    					settings.reloadBans();
    					settings.reloadFreekits();
    					settings.reloadTourneys();
    					settings.reloadLevels();
    					settings.reloadRanks();
    					String prefix = settings.getConfig().getString("messages.prefix");
    					p.sendMessage(prefix.replaceAll("&", "§") + "Config successfully reloaded!");
    				}
    			}
    		}
    	}
    	return true;
    }
    
    
}
