package net.lpsy.rbsg.block.custom;

import com.mojang.serialization.MapCodec;
import net.lpsy.rbsg.block.entity.ModBlockEntities;
import net.lpsy.rbsg.block.entity.RefinerBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RefinerBlock extends BlockWithEntity implements BlockEntityProvider {

    public static final MapCodec<RefinerBlock> CODEC = createCodec(RefinerBlock::new);

    private static final VoxelShape SHAPE = Block.createCuboidShape(0,0,0, 16, 14, 16);
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty LIT = Properties.LIT;

    public RefinerBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
            if (world.isClient) {
                return ActionResult.SUCCESS;
            }
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            return ActionResult.CONSUME;
    }

//    @Nullable
//    @Override
//    public BlockState getPlacementState(ItemPlacementContext ctx) {
//        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
//    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.isOf(newState.getBlock())){
            return;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof RefinerBlockEntity refinerBlockEntity) {
            if (world instanceof ServerWorld){
                ItemScatterer.spawn(world, pos, refinerBlockEntity);
            }
            world.updateComparators(pos, this);
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RefinerBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        //return validateTicker(type, RefinerBlockRegister.REFINER_BLOCK_ENTITY, RefinerBlockEntity::tick);
        return validateTicker(type, RefinerBlockRegister.REFINER_BLOCK_ENTITY,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }

    protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof RefinerBlockEntity){
            player.openHandledScreen((NamedScreenHandlerFactory) blockEntity);
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

//    @Override
//    public BlockState rotate(BlockState state, BlockRotation rotation) {
//        return (BlockState)state.with(FACING, rotation.rotate(state.get(FACING)));
//    }
//
//    @Override
//    public BlockState mirror(BlockState state, BlockMirror mirror) {
//        return state.rotate(mirror.getRotation(state.get(FACING)));
//    }
//
//    @Override
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(FACING, LIT);
//    }

}
