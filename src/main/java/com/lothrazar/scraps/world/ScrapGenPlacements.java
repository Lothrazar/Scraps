package com.lothrazar.scraps.world;

import com.lothrazar.scraps.ScrapConfig;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;

public class ScrapGenPlacements {

  private static final int LARGE = 120;
  private static final int SMALL = 20;

  public static void init() {
    //Just here to load the class and let the features be initialized and registered
  }

  //  ScrapModMain.MODID + ":" +
  CavePlacements wtf;
  CaveFeatures aaaaaaah;
  //
  //          NoiseThresholdCountPlacement.of(NOISELEVEL, NOISEABOVE, NOISEBELOW),
  //          RarityFilter.onAverageOnceEvery(2),
  //          HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(40), VerticalAnchor.belowTop(120)), //configs
  //
  public static final Holder<PlacedFeature> METAL_SMALL = PlacementUtils.register("metal_small", ScrapGenFeatures.METAL_SIMPLE,
      CountPlacement.of(SMALL),
      InSquarePlacement.spread(),
      HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(ScrapConfig.METAL_SMALL_BOTTOM.get()), VerticalAnchor.belowTop(ScrapConfig.METAL_SMALL_TOP.get())),
      EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.hasSturdyFace(Direction.UP), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
      RandomOffsetPlacement.vertical(ConstantInt.of(1)),
      BiomeFilter.biome());
  //
  public static final Holder<PlacedFeature> BONE_SMALL = PlacementUtils.register("bone_small", ScrapGenFeatures.BONES_SIMPLE,
      CountPlacement.of(SMALL),
      InSquarePlacement.spread(),
      HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(ScrapConfig.BONE_SMALL_BOTTOM.get()), VerticalAnchor.belowTop(ScrapConfig.BONE_SMALL_TOP.get())),
      EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.hasSturdyFace(Direction.UP), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
      RandomOffsetPlacement.vertical(ConstantInt.of(1)),
      BiomeFilter.biome());
  //
  //
  //
  //
  public static final Holder<PlacedFeature> BRUSH_LARGE = PlacementUtils.register("brush_large", ScrapGenFeatures.BRUSH_SIMPLE,
      CountPlacement.of(LARGE),
      InSquarePlacement.spread(),
      HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(ScrapConfig.BRUSH_LARGE_BOTTOM.get()), VerticalAnchor.belowTop(ScrapConfig.BRUSH_LARGE_TOP.get())),
      EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.hasSturdyFace(Direction.UP), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
      RandomOffsetPlacement.vertical(ConstantInt.of(1)),
      BiomeFilter.biome());
  //
  //
  //  public static final Holder<PlacedFeature> SCRAP_SINGLE = PlacementUtils.register("scrap_single", ScrapGenFeatures.SCRAP_single,
  //      // list starts here
  //      CountPlacement.of(256), 
  //      InSquarePlacement.spread(),
  //      PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
  //      EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
  //      RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
  //      BiomeFilter.biome());
}
