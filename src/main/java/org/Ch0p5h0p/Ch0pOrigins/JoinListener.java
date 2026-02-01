package org.Ch0p5h0p.Ch0pOrigins;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.Ch0p5h0p.Ch0pOrigins.origins.OriginFactory;
import org.Ch0p5h0p.Ch0pOrigins.player.PlayerRegistry;
import org.Ch0p5h0p.Ch0pOrigins.player.PlayerState;

import java.util.UUID;

import static org.apache.logging.log4j.LogManager.getLogger;

public class JoinListener implements Listener {
    // Handles join logic. The below function executes once.
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        // set up an origins and playerstate
        UUID uuid=e.getPlayer().getUniqueId();
        if (PlayerRegistry.exists(uuid)) {
            getLogger().info("Player "+e.getPlayer().getName()+" exists");
            return;
        } else {
            getLogger().info("Player "+e.getPlayer().getName()+" doesn't have a PlayerState, creating one...");
        }
        PlayerState p = new PlayerState(uuid);
        p.setOrigin(OriginFactory.createOrigin("HUMAN", p));
        PlayerRegistry.registerPlayer(p);
        getLogger().info("Creating playerstate for Ch0p5h0p");
    }
}
