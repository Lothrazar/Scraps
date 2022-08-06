package com.lothrazar.scraps.content;

import java.util.List;
import com.lothrazar.scraps.ScrapModMain;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class ScrapGenPlacements {

  public static void init() {
    //Just here to load the class and let the features be initialized and registered
  }

  private static Holder<PlacedFeature> genPlaced(String id, Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> feature, List<PlacementModifier> placementModifiers) {
    return PlacementUtils.register(ScrapModMain.MODID + ":" + id, feature, placementModifiers);
  }

  CavePlacements wtf;
  CaveFeatures aaaaaaah;
  //
  //          NoiseThresholdCountPlacement.of(NOISELEVEL, NOISEABOVE, NOISEBELOW),
  //          RarityFilter.onAverageOnceEvery(2),
  //          HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(40), VerticalAnchor.belowTop(120)), //configs
  public static final Holder<PlacedFeature> PF_SCRAP_TEST = genPlaced("scrap_metal", ScrapGenFeatures.SCRAP_TEST,
      //
      List.of(
          CountPlacement.of(256),
          InSquarePlacement.spread(),
          HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-50), VerticalAnchor.belowTop(222)),
          EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
          BiomeFilter.biome())
  //
  );
  //
  //
  //
  //  public static final Holder<PlacedFeature> PF_SCRAP_BONES = genPlaced("scrap_bones", ScrapGenFeatures.SCRAP_BONES,
  //      List.of(NoiseThresholdCountPlacement.of(NOISELEVEL, NOISEABOVE, NOISEBELOW),
  //          RarityFilter.onAverageOnceEvery(RARITY), InSquarePlacement.spread(),
  //          HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(55), VerticalAnchor.belowTop(111)), BiomeFilter.biome()));
  //
  //  public static List<PlacementModifier> PLACE_SURFACE = List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
  //shared cave thing
  //  private static List<PlacementModifier> SHARED_CAVE = List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
  //
  //
  //
  //  private static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> BRUSH = FeatureUtils.register("brush",
  //      Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder()
  //          .add(ScrapModRegistry.SCRAP_BRUSH.get().defaultBlockState(), 4)
  //          //          .add(ScrapModRegistry.SCRAP_BRUSH.get().defaultBlockState(), 7)
  //          .add(ScrapModRegistry.SCRAP_BRUSH.get().defaultBlockState(), 1))));
  //  private static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> BRUSH_PATCH = FeatureUtils.register("brush_patch", Feature.VEGETATION_PATCH,
  //      new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, BlockStateProvider.simple(Blocks.GRASS_BLOCK),
  //          PlacementUtils.inlinePlaced(BRUSH), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F));
  //  public static Holder<PlacedFeature> BRUSH_PLACE = PlacementUtils.register(new ResourceLocation(ScrapModMain.MODID, "brush_place").toString(), BRUSH_PATCH, SHARED_CAVE);
  //  //
  //
  //
  //  private static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> BONES = FeatureUtils.register("bones",
  //      Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder()
  //          .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 4)
  //          .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 7)
  //          .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 9)
  //          .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 1))));
  //  //
  //  public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_RED_MUSHROOM =
  //      //
  //      FeatureUtils.register("patch_red_mushroom", Feature.RANDOM_PATCH,
  //          //
  //          FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.RED_MUSHROOM))));
  //  public static final BlockPredicateFilter SOLID = BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.wouldSurvive(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), BlockPos.ZERO)));
  //  ////
  //  public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_RED_MUSHROOM = FeatureUtils.register("bones", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
  //      new SimpleBlockConfiguration(BlockStateProvider.simple(ScrapModRegistry.SCRAP_BONES.get()))));
  //  //
  //  //
  //  public static final Holder<PlacedFeature> TWISTING_VINES = PlacementUtils.register("twisting_vines", PATCH_RED_MUSHROOM, CountPlacement.of(10),
  //      InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome(), SOLID);
  //  //
  //  //
  //  //
  //  public static final Holder<PlacedFeature> FFFFFFF = PlacementUtils.register("red_mushroom_nether", PATCH_RED_MUSHROOM,
  //      RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
  //
  //  public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_CRIMSON_ROOTS = FeatureUtils.register("patch_crimson_roots", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.CRIMSON_ROOTS))));
  //  public static final Holder<PlacedFeature> BONES_PLACE = PlacementUtils.register(new ResourceLocation(ScrapModMain.MODID, "bones_place").toString(), BONES_PATCH, SHARED_CAVE);
  //
  //
  //this feature has all of them
  //  private static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> TRASH = FeatureUtils.register("trash",
  //      Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder()
  //          .add(ScrapModRegistry.SCRAP_TRASH.get().defaultBlockState(), 4)
  //          //          .add(ScrapModRegistry.SCRAP_TRASH.get().defaultBlockState(), 7)
  //          .add(ScrapModRegistry.SCRAP_TRASH.get().defaultBlockState(), 1))));
  //  private static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> TRASH_PATCH = FeatureUtils.register("trash_patch", Feature.VEGETATION_PATCH,
  //      new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, BlockStateProvider.simple(Blocks.GRASS_BLOCK),
  //          PlacementUtils.inlinePlaced(TRASH), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F));
  //  public static Holder<PlacedFeature> TRASH_PLACE = PlacementUtils.register(new ResourceLocation(ScrapModMain.MODID, "trash_place").toString(), TRASH_PATCH, SHARED_CAVE);
  //  ///
  //  ///
  //  ///
  //  private static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> METAL = FeatureUtils.register("metal",
  //      Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder()
  //          .add(ScrapModRegistry.SCRAP_METAL.get().defaultBlockState(), 4)
  //          //          .add(ScrapModRegistry.SCRAP_METAL.get().defaultBlockState(), 7)
  //          .add(ScrapModRegistry.SCRAP_METAL.get().defaultBlockState(), 1))));
  //  private static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> METAL_PATCH = FeatureUtils.register("metal_patch", Feature.VEGETATION_PATCH,
  //      new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, BlockStateProvider.simple(Blocks.STONE),
  //          PlacementUtils.inlinePlaced(METAL), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F));
  //  public static Holder<PlacedFeature> METAL_PLACE = PlacementUtils.register(new ResourceLocation(ScrapModMain.MODID, "metal_place").toString(), METAL_PATCH, SHARED_CAVE);
  //
  //
  //now start another feature 
}
