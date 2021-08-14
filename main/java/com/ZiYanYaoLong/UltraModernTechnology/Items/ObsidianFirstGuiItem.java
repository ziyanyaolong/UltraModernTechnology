package com.ZiYanYaoLong.UltraModernTechnology.Items;

import com.ZiYanYaoLong.UltraModernTechnology.GUI.OpenGUI;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.InventoryGroupRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class ObsidianFirstGuiItem extends Item {
    public ObsidianFirstGuiItem() {
        super(new Item.Properties().tab(InventoryGroupRegistry.material));
    }


    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isClientSide()) {
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenGUI::new);
        }
        return super.use(worldIn, playerIn, handIn);
    }
}

