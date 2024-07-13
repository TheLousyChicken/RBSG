package net.lpsy.rbsg.block.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CookingRecipeCategory;

public class RefiningRecipe extends AbstractCookingRecipe {
    private final int cookTime;
    private final float experience;
    private final ItemStack output;

    public RefiningRecipe(String group, CookingRecipeCategory category, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(RefinerBlockRegister.REFINING_RECIPE, group, category, input, output, experience, cookTime);
        this.cookTime = cookTime;
        this.experience = experience;
        this.output = output;
    }

    public int getCookingTime(){
        return this.cookTime;
    }

    public float getExperience() { return this.experience; }
    public ItemStack getResultItem() { return this.output; }

    public ItemStack createIcon() {
        return new ItemStack(RefinerBlockRegister.REFINER_BLOCK);
    }

    public boolean isIgnoredInRecipeBook() { return true; }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RefinerBlockRegister.REFINING_RECIPE_SERIALIZER;
    }
}
