package net.agrotom.primist;

import net.agrotom.primist.blocks.ModBlocks;
import net.agrotom.primist.client.color.ModColorBlocks;
import net.agrotom.primist.client.render.GrillTileEntityRenderer;
import net.agrotom.primist.client.render.WoodenBarrelTileEntityRenderer;
import net.agrotom.primist.data.recipes.ModRecipeTypes;
import net.agrotom.primist.items.ModItems;
import net.agrotom.primist.tileentity.ModTileEntities;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("primist")
public class Core {

	private static final Logger LOGGER = LogManager.getLogger();
	
	public static final String MOD_ID = "primist"; 

	public Core() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

		MinecraftForge.EVENT_BUS.register(this);
		
		final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModTileEntities.register(eventBus);
        ModRecipeTypes.register(eventBus);
	}

	private void setup(final FMLCommonSetupEvent event) {

	}

	private void doClientStuff(final FMLClientSetupEvent event) {

		ClientRegistry.bindTileEntityRenderer(ModTileEntities.GRILL_TILEENTITY.get(), GrillTileEntityRenderer::new);
    	ClientRegistry.bindTileEntityRenderer(ModTileEntities.WOODEN_BARREL_TILEENTITY.get(), WoodenBarrelTileEntityRenderer::new);
    	ModColorBlocks.register();
		
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {

	}

	private void processIMC(final InterModProcessEvent event) {
		
	}
	
}
