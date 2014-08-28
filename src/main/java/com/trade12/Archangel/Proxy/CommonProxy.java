package com.trade12.Archangel.Proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by kieran on 13/08/2014.
 */
public class CommonProxy  {

    public void initSounds()
    {

    }
    public void initRenders()
    {

    }

    public EntityPlayer getPlayer()
    {
        return null;
    }

    public void sparkleFX(World world, double x, double y, double z, float r, float g, float b, float size, int m) {
        sparkleFX(world, x, y, z, r, g, b, size, m, false);
    }

    public void sparkleFX(World world, double x, double y, double z, float r, float g, float b, float size, int m, boolean fake) {
        // NO-OP
    }
}
