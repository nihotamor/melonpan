package doph.niho.melonpan.itemblock;

import doph.niho.melonpan.block.AllBlock;
import doph.niho.melonpan.block.BlockManaita2;
import net.minecraft.item.ItemStack;

public class ItemBlockManaita2 extends BaseItemBlock {
	public ItemBlockManaita2() {
		super(AllBlock.manaita2);
		this.setHasSubtypes(true);
	}

	public int getMetadata(int damage) {
		return damage;
	}

	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "." + ((BlockManaita2)this.block).getUnlocalizedName(stack);
	}
}
