package com.trade12.Archangel.blocks.Lantern;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by Kieran on 27/08/2014.
 */
public class ModelLantern extends ModelBase {

    ModelRenderer Base;
    ModelRenderer Middle;
    ModelRenderer TopLong1;
    ModelRenderer TopLong2;
    ModelRenderer TopShort1;
    ModelRenderer TopShort2;
    ModelRenderer Detail1;
    ModelRenderer Detail2;
    ModelRenderer Detail3;
    ModelRenderer Detail4;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg4;
    ModelRenderer Leg3;
    private float scale = 0.0625F;

    public ModelLantern()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.Base = new ModelRenderer(this, 0, 17);
        this.Base.addBox(0.0F, 0.0F, 0.0F, 10, 2, 10);
        this.Base.setRotationPoint(-4.0F, 14.0F, -4.0F);
        this.Base.setTextureSize(64, 32);
        this.Base.mirror = true;

        this.Middle = new ModelRenderer(this, 0, 3);
        this.Middle.addBox(0.0F, 0.0F, 0.0F, 12, 2, 12);
        this.Middle.setRotationPoint(-5.0F, 12.0F, -5.0F);
        this.Middle.setTextureSize(64, 32);
        this.Middle.mirror = true;

        this.TopLong1 = new ModelRenderer(this, 30, 17);
        this.TopLong1.addBox(0.0F, 0.0F, 0.0F, 12, 3, 2);
        this.TopLong1.setRotationPoint(7.0F, 9.0F, 7.0F);
        this.TopLong1.setTextureSize(64, 32);
        this.TopLong1.mirror = true;
        this.TopLong1.rotateAngleY = 3.141593F;

        this.TopLong2 = new ModelRenderer(this, 30, 17);
        this.TopLong2.addBox(0.0F, 0.0F, 0.0F, 12, 3, 2);
        this.TopLong2.setRotationPoint(-5.0F, 9.0F, -5.0F);
        this.TopLong2.setTextureSize(64, 32);
        this.TopLong2.mirror = true;

        this.TopShort1 = new ModelRenderer(this, 36, 4);
        this.TopShort1.addBox(-2.0F, 0.0F, -8.0F, 2, 3, 8);
        this.TopShort1.setRotationPoint(5.0F, 9.0F, -3.0F);
        this.TopShort1.setTextureSize(64, 32);
        this.TopShort1.mirror = true;
        this.TopShort1.rotateAngleY = 3.141593F;

        this.TopShort2 = new ModelRenderer(this, 36, 4);
        this.TopShort2.addBox(0.0F, 0.0F, 0.0F, 2, 3, 8);
        this.TopShort2.setRotationPoint(-5.0F, 9.0F, -3.0F);
        this.TopShort2.setTextureSize(64, 32);
        this.TopShort2.mirror = true;

        this.Detail1 = new ModelRenderer(this, 0, 20);
        this.Detail1.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2);
        this.Detail1.setRotationPoint(-7.0F, 7.0F, 1.5F);
        this.Detail1.setTextureSize(64, 32);
        this.Detail1.mirror = true;
        this.Detail1.rotateAngleY = 1.570796F;

        this.Detail2 = new ModelRenderer(this, 0, 20);
        this.Detail2.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2);
        this.Detail2.setRotationPoint(9.0F, 7.0F, 0.5F);
        this.Detail2.setTextureSize(64, 32);
        this.Detail2.mirror = true;
        this.Detail2.rotateAngleY = -1.570796F;

        this.Detail3 = new ModelRenderer(this, 0, 20);
        this.Detail3.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2);
        this.Detail3.setRotationPoint(0.5F, 7.0F, -7.0F);
        this.Detail3.setTextureSize(64, 32);
        this.Detail3.mirror = true;


        this.Detail4 = new ModelRenderer(this, 0, 20);
        this.Detail4.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2);
        this.Detail4.setRotationPoint(1.5F, 7.0F, 9.0F);
        this.Detail4.setTextureSize(64, 32);
        this.Detail4.mirror = true;
        this.Detail4.rotateAngleY = 3.141593F;

        this.Leg1 = new ModelRenderer(this, 0, 29);
        this.Leg1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        this.Leg1.setRotationPoint(3.0F, 16.0F, 3.0F);
        this.Leg1.setTextureSize(64, 32);
        this.Leg1.mirror = true;

        this.Leg2 = new ModelRenderer(this, 0, 29);
        this.Leg2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        this.Leg2.setRotationPoint(-3.0F, 16.0F, -3.0F);
        this.Leg2.setTextureSize(64, 32);
        this.Leg2.mirror = true;

        this.Leg4 = new ModelRenderer(this, 0, 29);
        this.Leg4.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        this.Leg4.setRotationPoint(3.0F, 16.0F, -3.0F);
        this.Leg4.setTextureSize(64, 32);
        this.Leg4.mirror = true;

        this.Leg3 = new ModelRenderer(this, 0, 29);
        this.Leg3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        this.Leg3.setRotationPoint(-3.0F, 16.0F, 3.0F);
        this.Leg3.setTextureSize(64, 32);
        this.Leg3.mirror = true;

    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Base.render(f5);
        this.Middle.render(f5);
        this.TopLong1.render(f5);
        this.TopLong2.render(f5);
        this.TopShort1.render(f5);
        this.TopShort2.render(f5);
        this.Detail1.render(f5);
        this.Detail2.render(f5);
        this.Detail3.render(f5);
        this.Detail4.render(f5);
        this.Leg1.render(f5);
        this.Leg2.render(f5);
        this.Leg4.render(f5);
        this.Leg3.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
