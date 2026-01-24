package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class CactusDamageMultiplier implements Listener {

    // Cactus hace 5 veces mas dano
    // Sebas
    @EventHandler
    public void onCactusDamage(EntityDamageEvent event) {

        if (event.getCause() != EntityDamageEvent.DamageCause.CONTACT) return;

        double damage = event.getDamage();

        event.setDamage(damage * 5);
    }
}
