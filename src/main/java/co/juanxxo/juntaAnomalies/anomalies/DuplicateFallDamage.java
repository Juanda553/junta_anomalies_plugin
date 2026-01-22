package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DuplicateFallDamage implements Listener {

    // Daño de caida duplicado
    // Sebas
    @EventHandler
    public void onFallDamage(EntityDamageEvent event) {

        if (!(event.getEntity() instanceof Player)) return;

        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) return;

        event.setDamage(event.getDamage() * 2);
    }

}