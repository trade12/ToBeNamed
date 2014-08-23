package com.trade12.Archangel.Proxy;

import com.trade12.Archangel.entity.*;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by kieran on 13/08/2014.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void initSounds()
    {

    }
    @Override
    public void initRenders()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityOstrich.class, new RenderOstrich(new ModelOstrich(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDeathAngel.class, new RenderDeathAngel(new ModelDeathAngel(), 0.5F));
    }
}
