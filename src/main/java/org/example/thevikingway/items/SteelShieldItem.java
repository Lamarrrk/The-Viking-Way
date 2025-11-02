package org.example.thevikingway.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;

public class SteelShieldItem extends ShieldItem {

    private static final int STEEL_SHIELD_DURABILITY = 669;

    public SteelShieldItem(Item.Properties properties) {
        super(properties.durability(STEEL_SHIELD_DURABILITY));
    }
}
