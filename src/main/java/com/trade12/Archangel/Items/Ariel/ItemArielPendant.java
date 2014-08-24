package com.trade12.Archangel.Items.Ariel;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.Config.ConfigHandler;
import com.trade12.Archangel.Handler.ChargeHandler;
import com.trade12.Archangel.Handler.KeyHandler;
import com.trade12.Archangel.Handler.PowerHandler;
import com.trade12.Archangel.Items.ItemLoader;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

import java.util.List;

/**
 * Created by Kieran on 21/08/2014.
 */
public class ItemArielPendant extends Item implements IBauble {

    int counter;
    boolean active;

    public ItemArielPendant() {
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_ARIEL_PENDANT);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        this.itemIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_ARIEL_PENDANT);
    }

    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {

        ChargeHandler.setCharge(itemStack, 0);
    }


    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useInfo)
    {
        ChargeHandler.addTooltipChargeInformation(itemStack, info);
        ChargeHandler.addSecondaryAbilityInformation(active,info);

    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entity) {
        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)entity;

            if (ChargeHandler.canArielCharge(itemStack, entity))
            {
                ChargeHandler.addCharge(itemStack, 1);
            }

            if (ChargeHandler.hasRoomForCharge(itemStack))
            {
                PowerHandler.drainFromBatteryIfPossible(itemStack, player, ItemLoader.arielPower);
            }

            if (ChargeHandler.hasEnoughChargeForOperation(itemStack, 10))
            {
                updateBlocks(player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
                counter++;

                if (counter == 100)
                {
                    counter = 0;
                    ChargeHandler.removeCharge(itemStack, 10);
                }

                if (KeyHandler.pendant && ChargeHandler.hasEnoughChargeForOperation(itemStack, 10))
                {
                    active = true;
                    double posY = player.posY-1.5;
                    int x = (int) player.posX;
                    int y = (int) posY;
                    int z = (int) player.posZ;
                    growBlocks(player.worldObj, x, y, z);
                    ChargeHandler.removeCharge(itemStack, 10);
                }

                if (!KeyHandler.pendant)
                {
                    active = false;
                }
            }
        }
    }

    public void growBlocks(World world, int x, int y, int z) {
        int range = 2;
        for (int ia = x - range; ia <= x + range; ia++) {
            for (int ib = z - range; ib <= z + range; ib++) {
                for (int ic = y - range; ic <= y + range; ic++) {
                    Block block = world.getBlock(ia, ic, ib);
                    if (block instanceof IGrowable) {
                        IGrowable plant = (IGrowable) block;
                        if (world.rand.nextInt(20)== 0) {
                            block.updateTick(world, ia, ic, ib, world.rand);
                            plant.func_149853_b(world, world.rand, ia, ic, ib);
                            world.spawnParticle("happyVillager", (double) ia, (double) ic, (double) ib, (double) ia, (double) ic, (double) ib);
                        }
                    }
                }
            }
        }
    }

    public void updateBlocks(World world, int x, int y, int z) {
        int range = 2;
        for (int ia = x - range; ia <= x + range; ia++) {
            for (int ib = z - range; ib <= z + range; ib++) {
                for (int ic = y - range; ic <= y + range; ic++) {
                    Block block = world.getBlock(ia, ic, ib);
                    if (block instanceof IPlantable) {
                        if (world.rand.nextInt() == 0) {
                            block.updateTick(world, ia, ic, ib, world.rand);
                        }
                    }
                }
            }
        }
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.AMULET;
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entity) {
        if (!entity.worldObj.isRemote) {
            entity.worldObj.playSoundAtEntity(entity, "random.pop", 0.1F, 1.3f);
        }
    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entity) {
        if (!entity.worldObj.isRemote) {
            entity.worldObj.playSoundAtEntity(entity, "random.pop", 0.1F, 1.3f);
        }
    }

    @Override
    public boolean canEquip(ItemStack itemStack, EntityLivingBase entity) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemStack, EntityLivingBase entity) {
        return true;
    }
}

