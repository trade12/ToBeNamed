package com.trade12.Archangel.Items.Ariel;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.lib.Ref;
import net.minecraft.item.Item;

/**
 * Created by Kieran on 21/08/2014.
 */
public class ItemArielPower extends Item {

    public ItemArielPower()
    {
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_ARIEL_POWER);
    }
}
