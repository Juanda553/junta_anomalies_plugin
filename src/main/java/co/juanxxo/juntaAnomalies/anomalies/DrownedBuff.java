package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DrownedBuff implements Listener {

    // Triple ahogamiento
    // Sebas
    @EventHandler
    public void onPlayerDrown(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (event.getCause() != EntityDamageEvent.DamageCause.DROWNING) return;

        event.setDamage(event.getDamage() * 3);
    }
}
