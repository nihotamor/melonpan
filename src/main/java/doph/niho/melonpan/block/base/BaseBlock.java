package doph.niho.melonpan.block.base;

import doph.niho.melonpan.creativetab.CreativeTabsMelonpan;
import doph.niho.melonpan.system.Define;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**BaseBlockクラスについて
*
* Block 通常のブロック。
* BlockBasePressurePlate 感圧板
* BlockBreakable ガラス、氷、ポータルなど
* BlockBush 植物系
* BlockButton ボタン
* BlockContainer インベントリなど
* BlockCrops 作物
* BlockDirection 向きのあるブロック
* BlockFalling 落下するブロック
* BlockLiquid 液体
* BlockOre 鉱石
* BlockRailBase レール
*/

public class BaseBlock extends Block {

    public BaseBlock(Material materialIn) {
        super(materialIn);
        this.setCreativeTab(CreativeTabsMelonpan.melonpanBlock);
    }

    @Override
    public Block setUnlocalizedName(String name) {
        super.setUnlocalizedName(Define.MODID + '.' + name);
        return this;
    }

    public String getUnlocalizedName(int meta) {
        return getUnlocalizedName();
    }

    public int getMetadata(int damage) {
        return damage;
    }
}
