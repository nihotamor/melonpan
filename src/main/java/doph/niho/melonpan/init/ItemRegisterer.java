package doph.niho.melonpan.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

import static doph.niho.melonpan.itemblock.AllItemBlock.*;

public class ItemRegisterer {
	public static void RegisterItem(RegistryEvent.Register<Item> e) {
		IForgeRegistry<Item> registry = e.getRegistry();
		registry.register(manaita);
		registry.register(manaita2);
	}
}
