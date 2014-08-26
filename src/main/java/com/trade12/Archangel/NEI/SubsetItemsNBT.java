package com.trade12.Archangel.NEI;

import codechicken.nei.api.ItemFilter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Kieran on 26/08/2014.
 */
public class SubsetItemsNBT implements ItemFilter {

    public Item item;

    public SubsetItemsNBT(Item item)
    {
        this.item = item;
    }

    public boolean matches(ItemStack item)
    {
        return (item.hasTagCompound()) && (this.item.equals(item.getItem()));
    }
}
