package com.trade12.Archangel.Items.SubItems;


import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.lib.NBTHelper;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Kieran on 27/08/2014.
 */
public class ItemFeatherAttraction extends Item {

    public ItemFeatherAttraction() {
        super();
        this.setMaxDamage(0);
        this.setMaxStackSize(1);
        canRepair = false;
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_FEATHER_ATTRACTION);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.epic;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack, int pass) {
        return stack.getItemDamage() == 1;
    }

    @SideOnly(Side.CLIENT)
    private IIcon iconOverlay;

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        super.registerIcons(iconRegister);
        iconOverlay = iconRegister.registerIcon(Ref.MOD_ID.toLowerCase() + ":" + Ref.UNLOCALISED_FEATHER_ATTRACTION);
    }

    @Override
    public IIcon getIcon(ItemStack stack, int renderPass) {
        if (stack.getItemDamage() == 0 || renderPass != 1)
            return this.itemIcon;
        else
            return iconOverlay;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean f) {
            if (NBTHelper.getShort("soundTimer", stack) > 0) {
                if (NBTHelper.getShort("soundTimer", stack) % 2 == 0) {
                    world.playSoundAtEntity(entity, "random.orb", 0.1F, 0.5F * ((world.rand.nextFloat() - world.rand.nextFloat()) * 0.7F + 1.8F));
                }
                NBTHelper.setShort("soundTimer", stack, NBTHelper.getShort("soundTimer", stack) - 1);
            }
        if (stack.getItemDamage() == 0)
            return;
        EntityPlayer player = null;
        if (entity instanceof EntityPlayer) {
            player = (EntityPlayer) entity;
        }
        if (player == null)
            return;
        scanForEntitiesInRange(world, player, 5.0D);
    }

    private void scanForEntitiesInRange(World world, EntityPlayer player, double d) {
        List iList = world.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(player.posX - d, player.posY - d, player.posZ - d, player.posX + d, player.posY + d, player.posZ + d));
        Iterator iterator = iList.iterator();
        while (iterator.hasNext()) {
            EntityItem item = (EntityItem) iterator.next();
            if (!checkForRoom(item.getEntityItem(), player)) {
                continue;
            }
            if (item.delayBeforeCanPickup > 0) {
                item.delayBeforeCanPickup = 0;
            }
            if (player.getDistanceToEntity(item) < 1.5D) {
                continue;
            }
            teleportEntityToPlayer(item, player);
            break;
        }
        List iList2 = world.getEntitiesWithinAABB(EntityXPOrb.class, AxisAlignedBB.getBoundingBox(player.posX - d, player.posY - d, player.posZ - d, player.posX + d, player.posY + d, player.posZ + d));
        Iterator iterator2 = iList2.iterator();
        while (iterator2.hasNext()) {
            EntityXPOrb item = (EntityXPOrb) iterator2.next();
            if (player.xpCooldown > 0) {
                player.xpCooldown = 0;
            }
            if (player.getDistanceToEntity(item) < 1.5D) {
                continue;
            }
            teleportEntityToPlayer(item, player);
            break;
        }
    }

    private void teleportEntityToPlayer(Entity item, EntityPlayer player) {
        player.worldObj.spawnParticle("mobSpell", item.posX + 0.5D + player.worldObj.rand.nextGaussian() / 8, item.posY + 0.2D, item.posZ + 0.5D + player.worldObj.rand.nextGaussian() / 8, 0.9D, 0.9D, 0.0D);
        player.getLookVec();
        double x = player.posX + player.getLookVec().xCoord * 0.2D;
        double y = player.posY - player.height / 2F;
        double z = player.posZ + player.getLookVec().zCoord * 0.2D;
        item.setPosition(x, y, z);
        {
            player.worldObj.playSoundAtEntity(player, "random.orb", 0.1F, 0.5F * ((player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat()) * 0.7F + 1.8F));
        }
    }

    private boolean checkForRoom(ItemStack item, EntityPlayer player) {
        int remaining = item.stackSize;
        for (ItemStack ist : player.inventory.mainInventory) {
            if (ist == null) {
                continue;
            }
            if (ist.getItem() == item.getItem() && ist.getItemDamage() == item.getItemDamage()) {
                if (ist.stackSize + remaining <= ist.getMaxStackSize())
                    return true;
                else {
                    int count = ist.stackSize;
                    while (count < ist.getMaxStackSize()) {
                        count++;
                        remaining--;
                        if (remaining == 0)
                            return true;
                    }
                }
            }
        }
        for (int slot = 0; slot < player.inventory.mainInventory.length; slot++) {
            if (player.inventory.mainInventory[slot] == null)
                return true;
        }
        return false;
    }

    @Override
    public void onUsingTick(ItemStack ist, EntityPlayer player, int count) {
        if (ist.getItemDamage() == 0)
            return;
        scanForEntitiesInRange(player.worldObj, player, 15.0D);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 64;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.block;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (world.isRemote)
            return stack;
        if (player.isSneaking()) {
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        } else {
            {
                NBTHelper.setShort("soundTimer", stack, 6);
            }
            stack.setItemDamage(stack.getItemDamage() == 0 ? 1 : 0);
        }
        return stack;
    }
}
