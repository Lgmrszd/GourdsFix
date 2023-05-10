package com.lgmrszd.gourds_fix.mixin;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StemGrownBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class StemGrownBlockPlacementCommonMixin {
    @Shadow public abstract BlockState defaultBlockState();

    @Inject(at = @At("HEAD"), method = "getStateForPlacement", cancellable = true)
    public void getStateForPlacementGourdsFix(BlockPlaceContext context, CallbackInfoReturnable<BlockState> cir) {
        if (!(this.defaultBlockState().getBlock() instanceof StemGrownBlock)) return;
        if (!(this.defaultBlockState().hasProperty(BlockStateProperties.FACING))) return;
        cir.setReturnValue(this.defaultBlockState().setValue(BlockStateProperties.FACING, context.getClickedFace()));
    }
}
