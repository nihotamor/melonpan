package doph.niho.melonpan.init;

import doph.niho.melonpan.tileentity.TileEntityManaita;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityRegisterer {
    public static void RegisterTileEntity() {
        GameRegistry.registerTileEntity(TileEntityManaita.class, "tilemanaita");
    }
}
