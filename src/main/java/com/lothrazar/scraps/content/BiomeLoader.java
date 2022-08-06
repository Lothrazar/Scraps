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
    boolean isNether = cat == Biome.BiomeCategory.NETHER;
    boolean isEnd = cat == Biome.BiomeCategory.THEEND;
    boolean assumeOverworld = !isNether && !isEnd;
    if (assumeOverworld) {
      //overworld-like  
      System.out.println("FFFF" + cat);
      builder.addFeature(Decoration.VEGETAL_DECORATION, ScrapGenPlacements.PF_SCRAP_TEST);
      //      builder.addFeature(Decoration.TOP_LAYER_MODIFICATION, ScrapGenPlacements.PF_SCRAP_BONES);
    }
  }
}
