package net.lpsy.rbsg.datagen;

import com.google.common.base.Optional;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lpsy.rbsg.block.ModBlocks;
import net.lpsy.rbsg.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> ENDERITE_SMELTING = List.of(ModItems.ENDERITE_SCRAP,
            ModBlocks.ANCIENT_ARTIFACT);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, ENDERITE_SMELTING, RecipeCategory.MISC, ModItems.ENDERITE_SCRAP,
                2f, 400, "enderite");
        offerBlasting(exporter, ENDERITE_SMELTING, RecipeCategory.MISC, ModItems.ENDERITE_SCRAP,
                4f, 200, "enderite");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ENDERITE_INGOT, RecipeCategory.DECORATIONS,
                ModBlocks.ENDERITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENDERITE_INGOT, 1)
                .pattern("AAA")
                .pattern("ABB")
                .pattern("BB ")
                .input('A', ModItems.ENDERITE_SCRAP)
                .input('B', Items.GOLD_INGOT)
                .criterion(hasItem(ModItems.ENDERITE_SCRAP), conditionsFromItem(ModItems.ENDERITE_SCRAP))
                .offerTo(exporter, Identifier.of("rbsg", getRecipeName(ModItems.ENDERITE_INGOT) + "_shaped"));
    }
}
