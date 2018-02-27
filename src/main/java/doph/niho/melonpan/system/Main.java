package doph.niho.melonpan.system;

import org.apache.logging.log4j.Logger;

import doph.niho.melonpan.block.AllBlock;
import doph.niho.melonpan.itemblock.AllItemBlock;
import doph.niho.melonpan.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Define.MODID, name = Define.MOD_NAME, version = Define.MOD_VERSION, acceptedMinecraftVersions = Define.MOD_MC_VERSION)
@EventBusSubscriber
public class Main {

	@Mod.Instance(Define.MODID)
	public static Main instance;
	@SidedProxy(clientSide = Define.CLIENT_PROXY_CLASS, serverSide = Define.COMMON_PROXY_CLASS)
	private static CommonProxy proxy;

	private static Logger logger;
	private static Configuration config;

	static {
		AllBlock.Init();
		AllItemBlock.Init();
	}

	@SubscribeEvent
	public void PreInit(FMLPreInitializationEvent e) {
		config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();
		logger = e.getModLog();
		proxy.PreInit(e);
	}

	@SubscribeEvent
	public void Init(FMLInitializationEvent e) {
		proxy.Init(e);
	}

	@SubscribeEvent
	public void PostInit(FMLPostInitializationEvent e) {
		proxy.PostInit(e);
	}

	@SubscribeEvent
	public static void OnItemRegistered(RegistryEvent.Register<Item> e) {
		proxy.OnItemRegistered(e);
	}

	@SubscribeEvent
	public static void OnBlockRegistered(RegistryEvent.Register<Block> e) {
		proxy.OnBlockRegistered(e);
	}

	@SubscribeEvent
	public static void OnRecipeRegistered(RegistryEvent.Register<IRecipe> e) {
		proxy.OnRecipeRegistered(e);
	}

	@SubscribeEvent
	public static void OnGuiRegistered(InitGuiEvent e) {
		proxy.OnGuiRegistered(e);
	}

	public Logger getLogger() {
		return logger;
	}

	public Configuration getConfig() {
		return config;
	}
}
