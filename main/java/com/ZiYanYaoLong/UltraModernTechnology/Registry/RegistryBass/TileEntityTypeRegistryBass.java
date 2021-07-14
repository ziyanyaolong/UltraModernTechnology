package com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass;

import com.ZiYanYaoLong.UltraModernTechnology.GeneralInformation.GeneralInformation;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryTable.RegistryTable;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;
import java.util.function.Supplier;

public class TileEntityTypeRegistryBass {
    private TileEntityTypeRegistryBass() {
//        tileEntity  = TILE_ENTITIES.register("tttaas",
//                () -> TileEntityType.Builder.of(ObsidianCounterTileEntity::new, BlockRegistry.my_tt.readRegistry().get()).build(null));;
    }

    private TileEntityTypeRegistryBass(String name, Supplier blockTileEntity, Block block) {
        tileEntity = TILE_ENTITIES.register(name,
                () -> TileEntityType.Builder.of(blockTileEntity, block).build(null));
    }
    private TileEntityTypeRegistryBass(String name, Supplier blockTileEntity, RegistryObject<Block> block) {
        tileEntity = TILE_ENTITIES.register(name,
                () -> TileEntityType.Builder.of(blockTileEntity, block.get()).build(null));
    }

    public static TileEntityTypeRegistryBass add(String name, Supplier blockTileEntity, Block block) {
        return RegistryTable.addRegistryList(new TileEntityTypeRegistryBass(name, blockTileEntity, block));
    }

    public static TileEntityTypeRegistryBass add(Supplier blockTileEntity, Block block) {
        Random rand = new Random();
        return RegistryTable.addRegistryList(new TileEntityTypeRegistryBass(blockTileEntity.getClass().getName().toLowerCase() + "_" + "tile_entity" + "_" + rand.nextInt(Integer.MAX_VALUE), blockTileEntity, block));
    }

    public static TileEntityTypeRegistryBass add(String name, Supplier blockTileEntity, BlockRegistryBass block) {
        return RegistryTable.addRegistryList(new TileEntityTypeRegistryBass(name, blockTileEntity, block.readRegistry()));
    }

    public static TileEntityTypeRegistryBass add(Supplier blockTileEntity, BlockRegistryBass block) {
        Random rand = new Random();
        return RegistryTable.addRegistryList(new TileEntityTypeRegistryBass(blockTileEntity.getClass().getName().toLowerCase() + "_" + "tile_entity" + "_" + rand.nextInt(Integer.MAX_VALUE), blockTileEntity, block.readRegistry()));
    }

    private static BlockRegistryBass blockA;
//    public final String readRegistryName() { return _name_; }
//    public final TileEntityType<?> readTileEntityType(){ return _tileEntityType_; }
//    public TileEntityType<?> setTileEntityType(TileEntityType<?> tileEntityType) { return _tileEntityType_ = tileEntityType; }
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, GeneralInformation.MOD_ID);
    public RegistryObject<TileEntityType<?>> tileEntity;
//    private TileEntityType<?> _tileEntityType_;
//    private String _name_;
}
