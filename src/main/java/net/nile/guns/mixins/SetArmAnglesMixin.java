package net.nile.guns.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.nile.guns.MarineMagnumItem;

@Mixin(BipedEntityModel.class)
public class SetArmAnglesMixin {
    @Inject(at = @At("HEAD"), method = "method_30154(Lnet/minecraft/entity/LivingEntity;)V", cancellable = true)
    private void SetAngles(LivingEntity entity, CallbackInfo cb)
    {
        if(entity.getMainHandStack().getItem() instanceof MarineMagnumItem)
        {
            BipedEntityModel model = (BipedEntityModel)(Object) this;
            // boolean bl3 = entity.getMainArm() == Arm.RIGHT;
            model.rightArm.yaw = -0.1F + model.head.yaw - 0.4F;
            model.leftArm.yaw = 0.1F + model.head.yaw;
            model.rightArm.pitch = -1.5707964F + model.head.pitch;
            model.leftArm.pitch = -1.5707964F + model.head.pitch;
            
            cb.cancel();
        }
    }
}
