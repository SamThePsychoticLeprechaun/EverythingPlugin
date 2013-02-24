package com.bossomeness.everything.in.one.plugin.commandhandler.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.bossomeness.everything.in.one.plugin.Permissions;
import com.bossomeness.everything.in.one.plugin.api.ConfigVariables;

public class Fire {

	public static boolean fire(Player player) {
		
		if (player.hasPermission(new Permissions().fire)) {
			
			int firetime = ConfigVariables.defaultfiretime * 20;
			int firesize = (ConfigVariables.defaultfiresize + 1) / 2;
			
			Location loc = new Location(null, 0, 0, 0);
			player.getLocation(loc);
			
			for (int x = (0 - firesize); x <= firesize; x++) {
				
				for (int z = (0 - firesize); z <= firesize; z++) {
					
					double xVal = (double) x;
					double zVal = (double) x;
					loc.setX(loc.getX() + xVal);
					loc.setZ(loc.getZ() + zVal);
					
					while (!(loc.getBlock().getType().equals(Material.AIR))) {
						
						loc.setY(loc.getY() + 1);
						
					}
					
					loc.getBlock().setType(Material.FIRE);
					loc.setY(player.getLocation().getY());
					
				}
				
			}
			
			player.setFireTicks(firetime);
			player.sendMessage(ChatColor.DARK_RED + "You burnt yourself!");	
			
		} else {
			
			player.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
			
		}
		
		return true;	
		
	}
	
	public static boolean fire(Player player, String arg) {
		
		if (player.hasPermission(new Permissions().fireOther)) {
			
			Player playerTarget = player.getServer().getPlayer(arg);
			int firetime = ConfigVariables.defaultfiretime * 20;
			double firesize = (double) Math.floor((ConfigVariables.defaultfiresize + 1) / 2);
			
			Location loc = new Location(null, 0, 0, 0);
			playerTarget.getLocation(loc);
			
			for (double x = (0 - firesize); x <= firesize; x++) {
				
				for (double z = (0 - firesize); z <= firesize; z++) {

					loc.setX(loc.getX() + x);
					loc.setZ(loc.getZ() + z);
					
					while (!(loc.getBlock().getType().equals(Material.AIR))) {
						
						loc.setY(loc.getY() + 1);
						
					}
					
					loc.getBlock().setType(Material.FIRE);
					loc.setY(playerTarget.getLocation().getY());
					
				}
				
			}
			
			playerTarget.setFireTicks(firetime);
			player.sendMessage(ChatColor.DARK_RED + "You have burnt " + playerTarget.getName() + "!");
			
		} else {
			
			player.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
			
		}
		
		return true;
		
	}
	
	public static boolean fire(Player player, String arg, String arg2) {
		
		Player playerTarget = player.getServer().getPlayer(arg);
		
		if (player.getName().equalsIgnoreCase(arg)) {
		
			if (player.hasPermission(new Permissions().fire)) {
			
			int firetime = Integer.parseInt(arg2) * 20;
			double firesize = (double) Math.floor((ConfigVariables.defaultfiresize + 1) / 2);
			
			Location loc = new Location(null, 0, 0, 0);
			player.getLocation(loc);
			
			for (double x = (0 - firesize); x <= firesize; x++) {
				
				for (double z = (0 - firesize); z <= firesize; z++) {

					loc.setX(loc.getX() + x);
					loc.setZ(loc.getZ() + z);
					
					while (!(loc.getBlock().getType().equals(Material.AIR))) {
						
						loc.setY(loc.getY() + 1);
						
					}

					loc.getBlock().setType(Material.FIRE);
					loc.setY(player.getLocation().getY());
					
				}
				
			}
			
			player.setFireTicks(firetime);
			player.sendMessage(ChatColor.DARK_RED + "You burnt yourself!");	
			
		} else {
			
			player.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
			
		}
			
		} else {
			
			if (player.hasPermission(new Permissions().fireOther)) {
				
				int firetime = ConfigVariables.defaultfiretime * 20;
				double firesize = (double) Math.floor((ConfigVariables.defaultfiresize + 1) / 2);
				
				Location loc = new Location(null, 0, 0, 0);
				playerTarget.getLocation(loc);
				
				for (double x = (0 - firesize); x <= firesize; x++) {
					
					for (double z = (0 - firesize); z <= firesize; z++) {

						loc.setX(loc.getX() + x);
						loc.setZ(loc.getZ() + z);
						
						while (!(loc.getBlock().getType().equals(Material.AIR))) {
							
							loc.setY(loc.getY() + 1);
							
						}
						
						loc.getBlock().setType(Material.FIRE);
						loc.setY(playerTarget.getLocation().getY());
						
					}
					
				}
				
				playerTarget.setFireTicks(firetime);
				player.sendMessage(ChatColor.DARK_RED + "You have burnt " + playerTarget.getName() + "!");
				
			} else {
				
				player.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
				
			}
			
		}
		
		return true;
		
	}
	
	public static boolean fire(Player player, String arg, String arg2, String arg3) {
		
		Player playerTarget = player.getServer().getPlayer(arg);
		
		if (player.getName().equalsIgnoreCase(arg)) {
		
			if (player.hasPermission(new Permissions().fire)) {
			
			int firetime = Integer.parseInt(arg2) * 20;
			double firesize = (double) Math.floor((Integer.parseInt(arg3) + 1) / 2);
			
			Location loc = new Location(null, 0, 0, 0);
			player.getLocation(loc);
			
			for (double x = (0 - firesize); x <= firesize; x++) {
				
				for (double z = (0 - firesize); z <= firesize; z++) {

					loc.setX(loc.getX() + x);
					loc.setZ(loc.getZ() + z);
					
					while (!(loc.getBlock().getType().equals(Material.AIR))) {
						
						loc.setY(loc.getY() + 1);
						
					}
					
					loc.getBlock().setType(Material.FIRE);
					loc.setY(playerTarget.getLocation().getY());
					
				}
				
			}
			
			player.setFireTicks(firetime);
			player.sendMessage(ChatColor.DARK_RED + "You burnt yourself!");	
			
		} else {
			
			player.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
			
		}
			
		} else {
			
			if (player.hasPermission(new Permissions().fireOther)) {
				
				int firetime = ConfigVariables.defaultfiretime * 20;
				double firesize = (double) Math.floor((ConfigVariables.defaultfiresize + 1) / 2);
				
				Location loc = new Location(null, 0, 0, 0);
				playerTarget.getLocation(loc);
				
				for (double x = (0 - firesize); x <= firesize; x++) {
					
					for (double z = (0 - firesize); z <= firesize; z++) {

						loc.setX(loc.getX() + x);
						loc.setZ(loc.getZ() + z);
						
						while (!(loc.getBlock().getType().equals(Material.AIR))) {
							
							loc.setY(loc.getY() + 1);
							
						}
						
						loc.getBlock().setType(Material.FIRE);
						loc.setY(playerTarget.getLocation().getY());
						
					}
					
				}
				
				playerTarget.setFireTicks(firetime);
				player.sendMessage(ChatColor.DARK_RED + "You have burnt " + playerTarget.getName() + "!");
				
			} else {
				
				player.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
				
			}
			
		}
		
		return true;
		
	}
	
}
