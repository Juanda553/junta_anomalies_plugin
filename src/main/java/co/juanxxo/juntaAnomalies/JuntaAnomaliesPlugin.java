package co.juanxxo.juntaAnomalies;

import co.juanxxo.juntaAnomalies.anomalies.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JuntaAnomaliesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // REGISTRAR ANOMALÍAS
        // USAR anomaly(new ClaseDeLaAnomalia()) PARA REGISTRAR CADA ANOMALÍA

        anomaly(new BlastfurnaceExplosive());
        anomaly(new BreakCobwebThreeSpider());
        anomaly(new DiamondOrePoisoned());
        anomaly(new DrownedBuff());
        anomaly(new ExplosiveBeds());
        anomaly(new HoldHotItems());
        anomaly(new MortalButton());
        anomaly(new SpiderAttackPutCobweb());
        anomaly(new ZombieDiamondSpawn());
        anomaly(new ZombieOfDeathPlayer());

        ////////////////////////////////////////////
        getLogger().info("Anomalías activadas");
    }

    @Override
    public void onDisable() {
        getLogger().info("Anomalías desactivadas");
    }

    private void anomaly(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }
}
