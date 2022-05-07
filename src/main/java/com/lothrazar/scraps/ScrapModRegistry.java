package com.lothrazar.scraps;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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
      return new ItemStack(JUNK.get());
    }
  };
  public static final RegistryObject<Block> JUNK = BLOCKS.register("junk", () -> new Block(Block.Properties.of(Material.STONE))); // garbage pile
  public static final RegistryObject<Block> GARBAGE = BLOCKS.register("garbage", () -> new Block(Block.Properties.of(Material.STONE))); // garbage full block
  static {
    ITEMS.register("junk", () -> new BlockItem(JUNK.get(), new Item.Properties().tab(TAB)));
    ITEMS.register("garbage", () -> new BlockItem(GARBAGE.get(), new Item.Properties().tab(TAB)));
    //
    ITEMS.register("scrap_bone", () -> new Item(new Item.Properties().tab(TAB)));
    ITEMS.register("scrap_copper", () -> new Item(new Item.Properties().tab(TAB)));
    ITEMS.register("scrap_flint", () -> new Item(new Item.Properties().tab(TAB)));
    ITEMS.register("scrap_glass", () -> new Item(new Item.Properties().tab(TAB)));
    ITEMS.register("scrap_leather", () -> new Item(new Item.Properties().tab(TAB)));
    ITEMS.register("scrap_stone", () -> new Item(new Item.Properties().tab(TAB)));
    ITEMS.register("scrap_string", () -> new Item(new Item.Properties().tab(TAB)));
    ITEMS.register("scrap_wood", () -> new Item(new Item.Properties().tab(TAB)));
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
