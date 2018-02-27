package doph.niho.melonpan.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerManaita extends BaseContainer{

	public ContainerManaita(InventoryPlayer playerInv, IInventory inv, EntityPlayer player) {
        super(playerInv, inv, player);
	    inventory = inv;
	    inv.openInventory(player);

	    for(int i = 0; i < inv.getSizeInventory(); i++) {
	        this.addSlotToContainer(new Slot(inv, i, 53 + i * 54, 20));
	    }
	    for(int i = 0; i < 3; i++) {
	        for(int j = 0; j < 9; j++) {
	            this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, i * 18 + 51));
	        }
	    }
	    for(int i = 0; i < 9; i++) {
	        this.addSlotToContainer(new Slot(playerInv, i, 8 + i + 18, 109));
	    }
	}

}
