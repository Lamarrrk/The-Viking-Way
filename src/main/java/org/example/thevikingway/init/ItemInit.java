package org.example.thevikingway.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.example.thevikingway.TheVikingWay;
import org.example.thevikingway.items.*;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheVikingWay.MOD_ID);

    /*-------------------------------------ITEMS-------------------------------------*/
    public static final RegistryObject<Item> WAR_HORN =
            ITEMS.register("war_horn",
                    () -> new WarHornItem(new Item.Properties()
                            .stacksTo(1)   // ріг один
                            .durability(0) // просто щоб показати, що він не ламається
                            .tab(CreativeModeTab.TAB_MISC)
                    ));
    public static final RegistryObject<Item> STEEL_INGOT =
            ITEMS.register("steel_ingot",
                    () -> new SteelIngotItem(new Item.Properties()
                            .stacksTo(64)
                            .tab(CreativeModeTab.TAB_MATERIALS)
                    ));
    public static final RegistryObject<Item> STEEL_SHIELD =
            ITEMS.register("steel_shield",
                    () -> new SteelShieldItem(
                            new Item.Properties()
                                    .stacksTo(1)
                                    .tab(CreativeModeTab.TAB_COMBAT)
                    ));

    /*-------------------------------------INSTRUMENTS-------------------------------------*/
    public static final RegistryObject<Item> STEEL_SWORD =
            ITEMS.register("steel_sword",
                    () -> new SwordItem(ModToolTiers.STEEL, 3, -2.4f,
                            new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> STEEL_PICKAXE =
            ITEMS.register("steel_pickaxe",
                    () -> new PickaxeItem(ModToolTiers.STEEL, 1, -2.8f,
                            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<Item> STEEL_AXE =
            ITEMS.register("steel_axe",
                    () -> new AxeItem(ModToolTiers.STEEL, 5.0f, -3.0f,
                            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<Item> STEEL_SHOVEL =
            ITEMS.register("steel_shovel",
                    () -> new ShovelItem(ModToolTiers.STEEL, 1.5f, -3.0f,
                            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<Item> STEEL_HOE =
            ITEMS.register("steel_hoe",
                    () -> new HoeItem(ModToolTiers.STEEL, -2, 0.0f,
                            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> SCANDINAVIAN_AXE =
            ITEMS.register("scandinavian_axe",
                    () -> new ScandinavianAxeItem(ModToolTiers.STEEL, 9.0f, -3.5f,
                            new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> MEAD = ITEMS.register("mead",
            () -> new MeadItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(16)));

    /*-------------------------------------ARMOR-------------------------------------*/
    public static final RegistryObject<Item> BARBARIAN_HELMET =
            ITEMS.register("barbarian_helmet",
                    () -> new BarbarianArmorItem(
                            ModArmorMaterials.BARBARIAN,
                            net.minecraft.world.entity.EquipmentSlot.HEAD,
                            new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
                    ));

    public static final RegistryObject<Item> BARBARIAN_CHESTPLATE =
            ITEMS.register("barbarian_chestplate",
                    () -> new BarbarianArmorItem(
                            ModArmorMaterials.BARBARIAN,
                            net.minecraft.world.entity.EquipmentSlot.CHEST,
                            new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
                    ));

    public static final RegistryObject<Item> BARBARIAN_LEGGINGS =
            ITEMS.register("barbarian_leggings",
                    () -> new BarbarianArmorItem(
                            ModArmorMaterials.BARBARIAN,
                            net.minecraft.world.entity.EquipmentSlot.LEGS,
                            new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
                    ));

    public static final RegistryObject<Item> BARBARIAN_BOOTS =
            ITEMS.register("barbarian_boots",
                    () -> new BarbarianArmorItem(
                            ModArmorMaterials.BARBARIAN,
                            net.minecraft.world.entity.EquipmentSlot.FEET,
                            new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
                    ));
    /*-------------------------------------FOOD-------------------------------------*/
    public static final RegistryObject<Item> ROAST_PIG =
            ITEMS.register("roast_pig", () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(12)
                            .saturationMod(1.2f)
                            .build())
                    .tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<Item> MEAT_STEW =
            ITEMS.register("meat_stew", () -> new BowlFoodItem(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(10)
                            .saturationMod(1.0f)
                            .build())
                    .stacksTo(1)
                    .tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<Item> FISH_SOUP =
            ITEMS.register("fish_soup", () -> new BowlFoodItem(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(8)
                            .saturationMod(0.9f)
                            .build())
                    .stacksTo(1)
                    .tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<Item> MEAT_ASSORTMENT =
            ITEMS.register("meat_assortment", () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(14)
                            .saturationMod(1.4f)
                            .build())
                    .tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<Item> VEGETABLE_SALAD =
            ITEMS.register("vegetable_salad", () -> new BowlFoodItem(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(7)
                            .saturationMod(0.8f)
                            .build())
                    .stacksTo(1)
                    .tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<Item> MEAT_WITH_SAUCE =
            ITEMS.register("meat_with_sauce", () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(10)
                            .saturationMod(1.0f)
                            .build())
                    .tab(CreativeModeTab.TAB_FOOD)));
}
