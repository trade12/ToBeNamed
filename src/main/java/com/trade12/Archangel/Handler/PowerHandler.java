package com.trade12.Archangel.Handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Kieran on 24/08/2014.
 */
public class PowerHandler {

    public static void drainFromBatteryIfPossible(ItemStack itemStack, EntityPlayer player, Item battery)
    {
        if (player.inventory.hasItem(battery))
        {
            for (int ia = 0; ia <= 35; ia++)
            {
                if (player.inventory.getStackInSlot(ia) != null)
                {
                    if(player.inventory.getStackInSlot(ia) == new ItemStack(battery))
                    {
                        if (player.inventory.getStackInSlot(ia).stackTagCompound.getInteger("Charge") > 0)
                        {
                            player.inventory.getStackInSlot(ia).stackTagCompound.setInteger("Charge", player.inventory.getStackInSlot(ia).stackTagCompound.getInteger("Charge")-1);
                            itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge")+1);
                        }
                    }
                }
            }
        }
    }
}
