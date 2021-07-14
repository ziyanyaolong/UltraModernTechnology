package com.ZiYanYaoLong.UltraModernTechnology;

import com.ZiYanYaoLong.UltraModernTechnology.GeneralInformation.GeneralInformation;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass.BlockRegistryBass;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass.ItemRegistryBass;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass.TileEntityTypeRegistryBass;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.BlockRegistry;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.ItemRegistry;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.TileEntityTypeRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GeneralInformation.MOD_ID)
public class UltraModernTechnology {
    public UltraModernTechnology() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        new ItemRegistry();
        new BlockRegistry();
        new TileEntityTypeRegistry();

        ItemRegistryBass.readItem().register(modEventBus);
        BlockRegistryBass.readBlock().register(modEventBus);
        TileEntityTypeRegistryBass.TILE_ENTITIES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

    }
}
