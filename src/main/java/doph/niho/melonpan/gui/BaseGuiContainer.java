package doph.niho.melonpan.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public abstract class BaseGuiContainer extends GuiContainer {

	protected static ResourceLocation resource = null;

	protected InventoryPlayer playerInventory;

	public BaseGuiContainer(Container inventorySlotsIn, InventoryPlayer playerInventoryIn) {
		super(inventorySlotsIn);
		playerInventory = playerInventoryIn;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
	}

	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		if (resource != null) {
			this.mc.renderEngine.bindTexture(resource);
			this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, xSize, ySize);
		}
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
