package org.example.thevikingway.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import org.example.thevikingway.init.ItemInit;

import java.util.Random;

public class FermentationBarrelBlock extends Block {

    public static final BooleanProperty FERMENTING = BlockStateProperties.LIT;

    public FermentationBarrelBlock() {
        super(BlockBehaviour.Properties.of(net.minecraft.world.level.material.Material.WOOD).strength(2.5f));
        this.registerDefaultState(this.stateDefinition.any().setValue(FERMENTING, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FERMENTING);
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        if (state.getValue(FERMENTING)) {
            world.setBlock(pos, state.setValue(FERMENTING, false), 3);
            popResource(world, pos, new ItemStack(ItemInit.MEAD.get()));
        }
    }

    public void startFermentation(Level world, BlockPos pos, BlockState state) {
        if (!world.isClientSide && !state.getValue(FERMENTING)) {
            world.setBlock(pos, state.setValue(FERMENTING, true), 3);
            world.scheduleTick(pos, this, 200);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {

        ItemStack held = player.getItemInHand(hand);

        if (held.is(Items.HONEY_BOTTLE)) {
            if (!world.isClientSide) {
                startFermentation(world, pos, state);
                if (!player.isCreative()) held.shrink(1);
            }
            return InteractionResult.sidedSuccess(world.isClientSide);
        }

        return InteractionResult.PASS;
    }
}
