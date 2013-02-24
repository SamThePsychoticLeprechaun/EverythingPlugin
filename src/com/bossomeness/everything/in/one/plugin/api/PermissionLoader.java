package com.bossomeness.everything.in.one.plugin.api;

import org.bukkit.plugin.PluginManager;

import com.bossomeness.everything.in.one.plugin.Everything;
import com.bossomeness.everything.in.one.plugin.Permissions;

public class PermissionLoader {
	
	public static void loadPerms(Everything plugin) {
		
		PluginManager pm = plugin.getServer().getPluginManager();

		pm.addPermission(new Permissions().heal);
		pm.addPermission(new Permissions().healOther);
		pm.addPermission(new Permissions().burn);
		pm.addPermission(new Permissions().burnOther);
		pm.addPermission(new Permissions().fire);
		pm.addPermission(new Permissions().fireOther);
		
	}
	
	public static void unloadPerms(Everything plugin) {
		
		PluginManager pm = plugin.getServer().getPluginManager();
		
		pm.removePermission(new Permissions().heal);
		pm.removePermission(new Permissions().healOther);
		pm.removePermission(new Permissions().burn);
		pm.removePermission(new Permissions().burnOther);
		pm.removePermission(new Permissions().fire);
		pm.removePermission(new Permissions().fireOther);
		
	}
	
}
