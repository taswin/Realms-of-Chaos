package com.eternaldoom.realmsofchaos.water.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

import com.eternaldoom.realmsofchaos.entity.EntityGiantFish;
import com.eternaldoom.realmsofchaos.entity.EntityKelpFish;

public class BiomeGenWater extends BiomeGenBase
{
    private static final String __OBFID = "CL_00000179";

    public BiomeGenWater(int id)
    {
        super(id);
        this.spawnableWaterCreatureList.clear();
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityGiantFish.class, 10, 2, 3));
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityKelpFish.class, 1, 2, 3));
    }

    @Override
    public BiomeGenBase.TempCategory getTempCategory()
    {
        return BiomeGenBase.TempCategory.OCEAN;
    }

    public void genTerrainBlocks(World p_150573_1_, Random p_150573_2_, ChunkPrimer p_150573_3_, int p_150573_5_, int p_150573_6_, double p_150573_7_)
    {
        super.genTerrainBlocks(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_5_, p_150573_6_, p_150573_7_);
    }
    
    public BiomeGenWater setColor(int color){
		return (BiomeGenWater) super.setColor(color);
    }
    
    public BiomeGenWater setBiomeName(String name){
    	return (BiomeGenWater) super.setBiomeName(name);
    }
    
    public BiomeGenWater setTheHeight(BiomeGenBase.Height h){
    	return (BiomeGenWater) super.setHeight(h);
    }
}