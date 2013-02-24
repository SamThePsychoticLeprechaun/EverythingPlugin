package com.bossomeness.everything.in.one.plugin.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

import com.bossomeness.everything.in.one.plugin.Everything;

public class ConfigLoader {

	protected static File configFile;
	
	public static void LoadConfig(Everything plugin) {
		
		Logger log = plugin.getLogger();
		FileConfiguration config = plugin.getConfig();
		configFile = new File(plugin.getDataFolder(), "config.yml");
		
		if(configFile.exists()) {
			try {
	        config.load(configFile);
	        log.info("Config file successfully loaded.");
				} catch (FileNotFoundException e) {
				log.info("Error while loading config!");
	            e.printStackTrace();
	        	} catch (IOException e) {
	            log.info("Error while loading config!");
	            e.printStackTrace();
	        	} catch (InvalidConfigurationException e) {
	            log.info("Error while loading config!");
	            e.printStackTrace();
	        	}	
			} else {
				log.info("Creating Config File!");
				plugin.saveDefaultConfig();
				try {
				    config.load(configFile);
				    log.info("Config file successfully loaded.");
					} catch (FileNotFoundException e) {
					log.info("Error while loading config!");
				    e.printStackTrace();
				    } catch (IOException e) {
				    log.info("Error while loading config!");
				    e.printStackTrace();
				    } catch (InvalidConfigurationException e) {
				    log.info("Error while loading config!");
				    e.printStackTrace();
				    }
			}
		
		ConfigVariables.defaultburntime = config.getInt("defaultburntime");
		ConfigVariables.defaultfiretime = config.getInt("defaultfiretime");
		ConfigVariables.defaultfiresize = config.getInt("defaultfiresize");
		
	}
	
}
