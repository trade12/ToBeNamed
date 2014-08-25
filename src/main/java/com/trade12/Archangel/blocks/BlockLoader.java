package com.trade12.Archangel.blocks;

import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * Created by Kieran on 25/08/2014.
 */
public class BlockLoader {

    public static Block cloud;
    public static Block AngelRune, ArielRune, NathanielRune, SarielRune;

    public static void load()
    {
        cloud = new BlockCloud(Ref.UNLOCALISED_CLOUD);

        AngelRune = new BlockAngelRune(Ref.UNLOCALISED_ANGELRUNE);


        GameRegistry.registerBlock(cloud, "Archangel_clouds");
        GameRegistry.registerBlock(AngelRune, "Archangel_angelRune");
    }
}
