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


  public static final DeferredBlock<BlockGarbage> GARBAGE = BLOCKS.registerBlock("garbage", props -> new BlockGarbage(props.mapColor(DyeColor.BROWN).strength(0.5F)));
  //junk is a small pile of stuff
  public static final DeferredBlock<BlockScraps> SCRAP_TRASH = BLOCKS.registerBlock("scrap_trash", props -> new BlockScraps(props.instabreak()));
  public static final DeferredBlock<BlockScraps> SCRAP_BONES = BLOCKS.registerBlock("scrap_bones", props -> new BlockScraps(props.instabreak()));
  public static final DeferredBlock<BlockScraps> SCRAP_METAL = BLOCKS.registerBlock("scrap_metal", props -> new BlockScraps(props.instabreak()));
  public static final DeferredBlock<BlockScraps> SCRAP_BRUSH = BLOCKS.registerBlock("scrap_brush", props -> new BlockScraps(props.instabreak()));

  static final DeferredItem<BlockItem> garbage = ITEMS.registerItem("garbage", props -> new BlockItem(GARBAGE.get(), props.useBlockDescriptionPrefix()));
  static final DeferredItem<BlockItem> scrap_trash = ITEMS.registerItem("scrap_trash", props -> new BlockItem(SCRAP_TRASH.get(), props.useBlockDescriptionPrefix()));
  static final DeferredItem<BlockItem> scrap_bones = ITEMS.registerItem("scrap_bones", props -> new BlockItem(SCRAP_BONES.get(), props.useBlockDescriptionPrefix()));
  static final DeferredItem<BlockItem> scrap_metal = ITEMS.registerItem("scrap_metal", props -> new BlockItem(SCRAP_METAL.get(), props.useBlockDescriptionPrefix()));
  static final DeferredItem<BlockItem> scrap_brush = ITEMS.registerItem("scrap_brush", props -> new BlockItem(SCRAP_BRUSH.get(), props.useBlockDescriptionPrefix()));
  static final DeferredItem<ItemFlib> junk = ITEMS.registerItem("junk", props -> new ItemFlib(props, new ItemFlib.Settings().tooltip().burnTime(200)));

  public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = TABS.register("tab", () ->
      CreativeModeTab.builder()
          .icon(() -> new ItemStack(GARBAGE.get()))
          .title(Component.translatable("itemGroup." + ScrapModMain.MODID))
          .displayItems((enabledFlags, populator) -> {
            for (var entry : ITEMS.getEntries()) {
              populator.accept(entry.get());
            }
          }).build());


  public static final DeferredItem<ItemShard> SHARD_BONE = ITEMS.registerItem("shard_bone", props -> new ItemShard(props)); //comp
  public static final DeferredItem<ItemShard> SHARD_BRICK = ITEMS.registerItem("shard_brick", props -> new ItemShard(props)); //hard
  public static final DeferredItem<ItemShard> SHARD_FLINT = ITEMS.registerItem("shard_flint", props -> new ItemShard(props)); //hard
  public static final DeferredItem<ItemShard> SHARD_GLASS = ITEMS.registerItem("shard_glass", props -> new ItemShard(props)); //hard
  public static final DeferredItem<ItemShard> SHARD_LEATHER = ITEMS.registerItem("shard_leather", props -> new ItemShard(props)); //comp
  public static final DeferredItem<ItemShard> SHARD_PAPER = ITEMS.registerItem("shard_paper", props -> new ItemShard(props)); //comp
  public static final DeferredItem<ItemShard> SHARD_WOOD = ITEMS.registerItem("shard_wood", props -> new ItemShard(props)); //comp


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
