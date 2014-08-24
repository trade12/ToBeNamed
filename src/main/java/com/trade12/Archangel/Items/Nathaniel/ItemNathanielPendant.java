package com.trade12.Archangel.Items.Nathaniel;

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
import net.minecraft.init.Blocks;
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
 * Created by Kieran on 18/08/2014.
 */


public class ItemNathanielPendant extends Item implements IBauble {

    int counter;
    boolean active;

    public ItemNathanielPendant() {
        super();
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_NATHANIEL_PENDANT);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        this.itemIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_SARIEL_PENDANT);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.AMULET;
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entity) {
        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)entity;

            if (ChargeHandler.canNathanielCharge(itemStack, entity))
            {
                ChargeHandler.addCharge(itemStack, 1);
            }

            if (ChargeHandler.hasRoomForCharge(itemStack))
            {
                PowerHandler.drainFromBatteryIfPossible(itemStack, player, ItemLoader.nathanielPower);
            }

            if (ChargeHandler.hasEnoughChargeForOperation(itemStack, 10))
            {
                World world = player.worldObj;
                int x = (int) (player.posX);
                int floor = (int) (player.posY - 2);
                int z = (int) (player.posZ);

                if ((world.getBlock(x, floor, z) == Blocks.lava) || (world.getBlock(x, floor, z) == Blocks.flowing_lava))
                {
                    player.addVelocity(0, 0.2, 0);
                    player.fallDistance = 0;
                    counter++;
                }

                if (counter == 100)
                {
                    ChargeHandler.removeCharge(itemStack, 10);
                    counter = 0;
                }
            }

            if (ChargeHandler.hasEnoughChargeForOperation(itemStack, 5))
            {
                if (KeyHandler.belt)
                {
                    active = true;
                    if (player.worldObj.getBlock((int) player.posX - 1, (int) player.posY, (int) player.posZ - 1) == Blocks.air)
                    {
                        player.worldObj.setBlock((int) player.posX - 1, (int) player.posY, (int) player.posZ - 1, Blocks.fire);
                        ChargeHandler.removeCharge(itemStack, 5);
                    }
                }

                if (!KeyHandler.belt)
                {
                    active = false;
                }
            }
        }
    }


    @Override
    public boolean showDurabilityBar(ItemStack itemStack)
    {
        return false;
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entity)
    {
        if (!entity.worldObj.isRemote)
        {
            entity.worldObj.playSoundAtEntity(entity, "random.pop", 0.1F, 1.4F);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useInfo)
    {
        ChargeHandler.addTooltipChargeInformation(itemStack, info);
        ChargeHandler.addSecondaryAbilityInformation(active, info);
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

    public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
    {
        ChargeHandler.setCharge(itemStack, 0);
    }
}