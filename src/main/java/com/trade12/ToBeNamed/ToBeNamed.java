package com.trade12.ToBeNamed;

import com.trade12.ToBeNamed.Proxy.CommonProxy;
import com.trade12.ToBeNamed.lib.Ref;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by kieran on 13/08/2014.
 */
@Mod(modid= Ref.MOD_ID, name=Ref.MOD_NAME, version=Ref.VERSION_NUMBER)
public class ToBeNamed {

    @Mod.Instance(Ref.MOD_ID)
    public static ToBeNamed instance;

    @SidedProxy(clientSide = Ref.CLIENT_PROXY_CLASS, serverSide = Ref.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    //Config stuff here

    public static boolean LogDebug = true;

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
