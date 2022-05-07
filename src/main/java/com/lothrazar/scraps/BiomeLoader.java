package com.lothrazar.scraps;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = ScrapModMain.MODID, bus = EventBusSubscriber.Bus.FORGE)
public class BiomeLoader {

  @SubscribeEvent(priority = EventPriority.HIGH)
  public static void biomeLoadingEvent(BiomeLoadingEvent event) {
    BiomeGenerationSettingsBuilder builder = event.getGeneration();
    BiomeCategory cat = event.getCategory();
    if (cat != Biome.BiomeCategory.NETHER
        && cat != Biome.BiomeCategory.THEEND
        && cat != Biome.BiomeCategory.BEACH
        && cat != Biome.BiomeCategory.DESERT
        && cat != Biome.BiomeCategory.MESA
        && cat != Biome.BiomeCategory.ICY
        && cat != Biome.BiomeCategory.OCEAN) {
      builder.addFeature(Decoration.TOP_LAYER_MODIFICATION, ScrapWorldgen.JUNK_PLACED_FEATURE);
    }
  }
}
