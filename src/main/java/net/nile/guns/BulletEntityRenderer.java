package net.nile.guns;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class BulletEntityRenderer extends MobEntityRenderer<BulletEntity, BulletEntityModel> {

public static final Identifier texture = new Identifier(NileGuns.modid, "textures/entity/bullet.png");

    public BulletEntityRenderer(EntityRenderDispatcher entityRenderDispatcher, BulletEntityModel entityModel, float f) {
        super(entityRenderDispatcher, entityModel, f);
    }

    public BulletEntityRenderer(EntityRenderDispatcher entityRenderDispatcher)
    {
        super(entityRenderDispatcher, new BulletEntityModel(), 1/2f);
    }

    @Override
    public Identifier getTexture(BulletEntity entity) {
        return texture;
    }

    
}
