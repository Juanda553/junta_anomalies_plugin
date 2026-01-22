package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class DiamondOrePoisoned implements Listener {

    //Juanda
    @EventHandler
    public void onPlayerBreakDiamond(BlockBreakEvent event) {
        Material type = event.getBlock().getType();
        if (type != Material.DIAMOND_ORE && type != Material.DEEPSLATE_DIAMOND_ORE) return;
        Player player = event.getPlayer();
        if (player.hasPotionEffect(org.bukkit.potion.PotionEffectType.POISON)) return;

        if (Math.random() > 0.3) return; // 30% de probabilidad
        player.addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.POISON, 60, 0));
    }
}
