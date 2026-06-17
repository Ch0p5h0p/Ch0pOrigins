package org.Ch0p5h0p.Ch0pOrigins.origins;

import org.Ch0p5h0p.Ch0pOrigins.gui.AbilityDoc;
import org.Ch0p5h0p.Ch0pOrigins.player.PlayerState;

public abstract class Origin {
    protected final PlayerState state;

    // These are used in the selection GUI to hold information about the origin
    public AbilityDoc primaryAbilityDoc;
    public AbilityDoc secondaryAbilityDoc;
    public AbilityDoc crouchAbilityDoc;
    public AbilityDoc passiveAbilityDoc;

    /* Once I figure out all of the stats that each origin should have,
       I'll put uninitialized variables and whatnot here. */

    protected Origin(PlayerState state) {
        this.state = state;
    }

    //tick logic (aka passive logic)
    public void tick(){};

    // Handled automatically
    public void primaryAbility(){};
    public void secondaryAbility(){};

    // Executes on crouch
    public void crouchOn(){};
    // Executes on crouch release
    public void crouchOff(){}
}
