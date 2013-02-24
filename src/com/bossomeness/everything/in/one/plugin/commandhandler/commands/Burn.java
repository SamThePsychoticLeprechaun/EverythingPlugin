package com.bossomeness.everything.in.one.plugin.commandhandler.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.bossomeness.everything.in.one.plugin.Everything;
import com.bossomeness.everything.in.one.plugin.Permissions;

public class Burn {
	
	/**
	 * Deals with burn commands with no parameters
	 * @param player
	 * @return
	 */
	public static boolean burn(Player player) {
		
		if (player.hasPermission(new Permissions().burn)) {
			
			int burntime = Everything.defaultburntime * 20;
			player.setFireTicks(burntime);
			player.sendMessage(ChatColor.DARK_RED + "You burnt yourself!");			
			
		} else {
			
			player.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
			
		}
		
		return true;
		
	}
	
	/**
	 * Deals with burn commands with a target parameter
	 * @param player
	 * @param arg
	 * @return
	 */
	public static boolean burn(Player player, String arg) {
		
		if (player.hasPermission(new Permissions().burnOther)) {
			
			Player playerTarget = player.getServer().getPlayer(arg);
			int burntime = Everything.defaultburntime * 20;
			playerTarget.setFireTicks(burntime);
			playerTarget.sendMessage(ChatColor.DARK_RED + "You have been set on fire!");
			player.sendMessage(ChatColor.DARK_RED + "You have burnt " + playerTarget.getName() + "!");			
			
		} else {
			
			player.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
			
		}
		
		return true;
		
	}
	
	/**
	 * Deals with burn commands with a target parameter and duration parameter
	 * @param player
	 * @param arg
	 * @param arg2
	 * @return
	 */
	public static boolean burn(Player player, String arg, String arg2) {
		
		Player playerTarget = player.getServer().getPlayer(arg);
		
		//Make sure the correct permissions is used - if player targets him/herself
		if (player.getName().equalsIgnoreCase(playerTarget.getName())) {
		
			if (player.hasPermission(new Permissions().burn)) {
				
			int burntime = Integer.parseInt(arg2);
			playerTarget.setFireTicks(burntime);
			player.sendMessage(ChatColor.DARK_RED + "You have burnt yourself!");	
				
			} else {
				
				player.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
				
			}
			
		} else {
			
			if (player.hasPermission(new Permissions().burn)) {
				
			int burntime = Integer.parseInt(arg2);
			playerTarget.setFireTicks(burntime);
			playerTarget.sendMessage(ChatColor.DARK_RED + "You have been set on fire!");
			player.sendMessage(ChatColor.DARK_RED + "You have burnt " + playerTarget.getName() + "!");	
					
			} else {
					
			player.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
					
			}
			
		}
		
		return true;
		
	}

}
