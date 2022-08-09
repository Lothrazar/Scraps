package com.lothrazar.scraps.world;

import com.lothrazar.scraps.ScrapConfig;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
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

  public static final Holder<PlacedFeature> METAL_SMALL = PlacementUtils.register("metal_small", ScrapGenFeatures.METAL_SIMPLE,
      CountPlacement.of(ScrapConfig.METAL_SMALL_COUNT.get()),
      InSquarePlacement.spread(),
      HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(ScrapConfig.METAL_SMALL_BOTTOM.get()), VerticalAnchor.belowTop(ScrapConfig.METAL_SMALL_TOP.get())),
      EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.hasSturdyFace(Direction.UP), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
      RandomOffsetPlacement.vertical(ConstantInt.of(1)),
      BiomeFilter.biome());
  public static final Holder<PlacedFeature> BONE_SMALL = PlacementUtils.register("bone_small", ScrapGenFeatures.BONES_SIMPLE,
      CountPlacement.of(ScrapConfig.BONE_SMALL_COUNT.get()),
      InSquarePlacement.spread(),
      HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(ScrapConfig.BONE_SMALL_BOTTOM.get()), VerticalAnchor.belowTop(ScrapConfig.BONE_SMALL_TOP.get())),
      EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.hasSturdyFace(Direction.UP), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
      RandomOffsetPlacement.vertical(ConstantInt.of(1)),
      BiomeFilter.biome());
  public static final Holder<PlacedFeature> TRASH_SMALL = PlacementUtils.register("trash_small", ScrapGenFeatures.TRASH_SIMPLE,
      CountPlacement.of(ScrapConfig.TRASH_SMALL_COUNT.get()),
      InSquarePlacement.spread(),
      HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(ScrapConfig.TRASH_SMALL_BOTTOM.get()), VerticalAnchor.belowTop(ScrapConfig.TRASH_SMALL_TOP.get())),
      EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.hasSturdyFace(Direction.UP), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
      RandomOffsetPlacement.vertical(ConstantInt.of(1)),
      BiomeFilter.biome());
  public static final Holder<PlacedFeature> BRUSH_SMALL = PlacementUtils.register("brush_small", ScrapGenFeatures.BRUSH_SIMPLE,
      CountPlacement.of(ScrapConfig.BRUSH_SMALL_COUNT.get()),
      InSquarePlacement.spread(),
      HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(ScrapConfig.BRUSH_SMALL_BOTTOM.get()), VerticalAnchor.belowTop(ScrapConfig.BRUSH_SMALL_TOP.get())),
      EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.hasSturdyFace(Direction.UP), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
      RandomOffsetPlacement.vertical(ConstantInt.of(1)),
      BiomeFilter.biome());
  //
  //
  //
  public static final Holder<PlacedFeature> METAL_LARGE = PlacementUtils.register("metal_large", ScrapGenFeatures.METAL_PATCH,
      //      CountPlacement.of(8),
      InSquarePlacement.spread(),
      HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(ScrapConfig.METAL_LARGE_BOTTOM.get()), VerticalAnchor.belowTop(ScrapConfig.METAL_LARGE_TOP.get())),
      EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.hasSturdyFace(Direction.UP), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
      RandomOffsetPlacement.vertical(ConstantInt.of(1)),
      BiomeFilter.biome());
  public static final Holder<PlacedFeature> BONE_LARGE = PlacementUtils.register("bone_large", ScrapGenFeatures.BONES_PATCH,
      //      CountPlacement.of(8),
      InSquarePlacement.spread(),
      HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(ScrapConfig.BONE_LARGE_BOTTOM.get()), VerticalAnchor.belowTop(ScrapConfig.BONE_LARGE_TOP.get())),
      EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.hasSturdyFace(Direction.UP), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
      RandomOffsetPlacement.vertical(ConstantInt.of(1)),
      BiomeFilter.biome());
  public static final Holder<PlacedFeature> TRASH_LARGE = PlacementUtils.register("trash_large", ScrapGenFeatures.TRASH_PATCH,
      //      CountPlacement.of(8),
      InSquarePlacement.spread(),
      HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(ScrapConfig.TRASH_LARGE_BOTTOM.get()), VerticalAnchor.belowTop(ScrapConfig.TRASH_LARGE_TOP.get())),
      EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.hasSturdyFace(Direction.UP), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
      RandomOffsetPlacement.vertical(ConstantInt.of(1)),
      BiomeFilter.biome());
  public static final Holder<PlacedFeature> BRUSH_LARGE = PlacementUtils.register("brush_large", ScrapGenFeatures.BRUSH_PATCH,
      //      CountPlacement.of(8),
      InSquarePlacement.spread(),
      HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(ScrapConfig.BRUSH_LARGE_BOTTOM.get()), VerticalAnchor.belowTop(ScrapConfig.BRUSH_LARGE_TOP.get())),
      EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.hasSturdyFace(Direction.UP), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
      RandomOffsetPlacement.vertical(ConstantInt.of(1)),
      BiomeFilter.biome());
}
