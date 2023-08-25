package net.agrotom.primist.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.agrotom.primist.tileentity.WoodenBarrelTileEntity;
import net.agrotom.primist.util.RenderUtils;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WoodenBarrelTileEntityRenderer extends TileEntityRenderer<WoodenBarrelTileEntity>
{

	public WoodenBarrelTileEntityRenderer(final TileEntityRendererDispatcher dispatcher)
	{
		super(dispatcher);
	}

	@Override
	public void render(final WoodenBarrelTileEntity tile, final float ticks, final MatrixStack matrix,
			final IRenderTypeBuffer buffer, final int combinedLightIn, final int combinedOverlayIn)
	{
		RenderUtils.renderOptNametag(tile, tile.getCurrentAmount() + "mb", matrix, buffer, combinedLightIn, 0.5f, 1.2f, 0.5f);
	}

}
