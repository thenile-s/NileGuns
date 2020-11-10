package net.nile.guns.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Arm;
import net.nile.guns.NileGuns;

@Mixin(BipedEntityModel.class)
public class SetArmAnglesMixin {
    @Inject(at = @At("HEAD"), method = "method_30154(Lnet/minecraft/entity/LivingEntity;)V", cancellable = true)
    private void SetAngles(LivingEntity entity, CallbackInfo cb)
    {
        boolean mainArmGun = (entity.getMainHandStack().getItem() == NileGuns.MARINE_MAGNUM);
        boolean offArmGun = (entity.getOffHandStack().getItem() == NileGuns.MARINE_MAGNUM);

        if(mainArmGun || offArmGun)
        {
            boolean rightArmMain = (entity.getMainArm() == Arm.RIGHT);
        BipedEntityModel model;
            if(mainArmGun)
        {
            if(rightArmMain)
            {
                model = (BipedEntityModel)(Object) this;
            // boolean bl3 = entity.getMainArm() == Arm.RIGHT;
            //model.leftArm.yaw = 0;
            model.rightArm.yaw = model.head.yaw;
            //model.leftArm.pitch = 0;
            model.rightArm.pitch = -1.5707964F + model.head.pitch;
            }
            else{
                model = (BipedEntityModel)(Object) this;
            // boolean bl3 = entity.getMainArm() == Arm.RIGHT;
            //model.rightArm.yaw = 0;
            model.leftArm.yaw = model.head.yaw;
           // model.rightArm.pitch = 0;
            model.leftArm.pitch = -1.5707964F + model.head.pitch;
            }
        }
        else if(offArmGun)
        {
            if(rightArmMain)
            {
                model = (BipedEntityModel)(Object) this;
            // boolean bl3 = entity.getMainArm() == Arm.RIGHT;
            //model.rightArm.yaw = 0;
            model.leftArm.yaw = model.head.yaw;
            //model.rightArm.pitch = 0;
            model.leftArm.pitch = -1.5707964F + model.head.pitch;
                
            }
            else{
               model = (BipedEntityModel)(Object) this;
            // boolean bl3 = entity.getMainArm() == Arm.RIGHT;
            //model.leftArm.yaw = 0;
            model.rightArm.yaw = model.head.yaw;
            //model.leftArm.pitch = 0;
            model.rightArm.pitch = -1.5707964F + model.head.pitch;
            }
        }
        cb.cancel();
        }
    }
}
