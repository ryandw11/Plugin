package me.ryandw11.tester.listeners;

import me.ryandw11.tester.core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class leaveListener implements Listener {
	
	public Main plugin;
	
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event){
		Player p = (Player) event.getPlayer();
		String name = p.getName();
		
		Bukkit.getServer().broadcastMessage(ChatColor.RED + name + " has left the server! GoodBye!");
	}
	
	
	
	
	

}
