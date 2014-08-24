package com.trade12.Archangel.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * Created by Kieran on 23/08/2014.
 */
public class ModelDeathAngel extends ModelBase {

    //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer smallWing1;
    ModelRenderer middleWing1;
    ModelRenderer endWing1;
    ModelRenderer smallWing2;
    ModelRenderer middleWing2;
    ModelRenderer endWing2;

    public ModelDeathAngel()
    {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);

        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setRotationPoint(0F, 0F, 0F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);

        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setRotationPoint(-5F, 2F, 0F);
        rightarm.setTextureSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, -1.570796F, -0.1115358F, 0.2230717F);

        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(5F, 2F, 0F);
        leftarm.setTextureSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, -1.570796F, 0.111544F, -0.2230705F);

        smallWing1 = new ModelRenderer(this, 34, 0);
        smallWing1.addBox(0F, 0F, 0F, 1, 5, 2);
        smallWing1.setRotationPoint(2F, 1F, 2F);
        smallWing1.setTextureSize(64, 32);
        smallWing1.mirror = true;
        setRotation(smallWing1, 0F, 0F, -0.3717861F);


        middleWing1 = new ModelRenderer(this, 42, 0);
        middleWing1.mirror = true;
        middleWing1.addBox(0F, 0F, 0F, 1, 11, 2);
        middleWing1.setRotationPoint(2F, 1F, 4F);
        middleWing1.setTextureSize(64, 32);
        middleWing1.mirror = true;
        setRotation(middleWing1, 0F, 0F, -0.3717861F);


        endWing1 = new ModelRenderer(this, 50, 0);
        middleWing1.mirror = false;
        endWing1.addBox(0F, 0F, 0F, 1, 14, 2);
        endWing1.setRotationPoint(2F, 2F, 6F);
        endWing1.setTextureSize(64, 32);
        endWing1.mirror = true;
        setRotation(endWing1, 0F, 0F, -0.3717861F);

        smallWing2 = new ModelRenderer(this, 34, 0);
        smallWing2.addBox(0F, 0F, 0F, 1, 5, 2);
        smallWing2.setRotationPoint(-3F, 1F, 2F);
        smallWing2.setTextureSize(64, 32);
        smallWing2.mirror = true;
        setRotation(smallWing2, 0F, 0F, 0.37179F);


        middleWing2 = new ModelRenderer(this, 42, 0);
        middleWing2.mirror = true;
        middleWing2.addBox(0F, 0F, 0F, 1, 11, 2);
        middleWing2.setRotationPoint(-3F, 1F, 4F);
        middleWing2.setTextureSize(64, 32);
        middleWing2.mirror = true;
        setRotation(middleWing2, 0F, 0F, 0.37179F);
        middleWing2.mirror = false;

        endWing2 = new ModelRenderer(this, 50, 0);
        endWing2.addBox(0F, 0F, 0F, 1, 14, 2);
        endWing2.setRotationPoint(-3F, 2F, 6F);
        endWing2.setTextureSize(64, 32);
        endWing2.mirror = true;
        setRotation(endWing2, 0F, 0F, 0.37179F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5,entity);
        head.render(f5);
        body.render(f5);
        rightarm.render(f5);
        leftarm.render(f5);
        smallWing1.render(f5);
        middleWing1.render(f5);
        endWing1.render(f5);
        smallWing2.render(f5);
        middleWing2.render(f5);
        endWing2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
    {
        //GL11.glRotated(90, 0, 1, 0);
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}
