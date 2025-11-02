package org.example.thevikingway.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import org.example.thevikingway.init.MobEffects;

public class ScandinavianAxeItem extends AxeItem {

    public ScandinavianAxeItem(Tier tier, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.hurtEnemy(stack, target, attacker);
        if (!attacker.level.isClientSide && target.isDeadOrDying()) {
            attacker.addEffect(new MobEffectInstance(MobEffects.BLESSING_OF_ODIN.get(), 200, 0));
        }
        return result;
    }
}

