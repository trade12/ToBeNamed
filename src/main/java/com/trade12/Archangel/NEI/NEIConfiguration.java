package com.trade12.Archangel.NEI;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

/**
 * Created by Kieran on 25/08/2014.
 */
public class NEIConfiguration implements IConfigureNEI {

    @Override
    public void loadConfig()
    {
        API.registerRecipeHandler(new NEICraftingRuneRecipeHandler());
        API.registerUsageHandler(new InfoHandler());
        API.registerRecipeHandler(new InfoHandler());
        System.out.println("Loaded NEI for Archangel!");
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
