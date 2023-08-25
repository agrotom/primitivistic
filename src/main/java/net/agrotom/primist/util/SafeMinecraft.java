package net.agrotom.primist.util;

import java.util.function.Consumer;

import javax.annotation.Nonnull;

import net.minecraft.client.Minecraft;

public class SafeMinecraft {

	private SafeMinecraft() {}

	public static boolean isMinecraftReady() {
		return Minecraft.getInstance() != null;
	}
	
	public static void ifMinecraftReady(@Nonnull Consumer<Minecraft> consumer) {
		if (isMinecraftReady()) {
			consumer.accept(Minecraft.getInstance());
		}
	}
	
}
