package fr.asvadia.aantiafk;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class AntiAFKListeners implements Listener {
    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission("astaff"))
            new AntiAFK(event.getPlayer())
                    .runTaskTimer(Main.getInstance(), 20, 20);
    }
}
