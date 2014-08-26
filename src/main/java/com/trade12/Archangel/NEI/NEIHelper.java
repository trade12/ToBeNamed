package com.trade12.Archangel.NEI;

import codechicken.nei.recipe.DefaultOverlayHandler;
import codechicken.nei.recipe.RecipeInfo;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiCrafting;

/**
 * Created by Kieran on 26/08/2014.
 */
public class NEIHelper
{
    public static boolean isCraftingGUI(GuiContainer gui)
    {
        if (gui.getClass() == GuiCrafting.class) {
            return true;
        }
        if ((RecipeInfo.hasOverlayHandler(gui, "crafting")) &&
                (RecipeInfo.getOverlayHandler(gui, "crafting").getClass() == DefaultOverlayHandler.class)) {
            return true;
        }
        return false;
    }

}
