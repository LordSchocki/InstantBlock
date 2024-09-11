package de.ventilover.instantBlock.command;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.UUID;

public class TriggerBlockCommand implements CommandExecutor {
    private static final ArrayList<UUID> triggeredPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player  player) {

            if (triggeredPlayers.contains(player.getUniqueId())){
                triggeredPlayers.remove(player.getUniqueId());
                player.sendMessage(Component.text("Items gehen nicht mehr ins Inventar"));
            }
            else{
                triggeredPlayers.add(player.getUniqueId());
                player.sendMessage(Component.text("Items gehen ins Inventar"));
            }


        }
        return true;
    }
}
