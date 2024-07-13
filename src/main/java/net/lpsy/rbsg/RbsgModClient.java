package net.lpsy.rbsg;

import net.fabricmc.api.ClientModInitializer;
import net.lpsy.rbsg.block.custom.RefinerBlockRegister;
import net.lpsy.rbsg.screen.ModScreenHandlers;
import net.lpsy.rbsg.screen.RefinerScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class RbsgModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //HandledScreens.register(ModScreenHandlers.REFINER_SCREEN_HANDLER, RefinerScreen::new);
        RefinerBlockRegister.onInitializeClient();
    }
}