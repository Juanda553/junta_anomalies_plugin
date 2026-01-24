package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SkeletonWitherChance implements Listener {

    // 40% de probabilidad que los esqueletos sean whither
    // Sebas
    @EventHandler
    public void onSkeletonSpawn(CreatureSpawnEvent event) {

        if (event.getEntityType() != EntityType.SKELETON) return;

        if (Math.random() > 0.40) return;

        Skeleton skeleton = (Skeleton) event.getEntity();
        Location loc = skeleton.getLocation();

        skeleton.remove();

        loc.getWorld().spawnEntity(loc, EntityType.WITHER_SKELETON);
    }
}
