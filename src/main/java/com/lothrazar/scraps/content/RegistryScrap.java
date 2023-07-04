package com.lothrazar.scraps.content;

import com.lothrazar.library.item.ItemFlib;
import com.lothrazar.library.registry.RecipeCompostFactory;
import com.lothrazar.scraps.ScrapModMain;
import com.lothrazar.scraps.blocks.BlockGarbage;
import com.lothrazar.scraps.blocks.BlockScraps;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryScrap {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ScrapModMain.MODID);
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ScrapModMain.MODID);
  private static final ResourceKey<CreativeModeTab> TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(ScrapModMain.MODID, "tab"));

  @SubscribeEvent
  public static void onCreativeModeTabRegister(RegisterEvent event) {
    event.register(Registries.CREATIVE_MODE_TAB, helper -> {
      helper.register(TAB, CreativeModeTab.builder().icon(() -> new ItemStack(GARBAGE.get()))
          .title(Component.translatable("itemGroup." + ScrapModMain.MODID))
          .displayItems((enabledFlags, populator) -> {
            for (RegistryObject<Item> entry : ITEMS.getEntries()) {
              populator.accept(entry.get());
            }
          }).build());
    });
  }

  public static final RegistryObject<Block> GARBAGE = BLOCKS.register("garbage", () -> new BlockGarbage(Block.Properties.of().mapColor(DyeColor.BROWN).strength(0.5F)));
  //junk is a small pile of stuff
  public static final RegistryObject<Block> SCRAP_TRASH = BLOCKS.register("scrap_trash", () -> new BlockScraps(Block.Properties.of().instabreak()));
  public static final RegistryObject<Block> SCRAP_BONES = BLOCKS.register("scrap_bones", () -> new BlockScraps(Block.Properties.of().instabreak()));
  public static final RegistryObject<Block> SCRAP_METAL = BLOCKS.register("scrap_metal", () -> new BlockScraps(Block.Properties.of().instabreak()));
  public static final RegistryObject<Block> SCRAP_BRUSH = BLOCKS.register("scrap_brush", () -> new BlockScraps(Block.Properties.of().instabreak()));
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
    if (ConfigRegistryScrap.COMPOSTER.get()) {
      final float f = RecipeCompostFactory.FillValues.LEAVES;
      RecipeCompostFactory.put(ShardItems.SHARD_BONE.get(), f);
      RecipeCompostFactory.put(ShardItems.SHARD_LEATHER.get(), f);
      RecipeCompostFactory.put(ShardItems.SHARD_PAPER.get(), f);
      RecipeCompostFactory.put(ShardItems.SHARD_WOOD.get(), f);
    }
    //NOT COMPOST: BRICK, FLINT, GLASS
  }
}
