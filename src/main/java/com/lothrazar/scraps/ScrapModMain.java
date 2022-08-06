package com.lothrazar.scraps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lothrazar.scraps.content.ClientStuff;
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
    ScrapModRegistry.TILE_ENTITIES.register(eventBus);
    eventBus.addListener(this::setup);
    ScrapConfig.setup();
    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
      eventBus.addListener(ClientStuff::setup);
    });
  }

  private void setup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
      ScrapGenPlacements.init();
    });
  }
}
