package net.lpsy.rbsg.block.custom;

import net.lpsy.rbsg.RbsgMod;
import net.lpsy.rbsg.block.entity.RefinerBlockEntity;
import net.lpsy.rbsg.screen.RefinerBlockScreenHandler;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class RefinerBlockRegister {
    public static Block REFINER_BLOCK;
    public static Item REFINER_ITEM;
    public static BlockEntityType REFINER_BLOCK_ENTITY;
    public static RecipeType<RefiningRecipe> REFINING_RECIPE;
    public static RecipeSerializer<RefiningRecipe> REFINING_RECIPE_SERIALIZER;
    public static ScreenHandlerType<RefinerBlockScreenHandler> REFINER_SCREEN_HANDLER;
    public static final Identifier INTERACT_WITH_REFINER = Identifier.of(RbsgMod.MOD_ID, "interact_with_refiner");

    public static void onInitialize() {
        REFINER_BLOCK = Registry.register(
                Registries.BLOCK, Identifier.of(RbsgMod.MOD_ID, "refiner_block"),
                new RefinerBlock(AbstractBlock.Settings.copy(Blocks.FURNACE)));
        REFINER_ITEM = Registry.register(Registries.ITEM,
                Identifier.of(RbsgMod.MOD_ID, "refiner_block"),
                new BlockItem(REFINER_BLOCK, new Item.Settings()));
        REFINER_BLOCK_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(RbsgMod.MOD_ID, "refiner_block"),
                BlockEntityType.Builder.create(RefinerBlockEntity::new, REFINER_BLOCK).build(null));
        REFINING_RECIPE = Registry.register(Registries.RECIPE_TYPE, Identifier.of(RbsgMod.MOD_ID, "haunting"), new RecipeType<RefiningRecipe>() {
            @Override
            public String toString() {return "rbsg:refining";}
        });
        REFINING_RECIPE_SERIALIZER = Registry.register(
                Registries.RECIPE_SERIALIZER,
                Identifier.of(RbsgMod.MOD_ID, "refining"),
                new CookingRecipeSerializer<>(RefiningRecipe::new, 200));
        REFINER_SCREEN_HANDLER = Registry.register(
                Registries.SCREEN_HANDLER,
                Identifier.of(RbsgMod.MOD_ID, "refiner_block"),
                new ScreenHandlerType<>(RefinerBlockScreenHandler::new, FeatureFlags.VANILLA_FEATURES));
    }
}
