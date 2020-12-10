package tnt;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Player p = event.getPlayer();
		World w = Bukkit.getWorld(p.getWorld().getName());
		if (Main.getPlugin().getConfig().getBoolean("ignite-on-place")) {
			if (event.getBlock().getType().equals(Material.TNT)) {
				Block block = event.getBlock();
				block.setType(Material.AIR);
				w.spawnEntity(event.getBlock().getLocation(), EntityType.PRIMED_TNT);
			}
		}
	}
}
