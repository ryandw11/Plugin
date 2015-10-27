package me.ryandw11.tester.commands;

import me.ryandw11.tester.core.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdCommand implements CommandExecutor {
	
	public Main plugin;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("cmd")){
			
			if(!(p instanceof Player )){
				plugin.logger.info("[Tester] Only player can use that command!");
				
			}
			else{
				p.sendMessage(ChatColor.DARK_GREEN + "You have made your first command!");
			}
			
		}
		
		
		return false;
	}

}
