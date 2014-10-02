package com.eternaldoom.realmsofchaos;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.eternaldoom.realmsofchaos.blocks.ContainerExtractor;
import com.eternaldoom.realmsofchaos.blocks.TileEntityExtractor;
import com.eternaldoom.realmsofchaos.client.GUIExtractor;

public class GUIHandler implements IGuiHandler{

	public static int guiID = 0;
    public static int extractor = guiID++;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		
		if(ID == extractor){
			return new ContainerExtractor(player.inventory, (TileEntityExtractor)entity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));

		if(ID == extractor){
			return new GUIExtractor(player.inventory, (TileEntityExtractor)entity);
		}
		return null;
	}

}