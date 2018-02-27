package doph.niho.melonpan.creativetab;

import doph.niho.melonpan.block.AllBlock;
import net.minecraft.item.ItemStack;

public class CreativeTabMelonpanBlock extends BaseCreativeTab {

	public CreativeTabMelonpanBlock(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(AllBlock.manaita);
	}

}
