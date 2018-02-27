package doph.niho.melonpan.init;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import doph.niho.melonpan.recipe.DummyRecipe;
import doph.niho.melonpan.system.ConfigMelonpan;
import doph.niho.melonpan.system.Define;
import net.minecraft.item.ItemFood;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class RecipeRegisterer {
	public static void RegisterRecipe(RegistryEvent.Register<IRecipe> e) {
		IForgeRegistry<IRecipe> registry = e.getRegistry();
		List<ResourceLocation> deleter = new ArrayList<>();
		Set<ResourceLocation> rl = registry.getKeys();
		List<ResourceLocation> items = new ArrayList<>();

		for (String s : ConfigMelonpan._CONFIG_MAIN.ItemsRecipeDeleted) {
			if (s.contains(":")) {
				items.add(new ResourceLocation(s.split(":")[0], s.split(":")[1]));
			} else {
				items.add(new ResourceLocation(s));
			}
		}
		items.add(new ResourceLocation("cake"));
		items.add(new ResourceLocation("speckled_melon"));

		Iterator<ResourceLocation> it = rl.iterator();
		while (it.hasNext()) {
			IRecipe recipe = registry.getValue(it.next());
			ResourceLocation res = registry.getKey(recipe);
			if (recipe.getRecipeOutput().getItem() instanceof ItemFood || items.contains(res)) {
				if (!res.getResourceDomain().equals(Define.MODID)) {
					deleter.add(res);
				}
			}
		}
		if(!deleter.isEmpty()) {
			for(ResourceLocation name : deleter) {
				((IForgeRegistryModifiable<IRecipe>)registry).remove(name);
				registry.register(new DummyRecipe().setRegistryName(name));
			}
			deleter.clear();
		}
	}
}
