package com.trade12.Archangel.entity;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOstrich extends ModelBase
{
    //fields
    ModelRenderer Foot1;
    ModelRenderer Foot2;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Joint1;
    ModelRenderer Joint2;
    ModelRenderer Shoulder1;
    ModelRenderer Shoulder2;
    ModelRenderer Main_Body;
    ModelRenderer Butt;
    ModelRenderer Feather1;
    ModelRenderer Feather2;
    ModelRenderer Feather3;
    ModelRenderer Lower_Neck;
    ModelRenderer Main_Neck;
    ModelRenderer Head;
    ModelRenderer Bottom_Beak;
    ModelRenderer Top_Beak;
    ModelRenderer Side_wing_top1;
    ModelRenderer Side_wing_bottom1;
    ModelRenderer Side_wing_top2;
    ModelRenderer Side_wing_bottom2;

    public ModelOstrich()
    {
        textureWidth = 64;
        textureHeight = 64;

        Foot1.mirror = true;
        Foot1 = new ModelRenderer(this, 48, 0);
        Foot1.addBox(0F, 0F, 0F, 5, 1, 2);
        Foot1.setRotationPoint(0F, 22F, -5F);
        Foot1.setTextureSize(64, 64);
        Foot1.mirror = true;
        setRotation(Foot1, 0F, 0F, 0.1487144F);
        Foot1.mirror = false;
        Foot2.mirror = true;
        Foot2 = new ModelRenderer(this, 48, 0);
        Foot2.addBox(0F, 0F, 0F, 5, 1, 2);
        Foot2.setRotationPoint(0F, 22F, 3F);
        Foot2.setTextureSize(64, 64);
        Foot2.mirror = true;
        setRotation(Foot2, 0F, 0F, 0.1487144F);
        Foot2.mirror = false;
        Leg1.mirror = true;
        Leg1 = new ModelRenderer(this, 55, 49);
        Leg1.addBox(0F, 0F, 0F, 2, 10, 2);
        Leg1.setRotationPoint(-3F, 14F, -5F);
        Leg1.setTextureSize(64, 64);
        Leg1.mirror = true;
        setRotation(Leg1, 0F, 0F, -0.2716104F);
        Leg1.mirror = false;
        Leg2.mirror = true;
        Leg2 = new ModelRenderer(this, 55, 49);
        Leg2.addBox(0F, 0F, 0F, 2, 10, 2);
        Leg2.setRotationPoint(-3F, 14F, 3F);
        Leg2.setTextureSize(64, 64);
        Leg2.mirror = true;
        setRotation(Leg2, 0F, 0F, -0.2716104F);
        Leg2.mirror = false;
        Joint1.mirror = true;
        Joint1 = new ModelRenderer(this, 52, 35);
        Joint1.addBox(0F, 0F, 0F, 3, 4, 3);
        Joint1.setRotationPoint(-3F, 11F, -5.5F);
        Joint1.setTextureSize(64, 64);
        Joint1.mirror = true;
        setRotation(Joint1, 0F, 0F, 0.1745329F);
        Joint1.mirror = false;
        Joint2.mirror = true;
        Joint2 = new ModelRenderer(this, 52, 35);
        Joint2.addBox(0F, 0F, 0F, 3, 4, 3);
        Joint2.setRotationPoint(-3F, 11F, 2.5F);
        Joint2.setTextureSize(64, 64);
        Joint2.mirror = true;
        setRotation(Joint2, 0F, 0F, 0.1745329F);
        Joint2.mirror = false;
        Shoulder1.mirror = true;
        Shoulder1 = new ModelRenderer(this, 50, 25);
        Shoulder1.addBox(0F, 0F, 0F, 5, 5, 2);
        Shoulder1.setRotationPoint(-3F, 6F, -6F);
        Shoulder1.setTextureSize(64, 64);
        Shoulder1.mirror = true;
        setRotation(Shoulder1, 0F, 0F, 0.1745329F);
        Shoulder1.mirror = false;
        Shoulder2.mirror = true;
        Shoulder2 = new ModelRenderer(this, 50, 25);
        Shoulder2.addBox(0F, 0F, 0F, 5, 5, 2);
        Shoulder2.setRotationPoint(-3F, 6F, 4F);
        Shoulder2.setTextureSize(64, 64);
        Shoulder2.mirror = true;
        setRotation(Shoulder2, 0F, 0F, 0.1745329F);
        Shoulder2.mirror = false;
        Main_Body = new ModelRenderer(this, 0, 0);
        Main_Body.addBox(0F, 0F, 0F, 16, 8, 8);
        Main_Body.setRotationPoint(-8.4F, 4F, -4F);
        Main_Body.setTextureSize(64, 64);
        Main_Body.mirror = true;
        setRotation(Main_Body, 0F, 0F, 0F);
        Butt = new ModelRenderer(this, 1, 53);
        Butt.addBox(0F, 0F, 0F, 5, 4, 4);
        Butt.setRotationPoint(-12F, 5F, -2F);
        Butt.setTextureSize(64, 64);
        Butt.mirror = true;
        setRotation(Butt, 0F, 0F, 0.1745329F);
        Feather1.mirror = true;
        Feather1 = new ModelRenderer(this, 0, 30);
        Feather1.addBox(0F, 0F, 0F, 6, 4, 1);
        Feather1.setRotationPoint(-16F, 4F, 3F);
        Feather1.setTextureSize(64, 64);
        Feather1.mirror = true;
        setRotation(Feather1, -0.2602545F, 0.4658647F, 0.2860769F);
        Feather1.mirror = false;
        Feather2.mirror = true;
        Feather2 = new ModelRenderer(this, 0, 30);
        Feather2.addBox(0F, 0F, 0F, 6, 4, 1);
        Feather2.setRotationPoint(-16F, 4F, -3.5F);
        Feather2.setTextureSize(64, 64);
        Feather2.mirror = true;
        setRotation(Feather2, 0.2602503F, -0.3717861F, 0.2860688F);
        Feather2.mirror = false;
        Feather3.mirror = true;
        Feather3 = new ModelRenderer(this, 0, 30);
        Feather3.addBox(0F, 0F, 0F, 6, 4, 1);
        Feather3.setRotationPoint(-17F, 5F, -0.45F);
        Feather3.setTextureSize(64, 64);
        Feather3.mirror = true;
        setRotation(Feather3, 0F, 0F, 0.0629971F);
        Feather3.mirror = false;
        Lower_Neck = new ModelRenderer(this, 0, 17);
        Lower_Neck.addBox(0F, 0F, 0F, 3, 8, 3);
        Lower_Neck.setRotationPoint(7F, 1F, -1.5F);
        Lower_Neck.setTextureSize(64, 64);
        Lower_Neck.mirror = true;
        setRotation(Lower_Neck, 0F, 0F, 0.2602503F);
        Main_Neck = new ModelRenderer(this, 52, 7);
        Main_Neck.addBox(0F, 0F, 0F, 2, 12, 2);
        Main_Neck.setRotationPoint(6.5F, -10F, -1F);
        Main_Neck.setTextureSize(64, 64);
        Main_Neck.mirror = true;
        setRotation(Main_Neck, 0F, 0F, -0.080175F);
        Head = new ModelRenderer(this, 30, 16);
        Head.addBox(0F, 0F, 0F, 3, 4, 4);
        Head.setRotationPoint(6F, -12.5F, -2F);
        Head.setTextureSize(64, 64);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Bottom_Beak = new ModelRenderer(this, 38, 47);
        Bottom_Beak.addBox(0F, 0F, 0F, 3, 1, 3);
        Bottom_Beak.setRotationPoint(8F, -11.5F, -1.5F);
        Bottom_Beak.setTextureSize(64, 64);
        Bottom_Beak.mirror = true;
        setRotation(Bottom_Beak, 0F, 0F, -0.1115358F);
        Top_Beak = new ModelRenderer(this, 38, 38);
        Top_Beak.addBox(0F, 0F, 0F, 3, 1, 3);
        Top_Beak.setRotationPoint(8F, -10F, -1.5F);
        Top_Beak.setTextureSize(64, 64);
        Top_Beak.mirror = true;
        setRotation(Top_Beak, 0F, 0F, 0.2602503F);
        Side_wing_top1 = new ModelRenderer(this, 0, 37);
        Side_wing_top1.addBox(0F, 0F, 0F, 12, 4, 1);
        Side_wing_top1.setRotationPoint(3F, 8F, 4F);
        Side_wing_top1.setTextureSize(64, 64);
        Side_wing_top1.mirror = true;
        setRotation(Side_wing_top1, 0F, 0F, -2.862753F);
        Side_wing_bottom1 = new ModelRenderer(this, 0, 44);
        Side_wing_bottom1.addBox(0F, 0F, 1F, 12, 4, 1);
        Side_wing_bottom1.setRotationPoint(3F, 9F, 3F);
        Side_wing_bottom1.setTextureSize(64, 64);
        Side_wing_bottom1.mirror = true;
        setRotation(Side_wing_bottom1, 0F, 0F, 2.991742F);
        Side_wing_top2 = new ModelRenderer(this, 0, 37);
        Side_wing_top2.addBox(0F, 0F, 0F, 12, 4, 1);
        Side_wing_top2.setRotationPoint(3F, 8F, -5F);
        Side_wing_top2.setTextureSize(64, 64);
        Side_wing_top2.mirror = true;
        setRotation(Side_wing_top2, 0F, 0F, -2.862753F);
        Side_wing_bottom2 = new ModelRenderer(this, 0, 44);
        Side_wing_bottom2.addBox(0F, 0F, 0F, 12, 4, 1);
        Side_wing_bottom2.setRotationPoint(3F, 9F, -5F);
        Side_wing_bottom2.setTextureSize(64, 64);
        Side_wing_bottom2.mirror = true;
        setRotation(Side_wing_bottom2, 0F, 0F, 2.991742F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Foot1.render(f5);
        Foot2.render(f5);
        Leg1.render(f5);
        Leg2.render(f5);
        Joint1.render(f5);
        Joint2.render(f5);
        Shoulder1.render(f5);
        Shoulder2.render(f5);
        Main_Body.render(f5);
        Butt.render(f5);
        Feather1.render(f5);
        Feather2.render(f5);
        Feather3.render(f5);
        Lower_Neck.render(f5);
        Main_Neck.render(f5);
        Head.render(f5);
        Bottom_Beak.render(f5);
        Top_Beak.render(f5);
        Side_wing_top1.render(f5);
        Side_wing_bottom1.render(f5);
        Side_wing_top2.render(f5);
        Side_wing_bottom2.render(f5);
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

