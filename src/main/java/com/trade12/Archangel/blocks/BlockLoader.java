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
    public static Block blankSlate, beltSlate, ringSlate, pendantSlate, focusCrystalSlate; //todo rename focusCrystal
    public static Block AngelVent, NathanielFireBox, SarielProducer;

    public static void load()
    {
        cloud = new BlockCloud(Ref.UNLOCALISED_CLOUD);

        AngelRune = new BlockAngelRune(Ref.UNLOCALISED_ANGELRUNE);
        SarielRune = new BlockSarielRune(Ref.UNLOCALISED_SARIELRUNE);
        NathanielRune = new BlockNathanielRune(Ref.UNLOCALISED_NATHANIELRUNE);

        blankSlate = new BlockBlankSlate(Ref.UNLOCALISED_BLANKSLATE);
        beltSlate = new BlockBeltSlate(Ref.UNLOCALISED_BELTSLATE);



        GameRegistry.registerBlock(cloud, "Archangel_clouds");
        GameRegistry.registerBlock(AngelRune, "Archangel_angelRune");
    }
}
