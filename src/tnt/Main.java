package tnt;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main getPlugin() {
		return getPlugin(Main.class);
	}
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		this.getServer().getPluginManager().registerEvents(new BlockPlace(), this);
		this.getServer().getPluginManager().registerEvents(new BlockBreak(), this);
		
	}

}
