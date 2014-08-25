package com.trade12.Archangel.blocks.TileEntity;

import com.trade12.Archangel.blocks.BlockLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

import java.util.List;

/**
 * Created by Kieran on 25/08/2014.
 */
public class TileEntitySarielProducer extends TileEntity {

    @Override
    public void updateEntity()
    {
        List entities = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord, zCoord - 1, xCoord + 1, yCoord + 2, zCoord + 1));
        for (Object obj : entities)
        {
            if (obj instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer)obj;
                if (!player.isInWater())
                {
                    player.fallDistance = 0;
                    if (player instanceof EntityPlayerMP)
                    {
                        if (!player.isSneaking() && !player.onGround && worldObj.getBlock(xCoord, yCoord+5, zCoord) == BlockLoader.SarielRune)
                        {
                            EntityPlayerMP playerMP = (EntityPlayerMP)player;
                            if (playerMP.playerNetServerHandler.func_147362_b().isChannelOpen())
                            {
                                EnderTeleportEvent event = new EnderTeleportEvent(playerMP, playerMP.posX, playerMP.posY+5, playerMP.posZ, 5.0F);
                                playerMP.setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
                                playerMP.fallDistance = 0.0F;
                            }
                        }
                        if (player.isSneaking()&& player.onGround && worldObj.getBlock(xCoord, yCoord-5, zCoord) == BlockLoader.SarielRune)
                        {
                            EntityPlayerMP playerMP = (EntityPlayerMP)player;
                            if (playerMP.playerNetServerHandler.func_147362_b().isChannelOpen())
                            {
                                EnderTeleportEvent event = new EnderTeleportEvent(playerMP, playerMP.posX, playerMP.posY-5, playerMP.posZ, 5.0F);
                                playerMP.setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
                                playerMP.fallDistance = 0.0F;
                            }
                        }
                    }
                }
            }
        }
    }
}
