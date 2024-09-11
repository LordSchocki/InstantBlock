package de.ventilover.instantBlock;

import de.ventilover.instantBlock.Listener.BlockBreakListener;
import de.ventilover.instantBlock.command.TriggerBlockCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class InstantBlock extends JavaPlugin {

    private static InstantBlock instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(),this);
        Bukkit.getCommandMap().register("itemaufsammeln", new TriggerBlockCommand());
        instance.getLogger().info("Started InstantBlock");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance.getLogger().info("Stopped InstantBlock");
    }
}
