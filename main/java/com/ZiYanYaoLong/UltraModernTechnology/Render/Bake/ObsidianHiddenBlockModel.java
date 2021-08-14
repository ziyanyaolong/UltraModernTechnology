package com.ZiYanYaoLong.UltraModernTechnology.Render.Bake;

import com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.data.ModelDataMap;
import net.minecraftforge.client.model.data.ModelProperty;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ObsidianHiddenBlockModel implements IBakedModel {
    IBakedModel defaultModel;
    public static ModelProperty<BlockState> COPIED_BLOCK = new ModelProperty<>();

    public ObsidianHiddenBlockModel(IBakedModel existingModel) {
        defaultModel = existingModel;
    }

    @Nonnull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData) {
        //设置了默认的渲染模型
        IBakedModel renderModel = defaultModel;

        //判断传入的数据有没有COPIED_BLOCK这个键
        if (extraData.hasProperty(COPIED_BLOCK)) {

            //获取COPIED_BLOCK这个键，相对应的值
            BlockState copiedBlock = extraData.getData(COPIED_BLOCK);

            //如果值不为null，从Minecraft的getBlockRendererDispatcher，取出对应BlockState的模型，放入renderModel中
            if (copiedBlock != null) {
                Minecraft mc = Minecraft.getInstance();
                BlockRendererDispatcher blockRendererDispatcher = mc.getBlockRenderer();
                renderModel = blockRendererDispatcher.getBlockModel(copiedBlock);
            }
        }

        //向下调用renderModel进行渲染
        return renderModel.getQuads(state, side, rand, extraData);
    }

    //给getQuads方法传入额外的数据
    @Override
    public IModelData getModelData(IBlockDisplayReader world, BlockPos pos, BlockState state, IModelData tileData) {
        //获取了「隐藏方块」下方方块的BlockState
        BlockState downBlockState = world.getBlockState(pos.below());

        //ModelDataMap是IModelData接口的唯二两个实现类中的一个，这里创建了一个键值对，并且通过withInitial设置了初始值：「键：COPIED_BLOCK，值：null」
        ModelDataMap modelDataMap = new ModelDataMap.Builder().withInitial(COPIED_BLOCK, null).build();

        //判断这个BlockState是不是空气，以及是不是又是一个相同的「隐藏方块」，如是就直接返回ModelDataMap
        if (downBlockState.getBlock() == Blocks.AIR || downBlockState.getBlock() == BlockRegistry.my_render.readRegistry().get()) {
            return modelDataMap;
        }

        //如果不是，通过调用setData方法设置了具体的「值」，然后返回
        modelDataMap.setData(COPIED_BLOCK, downBlockState);
        return modelDataMap;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand) {
        throw new AssertionError("IBakedModel::getQuads should never be called, only IForgeBakedModel::getQuads");
    }

    @Override
    public boolean isAmbientOcclusion(BlockState state) {
        return defaultModel.isAmbientOcclusion(state);
    }

    @Override
    public boolean isGui3d() {
        return defaultModel.isGui3d();
    }

    @Override
    public boolean isLayered() {
        return defaultModel.isLayered();
    }

    @Override
    public boolean isCustomRenderer() {
        return defaultModel.isCustomRenderer();
    }

    @Override
    public TextureAtlasSprite getParticleTexture(@Nonnull IModelData data) {
        return defaultModel.getParticleTexture(data);
    }

    public boolean useAmbientOcclusion() {
        return true;
    }

    public TextureAtlasSprite getParticleIcon(){
        return defaultModel.getParticleIcon();
    }

    public boolean usesBlockLight() {
        return true;
    }

    @Override
    public ItemOverrideList getOverrides() {
        return defaultModel.getOverrides();
    }
}
