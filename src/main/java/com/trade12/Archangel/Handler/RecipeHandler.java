package com.trade12.Archangel.Handler;

import com.trade12.Archangel.Items.ItemLoader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sun.org.mozilla.javascript.internal.ast.Block;

/**
 * Created by Kieran on 21/08/2014.
 */
public class RecipeHandler {

    public static Item nathanielStoneFull;
    public static void initRecipes()
    {
        nathanielStoneFull = new ItemStack(ItemLoader.nathanielStone, 1,0).getItem();


        //Angel
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelPillow), "YXY", "X X", "XXX", 'X', Blocks.glass_pane, 'Y', Blocks.planks);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelSilk, 4), "XXX", "XYX", "XXX",'X', Blocks.wool, 'Y',ItemLoader.angelPillow);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelRing), " X ", "YWY", "ZZZ", 'X', Items.emerald, 'Y', ItemLoader.angelPillow, 'Z', ItemLoader.ostrichFeather, 'W', ItemLoader.basicRing);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelBelt), "ZZZ", "YWY", " X ", 'X', Items.emerald, 'Y', ItemLoader.angelPillow, 'Z', ItemLoader.ostrichFeather, 'W', ItemLoader.basicBelt);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelPendant), "ZZ ", "YWY", " YX", 'X', Items.emerald, 'Y', ItemLoader.angelPillow, 'Z', ItemLoader.ostrichFeather, 'W', ItemLoader.basicPendant);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelPower), "X", "Y", 'X', ItemLoader.ostrichFeather, 'Y', ItemLoader.dormantCrystal);



        //Nathaniel
        GameRegistry.addRecipe(new ItemStack(ItemLoader.nathanielStone, 1, 1000), "XXX", "XYX", "XXX", 'X', Items.lava_bucket, 'Y', Blocks.stone);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.damagedHalo), "XYX", 'X', Items.lava_bucket, 'Y', Items.quartz); //todo add halo
        GameRegistry.addRecipe(new ItemStack(ItemLoader.nathanielRing), " X ", "YWY", "ZZZ", 'X', nathanielStoneFull, 'Y', ItemLoader.heart, 'Z', ItemLoader.damagedHalo, 'W', ItemLoader.basicRing);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.nathanielBelt), "ZZ ", "YWY", " YX", 'X', nathanielStoneFull, 'Y', ItemLoader.heart, 'Z', ItemLoader.damagedHalo, 'W', ItemLoader.basicPendant);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.nathanielPower), "X", "Y", 'X', ItemLoader.heart, 'Y', ItemLoader.dormantCrystal);





    }
}
