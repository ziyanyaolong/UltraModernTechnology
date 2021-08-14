package com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry;

import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass.TileEntityTypeRegistryBass;
import com.ZiYanYaoLong.UltraModernTechnology.TileEntity.Container.ObsidianFirstContainerTileEntity;
import com.ZiYanYaoLong.UltraModernTechnology.TileEntity.ObsidianCounterTileEntity;
import com.ZiYanYaoLong.UltraModernTechnology.TileEntity.ObsidianDownBlockTileEntity;
import com.ZiYanYaoLong.UltraModernTechnology.TileEntity.ObsidianUpBlockTileEntity;

public class TileEntityTypeRegistry {
    public static TileEntityTypeRegistryBass tttaas = TileEntityTypeRegistryBass.add("tttaas", ObsidianCounterTileEntity::new, BlockRegistry.my_tt);
    public static TileEntityTypeRegistryBass obsidianDownTileEntity = TileEntityTypeRegistryBass.add("obsidian_d_t", ObsidianDownBlockTileEntity::new, BlockRegistry.aaa);
    public static TileEntityTypeRegistryBass obsidianUpTileEntity = TileEntityTypeRegistryBass.add("obsidian_u_t", ObsidianUpBlockTileEntity::new, BlockRegistry.aab);
    public static TileEntityTypeRegistryBass obsidianFirstContainerTileEntity = TileEntityTypeRegistryBass.add("obsidian_yyu_t", ObsidianFirstContainerTileEntity::new, BlockRegistry.my_obj);
}
