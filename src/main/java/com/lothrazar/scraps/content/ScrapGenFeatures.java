package com.lothrazar.scraps.content;

import com.lothrazar.scraps.ScrapModMain;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class ScrapGenFeatures {

  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> buildFlower(String location, SimpleBlockConfiguration oc) {
    return FeatureUtils.register(ScrapModMain.MODID + ":" + location, Feature.SIMPLE_BLOCK, oc);
  }

  public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> SCRAP_TEST = buildFlower("scrap_bones",
      new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder()
          .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 4)
          .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 8)
          .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 2)
      //
      )));
  //instead of NOISE LEVEL try weighted?
  //  new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.FLOWERING_AZALEA.defaultBlockState(), 4).add(Blocks.AZALEA.defaultBlockState(), 7).add(Blocks.MOSS_CARPET.defaultBlockState(), 25).add(Blocks.GRASS.defaultBlockState(), 50).add(Blocks.TALL_GRASS.defaultBlockState(), 10)))); 
}
