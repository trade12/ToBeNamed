package com.trade12.Archangel.entity;

import com.trade12.Archangel.Items.ItemLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created by Kieran on 23/08/2014.
 */
public class EntityDeathAngel extends EntityZombie {

    public float field_70886_e;
    public float destPos;
    public float field_70884_g;
    public float field_70888_h;
    public float field_70889_i = 1.0F;

    public EntityDeathAngel(World world)
    {
        super(world);
        this.setSize(0.8F, 2.0F);
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.getAIMoveSpeed(),false));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }


    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
    }

 /**   protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }**/

   /** public void getMaxSafePointTries(DamageSource par1DamageSource)
    {
         super.getMaxSafePointTries(par1DamageSource);
    }
    **/

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
        return ("archangel:DeathAngel");
    }
    protected String getHurtSound()

    {
        return ("archangel:DeathAngelHurt");
    }
    protected String getDeathSound()
    {
        return "archangel:DeathAngelDeath";
    }


    protected Item getDropItem()
    {
        return Items.bone;
    }

    protected void dropFewItems(boolean bool, int nom)
    {
        this.dropItem(Items.quartz, 3);
    }



    protected void dropRareDrop(int par1)
    {
        this.dropItem(ItemLoader.heart, 1);
    }



  /**  protected void attackEntity(Entity entity, float p_70785_2_)
    {
        if (this.attackTime <= 0 && p_70785_2_ < 2.0F && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;
            this.attackEntityAsMob(entity);
        }
        else if (p_70785_2_ < 30.0F)
        {
            double d0 = entity.posX - this.posX;
            double d1 = entity.boundingBox.minY + (double)(entity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
            double d2 = entity.posZ - this.posZ;

            if (this.attackTime == 0)
            {
                ++this.maxHurtTime;

                if (this.maxHurtTime == 1)
                {
                    this.attackTime = 60;
                    this.func_70844_e(true);
                }
                else if (this.maxHurtTime <= 4)
                {
                    this.attackTime = 6;
                }
                else
                {
                    this.attackTime = 100;
                    this.maxHurtTime = 0;
                }

                if (this.maxHurtTime > 1)
                {
                    float f1 = MathHelper.sqrt_float(p_70785_2_) * 0.5F;
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);

                    for (int i = 0; i < 1; ++i)
                    {
                        EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.worldObj, this, d0 + this.rand.nextGaussian() * (double)f1, d1, d2 + this.rand.nextGaussian() * (double)f1);
                        entitysmallfireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
                        this.worldObj.spawnEntityInWorld(entitysmallfireball);
                    }
                }
            }

            this.rotationYaw = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
            this.hasAttacked = true;
        }
    }
**/
}
