package com.trade12.Archangel.blocks.TileEntity;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.blocks.BlockLoader;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

/**
 * Created by Kieran on 25/08/2014.
 */
public class BlockArielAdapter extends Block {

    int i = 0;
    public BlockArielAdapter(String unlocalizedName)
    {
        super(Material.rock);
        this.setCreativeTab(Archangel.tabCustom);
        this.setHardness(1.0F);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Ref.UNLOCALISED_ARIEL_ADAPTER);
        this.setTickRandomly(true);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        this.blockIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_ARIEL_ADAPTER);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        if (world.getBlock(x, y-1, z) == BlockLoader.ArielRune)
        {
            Block block = world.getBlock(x, y+1, z);
            if (block instanceof IGrowable)
            {
                IGrowable plant = (IGrowable) block;
                block.updateTick(world, x, y+1, z, world.rand);
                block.updateTick(world, x, y+1, z, world.rand);
                block.updateTick(world, x, y+1, z, world.rand);
                block.updateTick(world, x, y+1, z, world.rand);
                block.updateTick(world, x, y+1, z, world.rand);
                plant.func_149853_b(world, world.rand, x, y+1, z);
                world.spawnParticle("happyVillager", x, y+1, z, x, y+1, z);
            }
        }
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
    {
        return true;
    }

    @Override
    public boolean isFertile(World world, int x, int y, int z)
    {
        return true;
    }
}
