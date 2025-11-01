package org.example.thevikingway.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import org.example.thevikingway.init.ItemInit;

public class SteelSwordItem extends Item{
    public SteelSwordItem(Properties properties) {
        super(properties);
    }
    public int getUses(){
        return 800;
    }
    public float getSpeed(){
        return 7.0f;
    }
    public float getAttackDamageBonus(){
        return 4.0f;
    }
    public int getLevel(){
        return 2;
    }
    public int getEnchantmentValue() {
        return 12;
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemInit.STEEL_INGOT.get());
    }
}
