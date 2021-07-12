package com.ZiYanYaoLong.UltraModernTechnology.EventHandler;

import com.ZiYanYaoLong.UltraModernTechnology.GeneralInformation.GeneralInformation;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.ItemRegistry;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PropertyRegistry {
    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemModelsProperties.register(ItemRegistry.magic_ingot.readRegistry().get(),     //要添加overrides的物品
                    new ResourceLocation(GeneralInformation.MOD_ID, "size"),    //这个overrides的名字
                    (itemStack, clientWorld, livingEntity) -> itemStack.getCount());    //动态变化的值,这里直接调用了itemStack.getCount()函数返回了物品堆叠的数量
        });
    }
}