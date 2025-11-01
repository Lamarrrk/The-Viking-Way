package org.example.thevikingway.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import org.example.thevikingway.init.ItemInit;

public class SteelAxeItem extends Item {
    public SteelAxeItem(Properties properties) {
        super(properties);
    }
    public int getUses(){
        return 900;
    }
    public float getSpeed(){
        return 6.0f;
    }
    public float getAttackDamageBonus(){
        return 5.0f;
    }
    public int getLevel(){
        return 3;
    }
    public int getEnchantmentValue() {
        return 11;
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemInit.STEEL_INGOT.get());
    }
}