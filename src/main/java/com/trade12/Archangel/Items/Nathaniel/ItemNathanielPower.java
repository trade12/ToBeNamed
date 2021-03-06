package com.trade12.Archangel.Items.Nathaniel;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.Config.ConfigHandler;
import com.trade12.Archangel.Handler.ChargeHandler;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Kieran on 16/08/2014.
 */
public class ItemNathanielPower extends Item {

    public ItemNathanielPower()
    {
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_NATHANIEL_POWER);

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register)
    {
        this.itemIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_NATHANIEL_POWER);
    }

    public void onCreated(ItemStack itemStack, World world, EntityLivingBase entity)
    {
        ChargeHandler.setCharge(itemStack, 0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useInfo)
    {
        ChargeHandler.addTooltipChargeInformation(itemStack, info);
        info.add(Ref.UNLOCALISED_POWER_DESC);
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int ia, boolean ba)
    {
        if (itemStack.stackTagCompound == null)
            itemStack.setTagCompound(new NBTTagCompound());

        if (entity.posY > 200 && itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge)
        {
            itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge") + 1);
        }
    }
}
