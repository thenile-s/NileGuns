package net.nile.guns;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MarineMagnumItem extends Item {

    public static final String bulletCooldownTag = "bulletCooldown";

    private static final int bulletCooldownTicks = 20;

    public static final int magnumDamage = 6;

    public MarineMagnumItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!user.getItemCooldownManager().isCoolingDown(this))
        {
            user.getItemCooldownManager().set(this, bulletCooldownTicks);
            ArrowEntity arrow = new ArrowEntity(NileGuns.BULLET, world);
            // arrow.setCustomNameVisible(true); EntityType.ARROW
            // arrow.setCustomName(new LiteralText("Bullet :)"));
            Vec3d pos = user.getPos();
            arrow.setPos(pos.x, pos.y + user.getEyeHeight(user.getPose()), pos.z);
            // NileGuns.logger.info("Player pos " + pos.toString() + " arrow pos " + arrow.getPos().toString());
            // Vec3d rotation = user.getRotationVector();
            // arrow.setVelocity(rotation);
            arrow.setDamage(6);
            arrow.setProperties(user, user.pitch, user.yaw, 0, 4, 1);
            //arrow.setDamage(1000);
            //CreeperEntityModel
            //CreeperEntityRenderer
            //BowItem
            //ArrowEntity
            //ArrowItem
            //UseAction
            //TODO item model and texture
            //TODO render first person through held item renderer
            world.spawnEntity(arrow);
            world.playSound(null, pos.x, pos.y, pos.z, NileGuns.GUNSHOT, SoundCategory.PLAYERS, 1, 1);
            arrow.setSilent(true);
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}