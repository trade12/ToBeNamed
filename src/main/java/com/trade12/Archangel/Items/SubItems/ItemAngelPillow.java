package com.trade12.Archangel.Items.SubItems;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.Handler.MathHandler;
import com.trade12.Archangel.Items.Angel.ItemAngelPendant;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Kieran on 21/08/2014.
 */
public class ItemAngelPillow extends Item {

    @SideOnly(Side.CLIENT)
    private IIcon[] icon;

    int itemCount = 2;

    public ItemAngelPillow()
    {
        this.setHasSubtypes(true);
        this.setCreativeTab(Archangel.tabCustom);
        this.setMaxStackSize(1);
    }

    public String getUnlocalizedName(ItemStack itemStack)
    {
        int i = MathHelper.clamp_int(itemStack.getItemDamage(),0,itemCount -1);
        return super.getUnlocalizedName() + "." + Ref.UNLOCALISED_ANGEL_PILLOW[i];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int j = 0; j < itemCount; ++j)
        {
            list.add(new ItemStack(this, 1, j));
        }
    }

    @Override
    public void registerIcons(IIconRegister register)
    {
        this.icon = new IIcon[Ref.UNLOCALISED_ANGEL_PILLOW.length];
        for (int i = 0; i < Ref.UNLOCALISED_ANGEL_PILLOW.length; ++i)
        {
            this.icon[i] = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_ANGEL_PILLOW[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
        int j= MathHelper.clamp_int(meta, 0, itemCount-1);
        return this.icon[j];
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity player, int ia, boolean ba)
    {
        if (player.posY > 200 && this.getDamage(itemStack) ==0)
        {
            this.setDamage(itemStack, 1);
        }
    }
}
