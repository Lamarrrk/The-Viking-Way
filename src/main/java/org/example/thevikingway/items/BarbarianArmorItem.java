package org.example.thevikingway.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.example.thevikingway.init.ItemInit;
import org.example.thevikingway.TheVikingWay;

public class BarbarianArmorItem extends ArmorItem {

    private static final String HEAL_TICK_KEY = TheVikingWay.MOD_ID + "_barb_heal_tick";
    private static final String HORN_BUFF_UNTIL_KEY = TheVikingWay.MOD_ID + "_horn_buff_until";

    private static final int HEAL_INTERVAL_TICKS = 1200;

    public static final int HORN_BUFF_DURATION_TICKS = 200;

    public BarbarianArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (level.isClientSide) {
            return;
        }

        boolean hasFullSet = hasFullBarbarianSet(player);

        if (!hasFullSet) {
            return;
        }

        long gameTime = level.getGameTime();

        passiveHealOncePerMinute(player, gameTime);

        int strengthAmplifier = getHornBuffAmplifier(player, gameTime);

        player.addEffect(new MobEffectInstance(
                MobEffects.DAMAGE_BOOST,
                25,
                strengthAmplifier,
                false,
                false,
                true
        ));

        player.addEffect(new MobEffectInstance(
                MobEffects.MOVEMENT_SLOWDOWN,
                25,
                0,
                false,
                false,
                true
        ));
    }

    private void passiveHealOncePerMinute(Player player, long gameTime) {
        var data = player.getPersistentData();
        long lastHealTick = data.getLong(HEAL_TICK_KEY);

        if (gameTime - lastHealTick >= HEAL_INTERVAL_TICKS) {
            if (player.getHealth() < player.getMaxHealth()) {
                player.heal(2.0F); // 1 сердечко
            }
            data.putLong(HEAL_TICK_KEY, gameTime);
        }
    }

    private int getHornBuffAmplifier(Player player, long gameTime) {
        long hornUntil = player.getPersistentData().getLong(HORN_BUFF_UNTIL_KEY);
        if (hornUntil > gameTime) {
            return 1; // Strength II
        }
        return 0;     // Strength I
    }

    private boolean hasFullBarbarianSet(Player player) {
        return player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemInit.BARBARIAN_HELMET.get()
                && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ItemInit.BARBARIAN_CHESTPLATE.get()
                && player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ItemInit.BARBARIAN_LEGGINGS.get()
                && player.getItemBySlot(EquipmentSlot.FEET).getItem() == ItemInit.BARBARIAN_BOOTS.get();
    }
}

