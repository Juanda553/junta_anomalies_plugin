package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EnderPearlPoison implements Listener {

    // Aplicar veneno al usar EnderPearl
    // Sebas
    @EventHandler
    public void onEnderPearlThrow(ProjectileLaunchEvent event) {

        if (!(event.getEntity() instanceof EnderPearl)) return;

        if (!(event.getEntity().getShooter() instanceof Player)) return;

        Player player = (Player) event.getEntity().getShooter();

        player.addPotionEffect(
                new PotionEffect(
                        PotionEffectType.POISON,
                        20 * 5,
                        0
                )
        );
    }
}
