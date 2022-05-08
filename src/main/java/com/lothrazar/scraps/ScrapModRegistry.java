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
      return new ItemStack(SCRAP_TRASH.get());
    }
  };
  public static final RegistryObject<Block> GARBAGE = BLOCKS.register("garbage", () -> new Block(Block.Properties.of(Material.STONE))); // garbage full block
  //TODO: block tag /junk/
  //small is wood/string/leather/glass etc
  public static final RegistryObject<Block> SCRAP_TRASH = BLOCKS.register("scrap_trash", () -> new Block(Block.Properties.of(Material.STONE))); // TODO layers ?
  public static final RegistryObject<Block> SCRAP_BONES = BLOCKS.register("scrap_bones", () -> new Block(Block.Properties.of(Material.STONE)));
  public static final RegistryObject<Block> SCRAP_METAL = BLOCKS.register("scrap_metal", () -> new Block(Block.Properties.of(Material.STONE)));
  public static final RegistryObject<Block> SCRAP_FOOD = BLOCKS.register("scrap_food", () -> new Block(Block.Properties.of(Material.STONE)));
  static {
    ITEMS.register("junk", () -> new Item(new Item.Properties().tab(TAB))); //dead item, used for crafting
    //craft junk into garbage which is full block. garbage just drops random
    ITEMS.register("garbage", () -> new BlockItem(GARBAGE.get(), new Item.Properties().tab(TAB)));
    //pile_bones
    //pile_junk?
    //pile_wood ? or just placeable scraps?
    //or skip scrap and just have 
    //using forge/dusts tag. dust_glass, dust_wood (sawdust), 
    //TODO: item tag /scrap/ . 
    ITEMS.register("shard_bone", () -> new Item(new Item.Properties().tab(TAB))); //
    //    ITEMS.register("scrap_copper", () -> new Item(new Item.Properties().tab(TAB)));//4x into nugget
    ITEMS.register("shard_flint", () -> new Item(new Item.Properties().tab(TAB)));//4x
    ITEMS.register("shard_glass", () -> new Item(new Item.Properties().tab(TAB)));//?
    ITEMS.register("shard_leather", () -> new Item(new Item.Properties().tab(TAB)));//4x
    //    ITEMS.register("scrap_stone", () -> new Item(new Item.Properties().tab(TAB)));//4x into cobblestone?
    //        ITEMS.register("scrap_string", () -> new Item(new Item.Properties().tab(TAB)));//9x into wool
    ITEMS.register("shard_wood", () -> new Item(new Item.Properties().tab(TAB)));//9x into one stick?
    //one 'junk' item, 9x junk into 1x garbage
    //also tag all 'shards' as something
    //so like 5 junk and 4 leather shards would be garbage or osmething?
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
