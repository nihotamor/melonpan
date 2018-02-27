package doph.niho.melonpan.init;

import static doph.niho.melonpan.block.AllBlock.*;

import doph.niho.melonpan.block.base.BaseBlock;
import doph.niho.melonpan.system.Define;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;

public class ModelRegisterer {
	public static void RegisterModel(ModelRegistryEvent e) {
		RegisterModel(manaita, "_oak", "_spruce", "_birch", "_jungle");
		RegisterModel(manaita2, "_acacia", "_dark_oak");
	}

	public static void RegisterModel(BaseBlock b, String... subName) {
		int len = subName.length;
		if (len == 0) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), 0,
					new ModelResourceLocation(Define.MODID + ":" + b.getUnlocalizedName().substring(5), "inventory"));
		} else {
			for (int i = 0; i < len; i++) {
				ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), i, new ModelResourceLocation(
						Define.MODID + ":" + b.getUnlocalizedName().substring(14) + subName[i], "inventory"));
			}
		}

	}
}
