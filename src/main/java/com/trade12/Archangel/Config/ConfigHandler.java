package com.trade12.Archangel.Config;

import com.trade12.Archangel.lib.Ref;
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
    public static boolean timeBlock =false;

    public static void init(File file)
    {
        if (configuration == null)
        {
            configuration = new Configuration(file);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        maxCharge = configuration.getInt(Ref.MAX_CHARGE_NAME, Ref.TWEAKS_GROUP, maxCharge, Ref.MAX_CHARGE_DEFAULT, Ref.MAX_CHARGE_MAX, Ref.MAX_CHARGE_DESC);
        timeBlock = configuration.getBoolean(Ref.TIME_BLOCK_NAME, Ref.TWEAKS_GROUP, Ref.TIME_BLOCK_DEFAULT, Ref.TIME_BLOCK_DESC);
        if (configuration.hasChanged())
        {
            configuration.save();
        }

    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if(event.modID.equalsIgnoreCase(Ref.MOD_ID))
        {
            loadConfiguration();
        }
    }
}
