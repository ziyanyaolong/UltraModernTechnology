package com.ZiYanYaoLong.UltraModernTechnology.Registry.UserRegistry;

import com.ZiYanYaoLong.UltraModernTechnology.GeneralInformation.GeneralInformation;
import com.ZiYanYaoLong.UltraModernTechnology.TileEntity.Container.ObsidianFirstContainer;
import com.ZiYanYaoLong.UltraModernTechnology.TileEntity.Container.ObsidianFirstContainerItemNumber;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypeRegistry {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, GeneralInformation.MOD_ID);
    public static final RegistryObject<ContainerType<ObsidianFirstContainer>> obsidianFirstContainer = CONTAINERS.register("obsidian_first_container",
            () -> IForgeContainerType.create((int windowId, PlayerInventory inv, PacketBuffer data) ->
                    new ObsidianFirstContainer(windowId, inv, data.readBlockPos(), Minecraft.getInstance().level, new ObsidianFirstContainerItemNumber())));
}
