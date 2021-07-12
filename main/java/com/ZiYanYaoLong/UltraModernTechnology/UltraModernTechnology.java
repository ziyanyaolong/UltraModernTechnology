package com.ZiYanYaoLong.UltraModernTechnology;

import com.ZiYanYaoLong.UltraModernTechnology.GeneralInformation.GeneralInformation;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass.BlockRegistryBass;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass.ItemRegistryBass;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass.TileEntityTypeRegistryBass;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryTable.RegistryTable;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.BlockRegistry;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.ItemRegistry;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.TileEntityTypeRegistry;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GeneralInformation.MOD_ID)
public class UltraModernTechnology {
    public UltraModernTechnology(){

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        new ItemRegistry();
        new BlockRegistry();

        ItemRegistryBass.readItem().register(modEventBus);
        BlockRegistryBass.readBlock().register(modEventBus);
    }

    @SubscribeEvent
    public static void registerTE(RegistryEvent.Register<TileEntityType<?>> evt) {
        new TileEntityTypeRegistry();
        for (TileEntityTypeRegistryBass i : RegistryTable.readTileEntityTypeList()) {
            TileEntityType<?> type = i.readTileEntityType();
            type.setRegistryName(GeneralInformation.MOD_ID, i.readRegistryName());
            evt.getRegistry().register(type);
        }
    }
}
