package com.trade12.Archangel.lib;

import com.trade12.Archangel.Items.ItemLoader;
import com.trade12.Archangel.NEI.InfoData;
import net.minecraft.item.ItemStack;

/**
 * Created by Kieran on 25/08/2014.
 */
public class ItemInfo {

    public static void RegisterStuff()
    {
        InfoData.add(new ItemStack(ItemLoader.ostrichFeather),"Ostrich Feather","http://i.imgur.com/GijpJb9.png", new String[]{"A rare drop from Ostriches, they can be found in hot biomes due to there nature."});
        InfoData.add(new ItemStack(ItemLoader.nathanielPendant),"Nathaniel Pendant","http://i.imgur.com/GijpJb9.png",new String[]{"ozbiefheofiefibhoifipehoeihgfosrhf"});
    }
}
