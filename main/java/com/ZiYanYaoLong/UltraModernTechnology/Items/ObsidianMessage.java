package com.ZiYanYaoLong.UltraModernTechnology.Items;

import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.InventoryGroupRegistry;
import com.ZiYanYaoLong.UltraModernTechnology.UserNetwork.Networking;
import com.ZiYanYaoLong.UltraModernTechnology.UserNetwork.SendPack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class ObsidianMessage extends Item {
    public ObsidianMessage() {
        super(new Item.Properties().tab(InventoryGroupRegistry.material));
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isClientSide()) {
            Networking.INSTANCE.sendToServer(new SendPack("From the Client"));
        }
        if (!worldIn.isClientSide()) {
            Networking.INSTANCE.send(
                    PacketDistributor.PLAYER.with(
                            () -> (ServerPlayerEntity) playerIn
                    ),
                    new SendPack("From Server"));
        }
        return super.use(worldIn, playerIn, handIn);
    }
}
