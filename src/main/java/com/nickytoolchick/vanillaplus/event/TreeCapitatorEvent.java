package com.nickytoolchick.vanillaplus.event;

import com.nickytoolchick.vanillaplus.tag.ModTags;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;

public class TreeCapitatorEvent {
    public static void register() {
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            ItemStack stack = player.getMainHandStack();
            if (!(stack.getItem() instanceof AxeItem)) {
                return true;
            }
            if (EnchantmentHelper.hasAnyEnchantmentsIn(stack, ModTags.TREE_CAPITATOR_ENCHANTMENTS)) {
                Block block = world.getBlockState(pos).getBlock();
                if (isWood(block)) {
                    breakTree(world, pos, player);
                    return true;
                }
            }
            return true;

        });
    };

    private static boolean isWood(Block block) {
        return block.getDefaultState().isIn(BlockTags.LOGS);
    }

    private static boolean isLeaves(Block block) {
        return block.getDefaultState().isIn(BlockTags.LEAVES);
    }

    private static void breakTree(World world, BlockPos pos, PlayerEntity player) {
        Set<BlockPos> blocksToBreak = new HashSet<>();
        ItemStack axeStack = player.getMainHandStack();
        int maxDurability = axeStack.getMaxDamage() - axeStack.getDamage();

        collectTreeBlocks(world, pos, blocksToBreak, maxDurability);

        int blocksBroken = 0;

        for (BlockPos blockPos : blocksToBreak) {
            BlockState state = world.getBlockState(blockPos);
            if (!state.isAir()) {
                if (isWood(state.getBlock()) && blocksBroken < maxDurability) {
                    world.breakBlock(blockPos, true, player);
                    blocksBroken++;
                } else if (isLeaves(state.getBlock())) {
                    world.breakBlock(blockPos, true, player);
                }
            }

            if (blocksBroken >= maxDurability) {
                break;
            }
        }

        axeStack.damage(blocksBroken, player, EquipmentSlot.MAINHAND);
    }

    private static int collectTreeBlocks(World world, BlockPos pos, Set<BlockPos> blocksToBreak, int maxBlocks) {
        if (blocksToBreak.contains(pos)) {
            return 0;
        }

        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        int woodCount = 0;

        if (isWood(block)) {
            blocksToBreak.add(pos);
            woodCount++;
        } else if (isLeaves(block)) {
            blocksToBreak.add(pos);
        } else {
            return 0;
        }

        if (woodCount > 0 && woodCount >= maxBlocks) {
            return woodCount;
        }

        for (BlockPos neighborPos : getNeighboringPositions(pos)) {
            woodCount += collectTreeBlocks(world, neighborPos, blocksToBreak, maxBlocks - woodCount);

            if (woodCount >= maxBlocks) {
                break;
            }
        }

        return woodCount;
    }

    private static Iterable<BlockPos> getNeighboringPositions(BlockPos pos) {
        Set<BlockPos> neighbors = new HashSet<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    if (dx != 0 || dy != 0 || dz != 0) {
                        neighbors.add(pos.add(dx, dy, dz));
                    }
                }
            }
        }
        return neighbors;
    }


}
