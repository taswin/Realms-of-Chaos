package com.eternaldoom.realmsofchaos.overworld.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.eternaldoom.realmsofchaos.ROCTabs;

import cpw.mods.fml.common.registry.GameRegistry;
public class OverworldBlock extends Block{

	public OverworldBlock(Material mat, String tex, String name, float hard, float resist, SoundType sound) {
		super(mat);
		this.setBlockTextureName(tex);
		this.setBlockName(name);
		this.setHardness(hard);
		this.setResistance(resist);
		this.setCreativeTab(ROCTabs.OverworldBlocks);
	}
	
	public OverworldBlock register(String nam){
		GameRegistry.registerBlock(this, nam);
		return this;
	}
}
