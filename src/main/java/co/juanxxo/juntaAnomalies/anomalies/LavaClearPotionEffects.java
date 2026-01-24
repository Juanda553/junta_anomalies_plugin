package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;

public class LavaClearPotionEffects implements Listener {

    // Lava quita efectos de pociones
    // Sebas
    @EventHandler
    public void onPlayerTouchLava(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        Material block = player.getLocation().getBlock().getType();

        if (block == Material.LAVA) {

            for (PotionEffect effect : player.getActivePotionEffects()) {
                player.removePotionEffect(effect.getType());
            }
        }
    }
}