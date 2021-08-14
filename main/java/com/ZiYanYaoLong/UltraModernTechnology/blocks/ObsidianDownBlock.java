package com.ZiYanYaoLong.UltraModernTechnology.blocks;

import com.ZiYanYaoLong.UltraModernTechnology.TileEntity.ObsidianDownBlockTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class ObsidianDownBlock extends Block {
    public ObsidianDownBlock() {
        super(AbstractBlock.Properties.of(Material.STONE).harvestLevel(5));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ObsidianDownBlockTileEntity();
    }
}
