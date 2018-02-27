package doph.niho.melonpan.itemblock;

import doph.niho.melonpan.block.AllBlock;
import doph.niho.melonpan.block.BlockManaita;
import net.minecraft.item.ItemStack;

public class ItemBlockManaita extends BaseItemBlock{

	public ItemBlockManaita() {
		super(AllBlock.manaita);
		this.setHasSubtypes(true);
	}

	public int getMetadata(int damage) {
		return damage;
	}

	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "." + ((BlockManaita)this.block).getUnlocalizedName(stack);
	}
}
