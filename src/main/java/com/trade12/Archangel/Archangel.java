package com.trade12.Archangel;

import com.trade12.Archangel.Proxy.CommonProxy;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

/**
 * Created by kieran on 13/08/2014.
 */
@Mod(modid= Ref.MOD_ID, name=Ref.MOD_NAME, version=Ref.VERSION_NUMBER)
public class Archangel {

    @Mod.Instance(Ref.MOD_ID)
    public static Archangel instance;

    @SidedProxy(clientSide = Ref.CLIENT_PROXY_CLASS, serverSide = Ref.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static CreativeTabs tabCustom = new CreativeTabs("Archangel") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.quartz_block);
        }
    };

    //Config stuff here


    @Mod.EventHandler
    public void preInt(FMLPreInitializationEvent event)
    {


    }



    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

            /* Wrap things up */
    }
}
