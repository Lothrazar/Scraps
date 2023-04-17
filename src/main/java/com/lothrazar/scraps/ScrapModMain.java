package com.lothrazar.scraps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lothrazar.scraps.content.ConfigRegistryScrap;
import com.lothrazar.scraps.content.RegistryScrap;
import com.lothrazar.scraps.world.ScrapGenPlacements;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ScrapModMain.MODID)
public class ScrapModMain {

  public static final String MODID = "scraps";
  public static final Logger LOGGER = LogManager.getLogger();

  public ScrapModMain() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    RegistryScrap.BLOCKS.register(eventBus);
    RegistryScrap.ITEMS.register(eventBus);
    //    ScrapModRegistry.TILE_ENTITIES.register(eventBus);
    //    ScrapModRegistry.RECIPE_TYPES.register(eventBus);
    //    ScrapModRegistry.RECIPE_SERIALIZERS.register(eventBus);
    eventBus.addListener(this::setup);
    new ConfigRegistryScrap();
    InterModComms.sendTo("flib", "init", () -> new Object());
  }

  private void setup(final FMLCommonSetupEvent event) {
    //    MinecraftForge.EVENT_BUS.register(new GrindEvents());
    event.enqueueWork(() -> {
      ScrapGenPlacements.init();
      RegistryScrap.composter();
    });
  }
  /* Dynamic registry objects */
  //what the fuck
  //  public static final ResourceKey<PlacedFeature> METAL_SMALL = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MODID, "metal_small"));
  // 
  // TODO: salvaging garbage block for good stuff
  // what to salvage
  // 
  //MASH STUFF TOGETHER 9x9 DATA TAG
  // into junk and garbage
  //different ways to extract resources (LOTS OF WAYS ALREDY EXST) to get different 'shards'
  //
  // 
  //Darkosto — 07/11/2022
  //  *[DONE] Configurable size for scrap generation (Potentially have small, medium, and large piles)
  //  *[DONE] Y level configs
  //  *[DONE using loot tables] Use a similar type of harvest to the minecraft archeology mechanics? Using a shovel or tool to properly break the blocks instead of stepping on
  //      * stepping on gives a broken item because the player wasn't "careful" to harvest
  //
  //  *[done-ish] Recycle Mechanic to process through machines
  //  i added recycling by abusing shapeless crafting, data tag, and optional dependency on plain-grinder.]
  // i did get partway thru making a type of recycling machine i was going to call it a 'salvager'
  //but all you did was punch it to do a 1-1 item recipe, and i realized thats just plain grinder all over again
  // so it was either make a library mod to share some features
  //or can just use conditional recipes and add scraps recipes to grinder, and then its an optional dependency
  // 
  //
  //feature list
  //removed shard_cloth item (redundant since 4 string craft into wool)
  //removed shard_glass item (not useful or interesting. and doing coloured glass shards felt out of scope for small trash mod)
  //added many data tags and recipes
  //garbage block and junk all new texture
  //the four scrap_ blocks had a few updates, they need a solid base now, and 
  //scrap_ worldgen fixed with new configs with y level
  //scrap_ worldgen wont place moss blocks under itself anymore
  //scrap_ block loot table breaking without the right tool gives the random broken item
  //scrap_ when harvested correctly: item data tag    "scraps:mineable" THEN u get non-broken item IE full bone vs broken bone
  //
  // recycling: 
  //centered around items 'junk' and 'garbage' as abstract mash of stuff items
  //craft these and then process into whatever scrap you need
  //by using the shapeless recipes that accept any type of shard you can merge different types together
  //even more recycling:
  //if the following mods are also included (optional)
  //some recipes for type cyclic:crusher
  //some recipes for type plaingrinder:grinder
  //
}
