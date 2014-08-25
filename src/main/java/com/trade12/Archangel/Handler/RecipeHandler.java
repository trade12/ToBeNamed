package com.trade12.Archangel.Handler;

import com.trade12.Archangel.Items.ItemLoader;
import com.trade12.Archangel.blocks.BlockLoader;
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

    public static Item nathanielStoneFull, heavensDwellingFull;
    public static void initRecipes()
    {
        nathanielStoneFull = new ItemStack(ItemLoader.nathanielStone, 1,0).getItem();
        heavensDwellingFull = new ItemStack(ItemLoader.heavensDwelling, 1, 0).getItem();


        //Angel
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelPillow), "YXY", "X X", "XXX", 'X', Blocks.glass_pane, 'Y', Blocks.planks);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelSilk, 4), "XXX", "XYX", "XXX",'X', Blocks.wool, 'Y',ItemLoader.angelPillow);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelRing), " X ", "YWY", "ZZZ", 'X', Items.emerald, 'Y', ItemLoader.angelPillow, 'Z', ItemLoader.ostrichFeather, 'W', ItemLoader.basicRing);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelBelt), "ZZZ", "YWY", " X ", 'X', Items.emerald, 'Y', ItemLoader.angelPillow, 'Z', ItemLoader.ostrichFeather, 'W', ItemLoader.basicBelt);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelPendant), "ZZ ", "YWY", " YX", 'X', Items.emerald, 'Y', ItemLoader.angelPillow, 'Z', ItemLoader.ostrichFeather, 'W', ItemLoader.basicPendant);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelPower), "X", "Y", 'X', ItemLoader.ostrichFeather, 'Y', ItemLoader.dormantCrystal);


        //Nathaniel
        GameRegistry.addRecipe(new ItemStack(ItemLoader.nathanielStone, 1, 1000), "XXX", "XYX", "XXX", 'X', Items.lava_bucket, 'Y', Blocks.stone);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.damagedHalo), "XYX", 'X', Items.lava_bucket, 'Y', Items.quartz);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.nathanielRing), " X ", "YWY", "ZZZ", 'X', nathanielStoneFull, 'Y', ItemLoader.heart, 'Z', ItemLoader.damagedHalo, 'W', ItemLoader.basicRing);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.nathanielBelt), "ZZ ", "YWY", " YX", 'X', nathanielStoneFull, 'Y', ItemLoader.heart, 'Z', ItemLoader.damagedHalo, 'W', ItemLoader.basicPendant);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.nathanielPendant), "ZZ ", "YWY", " YX", 'X', nathanielStoneFull, 'Y', ItemLoader.heart, 'Z', ItemLoader.damagedHalo, 'W', ItemLoader.basicPendant);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.nathanielPower), "X", "Y", 'X', ItemLoader.heart, 'Y', ItemLoader.dormantCrystal);

        //Ariel
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelPurity, 1, 5), "XXX", "XYX", "XXX", 'X', Blocks.sapling, 'Y', Blocks.yellow_flower);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelPurity, 1, 4), "XXX", "XYX", "XXX", 'X', Blocks.vine, 'Y', new ItemStack(ItemLoader.angelPurity, 1, 5));
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelPurity, 1, 3), "XXX", "XYX", "XXX", 'X', Blocks.grass, 'Y', new ItemStack(ItemLoader.angelPurity, 1, 4));
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelPurity, 1, 2), "XXX", "XYX", "XXX", 'X', Blocks.red_mushroom, 'Y', new ItemStack(ItemLoader.angelPurity, 1, 3));
        GameRegistry.addRecipe(new ItemStack(ItemLoader.angelPurity), "XXX", "XYX", "XXX", 'X', Items.apple, 'Y', new ItemStack(ItemLoader.angelPurity, 1, 2));
        GameRegistry.addRecipe(new ItemStack(ItemLoader.pureSeed, 1, 5), "XXX", "XYX", "XXX", 'X', Blocks.sapling, 'Y', Items.wheat_seeds);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.pureSeed, 1, 4), "XXX", "XYX", "XXX", 'X', Blocks.vine, 'Y', new ItemStack(ItemLoader.pureSeed, 1, 5));
        GameRegistry.addRecipe(new ItemStack(ItemLoader.pureSeed, 1, 3), "XXX", "XYX", "XXX", 'X', Blocks.grass, 'Y', new ItemStack(ItemLoader.pureSeed, 1, 4));
        GameRegistry.addRecipe(new ItemStack(ItemLoader.pureSeed, 1, 2), "XXX", "XYX", "XXX", 'X', Blocks.red_mushroom, 'Y', new ItemStack(ItemLoader.pureSeed, 1, 3));
        GameRegistry.addRecipe(new ItemStack(ItemLoader.pureSeed), "XXX", "XYX", "XXX", 'X', Items.apple, 'Y', new ItemStack(ItemLoader.pureSeed, 1, 2));
        GameRegistry.addRecipe(new ItemStack(ItemLoader.arielRing), " X ", "YWY", "ZZZ", 'X', ItemLoader.angelPurity, 'Y', ItemLoader.pureSeed, 'Z', Blocks.red_flower, 'W', ItemLoader.basicRing);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.arielBelt), "ZZZ", "YWY", " X ", 'X', ItemLoader.angelPurity, 'Y', ItemLoader.pureSeed, 'Z', Blocks.red_flower, 'W', ItemLoader.basicBelt);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.arielPendant), "ZZ ", "YWY", " YX", 'X', ItemLoader.angelPurity, 'Y', ItemLoader.pureSeed, 'Z', Blocks.red_flower, 'W', ItemLoader.basicPendant);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.arielPower), "X", "Y", 'X', ItemLoader.pureSeed, 'Y', ItemLoader.dormantCrystal);

        //Sariel
        GameRegistry.addRecipe(new ItemStack(ItemLoader.heavensDwelling, 1, 16), "XYX", "YXY", "XYX", 'X', Items.ender_eye, 'Y', Blocks.obsidian);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.empoweredFoucs), "X", "Y", "Z", 'X', Items.ender_pearl, 'Y', Blocks.end_stone, 'Z', Blocks.quartz_ore);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.sarielRing), " X ", "YWY", "ZZZ", 'X', ItemLoader.empoweredFoucs, 'Y', heavensDwellingFull, 'Z', Blocks.end_stone, 'W', ItemLoader.basicRing);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.sarielBelt), "ZZZ", "YWY", " X ", 'X', ItemLoader.empoweredFoucs, 'Y', heavensDwellingFull, 'Z', Blocks.end_stone, 'W', ItemLoader.basicBelt);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.sarielPendant), "ZZ ", "YWY", " YX", 'X', ItemLoader.empoweredFoucs, 'Y', heavensDwellingFull, 'Z', Blocks.end_stone, 'W', ItemLoader.basicPendant);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.sarielPower), "X", "Y", 'X', heavensDwellingFull, 'Y', ItemLoader.dormantCrystal);

        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.guideBook), new ItemStack(Items.book), new ItemStack(ItemLoader.ostrichFeather));
        GameRegistry.addRecipe(new ItemStack(BlockLoader.CraftingRune), "YXY", "XZW", "YXY", 'Y', Blocks.quartz_ore, 'X', Blocks.glowstone, 'Z', Blocks.obsidian, 'W', ItemLoader.ostrichFeather);


    }
}
