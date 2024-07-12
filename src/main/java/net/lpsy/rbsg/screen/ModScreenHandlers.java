package net.lpsy.rbsg.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.lpsy.rbsg.RbsgMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<RefinerScreenHandler> REFINER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(RbsgMod.MOD_ID, "refining"),
                    new ExtendedScreenHandlerType<>(RefinerScreenHandler::new));

    public static void registerScreenHandlers(){
        RbsgMod.LOGGER.info("registering screen handlers for " + RbsgMod.MOD_ID);
    }
}
