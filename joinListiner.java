package me.ryandw11.tester.listeners;


import me.ryandw11.tester.core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class joinListener implements Listener {
	
	public Main plugin;
	
	
	
	
	
	
	
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player p = (Player) event.getPlayer();
		String name = p.getName();
		//if player has not joined before
		if(!p.hasPlayedBefore()){
			Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA + "Please welcome " + name + "!");
		}
		else{
			p.sendMessage(ChatColor.GRAY + "Welcome Back, " + name + "!" );
		}
	}

}
