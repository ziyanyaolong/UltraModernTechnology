package com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry;

import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass.BlockRegistryBass;
import com.ZiYanYaoLong.UltraModernTechnology.blocks.ObsidianBlock;
import com.ZiYanYaoLong.UltraModernTechnology.blocks.ObsidianCounter;
import com.ZiYanYaoLong.UltraModernTechnology.blocks.ObsidianOBJ;

//需要注册的方块
public class BlockRegistry {
    public static final BlockRegistryBass lp_block = BlockRegistryBass.add("lp_block", ObsidianBlock::new, InventoryGroupRegistry.material);
    public static final BlockRegistryBass my_obj = BlockRegistryBass.add("my_obj", ObsidianOBJ::new, InventoryGroupRegistry.material);
    public static final BlockRegistryBass my_tt = BlockRegistryBass.add("my_tt", ObsidianCounter::new, InventoryGroupRegistry.material);
}
