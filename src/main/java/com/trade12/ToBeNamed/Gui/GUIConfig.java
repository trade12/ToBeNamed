package com.trade12.ToBeNamed.Gui;

import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;

/**
 * Created by kieran on 13/08/2014.
 */
public class ConfigGUI extends GuiConfig
{
    public class ConfigGUI(GuiScreen parent)
    {
        super(parent, new ConfigElement());
    }
}
