package com.trade12.Archangel.blocks.TileEntity;

import com.trade12.Archangel.blocks.BlockLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import java.util.List;
import java.util.Objects;

/**
 * Created by Kieran on 25/08/2014.
 */
public class TileEntityAngelVent extends TileEntity {

    @Override
    public void updateEntity()
    {
        if (worldObj.getBlock(xCoord+1, yCoord, zCoord) == BlockLoader.AngelRune && worldObj.getBlock(xCoord-1, yCoord, zCoord) == BlockLoader.AngelRune && worldObj.getBlock(xCoord, yCoord, zCoord+1) == BlockLoader.AngelRune && worldObj.getBlock(xCoord, yCoord, zCoord-1) == BlockLoader.AngelRune)
        {
            List entities = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(xCoord-1, yCoord, zCoord-1, xCoord+1, yCoord + 2, zCoord+1));
            for (Object obj : entities)
            {
                if (obj instanceof EntityPlayer)
                {
                    EntityPlayer player = (EntityPlayer)obj;
                    if (!player.onGround && !player.isInWater())
                    {
                        player.fallDistance = 0;
                        if (!player.isSneaking())
                        {
                            if (player.posY > player.lastTickPosY)
                            {
                                double blocks = 8;
                                double multiplier = 0.03125;
                                double finalAmount = ((blocks) * (multiplier)) + (blocks % multiplier);
                                player.motionY += finalAmount;
                            }
                        }
                    }
                }
            }
        }
    }
}
