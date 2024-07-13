package net.lpsy.rbsg.block.entity;

import net.lpsy.rbsg.block.custom.RefinerBlockRegister;
import net.lpsy.rbsg.screen.RefinerBlockScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class RefinerBlockEntity extends AbstractFurnaceBlockEntity {
    public RefinerBlockEntity(BlockPos pos, BlockState state) {
        super(RefinerBlockRegister.REFINER_BLOCK_ENTITY, pos, state, RefinerBlockRegister.REFINING_RECIPE);
    }

    protected Text getContainerName() {
        return Text.translatable("container.refiner_block");
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory){
        return new RefinerBlockScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
