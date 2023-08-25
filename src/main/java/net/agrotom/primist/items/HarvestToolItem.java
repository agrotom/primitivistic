package net.agrotom.primist.items;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HarvestToolItem extends ToolItem {

	public HarvestToolItem(float p_i48512_1_, float p_i48512_2_, IItemTier p_i48512_3_, Set<Block> p_i48512_4_,
			Properties p_i48512_5_) {
		super(p_i48512_1_, p_i48512_2_, p_i48512_3_, p_i48512_4_, p_i48512_5_);
	}

	@Override
	public boolean mineBlock(ItemStack itemStack, World level, BlockState state, BlockPos pos,
			LivingEntity entity) {

		if (!level.isClientSide) {
			itemStack.hurtAndBreak(1, entity, (p_220038_0_) -> {
				p_220038_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
			});
		}

		return true;

	}

}
