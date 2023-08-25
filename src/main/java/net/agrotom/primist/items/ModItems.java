package net.agrotom.primist.items;

import java.util.Arrays;

import com.ibm.icu.impl.CollectionSet;

import net.agrotom.primist.Core;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Core.MOD_ID);

	public static final RegistryObject<Item> ONYX = ITEMS.register("onyx",
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

	public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot",
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

	public static final RegistryObject<Item> TUNGSTEN_NUGGET = ITEMS.register("tungsten_nugget",
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

	public static final RegistryObject<Item> HERB = ITEMS.register("herb",
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

	public static final RegistryObject<Item> DRIED_HERB = ITEMS.register("dried_herb",
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

	public static final RegistryObject<Item> FLINT_KNIFE = ITEMS.register("flint_knife",
			() -> new HarvestToolItem(2.0f, 0.25f, ItemTier.STONE,
					new CollectionSet<Block>(Arrays.asList(Blocks.FERN, Blocks.GRASS, Blocks.DEAD_BUSH)),
					new Item.Properties().defaultDurability(70).durability(70).tab(ItemGroup.TAB_TOOLS)));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
