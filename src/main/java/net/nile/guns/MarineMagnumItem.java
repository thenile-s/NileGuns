package net.nile.guns;

import net.minecraft.block.entity.StructureBlockBlockEntity.Action;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.IntTag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MarineMagnumItem extends Item {

    public static final String bulletCooldownTag = "bulletCooldown";

    private static final int bulletCooldownTicks = 20;

    public MarineMagnumItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!user.getItemCooldownManager().isCoolingDown(this))
        {
            user.getItemCooldownManager().set(this, bulletCooldownTicks);
            ProjectileEntity arrow = new ArrowEntity(world, user);
            Vec3d rotation = user.getRotationVector();
            arrow.setVelocity(rotation.multiply(10));
            //arrow.setDamage(1000);
            //TODO bullets & damage
            //CreeperEntityModel
            //CreeperEntityRenderer
            //BowItem
            //ArrowEntity
            //ArrowItem
            //TODO render first person through held item renderer
            user.getMainHandStack().getCooldown();
            world.spawnEntity(arrow);
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}