package doph.niho.melonpan.init;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

import static doph.niho.melonpan.block.AllBlock.*;

public class BlockRegisterer {
	public static void RegisterBlock(RegistryEvent.Register<Block> e) {
		IForgeRegistry<Block> registry = e.getRegistry();
		registry.register(manaita);
		registry.register(manaita2);
	}
}
