package com.trade12.Archangel.blocks;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Kieran on 25/08/2014.
 */
public class BlockNathanielBangle extends Block {

    public BlockNathanielBangle(String unlocalizedName)
    {
        super(Material.glass);
        this.setCreativeTab(Archangel.tabCustom);
        this.setHardness(0.0F);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Ref.UNLOCALISED_NATHANIEL_BANGLE);
        this.setBlockBounds(0.4F, 0.4F, 0.4F, 0.5F, 0.5F, 0.5F);
        this.setLightLevel(1.0F);
        this.needsRandomTick = true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        this.blockIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_NATHANIEL_BANGLE);
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
        this.setBlockBounds(0.4F, 0.4F, 0.4F, 0.5F, 0.5F, 0.5F);
    } //todo model lantern

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
        double d0 = (double)((float)x + 0.7F);
        double d1 = (double)((float)y + 0.4F);
        double d2 = (double)((float)z + 0.5F);
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;
        world.spawnParticle("flame", d0-d4, d1+d3, d2, 0.0D, 0.0D, 0.0D);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }

    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
        return false;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random)
    {
        return 0;
    }
}
