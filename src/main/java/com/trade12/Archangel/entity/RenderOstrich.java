package com.trade12.Archangel.entity;

import com.trade12.Archangel.lib.Ref;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;

/**
 * Created by Kieran on 17/08/2014.
 */
public class RenderOstrich extends RenderLiving {

   private static final ResourceLocation texture = new ResourceLocation("archangel", "textures/entity/ostrich.png");
      //private static final ResourceLocation texture = new ResourceLocation("Archangel" + "textures/entity/ostrich.png");

    public RenderOstrich(ModelBase modelBase, float i)
    {
        super(modelBase, i);
    }

    public void doRender(EntityOstrich ostrich, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender((EntityLiving)ostrich, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(EntityOstrich ostrich)
    {
        return texture;
    }


    public void doRender(EntityLiving entityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRender((EntityOstrich)entityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLivingBase entityLivingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRender((EntityOstrich)entityLivingBase, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityOstrich)entity);
    }

    public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRender((EntityOstrich)entity, par2, par4, par6, par8, par9);
    }
}
