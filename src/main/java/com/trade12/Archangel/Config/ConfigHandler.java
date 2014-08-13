package com.trade12.Archangel.Config;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by kieran on 13/08/2014.
 */
public class ConfigHandler {

    public static Configuration configuration;
    public static int maxCharge = 500;

    public static void init(File file)
    {
        if (configuration == null)
        {
            configuration = new Configuration(file);
            loadConfiguration;
        }
    }

    private static void loadConfiguration()
    {

    }
}
