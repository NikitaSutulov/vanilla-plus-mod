package com.nickytoolchick.vanillaplus.tag;

import com.nickytoolchick.vanillaplus.VanillaPlusMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static final TagKey<Enchantment> TREE_CAPITATOR_ENCHANTMENTS = createTag("tree_capitator_enchantments");
    public static final TagKey<Enchantment> SMELTING_ENCHANTMENTS = createTag("smelting_enchantments");

    private static TagKey<Enchantment> createTag(String name) {
        return TagKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(VanillaPlusMod.MOD_ID, name));
    }
}
