package org.example.thevikingway.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import org.example.thevikingway.init.ItemInit;

public class SteelHoeItem extends Item {
    public SteelHoeItem(Properties properties) {
        super(properties);
    }
    public int getUses(){
        return 500;
    }
    public float getSpeed(){
        return 6.5f;
    }
    public float getAttackDamageBonus(){
        return -2.0f;
    }
    public int getLevel(){
        return 2;
    }
    public int getEnchantmentValue() {
        return 14;
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemInit.STEEL_INGOT.get());
    }
}
