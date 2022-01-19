package fr.asvadia.aantiafk;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AntiAFK extends BukkitRunnable {
    private static final int AFK_TIME = 900;
    private final Player player;
    private Location location;
    private int afkTime;

    public AntiAFK(Player player) {
        this.player = player;
        this.location = player.getLocation();
        this.afkTime = 0;
    }

    @Override
    public void run() {
        if (!player.isOnline())
            cancel();

        if(location.equals(player.getLocation())) {
            if (++afkTime >= AFK_TIME)
                        player.kickPlayer("§6§lAnti AFK §f» §7Vous avez été kick pour afk !");
        } else if (afkTime > 0)
            afkTime = 0;
        location = player.getLocation();
    }
}
