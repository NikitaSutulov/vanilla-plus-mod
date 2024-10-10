package com.nickytoolchick.vanillaplus.block.gates;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public abstract class AbstractLogicGateBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty POWERED = Properties.POWERED;

    public AbstractLogicGateBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(POWERED, false));
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        super.onBlockAdded(state, world, pos, oldState, notify);
        updateOutput(world, pos, state);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
        updateOutput(world, pos, state);
    }

    private void updateOutput(World world, BlockPos pos, BlockState state) {
        Direction facing = state.get(FACING);

        boolean input1 = world.getEmittedRedstonePower(pos.offset(facing.rotateYClockwise()), facing.rotateYClockwise()) > 0; // Right side of the block
        boolean input2 = world.getEmittedRedstonePower(pos.offset(facing.rotateYCounterclockwise()), facing.rotateYCounterclockwise()) > 0; // Left side of the block
        boolean input3 = world.getEmittedRedstonePower(pos.offset(facing), facing) > 0; // Behind the block

        boolean output = calculateOutput(input1, input2, input3);

        if (state.get(POWERED) != output) {
            world.setBlockState(pos, state.with(POWERED, output), 3);
            world.updateNeighborsAlways(pos, this);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(POWERED) && direction == state.get(FACING) ? 15 : 0;
    }

    @Override
    public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(POWERED) && direction == state.get(FACING) ? 15 : 0;
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(0, 0, 0, 16, 2, 16);
    }

    // method to be implemented in children code
    protected abstract boolean calculateOutput(boolean input1, boolean input2, boolean input3);
}
