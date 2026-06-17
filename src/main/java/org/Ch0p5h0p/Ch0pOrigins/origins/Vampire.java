package org.Ch0p5h0p.Ch0pOrigins.origins;

import org.Ch0p5h0p.Ch0pOrigins.gui.AbilityDoc;
import org.Ch0p5h0p.Ch0pOrigins.player.PlayerState;

public class Vampire extends Origin {
    public Vampire(PlayerState state) {
        super(state);

        this.primaryAbilityDoc=new AbilityDoc(
                "Into Shadows",
                "Gain invis, speed, and become sun-resistant"
        );
        this.secondaryAbilityDoc=new AbilityDoc(
                "Sharpened Fangs",
                "Temporarily buff lifesteal"
        );
        this.crouchAbilityDoc=new AbilityDoc("-","-");
        this.passiveAbilityDoc=new AbilityDoc(
                "Vampirism",
                "Gain a quarter heart every time you attack an entity, but lose saturation and health in the sun"
        );
    }
}
