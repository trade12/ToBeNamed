package com.trade12.Archangel.Items.Ariel;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.Config.ConfigHandler;
import com.trade12.Archangel.Handler.KeyHandler;
import com.trade12.Archangel.Items.Angel.ItemAngelPendant;
import com.trade12.Archangel.Items.ItemLoader;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

import java.util.List;

/**
 * Created by Kieran on 21/08/2014.
 */
public class ItemArielPendant extends Item implements IBauble {

    int counter;
    boolean active;

    public ItemArielPendant() {
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_ARIEL_PENDANT);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        this.itemIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_ARIEL_PENDANT);
    }

    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        if (itemStack.stackTagCompound == null)
            itemStack.setTagCompound(new NBTTagCompound());

        itemStack.stackTagCompound.setInteger("Charge", 0);
    }


    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useInfo) {
        if (itemStack.stackTagCompound == null)
            itemStack.setTagCompound(new NBTTagCompound());

        info.add("Current Charge: " + itemStack.stackTagCompound.getInteger("Charge"));
        if (active) {
            info.add(EnumChatFormatting.DARK_PURPLE + Ref.UNLOCALISED_SECONDARY_ACTIVE);
        }
        if (!active) {
            info.add(EnumChatFormatting.DARK_PURPLE + Ref.UNLOCALISED_SECONDARY_DEACTIVE);
        }
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge && player.worldObj.canBlockSeeTheSky((int) player.posX, (int) player.posY - 1, (int) player.posZ) && player.worldObj.getWorldTime() > 0 && player.worldObj.getWorldTime() < 13000) {
                if (itemStack.stackTagCompound == null)
                    itemStack.setTagCompound(new NBTTagCompound());

                itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge") + 1);
            }
            if (KeyHandler.pendant) {
                active = true;
            }
            if (!KeyHandler.pendant) {
                active = false;
            }
            if (itemStack.stackTagCompound.getInteger("Charge") < ConfigHandler.maxCharge) {
                if (player.inventory.hasItem(ItemLoader.arielPower)) {
                    for (int ia = 0; ia <= 35; ia++) {
                        if (player.inventory.getStackInSlot(ia) != null) {
                            if (player.inventory.getStackInSlot(ia).getUnlocalizedName().equals("item.arielPower")) {
                                if (player.inventory.getStackInSlot(ia).stackTagCompound.getInteger("Charge") > 0) {
                                    player.inventory.getStackInSlot(ia).stackTagCompound.setInteger("Charge", player.inventory.getStackInSlot(ia).stackTagCompound.getInteger("Charge") - 1);
                                    itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge") + 1);
                                }
                            }
                        }
                    }
                }
            }

            if (itemStack.stackTagCompound.getInteger("Charge") >= 10) {
                updateBlocks(player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
                counter++;
                if (KeyHandler.pendant) {
                    double posY = player.posY - 1.5;
                    int x = (int) player.posX;
                    int y = (int) posY;
                    int z = (int) player.posZ;
                    growBlocks(player.worldObj, x, y, z);
                    itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge") - 10);
                }
                if (counter == 100) {
                    counter = 0;
                    itemStack.stackTagCompound.setInteger("Charge", itemStack.stackTagCompound.getInteger("Charge") - 10);
                }
            }
        }
    }

    public void growBlocks(World world, int x, int y, int z) {
        int range = 5;
        for (int ia = x - range; ia <= x + range; ia++) {
            for (int ib = z - range; ib <= z + range; ib++) {
                for (int ic = y - range; ic <= y + range; ic++) {
                    Block block = world.getBlock(ia, ic, ib);
                    if (block instanceof IGrowable) {
                        IGrowable plant = (IGrowable) block;
                        if (world.rand.nextInt(20) == 0) {
                            block.updateTick(world, ia, ic, ib, world.rand);
                            plant.func_149853_b(world, world.rand, ia, ic, ib);
                            world.spawnParticle("happyVillager", (double) ia, (double) ic, (double) ib, (double) ia, (double) ic, (double) ib);
                        }
                    }
                }
            }
        }
    }

    public void updateBlocks(World world, int x, int y, int z) {
        int range = 3;
        for (int ia = x - range; ia <= x + range; ia++) {
            for (int ib = z - range; ib <= z + range; ib++) {
                for (int ic = y - range; ic <= y + range; ic++) {
                    Block block = world.getBlock(ia, ic, ib);
                    if (block instanceof IPlantable) {
                        if (world.rand.nextInt(20) == 0) {
                            block.updateTick(world, ia, ic, ib, world.rand);
                        }
                    }
                }
            }
        }
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.AMULET;
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entity) {
        if (!entity.worldObj.isRemote) {
            entity.worldObj.playSoundAtEntity(entity, "random.pop", 0.1F, 1.3f);
        }
    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entity) {
        if (!entity.worldObj.isRemote) {
            entity.worldObj.playSoundAtEntity(entity, "random.pop", 0.1F, 1.3f);
        }
    }

    @Override
    public boolean canEquip(ItemStack itemStack, EntityLivingBase entity) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemStack, EntityLivingBase entity) {
        return true;
    }
}

