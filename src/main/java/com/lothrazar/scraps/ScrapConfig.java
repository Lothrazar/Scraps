package com.lothrazar.scraps;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.fml.loading.FMLPaths;

public class ScrapConfig {

  private static final ForgeConfigSpec.Builder CFG = new ForgeConfigSpec.Builder();
  private static ForgeConfigSpec COMMON_CONFIG;
  public static BooleanValue WORLDGEN_ENABLED;
  public static BooleanValue STEPHARVEST_ENABLED;
  public static IntValue METAL_SMALL_COUNT;
  public static IntValue METAL_SMALL_BOTTOM;
  public static IntValue METAL_SMALL_TOP;
  public static IntValue METAL_LARGE_BOTTOM;
  public static IntValue METAL_LARGE_TOP;
  public static IntValue BRUSH_SMALL_COUNT;
  public static IntValue BRUSH_SMALL_BOTTOM;
  public static IntValue BRUSH_SMALL_TOP;
  public static IntValue BRUSH_LARGE_BOTTOM;
  public static IntValue BRUSH_LARGE_TOP;
  public static IntValue BONE_SMALL_COUNT;
  public static IntValue BONE_SMALL_BOTTOM;
  public static IntValue BONE_SMALL_TOP;
  public static IntValue BONE_LARGE_BOTTOM;
  public static IntValue BONE_LARGE_TOP;
  public static IntValue TRASH_SMALL_COUNT;
  public static IntValue TRASH_SMALL_BOTTOM;
  public static IntValue TRASH_SMALL_TOP;
  public static IntValue TRASH_LARGE_BOTTOM;
  public static IntValue TRASH_LARGE_TOP;
  static {
    initConfig();
  }

  private static void initConfig() {
    CFG.comment("General settings").push(ScrapModMain.MODID);
    WORLDGEN_ENABLED = CFG.comment("Run worldgen from this mod in biome loader event").define("worldgen.enabled", true);
    //
    BONE_SMALL_COUNT = CFG.comment("Increase the count of these single spawns").defineInRange("worldgen.bone.small.count", 6, 1, 64);
    BONE_SMALL_BOTTOM = CFG.comment("Lowest point to generate this").defineInRange("worldgen.bone.small.bottom", -40, -9999, 9999);
    BONE_SMALL_TOP = CFG.comment("Highest point to generate this").defineInRange("worldgen.bone.small.top", 50, -9999, 9999);
    BONE_LARGE_BOTTOM = CFG.comment("Lowest point to generate this").defineInRange("worldgen.bone.large.bottom", -40, -9999, 9999);
    BONE_LARGE_TOP = CFG.comment("Highest point to generate this").defineInRange("worldgen.bone.large.top", 50, -9999, 9999);
    METAL_SMALL_COUNT = CFG.comment("Increase the count of these single spawns").defineInRange("worldgen.metal.small.count", 6, 1, 64);
    METAL_SMALL_BOTTOM = CFG.comment("Lowest point to generate this").defineInRange("worldgen.metal.small.bottom", -40, -9999, 9999);
    METAL_SMALL_TOP = CFG.comment("Highest point to generate this").defineInRange("worldgen.metal.small.top", 50, -9999, 9999);
    METAL_LARGE_BOTTOM = CFG.comment("Lowest point to generate this").defineInRange("worldgen.metal.large.bottom", -40, -9999, 9999);
    METAL_LARGE_TOP = CFG.comment("Highest point to generate this").defineInRange("worldgen.metal.large.top", 40, -9999, 9999);
    BRUSH_SMALL_COUNT = CFG.comment("Increase the count of these single spawns").defineInRange("worldgen.brush.small.count", 6, 1, 64);
    BRUSH_SMALL_BOTTOM = CFG.comment("Lowest point to generate this").defineInRange("worldgen.brush.small.bottom", 50, -9999, 9999);
    BRUSH_SMALL_TOP = CFG.comment("Highest point to generate this").defineInRange("worldgen.brush.small.top", 222, -9999, 9999);
    BRUSH_LARGE_BOTTOM = CFG.comment("Lowest point to generate this").defineInRange("worldgen.brush.large.bottom", 50, -9999, 9999);
    BRUSH_LARGE_TOP = CFG.comment("Highest point to generate this").defineInRange("worldgen.brush.large.top", 222, -9999, 9999);
    TRASH_SMALL_COUNT = CFG.comment("Increase the count of these single spawns").defineInRange("worldgen.trash.small.count", 6, 1, 64);
    TRASH_SMALL_BOTTOM = CFG.comment("Lowest point to generate this").defineInRange("worldgen.trash.small.bottom", -40, -9999, 9999);
    TRASH_SMALL_TOP = CFG.comment("Highest point to generate this").defineInRange("worldgen.trash.small.top", 222, -9999, 9999);
    TRASH_LARGE_BOTTOM = CFG.comment("Lowest point to generate this").defineInRange("worldgen.trash.large.bottom", -40, -9999, 9999);
    TRASH_LARGE_TOP = CFG.comment("Highest point to generate this").defineInRange("worldgen.trash.large.top", 222, -9999, 9999);
    //
    STEPHARVEST_ENABLED = CFG.comment("If true then stepping on a scrap pile will harvest it").define("steptobreak.enabled", true);
    CFG.pop(); // one pop for every push
    COMMON_CONFIG = CFG.build();
  }

  public static void setup() {
    final CommentedFileConfig configData = CommentedFileConfig.builder(FMLPaths.CONFIGDIR.get().resolve(ScrapModMain.MODID + ".toml"))
        .sync()
        .autosave()
        .writingMode(WritingMode.REPLACE)
        .build();
    configData.load();
    COMMON_CONFIG.setConfig(configData);
  }
}
