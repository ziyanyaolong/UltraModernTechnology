package com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry;

import com.ZiYanYaoLong.UltraModernTechnology.Items.*;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass.ItemRegistryBass;

//需要注册的物品
public class ItemRegistry {
    public static final ItemRegistryBass obsidian_ingot = ItemRegistryBass.add("obsidian_ingot", ObsidianIngot::new);
    public static final ItemRegistryBass obsidian_apple = ItemRegistryBass.add("obsidian_apple", ObsidianApple::new);
    public static final ItemRegistryBass magic_ingot = ItemRegistryBass.add("magic_ingot", MagicIngot::new);
    public static final ItemRegistryBass lithium_ingot = ItemRegistryBass.add("lithium_ingot", ObsidianIngot::new);
    public static final ItemRegistryBass lilk = ItemRegistryBass.add("lilk", ObsidianMessage::new);
    public static final ItemRegistryBass obsidianIngot = ItemRegistryBass.add("obsidian_first_gui", ObsidianFirstGuiItem::new);
}