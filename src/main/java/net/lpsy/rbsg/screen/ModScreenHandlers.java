package net.lpsy.rbsg.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.lpsy.rbsg.RbsgMod;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import java.sql.Ref;

public class ModScreenHandlers {


    public static void registerScreenHandlers(){
        RbsgMod.LOGGER.info("registering screen handlers for " + RbsgMod.MOD_ID);
    }

    public record RefinerData(String label) {
        public static final PacketCodec<RegistryByteBuf, RefinerData> PACKET_CODEC = PacketCodec.tuple(
                PacketCodecs.STRING,
                RefinerData::label,
                RefinerData::new
        );
    }
}