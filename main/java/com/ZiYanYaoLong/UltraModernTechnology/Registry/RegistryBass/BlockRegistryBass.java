package com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass;

import com.ZiYanYaoLong.UltraModernTechnology.GeneralInformation.GeneralInformation;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryTable.RegistryTable;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockRegistryBass {

    private BlockRegistryBass() {
        registry = null;
    }

    private BlockRegistryBass(String name, Supplier block) {
        registry = BLOCKS.register(name, block);
    }
    public static BlockRegistryBass add(String name, Supplier block, ItemGroup itemGroup) {
        BlockRegistryBass temp = RegistryTable.addRegistryList(new BlockRegistryBass(name, block));
        return ItemRegistryBass.addBlockItem(temp, name, itemGroup);
    }

    public static final DeferredRegister<Block> readBlock() {
        return BLOCKS;
    }

    public final RegistryObject<Block> readRegistry() {
        return registry;
    }

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GeneralInformation.MOD_ID);;
    private RegistryObject<Block> registry;
}
