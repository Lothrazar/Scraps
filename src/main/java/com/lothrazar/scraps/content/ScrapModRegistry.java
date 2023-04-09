package com.lothrazar.scraps.content;

import com.lothrazar.library.item.ItemFlib;
import com.lothrazar.library.registry.RegistryFactory;
import com.lothrazar.scraps.ScrapModMain;
import com.lothrazar.scraps.blocks.BlockGarbage;
import com.lothrazar.scraps.blocks.BlockScraps;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ScrapModRegistry {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ScrapModMain.MODID);
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ScrapModMain.MODID);

  @SubscribeEvent
  public static void buildContents(CreativeModeTabEvent.Register event) {
    RegistryFactory.buildTab(event, ScrapModMain.MODID, GARBAGE.get().asItem(), ITEMS);
  }

  public static final RegistryObject<Block> GARBAGE = BLOCKS.register("garbage", () -> new BlockGarbage(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(0.5F)));
  //junk is a small pile of stuff
  public static final RegistryObject<Block> SCRAP_TRASH = BLOCKS.register("scrap_trash", () -> new BlockScraps(Block.Properties.of(Material.STONE).instabreak()));
  public static final RegistryObject<Block> SCRAP_BONES = BLOCKS.register("scrap_bones", () -> new BlockScraps(Block.Properties.of(Material.STONE).instabreak()));
  public static final RegistryObject<Block> SCRAP_METAL = BLOCKS.register("scrap_metal", () -> new BlockScraps(Block.Properties.of(Material.STONE).instabreak()));
  public static final RegistryObject<Block> SCRAP_BRUSH = BLOCKS.register("scrap_brush", () -> new BlockScraps(Block.Properties.of(Material.STONE).instabreak()));
  static {
    ITEMS.register("garbage", () -> new BlockItem(GARBAGE.get(), new Item.Properties()));
    ITEMS.register("scrap_trash", () -> new BlockItem(SCRAP_TRASH.get(), new Item.Properties()));
    ITEMS.register("scrap_bones", () -> new BlockItem(SCRAP_BONES.get(), new Item.Properties()));
    ITEMS.register("scrap_metal", () -> new BlockItem(SCRAP_METAL.get(), new Item.Properties()));
    ITEMS.register("scrap_brush", () -> new BlockItem(SCRAP_BRUSH.get(), new Item.Properties()));
    ITEMS.register("junk", () -> new ItemFlib(new Item.Properties(), new ItemFlib.Settings().tooltip().burnTime(200)));
  }

  @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
  public static class ShardItems {

    public static final RegistryObject<Item> SHARD_BONE = ITEMS.register("shard_bone", () -> new ItemShard(new Item.Properties())); //comp
    public static final RegistryObject<Item> SHARD_BRICK = ITEMS.register("shard_brick", () -> new ItemShard(new Item.Properties())); //hard
    public static final RegistryObject<Item> SHARD_FLINT = ITEMS.register("shard_flint", () -> new ItemShard(new Item.Properties())); //hard
    public static final RegistryObject<Item> SHARD_GLASS = ITEMS.register("shard_glass", () -> new ItemShard(new Item.Properties())); //hard
    public static final RegistryObject<Item> SHARD_LEATHER = ITEMS.register("shard_leather", () -> new ItemShard(new Item.Properties())); //comp
    public static final RegistryObject<Item> SHARD_PAPER = ITEMS.register("shard_paper", () -> new ItemShard(new Item.Properties())); //comp
    public static final RegistryObject<Item> SHARD_WOOD = ITEMS.register("shard_wood", () -> new ItemShard(new Item.Properties())); //comp
  }

  public static void composter() {
    if (ScrapConfig.COMPOSTER.get()) {
      ComposterBlock.COMPOSTABLES.put(ShardItems.SHARD_BONE.get(), 0.3F);
      ComposterBlock.COMPOSTABLES.put(ShardItems.SHARD_LEATHER.get(), 0.3F);
      ComposterBlock.COMPOSTABLES.put(ShardItems.SHARD_PAPER.get(), 0.3F);
      ComposterBlock.COMPOSTABLES.put(ShardItems.SHARD_WOOD.get(), 0.3F);
    }
    //NOT COMPOST: BRICK, FLINT, GLASS
  }
}
