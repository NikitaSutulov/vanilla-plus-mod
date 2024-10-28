package com.nickytoolchick.vanillaplus.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.Vec3d;

public class ModCommands {
    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> registerAliases(dispatcher));
    }

    private static void registerAliases(CommandDispatcher<ServerCommandSource> dispatcher) {
        // Game mode aliases
        dispatcher.register(CommandManager.literal("survival")
                .executes(context -> executeCommand(context, "gamemode survival")));

        dispatcher.register(CommandManager.literal("creative")
                .executes(context -> executeCommand(context, "gamemode creative")));

        dispatcher.register(CommandManager.literal("adventure")
                .executes(context -> executeCommand(context, "gamemode adventure")));

        dispatcher.register(CommandManager.literal("spectator")
                .executes(context -> executeCommand(context, "gamemode spectator")));

        // Game rule aliases
        dispatcher.register(CommandManager.literal("keepInventory")
                .then(CommandManager.argument("value", BoolArgumentType.bool())
                        .executes(context -> {
                            boolean valueArg = BoolArgumentType.getBool(context, "value");
                            String command = "gamerule keepInventory " + valueArg;
                            return executeCommand(context, command);
                        }))
        );

        dispatcher.register(CommandManager.literal("mobGriefing")
                .then(CommandManager.argument("value", BoolArgumentType.bool())
                        .executes(context -> {
                            boolean valueArg = BoolArgumentType.getBool(context, "value");
                            String command = "gamerule mobGriefing " + valueArg;
                            return executeCommand(context, command);
                        }))
        );

        // Time aliases
        dispatcher.register(CommandManager.literal("day")
                .executes(context -> executeCommand(context, "time set day")));

        dispatcher.register(CommandManager.literal("night")
                .executes(context -> executeCommand(context, "time set night")));

        dispatcher.register(CommandManager.literal("noon")
                .executes(context -> executeCommand(context, "time set noon")));

        dispatcher.register(CommandManager.literal("midnight")
                .executes(context -> executeCommand(context, "time set midnight")));

        dispatcher.register(CommandManager.literal("clock")
                .executes(context -> executeCommand(context, "time query daytime")));

        // Weather aliases
        dispatcher.register(CommandManager.literal("sun")
                .executes(context -> executeCommand(context, "weather clear")));

        dispatcher.register(CommandManager.literal("rain")
                .executes(context -> executeCommand(context, "weather rain")));

        dispatcher.register(CommandManager.literal("thunder")
                .executes(context -> executeCommand(context, "weather thunder")));

        // Difficulty aliases
        dispatcher.register(CommandManager.literal("peaceful")
                .executes(context -> executeCommand(context, "difficulty peaceful")));

        dispatcher.register(CommandManager.literal("easy")
                .executes(context -> executeCommand(context, "difficulty easy")));

        dispatcher.register(CommandManager.literal("normal")
                .executes(context -> executeCommand(context, "difficulty normal")));

        dispatcher.register(CommandManager.literal("hard")
                .executes(context -> executeCommand(context, "difficulty hard")));

        // Teleportation aliases
        dispatcher.register(CommandManager.literal("tpall")
                .then(CommandManager.argument("x", StringArgumentType.string())
                        .then(CommandManager.argument("y", StringArgumentType.string())
                                .then(CommandManager.argument("z", StringArgumentType.string())
                                        .executes(context -> {
                                            String xArg = StringArgumentType.getString(context, "x");
                                            String yArg = StringArgumentType.getString(context, "y");
                                            String zArg = StringArgumentType.getString(context, "z");

                                            ServerCommandSource source = context.getSource();
                                            Vec3d sourcePos = source.getPosition();

                                            double x = parseCoordinate(xArg, sourcePos.x);
                                            double y = parseCoordinate(yArg, sourcePos.y);
                                            double z = parseCoordinate(zArg, sourcePos.z);

                                            source.getServer().getCommandManager()
                                                    .executeWithPrefix(source, String.format("tp @a %f %f %f", x, y, z));

                                            return 1;
                                        })
                                )))
        );

        // Effect aliases
        dispatcher.register(CommandManager.literal("speed")
                .then(CommandManager.argument("duration", DoubleArgumentType.doubleArg())
                        .then(CommandManager.argument("amplifier", DoubleArgumentType.doubleArg())
                                .executes(context -> {
                                    double duration = DoubleArgumentType.getDouble(context, "duration");
                                    double amplifier = DoubleArgumentType.getDouble(context, "amplifier");
                                    return executeCommand(context, String.format("effect give @a speed %d %d", (int) duration, (int) amplifier));
                                }))
                ));

        dispatcher.register(CommandManager.literal("strength")
                .then(CommandManager.argument("duration", DoubleArgumentType.doubleArg())
                        .then(CommandManager.argument("amplifier", DoubleArgumentType.doubleArg())
                                .executes(context -> {
                                    double duration = DoubleArgumentType.getDouble(context, "duration");
                                    double amplifier = DoubleArgumentType.getDouble(context, "amplifier");
                                    return executeCommand(context, String.format("effect give @a strength %d %d", (int) duration, (int) amplifier));
                                }))
                ));

        dispatcher.register(CommandManager.literal("jumpboost")
                .then(CommandManager.argument("duration", DoubleArgumentType.doubleArg())
                        .then(CommandManager.argument("amplifier", DoubleArgumentType.doubleArg())
                                .executes(context -> {
                                    double duration = DoubleArgumentType.getDouble(context, "duration");
                                    double amplifier = DoubleArgumentType.getDouble(context, "amplifier");
                                    return executeCommand(context, String.format("effect give @a jump_boost %d %d", (int) duration, (int) amplifier));
                                }))
                ));

        dispatcher.register(CommandManager.literal("regeneration")
                .then(CommandManager.argument("duration", DoubleArgumentType.doubleArg())
                        .then(CommandManager.argument("amplifier", DoubleArgumentType.doubleArg())
                                .executes(context -> {
                                    double duration = DoubleArgumentType.getDouble(context, "duration");
                                    double amplifier = DoubleArgumentType.getDouble(context, "amplifier");
                                    return executeCommand(context, String.format("effect give @a regeneration %d %d", (int) duration, (int) amplifier));
                                }))
                ));

        dispatcher.register(CommandManager.literal("invisibility")
                .then(CommandManager.argument("duration", DoubleArgumentType.doubleArg())
                        .executes(context -> {
                            double duration = DoubleArgumentType.getDouble(context, "duration");
                            return executeCommand(context, String.format("effect give @a invisibility %d", (int) duration));
                        }))
        );

        // Give kits aliases
        dispatcher.register(CommandManager.literal("kit")
                .then(CommandManager.argument("name", StringArgumentType.string())
                        .executes(context -> {
                            String kitName = StringArgumentType.getString(context, "name");
                            switch (kitName.toLowerCase()) {
                                case "starter":
                                    executeCommand(context, "give @p wooden_sword 1");
                                    executeCommand(context, "give @p wooden_pickaxe 1");
                                    executeCommand(context, "give @p wooden_axe 1");
                                    executeCommand(context, "give @p wooden_shovel 1");
                                    executeCommand(context, "give @p wooden_hoe 1");
                                    executeCommand(context, "give @p apple 16");
                                    executeCommand(context, "give @p oak_log 64");
                                    executeCommand(context, "give @p oak_planks 64");
                                    executeCommand(context, "give @p cooked_beef 64");
                                    executeCommand(context, "give @p leather_helmet 1");
                                    executeCommand(context, "give @p leather_chestplate 1");
                                    executeCommand(context, "give @p leather_leggings 1");
                                    executeCommand(context, "give @p leather_boots 1");
                                    return 1;

                                case "battle":
                                    executeCommand(context, "give @p netherite_sword 1");
                                    executeCommand(context, "give @p netherite_pickaxe 1");
                                    executeCommand(context, "give @p netherite_axe 1");
                                    executeCommand(context, "give @p shield 1");
                                    executeCommand(context, "give @p golden_apple 5");
                                    executeCommand(context, "give @p bow 1");
                                    executeCommand(context, "give @p cooked_beef 64");
                                    executeCommand(context, "give @p arrow 64");
                                    executeCommand(context, "give @p netherite_helmet 1");
                                    executeCommand(context, "give @p netherite_chestplate 1");
                                    executeCommand(context, "give @p netherite_leggings 1");
                                    executeCommand(context, "give @p netherite_boots 1");
                                    return 1;

                                case "builder":
                                    executeCommand(context, "give @p stone 64");
                                    executeCommand(context, "give @p dirt 64");
                                    executeCommand(context, "give @p oak_planks 64");
                                    executeCommand(context, "give @p sandstone 64");
                                    executeCommand(context, "give @p glass 64");
                                    executeCommand(context, "give @p cooked_beef 64");
                                    return 1;

                                case "miner":
                                    executeCommand(context, "give @p diamond_pickaxe 1");
                                    executeCommand(context, "give @p diamond_shovel 1");
                                    executeCommand(context, "give @p torch 64");
                                    executeCommand(context, "give @p water_bucket 1");
                                    executeCommand(context, "give @p cooked_beef 64");
                                    return 1; 

                                default:
                                    return 0;
                            }
                        })
                )
        );

        // Clear entities aliases
        dispatcher.register(CommandManager.literal("clearEntities")
                .executes(context -> executeCommand(context, "kill @e[type=!player]")));
    }

    private static int executeCommand(CommandContext<ServerCommandSource> context, String command) {
        MinecraftServer server = context.getSource().getServer();
        server.getCommandManager().executeWithPrefix(context.getSource(), command);
        return 1;
    }

    private static double parseCoordinate(String arg, double currentCoord) {
        if (arg.startsWith("~")) {
            if (arg.length() == 1) {
                return currentCoord;
            } else {
                return currentCoord + Double.parseDouble(arg.substring(1));
            }
        } else {
            return Double.parseDouble(arg);
        }
    }
}
