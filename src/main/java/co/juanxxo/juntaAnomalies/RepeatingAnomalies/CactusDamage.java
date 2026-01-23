package co.juanxxo.juntaAnomalies.RepeatingAnomalies;

import co.juanxxo.juntaAnomalies.utils.RepeatingAnomaly;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CactusDamage implements RepeatingAnomaly {


    @Override
    public void start(JavaPlugin plugin) {
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {

            for (Player player : Bukkit.getOnlinePlayers()) {

                if (player.getInventory().getItemInMainHand().getType() == Material.CACTUS) {
                    player.damage(1.0); // medio corazón
                }
            }

        }, 20L, 10L); // cada segundo
    }
}


