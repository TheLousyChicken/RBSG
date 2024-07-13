package net.lpsy.rbsg.block;

import net.lpsy.rbsg.RbsgMod;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    // make new regular blocks here + add them to Resources JSON
    //public static final Block BLOCK_NAME = registerBlock("block_name", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block",
            new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)));
    // make ore blocks here
    public static final Block ANCIENT_ARTIFACT = registerBlock("ancient_artifact",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,7), AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS).strength(30.0F, 1200.0F)));

    // custom blocks
    //public static final Block REFINER_BLOCK = registerBlock("refiner_block",
    //        new RefinerBlock(AbstractBlock.Settings.copy(Blocks.BLAST_FURNACE).nonOpaque()));

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(RbsgMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(RbsgMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        RbsgMod.LOGGER.info("registering mod blocks for " + RbsgMod.MOD_ID);
    }
}
