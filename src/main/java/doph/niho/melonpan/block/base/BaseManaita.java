package doph.niho.melonpan.block.base;

import doph.niho.melonpan.gui.GuiID;
import doph.niho.melonpan.system.Main;
import doph.niho.melonpan.tileentity.TileEntityManaita;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BaseManaita extends BaseBlock implements ITileEntityProvider {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    protected static final AxisAlignedBB X_AXIS_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.25D, 0.9375D, 0.125D, 0.75D);
    protected static final AxisAlignedBB Z_AXIS_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.0625D, 0.75D, 0.125D, 0.9375D);

    public BaseManaita(Material material) {
        super(material);
        this.setUnlocalizedName("manaita");
        this.setHardness(0.25F);
        this.setResistance(0.5F);
        this.setSoundType(SoundType.WOOD);
        this.setLightOpacity(1);
        this.setLightLevel(0.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityManaita();
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityManaita();
    }

    /*
     * 右クリックされたときに呼ばれる
     */
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
            EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = playerIn.inventory.getCurrentItem();
        TileEntityManaita tile = (TileEntityManaita) worldIn.getTileEntity(pos);

        if (tile != null && !worldIn.isRemote) {
            if (stack.getItem() instanceof ItemSword) {
                tile.addCutCount();
            } else {
                playerIn.openGui(Main.instance, GuiID.GUI_MANAITA, worldIn, MathHelper.ceil(playerIn.posX),
                        MathHelper.ceil(playerIn.posY), MathHelper.ceil(playerIn.posZ));
            }
        }
        return true;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
        return enumfacing.getAxis() == EnumFacing.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,
            EnumFacing side) {
        return true;
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return MapColor.AIR;
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.getBlock() != this ? state
                : state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
    }
}
