package com.trade12.Archangel.NEI;

import codechicken.nei.recipe.TemplateRecipeHandler;
import com.trade12.Archangel.lib.Ref;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import scala.reflect.internal.Trees;

/**
 * Created by Kieran on 25/08/2014.
 */
public class NEICraftingRuneRecipeHandler extends TemplateRecipeHandler {

    @Override
    public String getGuiTexture()
    {
        return new ResourceLocation(Ref.MOD_ID, "gui/craftingRune.png").toString();
    }

    @Override
    public String getRecipeName()
    {
        return "              " + StatCollector.translateToLocal("tile.BlockCraftingRune.name");
    }
}
