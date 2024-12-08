package com.nickytoolchick.vanillaplus.render;

import com.nickytoolchick.vanillaplus.mixin.BabySpiderMixin;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SpiderEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.SpiderEntity;

public class BabySpiderRenderer extends SpiderEntityRenderer<SpiderEntity> {
    public BabySpiderRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    protected void scale(SpiderEntity spiderEntity, MatrixStack matrixStack, float f) {
        if (spiderEntity.isBaby()) {
            float scale = 0.5F;
            matrixStack.scale(scale, scale, scale);
        } else {
            super.scale(spiderEntity, matrixStack, f);
        }
    }
}
