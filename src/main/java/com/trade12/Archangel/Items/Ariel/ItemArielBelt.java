package com.trade12.Archangel.Items.Ariel;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.trade12.Archangel.Archangel;
import com.trade12.Archangel.Config.ConfigHandler;
import com.trade12.Archangel.Handler.ChargeHandler;
import com.trade12.Archangel.Handler.KeyHandler;
import com.trade12.Archangel.Handler.PowerHandler;
import com.trade12.Archangel.Items.ItemLoader;
import com.trade12.Archangel.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.security.Key;
import java.util.List;

/**
 * Created by kieran on 21/08/2014.
 */
public class ItemArielBelt extends Item implements IBauble {

    boolean active;
    int counter;
    int counter2; //because im lazy

    public ItemArielBelt() {
        this.setMaxStackSize(1);
        this.setCreativeTab(Archangel.tabCustom);
        this.setUnlocalizedName(Ref.UNLOCALISED_ARIEL_BELT);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        this.itemIcon = register.registerIcon(Ref.MOD_ID + ":" + Ref.UNLOCALISED_ARIEL_BELT);
    }

    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        ChargeHandler.setCharge(itemStack, 0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entity, List info, boolean useInfo) {
        ChargeHandler.addTooltipChargeInformation(itemStack, info);
        ChargeHandler.addSecondaryAbilityInformation(active, info);
    }


    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;

            if (ChargeHandler.canFloralCharge(itemStack, entity)) {
                ChargeHandler.addCharge(itemStack, 1);
            }

            if (ChargeHandler.hasRoomForCharge(itemStack)) {
                PowerHandler.drainFromBatteryIfPossible(itemStack, player, ItemLoader.arielPower);
            }

            if (ChargeHandler.hasEnoughChargeForOperation(itemStack, 5)) {
                if (player.isCollidedHorizontally) {
                    player.addVelocity(0, 0.1, 0);
                    counter2++;
                    if (counter2 == 50) {
                        ChargeHandler.removeCharge(itemStack, 5);
                    }
                }
            }

            if (KeyHandler.belt && ChargeHandler.hasEnoughChargeForOperation(itemStack, 25)) {
                active = true;
                active = true;
                int x = (int) Math.round(player.posX - 0.5F);
                int y = (int) player.posY;
                int z = (int) Math.round(player.posZ - 0.5F);
                int random = (int) (Math.random() * ((5) + 1));
                counter++;

                if (counter == 250) {
                    if (random == 0) {
                        spawnChicken(player.worldObj, x, y, z);
                    }
                    if (random == 1) {
                        spawnPig(player.worldObj, x, y, z);
                    }
                    if (random == 2) {
                        spawnCow(player.worldObj, x, y, z);
                    }
                    if (random == 3) {
                        spawnSheep(player.worldObj, x, y, z);
                    }
                    if (random == 4) {
                        spawnHorse(player.worldObj, x, y, z);
                    }
                    if (random == 5) {
                        spawnSquid(player.worldObj, x, y, z);
                    }
                    ChargeHandler.removeCharge(itemStack, 25);
                    counter = 0;
                }
            }

        if (!KeyHandler.belt) {
            active = false;
        }

    }

}

    public void spawnPig(World world, int x, int y, int z)
    {
        EntityPig entityPig = new EntityPig(world);
        entityPig.setGrowingAge(-24000);
        entityPig.setCustomNameTag("Bob");
        entityPig.setLocationAndAngles(x, y, z, 1, 0);
        world.spawnEntityInWorld(entityPig);
        world.updateEntity(entityPig);

    }

    public void spawnHorse(World world, int x, int y, int z)
    {
        EntityHorse entityHorse = new EntityHorse(world);
        entityHorse.setGrowingAge(-24000);
        entityHorse.setCustomNameTag("Sir Markus VII");
        entityHorse.setLocationAndAngles(x,y,z,1,0);
        world.spawnEntityInWorld(entityHorse);
        world.updateEntity(entityHorse);

    }

    public void spawnChicken(World world, int x, int y, int z)
    {
        EntityChicken entityChicken = new EntityChicken(world);
        entityChicken.setGrowingAge(-24000);
        entityChicken.setCustomNameTag("Bob");
        entityChicken.setLocationAndAngles(x,y,z,1,0);
        world.spawnEntityInWorld(entityChicken);
        world.updateEntity(entityChicken);

    }

    public void spawnSquid(World world, int x, int y, int z)
    {
        EntitySquid entitySquid = new EntitySquid(world);
        entitySquid.setCustomNameTag("Bob");
        entitySquid.setLocationAndAngles(x,y,z,1,0);
        world.spawnEntityInWorld(entitySquid);
        world.updateEntity(entitySquid);

    }

    public void spawnCow(World world, int x, int y, int z)
    {
        EntityCow entityCow = new EntityCow(world);
        entityCow.setGrowingAge(-24000);
        entityCow.setCustomNameTag("Bob");
        entityCow.setLocationAndAngles(x,y,z,1,0);
        world.spawnEntityInWorld(entityCow);
        world.updateEntity(entityCow);

    }

    public void spawnSheep(World world, int x, int y, int z)
    {
        EntitySheep entitySheep = new EntitySheep(world);
        entitySheep.setGrowingAge(-24000);
        entitySheep.setCustomNameTag("Bob");
        entitySheep.setLocationAndAngles(x,y,z,1,0);
        world.spawnEntityInWorld(entitySheep);
        world.updateEntity(entitySheep);

    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack)
    {
        return BaubleType.BELT;
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entity)
    {
        if (!entity.worldObj.isRemote)
        {
            entity.worldObj.playSoundAtEntity(entity, "random.pop", 0.1F, 1.3f);
        }
    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entity)
    {
        if (!entity.worldObj.isRemote)
        {
            entity.worldObj.playSoundAtEntity(entity, "random.pop", 0.1F, 1.3f);
        }
    }

    @Override
    public boolean canEquip(ItemStack itemStack, EntityLivingBase entity)
    {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemStack, EntityLivingBase entity)
    {
        return true;
    }


}

