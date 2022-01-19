package fr.asvadia.aantiafk;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            new AntiAFK(player)
                    .runTaskTimer(Main.getInstance(), 20, 20);
        });

        getServer().getPluginManager().registerEvents(new AntiAFKListeners(), this);
    }
}
