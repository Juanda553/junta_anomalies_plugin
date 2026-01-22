package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class MortalButton implements Listener {

    // PRESIONAR BOTON MATA
    // Juanda
    @EventHandler
    public void onPlayerButtonPress(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (event.getClickedBlock() == null) return;

        Material type = event.getClickedBlock().getType();
        if (!type.name().contains("BUTTON")) return;

        Player player = event.getPlayer();
        player.damage(553000000.0);
    }
}
