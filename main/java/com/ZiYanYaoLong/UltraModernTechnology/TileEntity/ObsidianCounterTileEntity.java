package com.ZiYanYaoLong.UltraModernTechnology.TileEntity;

import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.TileEntityTypeRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class ObsidianCounterTileEntity extends TileEntity implements ITickableTileEntity {
    private int counter = 0;

    public ObsidianCounterTileEntity() {
        super(TileEntityTypeRegistry.tttaas.readTileEntityType());
    }

    //要实现的具体内容
    public int increase() {
        counter++;
        System.out.println("数量:" + counter);
        setChanged();
        return counter;
    }

    @Override
    public CompoundNBT getUpdateTag() {
        return super.getUpdateTag();
    }

    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT nbt){
        super.handleUpdateTag(state, nbt);
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        counter = nbt.getInt("counter");
        super.load(state, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        compound.putInt("counter", counter);
        return super.save(compound);
    }

    @Override
    public void tick(){
    }
}
