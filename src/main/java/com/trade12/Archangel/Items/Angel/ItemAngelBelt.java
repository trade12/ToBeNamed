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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import scala.Char;

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
        ChargeHandler.setCharge(itemStack, 0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useInfo)
    {
        ChargeHandler.addTooltipChargeInformation(itemStack, info);
        ChargeHandler.addSecondaryAbilityInformation(active, info);
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entity) {
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

            if (ChargeHandler.hasEnoughChargeForOperation(itemStack, 1))
            {
                player.capabilities.setPlayerWalkSpeed(0.2F);
                counter++;

                if (KeyHandler.belt && ChargeHandler.hasEnoughChargeForOperation(itemStack, 1))
                {
                    active = true;
                    player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 10, 3));
                    counter++;
                }

                if (!KeyHandler.belt)
                {
                    active = false;
                }

                if (counter == 100)
                {
                    ChargeHandler.removeCharge(itemStack, 1);
                    counter = 0;
                    if (!ChargeHandler.hasEnoughChargeForOperation(itemStack, 1))
                    {
                        player.capabilities.setPlayerWalkSpeed(0.1F);
                        if (KeyHandler.belt)
                        {
                            player.removePotionEffect(Potion.jump.getId());
                        }
                    }
                }
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