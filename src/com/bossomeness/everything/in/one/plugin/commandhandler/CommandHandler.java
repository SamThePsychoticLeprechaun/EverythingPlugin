package com.bossomeness.everything.in.one.plugin.commandhandler;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.bossomeness.everything.in.one.plugin.commandhandler.commands.Burn;
import com.bossomeness.everything.in.one.plugin.commandhandler.commands.Fire;
import com.bossomeness.everything.in.one.plugin.commandhandler.commands.Heal;

public class CommandHandler implements CommandExecutor {
	
	/**
	 * Redirects commands to the correct command class 
	 * or alerts the player of an incorrect command usage.
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		//Changes the command sender into a Player object
		Player player = (Player) sender;
		
		if (args[0].equalsIgnoreCase("heal")) {
			
			if (args.length == 1) {
				
				Heal.heal(player);
				
			} else if (args.length == 2) {
				
				Heal.heal(player, args[1]);
				
			} else {
				
				player.sendMessage(ChatColor.RED + "Incorrect use of the command 'Heal' - /ev Heal <Player Name>");
				
			}
			
		} else if (args[0].equalsIgnoreCase("burn")) {
			
			if (args.length == 1) {
				
				Burn.burn(player);
				
			} else if (args.length == 2) {
				
				if (!sender.getName().equalsIgnoreCase(args[1])) {
				
				Burn.burn(player, args[0]);
				
				} else {
					
					Burn.burn(player);
					
				}
				
			} else if (args.length == 3) {
				
				Burn.burn(player, args[1], args[2]);
				
			} else {
				
				player.sendMessage(ChatColor.RED + "Incorrect use of the command 'Burn' - /ev Burn <Player Name> <Burn Time>");
				
			}
			
		} else if (args[0].equalsIgnoreCase("fire")) {
			
			if (args.length == 1) {
				
				Fire.fire(player);
				
			} else if (args.length == 2) {
				
				if (!sender.getName().equalsIgnoreCase(args[0])) {
					
					Fire.fire(player, args[1]);
					
					} else {
						
						Fire.fire(player);
						
					}
				
			} else if (args.length == 3) {
				
				Fire.fire(player, args[1], args[2]);
				
			} else if (args.length == 4) {
				
				Fire.fire(player, args[1], args[2], args [3]);
				
			} else {
				
				player.sendMessage(ChatColor.RED + "Incorrect use of the command 'Fire' - /ev Fire <Player Name> <Burn Time> <Area of Effect>");
				
			}
			
		}
		
		player.sendMessage(ChatColor.RED + "Use '/ev Help' to get a list of commands");
		return true;
	}

}
