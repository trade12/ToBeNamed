package com.trade12.Archangel.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Kieran on 23/08/2014.
 */
public class RenderDeathAngel extends RenderLiving {

    private static final ResourceLocation texture = new ResourceLocation("archangel", "textures/entity/DeathAngel.png");
    //private static final ResourceLocation texture = new ResourceLocation("Archangel" + "textures/entity/ostrich.png");

    public RenderDeathAngel(ModelBase modelBase, float i)
    {
        super(modelBase, i);
    }

    public void doRender(EntityDeathAngel angel, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender((EntityLiving)angel, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(EntityDeathAngel angel)
    {
        return texture;
    }


    public void doRender(EntityLiving entityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRender((EntityDeathAngel)entityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLivingBase entityLivingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRender((EntityDeathAngel)entityLivingBase, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityDeathAngel)entity);
    }

    public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRender((EntityDeathAngel)entity, par2, par4, par6, par8, par9);
    }
}

