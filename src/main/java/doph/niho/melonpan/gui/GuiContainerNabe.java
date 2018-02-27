package doph.niho.melonpan.gui;

import doph.niho.melonpan.system.Define;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiContainerNabe extends BaseGuiContainer{

	static {
		resource = new ResourceLocation(Define.MODID, "textures/gui/nabe.png");
	}

	public GuiContainerNabe(EntityPlayer player, World world, int x, int y, int z) {
		super(new ContainerPlayer(player.inventory, world.isRemote, player), player.inventory);
	}

}
