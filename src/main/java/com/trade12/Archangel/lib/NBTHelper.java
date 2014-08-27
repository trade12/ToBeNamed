package com.trade12.Archangel.lib;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
/**
 * Created by Kieran on 27/08/2014.
 */
public class NBTHelper {

    public static int getShort(String s, ItemStack ist) {
        if (ist.getTagCompound() == null) {
            ist.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound tagCompound = ist.getTagCompound();
        if (tagCompound.getShort(s) == 0) {
            tagCompound.setShort(s, (short) 0);
        }
        return tagCompound.getShort(s);

    }

    public static void setShort(String s, ItemStack ist, int i) {
        if (ist.getTagCompound() == null) {
            ist.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound tagCompound = ist.getTagCompound();
        tagCompound.setShort(s, (short) i);
    }

    public static void setInteger(String s, ItemStack ist, int i) {
        if (ist.getTagCompound() == null) {
            ist.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound tagCompound = ist.getTagCompound();
        tagCompound.setInteger(s, (int) i);
    }

    public static boolean getBoolean(String s, ItemStack ist) {
        if (ist.getTagCompound() == null) {
            ist.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound tagCompound = ist.getTagCompound();
        if (!tagCompound.getBoolean(s)) {
            tagCompound.setBoolean(s, false);
        }
        return tagCompound.getBoolean(s);

    }

    public static void setBoolean(String s, ItemStack ist, boolean b) {
        if (ist.getTagCompound() == null) {
            ist.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound tagCompound = ist.getTagCompound();
        tagCompound.setBoolean(s, b);
    }
}
