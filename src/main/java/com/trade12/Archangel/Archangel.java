package com.trade12.Archangel;

import com.trade12.Archangel.Config.ConfigHandler;
import com.trade12.Archangel.Handler.KeyHandler;
import com.trade12.Archangel.Handler.RecipeHandler;
import com.trade12.Archangel.Items.ItemLoader;
import com.trade12.Archangel.NEI.InfoHandler;
import com.trade12.Archangel.Proxy.CommonProxy;
import com.trade12.Archangel.addon.enchiridion.EnchiridionHandler;
import com.trade12.Archangel.blocks.BlockLoader;
import com.trade12.Archangel.entity.EntityDeathAngel;
import com.trade12.Archangel.entity.EntityHandler;
import com.trade12.Archangel.entity.EntityOstrich;
import com.trade12.Archangel.lib.Ref;
import com.trade12.Archangel.lib.Log;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;



/**
 * Created by kieran on 13/08/2014.
 */
@Mod(modid= Ref.MOD_ID, name=Ref.MOD_NAME, version=Ref.VERSION_NUMBER, dependencies = Ref.DEPENDENCIES, guiFactory = Ref.MOD_GUI_FACTORY)
public class Archangel {

    @Mod.Instance(value = Ref.MOD_ID)
    public static Archangel instance;

    @SidedProxy(

            clientSide = Ref.CLIENT_PROXY_CLASS,
            serverSide = Ref.SERVER_PROXY_CLASS
    )

    public static CommonProxy proxy;

    public static CreativeTabs tabCustom = new CreativeTabs("Archangel")
    {
        @Override
        public Item getTabIconItem()
        {
            return (ItemLoader.angelPendant);
        }
    };



    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        ConfigHandler.init(event.getSuggestedConfigurationFile());
        ItemLoader.load();
        EntityHandler.registerEntityWithOstrachSpawns(EntityOstrich.class, "entityOstrach", 0x663300, 0x996600, 1, 2, 1);
        EntityHandler.registerEntityWithDeathAngelSpawns(EntityDeathAngel.class, "entityDeathAngel", 0x996600, 0x663300, 1, 2, 1);
        proxy.initRenders();
        RecipeHandler.initRecipes();
        EnchiridionHandler.load();
        Log.init();
        BlockLoader.load();


    }

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void preInitClient(FMLInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(new KeyHandler());
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

            /* Wrap things up */
    }
}
