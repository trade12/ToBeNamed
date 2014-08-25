package com.trade12.Archangel.blocks;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

/**
 * Created by Kieran on 25/08/2014.
 */
public class BlockDormantRune extends Block {

    public BlockDormantRune(String unlocalizedName)
    {
        super(Material.rock);
        this.setCreativeTab(Archangel.tabCustom);
        this.setHardness(2);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Ref.UNLOCALISED_DORMANT_RUNE);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        this.blockIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_DORMANT_RUNE);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int ia, float fa, float fb, float fc)
    {
        checkRecipe(world, x, y, z, BlockLoader.cloud, BlockLoader.AngelRune);
        checkRecipe(world, x, y, z, Blocks.lava, BlockLoader.NathanielRune);
    //    checkRecipe(world, x, y, z, Blocks.water, BlockLoader.aquaticRune);
        checkRecipe(world, x, y, z, Blocks.grass, BlockLoader.ArielRune);
        checkRecipe(world, x, y, z, Blocks.end_stone, BlockLoader.SarielRune);
        return true;
    }

    public void checkRecipe(World world, int x, int y, int z, Block input, Block output)
    {
        if (world.getBlock(x-1, y, z-1) == input && world.getBlock(x+1, y, z-1) == input && world.getBlock(x-1, y, z+1) == input && world.getBlock(x+1, y, z+1) == input &&
                world.getBlock(x+1, y, z) == input && world.getBlock(x-1, y, z) == input && world.getBlock(x, y, z+1) == input && world.getBlock(x, y, z-1) == input)
        {
            world.setBlock(x, y, z-1, Blocks.air);
            world.setBlock(x-1, y, z-1, Blocks.air);
            world.setBlock(x+1, y, z-1, Blocks.air);
            world.setBlock(x-1, y, z, Blocks.air);
            world.setBlock(x+1, y, z, Blocks.air);
            world.setBlock(x-1, y, z+1, Blocks.air);
            world.setBlock(x+1, y, z+1, Blocks.air);
            world.setBlock(x, y, z+1, Blocks.air);

            world.setBlock(x, y, z, output);
        }
    }
}
