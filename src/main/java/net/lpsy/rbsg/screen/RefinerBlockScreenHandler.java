package net.lpsy.rbsg.screen;
import net.lpsy.rbsg.block.custom.RefinerBlockRegister;
import net.lpsy.rbsg.block.entity.RefinerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;

public class RefinerBlockScreenHandler extends AbstractFurnaceScreenHandler {
    public RefinerBlockScreenHandler(int syncId, PlayerInventory playerInventory){
        super(RefinerBlockRegister.REFINER_SCREEN_HANDLER, RefinerBlockRegister.REFINING_RECIPE, RecipeBookCategory.FURNACE, syncId, playerInventory);
    }

    public RefinerBlockScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate){
        super(RefinerBlockRegister.REFINER_SCREEN_HANDLER, RefinerBlockRegister.REFINING_RECIPE, RecipeBookCategory.FURNACE, syncId, playerInventory, inventory, propertyDelegate);
    }
}

