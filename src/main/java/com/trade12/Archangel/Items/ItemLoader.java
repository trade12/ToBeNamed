package com.trade12.Archangel.Items;

import com.trade12.Archangel.Items.Angel.ItemAngelPower;
import com.trade12.Archangel.Items.Angel.ItemAngelRing;
import net.minecraft.item.Item;

/**
 * Created by kieran on 13/08/2014.
 */
public class ItemLoader {

    public static Item angelPendant, angelRing, angelBelt;
    public static Item AngelPower;


    public static void load()
    {
        angelRing = new ItemAngelRing();
        AngelPower = new ItemAngelPower();
    }
}
