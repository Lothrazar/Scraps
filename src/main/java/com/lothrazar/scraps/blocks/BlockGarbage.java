package com.lothrazar.scraps.blocks;

import com.lothrazar.scraps.content.ScrapConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockGarbage extends Block {

  //just like carpet
  protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

  public BlockGarbage(Properties properties) {
    super(properties.strength(0.3F).requiresCorrectToolForDrops());
  }

  //empty to let you walk thru like grass
  @Override
  @Deprecated
  public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
    return SHAPE;
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
      //      worldIn.destroyBlock(pos, true);
      //
      //
      //
      //TODO: soul sand? flesh block?
    }
  }
}
