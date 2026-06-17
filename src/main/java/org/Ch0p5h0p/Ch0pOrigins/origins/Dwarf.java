package org.Ch0p5h0p.Ch0pOrigins.origins;

import org.Ch0p5h0p.Ch0pOrigins.gui.AbilityDoc;
import org.Ch0p5h0p.Ch0pOrigins.player.PlayerState;

public class Dwarf extends Origin {
    protected Dwarf(PlayerState state) {
        super(state);

        this.primaryAbilityDoc=new AbilityDoc(
                "Ore Sense",
                "Find the highest value ore in a 32 block radius and gain information on its location"
        );
        this.secondaryAbilityDoc=new AbilityDoc(
                "Powder Keg",
                "Summon TNT"
        );
        this.crouchAbilityDoc=new AbilityDoc(
                "Headlamp",
                "Toggle Night Vision"
        );
        this.passiveAbilityDoc=new AbilityDoc(
                "Miner",
                "Gain haste, ores drop double when mined"
        );
    }
}
