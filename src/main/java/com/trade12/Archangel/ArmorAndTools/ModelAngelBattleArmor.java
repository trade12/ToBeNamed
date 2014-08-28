package com.trade12.Archangel.ArmorAndTools;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by Kieran on 28/08/2014.
 */
public class ModelAngelBattleArmor extends ModelBase {

    //fields
    ModelRenderer smallWing1;
    ModelRenderer middleWing1;
    ModelRenderer endWing1;
    ModelRenderer smallWing2;
    ModelRenderer endWing2;
    ModelRenderer middleWing2;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;

    public ModelAngelBattleArmor()
    {
        textureWidth = 64;
        textureHeight = 32;

        smallWing1 = new ModelRenderer(this, 34, 0);
        smallWing1.addBox(0F, 0F, 0F, 1, 5, 2);
        smallWing1.setRotationPoint(1F, 1.3F, 2F);
        smallWing1.setTextureSize(64, 32);
        smallWing1.mirror = true;
        setRotation(smallWing1, 0F, 0F, -0.37179F);
        middleWing1.mirror = true;
        middleWing1 = new ModelRenderer(this, 42, 0);
        middleWing1.addBox(0F, 0F, 0F, 1, 11, 2);
        middleWing1.setRotationPoint(1F, 1.3F, 4F);
        middleWing1.setTextureSize(64, 32);
        middleWing1.mirror = true;
        setRotation(middleWing1, 0F, 0F, -0.37179F);
        middleWing1.mirror = false;
        endWing1 = new ModelRenderer(this, 50, 0);
        endWing1.addBox(0F, 0F, 0F, 1, 14, 2);
        endWing1.setRotationPoint(1F, 2.3F, 6F);
        endWing1.setTextureSize(64, 32);
        endWing1.mirror = true;
        setRotation(endWing1, 0.0174533F, 0F, -0.37179F);
        smallWing2 = new ModelRenderer(this, 34, 0);
        smallWing2.addBox(0F, 0F, 0F, 1, 5, 2);
        smallWing2.setRotationPoint(-2F, 1F, 2F);
        smallWing2.setTextureSize(64, 32);
        smallWing2.mirror = true;
        setRotation(smallWing2, 0F, 0F, 0.37179F);
        endWing2 = new ModelRenderer(this, 50, 0);
        endWing2.addBox(0F, 0F, 0F, 1, 14, 2);
        endWing2.setRotationPoint(-2F, 2F, 6F);
        endWing2.setTextureSize(64, 32);
        endWing2.mirror = true;
        setRotation(endWing2, 0F, 0F, 0.37179F);
        middleWing2 = new ModelRenderer(this, 42, 0);
        middleWing2.addBox(0F, 0F, 0F, 1, 11, 2);
        middleWing2.setRotationPoint(-2F, 1F, 4F);
        middleWing2.setTextureSize(64, 32);
        middleWing2.mirror = true;
        setRotation(middleWing2, 0F, 0F, 0.37179F);
        Shape1 = new ModelRenderer(this, 52, 17);
        Shape1.addBox(0F, 0F, 0F, 5, 1, 1);
        Shape1.setRotationPoint(0F, 6F, -3F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0.6981317F, 0F, 0.3490659F);
        Shape2 = new ModelRenderer(this, 52, 17);
        Shape2.addBox(0F, 0F, 0F, 5, 1, 1);
        Shape2.setRotationPoint(0F, 1F, -3F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0.6981317F, 0F, 0.3490659F);
        Shape3 = new ModelRenderer(this, 52, 17);
        Shape3.addBox(0F, 0F, 0F, 5, 1, 1);
        Shape3.setRotationPoint(0F, 2F, -3F);
        Shape3.setTextureSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0.6981317F, 0F, 0.3490659F);
        Shape4 = new ModelRenderer(this, 52, 17);
        Shape4.addBox(0F, 0F, 0F, 5, 1, 1);
        Shape4.setRotationPoint(0F, 3F, -3F);
        Shape4.setTextureSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, 0.6981317F, 0F, 0.3490659F);
        Shape5 = new ModelRenderer(this, 52, 17);
        Shape5.addBox(0F, 0F, 0F, 5, 1, 1);
        Shape5.setRotationPoint(0F, 4F, -3F);
        Shape5.setTextureSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, 0.6981317F, 0F, 0.3490659F);
        Shape6 = new ModelRenderer(this, 52, 17);
        Shape6.addBox(0F, 0F, 0F, 5, 1, 1);
        Shape6.setRotationPoint(0F, 5F, -3F);
        Shape6.setTextureSize(64, 32);
        Shape6.mirror = true;
        setRotation(Shape6, 0.6981317F, 0F, 0.3490659F);
        Shape7 = new ModelRenderer(this, 0, 18);
        Shape7.addBox(0F, 0F, 0F, 5, 1, 1);
        Shape7.setRotationPoint(0F, 6F, -3F);
        Shape7.setTextureSize(64, 32);
        Shape7.mirror = true;
        setRotation(Shape7, 0.7504916F, 0F, 2.792527F);
        Shape8 = new ModelRenderer(this, 0, 18);
        Shape8.addBox(0F, 0F, 0F, 5, 1, 1);
        Shape8.setRotationPoint(0F, 2F, -3F);
        Shape8.setTextureSize(64, 32);
        Shape8.mirror = true;
        setRotation(Shape8, 0.7504916F, 0F, 2.792527F);
        Shape9 = new ModelRenderer(this, 0, 18);
        Shape9.addBox(0F, 0F, 0F, 5, 1, 1);
        Shape9.setRotationPoint(0F, 3F, -3F);
        Shape9.setTextureSize(64, 32);
        Shape9.mirror = true;
        setRotation(Shape9, 0.7504916F, 0F, 2.792527F);
        Shape10 = new ModelRenderer(this, 0, 18);
        Shape10.addBox(0F, 0F, 0F, 5, 1, 1);
        Shape10.setRotationPoint(0F, 1F, -3F);
        Shape10.setTextureSize(64, 32);
        Shape10.mirror = true;
        setRotation(Shape10, 0.7504916F, 0F, 2.792527F);
        Shape11 = new ModelRenderer(this, 0, 18);
        Shape11.addBox(0F, 0F, 0F, 5, 1, 1);
        Shape11.setRotationPoint(0F, 4F, -3F);
        Shape11.setTextureSize(64, 32);
        Shape11.mirror = true;
        setRotation(Shape11, 0.7504916F, 0F, 2.792527F);
        Shape12 = new ModelRenderer(this, 0, 18);
        Shape12.addBox(0F, 0F, 0F, 5, 1, 1);
        Shape12.setRotationPoint(0F, 5F, -3F);
        Shape12.setTextureSize(64, 32);
        Shape12.mirror = true;
        setRotation(Shape12, 0.7504916F, 0F, 2.792527F);
        Shape13 = new ModelRenderer(this, 0, 22);
        Shape13.addBox(0F, 0F, 0F, 1, 8, 1);
        Shape13.setRotationPoint(-0.5F, 0.5F, -3F);
        Shape13.setTextureSize(64, 32);
        Shape13.mirror = true;
        setRotation(Shape13, 0F, 0F, 0F);
        Shape14 = new ModelRenderer(this, 5, 24);
        Shape14.addBox(0F, 0F, 0F, 6, 6, 1);
        Shape14.setRotationPoint(-3F, 1F, 2F);
        Shape14.setTextureSize(64, 32);
        Shape14.mirror = true;
        setRotation(Shape14, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        smallWing2.render(f5);
        middleWing2.render(f5);
        endWing2.render(f5);
        smallWing2.render(f5);
        endWing2.render(f5);
        middleWing2.render(f5);
        Shape1.render(f5);
        Shape2.render(f5);
        Shape3.render(f5);
        Shape4.render(f5);
        Shape5.render(f5);
        Shape6.render(f5);
        Shape7.render(f5);
        Shape8.render(f5);
        Shape9.render(f5);
        Shape10.render(f5);
        Shape11.render(f5);
        Shape12.render(f5);
        Shape13.render(f5);
        Shape14.render(f5);
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
