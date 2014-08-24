package com.trade12.Archangel.Handler;

import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

/**
 * Created by kieran on 21/08/2014.
 */
public class MathHandler {

    public static boolean isDaytime(World world, int x, int y, int z)
    {
        int a = world.getSavedLightValue(EnumSkyBlock.Sky, x,y,z) - world.skylightSubtracted;
        float f = world.getCelestialAngleRadians(1.0F);

        if (f < (float)Math.PI)
        {
            f += (0.0F - f) * 0.2F;
        }
        else
        {
            f += (((float)Math.PI * 2F) -f) *0.2F;
        }

        a = Math.round((float)a* MathHelper.cos(f));

        if (a < 0)
        {
            a = 0;
        }
        if (a > 15)
        {
            a = 15;
        }

        return a != 0;

    }

    public static boolean isCold(World world, int x, int y, int z)
    {
        return world.canSnowAtBody(x, y, z, false);
    }
}
