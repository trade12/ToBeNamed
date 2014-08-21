package com.trade12.Archangel.Items.Nathaniel;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Kieran on 21/08/2014.
 */
public class ItemNathanielStone extends Item {

    IIcon   itemIcon0, itemIcon1, itemIcon2, itemIcon3;
    public ItemNathanielStone()
    {
        super();
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_SARIEL_STONE);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register)
    {
        itemIcon0 = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_SARIEL_STONE + "0");
        itemIcon1 = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_SARIEL_STONE + "1");
        itemIcon2 = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_SARIEL_STONE + "2");
        itemIcon3 = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_SARIEL_STONE + "3");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int dmg)
    {
        if (dmg <= 400)
        {
            return itemIcon3;
        }
        if (dmg <= 600 && dmg > 400)
        {
            return itemIcon2;
        }
        if (dmg < 1000 && dmg > 800)
        {
            return itemIcon1;
        }
        else
        {
            return itemIcon0;
        }
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity player, int ia, boolean ba)
    {
        if (player.dimension == -1 && this.getDamage(itemStack) != this.getMaxDamage(itemStack))
        {
            this.setDamage(itemStack, getDamage(itemStack) -1);
        }
    }
}
