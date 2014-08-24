package com.trade12.Archangel.Handler;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Kieran on 24/08/2014.
 */
public class InventoryHandler {

    public static void convertItemToItemInPlayerInventory(EntityPlayer player, ItemStack bauble, int cost, Item from, Item to)
    {
        if (player.inventory.hasItem(from) && ChargeHandler.hasEnoughChargeForOperation(bauble, cost))
        {
            for (int ia = 0; ia <= 35; ia++)
            {
                if (player.inventory.getStackInSlot(ia) != null)
                {
                    if (player.inventory.getStackInSlot(ia).getItem() == from)
                    {
                        player.inventory.setInventorySlotContents(ia, new ItemStack(to, 1, player.inventory.getStackInSlot(ia).stackSize));
                        ChargeHandler.removeCharge(bauble, cost);
                    }
                }
            }
        }
    }

    public static void convertBlockToBlockInPlayerInventory(EntityPlayer player, ItemStack bauble, int cost, Block from, Block to)
    {
        if (player.inventory.hasItem(new ItemStack(from).getItem()) && ChargeHandler.hasEnoughChargeForOperation(bauble, cost))
        {
            for (int ia = 0; ia <= 35; ia++)
            {
                if (player.inventory.getStackInSlot(ia) != null)
                {
                    if (player.inventory.getStackInSlot(ia).getItem() == new ItemStack(from).getItem())
                    {
                        player.inventory.setInventorySlotContents(ia, new ItemStack(to, 1, player.inventory.getStackInSlot(ia).stackSize));
                        ChargeHandler.removeCharge(bauble, cost);
                    }
                }
            }
        }
    }
}
