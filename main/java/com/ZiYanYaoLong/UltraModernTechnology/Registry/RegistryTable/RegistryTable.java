package com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryTable;

import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass.BlockRegistryBass;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass.ItemRegistryBass;
import com.ZiYanYaoLong.UltraModernTechnology.Registry.RegistryBass.TileEntityTypeRegistryBass;

import java.util.HashMap;
import java.util.Vector;

public class RegistryTable {
    //静态注册表
    private static Vector<ItemRegistryBass> itemList = new Vector<ItemRegistryBass>();
    private static Vector<BlockRegistryBass> blockList = new Vector<BlockRegistryBass>();
    private static Vector<TileEntityTypeRegistryBass> tileEntityTypeList = new Vector<TileEntityTypeRegistryBass>();
    private static HashMap<BlockRegistryBass, ItemRegistryBass> blockItemList = new HashMap<BlockRegistryBass,ItemRegistryBass>();

    //读取静态注册表
    public static final Vector<BlockRegistryBass> readBlockRegistryList() { return blockList; }
    public static final Vector<ItemRegistryBass> readItemRegistryList() {
        return itemList;
    }
    public static final Vector<TileEntityTypeRegistryBass> readTileEntityTypeList() {
        return tileEntityTypeList;
    }
    public static final HashMap<BlockRegistryBass, ItemRegistryBass> readBlockItemList() {
        return blockItemList;
    }

    //静态注册表添加
    public static ItemRegistryBass addRegistryList(ItemRegistryBass itemRegistryBass) {
        itemList.add(itemRegistryBass);
        return itemRegistryBass;
    }
    public static BlockRegistryBass addRegistryList(BlockRegistryBass blockRegistryBass) {
        blockList.add(blockRegistryBass);
        return blockRegistryBass;
    }
    public static TileEntityTypeRegistryBass addRegistryList(TileEntityTypeRegistryBass tileEntityTypeRegistryBass) {
        tileEntityTypeList.add(tileEntityTypeRegistryBass);
        return tileEntityTypeRegistryBass;
    }
    public static ItemRegistryBass addRegistryList(BlockRegistryBass blockRegistryBass, ItemRegistryBass itemRegistryBass) {
        blockItemList.put(blockRegistryBass, itemRegistryBass);
        return itemRegistryBass;
    }
}
