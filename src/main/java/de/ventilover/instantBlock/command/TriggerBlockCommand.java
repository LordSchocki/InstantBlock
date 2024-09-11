package de.ventilover.instantBlock.command;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.UUID;

public class TriggerBlockCommand extends Command {
    public static final ArrayList<UUID> triggeredPlayers = new ArrayList<>();

    public TriggerBlockCommand() {
        super("itemaufsammeln");
        this.usageMessage = "/itemaufsammeln";
        this.description = "Benutzen ja danke";
    }


    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
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
