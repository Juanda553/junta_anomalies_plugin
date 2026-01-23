package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class FireEternity implements Listener {

    @EventHandler
    public void onPlayerFire(EntityDamageEvent event) {

        if(!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();

        DamageCause cause = event.getCause();

        if(!(cause == DamageCause.FIRE_TICK)) return;

        player.sendMessage(cause.toString());

        player.setFireTicks(10000);

    }

}
