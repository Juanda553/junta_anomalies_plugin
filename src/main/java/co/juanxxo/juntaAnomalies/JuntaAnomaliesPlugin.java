package co.juanxxo.juntaAnomalies;

import co.juanxxo.juntaAnomalies.anomalies.AnomaliesListener;
import co.juanxxo.juntaAnomalies.anomalies.ZombieOfDeathPlayer;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JuntaAnomaliesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // REGISTRAR ANOMALÍAS
        // USAR anomaly(new ClaseDeLaAnomalia()) PARA REGISTRAR CADA ANOMALÍA

        anomaly(new AnomaliesListener());
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
