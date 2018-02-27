package doph.niho.melonpan.gui;

import doph.niho.melonpan.system.Define;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiContainerFrypan extends BaseGuiContainer {

    static {
        resource = new ResourceLocation(Define.MODID, "textures/gui/frypan.png");
    }

    public GuiContainerFrypan(EntityPlayer player, World world, int x, int y, int z) {
        super(new ContainerPlayer(player.inventory, world.isRemote, player), player.inventory);
    }

}
