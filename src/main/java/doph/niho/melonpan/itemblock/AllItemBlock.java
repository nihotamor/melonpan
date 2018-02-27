package doph.niho.melonpan.itemblock;

public class AllItemBlock {
	public static BaseItemBlock manaita;
	public static BaseItemBlock manaita2;

	public static void Init() {
		manaita = new ItemBlockManaita();
		manaita2 = new ItemBlockManaita2();
	}
}
