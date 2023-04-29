package com.lothrazar.scraps.content;

import com.lothrazar.library.config.ConfigTemplate;
import com.lothrazar.scraps.ScrapModMain;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class ConfigRegistryScrap extends ConfigTemplate {

  private static final ForgeConfigSpec CONFIG;
  public static BooleanValue STEPHARVEST_ENABLED;
  public static BooleanValue COMPOSTER;
  static {
    final ForgeConfigSpec.Builder BUILDER = builder();
    BUILDER.comment("General settings").push(ScrapModMain.MODID);
    //
    COMPOSTER = BUILDER.comment("If true then some of the scraps will be allowed to go into the minecraft:composter block (shard_bone, shard_leather, shard_paper, shard_wood only)").define("composter.enabled", true);
    STEPHARVEST_ENABLED = BUILDER.comment("If true then stepping on a scrap pile will harvest it").define("steptobreak.enabled", true);
    BUILDER.pop(); // one pop for every push
    CONFIG = BUILDER.build();
  }

  public ConfigRegistryScrap() {
    CONFIG.setConfig(setup(ScrapModMain.MODID));
  }
}
