package com.lothrazar.scraps.content;

import com.lothrazar.scraps.ScrapModMain;
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
    if (!ScrapsConfig.WORLDGEN_ENABLED.get()) {
      return;
    }
    BiomeGenerationSettingsBuilder builder = event.getGeneration();
    BiomeCategory cat = event.getCategory();
    if (cat != Biome.BiomeCategory.NETHER
        && cat != Biome.BiomeCategory.THEEND) {
      //overworld-like
      builder.addFeature(Decoration.TOP_LAYER_MODIFICATION, ScrapWorldgen.TRASH_PLACE);
      builder.addFeature(Decoration.TOP_LAYER_MODIFICATION, ScrapWorldgen.BRUSH_PLACE);
      builder.addFeature(Decoration.TOP_LAYER_MODIFICATION, ScrapWorldgen.BONES_PLACE);
      builder.addFeature(Decoration.TOP_LAYER_MODIFICATION, ScrapWorldgen.METAL_PLACE);
      //      builder.addFeature(Decoration.UNDERGROUND_DECORATION, ScrapWorldgen.SCRAP_CAVE_FEATURE);
    }
  }
}
