package com.lothrazar.scraps.world;

import com.lothrazar.scraps.ScrapModMain;
import com.lothrazar.scraps.content.ScrapConfig;
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
    if (!ScrapConfig.WORLDGEN_ENABLED.get()) {
      return;
    }
    BiomeGenerationSettingsBuilder builder = event.getGeneration();
    BiomeCategory cat = event.getCategory();
    boolean isNether = cat == Biome.BiomeCategory.NETHER;
    boolean isEnd = cat == Biome.BiomeCategory.THEEND;
    boolean assumeOverworld = !isNether && !isEnd;
    if (assumeOverworld) {
      //overworld-like  
      builder.addFeature(Decoration.VEGETAL_DECORATION, ScrapGenPlacements.BONE_SMALL);
      builder.addFeature(Decoration.VEGETAL_DECORATION, ScrapGenPlacements.BRUSH_SMALL);
      builder.addFeature(Decoration.VEGETAL_DECORATION, ScrapGenPlacements.TRASH_SMALL);
      builder.addFeature(Decoration.VEGETAL_DECORATION, ScrapGenPlacements.METAL_SMALL);
      builder.addFeature(Decoration.VEGETAL_DECORATION, ScrapGenPlacements.BONE_LARGE);
      builder.addFeature(Decoration.VEGETAL_DECORATION, ScrapGenPlacements.BRUSH_LARGE);
      builder.addFeature(Decoration.VEGETAL_DECORATION, ScrapGenPlacements.TRASH_LARGE);
      builder.addFeature(Decoration.VEGETAL_DECORATION, ScrapGenPlacements.METAL_LARGE);
    }
  }
}
