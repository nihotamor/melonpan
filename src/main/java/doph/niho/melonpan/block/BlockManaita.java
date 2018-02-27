package doph.niho.melonpan.block;

import doph.niho.melonpan.block.base.BaseManaita;
import doph.niho.melonpan.system.Define;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockManaita extends BaseManaita implements ITileEntityProvider {

	public static final PropertyEnum<BlockManaita.EnumType> VARIANT = PropertyEnum.<BlockManaita.EnumType>create("meta",
			BlockManaita.EnumType.class);

	public BlockManaita() {
		super(Material.WOOD);
		this.setRegistryName(new ResourceLocation(Define.MODID, "manaita"));
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(VARIANT,
				BlockManaita.EnumType.OAK));
	}

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return super.createNewTileEntity(world, meta);
    }

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
		return enumfacing.getAxis() == EnumFacing.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		IBlockState down = worldIn.getBlockState(pos.down());
		return super.canPlaceBlockAt(worldIn, pos) && (down.isTopSolid() || down.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID);
	}

    public String getUnlocalizedName(ItemStack item) {
        return BlockManaita.EnumType.byMetadata(item.getMetadata()).getUnlocalizedName();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (BlockManaita.EnumType blockmanaita$enumtype : BlockManaita.EnumType.values()) {
            items.add(new ItemStack(this, 1, blockmanaita$enumtype.getMetadata()));
        }
    }

	@Override
	@SuppressWarnings("deprecation")
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		EnumFacing enumfacing = placer.getHorizontalFacing().rotateY();

		try {
			return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer)
					.withProperty(FACING, enumfacing).withProperty(VARIANT, BlockManaita.EnumType.byMetadata(meta));
		} catch (IllegalArgumentException var11) {
			if (!worldIn.isRemote) {
				if (placer instanceof EntityPlayer) {
					placer.sendMessage(new TextComponentTranslation(
							"Invalid damage property. Please pick in [0, 1, 2, 3]", new Object[0]));
				}
			}
			return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer)
					.withProperty(FACING, enumfacing).withProperty(VARIANT, BlockManaita.EnumType.OAK);
		}
	}

	@Override
	public int damageDropped(IBlockState state) {
		return ((BlockManaita.EnumType) state.getValue(VARIANT)).getMetadata();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 4)).withProperty(VARIANT,
				BlockManaita.EnumType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
		i = i | ((BlockManaita.EnumType) state.getValue(VARIANT)).getMetadata();
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, VARIANT });
	}

	public static enum EnumType implements IStringSerializable {
		OAK(0, "oak"), SPRUCE(1, "spruce"), BIRCH(2, "birch"), JUNGLE(3, "jungle");

		private static final BlockManaita.EnumType[] META_LOOKUP = new BlockManaita.EnumType[values().length];
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

		public static BlockManaita.EnumType byMetadata(int meta) {
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
			for (BlockManaita.EnumType blockmanaita$enumtype : values()) {
				META_LOOKUP[blockmanaita$enumtype.getMetadata()] = blockmanaita$enumtype;
			}
		}
	}
}
