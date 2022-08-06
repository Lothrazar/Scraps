package com.lothrazar.scraps.world;

import com.lothrazar.scraps.ScrapModMain;
import com.lothrazar.scraps.content.ScrapModRegistry;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ScrapGenFeatures {

  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> buildFlower(String location, SimpleBlockConfiguration oc) {
    return FeatureUtils.register(ScrapModMain.MODID + ":" + location, Feature.SIMPLE_BLOCK, oc);
  }

  PlacementUtils test;
  //  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> bones_mid = buildFlower("bones_mid", // just like CaveFeatures.MOSS_VEGETATION
  //      new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder()
  //          .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 4)
  //          .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 8)
  //          .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 2)
  //      //
  //      )));
  //
  //
  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> METAL_SIMPLE = buildFlower("metal_simple",
      new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_METAL.get())));
  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> BRUSH_SIMPLE = buildFlower("brush_simple",
      new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_BRUSH.get())));
  //
  //
  //  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> brush_large = buildFlower("brush_large", // just like CaveFeatures.MOSS_VEGETATION
  //      new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder()
  //          .add(ScrapModRegistry.SCRAP_BRUSH.get().defaultBlockState(), 4)
  //          .add(ScrapModRegistry.SCRAP_BRUSH.get().defaultBlockState(), 8)
  //          .add(ScrapModRegistry.SCRAP_BRUSH.get().defaultBlockState(), 2)
  //      //
  //      )));
  //
  //instead of NOISE LEVEL try weighted?
  //  new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.FLOWERING_AZALEA.defaultBlockState(), 4).add(Blocks.AZALEA.defaultBlockState(), 7).add(Blocks.MOSS_CARPET.defaultBlockState(), 25).add(Blocks.GRASS.defaultBlockState(), 50).add(Blocks.TALL_GRASS.defaultBlockState(), 10)))); 
}
