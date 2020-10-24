package net.nile.guns;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class BulletEntityModel extends EntityModel<BulletEntity> {

    private final ModelPart base;

    public BulletEntityModel(){
        textureHeight = 2;
        textureWidth = 4;
        base = new ModelPart(this, 0, 0);
        base.addCuboid(-.5f, 3.0f, -.5f, 1, 1, 1);
    }

    @Override
    public void setAngles(BulletEntity entity, float limbAngle, float limbDistance, float animationProgress,
            float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green,
            float blue, float alpha) {
        matrices.translate(0, 1.25, 0);
        // render cube
        base.render(matrices, vertices, light, overlay);

    }
    
}
