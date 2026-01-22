package co.juanxxo.juntaAnomalies.anomalies;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class ZombieDiamondSpawn implements Listener {

    //Zombies spawnean full diamond (40% de probabilidad)
    // Sebas
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
