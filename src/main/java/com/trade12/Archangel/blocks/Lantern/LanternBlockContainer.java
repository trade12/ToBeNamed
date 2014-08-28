package com.trade12.Archangel.blocks.Lantern;

import com.trade12.Archangel.Archangel;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Kieran on 28/08/2014.
 */
public class LanternBlockContainer extends BlockContainer {

    public LanternBlockContainer() {
        super(Material.iron);
        this.setCreativeTab(Archangel.tabCustom);
        this.setBlockBounds(0.4F, 0.0F, 0.4F, 0.6F, 3.0F, 0.6F);
    }



    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityLantern();
    }


    @Override
    public int getRenderType() {
        return -1;
    }


    @Override
    public boolean isOpaqueCube() {
        return false;
    }


    public boolean renderAsNormalBlock() {
        return false;
    }


    public void registerIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon("");
    }
}
