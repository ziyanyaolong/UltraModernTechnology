package com.ZiYanYaoLong.UltraModernTechnology.InventoryGroup;

import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class InventoryGroup extends ItemGroup{
    public InventoryGroup() {
        super("material");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemRegistry.obsidian_ingot.readRegistry().get());
    }
}
