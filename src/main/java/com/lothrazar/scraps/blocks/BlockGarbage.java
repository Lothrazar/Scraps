package com.lothrazar.scraps.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockGarbage extends Block {

  //just like  SoulSandBlock y;
  protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

  public BlockGarbage(Properties properties) {
    super(properties.strength(0.3F)
        //        .requiresCorrectToolForDrops()
        .noOcclusion().strength(0.5F).speedFactor(0.4F).sound(SoundType.SOUL_SAND));
  }

  //empty to let you walk thru like grass
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
