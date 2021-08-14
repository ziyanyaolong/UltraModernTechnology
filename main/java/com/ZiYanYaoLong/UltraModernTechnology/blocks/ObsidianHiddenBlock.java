package com.ZiYanYaoLong.UltraModernTechnology.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ObsidianHiddenBlock extends Block {
    public ObsidianHiddenBlock() {
        super(Properties.of(Material.STONE).harvestLevel(2).noOcclusion());
    }
}
