package co.juanxxo.juntaAnomalies;

import co.juanxxo.juntaAnomalies.anomalies.AnomaliesListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class JuntaAnomaliesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new AnomaliesListener(), this);
        getLogger().info("Anomalías activadas");
    }

    @Override
    public void onDisable() {
        getLogger().info("Anomalías desactivadas");
    }
}
