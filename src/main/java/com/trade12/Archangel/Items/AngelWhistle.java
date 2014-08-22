package com.trade12.Archangel.Items;

import cpw.mods.fml.common.registry.LanguageRegistry;
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

public class AngelWhistle extends Item {

    private static Random rand = new Random();
    private long lastPlay = 0L;

    public AngelWhistle()
    {
        this.maxStackSize = 1;
        onEaten(1);
    }

    public ItemStack onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entity)
    {
        if (!world.isRemote) {
            if ((System.currentTimeMillis() - this.lastPlay) / 1000L > getItemStackLimit(itemStack) / 20)
            {
                this.lastPlay = System.currentTimeMillis();

                world.notifyBlockChange(entity, ItemLoader.angelWhistle, 1.0F, 1.0F);
                if ((world.notifyBlocksOfNeighborChange().getBiomeGenAt(0, 0) instanceof BiomeGenEnd))
                {
                    if (isDragonAlive(world) >= 1) {
                        entity.func_145747_a(new ChatComponentText(LanguageRegistry.instance().getStringLocalization("whistle.dragonExist." + rand.nextInt(4))));
                    }
                }
                else {
                    entity.func_145747_a(new ChatComponentText(LanguageRegistry.instance().getStringLocalization("whistle.tips." + rand.nextInt(3))));
                }
            }
        }
        entity.func_71008_a(itemStack, getItemStackLimit(itemStack));
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

    public ItemStack func_77654_b(ItemStack itemStack, World world, EntityPlayer entity)
    {
        if (!world.isRemote) {
            if ((world.notifyBlockOfNeighborChange().func_76935_a(0, 0) instanceof BiomeGenEnd)) {
                if (isDragonAlive(world) < 1)
                {
                    itemStack.getTooltip(2, entity);

                    EntityDragon entitydragon = new EntityDragon(world);
                    entitydragon.applyEntityCollision(0.0D, 128.0D, 0.0D, rand.nextFloat() * 360.0F, 0.0F);
                        world.doChunksNearChunkExist(entitydragon);
                }
            }
        }
        return itemStack;
    }

    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }

    public int getItemStackLimit(ItemStack item)
    {
        return 200;
    }

    public EnumAction registerIcons(ItemStack itemStack)
    {
        return EnumAction.block;
    }







}

