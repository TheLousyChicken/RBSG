package net.lpsy.rbsg.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.lpsy.rbsg.RbsgMod;
import net.lpsy.rbsg.block.entity.RefinerBlockEntity;
import net.lpsy.rbsg.screen.RefinerBlockScreenHandler;
import net.lpsy.rbsg.screen.RefinerScreen;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class RefinerBlockRegister {
    public static final Identifier REFINER_IDENTIFIER = Identifier.of(RbsgMod.MOD_ID, "refiner_block");
    public static final ScreenHandlerType<RefinerBlockScreenHandler> REFINER_SCREEN_HANDLER =
            new ScreenHandlerType<>(RefinerBlockScreenHandler::new, FeatureSet.empty());

    public static RefinerBlock REFINER_BLOCK = new RefinerBlock(FabricBlockSettings.create().mapColor(MapColor.GRAY).sounds(BlockSoundGroup.METAL).strength(2.0f));
    public static BlockEntityType<RefinerBlockEntity> REFINER_BLOCK_ENTITY;

    public static void onInitialize() {
        REFINER_BLOCK_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                REFINER_IDENTIFIER,
                FabricBlockEntityTypeBuilder.create(
                        RefinerBlockEntity::new,
                        REFINER_BLOCK
                ).build(null)
        );

        Registry.register(Registries.BLOCK, REFINER_IDENTIFIER, REFINER_BLOCK);
        Registry.register(Registries.ITEM, REFINER_IDENTIFIER, new BlockItem(REFINER_BLOCK, new Item.Settings()));
        Registry.register(Registries.SCREEN_HANDLER, REFINER_IDENTIFIER, REFINER_SCREEN_HANDLER);
    }

    public static void onInitializeClient() {
        HandledScreens.register(REFINER_SCREEN_HANDLER, RefinerScreen::new);
    }
}
