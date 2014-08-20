package com.trade12.Archangel.Items;

import com.trade12.Archangel.Items.Angel.ItemAngelBelt;
import com.trade12.Archangel.Items.Angel.ItemAngelPendant;
import com.trade12.Archangel.Items.Angel.ItemAngelPower;
import com.trade12.Archangel.Items.Angel.ItemAngelRing;
import com.trade12.Archangel.Items.Nathaniel.ItemNathanielBelt;
import com.trade12.Archangel.Items.Nathaniel.ItemNathanielPendant;
import com.trade12.Archangel.Items.Nathaniel.ItemNathanielPower;
import com.trade12.Archangel.Items.Nathaniel.ItemNathanielRing;
import com.trade12.Archangel.Items.Sariel.ItemSarielBelt;
import com.trade12.Archangel.Items.Sariel.ItemSarielPendant;
import com.trade12.Archangel.Items.Sariel.ItemSarielPower;
import com.trade12.Archangel.Items.Sariel.ItemSarielRing;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by kieran on 13/08/2014.
 */
public class ItemLoader {

    public static Item angelPendant, angelRing, angelBelt;
    public static Item angelPower;
    public static Item sarielRing, sarielPendant, sarielBelt;
    public static Item sarielPower;
    public static Item nathanielPendant, nathanielRing, nathanielBelt;
    public static Item nathanielPower;
    public static Item ostracheFeather;


    public static void load()
    {
        angelRing = new ItemAngelRing();
        angelPower = new ItemAngelPower();
        angelBelt = new ItemAngelBelt();
        angelPendant = new ItemAngelPendant();

        sarielRing = new ItemSarielRing();
        sarielPower = new ItemSarielPower();
        sarielPendant = new ItemSarielPendant();
        sarielBelt = new ItemSarielBelt();

        nathanielPendant = new ItemNathanielPendant();
        nathanielRing = new ItemNathanielRing();
        nathanielBelt = new ItemNathanielBelt();
        nathanielPower = new ItemNathanielPower();


        GameRegistry.registerItem(angelPendant, "Archangel_angelPendant");
        GameRegistry.registerItem(angelRing, "Archangel_angelRing");
        GameRegistry.registerItem(angelBelt, "Archangel_angelBelt");
        GameRegistry.registerItem(angelPower, "Archangel_angelPower");

        GameRegistry.registerItem(sarielRing, "Archangel_sarielRing");
        GameRegistry.registerItem(sarielBelt, "Archangel_sarielBelt");
        GameRegistry.registerItem(sarielPendant, "Archangel_sarielPendant");
        GameRegistry.registerItem(sarielPower, "Archangel_sarielPower");

        GameRegistry.registerItem(nathanielPendant, "Archangel_nathanielPendant");
        GameRegistry.registerItem(nathanielRing, "Archangel_nathanielRing");
        GameRegistry.registerItem(nathanielBelt, "Archangel_nathanielBelt");
        GameRegistry.registerItem(nathanielPower, "Archangel_nathanielPower");


    }
}
