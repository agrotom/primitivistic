package net.agrotom.primist.util;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderUtils {

	private RenderUtils() {
	}

	public static void renderOptNametag(@Nonnull TileEntity tile, @Nonnull String text,
			@Nonnull MatrixStack matrix, @Nonnull IRenderTypeBuffer buffer, int p_225629_5_, float x, float y,
			float z) {
		
		SafeMinecraft.ifMinecraftReady(minecraft -> {
			if (minecraft.player.isShiftKeyDown()) {
				final EntityRendererManager entityRenderDispatcher = minecraft.getEntityRenderDispatcher();
	
				matrix.pushPose();
				matrix.translate(x, y, z);
				matrix.mulPose(entityRenderDispatcher.cameraOrientation());
				matrix.scale(-0.025F, -0.025F, 0.025F);
	
				Matrix4f matrix4f = matrix.last().pose();
	
				float f1 = minecraft.options.getBackgroundOpacity(0.25F);
				int j = (int) (f1 * 255.0F) << 24;
				final FontRenderer font = minecraft.font;
				float f2 = (float) (-font.width(text) / 2);
	
				font.drawInBatch(text, f2, 0, -1, false, matrix4f, buffer, false, j, p_225629_5_);
	
				matrix.popPose();
			}
		});
	}

}
