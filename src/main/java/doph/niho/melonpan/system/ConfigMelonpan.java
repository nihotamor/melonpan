package doph.niho.melonpan.system;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Type;

public class ConfigMelonpan{
	@Config(modid = Define.MODID, type = Type.INSTANCE, name = Define.MODID)
	public static class _CONFIG_MAIN{
		@Comment({"レシピを消去するアイテムのリスト(食料用)", "List of Items whiches recipes are deleted (for Foods)"})
		public static String[] ItemsRecipeDeleted = {"cake", "speckled_melon"};
	}
}
