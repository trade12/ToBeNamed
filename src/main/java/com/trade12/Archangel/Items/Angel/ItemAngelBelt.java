package com.trade12.Archangel.Items.Angel;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.Config.ConfigHandler;
import com.trade12.Archangel.Handler.KeyHandler;
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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Kieran on 15/08/2014.
 */
public class ItemAngelBelt extends Item implements IBauble {

    int counter;
    boolean active;

    public ItemAngelBelt()
    {
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_ANGEL_BELT);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register)
    {
        this.itemIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_ANGEL_BELT);
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
        if (active)
        {
            info.add(EnumChatFormatting.DARK_PURPLE + "Secondary Ability Awakened");
        }

        if (!active)
        {
            info.add(EnumChatFormatting.DARK_PURPLE + "Secondary Ability Suppressed");
        }
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entity) {
        if (entity instanceof EntityPlayer) {
            if (itemStack.stackTagCompound == null)
                itemStack.setTagCompound(new NBTTagCompound());

            EntityPlayer player = (EntityPlayer) entity;
            if (player.posY > 200 && itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge) {
                itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge") + 1);
            }

            if (itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge) {
                if (player.inventory.hasItem(ItemLoader.angelPower)) {
                    for (int ia = 0; ia <= 35; ia++) {
                        if (player.inventory.getStackInSlot(ia) != null) {
                            if (player.inventory.getStackInSlot(ia).getUnlocalizedName().equals("item.AngelPower")) {
                                if (player.inventory.getStackInSlot(ia).stackTagCompound.getInteger("Charge") > 0) {
                                    player.inventory.getStackInSlot(ia).stackTagCompound.setInteger("Charge", player.inventory.getStackInSlot(ia).stackTagCompound.getInteger("Charge") - 1);
                                    itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge") + 1);
                                }
                            }
                        }
                    }
                }
            }
        if (itemStack.stackTagCompound.getInteger("charge") > 0)
        {
            player.capabilities.setPlayerWalkSpeed(0.2F);
            if (KeyHandler.belt)
            {
                active = true;
                player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 10, 3));
                counter++;
            }
            if (!KeyHandler.belt)
            {
                active = false;
            }
            counter++;
            if (counter == 100) //5 seconds == 100 ticks
            {
                itemStack.stackTagCompound.setInteger("charge", itemStack.stackTagCompound.getInteger("charge") - 1);
                counter = 0;
            }
        }
        else
        {
            player.capabilities.setPlayerWalkSpeed(0.1F);
            player.removePotionEffect(Potion.jump.getId());
        }
    }
}

    @Override
    public BaubleType getBaubleType(ItemStack itemStack)
    {
        return BaubleType.BELT;
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entity)
    {
        if (!entity.worldObj.isRemote)
        {
            entity.worldObj.playSoundAtEntity(entity, "random.pop", 0.1F, 1.3f);
        }
    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entity)
    {
        if (!entity.worldObj.isRemote)
        {
            entity.worldObj.playSoundAtEntity(entity, "random.pop", 0.1F, 1.3f);
            if (entity instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer)entity;
                player.capabilities.setPlayerWalkSpeed(0.1F);
                player.removePotionEffect(Potion.jump.getId());
            }
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