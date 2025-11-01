package org.example.thevikingway;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.example.thevikingway.init.ItemInit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(TheVikingWay.MOD_ID)
public class TheVikingWay {

    public static final String MOD_ID = "thevikingway";

    private static final Logger LOGGER = LoggerFactory.getLogger(TheVikingWay.class);


    public TheVikingWay() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(modEventBus); // реєструємо наші айтеми в батьківський клас із init/ItemInit,
                                              // айтем war_horn вже має бути прям у майнкрафті якщо зайти та пошукати в табі в креативі

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("[The Viking Way] Вікінги прокидаються. Мод ініціалізовано!");
    }


    @net.minecraftforge.eventbus.api.SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("[The Viking Way] Сервер стартує з активним модом.");
    }
}