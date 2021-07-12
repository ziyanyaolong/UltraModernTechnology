package com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass;

import com.ZiYanYaoLong.UltraModernTechnology.GeneralInformation.GeneralInformation;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryTable.RegistryTable;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ItemRegistryBass {
    private ItemRegistryBass(){
        registry = null;
    }
    private ItemRegistryBass(String name, Supplier item) {
        registry = ITEMS.register(name, item);
    }
    public static ItemRegistryBass add(String name, Supplier item) {
        return RegistryTable.addRegistryList(new ItemRegistryBass(name, item));
    }

    public static ItemRegistryBass addAbstract(){
        return new ItemRegistryBass();
    }

    public static final BlockRegistryBass addBlockItem(final BlockRegistryBass blockRegistryBass, final String name, final ItemGroup itemGroup){
        ItemRegistryBass temp = RegistryTable.addRegistryList(new ItemRegistryBass());
        temp.registry = ITEMS.register(name, () -> new BlockItem(blockRegistryBass.readRegistry().get(), new Item.Properties().tab(itemGroup)));
        RegistryTable.addRegistryList(blockRegistryBass, temp);
        return blockRegistryBass;
    }

    public static final DeferredRegister<Item> readItem(){
        return ITEMS;
    }

    public final RegistryObject<Item> readRegistry() {
        return registry;
    }

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GeneralInformation.MOD_ID);;
    private RegistryObject<Item> registry;
}