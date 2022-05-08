package com.lothrazar.scraps;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientStuff {

  @OnlyIn(Dist.CLIENT)
  public static void setup(FMLClientSetupEvent event) {
    RenderType c = RenderType.cutout();
    ItemBlockRenderTypes.setRenderLayer(ScrapModRegistry.SCRAP_TRASH.get(), c);
  }
}
