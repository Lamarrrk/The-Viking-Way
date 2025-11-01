package org.example.thevikingway.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import org.example.thevikingway.init.ItemInit;

public class SteelShovelItem extends Item {
    public SteelShovelItem(Properties properties) {
        super(properties);
    }
    public int getUses(){
        return 600;
    }
    public float getSpeed(){
        return 7.5f;
    }
    public float getAttackDamageBonus(){
        return 1.5f;
    }
    public int getLevel(){
        return 3;
    }
    public int getEnchantmentValue() {
        return 12;
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemInit.STEEL_INGOT.get());
    }
}
