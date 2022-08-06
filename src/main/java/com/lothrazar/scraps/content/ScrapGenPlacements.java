package com.lothrazar.scraps.content;

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
  public static final Holder<PlacedFeature> PF_SCRAP_TEST = PlacementUtils.register("scrap_test", ScrapGenFeatures.SCRAP_TEST,
      //
      //      List.of(
      CountPlacement.of(256),
      InSquarePlacement.spread(),
      HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-50), VerticalAnchor.belowTop(222)),
      EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.hasSturdyFace(Direction.UP), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
      BiomeFilter.biome()
  //
  );
  public static final Holder<PlacedFeature> SCRAP_SINGLE = PlacementUtils.register("scrap_single", ScrapGenFeatures.SCRAP_single,
      // list starts here
      CountPlacement.of(25), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
      EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
      RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
      BiomeFilter.biome());
}
