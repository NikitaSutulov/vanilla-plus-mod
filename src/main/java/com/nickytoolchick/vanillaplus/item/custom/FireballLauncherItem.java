package com.nickytoolchick.vanillaplus.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireballLauncherItem extends Item {
    public FireballLauncherItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (!world.isClient) {
            if (player.getAbilities().creativeMode) {
                launchFireball(world, player);
            } else {
                ItemStack fireballStack = getFireballStack(player);
                if (!fireballStack.isEmpty()) {
                    launchFireball(world, player);
                    fireballStack.decrement(1);
                    itemStack.damage(1, player, EquipmentSlot.MAINHAND);
                }
            }
            player.getItemCooldownManager().set(this, 20);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    private void launchFireball(World world, PlayerEntity player) {
        Vec3d direction = player.getRotationVec(1.0F);
        FireballEntity fireball = new FireballEntity(world, player, direction, 1);
        fireball.setPos(
                player.getX() + direction.x,
                player.getY() + player.getEyeHeight(player.getPose()),
                player.getZ() + direction.z
        );

        fireball.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 0);

        world.spawnEntity(fireball);
    }


    private ItemStack getFireballStack(PlayerEntity player) {
        for (ItemStack stack : player.getInventory().main) {
            if (stack.isOf(Items.FIRE_CHARGE)) {
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }
}
