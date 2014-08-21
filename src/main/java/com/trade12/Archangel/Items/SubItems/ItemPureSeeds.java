package com.trade12.Archangel.Items.SubItems;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

/**
 * Created by Kieran on 21/08/2014.
 */
public class ItemPureSeeds extends Item {

    public ItemPureSeeds()
    {
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_PURE_SEED);
        this.setMaxStackSize(1);
        this.setMaxDamage(5);
        this.setNoRepair();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register)
    {
        this.itemIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_PURE_SEED);
    }
}
