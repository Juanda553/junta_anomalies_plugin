package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class CreeperCharged implements Listener {

    // Creepers recargados
    // Sebas
    @EventHandler
    public void onCreeperSpawn(EntitySpawnEvent event) {

        if (!(event.getEntity() instanceof Creeper)) return;

        Creeper creeper = (Creeper) event.getEntity();

        creeper.setPowered(true);

    }
}
