package me.aleksilassila.litematica.printer.v1_19.guides.placement;

import me.aleksilassila.litematica.printer.v1_19.SchematicBlockState;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Direction;

public class FallingBlockGuide extends GuesserGuide {

    public FallingBlockGuide(SchematicBlockState state) {
        super(state);
    }

    @Override
    public boolean shouldSkip() {
        if (targetState.getBlock() instanceof FallingBlock) {
            BlockState below = state.world.getBlockState(state.blockPos.offset(Direction.DOWN));
            return FallingBlock.canFallThrough(below);
        }

        return super.shouldSkip();
    }
}
