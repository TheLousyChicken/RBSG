package net.lpsy.rbsg;

import net.fabricmc.api.ClientModInitializer;
import net.lpsy.rbsg.screen.ModScreenHandlers;
import net.lpsy.rbsg.screen.RefinerScreen;
import net.lpsy.rbsg.screen.RefinerScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class RbsgModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.REFINER_SCREEN_HANDLER, RefinerScreen::new);
    }
}