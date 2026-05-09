package com.lothrazar.scraps.content;

import com.lothrazar.library.item.ItemFlib;
import com.lothrazar.library.registry.RecipeCompostFactory;
import com.lothrazar.scraps.ScrapModMain;
import com.lothrazar.scraps.blocks.BlockGarbage;
import com.lothrazar.scraps.blocks.BlockScraps;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RegistryScrap {

  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ScrapModMain.MODID);
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ScrapModMain.MODID);
  public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ScrapModMain.MODID);


  public static final DeferredBlock<BlockGarbage> GARBAGE = BLOCKS.register("garbage", () -> new BlockGarbage(Block.Properties.of().mapColor(DyeColor.BROWN).strength(0.5F)));
  //junk is a small pile of stuff
  public static final DeferredBlock<BlockScraps> SCRAP_TRASH = BLOCKS.register("scrap_trash", () -> new BlockScraps(Block.Properties.of().instabreak()));
  public static final DeferredBlock<BlockScraps> SCRAP_BONES = BLOCKS.register("scrap_bones", () -> new BlockScraps(Block.Properties.of().instabreak()));
  public static final DeferredBlock<BlockScraps> SCRAP_METAL = BLOCKS.register("scrap_metal", () -> new BlockScraps(Block.Properties.of().instabreak()));
  public static final DeferredBlock<BlockScraps> SCRAP_BRUSH = BLOCKS.register("scrap_brush", () -> new BlockScraps(Block.Properties.of().instabreak()));

  static final DeferredItem<BlockItem> garbage = ITEMS.register("garbage", () -> new BlockItem(GARBAGE.get(), new Item.Properties()));
  static final DeferredItem<BlockItem> scrap_trash = ITEMS.register("scrap_trash", () -> new BlockItem(SCRAP_TRASH.get(), new Item.Properties()));
  static final DeferredItem<BlockItem> scrap_bones = ITEMS.register("scrap_bones", () -> new BlockItem(SCRAP_BONES.get(), new Item.Properties()));
  static final DeferredItem<BlockItem> scrap_metal = ITEMS.register("scrap_metal", () -> new BlockItem(SCRAP_METAL.get(), new Item.Properties()));
  static final DeferredItem<BlockItem> scrap_brush = ITEMS.register("scrap_brush", () -> new BlockItem(SCRAP_BRUSH.get(), new Item.Properties()));
  static final DeferredItem<ItemFlib> junk = ITEMS.register("junk", () -> new ItemFlib(new Item.Properties(), new ItemFlib.Settings().tooltip().burnTime(200)));

  public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = TABS.register("tab", () ->
      CreativeModeTab.builder()
          .icon(() -> new ItemStack(GARBAGE.get()))
          .title(Component.translatable("itemGroup." + ScrapModMain.MODID))
          .displayItems((enabledFlags, populator) -> {
            for (var entry : ITEMS.getEntries()) {
              populator.accept(entry.get());
            }
          }).build());


  public static final DeferredItem<ItemShard> SHARD_BONE = ITEMS.register("shard_bone", () -> new ItemShard(new Item.Properties())); //comp
  public static final DeferredItem<ItemShard> SHARD_BRICK = ITEMS.register("shard_brick", () -> new ItemShard(new Item.Properties())); //hard
  public static final DeferredItem<ItemShard> SHARD_FLINT = ITEMS.register("shard_flint", () -> new ItemShard(new Item.Properties())); //hard
  public static final DeferredItem<ItemShard> SHARD_GLASS = ITEMS.register("shard_glass", () -> new ItemShard(new Item.Properties())); //hard
  public static final DeferredItem<ItemShard> SHARD_LEATHER = ITEMS.register("shard_leather", () -> new ItemShard(new Item.Properties())); //comp
  public static final DeferredItem<ItemShard> SHARD_PAPER = ITEMS.register("shard_paper", () -> new ItemShard(new Item.Properties())); //comp
  public static final DeferredItem<ItemShard> SHARD_WOOD = ITEMS.register("shard_wood", () -> new ItemShard(new Item.Properties())); //comp


  public static void composter() {
    if (ConfigRegistryScrap.COMPOSTER.get()) {
      final float f = RecipeCompostFactory.FillValues.LEAVES;
      RecipeCompostFactory.put(SHARD_BONE.get(), f);
      RecipeCompostFactory.put(SHARD_LEATHER.get(), f);
      RecipeCompostFactory.put(SHARD_PAPER.get(), f);
      RecipeCompostFactory.put(SHARD_WOOD.get(), f);
    }
    //NOT COMPOST: BRICK, FLINT, GLASS
  }
}
