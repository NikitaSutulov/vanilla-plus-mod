package com.nickytoolchick.vanillaplus.render;

import com.nickytoolchick.vanillaplus.mixin.BabyWitchMixin;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.WitchEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.WitchEntity;

public class BabyWitchRenderer extends WitchEntityRenderer {

    public BabyWitchRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    protected void scale(WitchEntity witchEntity, MatrixStack matrixStack, float f) {
        if (witchEntity.isBaby()) {
            float scale = 0.5F;
            matrixStack.scale(scale, scale, scale);
        } else {
            super.scale(witchEntity, matrixStack, f);
        }
    }
}
