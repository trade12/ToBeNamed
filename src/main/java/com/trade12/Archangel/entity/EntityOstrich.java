package com.trade12.Archangel.entity;

import com.trade12.Archangel.Items.ItemLoader;
import com.trade12.Archangel.lib.Ref;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.world.World;

/**
 * Created by Kieran on 16/08/2014.
 */
public class EntityOstrich extends EntityAnimal {

    public float field_70886_e;
    public float destPos;
    public float field_70884_g;
    public float field_70888_h;
    public float field_70889_i = 1.0F;
    public EntityOstrich(World world)
    {
        super(world);
        this.setSize(0.8F, 2.0F);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, Items.wheat_seeds, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        this.field_70888_h = this.field_70886_e;
        this.field_70884_g = this.destPos;
        this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);

        if (this.destPos < 0.0F)
        {
            this.destPos = 0.0F;
        }

        if (this.destPos > 1.0F)
        {
            this.destPos = 1.0F;
        }

        if (!this.onGround && this.field_70889_i < 1.0F)
        {
            this.field_70889_i = 1.0F;
        }

        this.field_70889_i = (float)((double)this.field_70889_i * 0.9D);

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }

        this.field_70886_e += this.field_70889_i * 2.0F;
    }

    protected void fall(float x) {}
    protected String getLivingSound()
    {
        return ("archangel:ostrichSay");
    }
    protected String getHurtSound()

    {
        return ("archangel:ostrichSay");
    }
    protected String getDeathSound()
    {
        return "archangel:ostrichSay";
    }

  /**  protected void func_145780_a(int x, int y, int z, Blocks block)
    {
        this.playSound("mob.chicken.step", 0.15F, 1.0F);
    }
**/

    protected Item getDropItem()
    {
        return ItemLoader.ostrichFeather;
    }

    protected void dropFewItems(boolean bool, int nom)
    {
        this.dropItem(Items.feather, 3);
    }

    public EntityOstrich createChild(EntityAgeable ageable)
    {
        return new EntityOstrich(this.worldObj);
    }

    public boolean isBreedingItem(ItemStack itemStack)
    {
        return itemStack != null && itemStack.getItem() instanceof ItemSeeds;
    }

    protected void dropRareDrop(int par1)
    {
        this.dropItem(ItemLoader.ostrichFeather, 1);
    }


}
