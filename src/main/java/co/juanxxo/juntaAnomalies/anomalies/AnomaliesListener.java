package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class AnomaliesListener implements Listener {
    final boolean ENABLE_BUTTON_KILL = true;

    // PRESIONAR BOTON MATA
    @EventHandler
    public void onPlayerButtonPress(PlayerInteractEvent event) {
        if (ENABLE_BUTTON_KILL == false) return;

        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (event.getClickedBlock() == null) return;

        Material type = event.getClickedBlock().getType();
        if (!type.name().contains("BUTTON")) return;

        Player player = event.getPlayer();
        player.damage(553000000.0);
    }

    // Romper telaraña genera 3 cave spiders
    @EventHandler
    public void onPlayerBreakCobweb(BlockBreakEvent event) {
        if (event.getBlock().getType() != Material.COBWEB) return;

        Player player = event.getPlayer();
        event.getBlock().getWorld().spawn(event.getBlock().getLocation(), org.bukkit.entity.CaveSpider.class);
        event.getBlock().getWorld().spawn(event.getBlock().getLocation(), org.bukkit.entity.CaveSpider.class);
        event.getBlock().getWorld().spawn(event.getBlock().getLocation(), org.bukkit.entity.CaveSpider.class);
    }

    // ROMPER DIAMANTE o DEEPSLATE_DIAMOND APLICA VENENO
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
