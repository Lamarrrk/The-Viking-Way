package org.example.thevikingway.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TentBlock extends HorizontalDirectionalBlock {

    private static final VoxelShape SHAPE =
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);

    public TentBlock() {
        super(BlockBehaviour.Properties
                .of(Material.WOOL)
                .strength(0.8F)
                .sound(SoundType.WOOL)
                .noOcclusion()
        );
        this.registerDefaultState(
                this.stateDefinition.any().setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState()
                .setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state,
                                 Level level,
                                 BlockPos pos,
                                 Player player,
                                 InteractionHand hand,
                                 BlockHitResult hit) {

        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        if (!level.dimension().equals(Level.OVERWORLD)) {
            player.displayClientMessage(
                    new TranslatableComponent("message.thevikingway.tent.dimension"),
                    true
            );
            return InteractionResult.CONSUME;
        }

        if (level.isDay()) {
            player.displayClientMessage(
                    new TranslatableComponent("message.thevikingway.tent.only_night"),
                    true
            );
            return InteractionResult.CONSUME;
        }

        FoodData food = player.getFoodData();
        food.eat(4, 0.5F);

        player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 40, 0, false, false));
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, false, false));

        if (level instanceof ServerLevel serverLevel) {
            long dayTime = serverLevel.getDayTime();
            long nextDayStart = ((dayTime / 24000L) + 1L) * 24000L;
            serverLevel.setDayTime(nextDayStart + 1000L);
        }

        player.displayClientMessage(
                new TranslatableComponent("message.thevikingway.tent.rest"),
                true
        );

        return InteractionResult.CONSUME;
    }
}
