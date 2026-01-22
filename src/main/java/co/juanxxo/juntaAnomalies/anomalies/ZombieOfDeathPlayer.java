package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class ZombieOfDeathPlayer implements Listener {

    // Cuando un jugador muere, genera un zombie en su lugar de muerte
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Location deathLocation = player.getLocation();

        Zombie zombie = deathLocation.getWorld().spawn(deathLocation, Zombie.class);
        zombie.setCustomName(player.getName());
        zombie.setBaby(false);
        zombie.setCanPickupItems(true);
        zombie.setCustomNameVisible(true);
    }
}
