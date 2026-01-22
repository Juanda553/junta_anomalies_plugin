package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ExplosiveBeds implements Listener {

    //Camas explotan en el overworld
    // Sebas
    @EventHandler
    public void onBedExplodes(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Block block = event.getClickedBlock();
        if (block == null) return;

        if (!block.getType().name().contains("BED")) return;

        Player player = event.getPlayer();

        event.setCancelled(true);

        block.setType(Material.AIR);

        block.getWorld().createExplosion(
                block.getLocation().add(0.5, 0.5, 0.5),
                2.0F,
                false,
                true,
                player
        );
    }
}
