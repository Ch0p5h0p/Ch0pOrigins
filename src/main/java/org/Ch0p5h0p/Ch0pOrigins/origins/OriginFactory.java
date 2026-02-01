package org.Ch0p5h0p.Ch0pOrigins.origins;

import net.kyori.adventure.text.Component;
import org.Ch0p5h0p.Ch0pOrigins.player.PlayerState;
import org.originsascendants.originAscendants.player.*;

public class OriginFactory {
    public static Origin createOrigin(String typeName, PlayerState state) {
        switch (typeName) {
            case "HUMAN":
                state.toBukkit().sendMessage(Component.text("Creating Human origin..."));
                return new Human(state);
            case "ELYTRIAN":
                state.toBukkit().sendMessage(Component.text("Creating Elytrian origin..."));
                return new Elytrian(state);
            default: throw new IllegalArgumentException("Type \""+typeName+"\" doesn't exist.");
        }
    }
}
