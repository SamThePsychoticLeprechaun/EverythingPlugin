package com.bossomeness.everything.in.one.plugin;

import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;

import com.bossomeness.everything.in.one.plugin.api.ConfigLoader;
import com.bossomeness.everything.in.one.plugin.api.PermissionLoader;
import com.bossomeness.everything.in.one.plugin.commandhandler.CommandHandler;

public class Everything extends JavaPlugin {
	
	protected static File configFile;
	public Everything plugin;

	@Override
	public void onEnable() {
		
		//Sets the plugin value for other classes
		plugin = this;
		
		//Adds permissions when the server starts up
		PermissionLoader.loadPerms(plugin);		
		
		//Redirects commands to the command handler
		getCommand("everything").setExecutor(new CommandHandler());
		getCommand("ev").setExecutor(new CommandHandler());
		

		//Creates the config file if not already in data folder and loads the file and its values thereafter
		ConfigLoader.LoadConfig(plugin);
		
	}

	@Override
	public void onDisable() {
		
		//Removes permissions when the plugin is disabled
		PermissionLoader.unloadPerms(plugin);
		
	}

}
