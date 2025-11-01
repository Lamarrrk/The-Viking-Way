package org.example.thevikingway.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.example.thevikingway.TheVikingWay;
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
}
