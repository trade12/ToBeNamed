package com.trade12.Archangel.Items.SubItems;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Kieran on 21/08/2014.
 */
public class ItemEmpoweredFocus extends Item {

    public ItemEmpoweredFocus()
    {
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_EMPOWERED_FOCUS);
        this.setNoRepair();
        this.setMaxDamage(16);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useInfo)
    {
        if (this.getDurabilityForDisplay(itemStack) == 1)
        {
            info.add("Suppressed");
        }
        if (this.getDurabilityForDisplay(itemStack) != 1) {
            info.add("Awakened");
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register)
    {
        this.itemIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_EMPOWERED_FOCUS);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if (player.inventory.hasItem(Items.ender_pearl) && this.getDamage(itemStack) !=0)
        {
            player.inventory.consumeInventoryItem(Items.ender_pearl);
            this.setDamage(itemStack, this.getDamage(itemStack)-1);
            if (!player.worldObj.isRemote)
            {
                player.worldObj.playSoundAtEntity(player, "random.pop", 0.1F, 1.3F);
            }
        }
        else
        {
            return itemStack;
        }
        return itemStack;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int ia, int ib, int ic, int id, float fa, float fb, float fc)
    {
        return true;
    }
}

