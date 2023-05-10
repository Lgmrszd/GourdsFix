package com.lgmrszd.gourds_fix;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import virtuoel.statement.api.StateRefresher;

public class GourdsFixFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        StateRefresher.INSTANCE.addBlockProperty(Blocks.MELON, BlockStateProperties.FACING, Direction.UP);
        StateRefresher.INSTANCE.addBlockProperty(Blocks.PUMPKIN, BlockStateProperties.FACING, Direction.UP);

        CommonClass.init();
    }

}
