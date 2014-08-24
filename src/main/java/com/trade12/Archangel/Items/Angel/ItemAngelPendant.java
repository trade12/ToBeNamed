package com.trade12.Archangel.Items.Angel;

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
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Kieran on 15/08/2014.
 */
public class ItemAngelPendant extends Item implements IBauble {

    int counter;
    boolean active;

    public ItemAngelPendant() {
        super();
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_ANGEL_PENDANT);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        this.itemIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_ANGEL_PENDANT);
    }



    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entity) {
        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)entity;

            if (ChargeHandler.canWindmakersCharge(itemStack, (int) player.posY))
            {
                ChargeHandler.addCharge(itemStack, 1);
            }

            if (ChargeHandler.hasRoomForCharge(itemStack))
            {
                PowerHandler.drainFromBatteryIfPossible(itemStack, player, ItemLoader.angelPower);
            }

            if (ChargeHandler.hasEnoughChargeForOperation(itemStack, 1))
            {
                player.fallDistance = 0;

                if (player.isAirBorne)
                {
                    counter++;
                }

                if (KeyHandler.pendant && ChargeHandler.hasEnoughChargeForOperation(itemStack, 1))
                {
                    active = true;
                    if (player.isSneaking())
                    {
                        player.addVelocity(0, 0.2, 0);
                        player.worldObj.spawnParticle("happyVillager", player.posX, player.posY-2, player.posZ, player.posX, player.posY, player.posZ);
                        counter++;
                    }
                }

                if (!KeyHandler.pendant)
                {
                    active = false;
                }

                if (counter == 100)
                {
                    ChargeHandler.removeCharge(itemStack, 1);
                    counter = 0;
                }
            }
        }
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack)
    {
        return BaubleType.AMULET;
    }


    @Override
    public boolean showDurabilityBar(ItemStack itemStack)

    {
        return  false;
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entity)
    {
        if (!entity.worldObj.isRemote)
        {
            entity.worldObj.playSoundAtEntity(entity, "random.pop", 0.1F, 1.3F);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useInfo)
    {
       ChargeHandler.addTooltipChargeInformation(itemStack, info);
        ChargeHandler.addSecondaryAbilityInformation(active, info);
    }

    public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
    {
        ChargeHandler.setCharge(itemStack, 0);
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
    public boolean canEquip(ItemStack itemstack, EntityLivingBase entity)
    {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase entity)
    {
        return true;
    }
}
