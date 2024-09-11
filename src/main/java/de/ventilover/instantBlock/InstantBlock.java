package de.ventilover.instantBlock;

import org.bukkit.plugin.java.JavaPlugin;

public final class InstantBlock extends JavaPlugin {

    private static InstantBlock instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
