package com.experiencepvp.kits;
 
import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
 
public class SettingsManager {
 
        private SettingsManager() { }
       
        static SettingsManager instance = new SettingsManager();
       
        public static SettingsManager getInstance() {
                return instance;
        }
       
        Plugin p;
       
        FileConfiguration config;
        File cfile;
       
        FileConfiguration data;
        File dfile;
        
        FileConfiguration tourney;
        File tfile;
        
        FileConfiguration freekit;
        File ffile;
        
        FileConfiguration onevone;
        File ofile;
        
        FileConfiguration levels;
        File lfile;
        
        FileConfiguration ranks;
        File rfile;
        
        FileConfiguration bans;
        File bfile;
        
        public void setup(Plugin p) {
                cfile = new File(p.getDataFolder(), "config.yml");
                config = p.getConfig();
                //config.options().copyDefaults(true);
                //saveConfig();
               
                if (!p.getDataFolder().exists()) {
                        p.getDataFolder().mkdir();
                }
               
                dfile = new File(p.getDataFolder(), "data.yml");
               
                if (!dfile.exists()) {
                        try {
                                dfile.createNewFile();
                        }
                        catch (IOException e) {
                                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create data.yml!");
                        }
                }
               
                data = YamlConfiguration.loadConfiguration(dfile);
               
                
                tfile = new File(p.getDataFolder(), "tourney.yml");
                if (!tfile.exists()) {
                    try {
                            tfile.createNewFile();
                    }
                    catch (IOException e) {
                            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create data.yml!");
                    }
                }
           
                tourney = YamlConfiguration.loadConfiguration(tfile);
            
                ffile = new File(p.getDataFolder(), "freekit.yml");
                if (!ffile.exists()) {
                	try {
                		ffile.createNewFile();
                	} catch (IOException e) {
                		System.out.println("Couldn't create freekit.yml!");
                	}
                }
            
                ofile = new File(p.getDataFolder(), "1v1.yml");
                if (!ofile.exists()) {
                	try {
                		ofile.createNewFile();
                	} catch (IOException e) {
                		System.out.println("Couldnt create 1v1.yml");
                	}
                }
            
                lfile = new File(p.getDataFolder(), "levels.yml");
                if (!lfile.exists()) {
                	try {
                		lfile.createNewFile();
                	} catch (IOException e) {
                		System.out.println("Couldnt create levels.yml");
                	}
                }
            
                rfile = new File(p.getDataFolder(), "ranks.yml");
                if (!rfile.exists()) {
                	try {
                		lfile.createNewFile();
                	} catch (IOException e) {
                		System.out.println("Couldnt create ranks.yml");
                	}
                }
            
                bfile = new File(p.getDataFolder(), "bans.yml");
                if (!bfile.exists()) {
                	try {
                		bfile.createNewFile();
                	} catch (IOException e) {
                		System.out.println("Could not create bans.yml!");
                	}
                }
        }
        
        public FileConfiguration getData() {
                return data;
        }
       
        public void saveData() {
                try {
                        data.save(dfile);
                }
                catch (IOException e) {
                        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save data.yml!");
                }
        }
       
        public void reloadData() {
                data = YamlConfiguration.loadConfiguration(dfile);
        }
       
        public FileConfiguration getConfig() {
                return config;
        }
       
        public void saveConfig() {
                try {
                        config.save(cfile);
                }
                catch (IOException e) {
                        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
                }
        }
       
        public void reloadConfig() {
                config = YamlConfiguration.loadConfiguration(cfile);
        }
       
        public PluginDescriptionFile getDesc() {
                return p.getDescription();
        }
        
        public FileConfiguration getTourneys() {
        	return tourney;
        }
        
        public void reloadTourneys() {
        	tourney = YamlConfiguration.loadConfiguration(tfile);
        }
        
        public void saveTourneys() {
            try {
                tourney.save(tfile);
            } catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save tourney.yml!");
            }
        }
        
        public FileConfiguration getFreeKits() {
        	return freekit;
        }
        
        public void reloadFreekits() {
        	freekit = YamlConfiguration.loadConfiguration(ffile);
        }
        
        public void saveFreekits() {
        	try {
        		freekit.save(ffile);
        	} catch (IOException e) {
        		System.out.println("Could not save freekit.yml");
        	}
        }
        
        public FileConfiguration get1v1() {
        	return onevone;
        }
        
        public void reload1v1() {
        	onevone = YamlConfiguration.loadConfiguration(ofile);
        }
        
        public void save1v1() {
        	try {
        		onevone.save(ofile);
        	} catch (IOException e) {
        		System.out.println("Could not save 1v1.yml");
        	}
        }
        
        public FileConfiguration getLevels() {
        	return levels;
        }
        
        public void reloadLevels() {
        	tourney = YamlConfiguration.loadConfiguration(lfile);
        }
        
        public void saveLevels() {
            try {
                levels.save(lfile);
            } catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save levels.yml!");
            }
        }
        
        public FileConfiguration getRanks() {
        	return ranks;
        }
        
        public void reloadRanks() {
        	tourney = YamlConfiguration.loadConfiguration(lfile);
        }
        
        public void saveRanks() {
            try {
                ranks.save(rfile);
            } catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save ranks.yml!");
            }
        }
        
        public FileConfiguration getBans() {
        	return bans;
        }
        
        public void reloadBans() {
        	bans = YamlConfiguration.loadConfiguration(bfile);
        }
        
        public void saveBans() {
            try {
                bans.save(bfile);
            } catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save bans.yml!");
            }
        }
}