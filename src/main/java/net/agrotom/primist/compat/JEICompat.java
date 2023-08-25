package net.agrotom.primist.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.agrotom.primist.Core;
import net.agrotom.primist.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;

@JeiPlugin
public class JEICompat implements IModPlugin {

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation(Core.MOD_ID, "jei_plugin");
	}
	
	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		final IIngredientManager manager = registration.getIngredientManager();
		
		final IIngredientType<ItemStack> type = manager.getIngredientType(ItemStack.class);
		
		registration.addIngredientInfo(new ItemStack(ModItems.HERB.get()), type,
				new StringTextComponent("Herb gathering from grass by flint knife"));
		registration.addIngredientInfo(new ItemStack(ModItems.DRIED_HERB.get()), type,
				new StringTextComponent("Dried herb gathering from dead bushes by flint knife"));
	}

}
