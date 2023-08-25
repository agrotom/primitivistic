package net.agrotom.primist.events;

import javax.annotation.Nonnull;

import net.agrotom.primist.Core;
import net.agrotom.primist.events.loot.HerbAdditionModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Core.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

	private ModEvents() {}
	
	@SubscribeEvent
	public static void registerModifierSerializers(@Nonnull RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
		event.getRegistry().registerAll(new HerbAdditionModifier.Serializer().setRegistryName(Core.MOD_ID, "herb_from_grass"),
				new HerbAdditionModifier.Serializer().setRegistryName(Core.MOD_ID, "herb_from_bush"));
	}

}
