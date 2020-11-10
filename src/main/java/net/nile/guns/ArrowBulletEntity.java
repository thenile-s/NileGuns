package net.nile.guns;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class ArrowBulletEntity extends ArrowEntity {

    public ArrowBulletEntity(World world, LivingEntity owner) {
        super(NileGuns.ARROW_BULLET, world);
        updatePosition(owner.getX(), owner.getEyeY() - 0.10000000149011612D, owner.getZ());
        setOwner(owner);
        pickupType = PickupPermission.DISALLOWED;
    }
    

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        this.remove();
    }

    @Override
    protected float getDragInWater() {
        return 1;
    }
}
