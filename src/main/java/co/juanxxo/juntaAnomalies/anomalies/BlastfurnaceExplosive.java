package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlastfurnaceExplosive implements Listener {

    //Altohornos explotan al interactuar
    // Sebas
    @EventHandler
    public void onBlastFurnaceInteract(PlayerInteractEvent event) {

        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        Block block = event.getClickedBlock();
        if (block == null) return;
        if (block.getType() != Material.BLAST_FURNACE) return;

        Player player = event.getPlayer();
        event.setCancelled(true);
        block.setType(Material.AIR);

        block.getWorld().createExplosion(
                block.getLocation().add(0.5, 0.5, 0.5),
                3.0F,   // potencia
                false,  // no prende fuego
                true,   // rompe bloques
                player  // responsable
        );
    }
}
