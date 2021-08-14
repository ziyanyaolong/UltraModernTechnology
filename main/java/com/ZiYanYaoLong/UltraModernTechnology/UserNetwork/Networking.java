package com.ZiYanYaoLong.UltraModernTechnology.UserNetwork;

import com.ZiYanYaoLong.UltraModernTechnology.GeneralInformation.GeneralInformation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class Networking {
    public static final String VERSION = "1.0";
    private static int ID = 0;
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(GeneralInformation.MOD_ID, "first_net"),   //通道的名称
            () -> VERSION,  //返回当前网络协议版本
            //检查传入的连接协议版本是否与客户端或服务器网络兼容
            VERSION ::equals,
            VERSION ::equals
    );

    public static int nextID() {
        return ID++;
    }

    public static void registerMessage() {
        INSTANCE.messageBuilder(SendPack.class, nextID())
                .encoder(SendPack::toBytes) //序列化数据包
                .decoder(SendPack::new) //反序列化数据包
                .consumer(SendPack::handler)    //当接受到数据之后进行一系列操作
                .add();
    }
}
