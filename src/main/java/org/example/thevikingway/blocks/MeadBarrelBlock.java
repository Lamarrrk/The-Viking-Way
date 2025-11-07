package org.example.thevikingway.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import org.example.thevikingway.init.ItemInit;

import java.util.Random;

public class MeadBarrelBlock extends HorizontalDirectionalBlock {

    public static final BooleanProperty FERMENTING = BlockStateProperties.LIT;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public MeadBarrelBlock() {
        super(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5f).sound(SoundType.WOOD));
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FERMENTING, false)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FERMENTING, FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
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