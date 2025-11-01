package org.example.thevikingway.init;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier STEEL = new ForgeTier(
            2,
            600,
            6.5f,
            2.5f,
            14,
            null,
            () -> Ingredient.of(ItemInit.STEEL_INGOT.get())
    );
}
