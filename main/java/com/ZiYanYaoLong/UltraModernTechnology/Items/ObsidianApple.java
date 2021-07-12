package com.ZiYanYaoLong.UltraModernTechnology.Items;

import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.InventoryGroupRegistry;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ObsidianApple extends Item {
    private static final Food food = (new Food.Builder())
            .saturationMod(10)  //饱食度
            .nutrition(20)  //饥饿度
            .effect(() -> new EffectInstance(Effects.POISON, 3 * 20, 1), 1) //药水效果
            .build();

    public ObsidianApple() {
        super(new Properties().food(food).tab(InventoryGroupRegistry.material));
    }
}
