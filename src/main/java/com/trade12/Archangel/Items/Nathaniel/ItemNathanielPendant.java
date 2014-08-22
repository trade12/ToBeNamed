package com.trade12.Archangel.Items.Nathaniel;

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
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

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
        if (entity instanceof EntityPlayer) {
            if (itemStack.stackTagCompound == null)
                itemStack.setTagCompound(new NBTTagCompound());

            EntityPlayer player = (EntityPlayer) entity;
            if (itemStack.stackTagCompound.getInteger("Charge ") > 0) {
                int x = (int) Math.round(player.posX - 0.5F);
                int y = (int) player.posY;
                int z = (int) Math.round(player.posZ - 0.5F);
                player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 10, 1));
                if (KeyHandler.pendant) {
                    if (player.worldObj.getBlockLightValue(x, y, z) < 6) {
                        if (player.worldObj.getBlock(x, y - 1, z) == Blocks.air) {
                            player.worldObj.setBlock(x , y-1 , z , Blocks.quartz_ore); //todo add the feature of secrets
                            itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge"));

                        }
                    }
                    active = true;
                }
                if (!KeyHandler.pendant) {
                    active = false;
                }
                if (counter == 100) {
                    itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge") - 1);
                    counter = 0;
                } else {
                    counter++;
                }
            }

        }
        if (entity.isBurning() && itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge || entity.dimension == -1 && itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge) {
            itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge") + 1);
        }
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;

            if (itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge) {
                if (player.inventory.hasItem(ItemLoader.nathanielPower)) {
                    for (int ia = 0; ia <= 35; ia++) {
                        if (player.inventory.getStackInSlot(ia) != null) {
                            if (player.inventory.getStackInSlot(ia).getUnlocalizedName().equals("item.nathanielPower")) {
                                if (player.inventory.getStackInSlot(ia).stackTagCompound.getInteger("charge") > 0) {
                                    player.inventory.getStackInSlot(ia).stackTagCompound.setInteger("charge", player.inventory.getStackInSlot(ia).stackTagCompound.getInteger("charge") - 1);
                                    itemStack.stackTagCompound.setInteger("charge", itemStack.stackTagCompound.getInteger("charge") + 1);
                                }
                            }
                        }
                    }
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
        if (itemStack.stackTagCompound == null)
            itemStack.setTagCompound(new NBTTagCompound());

        info.add("Current Charge: " + itemStack.stackTagCompound.getInteger("charge"));
        if (active)
        {
            info.add(EnumChatFormatting.DARK_PURPLE + "Secondary Ability Awakened");
        }
        if (!active)
        {
            info.add(EnumChatFormatting.WHITE + "Secondary Ability Suppressed");
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

    public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
    {
        if (itemStack.stackTagCompound == null)
            itemStack.setTagCompound(new NBTTagCompound());

        itemStack.stackTagCompound.setInteger("charge", 0);
    }
}