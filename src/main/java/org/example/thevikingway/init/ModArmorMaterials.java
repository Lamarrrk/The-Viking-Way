package org.example.thevikingway.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.example.thevikingway.TheVikingWay;

public enum ModArmorMaterials implements ArmorMaterial {

    BARBARIAN("barbarian",
            26,                     // живе довше
            new int[]{3, 8, 7, 3},  // кращий захист
            15,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            1.5F,
            0.1F
    );

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;

    ModArmorMaterials(String name,
                      int durabilityMultiplier,
                      int[] protectionAmounts,
                      int enchantability,
                      SoundEvent equipSound,
                      float toughness,
                      float knockbackResistance) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurabilityForSlot(net.minecraft.world.entity.EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(net.minecraft.world.entity.EquipmentSlot slot) {
        return this.protectionAmounts[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemInit.STEEL_INGOT.get());
    }

    @Override
    public String getName() {
        return TheVikingWay.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}