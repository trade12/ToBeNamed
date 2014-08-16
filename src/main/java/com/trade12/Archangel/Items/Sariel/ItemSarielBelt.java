package com.trade12.Archangel.Items.Sariel;

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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

import java.util.List;

/**
 * Created by Kieran on 16/08/2014.
 */
public class ItemSarielBelt extends Item implements IBauble {

    boolean active;
    public ItemSarielBelt()
    {
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_SARIEL_BELT);
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

        itemStack.stackTagCompound.setInteger("charge", 0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useInfo)
    {
        if (itemStack.stackTagCompound == null)
            itemStack.setTagCompound(new NBTTagCompound());

        info.add("Current Charge: " + itemStack.stackTagCompound.getInteger("charge"));
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
    public BaubleType getBaubleType(ItemStack itemStack)
    {
        return BaubleType.BELT;
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entity)
    {
        if (entity instanceof EntityPlayer)
        {
            if (itemStack.stackTagCompound == null)
                itemStack.setTagCompound(new NBTTagCompound());

            EntityPlayer player = (EntityPlayer)entity;
            if (player.dimension == 1 && itemStack.stackTagCompound.getInteger("charge") < ConfigHandler.maxCharge)
            {
                itemStack.stackTagCompound.setInteger("charge", itemStack.stackTagCompound.getInteger("charge") + 1);
            }

            if (itemStack.stackTagCompound.getInteger("charge") < ConfigHandler.maxCharge)
            {
                if (player.inventory.hasItem(ItemLoader.sarielPower))
                {
                    for (int ia = 0; ia <= 35; ia++)
                    {
                        if (player.inventory.getStackInSlot(ia) != null)
                        {
                            if(player.inventory.getStackInSlot(ia).getUnlocalizedName().equals("item.transposingBattery"))
                            {
                                if (player.inventory.getStackInSlot(ia).stackTagCompound.getInteger("charge") > 0)
                                {
                                    player.inventory.getStackInSlot(ia).stackTagCompound.setInteger("charge", player.inventory.getStackInSlot(ia).stackTagCompound.getInteger("charge")-1);
                                    itemStack.stackTagCompound.setInteger("charge", itemStack.stackTagCompound.getInteger("charge")+1);
                                }
                            }
                        }
                    }
                }
            }

            if (itemStack.stackTagCompound.getInteger("charge") > 0)
            {
                if (player.isInWater())
                {
                    if (player instanceof EntityPlayerMP)
                    {
                        EntityPlayerMP playerMP = (EntityPlayerMP)player;
                        float rand = itemRand.nextFloat();
                        if (playerMP.playerNetServerHandler.func_147362_b().isChannelOpen())
                        {
                            EnderTeleportEvent event = new EnderTeleportEvent(playerMP, playerMP.posX+rand, playerMP.posY+3, playerMP.posZ+rand, 5.0F);
                            if (!MinecraftForge.EVENT_BUS.post(event))
                            {
                                if (playerMP.isRiding())
                                {
                                    playerMP.mountEntity((Entity) null);
                                }
                            }
                            playerMP.setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
                            playerMP.fallDistance = 0.0F;
                            itemStack.stackTagCompound.setInteger("charge", itemStack.stackTagCompound.getInteger("charge") - 10);
                        }
                    }
                }
                if (KeyHandler.belt)
                {
                    if (itemStack.stackTagCompound.getInteger("charge") > 1)
                    {
                        player.addExperience(1);
                        itemStack.stackTagCompound.setInteger("charge", itemStack.stackTagCompound.getInteger("charge") - 2);
                    }
                    active = true;
                }
                if (!KeyHandler.belt)
                {
                    active = false;
                }
            }
        }
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack)
    {
        return false;
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

