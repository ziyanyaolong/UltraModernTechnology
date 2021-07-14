package com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry;

import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass.TileEntityTypeRegistryBass;
import com.ZiYanYaoLong.UltraModernTechnology.TileEntity.ObsidianCounterTileEntity;

public class TileEntityTypeRegistry {
    public static TileEntityTypeRegistryBass tttaas = TileEntityTypeRegistryBass.add("tttaas", ObsidianCounterTileEntity::new, BlockRegistry.my_tt);
}
