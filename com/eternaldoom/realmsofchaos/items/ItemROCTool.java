package com.eternaldoom.realmsofchaos.items;

import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.eternaldoom.realmsofchaos.ROCTabs;
import com.google.common.collect.Multimap;

public class ItemROCTool extends ItemTool
{
    private Set breakableSet;
    protected float efficiencyOnProperMaterial = 4.0F;
    private float damageVsEntity;
    public ROCItems.ToolMaterial toolMaterial;

    public ItemROCTool(float attackDamage, ROCItems.ToolMaterial material, Set breaks, String name, boolean vanilla) {
    	super(attackDamage, ToolMaterial.STONE, breaks);
    	setUnlocalizedName(name);
        this.toolMaterial = material;
        this.breakableSet = breaks;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.efficiencyOnProperMaterial = material.getEfficiency();
        this.damageVsEntity = attackDamage;
        toolMaterial = material;
        if(!vanilla) setCreativeTab(CreativeTabs.tabBlock/*ROCTabs.Tools*/); else setCreativeTab(null);
        if (this instanceof ItemROCPickaxe)
        {
            toolClass = "pickaxe";
        }
        else if (this instanceof ItemROCAxe)
        {
            toolClass = "axe";
        }
        else if (this instanceof ItemROCShovel)
        {
            toolClass = "shovel";
        }
    }
    
    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
    	if(item.getMaxDamage() == -1){
    		infoList.add(EnumChatFormatting.BLUE + "Infinite Uses");
    	}
    	else{
    		infoList.add(EnumChatFormatting.GREEN + "" + (item.getMaxDamage() - item.getItemDamage()) + " Uses Remaining");
    	}
        
        infoList.add(EnumChatFormatting.RED + "" + this.toolMaterial.getEfficiency() + " Efficiency");
        
		if (this instanceof ItemROCPickaxe) infoList.add(EnumChatFormatting.DARK_RED + "" + Math.round((toolMaterial.getAttackDamage() + 4.0f)/4 + 1) + " Attack Damage");
		if (this instanceof ItemROCAxe) infoList.add(EnumChatFormatting.DARK_RED + "" + Math.round((toolMaterial.getAttackDamage() + 4.0f)/4 + 1) + " Attack Damage");
		if (this instanceof ItemROCShovel) infoList.add(EnumChatFormatting.DARK_RED + "" + Math.round((toolMaterial.getAttackDamage() + 4.0f)/5 + 1) + " Attack Damage");
    }
    
    @Override
    public float getStrVsBlock(ItemStack p_150893_1_, Block p_150893_2_) {
        return this.breakableSet.contains(p_150893_2_) ? this.efficiencyOnProperMaterial : 1.0F;
    }

    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, BlockPos pos, EntityLivingBase p_150894_7_) {
        if ((double)p_150894_3_.getBlockHardness(p_150894_2_, pos) != 0.0D)
        {
            p_150894_1_.damageItem(1, p_150894_7_);
        }

        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    public ROCItems.ToolMaterial getNewToolMaterial() {
        return this.toolMaterial;
    }
    
    @Override
    public Item.ToolMaterial getToolMaterial() {
        return Item.ToolMaterial.STONE;
    }

    
    @Override
    public int getItemEnchantability(){
        return this.toolMaterial.getEnchantability();
    }

    public String getToolMaterialName() {
        return this.toolMaterial.toString();
    }

    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
        return this.toolMaterial.getItemForRepair() == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    @Override
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Tool modifier", (double)this.damageVsEntity, 0));
        return multimap;
    }
    
    private String toolClass;
    
    /*@Override
    public int getHarvestLevel(ItemStack stack, String toolClass)
    {
        int level = super.getHarvestLevel(stack, toolClass);
        if (level == -1 && toolClass != null && toolClass.equals(this.toolClass))
        {
            return this.toolMaterial.getHarvestLevel();
        }
        else
        {
            return level;
        }
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack)
    {
        return toolClass != null ? ImmutableSet.of(toolClass) : super.getToolClasses(stack);
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta)
    {
        if (ForgeHooks.isToolEffective(stack, block, meta))
        {
            return efficiencyOnProperMaterial;
        }
        return super.getDigSpeed(stack, block, meta);
    }*/
}