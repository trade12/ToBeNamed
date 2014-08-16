package com.trade12.Archangel.Items;

import com.trade12.Archangel.Items.Angel.ItemAngelBelt;
import com.trade12.Archangel.Items.Angel.ItemAngelPendant;
import com.trade12.Archangel.Items.Angel.ItemAngelPower;
import com.trade12.Archangel.Items.Angel.ItemAngelRing;
import com.trade12.Archangel.Items.Sariel.ItemSarielPower;
import com.trade12.Archangel.Items.Sariel.ItemSarielRing;
import net.minecraft.item.Item;

/**
 * Created by kieran on 13/08/2014.
 */
public class ItemLoader {

    public static Item angelPendant, angelRing, angelBelt;
    public static Item AngelPower;
    public static Item sarielRing, sarielPendant, sarielBelt;
    public static Item sarielPower;


    public static void load()
    {
        angelRing = new ItemAngelRing();
        AngelPower = new ItemAngelPower();
        angelBelt = new ItemAngelBelt();
        angelPendant = new ItemAngelPendant();
        sarielRing = new ItemSarielRing();
        sarielPower = new ItemSarielPower();
    }
}
