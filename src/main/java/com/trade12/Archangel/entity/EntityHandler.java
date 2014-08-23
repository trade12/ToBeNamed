package com.trade12.Archangel.entity;

import com.trade12.Archangel.Archangel;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenHell;

import java.util.Random;

/**
 * Created by Kieran on 16/08/2014.
 */
public class EntityHandler
{
    @Mod.Instance()
    public static Archangel instance;

    public static void registerEntity(Class entityClass, String name, int primaryColour, int secondaryColour, BiomeGenBase biome, int min, int max, int rarity)
    {
        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        long seed = name.hashCode();
        Random rand = new Random(seed);


        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
        EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
        EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.creature, biome);
        EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColour, secondaryColour));

    }

    public static void registerEntityWithOstrachSpawns(Class entityClass, String name, int primaryColour, int secondaryColour, int min, int max, int rarity )
    {
        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        long seed = name.hashCode();
        Random rand = new Random(seed);

        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
        EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
        EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.creature, BiomeGenBase.beach);
        EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.creature, BiomeGenBase.birchForest);
        EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.creature, BiomeGenBase.birchForestHills);
        EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.creature, BiomeGenBase.extremeHills);
        EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.creature, BiomeGenBase.extremeHillsEdge);
        EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.creature, BiomeGenBase.extremeHillsPlus);
        EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.creature, BiomeGenBase.plains);
        EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.creature, BiomeGenBase.savanna);
        EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.creature, BiomeGenBase.savannaPlateau);
        EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.creature, BiomeGenBase.forest);
        EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.creature, BiomeGenBase.forestHills);
        EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.creature, BiomeGenBase.roofedForest);
        EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColour, secondaryColour));
    }

    public static void registerEntityWithDeathAngelSpawns(Class entityClass, String name, int primaryColour, int secondaryColour, int min, int max, int rarity)
    {
        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        long seed = name.hashCode();
        Random rand = new Random(seed);

        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
        EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
        EntityRegistry.addSpawn(entityClass,rarity,min,max, EnumCreatureType.creature, BiomeGenBase.hell);
    }



}
