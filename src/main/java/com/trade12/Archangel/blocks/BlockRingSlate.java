package com.trade12.Archangel.blocks;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.Items.ItemLoader;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

/**
 * Created by Kieran on 25/08/2014.
 */
public class BlockRingSlate extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon ringSlateTop;

    @SideOnly(Side.CLIENT)
    private IIcon slateSides;

    public BlockRingSlate(String unlocalisedName)
    {
        super(Material.rock);
        this.setCreativeTab(Archangel.tabCustom);
        this.setHardness(1.0F);
        this.setBlockName(unlocalisedName);
        this.setBlockTextureName(Ref.UNLOCALISED_RINGSLATE);
        this.useNeighborBrightness = true;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8F, 1.0F);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        ringSlateTop = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_RINGSLATE);
        slateSides = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_BLANKSLATE);
    }

    @Override
    public IIcon getIcon(int a, int b)
    {
        if (a == 1)
        {
            return this.ringSlateTop;
        }
        else
        {
            return this.slateSides;
        }
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8F, 1.0F);
    }

    @Override
    public Item getItemDropped(int a, Random random, int b)
    {
        return ItemLoader.basicRing;
    }

}
