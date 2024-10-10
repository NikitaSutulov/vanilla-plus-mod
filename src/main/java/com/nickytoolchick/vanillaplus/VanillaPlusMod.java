package com.nickytoolchick.vanillaplus;

import com.nickytoolchick.vanillaplus.block.ModBlocks;
import com.nickytoolchick.vanillaplus.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaPlusMod implements ModInitializer {
	public static final String MOD_ID = "vanillaplusmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerBlocks();
		ModItems.registerModItems();
	}
}