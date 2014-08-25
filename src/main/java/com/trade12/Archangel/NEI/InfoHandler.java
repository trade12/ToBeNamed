package com.trade12.Archangel.NEI;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.ICraftingHandler;
import codechicken.nei.recipe.IUsageHandler;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

/**
 * Created by Kieran on 25/08/2014.
 */
public class InfoHandler implements IUsageHandler, ICraftingHandler {

    public static FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
    public static int color = -12566464;
    int currentRecipe;
    ItemStack displayItem = null;

    public InfoHandler()
    {
        this.currentRecipe = -1;
    }

    public InfoHandler(int currentRecipe, ItemStack item)
    {
        if (currentRecipe < InfoData.data.size()) {
            this.currentRecipe = currentRecipe;
        }
        this.displayItem = item;
    }

    public String getRecipeName()
    {
        return "Archangel: Info";
    }

    public int numRecipes()
    {
        return this.currentRecipe < 0 ? 0 : ((InfoData)InfoData.data.get(this.currentRecipe)).info.length;
    }

    public void drawBackground(int recipe) {}

    public int getWidth()
    {
        return 166;
    }

    public PositionedStack getResultStack(int recipe)
    {
        return new PositionedStack(this.displayItem != null ? this.displayItem : ((InfoData)InfoData.data.get(this.currentRecipe)).item, getWidth() / 2 - 9, 0, false);
    }

    public void drawForeground(int recipe)
    {
        List text = fontRenderer.listFormattedStringToWidth(((InfoData)InfoData.data.get(this.currentRecipe)).info[recipe], getWidth() - 8);
        for (int i = 0; i < text.size(); i++)
        {
            String t = (String)text.get(i);
            GuiDraw.drawString(t, getWidth() / 2 - GuiDraw.getStringWidth(t) / 2, 18 + i * 8, color, false);
        }
    }

    public List<PositionedStack> getIngredientStacks(int recipe)
    {
        return new ArrayList();
    }

    public List<PositionedStack> getOtherStacks(int recipetype)
    {
        return new ArrayList();
    }

    public void onUpdate() {}

    public boolean hasOverlay(GuiContainer gui, Container container, int recipe)
    {
        return false;
    }

    public IRecipeOverlayRenderer getOverlayRenderer(GuiContainer gui, int recipe)
    {
        return null;
    }

    public IOverlayHandler getOverlayHandler(GuiContainer gui, int recipe)
    {
        return null;
    }

    public int recipiesPerPage()
    {
        return 1;
    }

    public List<String> handleTooltip(GuiRecipe gui, List<String> currenttip, int recipe)
    {
        return currenttip;
    }

    public List<String> handleItemTooltip(GuiRecipe gui, ItemStack stack, List<String> currenttip, int recipe)
    {
        return currenttip;
    }

    public boolean keyTyped(GuiRecipe gui, char keyChar, int keyCode, int recipe)
    {
        return false;
    }

    public boolean mouseClicked(GuiRecipe gui, int button, int recipe)
    {
        return false;
    }

    public IUsageHandler getUsageHandler(String inputId, Object... ingredients)
    {
        if (inputId != "item") {
            return this;
        }
        for (int i = 0; i < ingredients.length; i++) {
            if ((ingredients[i] instanceof ItemStack)) {
                for (int j = 0; j < InfoData.data.size(); j++) {
                    if (((InfoData)InfoData.data.get(j)).matches((ItemStack)ingredients[i])) {
                        return new InfoHandler(j, (ItemStack)ingredients[i]);
                    }
                }
            }
        }
        return this;
    }

    public ICraftingHandler getRecipeHandler(String outputId, Object... results)
    {
        if (outputId != "item") {
            return this;
        }
        for (int i = 0; i < results.length; i++) {
            if ((results[i] instanceof ItemStack)) {
                for (int j = 0; j < InfoData.data.size(); j++) {
                    if (((InfoData)InfoData.data.get(j)).matches((ItemStack)results[i])) {
                        return new InfoHandler(j, (ItemStack)results[i]);
                    }
                }
            }
        }
        return this;
    }
}
