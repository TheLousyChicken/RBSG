package net.lpsy.rbsg.screen;
import net.lpsy.rbsg.block.custom.RefinerBlockRegister;
import net.lpsy.rbsg.block.entity.RefinerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;

public class RefinerBlockScreenHandler extends ScreenHandler {

    public Inventory inventory;
    public PropertyDelegate propertyDelegate;

    public RefinerBlockScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(27), new ArrayPropertyDelegate(RefinerBlockEntity.PROPERTY_DELEGATE_SIZE));
    }

    public RefinerBlockScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(RefinerBlockRegister.REFINER_SCREEN_HANDLER, syncId);
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.addProperties(this.propertyDelegate);

        //some inventories do custom logic when a player opens it.
        inventory.onOpen(playerInventory.player);

        this.addSlot(new Slot(inventory, 0, 80, 11));
        this.addSlot(new Slot(inventory, 1, 80, 59));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for(int i = 0; i < 3; ++i){
            for(int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l+i*9+9, 8+l*18, 84+i*18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory){
        for(int i=0; i<9; ++i){
            this.addSlot(new Slot(playerInventory, i, 8+i*18, 142));
        }
    }

    // Shift + Player Inv Slot
    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        //TODO - make only go into input slots (9 - 17)

        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStackNoCallbacks(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    public boolean isCrafting(){
        return propertyDelegate.get(0) >0;
    }

    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int progressArrowSize = 26;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }



    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

}

