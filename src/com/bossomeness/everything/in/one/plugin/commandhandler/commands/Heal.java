package com.bossomeness.everything.in.one.plugin.commandhandler.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.bossomeness.everything.in.one.plugin.Permissions;

public class Heal {
	
	/**
	 * Deals with healing commands with no parameters
	 * @param player
	 * @return
	 */
	public static boolean heal(Player player) {
			
		if(player.hasPermission(new Permissions().heal)) {
				
			player.setHealth(20);
			player.setFoodLevel(20);
			player.setRemainingAir(20);
			player.setFireTicks(0);
			player.sendMessage(ChatColor.AQUA + "You have been healed!");
			
		} else {
			
			player.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
			
		}
			
		return true;
		
	}
	
	/**
	 * Deals with healing commands with a target parameter
	 * @param player
	 * @param arg
	 * @return
	 */
	public static boolean heal(Player player, String arg) {
		
		Player playerTarget = player.getServer().getPlayer(arg);
		
		if (playerTarget != null) {
			
			if (player.hasPermission(new Permissions().healOther)) {
				
				playerTarget.setHealth(20);
				playerTarget.setFoodLevel(20);
				playerTarget.setRemainingAir(20);
				playerTarget.setFireTicks(0);
				playerTarget.sendMessage(ChatColor.AQUA	+ "You have just been healed!");
				player.sendMessage(ChatColor.AQUA + "You have healed " + playerTarget.getName());
				
			} else {
				
				player.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
			
			}
			
		} else {
			
			player.sendMessage(ChatColor.RED + "Player Not Found!");
		
		}
		
		return true;
		
	}
	
}
