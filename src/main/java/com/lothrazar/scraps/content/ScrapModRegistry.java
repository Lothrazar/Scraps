package com.lothrazar.scraps.content;

import com.lothrazar.scraps.ScrapModMain;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ScrapModRegistry {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ScrapModMain.MODID);
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ScrapModMain.MODID);
  public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ScrapModMain.MODID);
  public static final CreativeModeTab TAB = new CreativeModeTab(ScrapModMain.MODID) {

    @Override
    public ItemStack makeIcon() {
      return new ItemStack(SCRAP_TRASH.get());
    }
  };
  public static final RegistryObject<Block> GARBAGE = BLOCKS.register("garbage", () -> new Block(Block.Properties.of(Material.STONE).strength(0.5F))); // garbage full block
  //junk is a small pile of stuff
  public static final RegistryObject<Block> SCRAP_TRASH = BLOCKS.register("scrap_trash", () -> new BlockScraps(Block.Properties.of(Material.STONE).instabreak())); // TODO layers ?
  public static final RegistryObject<Block> SCRAP_BONES = BLOCKS.register("scrap_bones", () -> new BlockScraps(Block.Properties.of(Material.STONE).instabreak()));
  public static final RegistryObject<Block> SCRAP_METAL = BLOCKS.register("scrap_metal", () -> new BlockScraps(Block.Properties.of(Material.STONE).instabreak()));
  static {
    //blockitems    
    ITEMS.register("garbage", () -> new BlockItem(GARBAGE.get(), new Item.Properties().tab(TAB)));
    ITEMS.register("scrap_trash", () -> new BlockItem(SCRAP_TRASH.get(), new Item.Properties().tab(TAB)));
    ITEMS.register("scrap_bones", () -> new BlockItem(SCRAP_BONES.get(), new Item.Properties().tab(TAB)));
    ITEMS.register("scrap_metal", () -> new BlockItem(SCRAP_METAL.get(), new Item.Properties().tab(TAB)));
    //items
    ITEMS.register("junk", () -> new Item(new Item.Properties().tab(TAB)) {

      @Override
      public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
        return 200;
      }
    }); //dead item, used for crafting
    ITEMS.register("shard_bone", () -> new Item(new Item.Properties().tab(TAB)));
    ITEMS.register("shard_flint", () -> new Item(new Item.Properties().tab(TAB)));
    ITEMS.register("shard_glass", () -> new Item(new Item.Properties().tab(TAB)));
    ITEMS.register("shard_leather", () -> new Item(new Item.Properties().tab(TAB)));
    ITEMS.register("shard_cloth", () -> new Item(new Item.Properties().tab(TAB)));
    ITEMS.register("shard_brick", () -> new Item(new Item.Properties().tab(TAB)));
    ITEMS.register("shard_paper", () -> new Item(new Item.Properties().tab(TAB)));
    ITEMS.register("shard_wood", () -> new Item(new Item.Properties().tab(TAB)));
    ///NO ..shard diamond? shard emerald shard lapis?    //shard_ender
    //
    //YES: 
    // shard_obsidian
    //    ITEMS.register("shard_stone", () -> new Item(new Item.Properties().tab(TAB)));//4x into cobblestone?  
  }
  //  garbage pile - size of lili pad, drops random scrap. spawns in world, 
  //  garbage block - drops even more random scrap. spawns in world 
  // 
  //
  //  Recycler block: 
  //  recipes 1 input slot one output slot. power = maybe not RF ?
  //  input 32 scrap iron for one iron nugget
  //  input 8 scrap string for 1 string 
  //
  //
}
