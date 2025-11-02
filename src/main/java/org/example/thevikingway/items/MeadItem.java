package org.example.thevikingway.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class MeadItem extends Item {

    public MeadItem(Properties properties) {
        super(properties.food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(0.4f)
                .alwaysEat()
                .build()));
    }

    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (!world.isClientSide) {
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
            entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0));
        }
        return super.finishUsingItem(stack, world, entity);
    }
}