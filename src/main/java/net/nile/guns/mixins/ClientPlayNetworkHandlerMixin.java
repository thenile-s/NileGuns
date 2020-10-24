package net.nile.guns.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.math.Vec3d;
import net.nile.guns.BulletEntity;
import net.nile.guns.NileGuns;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
    @Shadow
    private ClientWorld world;
    @Inject(
            at = @At("HEAD"),
			method = "onEntitySpawn(Lnet/minecraft/network/packet/s2c/play/EntitySpawnS2CPacket;)V",
			cancellable = true
    )
    private void onEntitySpawn(EntitySpawnS2CPacket packet, CallbackInfo ci) {
		Entity entity = null;
		if (packet.getEntityTypeId() == NileGuns.BULLET) {
            entity = new BulletEntity(NileGuns.BULLET, world);
		} // we can replicate this one here for all our other entities
		// entity would be null here when the type was not one for us
		if (entity != null) {
            double x,y,z; x = packet.getX(); y = packet.getY(); z = packet.getZ();
            entity .setPos(x, y, z);
			int entityId = packet.getId();
			entity.setVelocity(new Vec3d(packet.getVelocityX(), packet.getVelocityY(), packet.getVelocityZ())); // entities always spawn standing still. We may change this later
			entity.updatePosition(x, y, z);
			entity.updateTrackedPosition(x, y, z);
			entity.pitch = (float) (packet.getPitch() * 360) / 256.0F;
			entity.yaw = (float) (packet.getYaw() * 360) / 256.0F;
			entity.setEntityId(entityId);
			entity.setUuid(packet.getUuid());
			this.world.addEntity(entityId, entity);
			ci.cancel(); // cancel stops the rest of the method to run (so no spawning code from mc runs)
		}
	}
}
