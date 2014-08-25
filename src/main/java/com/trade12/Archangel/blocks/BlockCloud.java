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

/**
 * Created by Kieran on 25/08/2014.
 */
public class BlockCloud extends Block {

    public BlockCloud(String unlocalisedName)
    {
        super(Material.glass);
        this.setCreativeTab(Archangel.tabCustom);
        this.setHardness(0.2F);
        this.setBlockName(unlocalisedName);
        this.setBlockTextureName(Ref.UNLOCALISED_CLOUD);
        this.useNeighborBrightness = true;
        this.setStepSound(soundTypeCloth);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        this.blockIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_CLOUD);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }
}
