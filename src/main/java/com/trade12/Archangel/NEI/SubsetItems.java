package com.trade12.Archangel.NEI;

import codechicken.nei.api.ItemFilter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

/**
 * Created by Kieran on 26/08/2014.
 */
public class SubsetItems implements ItemFilter {

    public ArrayList<Item> items = new ArrayList();

    public SubsetItems(Item... items)
    {
        for (Item i : items) {
            if (i != null) {
                this.items.add(i);
            }
        }
    }

    public SubsetItems addItem(Item item)
    {
        this.items.add(item);
        return this;
    }

    public boolean matches(ItemStack item)
    {
        for (Item i : this.items) {
            if (i.equals(item.getItem())) {
                return true;
            }
        }
        return false;
    }
}
