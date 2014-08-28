package com.trade12.Archangel.Items.Angel;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.Config.ConfigHandler;
import com.trade12.Archangel.Handler.ChargeHandler;
import com.trade12.Archangel.Handler.PowerHandler;
import com.trade12.Archangel.Items.ItemLoader;
import com.trade12.Archangel.lib.IconHelper;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import scala.tools.nsc.interpreter.Power;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import java.util.List;

/**
 * Created by kieran on 13/08/2014.
 */
public class ItemAngelRing extends Item implements IBauble {

    int counter;
    public static IIcon iconWings;
    public static IIcon iconDemonWings;

    public ItemAngelRing()
    {
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_ANGELRING);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register)
    {
        itemIcon = IconHelper.forItem(register, this, 0);
        iconWings = IconHelper.forItem(register, this, 1);
        iconDemonWings = IconHelper.forItem(register, this, 2);
    }

    public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
    {
        ChargeHandler.setCharge(itemStack, 0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useInfo)
    {
        ChargeHandler.addTooltipChargeInformation(itemStack, info);
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entity, LivingUpdateEvent event)
    {
        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)entity;

            if (ChargeHandler.canAngelCharge(itemStack, (int) player.posY))
            {
                ChargeHandler.addCharge(itemStack, 1);
            }

            if (ChargeHandler.hasRoomForCharge(itemStack))
            {
                PowerHandler.drainFromBatteryIfPossible(itemStack, player, ItemLoader.angelPower);
            }

            if (ChargeHandler.hasEnoughChargeForOperation(itemStack, 10))
            {
                player.capabilities.allowFlying = true;
                player.fallDistance = 0;

                if (player.isAirBorne)
                {
                    counter++;
                }

                if (counter == 100)
                {
                    ChargeHandler.removeCharge(itemStack, 10);
                    counter = 0;
                    if (!ChargeHandler.hasEnoughChargeForOperation(itemStack, 10) && !player.capabilities.isCreativeMode)
                    {
                        player.capabilities.allowFlying = false;
                        player.capabilities.isFlying = false;
                    }
                }
                if (player.capabilities.isFlying)
                {
                    if (Math.abs(player.motionX) > 0.1 || Math.abs(player.motionZ) > 0.1)
                    {
                        double x = event.entityLiving.posX - 0.5;
                        double y = event.entityLiving.posY - 1.7;
                        double z = event.entityLiving.posZ - 0.5;

                        String name = player.getGameProfile().getName();
                        float r = 1F;
                        float g = 1F;
                        float b = 1F;

                        if(name.equals("TheTrade12"))
                            g = 1F - ((float) Math.random() * 0.75F + 0.25F);
                        }

                        for(int i = 0; i < 3; i++)
                                Archangel.proxy.sparkleFX(event.entityLiving.worldObj, x + Math.random() * event.entityLiving.width, y + Math.random() * 0.4, z + Math.random() * event.entityLiving.width, r, g, b, 2F * (float) Math.random(), 20);
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
        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)entity;
            if (!player.worldObj.isRemote && !player.capabilities.isCreativeMode)
            {
                player.worldObj.playSoundAtEntity(player, "random.pop", 0.1F, 1.3F);
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
