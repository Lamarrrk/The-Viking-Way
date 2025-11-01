package org.example.thevikingway.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import org.example.thevikingway.init.ItemInit;

public class SteelPickaxeItem extends Item{
    public SteelPickaxeItem(Properties properties) {
        super(properties);
    }
    public int getUses(){
        return 850;
    }
    public float getSpeed(){
        return 7.2f;
    }
    public float getAttackDamageBonus(){
        return 1.0f;
    }
    public int getLevel(){
        return 4;
    }
    public int getEnchantmentValue() {
        return 13;
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemInit.STEEL_INGOT.get());
    }
}