package com.trade12.Archangel.Proxy;


import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.FXSparkle;
import com.trade12.Archangel.WingRenderHandler;
import com.trade12.Archangel.entity.*;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
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
        MinecraftForge.EVENT_BUS.register(new WingRenderHandler());
    }

    private static boolean noclipEnabled = false;



    @Override
    public void sparkleFX(World world, double x, double y, double z, float r, float g, float b, float size, int m, boolean fake) {
        if(!doParticle() && !fake)
            return;

        FXSparkle sparkle = new FXSparkle(world, x, y, z, size, r, g, b, m);
        sparkle.fake = sparkle.noClip = fake;
        if(noclipEnabled)
            sparkle.noClip = true;
        Minecraft.getMinecraft().effectRenderer.addEffect(sparkle);
    }

    private boolean doParticle() {
        /** if(!ConfigHandler.useVanillaParticleLimiter)
            return true; **/

        float chance = 1F;
        if(Minecraft.getMinecraft().gameSettings.particleSetting == 1)
            chance = 0.6F;
        else if(Minecraft.getMinecraft().gameSettings.particleSetting == 2)
            chance = 0.2F;

        return Math.random() < chance;
    }



}


