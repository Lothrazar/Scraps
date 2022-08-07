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
  public static IntValue METAL_SMALL_BOTTOM;
  public static IntValue METAL_SMALL_TOP;
  public static IntValue BRUSH_LARGE_BOTTOM;
  public static IntValue BRUSH_LARGE_TOP;
  public static IntValue BONE_SMALL_BOTTOM;
  public static IntValue BONE_SMALL_TOP;
  static {
    initConfig();
  }

  private static void initConfig() {
    CFG.comment("General settings").push(ScrapModMain.MODID);
    WORLDGEN_ENABLED = CFG.comment("Run worldgen from this mod in biome loader event").define("worldgen.enabled", true);
    BONE_SMALL_BOTTOM = CFG.comment("Lowest point to generate this").defineInRange("worldgen.bone_small.bottom", -40, -9999, 9999);
    BONE_SMALL_TOP = CFG.comment("Highest point to generate this").defineInRange("worldgen.bone_small.top", 222, -9999, 9999);
    METAL_SMALL_BOTTOM = CFG.comment("Lowest point to generate this").defineInRange("worldgen.metal_small.bottom", -40, -9999, 9999);
    METAL_SMALL_TOP = CFG.comment("Highest point to generate this").defineInRange("worldgen.metal_small.top", 222, -9999, 9999);
    BRUSH_LARGE_BOTTOM = CFG.comment("Lowest point to generate this").defineInRange("worldgen.brush_large.bottom", -40, -9999, 9999);
    BRUSH_LARGE_TOP = CFG.comment("Highest point to generate this").defineInRange("worldgen.brush_large.top", 222, -9999, 9999);
    STEPHARVEST_ENABLED = CFG.comment("If true then stepping on a scrap pile will harvest it").define("steptobreak.enabled", true);
    //TODO on contact auto break config?
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
