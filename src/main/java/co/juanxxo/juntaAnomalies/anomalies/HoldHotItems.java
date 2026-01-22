package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

import java.util.EnumSet;
import java.util.Set;

public class HoldHotItems implements Listener {

    // Materiales calientes queman
    // Sebas
    @EventHandler
    public void onHoldHotItem(PlayerItemHeldEvent event) {

        Set<Material> HOT_ITEMS = EnumSet.of(
                Material.LAVA_BUCKET,
                Material.MAGMA_BLOCK,
                Material.BLAZE_ROD,
                Material.FIRE_CHARGE,
                Material.CAMPFIRE,
                Material.MAGMA_CREAM,
                Material.BLAZE_POWDER);

        Player player = event.getPlayer();

        ItemStack item = player.getInventory().getItem(event.getNewSlot());
        if (item == null) return;

        if (!HOT_ITEMS.contains(item.getType())) return;

        player.setFireTicks(60);
    }
}
