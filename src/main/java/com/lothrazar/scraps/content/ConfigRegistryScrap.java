package com.lothrazar.scraps.content;

import com.lothrazar.scraps.ScrapModMain;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigRegistryScrap {

  private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
  public static final ModConfigSpec.BooleanValue COMPOSTER;
  public static final ModConfigSpec.BooleanValue STEPHARVEST_ENABLED;
  public static final ModConfigSpec CONFIG;

  static {
    BUILDER.comment("General settings").push(ScrapModMain.MODID);
    //
    COMPOSTER = BUILDER.comment("If true then some of the scraps will be allowed to go into the minecraft:composter block (shard_bone, shard_leather, shard_paper, shard_wood only)").define("composter.enabled", true);
    STEPHARVEST_ENABLED = BUILDER.comment("If true then stepping on a scrap pile will harvest it").define("steptobreak.enabled", true);
    BUILDER.pop(); // one pop for every push
    CONFIG = BUILDER.build();
  }

  public ConfigRegistryScrap(ModContainer modContainer) {
    modContainer.registerConfig(ModConfig.Type.COMMON, CONFIG);
  }
}
