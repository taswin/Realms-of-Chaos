package com.eternaldoom.realmsofchaos.client.blockrenderers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLLog;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.eternaldoom.realmsofchaos.blocks.BlockFrozenChest;
import com.eternaldoom.realmsofchaos.blocks.TileEntityFrozenChest;

public class RenderFrozenChest extends TileEntitySpecialRenderer
{
    private static final ResourceLocation doubletex = new ResourceLocation("realmsofchaos:textures/tileentity/chest/frozen_double.png");
    private static final ResourceLocation singletex = new ResourceLocation("realmsofchaos:textures/tileentity/chest/frozen.png");
    private ModelTransparentChest singlemodel = new ModelTransparentChest();
    private ModelTransparentChest doublemodel = new ModelTransparentDoubleChest();
    private boolean field_147509_j;

    public RenderFrozenChest(){}

    public void renderTileEntityAt(TileEntityFrozenChest tile, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
    {
        int i;

        if (!tile.hasWorldObj())
        {
            i = 0;
        }
        else
        {
            Block block = tile.getBlockType();
            i = tile.getBlockMetadata();

            if (block instanceof BlockFrozenChest && i == 0)
            {
                try
                {
                ((BlockFrozenChest)block).func_149954_e(tile.getWorld(), tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ());
                }
                catch (ClassCastException e)
                {
                    FMLLog.severe("Attempted to render a Frozen chest at %d,  %d, %d that was not a Frozen chest. That is a bug.", tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ());
                }
                i = tile.getBlockMetadata();
            }

            tile.checkForAdjacentChests();
        }

        if (tile.adjacentChestZNeg == null && tile.adjacentChestXNeg == null)
        {
            ModelTransparentChest modelchest;

            if (tile.adjacentChestXPos == null && tile.adjacentChestZPos == null)
            {
                modelchest = this.singlemodel;

                this.bindTexture(singletex);
            }
            else
            {
                modelchest = this.doublemodel;

                this.bindTexture(doubletex);
            }

            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float)p_147500_2_, (float)p_147500_4_ + 1.0F, (float)p_147500_6_ + 1.0F);
            GL11.glScalef(1.0F, -1.0F, -1.0F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            short short1 = 0;

            if (i == 2)
            {
                short1 = 180;
            }

            if (i == 3)
            {
                short1 = 0;
            }

            if (i == 4)
            {
                short1 = 90;
            }

            if (i == 5)
            {
                short1 = -90;
            }

            if (i == 2 && tile.adjacentChestXPos != null)
            {
                GL11.glTranslatef(1.0F, 0.0F, 0.0F);
            }

            if (i == 5 && tile.adjacentChestZPos != null)
            {
                GL11.glTranslatef(0.0F, 0.0F, -1.0F);
            }

            GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float f1 = tile.prevLidAngle + (tile.lidAngle - tile.prevLidAngle) * p_147500_8_;
            float f2;

            if (tile.adjacentChestZNeg != null)
            {
                f2 = tile.adjacentChestZNeg.prevLidAngle + (tile.adjacentChestZNeg.lidAngle - tile.adjacentChestZNeg.prevLidAngle) * p_147500_8_;

                if (f2 > f1)
                {
                    f1 = f2;
                }
            }

            if (tile.adjacentChestXNeg != null)
            {
                f2 = tile.adjacentChestXNeg.prevLidAngle + (tile.adjacentChestXNeg.lidAngle - tile.adjacentChestXNeg.prevLidAngle) * p_147500_8_;

                if (f2 > f1)
                {
                    f1 = f2;
                }
            }

            f1 = 1.0F - f1;
            f1 = 1.0F - f1 * f1 * f1;
            modelchest.chestLid.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
            modelchest.renderAll();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_, int idk)
    {
        this.renderTileEntityAt((TileEntityFrozenChest)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
    }
}