package com.lothrazar.scraps.blocks.salvager;

import java.util.List;
import com.lothrazar.scraps.content.ScrapModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileSalvager extends BlockEntity implements Container {

  //  private static final int MULT_OF_MAX_STAGE_BREAKSTUFF = 4;
  public static final String NBTINV = "inv";
  ItemStackHandler inputSlots = new ItemStackHandler(1);
  ItemStackHandler outputSlots = new ItemStackHandler(4);
  private ItemStackHandlerWrapper inventory = new ItemStackHandlerWrapper(inputSlots, outputSlots);
  private LazyOptional<IItemHandler> inventoryCap = LazyOptional.of(() -> inventory);

  public TileSalvager(BlockPos pos, BlockState state) {
    super(null, pos, state); // ScrapModRegistry.T_SALVAGER.get() 
  }

  private void tick() {
    System.out.println("tick");
  }

  public boolean canProcessOre() {
    return !inputIsEmpty(); // timer? stage? energy?// stage == ConfigManager.MAX_STAGE.get();
  }

  public void setLitProperty(boolean lit) {
    BlockState st = this.getBlockState();
    if (!st.hasProperty(BlockSalvager.LIT)) {
      return;
    }
    boolean previous = st.getValue(BlockSalvager.LIT);
    if (previous != lit) {
      this.level.setBlockAndUpdate(worldPosition, st.setValue(BlockSalvager.LIT, lit));
    }
  }

  public void processFromOnHit() {
    //    stage = 0;
    RecipeSalvager currentRecipe = this.findMatchingRecipe();
    if (currentRecipe != null) {
      //
      //        this.burnTimeMax = this.currentRecipe.energy.getTicks();
      //        this.burnTime = this.burnTimeMax;
      //        this.inputSlots.extractItem(0, 1, false); 
      System.out.println("FFFFFFFFUCK output");
      this.inputSlots.extractItem(0, currentRecipe.ingredientCount, false);
      this.outputSlots.insertItem(0, currentRecipe.getResultItem(), false);
    }
  }
  //  private boolean tryProcessRecipe(RecipeSalvager currentRecipe) {
  //    // ok so do the thing
  //    ItemStack result = currentRecipe.assemble(this);
  //    //does it match? does it fit into the output slot 
  //    //insert in simulate mode. does it fit?
  //    if (this.outputSlots.insertItem(0, result, true).isEmpty()) {
  //      return true;
  //    }
  //    return false;
  //  }

  private RecipeSalvager findMatchingRecipe() {
    List<RecipeSalvager> recipes = level.getRecipeManager().getAllRecipesFor(ScrapModRegistry.RECIPE.get());
    for (RecipeSalvager rec : recipes) {
      if (rec.matches(this, level)) {
        System.out.println(rec + "FOUND recipe among list " + recipes.size());
        return rec;
      }
    }
    return null;
  }

  @Override
  public void load(CompoundTag tag) {
    inventory.deserializeNBT(tag.getCompound(NBTINV));
    super.load(tag);
  }

  @Override
  public void saveAdditional(CompoundTag tag) {
    super.saveAdditional(tag);
    tag.put(NBTINV, inventory.serializeNBT());
  }

  @Override
  public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
    if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY
    //        && ConfigManager.AUTOMATION_ALLOWED.get()
    ) {
      return inventoryCap.cast();
    }
    return super.getCapability(cap, side);
  }

  private boolean inputIsEmpty() {
    return this.inputSlots.getStackInSlot(0).isEmpty();
  }

  public static void clientTick(Level level, BlockPos blockPos, BlockState blockState, TileSalvager tileGrinder) {}

  public static <E extends BlockEntity> void serverTick(Level level, BlockPos blockPos, BlockState blockState, TileSalvager tile) {
    tile.tick();
  }

  /******** Fakeout stuff for IRecipe *********************/
  @Override
  public void clearContent() {
    // TODO Auto-generated method stub
  }

  @Override
  public ItemStack removeItem(int arg0, int arg1) {
    return ItemStack.EMPTY;
  }

  @Override
  public int getContainerSize() {
    return 0;
  }

  @Override
  public ItemStack getItem(int arg0) {
    return ItemStack.EMPTY;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean stillValid(Player arg0) {
    return true;
  }

  @Override
  public ItemStack removeItemNoUpdate(int arg0) {
    return ItemStack.EMPTY;
  }

  @Override
  public void setItem(int arg0, ItemStack arg1) {}
}