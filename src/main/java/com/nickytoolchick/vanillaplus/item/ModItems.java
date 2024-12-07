package com.nickytoolchick.vanillaplus.item;

import com.nickytoolchick.vanillaplus.VanillaPlusMod;
import com.nickytoolchick.vanillaplus.item.custom.DaggerItem;
import com.nickytoolchick.vanillaplus.item.custom.FireballLauncherItem;
import com.nickytoolchick.vanillaplus.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
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

    private static final Item FIREBALL_LAUNCHER = registerItem("fireball_launcher",
            new FireballLauncherItem(new Item.Settings().maxDamage(384).maxCount(1)));

    private static final Item FLOUR = registerItem("flour", new Item(new Item.Settings()));

    private static final Item DOUGH = registerItem("dough", new Item(new Item.Settings()));

    private static final Item RAW_BEETROOT_SOUP = registerItem("raw_beetroot_soup", new Item(new Item.Settings().maxCount(1)));

    private static final Item RAW_BREAD = registerItem("raw_bread", new Item(new Item.Settings()));

    private static final Item RAW_CAKE = registerItem("raw_cake", new Item(new Item.Settings()));

    private static final Item RAW_COOKIE = registerItem("raw_cookie", new Item(new Item.Settings()));

    private static final Item RAW_MUSHROOM_STEW = registerItem("raw_mushroom_stew", new Item(new Item.Settings().maxCount(1)));

    private static final Item RAW_PUMPKIN_PIE = registerItem("raw_pumpkin_pie", new Item(new Item.Settings()));

    public static final Item TOMATO = registerItem("tomato",
            new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).build())));

    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds", new AliasedBlockItem(ModBlocks.TOMATO_CROP, new Item.Settings()));

    private static final Item BAKED_TOMATO = registerItem("baked_tomato",
            new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.5F).build())));

    private static final Item TOMATO_SOUP = registerItem("tomato_soup",
            new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).usingConvertsTo(Items.BOWL).build()).maxCount(1)));

    private static final Item RAW_TOMATO_SOUP = registerItem("raw_tomato_soup", new Item(new Item.Settings().maxCount(1)));

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
            entries.add(FIREBALL_LAUNCHER);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(FLOUR);
            entries.add(DOUGH);
            entries.add(RAW_BEETROOT_SOUP);
            entries.add(RAW_MUSHROOM_STEW);
            entries.add(RAW_BREAD);
            entries.add(RAW_CAKE);
            entries.add(RAW_COOKIE);
            entries.add(RAW_PUMPKIN_PIE);
            entries.add(RAW_TOMATO_SOUP);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(TOMATO);
            entries.add(BAKED_TOMATO);
            entries.add(TOMATO_SOUP);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(TOMATO_SEEDS);
        });
    }
}
