package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class DoorInstantKill implements Listener {

    // Puertas Dañinas
    // Sebas
    @EventHandler
    public void onPlayerOpenDoor(PlayerInteractEvent event){

        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        if (event.getClickedBlock() == null) return;

        Material type = event.getClickedBlock().getType();

        if (!type.name().contains("DOOR")) return;

        Player player = event.getPlayer();

        player.damage(1000000.0);

    }
}
