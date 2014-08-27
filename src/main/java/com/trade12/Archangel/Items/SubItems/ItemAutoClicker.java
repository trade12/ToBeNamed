package com.trade12.Archangel.Items.SubItems;

import java.util.List;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import baubles.api.BaubleType;
import baubles.api.IBauble;
/**
 * Created by Kieran on 27/08/2014.
 */
public class ItemAutoClicker extends Item implements IBauble {

    World world;

    public ItemAutoClicker() {
        super();
        this.setMaxStackSize(1);
        this.setMaxDamage(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_AUTO_CLICKER);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register)
    {
        this.itemIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_AUTO_CLICKER);
    }

    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean par4) {
        info.add(EnumChatFormatting.LIGHT_PURPLE + "Rapidly swings the players hand");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {
        return EnumRarity.common;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        player.swingItem();

    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
    }

    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return false;
    }
}
