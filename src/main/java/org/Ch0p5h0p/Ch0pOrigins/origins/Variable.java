package org.Ch0p5h0p.Ch0pOrigins.origins;

import org.Ch0p5h0p.Ch0pOrigins.gui.AbilityDoc;
import org.Ch0p5h0p.Ch0pOrigins.player.PlayerState;

public class Variable extends Origin {
    public Variable(PlayerState state) {
        super(state);

        this.primaryAbilityDoc=new AbilityDoc(
                "Accretion",
                "Sacrifice experience to increase size"
        );
        this.secondaryAbilityDoc=new AbilityDoc(
                "Dissipation",
                "Gain experience at the cost of size"
        );
        this.crouchAbilityDoc=new AbilityDoc("-","-");
        this.passiveAbilityDoc=new AbilityDoc(
                "Variable",
                "Gain strength and haste at the cost of speed for higher sizes, but gain speed and feather falling at the cost of strength for smaller sizes"
        );
    }
}
