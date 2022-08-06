package com.lothrazar.scraps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lothrazar.scraps.content.ClientStuff;
import com.lothrazar.scraps.content.ScrapModRegistry;
import com.lothrazar.scraps.content.ScrapGenPlacements;
import com.lothrazar.scraps.content.ScrapsConfig;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Scoreboard;
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
    ScrapsConfig.setup();
    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
      eventBus.addListener(ClientStuff::setup);
    });
    Scoreboard y;
    Objective x;
  }

  private void setup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
      ScrapGenPlacements.init();
    });
  }
}
