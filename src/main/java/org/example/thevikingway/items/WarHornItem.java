package org.example.thevikingway.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class WarHornItem extends Item {

    private static final int EFFECT_DURATION = 5 * 60 * 20;

    public WarHornItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level,
                                                  Player player,
                                                  InteractionHand hand) {

        ItemStack stack = player.getItemInHand(hand);

        player.getCooldowns().addCooldown(this, 20 * 10);

        if (!level.isClientSide) {
            level.playSound(
                    null,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    SoundEvents.RAID_HORN,
                    SoundSource.PLAYERS,
                    4.0F,
                    1.0F
            );

            player.addEffect(new MobEffectInstance(
                    MobEffects.MOVEMENT_SPEED,
                    EFFECT_DURATION,
                    0,      // amplifier 0 = рівень 1
                    false,
                    true
            ));

            player.addEffect(new MobEffectInstance(
                    MobEffects.DAMAGE_BOOST,
                    EFFECT_DURATION,
                    0,
                    false,
                    true
            ));
        }

        player.swing(hand);

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
