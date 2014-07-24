package com.eternaldoom.realmsofchaos.overworld.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.eternaldoom.realmsofchaos.overworld.blocks.ROCBlocks;
import com.eternaldoom.realmsofchaos.overworld.items.ROCItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class OverworldCrafting {
	
	public static void initRecipes(){
		GameRegistry.addRecipe(new ItemStack(ROCBlocks.netherrack_bricks, 4), new Object[]{"XX", "XX", 'X', Blocks.netherrack});
		GameRegistry.addRecipe(new ItemStack(ROCBlocks.charwood_planks, 4), new Object[]{"X", 'X', ROCBlocks.charwood_log});
		GameRegistry.addRecipe(new ItemStack(Blocks.crafting_table), new Object[]{"XX", "XX", 'X', ROCBlocks.charwood_planks});
		GameRegistry.addRecipe(new ItemStack(Items.stick, 4), new Object[]{"X", "X", 'X', ROCBlocks.charwood_planks});
		GameRegistry.addRecipe(new ItemStack(ROCItems.citronite_stone), new Object[]{" C ", "C C", " C ", 'C', ROCItems.citronite_gem});
		GameRegistry.addRecipe(new ItemStack(ROCItems.flame_stone), new Object[]{"ACA", "XLX", "ACA", 'A', ROCItems.ash_dust, 'C', ROCItems.citronite_stone, 'X', ROCItems.xylite_ingot, 'L', Items.lava_bucket});
		GameRegistry.addRecipe(new ItemStack(ROCBlocks.extractor), new Object[]{"CWC", "WWW", "CWC", 'C', ROCBlocks.citronite_block, 'W', ROCBlocks.charwood_log});
		GameRegistry.addRecipe(new ItemStack(ROCBlocks.citronite_block), new Object[]{"CCC", "CCC", "CCC", 'C', ROCItems.citronite_stone});
		GameRegistry.addRecipe(new ItemStack(ROCItems.citronite_stone, 9), new Object[]{"C", 'C', ROCBlocks.citronite_block});
		GameRegistry.addRecipe(new ItemStack(ROCBlocks.xylite_block), new Object[]{"XXX", "XXX", "XXX", 'X', ROCItems.xylite_ingot});
		GameRegistry.addRecipe(new ItemStack(ROCItems.xylite_ingot, 9), new Object[]{"X", 'X', ROCBlocks.xylite_block});
		
		RecipeHelper.addArmorRecipe(ROCItems.heliotrope_helmet, ROCItems.heliotrope_chestplate, ROCItems.heliotrope_leggings, ROCItems.heliotrope_boots, ROCItems.heliotrope);
		RecipeHelper.addArmorRecipe(ROCItems.citronite_helmet, ROCItems.citronite_chestplate, ROCItems.citronite_leggings, ROCItems.citronite_boots, ROCItems.citronite_gem);
		RecipeHelper.addArmorRecipe(ROCItems.xylite_helmet, ROCItems.xylite_chestplate, ROCItems.xylite_leggings, ROCItems.xylite_boots, ROCItems.xylite_ingot);
		RecipeHelper.addArmorRecipe(ROCItems.flame_helmet, ROCItems.flame_chestplate, ROCItems.flame_leggings, ROCItems.heliotrope_boots, ROCItems.flame_stone);
		
		RecipeHelper.addToolRecipe(ROCItems.heliotrope_sword, ROCItems.heliotrope_pickaxe, ROCItems.heliotrope_axe, ROCItems.heliotrope_shovel, ROCItems.heliotrope);
		RecipeHelper.addToolRecipe(ROCItems.citronite_sword, ROCItems.citronite_pickaxe, ROCItems.citronite_axe, ROCItems.citronite_shovel, ROCItems.citronite_stone);
		RecipeHelper.addToolRecipe(ROCItems.xylite_sword, ROCItems.xylite_pickaxe, ROCItems.xylite_axe, ROCItems.xylite_shovel, ROCItems.xylite_ingot);
		RecipeHelper.addToolRecipe(ROCItems.flame_sword, ROCItems.flame_pickaxe, ROCItems.flame_axe, ROCItems.flame_shovel, ROCItems.flame_stone);

    	ExtractorRecipes.addItemRecipe(ROCItems.xylite_crystal, new ItemStack(ROCItems.xylite_ingot), 10.0f);
    	
    	GameRegistry.addSmelting(ROCBlocks.heliotrope_ore, new ItemStack(ROCItems.heliotrope), 5.0f);
	}
}
