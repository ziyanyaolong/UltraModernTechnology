package com.ZiYanYaoLong.UltraModernTechnology.Items;

import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.InventoryGroupRegistry;
import net.minecraft.item.Item;

public class MagicIngot extends Item {
    public MagicIngot() {
        super(new Properties().tab(InventoryGroupRegistry.material));
    }
}
