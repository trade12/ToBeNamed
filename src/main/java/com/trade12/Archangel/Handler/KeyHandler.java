package com.trade12.Archangel.Handler;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by Kieran on 15/08/2014.
 */
public class KeyHandler {

    public static final int BELT = 0;
    public static final int PENDANT = 1;
    private static final String[] desc = {"key.Archangel.descBelt", "key.Archangel.descPendant"};
    private static final int[] keyValues = {Keyboard.KEY_C, Keyboard.KEY_X};
    public final KeyBinding[] keys;
    public static boolean belt, pendant;


    @SideOnly(Side.CLIENT)
    public KeyHandler() {
        keys = new KeyBinding[desc.length];
        for (int i = 0; i < desc.length; ++i)
        {
            keys[i] = new KeyBinding(desc[i], keyValues[i], "key.Archangel.category");
            ClientRegistry.registerKeyBinding(keys[i]);
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {
            if (keys[BELT].isPressed()) {
                if (belt) {
                    belt = false;
                } else if (!belt) {
                    belt = true;
                }
            }
            if (keys[PENDANT].isPressed()) {
                if (pendant) {
                    pendant = false;
                } else if (!pendant) {
                    pendant = true;
                }
            }
        }
    }

}
