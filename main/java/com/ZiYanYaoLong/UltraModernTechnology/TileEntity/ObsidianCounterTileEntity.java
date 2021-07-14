package com.ZiYanYaoLong.UltraModernTechnology.TileEntity;

import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.TileEntityTypeRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

public class ObsidianCounterTileEntity extends TileEntity implements ITickableTileEntity {
    private int counter = 0;
    private int MAX_TIME = 5 * 20;
    private int timer = 0;
    private static final String a = "哼，哼~";
    private static final String b = "哼啊，啊~";
    private static final String c = "啊啊啊啊啊啊啊啊啊啊~";
    private int JS = 0;
    private boolean flag = false;

    public ObsidianCounterTileEntity() {
        super(TileEntityTypeRegistry.tttaas.tileEntity.get());
//        super(null);
    }

    //要实现的具体内容
    public int increase() {
        counter++;
        System.out.println("数量:" + counter);
        markUpdated();
        return counter;
    }

    protected void markUpdated() {
        if (this.getLevel() != null) {
            this.setChanged();
            this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 2);
        }
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        System.out.println("load读取");
        counter = nbt.getInt("counter");
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        System.out.println("save保存");
        compound.putInt("counter", counter);
        return super.save(compound);
    }

    @Override
    public void tick() {
        if (level.isClientSide() && flag) {
            PlayerEntity player = level.getNearestPlayer(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), 10, false);
            this.level.playSound(player, worldPosition, SoundEvents.NOTE_BLOCK_PLING, SoundCategory.AMBIENT, 1.0f, 1.0f);
            flag = false;
        }
        if (!level.isClientSide()) {
            if (timer == MAX_TIME) {
                flag = true;
                level.sendBlockUpdated(worldPosition, this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
                flag = true;
                timer = 0;
            }
            timer++;
        }
    }

    //服务端发送数据包
    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        try{
            return new SUpdateTileEntityPacket(getBlockPos(), -1, this.getUpdateTag());
        }catch (Exception e)
        {
            System.out.println("getUpdatePacket出错:" + e);
        }
        return null;
    }

    //客户端接受数据包
    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        try{
            CompoundNBT tag = pkt.getTag();
            handleUpdateTag(level.getBlockState(pkt.getPos()), tag);
        }catch (Exception e)
        {
            System.out.println("onDataPacket出错:" + e);
        }
    }

    //在区块刚被载入时被调用的方法
    @Override
    public CompoundNBT getUpdateTag() {
        try{
            CompoundNBT NBT = super.getTileData();
            System.out.println("getUpdateTag-NBT:" + NBT);
            NBT.putBoolean("flag", flag);
            return NBT;
        }catch (Exception e)
        {
            System.out.println("getUpdateTag出错:" + e);
        }
        return null;
    }

    //在区块刚被载入时被调用的方法
    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        try{
            flag = tag.getBoolean("flag");
        }catch (Exception e)
        {
            System.out.println("handleUpdateTag出错:" + e);
        }
    }
}
