package com.trade12.Archangel.blocks.TileEntity;

import com.trade12.Archangel.blocks.BlockLoader;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import java.util.List;

/**
 * Created by Kieran on 25/08/2014.
 */
public class TileEntityNathanielFireBox extends TileEntity {

    @Override
    public void updateEntity()
    {
        if (worldObj.getBlock(xCoord+1, yCoord, zCoord+1) == BlockLoader.NathanielRune && worldObj.getBlock(xCoord+1, yCoord, zCoord-1) == BlockLoader.NathanielRune && worldObj.getBlock(xCoord-1, yCoord, zCoord+1) == BlockLoader.NathanielRune && worldObj.getBlock(xCoord-1, yCoord, zCoord-1) == BlockLoader.NathanielRune)
        {
            List entities = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord, zCoord - 1, xCoord + 1, yCoord + 2, zCoord + 1));
            for (Object obj : entities)
            {
                if (obj instanceof EntityLivingBase)
                {
                    EntityLivingBase entityLivingBase = (EntityLivingBase)obj;
                    entityLivingBase.setFire(3);
                    if (!entityLivingBase.worldObj.isRemote)
                    {
                        entityLivingBase.worldObj.playSoundAtEntity(entityLivingBase, "random.fizz", 0.1F, 1.3F);
                    }
                    worldObj.spawnParticle("flame", xCoord+0.5, yCoord+1, zCoord+0.5, 0.0D, 0.5D, 0.0D);
                }
            }
        }
    }
}
