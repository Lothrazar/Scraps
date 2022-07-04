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
  //shared cave thing
  private static List<PlacementModifier> SHARED_CAVE = List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
  //
  //
  //
  private static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> BRUSH = FeatureUtils.register("brush",
      Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder()
          .add(ScrapModRegistry.SCRAP_BRUSH.get().defaultBlockState(), 4)
          //          .add(ScrapModRegistry.SCRAP_BRUSH.get().defaultBlockState(), 7)
          .add(ScrapModRegistry.SCRAP_BRUSH.get().defaultBlockState(), 1))));
  private static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> BRUSH_PATCH = FeatureUtils.register("brush_patch", Feature.VEGETATION_PATCH,
      new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, BlockStateProvider.simple(Blocks.GRASS_BLOCK),
          PlacementUtils.inlinePlaced(BRUSH), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F));
  public static Holder<PlacedFeature> BRUSH_PLACE = PlacementUtils.register(new ResourceLocation(ScrapModMain.MODID, "brush_place").toString(), BRUSH_PATCH, SHARED_CAVE);
  //
  //
  //
  private static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> BONES = FeatureUtils.register("bones",
      Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder()
          .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 4)
          //          .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 7)
          .add(ScrapModRegistry.SCRAP_BONES.get().defaultBlockState(), 1))));
  private static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> BONES_PATCH = FeatureUtils.register("bones_patch", Feature.VEGETATION_PATCH,
      new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, BlockStateProvider.simple(Blocks.STONE),
          PlacementUtils.inlinePlaced(BONES), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F));
  public static Holder<PlacedFeature> BONES_PLACE = PlacementUtils.register(new ResourceLocation(ScrapModMain.MODID, "bones_place").toString(), BONES_PATCH, SHARED_CAVE);
  //
  //
  //this feature has all of them
  private static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> TRASH = FeatureUtils.register("trash",
      Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder()
          .add(ScrapModRegistry.SCRAP_TRASH.get().defaultBlockState(), 4)
          //          .add(ScrapModRegistry.SCRAP_TRASH.get().defaultBlockState(), 7)
          .add(ScrapModRegistry.SCRAP_TRASH.get().defaultBlockState(), 1))));
  private static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> TRASH_PATCH = FeatureUtils.register("trash_patch", Feature.VEGETATION_PATCH,
      new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, BlockStateProvider.simple(Blocks.GRASS_BLOCK),
          PlacementUtils.inlinePlaced(TRASH), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F));
  public static Holder<PlacedFeature> TRASH_PLACE = PlacementUtils.register(new ResourceLocation(ScrapModMain.MODID, "trash_place").toString(), TRASH_PATCH, SHARED_CAVE);
  ///
  ///
  ///
  private static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> METAL = FeatureUtils.register("metal",
      Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder()
          .add(ScrapModRegistry.SCRAP_METAL.get().defaultBlockState(), 4)
          //          .add(ScrapModRegistry.SCRAP_METAL.get().defaultBlockState(), 7)
          .add(ScrapModRegistry.SCRAP_METAL.get().defaultBlockState(), 1))));
  private static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> METAL_PATCH = FeatureUtils.register("metal_patch", Feature.VEGETATION_PATCH,
      new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, BlockStateProvider.simple(Blocks.STONE),
          PlacementUtils.inlinePlaced(METAL), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F));
  public static Holder<PlacedFeature> METAL_PLACE = PlacementUtils.register(new ResourceLocation(ScrapModMain.MODID, "metal_place").toString(), METAL_PATCH, SHARED_CAVE);
  //
  //
  //now start another feature 
}
