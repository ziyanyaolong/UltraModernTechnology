package com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass;

import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryTable.RegistryTable;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;

import java.util.Random;
import java.util.function.Supplier;

public class TileEntityTypeRegistryBass {
    private TileEntityTypeRegistryBass() {
//        TileEntity = null;
    }

    private TileEntityTypeRegistryBass(String name, Supplier blockTileEntity, Block block) {
        _name_ = name;
        _tileEntityType_ = TileEntityType.Builder.of(blockTileEntity, block).build(null);
    }

    public static TileEntityTypeRegistryBass add(String name, Supplier blockTileEntity, Block block) {
        return RegistryTable.addRegistryList(new TileEntityTypeRegistryBass(name, blockTileEntity, block));
    }

    public static TileEntityTypeRegistryBass add(Supplier blockTileEntity, Block block) {
        Random rand = new Random();
        return RegistryTable.addRegistryList(new TileEntityTypeRegistryBass(blockTileEntity.getClass().getName().toLowerCase() + "_" + "tile_entity" + "_" + rand.nextInt(Integer.MAX_VALUE), blockTileEntity, block));
    }

    public static TileEntityTypeRegistryBass add(String name, Supplier blockTileEntity, BlockRegistryBass block) {
        return RegistryTable.addRegistryList(new TileEntityTypeRegistryBass(name, blockTileEntity, block.readRegistry().get()));
    }

    public static TileEntityTypeRegistryBass add(Supplier blockTileEntity, BlockRegistryBass block) {
        Random rand = new Random();
        return RegistryTable.addRegistryList(new TileEntityTypeRegistryBass(blockTileEntity.getClass().getName().toLowerCase() + "_" + "tile_entity" + "_" + rand.nextInt(Integer.MAX_VALUE), blockTileEntity, block.readRegistry().get()));
    }

    public final String readRegistryName() { return _name_; }
    public final TileEntityType<?> readTileEntityType(){ return _tileEntityType_; }
    public TileEntityType<?> setTileEntityType(TileEntityType<?> tileEntityType) { return _tileEntityType_ = tileEntityType; }

    TileEntityType<?> _tileEntityType_;
    private String _name_;
}
