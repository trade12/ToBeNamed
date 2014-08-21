package com.trade12.Archangel.Items;

import com.trade12.Archangel.Items.Angel.ItemAngelBelt;
import com.trade12.Archangel.Items.Angel.ItemAngelPendant;
import com.trade12.Archangel.Items.Angel.ItemAngelPower;
import com.trade12.Archangel.Items.Angel.ItemAngelRing;
import com.trade12.Archangel.Items.Ariel.ItemArielBelt;
import com.trade12.Archangel.Items.Ariel.ItemArielPendant;
import com.trade12.Archangel.Items.Ariel.ItemArielPower;
import com.trade12.Archangel.Items.Ariel.ItemArielRing;
import com.trade12.Archangel.Items.Nathaniel.*;
import com.trade12.Archangel.Items.Sariel.ItemSarielBelt;
import com.trade12.Archangel.Items.Sariel.ItemSarielPendant;
import com.trade12.Archangel.Items.Sariel.ItemSarielPower;
import com.trade12.Archangel.Items.Sariel.ItemSarielRing;
import com.trade12.Archangel.Items.SubItems.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by kieran on 13/08/2014.
 */
public class ItemLoader {

    public static Item angelPendant, angelRing, angelBelt;
    public static Item sarielRing, sarielPendant, sarielBelt;
    public static Item nathanielPendant, nathanielRing, nathanielBelt;
    public static Item arielPendant, arielRing, arielBelt;
    public static Item arielPower, sarielPower, angelPower, nathanielPower;
    public static Item nathanielStone;

    public static Item empoweredFoucs, heavensDwelling,ostracheFeather;
    public static Item basicBelt, basicRing, basicPendant;


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
        nathanielStone = new ItemNathanielStone();

        arielPower = new ItemArielPower();
        arielBelt = new ItemArielBelt();
        arielPendant = new ItemArielPendant();
        arielRing = new ItemArielRing();

        basicRing = new ItemBasicRing();
        basicBelt = new ItemBasicBelt();
        basicPendant = new ItemBasicPendant();

        empoweredFoucs = new ItemEmpoweredFocus();
        heavensDwelling = new ItemHeavensDwelling();


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
        GameRegistry.registerItem(nathanielStone, "Archangel_nathanielStone");

        GameRegistry.registerItem(arielPower, "Archangel_arielPower");
        GameRegistry.registerItem(arielBelt, "Archangel_arielBelt");
        GameRegistry.registerItem(arielPendant, "Archangel_arielPendant");
        GameRegistry.registerItem(arielRing, "Archangel_arielRing");

        GameRegistry.registerItem(basicBelt, "Archangel_basicBelt");
        GameRegistry.registerItem(basicRing, "Archangel_basicRing");
        GameRegistry.registerItem(basicPendant, "Archangel_basicPendant");

        GameRegistry.registerItem(empoweredFoucs, "Archangel_empoweredFocus");
        GameRegistry.registerItem(heavensDwelling, "Archangel_heavensDwelling");


    }
}
