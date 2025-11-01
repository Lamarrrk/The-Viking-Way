package org.example.thevikingway.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class SteelIngotItem extends Item  {
    public SteelIngotItem(Properties tab) {
        super(new Item.Properties()
                .stacksTo(64) //Стаки
                .tab(CreativeModeTab.TAB_MATERIALS)); // Вкладочка в креативі
    }
}
