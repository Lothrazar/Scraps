package com.lothrazar.scraps.world;

import com.lothrazar.scraps.content.ScrapModRegistry;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ScrapGenFeatures {

  //patches
  public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> METAL_PATCH = FeatureUtils.register("metal_patch", Feature.RANDOM_PATCH,
      FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_METAL.get()))));
  public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BRUSH_PATCH = FeatureUtils.register("brush_patch", Feature.RANDOM_PATCH,
      FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_BRUSH.get()))));
  public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BONES_PATCH = FeatureUtils.register("bones_patch", Feature.RANDOM_PATCH,
      FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_BONES.get()))));
  public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TRASH_PATCH = FeatureUtils.register("trash_patch", Feature.RANDOM_PATCH,
      FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_TRASH.get()))));
  //
  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> METAL_SIMPLE = FeatureUtils.register("metal_simple", Feature.SIMPLE_BLOCK,
      new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_METAL.get())));
  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> BRUSH_SIMPLE = FeatureUtils.register("brush_simple", Feature.SIMPLE_BLOCK,
      new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_BRUSH.get())));
  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> BONES_SIMPLE = FeatureUtils.register("bones_simple", Feature.SIMPLE_BLOCK,
      new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_BONES.get())));
  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> TRASH_SIMPLE = FeatureUtils.register("trash_simple", Feature.SIMPLE_BLOCK,
      new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_TRASH.get())));
}
