package com.lothrazar.scraps.world;

import com.lothrazar.scraps.content.ScrapModRegistry;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ScrapGenFeatures {

  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> buildFlower(String location, SimpleBlockConfiguration oc) {
    return FeatureUtils.register(location, Feature.SIMPLE_BLOCK, oc);
  }
  //  ScrapModMain.MODID + ":" + 
  //  PlacementUtils test;

  //
  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> METAL_SIMPLE = buildFlower("metal_simple",
      new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_METAL.get())));
  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> BRUSH_SIMPLE = buildFlower("brush_simple",
      new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_BRUSH.get())));
  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> BONES_SIMPLE = buildFlower("bones_simple",
      new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_BONES.get())));
  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> TRASH_SIMPLE = buildFlower("trash_simple",
      new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_TRASH.get())));
}
