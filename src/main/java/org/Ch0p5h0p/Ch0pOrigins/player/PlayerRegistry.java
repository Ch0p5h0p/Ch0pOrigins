package org.Ch0p5h0p.Ch0pOrigins.player;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;

public final class PlayerRegistry {
    // Stores all player UUIDs as values to reference playerstates.
    private static final Map<UUID, PlayerState> players = new HashMap<>();

    public static void registerPlayer(PlayerState player) {
        players.put(player.getUUID(), player);
    }

    public static PlayerState getPlayerFromUUID(UUID uuid) {
        return players.get(uuid);
    }

    public static Collection<PlayerState> getAllPlayerStates() {
        return players.values();
    }

    public static boolean exists(UUID uuid) {
        if (players.containsKey(uuid)) {
            return true;
        } else {
            return false;
        }
    }
}