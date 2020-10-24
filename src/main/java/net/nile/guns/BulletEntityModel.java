package net.nile.guns;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.projectile.ArrowEntity;

public class BulletEntityModel extends EntityModel<ArrowEntity> {

    private final ModelPart base;

    public BulletEntityModel(){
        textureHeight = 2;
        textureWidth = 4;
        base = new ModelPart(this, 0, 0);
        base.addCuboid(-0.5f,3.75f, -0.5f, 1, 1, 1);
    }

    @Override
    public void setAngles(ArrowEntity entity, float limbAngle, float limbDistance, float animationProgress,
            float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green,
            float blue, float alpha) {
        //matrices.translate(0, 1.25, 0);
        // render cube
        base.render(matrices, vertices, light, overlay);

    }
    
}
