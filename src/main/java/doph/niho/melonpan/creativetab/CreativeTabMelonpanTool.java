package doph.niho.melonpan.creativetab;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CreativeTabMelonpanTool extends BaseCreativeTab{

	public CreativeTabMelonpanTool(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.APPLE);
	}

}
