package doph.niho.melonpan.block;

import doph.niho.melonpan.block.base.BaseManaita;
import doph.niho.melonpan.system.Define;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class BlockManaita2 extends BaseManaita implements ITileEntityProvider {
	public static final PropertyEnum<BlockManaita2.EnumType> VARIANT = PropertyEnum.<BlockManaita2.EnumType>create("meta",
			BlockManaita2.EnumType.class);

	public BlockManaita2() {
		super(Material.WOOD);
		this.setRegistryName(new ResourceLocation(Define.MODID, "manaita2"));
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockManaita2.EnumType.ACACIA));
	}

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return super.createNewTileEntity(world, meta);
    }

	@Override
	@SuppressWarnings("deprecation")
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		EnumFacing enumfacing = placer.getHorizontalFacing().rotateY();

		try {
			return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, enumfacing).withProperty(VARIANT, BlockManaita2.EnumType.byMetadata(meta));
		} catch(IllegalArgumentException var11) {
			if(!worldIn.isRemote) {
				if(placer instanceof EntityPlayer) {
					placer.sendMessage(new TextComponentTranslation("Invalid damage property. Please pick in [0, 1]", new Object[0]));
				}
			}
			return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, enumfacing).withProperty(VARIANT, BlockManaita2.EnumType.ACACIA);
		}
	}

    public String getUnlocalizedName(ItemStack item) {
        return BlockManaita2.EnumType.byMetadata(item.getMetadata()).getUnlocalizedName();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (BlockManaita2.EnumType blockmanaita$enumtype : BlockManaita2.EnumType.values()) {
            items.add(new ItemStack(this, 1, blockmanaita$enumtype.getMetadata()));
        }
    }

	@Override
	public int damageDropped(IBlockState state) {
		return ((BlockManaita2.EnumType) state.getValue(VARIANT)).getMetadata();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 4)).withProperty(VARIANT, BlockManaita2.EnumType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
		i = i | ((BlockManaita2.EnumType)state.getValue(VARIANT)).getMetadata();
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, VARIANT });
	}

	public static enum EnumType implements IStringSerializable {
		ACACIA(0, "acacia"), DARK_OAK(1, "dark_oak");

		private static final BlockManaita2.EnumType[] META_LOOKUP = new BlockManaita2.EnumType[values().length];
		private final int meta;
		private final String name;

		private EnumType(int metaIn, String nameIn) {
			this.meta = metaIn;
			this.name = nameIn;
		}

		public int getMetadata() {
			return this.meta;
		}

		public String toString() {
			return this.name;
		}

		public static BlockManaita2.EnumType byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}
			return META_LOOKUP[meta];
		}

		public String getName() {
			return this.name;
		}

		public String getUnlocalizedName() {
			return this.name;
		}

		static {
			for (BlockManaita2.EnumType blockmanaita$enumtype : values()) {
				META_LOOKUP[blockmanaita$enumtype.getMetadata()] = blockmanaita$enumtype;
			}
		}
	}
}
