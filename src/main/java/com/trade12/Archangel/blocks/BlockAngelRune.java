package com.trade12.Archangel.blocks;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by Kieran on 25/08/2014.
 */
public class BlockAngelRune extends Block {

    public BlockAngelRune(String unlocalisedName)
    {
        super(Material.rock);
        this.setCreativeTab(Archangel.tabCustom);
        this.setHardness(1.0F);
        this.setBlockName(unlocalisedName);
        this.setBlockTextureName(Ref.UNLOCALISED_ANGELRUNE);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        this.blockIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_ANGELRUNE);
    }
}
