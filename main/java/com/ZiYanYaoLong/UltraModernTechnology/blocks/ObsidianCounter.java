package com.ZiYanYaoLong.UltraModernTechnology.blocks;

import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.TileEntityTypeRegistry;
import com.ZiYanYaoLong.UltraModernTechnology.TileEntity.ObsidianCounterTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;

public class ObsidianCounter extends Block {

    public ObsidianCounter() {
        super(Properties.of(Material.STONE).harvestLevel(5));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        new TileEntityTypeRegistry();
        System.out.println("TileEntityTypeRegistry:hhh");
        return new ObsidianCounterTileEntity();
    }

    @SubscribeEvent
    public ActionResultType RightClickBlock(PlayerInteractEvent.EntityInteractSpecific event) {
        System.out.println("触发啦！" + event);
//        if (!worldIn.isClientSide() && handIn == Hand.MAIN_HAND) {
//            ObsidianCounterTileEntity obsidianCounterTileEntity = (ObsidianCounterTileEntity) worldIn.getBlockEntity(pos);
//            int counter = obsidianCounterTileEntity.increase();
//            TranslationTextComponent translationTextComponent = new TranslationTextComponent("message.neutrino.counter", counter);
//            player.sendMessage(translationTextComponent, player.getUUID());
//        }
        return ActionResultType.SUCCESS;
    }
}
