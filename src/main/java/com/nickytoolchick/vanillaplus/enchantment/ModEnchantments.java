package com.nickytoolchick.vanillaplus.enchantment;

import com.nickytoolchick.vanillaplus.VanillaPlusMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> TREE_CAPITATOR =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(VanillaPlusMod.MOD_ID, "tree_capitator"));

    public static void initialize() {}
}
