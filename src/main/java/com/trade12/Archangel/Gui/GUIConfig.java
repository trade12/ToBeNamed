package com.trade12.Archangel.Gui;

import com.trade12.Archangel.Config.ConfigHandler;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

/**
 * Created by kieran on 13/08/2014.
 */
public class GUIConfig extends GuiConfig
{
    public GUIConfig(GuiScreen parent)
    {
        super(parent, new ConfigElement(ConfigHandler.configuration.getCategory(Ref.TWEAKS_GROUP)).getChildElements(),Ref.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.configuration.toString()));

    }
}
