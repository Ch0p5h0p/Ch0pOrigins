package org.Ch0p5h0p.Ch0pOrigins.origins;

import net.kyori.adventure.text.Component;
import org.Ch0p5h0p.Ch0pOrigins.gui.AbilityDoc;
import org.Ch0p5h0p.Ch0pOrigins.player.PlayerState;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Glitch extends Origin {

    private final int primaryCooldown=20*15;
    private final int secondaryCooldown=20*5;
    private int primaryCooldownCounter=primaryCooldown;
    private int secondaryCooldownCounter=secondaryCooldown;

    private Particle.DustOptions redDustAmbient = new Particle.DustOptions(Color.fromRGB(255, 0, 0), 0.5f);
    private Particle.DustOptions redDustBig = new Particle.DustOptions(Color.fromRGB(255, 0, 0), 0.5f);
    private Particle.DustOptions blueDustAmbient = new Particle.DustOptions(Color.fromRGB(0, 255, 255), 0.5f);
    private Particle.DustOptions blueDustBig = new Particle.DustOptions(Color.fromRGB(0, 255, 255), 0.5f);

    public Glitch(PlayerState state) {
        super(state);

        this.primaryAbilityDoc = new AbilityDoc(
                "D1sp?l4ce",
                "Warp to a random position in a 32 block radius"
        );
        this.secondaryAbilityDoc = new AbilityDoc(
                "R3ro?ll",
                "Randomize your health between 1 and 15 hearts"
        );
        this.crouchAbilityDoc = new AbilityDoc(
                "0bfu5ca?te",
                "Become invisible when crouching"
        );
        this.passiveAbilityDoc = new AbilityDoc("-","-");
    }

    @Override
    public void primaryAbility() {
        if (primaryCooldownCounter < primaryCooldown) return;
        double x = (Math.random()*64)-32;
        double z = (Math.random()*64)-32;
        Player bukkitPlayer = this.state.toBukkit();

        double y = getSafeSurface(bukkitPlayer.getWorld(), bukkitPlayer.getX()+x, bukkitPlayer.getZ()+z, bukkitPlayer.getY());
        if (y == -127) {
            bukkitPlayer.sendActionBar(Component.text("D1sp?l4ce... FA1?LED."));
            return;
        }

        bukkitPlayer.getWorld().spawnParticle(Particle.DUST, bukkitPlayer.getLocation(), 10, redDustBig);
        bukkitPlayer.getWorld().spawnParticle(Particle.DUST, bukkitPlayer.getLocation(), 10, blueDustBig);

        bukkitPlayer.teleport(new Location(bukkitPlayer.getWorld(), x, y, z));
        bukkitPlayer.getWorld().spawnParticle(Particle.DUST, bukkitPlayer.getLocation(), 10, redDustBig);
        bukkitPlayer.getWorld().spawnParticle(Particle.DUST, bukkitPlayer.getLocation(), 10, blueDustBig);
        bukkitPlayer.sendActionBar(Component.text("D1sp?l4ce... EX3C?UTE."));
    }

    public double getSafeSurface(World world, double x, double z, double currentY) {
        double surface = -127; // void damage height. we can be SURE there wont be any world overlap here.

        // Check within a 32 block radius
        for (int y = (int)currentY+32; y >= currentY-32; y--) {
            Block block = world.getBlockAt((int)x, y, (int)z);

            if (block.getType().isAir() && world.getBlockAt((int)x, y-1, (int)z).getType().isSolid()) {
                surface = y;
                break;
            }
        }
        return surface;
    }

    @Override
    public void secondaryAbility() {
        if (secondaryCooldownCounter < secondaryCooldown) return;
        this.state.toBukkit().sendActionBar(Component.text("R3ro?ll... EX3C?UTE."));
        this.state.toBukkit().setHealth((Math.random()*28)+2);
    }

    @Override
    public void tick() {
        if (primaryCooldownCounter < primaryCooldown) primaryCooldownCounter++;
        if (secondaryCooldownCounter < secondaryCooldown) secondaryCooldownCounter++;
    }

    @Override
    public void crouchOn() {
        this.state.toBukkit().sendPotionEffectChange(this.state.toBukkit(), new PotionEffect(PotionEffectType.INVISIBILITY, 3, 1, true, false));
    }

    @Override
    public void crouchOff() {

    }
}
