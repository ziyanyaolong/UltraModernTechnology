package com.ZiYanYaoLong.UltraModernTechnology.TileEntity.Container;

import net.minecraft.util.IIntArray;

public class ObsidianFirstContainerItemNumber implements IIntArray {
    int i = 0;

    @Override
    public int get(int index) {
        return i;
    }

    @Override
    public void set(int index, int value) {
        i = value;
    }

    @Override
    public int getCount() {
        return 1;
    }
}
