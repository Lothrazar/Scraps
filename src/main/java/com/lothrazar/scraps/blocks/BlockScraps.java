package com.lothrazar.scraps.blocks;

import com.lothrazar.scraps.content.ScrapConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockScraps extends Block {

  //just like carpet
  protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);

  public BlockScraps(Properties properties) {
    super(properties.strength(0.3F).noOcclusion());
  }

  //empty to let you walk thru like grass
  @Override
  @Deprecated
  public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
    return Shapes.empty();
  }

  //general shape including select box
  @Override
  public VoxelShape getShape(BlockState p_152917_, BlockGetter p_152918_, BlockPos p_152919_, CollisionContext p_152920_) {
    return SHAPE;
  }

  //if config says so, break block on contact
  @Override
  public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
    if (!worldIn.isClientSide && ScrapConfig.STEPHARVEST_ENABLED.get() && entityIn instanceof Player) {
      //
      worldIn.destroyBlock(pos, true);
    }
  }

  //make it break if no stuff below
  @Override
  public boolean canSurvive(BlockState bs, LevelReader level, BlockPos pos) {
    return level.getBlockState(pos.below()).getMaterial().isSolid();
  }

  //update when surrounding changes
  @SuppressWarnings("deprecation")
  @Override
  public BlockState updateShape(BlockState bs, Direction face, BlockState bsOp, LevelAccessor level, BlockPos pos, BlockPos posOther) {
    return !bs.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(bs, face, bsOp, level, pos, posOther);
  }
}
