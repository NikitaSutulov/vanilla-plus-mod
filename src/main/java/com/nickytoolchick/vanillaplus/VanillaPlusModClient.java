package com.nickytoolchick.vanillaplus;

import com.nickytoolchick.vanillaplus.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class VanillaPlusModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REDSTONE_CLOCK_BLOCK, RenderLayer.getCutout());
    }
}
