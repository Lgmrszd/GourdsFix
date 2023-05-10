package com.lgmrszd.gourds_fix;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
public class CommonClass {
    public static void init() {
    }

    public static void onStemGrowth(BlockState state, BlockPos pos, LevelAccessor level) {
        if (!(state.getBlock() instanceof AttachedStemBlock)) return;
        Direction dir = state.getValue(AttachedStemBlock.FACING);
        BlockState grownBlock = level.getBlockState(pos.relative(dir));
        if (grownBlock.hasProperty(BlockStateProperties.FACING)) {
            BlockState newState = grownBlock.setValue(BlockStateProperties.FACING, dir.getOpposite());
            level.setBlock(pos.relative(dir), newState, 0);
        }
    }
}