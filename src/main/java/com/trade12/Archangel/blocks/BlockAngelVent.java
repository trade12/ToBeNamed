package com.trade12.Archangel.blocks;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.blocks.TileEntity.TileEntityAngelVent;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Kieran on 25/08/2014.
 */
public class BlockAngelVent extends Block {

    public BlockAngelVent(String unlocalizedName)
    {
        super(Material.rock);
        this.setCreativeTab(Archangel.tabCustom);
        this.setHardness(1.0F);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Ref.UNLOCALISED_ANGEL_VENT);
        this.setLightLevel(0.1F);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        this.blockIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_ANGEL_VENT);
    }

    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityAngelVent();
    }
}
