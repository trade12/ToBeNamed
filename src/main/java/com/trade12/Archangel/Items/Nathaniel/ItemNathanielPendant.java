package com.trade12.Archangel.Items.Nathaniel;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Kieran on 18/08/2014.
 */
public class ItemNathanielPendant extends Item implements IBauble {

    int counter;
    boolean active;
    public ItemNathanielPendant()
    {
        super();
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_NATHANIEL_PENDANT);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register)
    {
        this.itemIcon = register.registerIcon(Ref.MOD_ID + ":" Ref.UNLOCALISED_SARIEL_PENDANT);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack)
    {
        return BaubleType.AMULET;
    }

}
