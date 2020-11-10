package net.nile.guns;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MarineMagnumItem extends Item {

    public static final String bulletCooldownTag = "bulletCooldown";

    public static final int bulletCooldownTicks = 20;

    public static final int magnumDamage = 6;

    public static final float magnumVelocity = 4;

    public MarineMagnumItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!user.getItemCooldownManager().isCoolingDown(this) 
        /*&& user.getMainHandStack().getItem() instanceof MarineMagnumItem*/)
        {
            boolean hasAmmo = user.abilities.creativeMode;
            if(!hasAmmo)
            {
                ItemStack stack;
                for (int i = 0; i < user.inventory.size(); i++) {
                    stack = user.inventory.getStack(i);
                    if(stack.getItem() == NileGuns.ARROW_BULLET_ITEM)
                    {
                        stack.decrement(1);
                        hasAmmo = true;
                        break;
                    }
                }
            }
            if(hasAmmo)
            {
                user.getItemCooldownManager().set(this, bulletCooldownTicks);
                //ArrowEntity bullet = new ArrowEntity(EntityType.ARROW, world);
                //ArrowEntity bullet = new ArrowEntity(world, user); 
                //REMINDER THAT THIS WORKS IF U DONT SET POS
                ArrowEntity bullet = new ArrowBulletEntity(world, user);
                // arrow.setCustomNameVisible(true); EntityType.ARROW
                // arrow.setCustomName(new LiteralText("Bullet :)"));
                Vec3d pos = user.getPos();
                // NileGuns.logger.info("Player pos " + pos.toString() + " arrow pos " + arrow.getPos().toString());
                // Vec3d rotation = user.getRotationVector();
                // arrow.setVelocity(rotation);
                //bullet.setProperties(user, magnumDamage, magnumVelocity);
                //arrow.setDamage(1000);
                //CreeperEntityModel
                //CreeperEntityRenderer
                //BowItem
                //ArrowEntity+
                //ArrowItem
                //UseAction
                //ArrowEntity
                //bullet.setPos(pos.x, user.getEyeY(), pos.z);
                //ArrowEntity
                bullet.setProperties(user, user.pitch, user.yaw, 0.0F, 1 * magnumVelocity, 1.0F);
                bullet.setDamage(magnumDamage);;
                world.spawnEntity(bullet);
                world.playSound(null, pos.x, pos.y, pos.z, NileGuns.GUNSHOT, SoundCategory.PLAYERS, 1, 1);
                bullet.setSilent(true);
            }
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}