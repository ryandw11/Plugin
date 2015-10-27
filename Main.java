package me.ryandw11.tester.core;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import me.ryandw11.tester.commands.cmdCommand;
import me.ryandw11.tester.commands.teleCommand;
import me.ryandw11.tester.listeners.joinListener;
import me.ryandw11.tester.listeners.leaveListener;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public final Logger logger = Logger.getLogger("Minecraft");
	public Main plugin;
	
	public File balfile = new File(getDataFolder() + "coindata.yml");
	public FileConfiguration bal = YamlConfiguration.loadConfiguration(balfile);
	
	
	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info("The tester plugin has been enabled!"); // prints into the log
		getCommand("cmd").setExecutor(new cmdCommand());
		getCommand("vtp").setExecutor(new teleCommand());
		Bukkit.getServer().getPluginManager().registerEvents(new leaveListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new joinListener(), this);
		
		loadFile();
	}
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info("The tester plugin has been disabled!"); // same thing
		saveFile();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void saveFile(){
		
		try{
			bal.save(balfile);
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
	}
	
	public void loadFile(){
		if(balfile.exists()){
			try {
				bal.load(balfile);
			} catch (IOException | InvalidConfigurationException e) {

				e.printStackTrace();
			}
		}
		else{
			try {
				bal.save(balfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
