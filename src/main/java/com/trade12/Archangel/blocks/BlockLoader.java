package com.trade12.Archangel.blocks;

import com.trade12.Archangel.lib.Log;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * Created by Kieran on 25/08/2014.
 */
public class BlockLoader {

    public static Block cloud;
    public static Block AngelRune, ArielRune, NathanielRune, SarielRune, DormantRune;
    public static Block blankSlate, beltSlate, ringSlate, pendantSlate, RefinedCrystalSlate;
    public static Block AngelVent, NathanielFireBox, SarielProducer;
    public static Block NathanielBangle;
    public static Block CraftingRune;


    public static void load()
    {
        cloud = new BlockCloud(Ref.UNLOCALISED_CLOUD);

        AngelRune = new BlockAngelRune(Ref.UNLOCALISED_ANGELRUNE);
        SarielRune = new BlockSarielRune(Ref.UNLOCALISED_SARIELRUNE);
        NathanielRune = new BlockNathanielRune(Ref.UNLOCALISED_NATHANIELRUNE);
        ArielRune = new BlockArielRune(Ref.UNLOCALISED_ARIELRUNE);
        DormantRune = new BlockDormantRune(Ref.UNLOCALISED_DORMANT_RUNE);

        blankSlate = new BlockBlankSlate(Ref.UNLOCALISED_BLANKSLATE);
        beltSlate = new BlockBeltSlate(Ref.UNLOCALISED_BELTSLATE);
        ringSlate = new BlockRingSlate(Ref.UNLOCALISED_RINGSLATE);
        pendantSlate = new BlockPendantSlate(Ref.UNLOCALISED_PENDANTSLATE);
        RefinedCrystalSlate = new BlockRefinedCrystalSlate(Ref.UNLOCALISED_REFINEDSLATE);

        AngelVent = new BlockAngelVent(Ref.UNLOCALISED_ANGEL_VENT);
        NathanielFireBox = new BlockNathanielFireBox(Ref.UNLOCALISED_NATHANIELFB);
        SarielProducer = new BlockSarielProducer(Ref.UNLOCALISED_SARIEL_PRODUCER);

        NathanielBangle = new BlockNathanielBangle(Ref.UNLOCALISED_NATHANIEL_BANGLE);

        CraftingRune = new BlockCraftingRune(Ref.UNLOCALISED_CRAFTING_RUNE_1);




        GameRegistry.registerBlock(cloud, "Archangel_clouds");

        GameRegistry.registerBlock(AngelRune, "Archangel_angelRune");
        GameRegistry.registerBlock(SarielRune, "Archangel_sarielRune");
        GameRegistry.registerBlock(NathanielRune, "Archangel_nathanielRune");
        GameRegistry.registerBlock(ArielRune, "Archangel_arielRune");
        GameRegistry.registerBlock(DormantRune, "Archangel_dormantRune");

        GameRegistry.registerBlock(blankSlate, "Archangel_blankSlate");
        GameRegistry.registerBlock(beltSlate, "Archangel_beltSlate");
        GameRegistry.registerBlock(ringSlate, "Archangel_ringSlate");
        GameRegistry.registerBlock(pendantSlate, "Archangel_pendantSlate");
        GameRegistry.registerBlock(RefinedCrystalSlate, "Archangel_refinedCrystalSlate");

        GameRegistry.registerBlock(AngelVent, "Archangel_angelVent");
        GameRegistry.registerBlock(NathanielFireBox, "Archangel_nathanielFireBox");
        GameRegistry.registerBlock(SarielProducer, "Archangel_sarielProducer");

        GameRegistry.registerBlock(NathanielBangle, "Archangel_nathanielBangle");

        GameRegistry.registerBlock(CraftingRune, "Archangel_craftingRune");
    }
}
