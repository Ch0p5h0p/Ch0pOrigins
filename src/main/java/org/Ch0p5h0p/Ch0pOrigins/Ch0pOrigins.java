package org.Ch0p5h0p.Ch0pOrigins;

import org.Ch0p5h0p.Ch0pOrigins.player.PlayerRegistry;
import org.Ch0p5h0p.Ch0pOrigins.player.PlayerState;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.Ch0p5h0p.Ch0pOrigins.player.*;
public final class Ch0pOrigins extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Origins Ascendants plugin loaded.");

        getServer().getPluginManager().registerEvents(new JoinListener(), this);

        getServer().getPluginManager().registerEvents(new AbilityListener(), this);
        getLogger().info("Loaded the ability listener");

        this.getCommand("setorigin").setExecutor(new SetOriginCommand());
        getLogger().info("Loaded setorigin command");

        Bukkit.getScheduler().runTaskTimer(this, ()->{
            for(PlayerState state : PlayerRegistry.getAllPlayerStates()) {
                if (state != null) {
                    state.getOrigin().tick();
                }
            }
        },1L,1L);
    }

    @Override
    public void onDisable() {
        getLogger().info("Origins Ascendants plugin unloaded.");
    }

}
