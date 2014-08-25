package com.trade12.Archangel.blocks;

import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.Config.ConfigHandler;
import com.trade12.Archangel.blocks.BlockLoader;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

/**
 * Created by Kieran on 25/08/2014.
 */
public class BlockCraftingRune extends Block {

    public BlockCraftingRune(String unlocalizedName)
    {
        super(Material.rock);
        this.setCreativeTab(Archangel.tabCustom);
        this.setHardness(2);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Ref.UNLOCALISED_CRAFTING_RUNE_1);
        this.setLightLevel(1.0F);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        this.blockIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_CRAFTING_RUNE_1);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int ia, float fa, float fb, float fc)
    {
        addRecipe(world, x, y, z, Blocks.stone, Blocks.stone, Blocks.stone,
                Blocks.stone, Blocks.stone,
                Blocks.stone, Blocks.stone, Blocks.stone,

                Blocks.water, Blocks.water, Blocks.water,
                Blocks.water, Blocks.water,
                Blocks.water, Blocks.water, Blocks.water);

        addRecipe(world, x, y, z, Blocks.netherrack, Blocks.netherrack, Blocks.netherrack,
                Blocks.netherrack, Blocks.netherrack,
                Blocks.netherrack, Blocks.netherrack, Blocks.netherrack,

                Blocks.lava, Blocks.lava, Blocks.lava,
                Blocks.lava, Blocks.lava,
                Blocks.lava, Blocks.lava, Blocks.lava);

        addRecipe(world, x, y, z, Blocks.wool, Blocks.wool, Blocks.wool,
                Blocks.wool, Blocks.wool,
                Blocks.wool, Blocks.wool, Blocks.wool,

                BlockLoader.cloud, BlockLoader.cloud, BlockLoader.cloud,
                BlockLoader.cloud, BlockLoader.cloud,
                BlockLoader.cloud, BlockLoader.cloud, BlockLoader.cloud);

        if (ConfigHandler.timeBlock)
        {
            addRecipe(world, x, y, z, Blocks.obsidian, Blocks.obsidian, Blocks.obsidian,
                    Blocks.obsidian, Blocks.obsidian,
                    Blocks.obsidian, Blocks.obsidian, Blocks.obsidian,
                    "nighttime");

            addRecipe(world, x, y, z, Blocks.glowstone, Blocks.glowstone, Blocks.glowstone,
                    Blocks.glowstone, Blocks.glowstone,
                    Blocks.glowstone, Blocks.glowstone, Blocks.glowstone,
                    "daytime");
        }

        addRecipe(world, x, y, z, Blocks.glowstone, BlockLoader.cloud, Blocks.glowstone,
                BlockLoader.cloud, BlockLoader.cloud,
                Blocks.glowstone, BlockLoader.cloud, Blocks.glowstone,
                "thunder");

        addRecipeOutput1(world, x, y, z, Blocks.obsidian, Blocks.stone, BlockLoader.blankSlate);

        addRecipe(world, x, y, z, Blocks.wool, BlockLoader.blankSlate, Blocks.wool,
                Blocks.wool, Blocks.wool,
                Blocks.wool, Blocks.gold_block, Blocks.wool,

                Blocks.air, BlockLoader.beltSlate, Blocks.air,
                Blocks.air, Blocks.air,
                Blocks.air, Blocks.air, Blocks.air);

        addRecipe(world, x, y, z, Blocks.air, BlockLoader.blankSlate, Blocks.air,
                Blocks.light_weighted_pressure_plate, Blocks.light_weighted_pressure_plate,
                Blocks.air, Blocks.gold_block, Blocks.air,

                Blocks.air, BlockLoader.ringSlate, Blocks.air,
                Blocks.air, Blocks.air,
                Blocks.air, Blocks.air, Blocks.air);

        addRecipe(world, x, y, z, Blocks.tripwire, BlockLoader.blankSlate, Blocks.tripwire,
                Blocks.wool, Blocks.wool,
                Blocks.wool, Blocks.gold_block, Blocks.wool,

                Blocks.air, BlockLoader.pendantSlate, Blocks.air,
                Blocks.air, Blocks.air,
                Blocks.air, Blocks.air, Blocks.air);

        addRecipe(world, x, y, z, Blocks.emerald_block, BlockLoader.blankSlate, Blocks.diamond_block,
                Blocks.obsidian, Blocks.obsidian,
                Blocks.obsidian, Blocks.gold_block, Blocks.obsidian,

                Blocks.air, BlockLoader.RefinedCrystalSlate, Blocks.air,
                Blocks.air, Blocks.air,
                Blocks.air, Blocks.air, Blocks.air);

     /**   addRecipeOutput1(world, x, y, z, Blocks.obsidian, Blocks.cobblestone, BlockLoader.inertRune);

        transformIntoT2(world, x, y, z); **/

        return true;
    }

    public void addRecipe(World world, int x, int y, int z, Block a, Block b, Block c, Block d, Block e, Block f, Block g, Block h, Block outputa, Block outputb, Block outputc, Block outputd, Block outpute, Block outputf, Block outputg, Block outputh)
    {
        if (world.getBlock(x - 1, y, z - 1) == a && world.getBlock(x, y, z - 1) == b &&
                world.getBlock(x + 1, y, z - 1) == c && world.getBlock(x - 1, y, z) == d &&
                world.getBlock(x + 1, y, z) == e && world.getBlock(x - 1, y, z + 1) == f &&
                world.getBlock(x, y, z + 1) == g && world.getBlock(x + 1, y, z + 1) == h)
        {
            world.setBlock(x - 1, y, z - 1, outputa);
            world.setBlock(x, y, z - 1, outputb);
            world.setBlock(x + 1, y, z - 1, outputc);
            world.setBlock(x - 1, y, z, outputd);
            world.setBlock(x + 1, y, z, outpute);
            world.setBlock(x - 1, y, z + 1, outputf);
            world.setBlock(x + 1, y, z + 1, outputg);
            world.setBlock(x, y, z + 1, outputh);

            world.spawnParticle("happyVillager", (double) x,
                    (double) y + 1, (double) z, (double) x, (double) y + 1, (double) z);
        }
    }

    public void addRecipe(World world, int x, int y, int z, Block a, Block b, Block c, Block d, Block e, Block f, Block g, Block h, String output)
    {
        if (world.getBlock(x - 1, y, z - 1) == a && world.getBlock(x, y, z - 1) == b &&
                world.getBlock(x + 1, y, z - 1) == c && world.getBlock(x - 1, y, z) == d &&
                world.getBlock(x + 1, y, z) == e && world.getBlock(x - 1, y, z + 1) == f &&
                world.getBlock(x, y, z + 1) == g && world.getBlock(x + 1, y, z + 1) == h)
        {
            world.setBlock(x, y, z - 1, Blocks.air);
            world.setBlock(x - 1, y, z - 1, Blocks.air);
            world.setBlock(x + 1, y, z - 1, Blocks.air);
            world.setBlock(x - 1, y, z, Blocks.air);
            world.setBlock(x + 1, y, z, Blocks.air);
            world.setBlock(x - 1, y, z + 1, Blocks.air);
            world.setBlock(x + 1, y, z + 1, Blocks.air);
            world.setBlock(x, y, z + 1, Blocks.air);

            if (output.equals("nighttime"))
            {
                world.setWorldTime(18000);
            }
            if (output.equals("daytime"))
            {
                world.setWorldTime(6000);
            }
            if (output.equals("thunder"))
            {
                world.addWeatherEffect(new EntityLightningBolt(world, x, y, z));
            }
            if (output.equals("break"))
            {
                world.setBlock(x, y + 1, z, Blocks.air);
            }

            world.spawnParticle("happyVillager", (double) x,
                    (double) y + 1, (double) z, (double) x, (double) y + 1, (double) z);
        }
    }

    public void addRecipe(World world, int x, int y, int z, Block input1, Block input2, Block output)
    {
        if (world.getBlock(x - 1, y, z - 1) == input1 && world.getBlock(x + 1, y, z - 1) == input1 &&
                world.getBlock(x - 1, y, z + 1) == input1 && world.getBlock(x + 1, y, z + 1) == input1 &&
                world.getBlock(x + 1, y, z) == input2 && world.getBlock(x - 1, y, z) == input2 &&
                world.getBlock(x, y, z + 1) == input2 && world.getBlock(x, y, z - 1) == input2)
        {
            world.setBlock(x - 1, y, z - 1, output);
            world.setBlock(x, y, z - 1, output);
            world.setBlock(x + 1, y, z - 1, output);
            world.setBlock(x - 1, y, z, output);
            world.setBlock(x + 1, y, z, output);
            world.setBlock(x - 1, y, z + 1, output);
            world.setBlock(x + 1, y, z + 1, output);
            world.setBlock(x, y, z + 1, output);

            world.spawnParticle("happyVillager", (double) x,
                    (double) y + 1, (double) z, (double) x, (double) y + 1, (double) z);
        }
    }

    public void addRecipeOutput1(World world, int x, int y, int z, Block input1, Block input2, Block output)
    {
        if (world.getBlock(x - 1, y, z - 1) == input1 && world.getBlock(x + 1, y, z - 1) == input1 &&
                world.getBlock(x - 1, y, z + 1) == input1 && world.getBlock(x + 1, y, z + 1) == input1 &&
                world.getBlock(x + 1, y, z) == input2 && world.getBlock(x - 1, y, z) == input2 &&
                world.getBlock(x, y, z + 1) == input2 && world.getBlock(x, y, z - 1) == input2)
        {
            world.setBlock(x - 1, y, z - 1, Blocks.air);
            world.setBlock(x, y, z - 1, output);
            world.setBlock(x + 1, y, z - 1, Blocks.air);
            world.setBlock(x - 1, y, z, Blocks.air);
            world.setBlock(x + 1, y, z, Blocks.air);
            world.setBlock(x - 1, y, z + 1, Blocks.air);
            world.setBlock(x + 1, y, z + 1, Blocks.air);
            world.setBlock(x, y, z + 1, Blocks.air);

            world.spawnParticle("happyVillager", (double) x,
                    (double) y + 1, (double) z, (double) x, (double) y + 1, (double) z);
        }
    }

  /**  public void transformIntoT2(World world, int x, int y, int z)
    {
        if (world.getBlock(x + 1, y, z) == Blocks.obsidian && world.getBlock(x + 1, y, z + 1) == Blocks.gold_block &&
                world.getBlock(x + 1, y, z - 1) == Blocks.gold_block &&
                world.getBlock(x - 1, y, z) == Blocks.obsidian &&
                world.getBlock(x - 1, y, z + 1) == Blocks.gold_block &&
                world.getBlock(x - 1, y, z - 1) == Blocks.gold_block &&
                world.getBlock(x, y, z - 1) == Blocks.obsidian && world.getBlock(x, y, z + 1) == Blocks.obsidian)
        {
            world.setWorldTime(18000);

            world.setBlock(x - 1, y, z - 1, Blocks.air);
            world.setBlock(x, y, z - 1, Blocks.air);
            world.setBlock(x + 1, y, z - 1, Blocks.air);
            world.setBlock(x - 1, y, z, Blocks.air);
            world.setBlock(x + 1, y, z, Blocks.air);
            world.setBlock(x - 1, y, z + 1, Blocks.air);
            world.setBlock(x + 1, y, z + 1, Blocks.air);
            world.setBlock(x, y, z + 1, Blocks.air);

            world.addWeatherEffect(new EntityLightningBolt(world, x + 5, y, z));
            world.addWeatherEffect(new EntityLightningBolt(world, x - 5, y, z));
            world.addWeatherEffect(new EntityLightningBolt(world, x, y, z + 5));
            world.addWeatherEffect(new EntityLightningBolt(world, x, y, z - 5));
            world.addWeatherEffect(new EntityLightningBolt(world, x + 5, y, z + 5));
            world.addWeatherEffect(new EntityLightningBolt(world, x + 5, y, z - 5));
            world.addWeatherEffect(new EntityLightningBolt(world, x - 5, y, z + 5));
            world.addWeatherEffect(new EntityLightningBolt(world, x - 5, y, z - 5));

            world.setBlock(x, y, z, BlockLoader.craftingBlockT2);
        }
    } **/
}
