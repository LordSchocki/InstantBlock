package de.ventilover.instantBlock.Listener;

import de.ventilover.instantBlock.command.TriggerBlockCommand;
import io.papermc.paper.event.block.BlockBreakBlockEvent;
import org.bukkit.Material;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){

        if (event.getBlock().getState() instanceof Container || !TriggerBlockCommand.triggeredPlayers.contains(event.getPlayer().getUniqueId())){
            return;
        }

        Player player = event.getPlayer();

        ItemStack tool = player.getInventory().getItemInMainHand();

        event.setDropItems(false); //we handle the dropping manually

        Collection<ItemStack> drops = event.getBlock().getDrops(tool);

        for (ItemStack item : drops){

            if (canHoldItem(player, item)){
                player.getInventory().addItem(item);
            }

            else{
                event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), item);
            }


        }


    }

    //So this method checks if the broken item can get into the player inventory
    private boolean canHoldItem(Player player, ItemStack itemDropped){

        int itemAmount = itemDropped.getAmount();

        //let's loop over every item of the player


        for (ItemStack item : player.getInventory().getContents()){

            if (item == null || item.getType() == Material.AIR){
                return true; //if they have at least one empty slot, they can hold
            }

            if (item.getType() == itemDropped.getType()){
                //if they have the same item, it can stack
                if (item.getMaxStackSize() == 1){ //can stack here
                    continue;
                }

                int storeAmount = item.getMaxStackSize() - item.getAmount(); //get the max amount store able

                itemAmount -= storeAmount; //then remove how much we can store
            }

            if (itemAmount <= 0){ //if this value is reached, we can store it
                return true;
            }


        }
        //reached here if the item cant be stored
        return false;
    }

    @EventHandler
    public void onBlockBreakBlock(BlockBreakBlockEvent event){

    }


}
