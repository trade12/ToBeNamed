package com.trade12.Archangel;

import com.trade12.Archangel.Items.Angel.ItemAngelRing;
import org.lwjgl.opengl.GL11;

import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.RenderPlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Kieran on 28/08/2014.
*/

public class WingRenderHandler {

    @SubscribeEvent
    public void onPlayerRender(RenderPlayerEvent.Specials.Post event) {
        InventoryBaubles inv = PlayerHandler.getPlayerBaubles(event.entityPlayer);
        if(inv.getStackInSlot(0) != null && inv.getStackInSlot(0).getItem() instanceof ItemAngelRing) {
            GL11.glPushMatrix();
            IIcon icon = event.entityPlayer.worldObj.provider.isHellWorld ? ItemAngelRing.iconDemonWings : ItemAngelRing.iconWings;
            Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);

            boolean flying = event.entityPlayer.capabilities.isFlying;

            float rz = 120F;
            float rx = 20F + (float) ((Math.sin((double) event.entityPlayer.ticksExisted * (flying ? 0.4F : 0.2F)) + 0.5F) * (flying ? 30F : 5F));
            float d = 0F;
            float h = 0.4F;
            float i = 0.15F;

            float f = icon.getMinU();
            float f1 = icon.getMaxU();
            float f2 = icon.getMinV();
            float f3 = icon.getMaxV();

            if(event.entityPlayer.isSneaking())
                GL11.glRotatef(28.64789F, 1.0F, 0.0F, 0.0F);

            GL11.glTranslatef(-d, h, i);
            GL11.glRotatef(rz, 0F, 0F, 1F);
            GL11.glRotatef(rx, 1F, 0F, 0F);
            ItemRenderer.renderItemIn2D(Tessellator.instance, f1, f2, f, f3, icon.getIconWidth(), icon.getIconHeight(), 1F / 32F);
            GL11.glRotatef(-rx, 1F, 0F, 0F);
            GL11.glRotatef(-rz, 0F, 0F, 1F);

            GL11.glScalef(-1F, 1F, 1F);
            GL11.glRotatef(rz, 0F, 0F, 1F);
            GL11.glRotatef(rx, 1F, 0F, 0F);
            ItemRenderer.renderItemIn2D(Tessellator.instance, f1, f2, f, f3, icon.getIconWidth(), icon.getIconHeight(), 1F / 32F);
            GL11.glRotatef(-rx, 1F, 0F, 0F);
            GL11.glRotatef(-rz, 0F, 0F, 1F);
            GL11.glTranslatef(d, 0F, 0F);


            GL11.glColor3f(1F, 1F, 1F);
            GL11.glPopMatrix();
        }
    }
}
