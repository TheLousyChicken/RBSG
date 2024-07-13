package net.lpsy.rbsg.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.lpsy.rbsg.RbsgMod;
import net.lpsy.rbsg.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
//    public static final BlockEntityType<RefinerBlockEntity> REFINER_BLOCK_ENTITY =
//            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(RbsgMod.MOD_ID, "refinery_be"),
//                    FabricBlockEntityTypeBuilder.create(RefinerBlockEntity::new,
//                            ModBlocks.REFINER_BLOCK).build());

    public static void registerBlockEntities(){
        RbsgMod.LOGGER.info("registering block entities for " + RbsgMod.MOD_ID);
    }
}
