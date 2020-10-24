package net.nile.guns;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class BulletEntity extends ArrowEntity {

    public BulletEntity(EntityType<? extends ArrowEntity> type, World world) {
        super(type, world);
        //ArrowEntity
    }

	public BulletEntity(World world, PlayerEntity user) {
        super(NileGuns.BULLET, world);
        setOwner(user);
    }
    
    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        //this.remove();
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        //entityHitResult.getEntity().damage(DamageSource.arrow(this, getOwner()), (float)getDamage());
        NileGuns.logger.info("Entity hit " + entityHitResult.getEntity().getEntityName());
        super.onEntityHit(entityHitResult);
    }
}
