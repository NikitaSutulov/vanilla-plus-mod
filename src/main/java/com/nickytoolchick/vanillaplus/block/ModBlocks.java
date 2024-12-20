package com.nickytoolchick.vanillaplus.block;

import com.nickytoolchick.vanillaplus.VanillaPlusMod;
import com.nickytoolchick.vanillaplus.block.clocks.*;
import com.nickytoolchick.vanillaplus.block.crops.TomatoCropBlock;
import com.nickytoolchick.vanillaplus.block.gates.*;
import com.nickytoolchick.vanillaplus.world.ModConfiguredFeatures;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModBlocks {
    public static final Block AND_GATE_WITH_THREE_INPUTS_BLOCK = registerBlock("and_gate_with_three_inputs_block",
            new AndGateWithThreeInputsBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block AND_GATE_WITH_TWO_INPUTS_BLOCK = registerBlock("and_gate_with_two_inputs_block",
            new AndGateWithTwoInputsBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block NAND_GATE_WITH_THREE_INPUTS_BLOCK = registerBlock("nand_gate_with_three_inputs_block",
            new NandGateWithThreeInputsBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block NAND_GATE_WITH_TWO_INPUTS_BLOCK = registerBlock("nand_gate_with_two_inputs_block",
            new NandGateWithTwoInputsBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block NOR_GATE_WITH_THREE_INPUTS_BLOCK = registerBlock("nor_gate_with_three_inputs_block",
            new NorGateWithThreeInputsBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block NOR_GATE_WITH_TWO_INPUTS_BLOCK = registerBlock("nor_gate_with_two_inputs_block",
            new NorGateWithTwoInputsBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block NOT_GATE_BLOCK = registerBlock("not_gate_block",
            new NotGateBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block OR_GATE_WITH_THREE_INPUTS_BLOCK = registerBlock("or_gate_with_three_inputs_block",
            new OrGateWithThreeInputsBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block OR_GATE_WITH_TWO_INPUTS_BLOCK = registerBlock("or_gate_with_two_inputs_block",
            new OrGateWithTwoInputsBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block XNOR_GATE_WITH_THREE_INPUTS_BLOCK = registerBlock("xnor_gate_with_three_inputs_block",
            new XnorGateWithThreeInputsBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block XNOR_GATE_WITH_TWO_INPUTS_BLOCK = registerBlock("xnor_gate_with_two_inputs_block",
            new XnorGateWithTwoInputsBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block XOR_GATE_WITH_THREE_INPUTS_BLOCK = registerBlock("xor_gate_with_three_inputs_block",
            new XorGateWithThreeInputsBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block XOR_GATE_WITH_TWO_INPUTS_BLOCK = registerBlock("xor_gate_with_two_inputs_block",
            new XorGateWithTwoInputsBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block REDSTONE_CLOCK_BLOCK = registerBlock("redstone_clock_block",
            new RedstoneClockBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .nonOpaque()));

    public static final Block APPLE_LOG = registerBlock("apple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).strength(4f)));
    public static final Block APPLE_WOOD = registerBlock("apple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_APPLE_LOG = registerBlock("stripped_apple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final Block STRIPPED_APPLE_WOOD = registerBlock("stripped_apple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(4f)));
    public static final Block APPLE_PLANKS = registerBlock("apple_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(4f)));
    public static final Block APPLE_LEAVES = registerBlock("apple_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).nonOpaque()));
    public static final Block APPLE_SAPLING = registerBlock("apple_sapling",
            new SaplingBlock(
                    new SaplingGenerator(
                            Identifier.of(VanillaPlusMod.MOD_ID, "apple_tree").toString(),
                            0.1F,
                            Optional.empty(),
                            Optional.empty(),
                            Optional.of(ModConfiguredFeatures.APPLE_TREE_KEY),
                            Optional.empty(),
                            Optional.empty(),
                            Optional.empty()
                    ),
                    AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)
            )
    );

    public static final Block TOMATO_CROP = registerBlockWithoutBlockItem("tomato_crop",
            new TomatoCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));


    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(VanillaPlusMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(VanillaPlusMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(VanillaPlusMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerBlocks() {
        VanillaPlusMod.LOGGER.info("Registering Mod Blocks for " + VanillaPlusMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(AND_GATE_WITH_THREE_INPUTS_BLOCK);
            entries.add(AND_GATE_WITH_TWO_INPUTS_BLOCK);
            entries.add(NAND_GATE_WITH_THREE_INPUTS_BLOCK);
            entries.add(NAND_GATE_WITH_TWO_INPUTS_BLOCK);
            entries.add(NOR_GATE_WITH_THREE_INPUTS_BLOCK);
            entries.add(NOR_GATE_WITH_TWO_INPUTS_BLOCK);
            entries.add(NOT_GATE_BLOCK);
            entries.add(OR_GATE_WITH_THREE_INPUTS_BLOCK);
            entries.add(OR_GATE_WITH_TWO_INPUTS_BLOCK);
            entries.add(XNOR_GATE_WITH_THREE_INPUTS_BLOCK);
            entries.add(XNOR_GATE_WITH_TWO_INPUTS_BLOCK);
            entries.add(XOR_GATE_WITH_THREE_INPUTS_BLOCK);
            entries.add(XOR_GATE_WITH_TWO_INPUTS_BLOCK);
            entries.add(REDSTONE_CLOCK_BLOCK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(APPLE_LOG);
            entries.add(APPLE_WOOD);
            entries.add(APPLE_PLANKS);
            entries.add(APPLE_LEAVES);
            entries.add(STRIPPED_APPLE_LOG);
            entries.add(STRIPPED_APPLE_WOOD);
            entries.add(APPLE_SAPLING);
        });
    }
}
