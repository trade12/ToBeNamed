package com.trade12.Archangel.Items;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenEnd;
import org.lwjgl.Sys;

import java.util.List;
import java.util.Random;

/**
 * Created by Kieran on 22/08/2014.
**/

public class AngelWhistle extends Item {

    private static Random rand = new Random();
    private long lastPlay = 0L;

    public AngelWhistle()
    {
        this.maxStackSize = 1;
        this.setMaxDamage(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_ANGEL_WHISTLE);
    }


    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entity)
    {
        if (!world.isRemote) {
            if ((System.currentTimeMillis() - this.lastPlay) / 1000L > getMaxItemUseDuration(itemStack) / 20)
            {
                this.lastPlay = System.currentTimeMillis();

                world.playSoundAtEntity(entity, "archangel:flute", 1.0F, 1.0F);
                if ((world.getWorldChunkManager().getBiomeGenAt(0, 0) instanceof BiomeGenEnd))
                {
                    if (isDragonAlive(world) >= 1) {
                        entity.addChatComponentMessage(new ChatComponentText(LanguageRegistry.instance().getStringLocalization("flute.dragonExist." + rand.nextInt(4))));
                    }
                }
                else {
                    entity.addChatComponentMessage(new ChatComponentText(LanguageRegistry.instance().getStringLocalization("flute.tips." + rand.nextInt(3))));
                }
            }
        }
        entity.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    private int isDragonAlive(World world)
    {
        List list = world.loadedEntityList;
        int dragonNum = 0;
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) instanceof EntityDragon)) {
                dragonNum++;
            }
        }
        return dragonNum;
    }

    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entity)
    {
        if (!world.isRemote) {
            if ((world.getWorldChunkManager().getBiomeGenAt(0, 0) instanceof BiomeGenEnd)) {
                if (isDragonAlive(world) < 1)
                {
                    itemStack.damageItem(2, entity);

                    EntityDragon entitydragon = new EntityDragon(world);
                    entitydragon.setLocationAndAngles(0.0D, 128.0D, 0.0D, rand.nextFloat() * 360.0F, 0.0F);
                    world.spawnEntityInWorld(entitydragon);
                }
            }
        }
        return itemStack;
    }

    public boolean isFull3D()
    {
        return true;
    }

    public int getMaxItemUseDuration(ItemStack item)
    {
        return 200;
    }

    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
    }
}