package com.nickytoolchick.vanillaplus;

import com.nickytoolchick.vanillaplus.block.ModBlocks;
import com.nickytoolchick.vanillaplus.command.ModCommands;
import com.nickytoolchick.vanillaplus.enchantment.ModEnchantments;
import com.nickytoolchick.vanillaplus.event.TreeCapitatorEvent;
import com.nickytoolchick.vanillaplus.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaPlusMod implements ModInitializer {
	public static final String MOD_ID = "vanillaplusmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerBlocks();
		ModItems.registerModItems();
		ModCommands.registerCommands();
		ModEnchantments.initialize();

		TreeCapitatorEvent.register();

		StrippableBlockRegistry.register(ModBlocks.APPLE_LOG, ModBlocks.STRIPPED_APPLE_LOG);
		StrippableBlockRegistry.register(ModBlocks.APPLE_WOOD, ModBlocks.STRIPPED_APPLE_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.APPLE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.APPLE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_APPLE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_APPLE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.APPLE_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.APPLE_LEAVES, 30, 60);

		CompostingChanceRegistry.INSTANCE.add(ModItems.TOMATO, 0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.TOMATO_SEEDS, 0.25f);
	}
}