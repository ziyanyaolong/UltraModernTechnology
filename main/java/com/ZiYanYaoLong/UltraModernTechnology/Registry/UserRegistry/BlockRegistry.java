package com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry;

import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass.BlockRegistryBass;
import com.ZiYanYaoLong.UltraModernTechnology.blocks.*;

//需要注册的方块
public class BlockRegistry {
    public static final BlockRegistryBass lp_block = BlockRegistryBass.add("lp_block", ObsidianBlock::new, InventoryGroupRegistry.material);
    public static final BlockRegistryBass my_obj = BlockRegistryBass.add("my_obj", ObsidianOBJ::new, InventoryGroupRegistry.material);
    public static final BlockRegistryBass my_tt = BlockRegistryBass.add("my_tt", ObsidianCounter::new, InventoryGroupRegistry.material);
    public static final BlockRegistryBass my_render = BlockRegistryBass.add("my_render", ObsidianHiddenBlock::new, InventoryGroupRegistry.material);
    public static final BlockRegistryBass aaa = BlockRegistryBass.add("u_aaa", ObsidianDownBlock::new, InventoryGroupRegistry.material);
    public static final BlockRegistryBass aab = BlockRegistryBass.add("u_aab", ObsidianUpBlock::new, InventoryGroupRegistry.material);
    public static final BlockRegistryBass large_cooling_tower = BlockRegistryBass.add("large_cooling_tower", ObsidianOBJ::new, InventoryGroupRegistry.material);
}
