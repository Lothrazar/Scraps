package com.lothrazar.scraps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lothrazar.scraps.content.ClientStuff;
import com.lothrazar.scraps.content.ScrapConfig;
import com.lothrazar.scraps.content.ScrapModRegistry;
import com.lothrazar.scraps.world.ScrapGenPlacements;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ScrapModMain.MODID)
public class ScrapModMain {

  public static final String MODID = "scraps";
  public static final Logger LOGGER = LogManager.getLogger();

  public ScrapModMain() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    ScrapModRegistry.BLOCKS.register(eventBus);
    ScrapModRegistry.ITEMS.register(eventBus);
    //    ScrapModRegistry.TILE_ENTITIES.register(eventBus);
    //    ScrapModRegistry.RECIPE_TYPES.register(eventBus);
    //    ScrapModRegistry.RECIPE_SERIALIZERS.register(eventBus);
    eventBus.addListener(this::setup);
    ScrapConfig.setup();
    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
      eventBus.addListener(ClientStuff::setup);
    });
  }

  private void setup(final FMLCommonSetupEvent event) {
    //    MinecraftForge.EVENT_BUS.register(new GrindEvents());
    event.enqueueWork(() -> {
      ScrapGenPlacements.init();
    });
  }
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
  //  *[DONE] Use a similar type of harvest to the minecraft archeology mechanics? Using a shovel or tool to properly break the blocks instead of stepping on
  //      * stepping on gives a broken item because the player wasn't "careful" to harvest
  //
  //  *[DONE] Recycle Mechanic to process through machines
  //
  //feature list
  //worldgen fixed with new configs
  //worldgen wont place moss blocks under itself anymore
  //applies to the four scrap_ piles and the block 'garbage'
  //breaking without the right tool gives the random broken item
  //harvest correctly: item data tag    "scraps:mineable" THEN u get non-broken item IE full bone vs broken bone
  // recycling: 
  //centered around items 'junk' and 'garbage' as abstract mash of stuff items
  //craft these and then process into whatever scrap you need
  //example
  //if you need flint, make some junk and garbage and find which processing recipe gets scrap_flint, and make flint from that 
  //optional recipes added for plaingrinder and cyclic:crusher also
  //
  //
}
