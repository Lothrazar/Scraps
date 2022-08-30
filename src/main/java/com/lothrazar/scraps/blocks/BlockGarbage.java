package com.lothrazar.scraps.blocks;

import com.lothrazar.library.block.BlockFlib;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockGarbage extends BlockFlib {

  protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

  public BlockGarbage(Properties properties) {
    super(properties.noOcclusion().strength(0.5F).speedFactor(0.4F).sound(SoundType.SOUL_SAND), new BlockFlib.Settings().tooltip());
  }

  @Override
  @Deprecated
  public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
    return SHAPE;
  }

  @Override
  public VoxelShape getBlockSupportShape(BlockState state, BlockGetter level, BlockPos pos) {
    return Shapes.block();
  }

  @Override
  public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
    return false;
  }

  @Override
  public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
    return Shapes.block();
  }
}
