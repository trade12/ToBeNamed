package com.trade12.Archangel.addon.enchiridion;

import com.trade12.Archangel.Items.ItemLoader;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import enchiridion.api.GuideHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;

/**
 * Created by Kieran on 24/08/2014.
 */
public class EnchiridionHandler {

    public static Item guideBook = ItemLoader.guideBook;
    public static void load()
    {
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            GuideHandler.registerBook(new ItemStack(guideBook), Ref.MOD_ID, "guideBook", 0xB3825F);
        }
    }
}
