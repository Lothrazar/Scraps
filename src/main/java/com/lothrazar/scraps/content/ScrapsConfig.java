package com.lothrazar.scraps.content;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.lothrazar.scraps.ScrapModMain;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.fml.loading.FMLPaths;

public class ScrapsConfig {

  private static final ForgeConfigSpec.Builder CFG = new ForgeConfigSpec.Builder();
  private static ForgeConfigSpec COMMON_CONFIG;
  public static BooleanValue WORLDGEN_ENABLED;
  static {
    initConfig();
  }

  private static void initConfig() {
    CFG.comment("General settings").push(ScrapModMain.MODID);
    WORLDGEN_ENABLED = CFG.comment("Run worldgen from this mod in biome loader event").define("worldgen.enabled", true);
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
