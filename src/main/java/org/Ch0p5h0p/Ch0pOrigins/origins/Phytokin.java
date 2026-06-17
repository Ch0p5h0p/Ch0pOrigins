package org.Ch0p5h0p.Ch0pOrigins.origins;

import org.Ch0p5h0p.Ch0pOrigins.gui.AbilityDoc;
import org.Ch0p5h0p.Ch0pOrigins.player.PlayerState;

public class Phytokin extends Origin {
    public Phytokin(PlayerState state) {
        super(state);

        this.primaryAbilityDoc=new AbilityDoc(
                "Hardened Bark",
                "Gain resistance and strength"
        );
        this.secondaryAbilityDoc=new AbilityDoc(
                "Natural Blessing",
                "Grow all crops within a 5 block radius"
        );
        this.crouchAbilityDoc=new AbilityDoc("-","-");
        this.passiveAbilityDoc=new AbilityDoc(
                "Verdant",
                "Gain saturation and regeneration in the sunlight but become slower"
        );
    }
}
