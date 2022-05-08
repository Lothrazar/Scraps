package com.lothrazar.scraps.content;

import java.util.List;
import com.lothrazar.scraps.ScrapModMain;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ScrapWorldgen {

  public static void init() {
    //Just here to load the class and let the features be initialized and registered
  }

  //  public static List<PlacementModifier> PLACE_SURFACE = List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
  public static List<PlacementModifier> PLACE_CAVE = List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
  public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> SCRAPS = FeatureUtils.register("scraps",
      Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder()
          .add(ScrapModRegistry.SCRAP_TRASH.get().defaultBlockState(), 4)
          .add(ScrapModRegistry.SCRAP_TRASH.get().defaultBlockState(), 7)
          .add(ScrapModRegistry.SCRAP_METAL.get().defaultBlockState(), 25)
          .add(ScrapModRegistry.SCRAP_TRASH.get().defaultBlockState(), 50)
          .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 10))));
  public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> PATCH = FeatureUtils.register("patch", Feature.VEGETATION_PATCH,
      new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, BlockStateProvider.simple(Blocks.MOSS_BLOCK),
          PlacementUtils.inlinePlaced(SCRAPS), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F));
  public static Holder<PlacedFeature> PATCH_CAVE = PlacementUtils.register(new ResourceLocation(ScrapModMain.MODID, "patch_cave").toString(), PATCH, PLACE_CAVE);
  //
  //
  //  public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> JUNK_AIR = FeatureUtils.register(new ResourceLocation(ScrapModMain.MODID, "junk").toString(),
  //      Feature.RANDOM_PATCH, new RandomPatchConfiguration(128, 0, 0, PlacementUtils.filtered(Feature.SIMPLE_BLOCK,
  //          new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder()
  //              .add(ScrapModRegistry.SCRAP_TRASH.get().defaultBlockState(), 10)
  //              .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 7)
  //              //              .add(ScrapModRegistry.SCRAP_FOOD.get().defaultBlockState(), 5)
  //              .add(ScrapModRegistry.SCRAP_METAL.get().defaultBlockState(), 1))),
  //          BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.not(
  //              BlockPredicate.matchesBlocks(ImmutableList.of(Blocks.ICE, Blocks.SAND, Blocks.RED_SAND, Blocks.WATER, Blocks.LAVA),
  //                  new BlockPos(0, -1, 0)))))));
  //  public static Holder<PlacedFeature> SCRAP_SURFACE_FEATURE = PlacementUtils.register(new ResourceLocation(ScrapModMain.MODID, "scrap_surface").toString(), JUNK_AIR, PLACE_SURFACE);
  //  public static Holder<PlacedFeature> SCRAP_CAVE_FEATURE = PlacementUtils.register(new ResourceLocation(ScrapModMain.MODID, "scrap_cave").toString(), JUNK_AIR, PLACE_CAVE);
}