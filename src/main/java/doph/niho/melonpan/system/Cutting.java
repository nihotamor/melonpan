package doph.niho.melonpan.system;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Cutting {
    public static int Get(Item item) {
        if (item.equals(Items.APPLE))
            return 4;
        return 1;
    }

    public static ItemStack Result(Item item) {
        return ItemStack.EMPTY;
    }
}
