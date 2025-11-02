package org.example.thevikingway.init;

import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.example.thevikingway.TheVikingWay;
import org.example.thevikingway.items.MeadItem;
import org.example.thevikingway.items.ScandinavianAxeItem;
import org.example.thevikingway.items.SteelIngotItem;
import org.example.thevikingway.items.WarHornItem;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheVikingWay.MOD_ID);

    public static final RegistryObject<Item> WAR_HORN =
            ITEMS.register("war_horn",
                    () -> new WarHornItem(new Item.Properties()
                            .stacksTo(1)   // ріг один
                            .durability(0) // просто щоб показати, що він не ламається
                    ));
    public static final RegistryObject<Item> STEEL_INGOT =
            ITEMS.register("steel_ingot",
                    () -> new SteelIngotItem(new Item.Properties()
                            .stacksTo(64)
                            .tab(CreativeModeTab.TAB_MATERIALS)
                    ));
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
}
