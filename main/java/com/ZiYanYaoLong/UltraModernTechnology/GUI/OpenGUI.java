package com.ZiYanYaoLong.UltraModernTechnology.GUI;

import com.ZiYanYaoLong.UltraModernTechnology.GeneralInformation.GeneralInformation;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TranslationTextComponent;

public class OpenGUI {
    public OpenGUI() {
        Minecraft.getInstance().setScreen(new ObsidianFirstGui(new TranslationTextComponent(GeneralInformation.MOD_ID + ".test")));
    }
}
