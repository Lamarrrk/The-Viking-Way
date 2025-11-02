package org.example.thevikingway.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.example.thevikingway.TheVikingWay;

public class MobEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TheVikingWay.MOD_ID);

    public static final RegistryObject<MobEffect> BLESSING_OF_ODIN =
            EFFECTS.register("blessing_of_odin", BlessingOfOdinEffect::new);

}
