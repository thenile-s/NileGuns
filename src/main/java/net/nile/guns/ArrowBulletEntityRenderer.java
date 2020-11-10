package net.nile.guns;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;

public class ArrowBulletEntityRenderer extends EntityRenderer<ArrowEntity> {

public static final Identifier texture = new Identifier(NileGuns.modid, "textures/entity/bullet.png");

protected ArrowBulletEntityModel model;

    public ArrowBulletEntityRenderer(EntityRenderDispatcher entityRenderDispatcher, ArrowBulletEntityModel entityModel) {
        super(entityRenderDispatcher);
        model = entityModel;
    }

    public ArrowBulletEntityRenderer(EntityRenderDispatcher entityRenderDispatcher)
    {
        super(entityRenderDispatcher);
        model = new ArrowBulletEntityModel();
    }

    @Override
    public Identifier getTexture(ArrowEntity entity) {
        return texture;
    }

    @Override
    public void render(ArrowEntity entity, float yaw, float tickDelta, MatrixStack matrices,
            VertexConsumerProvider vertexConsumers, int light) {
        model.render(matrices, vertexConsumers.getBuffer(model.getLayer(getTexture(entity))), light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        if (this.hasLabel(entity)) {
            this.renderLabelIfPresent(entity, entity.getDisplayName(), matrices, vertexConsumers, light);
        }
    }
}