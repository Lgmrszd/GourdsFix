package com.lgmrszd.gourds_fix.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static com.lgmrszd.gourds_fix.CommonClass.onStemGrowth;

@Mixin(StemBlock.class)
public class StemBlockRandomTickMixin {
    @Inject(at = @At("TAIL"), method = "randomTick")
    private void randomTickGourdsFix(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Random random, CallbackInfo ci) {
        BlockState newState = serverLevel.getBlockState(blockPos);
        onStemGrowth(newState, blockPos, serverLevel);
    }
}
