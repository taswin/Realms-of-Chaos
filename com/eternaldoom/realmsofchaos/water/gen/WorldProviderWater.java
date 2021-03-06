package com.eternaldoom.realmsofchaos.water.gen;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

import com.eternaldoom.realmsofchaos.RealmsOfChaos;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderWater extends WorldProvider{

	@Override
	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerHell(RealmsOfChaos.waterBiome, 0.8f);
		this.dimensionId = RealmsOfChaos.waterDimID;
	}
	
	public IChunkProvider createChunkGenerator()
    {
        return new ChunkProviderWater(worldObj, worldObj.getSeed(), true);
    }
	
	@SideOnly(Side.CLIENT)
    public float getCloudHeight()
    {
        return 225;
    }
	
	@Override
	public String getDimensionName() {
		return "Water"; //TODO: find a decent name for the dimension
	}
	
	@Override
	public boolean canRespawnHere(){
		return false;
	}
}
