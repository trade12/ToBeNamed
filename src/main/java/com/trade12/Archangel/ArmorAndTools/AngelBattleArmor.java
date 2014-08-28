package com.trade12.Archangel.ArmorAndTools;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Kieran on 28/08/2014.
 */
public class AngelBattleArmor extends ItemArmor {


    public IIcon iconChest;
    public IIcon iconHelm;
    public IIcon iconLegs;

    public AngelBattleArmor(ArmorMaterial enumamormaterial, int j, int k)
    {
        super(enumamormaterial, j, k);
        this.setCreativeTab(Archangel.tabCustom);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register)
    {
        this.iconChest = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_ANGEL_ARMOR_CHEST);
    }



    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1)
    {
        return this.armorType == 1 ? this.iconChest: this.armorType == 0 ? this.iconHelm : this.iconLegs;
    }



}
