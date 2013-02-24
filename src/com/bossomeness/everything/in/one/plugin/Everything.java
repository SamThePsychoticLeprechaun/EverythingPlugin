package com.bossomeness.everything.in.one.plugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.bossomeness.everything.in.one.plugin.commandhandler.CommandHandler;

public class Everything extends JavaPlugin {
	
	protected static File configFile;
	
	public static int defaultburntime;
	public static int defaultfiretime;
	public static int defaultfiresize;

	@Override
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		/**
		 * adds permissions when the server starts up
		 */
		pm.addPermission(new Permissions().heal);
		pm.addPermission(new Permissions().healOther);
		pm.addPermission(new Permissions().burn);
		pm.addPermission(new Permissions().burnOther);
		pm.addPermission(new Permissions().fire);
		pm.addPermission(new Permissions().fireOther);
		
		/**
		 * redirects commands to the command handler
		 */
		getCommand("everything").setExecutor(new CommandHandler());
		getCommand("ev").setExecutor(new CommandHandler());
		
		/**
		 * creates the config file if not already in data folder and loads thereafter	
		 */
		configFile = new File(getDataFolder(), "config.yml");
		
		if(configFile.exists()) {
			try {
	        getConfig().load(configFile);
	        getLogger().info("Config file successfully loaded.");
				} catch (FileNotFoundException e) {
				getLogger().info("Error while loading config!");
	            e.printStackTrace();
	        	} catch (IOException e) {
	            getLogger().info("Error while loading config!");
	            e.printStackTrace();
	        	} catch (InvalidConfigurationException e) {
	            getLogger().info("Error while loading config!");
	            e.printStackTrace();
	        	}	
			} else {
				getLogger().info("Creating Config File!");
				this.saveDefaultConfig();
				try {
				    getConfig().load(configFile);
				    getLogger().info("Config file successfully loaded.");
					} catch (FileNotFoundException e) {
					getLogger().info("Error while loading config!");
				    e.printStackTrace();
				    } catch (IOException e) {
				    getLogger().info("Error while loading config!");
				    e.printStackTrace();
				    } catch (InvalidConfigurationException e) {
				    getLogger().info("Error while loading config!");
				    e.printStackTrace();
				    }
			}
		
		/**
		 * gets all values from the config file
		 */
		FileConfiguration config = getConfig();
		
		Everything.defaultburntime = config.getInt("defaultburntime");
		Everything.defaultfiretime = config.getInt("defaultfiretime");
		Everything.defaultfiresize = config.getInt("defaultfiresize");
		
	}

	@Override
	public void onDisable() {
		/**
		 * This section disables the permissions
		 */
		getServer().getPluginManager().removePermission(new Permissions().heal);
		getServer().getPluginManager().removePermission(new Permissions().healOther);
		getServer().getPluginManager().removePermission(new Permissions().burn);
		getServer().getPluginManager().removePermission(new Permissions().burnOther);
		getServer().getPluginManager().removePermission(new Permissions().fire);
		getServer().getPluginManager().removePermission(new Permissions().fireOther);
	}

}
