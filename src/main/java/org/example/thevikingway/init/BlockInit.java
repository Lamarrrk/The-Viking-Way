package org.example.thevikingway.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.example.thevikingway.TheVikingWay;
import org.example.thevikingway.blocks.FermentationBarrelBlock;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TheVikingWay.MOD_ID);

    public static final RegistryObject<Block> FERMENTATION_BARREL =
            BLOCKS.register("fermentation_barrel", FermentationBarrelBlock::new);

    public static void registerBlockItems() {
        ItemInit.ITEMS.register("fermentation_barrel",
                () -> new BlockItem(FERMENTATION_BARREL.get(), new net.minecraft.world.item.Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    }
}
