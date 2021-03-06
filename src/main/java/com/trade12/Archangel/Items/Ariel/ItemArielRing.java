package com.trade12.Archangel.Items.Ariel;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.Config.ConfigHandler;
import com.trade12.Archangel.Handler.ChargeHandler;
import com.trade12.Archangel.Handler.PowerHandler;
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
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Kieran on 21/08/2014.
 */
public class ItemArielRing extends Item implements IBauble {

    int counter;
    public ItemArielRing()
    {
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_ARIEL_RING);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register)
    {
        this.itemIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_ARIEL_RING);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useInfo) {
        ChargeHandler.setCharge(itemStack, 0);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack)
    {
        return BaubleType.RING;
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entity)
    {
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
                if (player.getAbsorptionAmount() < 20)
                {
                    counter++;
                    if (player.getAbsorptionAmount() < 10 && counter > 250)
                    {
                        player.setAbsorptionAmount(10);
                        ChargeHandler.removeCharge(itemStack, 10);
                        counter = 0;
                    }
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
    public void onEquipped(ItemStack itemStack, EntityLivingBase player)
    {
        if (!player.worldObj.isRemote)
        {
            player.worldObj.playSoundAtEntity(player, "random.pop", 0.1F, 1.3f);
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
