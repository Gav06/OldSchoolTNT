package tnt;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;


public class BlockBreak implements Listener {
	@EventHandler
	public void onPlace(BlockBreakEvent event) {
		if (Main.getPlugin().getConfig().getBoolean("ignite-on-punch")) {
			World w = event.getBlock().getLocation().getWorld();
			if (event.getBlock().getType().equals(Material.TNT)) {			
				event.setCancelled(true);
				event.getBlock().setType(Material.AIR);
				w.spawnEntity(event.getBlock().getLocation(), EntityType.PRIMED_TNT);
			}
		}
	}

}
