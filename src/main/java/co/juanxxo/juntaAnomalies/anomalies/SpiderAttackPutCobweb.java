package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class SpiderAttackPutCobweb implements Listener {

    //Arañas generan telarañas en los pies
    // Sebas
    @EventHandler
    public void onSpiderAttackPlayer(EntityDamageByEntityEvent event) {

        EntityType damagerType = event.getDamager().getType();
        if (damagerType != EntityType.SPIDER &&
                damagerType != EntityType.CAVE_SPIDER) {
            return;
        }

        if (!(event.getEntity() instanceof Player player)) return;

        Block block = player.getLocation().getBlock();

        if(Math.random() > 0.5) return;

        if (block.getType() == Material.AIR) {
            block.setType(Material.COBWEB);
        }
    }
}
