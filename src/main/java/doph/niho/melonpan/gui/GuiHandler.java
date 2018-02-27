package doph.niho.melonpan.gui;

import doph.niho.melonpan.tileentity.TileEntityManaita;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case GuiID.GUI_MANAITA:
			return new ContainerManaita(player.inventory, (TileEntityManaita)world.getTileEntity(new BlockPos(x, y, z)), player);
		case GuiID.GUI_NABE:
			//return new ContainerNabe(x, y, z);
		case GuiID.GUI_FRYPAN:
			//return new ContainerFrypan(x, y, z);
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case GuiID.GUI_MANAITA:
			return new GuiContainerManaita(player, world, x, y, z);
		case GuiID.GUI_NABE:
			return new GuiContainerNabe(player, world, x, y, z);
		case GuiID.GUI_FRYPAN:
			return new GuiContainerFrypan(player, world, x, y, z);
		default:
			return null;
		}
	}
}
