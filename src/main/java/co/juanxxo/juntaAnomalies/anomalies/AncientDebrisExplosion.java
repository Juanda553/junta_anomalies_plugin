package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class AncientDebrisExplosion implements Listener {

    // 30% de probabilidad de explosion al picar netherite
    // Sebas
    @EventHandler
    public void onBreakAncientDebris(BlockBreakEvent event) {

        if (event.getBlock().getType() != Material.ANCIENT_DEBRIS) return;

        if (Math.random() <= 0.30) {
            event.getBlock().getWorld().createExplosion(
                    event.getBlock().getLocation(),
                    3.0f,   // potencia de la explosión
                    false   // no prende fuego
            );
        }
    }
}