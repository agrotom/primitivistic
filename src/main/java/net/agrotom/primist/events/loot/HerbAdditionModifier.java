package net.agrotom.primist.events.loot;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class HerbAdditionModifier extends LootModifier {

	private final Item addition;
	
	protected HerbAdditionModifier(ILootCondition[] conditionsIn, Item addition) {
		super(conditionsIn);
		this.addition = addition;
	}

	@Nonnull
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		generatedLoot.add(new ItemStack(addition, 1));
		return generatedLoot;
	}

	public static class Serializer extends GlobalLootModifierSerializer<HerbAdditionModifier> {

		@Override
		public HerbAdditionModifier read(ResourceLocation location, JsonObject object,
				ILootCondition[] ailootcondition) {
			final Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getAsString(object, "addition")));
			
			return new HerbAdditionModifier(ailootcondition, addition);
		}

		@Override
		public JsonObject write(HerbAdditionModifier instance) {
			final JsonObject json = makeConditions(instance.conditions); 
			
			json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
			
			return json;
		}
		
	}

}
