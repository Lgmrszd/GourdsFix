package com.lgmrszd.gourds_fix;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import virtuoel.statement.api.StateRefresher;

import static com.lgmrszd.gourds_fix.CommonClass.onStemGrowth;

@Mod(Constants.MOD_ID)
public class GourdsFixForge {
    
    public GourdsFixForge() {
        StateRefresher.INSTANCE.addBlockProperty(Blocks.MELON, BlockStateProperties.FACING, Direction.UP);
        StateRefresher.INSTANCE.addBlockProperty(Blocks.PUMPKIN, BlockStateProperties.FACING, Direction.UP);
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.

        CommonClass.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onGrownEventPost(BlockEvent.CropGrowEvent.Post event) {
        BlockState state = event.getState();
        LevelAccessor level = event.getLevel();
        BlockPos pos = event.getPos();
        onStemGrowth(state, pos, level);
    }
}