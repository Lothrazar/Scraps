package com.lothrazar.scraps;

import java.util.List;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ScrapWorldgen {

  public static void init() {
    //Just here to load the class and let the features be initialized and registered
  }

  public static List<PlacementModifier> PLACE_SURFACE = List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
  //
  //
  public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> JUNK_FEATURE = FeatureUtils.register(new ResourceLocation(ScrapModMain.MODID, "junk").toString(),
      Feature.RANDOM_PATCH, new RandomPatchConfiguration(128, 0, 0, PlacementUtils.filtered(Feature.SIMPLE_BLOCK,
          new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder()
              .add(ScrapModRegistry.SCRAP_TRASH.get().defaultBlockState(), 10)
              .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 7)
              .add(ScrapModRegistry.SCRAP_FOOD.get().defaultBlockState(), 5)
              .add(ScrapModRegistry.SCRAP_METAL.get().defaultBlockState(), 1))),
          BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.not(
              BlockPredicate.matchesBlocks(ImmutableList.of(Blocks.ICE, Blocks.SAND, Blocks.RED_SAND, Blocks.WATER, Blocks.LAVA),
                  new BlockPos(0, -1, 0)))))));
  public static Holder<PlacedFeature> JUNK_PLACED_FEATURE = PlacementUtils.register(new ResourceLocation(ScrapModMain.MODID, "junk").toString(), JUNK_FEATURE, PLACE_SURFACE);
}
