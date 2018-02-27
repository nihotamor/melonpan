package doph.niho.melonpan.creativetab;

import doph.niho.melonpan.block.AllBlock;
import net.minecraft.item.ItemStack;

public class CreativeTabMelonpanFood extends BaseCreativeTab {

	public CreativeTabMelonpanFood(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(AllBlock.manaita2, 3);
	}

}
