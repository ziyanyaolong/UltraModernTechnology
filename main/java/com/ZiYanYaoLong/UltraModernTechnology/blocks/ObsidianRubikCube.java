package com.ZiYanYaoLong.UltraModernTechnology.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.state.IntegerProperty;

public class ObsidianRubikCube extends Block {
    private static IntegerProperty STATE = IntegerProperty.create("face", 0, 1);

    public ObsidianRubikCube() {
        super(Properties.of(Material.STONE).harvestLevel(5));
    }
}
