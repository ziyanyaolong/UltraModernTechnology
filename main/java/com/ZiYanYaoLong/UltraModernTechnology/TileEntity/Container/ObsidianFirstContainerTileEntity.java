package com.ZiYanYaoLong.UltraModernTechnology.TileEntity.Container;

import com.ZiYanYaoLong.UltraModernTechnology.GeneralInformation.GeneralInformation;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.TileEntityTypeRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;

public class ObsidianFirstContainerTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

    private Inventory inventory = new Inventory(1);
    private ObsidianFirstContainerItemNumber itemNumber = new ObsidianFirstContainerItemNumber();

    public ObsidianFirstContainerTileEntity() {
        super(TileEntityTypeRegistry.obsidianFirstContainerTileEntity.readTileEntity().get());
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("gui." + GeneralInformation.MOD_ID + ".first_container");
    }

    @Nullable
    @Override
    public Container createMenu(int sycID, PlayerInventory inventory, PlayerEntity player) {
        return new ObsidianFirstContainer(sycID, inventory, this.worldPosition, this.level, itemNumber);
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        this.inventory.addItem(ItemStack.of(nbt.getCompound("item")));
        super.load(state, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        ItemStack itemStack = this.inventory.getItem(0).copy();
        compound.put("item", itemStack.serializeNBT());
        return super.save(compound);
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public void tick() {
        if (!level.isClientSide()) {
            this.itemNumber.set(0, this.inventory.getItem(0).getCount());
        }
    }
}
