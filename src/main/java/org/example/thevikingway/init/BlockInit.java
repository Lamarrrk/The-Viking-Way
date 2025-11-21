package org.example.thevikingway.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.example.thevikingway.TheVikingWay;
import org.example.thevikingway.blocks.MeadBarrelBlock;
import org.example.thevikingway.blocks.TentBlock;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TheVikingWay.MOD_ID);

    public static final RegistryObject<Block> MEAD_BARREL = BLOCKS.register("mead_barrel", MeadBarrelBlock::new);
    public static final RegistryObject<Block> TENT = BLOCKS.register("tent", TentBlock::new);

    public static void registerBlockItems() {
        ItemInit.ITEMS.register("mead_barrel",
                () -> new BlockItem(MEAD_BARREL.get(), new net.minecraft.world.item.Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
        ItemInit.ITEMS.register("tent",
                () -> new BlockItem(TENT.get(), new net.minecraft.world.item.Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    }
}
