package net.nile.guns.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.nile.guns.MarineMagnumItem;
import net.nile.guns.NileGuns;

@Mixin(BipedEntityModel.class)
public class SetLeftArmAnglesMixin {
    @Inject(at = @At("HEAD"), method = "method_30154(Lnet/minecraft/entity/LivingEntity;)V", cancellable = true)
    private void SetAngles(LivingEntity entity, CallbackInfo cb)
    {
        if(entity.getMainHandStack().getItem() instanceof MarineMagnumItem)
        {
            BipedEntityModel model = (BipedEntityModel)(Object) this;
            //TODO get the pose right
            model.leftArm.yaw = 0.3f;
            model.rightArm.pitch = 0.3f;
            
            cb.cancel();
        }
    }
}
