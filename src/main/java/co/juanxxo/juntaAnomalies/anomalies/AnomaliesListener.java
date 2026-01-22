package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import java.util.EnumSet;
import java.util.Set;

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


    //Arañas generan telarañas en los pies
    @EventHandler
    public void onSpiderAttackPlayer(EntityDamageByEntityEvent event) {

        EntityType damagerType = event.getDamager().getType();
        if (damagerType != EntityType.SPIDER &&
                damagerType != EntityType.CAVE_SPIDER) {
            return;
        }

        if (!(event.getEntity() instanceof Player player)) return;

        Block block = player.getLocation().getBlock();

        if(Math.random() > 0.5) return;

        if (block.getType() == Material.AIR) {
            block.setType(Material.COBWEB);
        }
    }

    //Altohornos explotan al interactuar
    @EventHandler
    public void onBlastFurnaceInteract(PlayerInteractEvent event) {

        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Block block = event.getClickedBlock();
        if (block == null) return;

        if (block.getType() != Material.BLAST_FURNACE) return;

        Player player = event.getPlayer();

        event.setCancelled(true);

        block.setType(Material.AIR);

        block.getWorld().createExplosion(
                block.getLocation().add(0.5, 0.5, 0.5),
                2.0F,   // potencia
                false,  // no prende fuego
                true,   // rompe bloques
                player  // responsable
        );
    }

    //Triple ahogamiento
    @EventHandler
    public void onPlayerDrown(EntityDamageEvent event) {

        if (!(event.getEntity() instanceof Player)) return;

        if (event.getCause() != EntityDamageEvent.DamageCause.DROWNING) return;

        event.setDamage(event.getDamage() * 3);
    }

    //Materiales calientes queman
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

    //Camas explotan en el overworld
    @EventHandler
    public void onBedExplodes(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Block block = event.getClickedBlock();
        if (block == null) return;

        if (!block.getType().name().contains("BED")) return;

        Player player = event.getPlayer();

        event.setCancelled(true);

        block.setType(Material.AIR);

        block.getWorld().createExplosion(
                block.getLocation().add(0.5, 0.5, 0.5),
                2.0F,   // potencia
                false,  // no prende fuego
                true,   // rompe bloques
                player  // responsable
        );
    }

    //Zombies spawnean full diamond (40% de probabilidad)
    @EventHandler
    public void onZombieDiamondArmorSpawn(CreatureSpawnEvent event) {

        if (event.getEntityType() != EntityType.ZOMBIE) return;

        if (Math.random() > 0.4) return;

        Zombie zombie = (Zombie) event.getEntity();
        EntityEquipment eq = zombie.getEquipment();
        if (eq == null) return;

        eq.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
        eq.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        eq.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
        eq.setBoots(new ItemStack(Material.DIAMOND_BOOTS));

        eq.setHelmetDropChance(0f);
        eq.setChestplateDropChance(0f);
        eq.setLeggingsDropChance(0f);
        eq.setBootsDropChance(0f);
    }
}
