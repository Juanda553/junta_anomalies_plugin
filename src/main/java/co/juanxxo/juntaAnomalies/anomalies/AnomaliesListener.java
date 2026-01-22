package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class AnomaliesListener implements Listener {
    final boolean ENABLE_BUTTON_KILL = true;

    // PRESIONAR BOTON MATA
    @EventHandler
    public void onPlayerButtonPress(PlayerInteractEvent event) {
        if (ENABLE_BUTTON_KILL == false) return;

        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (event.getClickedBlock() == null) return;

        Material type = event.getClickedBlock().getType();
        if (!type.name().contains("BUTTON")) return;

        Player player = event.getPlayer();
        player.damage(553000000.0);
    }

    // Romper telaraña genera 3 cave spiders
    @EventHandler
    public void onPlayerBreakCobweb(BlockBreakEvent event) {
        if (event.getBlock().getType() != Material.COBWEB) return;

        Player player = event.getPlayer();
        event.getBlock().getWorld().spawn(event.getBlock().getLocation(), org.bukkit.entity.CaveSpider.class);
        event.getBlock().getWorld().spawn(event.getBlock().getLocation(), org.bukkit.entity.CaveSpider.class);
        event.getBlock().getWorld().spawn(event.getBlock().getLocation(), org.bukkit.entity.CaveSpider.class);
    }

    @EventHandler
    //Arañas generan telarañas en los pies
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
