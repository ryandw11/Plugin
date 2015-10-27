package me.ryandw11.tester.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class teleCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		
		
		if(!(sender instanceof Player )) return true;
		Player p = (Player) sender;
		if(args.length != 1) return true;
		if(cmd.getName().equalsIgnoreCase("vtp")){
			if (p.hasPermission("tester.vtp") || p.isOp()) {
			Player tp = (Player) Bukkit.getServer().getPlayer(args[0]);
			String name = tp.getName();
			
			if(tp.isOnline()){
				PotionEffectType effect=PotionEffectType.INVISIBILITY;
				Location loc = tp.getLocation();
				
				p.teleport(loc);
				p.addPotionEffect(effect.createEffect(1500,100));
				p.sendMessage(ChatColor.RED + "You have been teleported to " + name + "!");
			}
			else{
				p.sendMessage(ChatColor.GREEN + "The player is not online!");
			}
			
		}
			else{
				p.sendMessage(ChatColor.RED + "You do not have perm to this command!");
			
			}
		}
		
		return false;
	}

}
