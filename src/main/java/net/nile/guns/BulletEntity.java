package net.nile.guns;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.text.LiteralText;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class BulletEntity extends Entity {

    public BulletEntity(EntityType<?> type, World world) {
        super(type, world);
        //ArrowEntity
    }

    @Override
    protected void initDataTracker() {
       
    }

    @Override
    protected void readCustomDataFromTag(CompoundTag tag) {
        
    }

    @Override
    protected void writeCustomDataToTag(CompoundTag tag) {
        
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    public void tick() {
        
        super.tick();
    }
}
