package gvclib.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerSoldierArmor extends LayerArmorBase<ModelBiped>
{
	float size;
	float armorsize;
    public LayerSoldierArmor(RenderLivingBase<?> rendererIn)
    {
        super(rendererIn);
        //this.size = size;
        //this.armorsize = armorsize;
    }

    protected void initArmor()
    {
        //this.modelLeggings = new ModelSoldier(this.size, false);
        //this.modelArmor = new ModelSoldier(this.armorsize, false);
    	this.modelLeggings = new ModelSoldier(0.5F, false);
        this.modelArmor = new ModelSoldier(1.0F, false);
    }

    @SuppressWarnings("incomplete-switch")
    protected void setModelSlotVisible(ModelBiped p_188359_1_, EntityEquipmentSlot slotIn)
    {
        this.setModelVisible(p_188359_1_);

        switch (slotIn)
        {
            case HEAD:
                p_188359_1_.bipedHead.showModel = true;
                p_188359_1_.bipedHeadwear.showModel = true;
                break;
            case CHEST:
                p_188359_1_.bipedBody.showModel = true;
                p_188359_1_.bipedRightArm.showModel = true;
                p_188359_1_.bipedLeftArm.showModel = true;
                break;
            case LEGS:
                p_188359_1_.bipedBody.showModel = true;
                p_188359_1_.bipedRightLeg.showModel = true;
                p_188359_1_.bipedLeftLeg.showModel = true;
                break;
            case FEET:
                p_188359_1_.bipedRightLeg.showModel = true;
                p_188359_1_.bipedLeftLeg.showModel = true;
        }
    }

    protected void setModelVisible(ModelBiped model)
    {
        model.setVisible(false);
    }

    /*@Override
    protected ModelBiped getArmorModelHook(net.minecraft.entity.EntityLivingBase entity, net.minecraft.item.ItemStack itemStack, EntityEquipmentSlot slot, ModelBiped model)
    {
        return net.minecraftforge.client.ForgeHooksClient.getArmorModel(entity, itemStack, slot, model);
    }*/
}