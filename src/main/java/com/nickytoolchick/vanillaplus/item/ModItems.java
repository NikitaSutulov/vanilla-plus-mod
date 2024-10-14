package com.nickytoolchick.vanillaplus.item;

import com.nickytoolchick.vanillaplus.VanillaPlusMod;
import com.nickytoolchick.vanillaplus.item.custom.DaggerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item WOODEN_DAGGER = registerItem(
            "wooden_dagger",
            new DaggerItem(ToolMaterials.WOOD, new Item.Settings().attributeModifiers(DaggerItem.createAttributeModifiers(ToolMaterials.WOOD, 1, -1F)))
    );

    public static final Item STONE_DAGGER = registerItem(
            "stone_dagger",
            new DaggerItem(ToolMaterials.STONE, new Item.Settings().attributeModifiers(DaggerItem.createAttributeModifiers(ToolMaterials.STONE, 1, -1F)))
    );

    public static final Item GOLDEN_DAGGER = registerItem(
            "golden_dagger",
            new DaggerItem(ToolMaterials.GOLD, new Item.Settings().attributeModifiers(DaggerItem.createAttributeModifiers(ToolMaterials.GOLD, 1, -1F)))
    );

    public static final Item IRON_DAGGER = registerItem(
            "iron_dagger",
            new DaggerItem(ToolMaterials.IRON, new Item.Settings().attributeModifiers(DaggerItem.createAttributeModifiers(ToolMaterials.IRON, 1, -1F)))
    );

    public static final Item DIAMOND_DAGGER = registerItem(
            "diamond_dagger",
            new DaggerItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(DaggerItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -1F)))
    );

    public static final Item NETHERITE_DAGGER = registerItem(
            "netherite_dagger",
            new DaggerItem(ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(DaggerItem.createAttributeModifiers(ToolMaterials.NETHERITE, 1, -1F)))
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(VanillaPlusMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        VanillaPlusMod.LOGGER.info("Registering Mod Items for " + VanillaPlusMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(WOODEN_DAGGER);
            entries.add(STONE_DAGGER);
            entries.add(GOLDEN_DAGGER);
            entries.add(IRON_DAGGER);
            entries.add(DIAMOND_DAGGER);
            entries.add(NETHERITE_DAGGER);
        });
    }
}
