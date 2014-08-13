package com.trade12.Archangel.Items.Angel;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.Items.ItemLoader;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by kieran on 13/08/2014.
 */
public class ItemAngelRing extends Item implements IBauble {

    int counter;
    public ItemAngelRing()
    {
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_ANGELRING);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcon(IIconRegister register)
    {
        this.itemIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_ANGELRING);
    }

    public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
    {
        if (itemStack.stackTagCompound == null)
            itemStack.setTagCompound(new NBTTagCompound());

        itemStack.stackTagCompound.setInteger("Charge", 0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useInfo)
    {
        if (itemStack.stackTagCompound == null)
            itemStack.setTagCompound(new NBTTagCompound());

        info.add("Current Charge: " + itemStack.stackTagCompound.getInteger("Charge"));
    }

    @Override
    public void onEquipTick(ItemStack itemStack, EntityLivingBase entity)
    {
        if (entity instanceof EntityPlayer)
        {
            if (itemStack.stackTagCompound == null)
                itemStack.setTagCompound(new NBTTagCompound());

            EntityPlayer player = (EntityPlayer)entity;
            if (player.posY > 200 && itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge)  //todo: add Config Handler
            {
                itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge") + 1);
            }

            if (itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge)
            {
                if (player.inventory.hasItem(ItemLoader.AngelPower))
                {
                    for (int ia = 0; ia <= 35; ia++)
                    {
                        if (player.inventory.getStackInSlot(ia) != null)
                        {
                            if(player.inventory.getStackInSlot(ia).getUnlocalizedName().equals("item.angelPower"))
                            {
                                if (player.inventory.getStackInSlot(ia).stackTagCompound.getInteger("Charge") > 0)
                                {
                                    player.inventory.getStackInSlot(ia).stackTagCompound.setInteger("Charge", player.inventory.getStackInSlot(ia).stackTagCompound.getInteger("Charge")-1);
                                    itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge")+1);
                                }
                            }
                        }
                    }
                }
            }

            if (itemStack.stackTagCompound.getInteger("Charge") > 0)
            {
                player.capabilities.allowFlying = true;
                player.fallDistance = 0;
                if (player.isAirBorne)
                {
                    counter++;
                }
                if (counter == 100) //Thing this is 5 second xD
                {
                    itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge")- 10);
                    counter = 0;
                }
            }
            else if (!player.capabilities.isCreativeMode)
            {
                player.capabilities.allowFlying = false;
                player.capabilities.isFlying = false;
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
            entity.worldObj.playSoundAtEntity(entity, "Sound", 0.1F, 1.3F); //todo: add sound and input directory
        }
    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entity)
    {
        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)entity;
            if (!player.worldObj.isRemote && !player.capabilities.isCreativeMode)
            {
                player.worldObj.playSoundAtEntity(player, "Sound", 0.1F, 1.3F); //todo: add sound
                player.capabilities.allowFlying = false;
                player.capabilities.isFlying = false;
            }
        }
    }

    @Override
    public boolean canEquip(ItemStack itemStack, EntityLivingBase entity)
    {
        return true;
    }

    @Override
    public  boolean canUnequip(ItemStack itemStack, EntityLivingBase entity)
    {
        return true;
    }


}
