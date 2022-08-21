package com.lothrazar.scraps.world;

import com.lothrazar.library.world.FeatureBuilder;
import com.lothrazar.scraps.content.ScrapModRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class ScrapGenFeatures {

  //patches
  public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> METAL_PATCH = FeatureBuilder.patch("metal_patch", ScrapModRegistry.SCRAP_METAL.get());
  public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BRUSH_PATCH = FeatureBuilder.patch("brush_patch", ScrapModRegistry.SCRAP_BRUSH.get());
  public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BONES_PATCH = FeatureBuilder.patch("bones_patch", ScrapModRegistry.SCRAP_BONES.get());
  public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TRASH_PATCH = FeatureBuilder.patch("trash_patch", ScrapModRegistry.SCRAP_TRASH.get());
  //singletons 
  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> METAL_SIMPLE = FeatureBuilder.simple("metal_simple", ScrapModRegistry.SCRAP_METAL.get());
  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> BRUSH_SIMPLE = FeatureBuilder.simple("brush_simple", ScrapModRegistry.SCRAP_BRUSH.get());
  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> BONES_SIMPLE = FeatureBuilder.simple("bones_simple", ScrapModRegistry.SCRAP_BONES.get());
  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> TRASH_SIMPLE = FeatureBuilder.simple("trash_simple", ScrapModRegistry.SCRAP_TRASH.get());
}
