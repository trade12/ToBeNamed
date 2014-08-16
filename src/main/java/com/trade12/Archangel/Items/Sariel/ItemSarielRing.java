package com.trade12.Archangel.Items.Sariel;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.Config.ConfigHandler;
import com.trade12.Archangel.Items.ItemLoader;
import com.trade12.Archangel.lib.Ref;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Kieran on 15/08/2014.
 */
public class ItemSarielRing extends Item implements IBauble {

    public ItemSarielRing() {
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_SARIEL_RING);
    }


    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        this.itemIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_SARIEL_RING);
    }

    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        if (itemStack.stackTagCompound == null)
            itemStack.setTagCompound(new NBTTagCompound());

        itemStack.stackTagCompound.setInteger("charge", 0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useInfo) {
        if (itemStack.stackTagCompound == null)
            itemStack.setTagCompound(new NBTTagCompound());

        info.add("Current Charge: " + itemStack.stackTagCompound.getInteger("Charge"));
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entity) {
        if (entity instanceof EntityPlayer) {
            if (itemStack.stackTagCompound == null)
                itemStack.setTagCompound(new NBTTagCompound());

            EntityPlayer player = (EntityPlayer) entity;
            if (player.dimension == 1 && itemStack.stackTagCompound.getInteger("charge") < ConfigHandler.maxCharge) {
                itemStack.stackTagCompound.setInteger("charge", itemStack.stackTagCompound.getInteger("charge") + 1);
            }

            if (itemStack.stackTagCompound.getInteger("charge") < ConfigHandler.maxCharge) {
                if (player.inventory.hasItem(ItemLoader.sarielPower)) {
                    for (int ia = 0; ia <= 35; ia++) {
                        if (player.inventory.getStackInSlot(ia) != null) {
                            if (player.inventory.getStackInSlot(ia).getUnlocalizedName().equals("item.transposingBattery")) {
                                if (player.inventory.getStackInSlot(ia).stackTagCompound.getInteger("charge") > 0) {
                                    player.inventory.getStackInSlot(ia).stackTagCompound.setInteger("charge", player.inventory.getStackInSlot(ia).stackTagCompound.getInteger("charge") - 1);
                                    itemStack.stackTagCompound.setInteger("charge", itemStack.stackTagCompound.getInteger("charge") + 1);
                                }
                            }
                        }
                    }
                }
            }

            if (itemStack.stackTagCompound.getInteger("Charge") > 0)
            {
                if (itemStack.stackTagCompound.getInteger("Charge") > 10)
                {
                    if (player.inventory.hasItem(new ItemStack(Blocks.sandstone).getItem())) //todo; change blocks.sandstone to alternative block
                    {
                        for (int ia = 0; ia <= 35; ia++)
                        {
                            if (player.inventory.getStackInSlot(ia) != null)
                            {
                                if (player.inventory.getStackInSlot(ia).getItem() == new ItemStack(Blocks.sandstone).getItem() && player.inventory.getStackInSlot(ia).stackSize == 1)
                                {
                                    player.inventory.setInventorySlotContents(ia, new ItemStack(Blocks.end_stone));
                                    itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge")- 10);
                                }
                            }
                        }
                    }

                }
            }


        }

    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack)
    {
        return BaubleType.RING;
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entity)
    {
        if (!entity.worldObj.isRemote)
        {
            entity.worldObj.playSoundAtEntity(entity, "random.pop", 0.1F, 1.3F);
        }
    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entity)
    {
        if (!entity.worldObj.isRemote)
        {
            entity.worldObj.playSoundAtEntity(entity, "random.pop", 0.1F, 1.3F);
        }
    }

    @Override
    public boolean canEquip(ItemStack itemStack, EntityLivingBase entity)
    {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemStack, EntityLivingBase entity)
    {
        return true;
    }
}