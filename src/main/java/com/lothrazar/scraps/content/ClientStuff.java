package com.lothrazar.scraps.content;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientStuff {

  @OnlyIn(Dist.CLIENT)
  public static void setup(FMLClientSetupEvent event) {
    RenderType c = RenderType.translucent();
    ItemBlockRenderTypes.setRenderLayer(ScrapModRegistry.SCRAP_TRASH.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ScrapModRegistry.SCRAP_BONES.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ScrapModRegistry.SCRAP_METAL.get(), c);
  }
}
