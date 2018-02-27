package doph.niho.melonpan.init;

import doph.niho.melonpan.gui.GuiHandler;
import doph.niho.melonpan.system.Main;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiRegisterer {
	public static void RegisterGui(InitGuiEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}
}
