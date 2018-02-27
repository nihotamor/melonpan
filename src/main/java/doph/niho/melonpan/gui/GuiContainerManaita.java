package doph.niho.melonpan.gui;

import doph.niho.melonpan.system.Define;
import doph.niho.melonpan.tileentity.TileEntityManaita;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiContainerManaita extends BaseGuiContainer {

    private final IInventory manaitaInventory;

    static {
        resource = new ResourceLocation(Define.MODID, "textures/gui/manaita.png");
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        // this.fontRenderer.drawString(this.manaitaInventory.getDisplayName().toString(),
        // 8, 6, Define.TEXT_COLOR);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96,
                Define.TEXT_COLOR);
    }

    public GuiContainerManaita(EntityPlayer player, World world, int x, int y, int z) {
        super(new ContainerManaita(player.inventory, (TileEntityManaita) world.getTileEntity(new BlockPos(x, y, z)),
                player), player.inventory);
        this.manaitaInventory = (TileEntityManaita) world.getTileEntity(new BlockPos(x, y, z));
        this.xSize = 176;
        this.ySize = 133;
    }

}
