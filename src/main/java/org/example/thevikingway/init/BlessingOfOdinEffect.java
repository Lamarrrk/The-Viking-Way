package org.example.thevikingway.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class BlessingOfOdinEffect extends MobEffect {

    public BlessingOfOdinEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x8A2BE2);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        entity.addEffect(new MobEffectInstance(net.minecraft.world.effect.MobEffects.MOVEMENT_SPEED, 25, 1, false, false));
        entity.addEffect(new MobEffectInstance(net.minecraft.world.effect.MobEffects.DAMAGE_RESISTANCE, 25, 0, false, false));
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
