package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakCobwebThreeSpider implements Listener {

    //Sebas
    @EventHandler
    public void onPlayerBreakCobweb(BlockBreakEvent event) {
        if (event.getBlock().getType() != Material.COBWEB) return;

        Player player = event.getPlayer();
        event.getBlock().getWorld().spawn(event.getBlock().getLocation(), org.bukkit.entity.CaveSpider.class);
        event.getBlock().getWorld().spawn(event.getBlock().getLocation(), org.bukkit.entity.CaveSpider.class);
        event.getBlock().getWorld().spawn(event.getBlock().getLocation(), org.bukkit.entity.CaveSpider.class);
    }
}
