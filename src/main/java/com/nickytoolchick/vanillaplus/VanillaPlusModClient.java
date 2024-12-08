package com.nickytoolchick.vanillaplus;

import com.nickytoolchick.vanillaplus.block.ModBlocks;
import com.nickytoolchick.vanillaplus.render.BabySpiderRenderer;
import com.nickytoolchick.vanillaplus.render.BabyWitchRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EntityType;

public class VanillaPlusModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REDSTONE_CLOCK_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APPLE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout());

        EntityRendererRegistry.register(EntityType.WITCH, BabyWitchRenderer::new);
        EntityRendererRegistry.register(EntityType.SPIDER, BabySpiderRenderer::new);
    }
}
