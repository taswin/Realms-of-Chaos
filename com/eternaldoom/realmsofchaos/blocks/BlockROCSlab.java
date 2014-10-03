package com.eternaldoom.realmsofchaos.blocks;

import java.util.List;
import java.util.Random;

import com.eternaldoom.realmsofchaos.ROCTabs;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockROCSlab extends BlockSlab
{
    public BlockROCSlab(Material mat, String name)
    {
        super(mat);
        IBlockState iblockstate = this.blockState.getBaseState();

        iblockstate = iblockstate.withProperty(HALF_PROP, BlockSlab.EnumBlockHalf.BOTTOM);
        setUnlocalizedName(name);
        setCreativeTab(ROCTabs.Blocks);
    }

    @Override
    public String getFullSlabName(int p_150002_1_)
    {
        return super.getUnlocalizedName();
    }

    @Override
    public Object func_176553_a(ItemStack p_176553_1_)
    {
        return null;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
     
    	IBlockState iblockstate = this.getDefaultState().withProperty(HALF_PROP, (meta) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);

        return iblockstate;
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return super.getMetaFromState(state);
    }

    @Override
    protected BlockState createBlockState()
    {
        return this.isDouble() ? new BlockState(this, new IProperty[] {}): new BlockState(this, new IProperty[] {HALF_PROP});
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }
}