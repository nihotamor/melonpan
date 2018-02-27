package doph.niho.melonpan.block;

import doph.niho.melonpan.block.base.BaseBlock;

public class AllBlock {
	public static BaseBlock manaita;
	public static BaseBlock manaita2;

	public static void Init() {
		manaita = new BlockManaita();
		manaita2 = new BlockManaita2();
	}
}
