package com.nickytoolchick.vanillaplus.item;

import com.nickytoolchick.vanillaplus.VanillaPlusMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(VanillaPlusMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        VanillaPlusMod.LOGGER.info("Registering Mod Items for " + VanillaPlusMod.MOD_ID);
    }
}
