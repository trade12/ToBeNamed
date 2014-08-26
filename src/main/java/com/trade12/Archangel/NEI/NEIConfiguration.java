package com.trade12.Archangel.NEI;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import com.trade12.Archangel.lib.Log;

/**
 * Created by Kieran on 25/08/2014.
 */
public class NEIConfiguration implements IConfigureNEI {

    @Override
    public void loadConfig()
    {
        API.registerRecipeHandler(new NEICraftingRuneRecipeHandler());
        API.registerRecipeHandler(new InfoHandler());
        API.registerUsageHandler(new InfoHandler());
        Log.info("*********************Loaded NEI Support for Archangel***********************");
    }

    @Override
    public String getName()
    {
        return "Archange; NEI";
    }

    @Override
    public String getVersion()
    {
        return "1.0-Banana";
    }
}
