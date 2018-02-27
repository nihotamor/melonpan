package doph.niho.melonpan.proxy;

import doph.niho.melonpan.init.BlockRegisterer;
import doph.niho.melonpan.init.GuiRegisterer;
import doph.niho.melonpan.init.ItemRegisterer;
import doph.niho.melonpan.init.RecipeRegisterer;
import doph.niho.melonpan.init.TileEntityRegisterer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void PreInit(FMLPreInitializationEvent e) {

	}

	public void Init(FMLInitializationEvent e) {
	    TileEntityRegisterer.RegisterTileEntity();
	}

	public void PostInit(FMLPostInitializationEvent e) {

	}

	public void OnItemRegistered(RegistryEvent.Register<Item> e) {
		ItemRegisterer.RegisterItem(e);

	}

	public void OnBlockRegistered(RegistryEvent.Register<Block> e) {
		BlockRegisterer.RegisterBlock(e);
	}

	public void OnRecipeRegistered(RegistryEvent.Register<IRecipe> e) {
		RecipeRegisterer.RegisterRecipe(e);
	}

	public void OnGuiRegistered(InitGuiEvent e) {
		GuiRegisterer.RegisterGui(e);
	}
}
