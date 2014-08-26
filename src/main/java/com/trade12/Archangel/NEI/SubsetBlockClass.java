package com.trade12.Archangel.NEI;

import codechicken.nei.api.ItemFilter;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * Created by Kieran on 26/08/2014.
 */
public class SubsetBlockClass implements ItemFilter {

    public Class<? extends Block> base;

    public SubsetBlockClass(Class<? extends Block> base)
    {
        this.base = base;
    }

    public boolean matches(ItemStack item)
    {
        return this.base.equals(Block.getBlockFromItem(item.getItem()).getClass());
    }
}
