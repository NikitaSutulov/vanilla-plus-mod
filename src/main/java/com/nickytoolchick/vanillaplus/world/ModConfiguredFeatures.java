package com.nickytoolchick.vanillaplus.world;

import com.nickytoolchick.vanillaplus.VanillaPlusMod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> APPLE_TREE_KEY = registerKey("apple_tree");


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(VanillaPlusMod.MOD_ID, name));
    }
}
