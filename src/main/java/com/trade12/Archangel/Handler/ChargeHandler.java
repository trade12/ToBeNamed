package com.trade12.Archangel.Handler;

import com.trade12.Archangel.Config.ConfigHandler;
import com.trade12.Archangel.lib.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Kieran on 24/08/2014.
 */
public class ChargeHandler {

    public static boolean canAngelCharge(ItemStack itemStack, int y)
    {
        return !isTagNull(itemStack) && (itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge && y >= 200);
    }

    public static boolean canNathanielCharge(ItemStack itemStack, Entity entity)
    {
        return !isTagNull(itemStack) && (itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge && (entity.isBurning() || entity.dimension == -1));
    }

  /**  public static boolean canAquaticCharge(ItemStack itemStack, Entity entity)
    {
        return !isTagNull(itemStack) && (itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge && (entity.isInWater() || entity.worldObj.isRaining()));
    } **/

    public static boolean canArielCharge(ItemStack itemStack, Entity entity)
    {
        int x = (int) entity.posX;
        int y = (int) entity.posY;
        int z = (int) entity.posZ;
        World world = entity.worldObj;

        return !isTagNull(itemStack) && (itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge && world.canBlockSeeTheSky(x, y, z) && MathHandler.isDaytime(world, x, y, z));
    }

    public static boolean canSarielCharge(ItemStack itemStack, Entity entity)
    {
        return !isTagNull(itemStack) && (itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge && entity.dimension == 1);
    }

/**    public static boolean canFrostbittenCharge(ItemStack itemStack, Entity entity)
    {
        int x = (int) entity.posX;
        int y = (int) entity.posY;
        int z = (int) entity.posZ;
        World world = entity.worldObj;

        return !isTagNull(itemStack) && itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge && MathHandler.isCold(world, x, y, z);
    }**/

    public static void addCharge(ItemStack itemStack, int amount)
    {
        if (itemStack.stackTagCompound.getInteger("Charge") + amount <= ConfigHandler.maxCharge && !isTagNull(itemStack))
        {
            itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge") + amount);
        }
    }

    public static void removeCharge(ItemStack itemStack, int amount)
    {
        if (itemStack.stackTagCompound.getInteger("Charge") - amount >= 0 && !isTagNull(itemStack))
        {
            itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge") - amount);
        }
    }

public static void setCharge(ItemStack itemStack, int amount)
    {
        if (!isTagNull(itemStack))
        {
            itemStack.stackTagCompound.setInteger("Charge", amount);
        }
    }

    public static boolean isTagNull(ItemStack itemStack)
    {
        if (itemStack.stackTagCompound == null)
        {
            itemStack.setTagCompound(new NBTTagCompound());
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int getCharge(ItemStack itemStack)
    {
        if (!isTagNull(itemStack))
        {
            return itemStack.stackTagCompound.getInteger("Charge");
        }
        else
        {
            return 0;
        }
    }

    public static boolean hasRoomForCharge(ItemStack itemStack)
    {
        return getCharge(itemStack) < ConfigHandler.maxCharge;
    }

    public static boolean hasEnoughChargeForOperation(ItemStack itemStack, int cost)
    {
        return !isTagNull(itemStack) && (getCharge(itemStack) >= cost);
    }

    public static void addTooltipChargeInformation(ItemStack itemStack, List info)
    {
        if (!isTagNull(itemStack))
        {
            info.add("Current Charge: " + getCharge(itemStack));
        }
    }

    public static void addSecondaryAbilityInformation(boolean active, List info)
    {
        if (active)
        {
            info.add(EnumChatFormatting.LIGHT_PURPLE + Ref.UNLOCALISED_SECONDARY_ACTIVE);
        }
        if (!active)
        {
            info.add(EnumChatFormatting.LIGHT_PURPLE + Ref.UNLOCALISED_SECONDARY_DEACTIVE);
        }
    }
}
