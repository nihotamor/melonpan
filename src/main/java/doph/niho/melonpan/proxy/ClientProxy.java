package doph.niho.melonpan.proxy;

import doph.niho.melonpan.init.ModelRegisterer;
import doph.niho.melonpan.system.Define;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Define.MODID)
public class ClientProxy extends CommonProxy {

	@Override
	public void PreInit(FMLPreInitializationEvent e) {
	    super.PreInit(e);
	}

	@Override
	public void Init(FMLInitializationEvent e) {
	    super.Init(e);
	}

	@Override
	public void PostInit(FMLPostInitializationEvent e) {
	    super.PostInit(e);
	}

	@Override
	public void OnItemRegistered(RegistryEvent.Register<Item> e) {
		super.OnItemRegistered(e);
	}

	@Override
	public void OnBlockRegistered(RegistryEvent.Register<Block> e) {
		super.OnBlockRegistered(e);
	}

	@Override
	public void OnRecipeRegistered(RegistryEvent.Register<IRecipe> e) {
		super.OnRecipeRegistered(e);
	}

	@Override
	public void OnGuiRegistered(InitGuiEvent e) {
		super.OnGuiRegistered(e);
	}

	@SubscribeEvent
	public static void OnModelRegistered(ModelRegistryEvent e) {
		ModelRegisterer.RegisterModel(e);
	}

}
