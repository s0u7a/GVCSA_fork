package gvclib.item;

import gvclib.network.GVCLClientMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.mod_GVCLib;
public class ItemGun_AR extends ItemGunBase {
	public ItemGun_AR() {
		super();
		this.maxStackSize = 1;
	}

	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		EntityPlayer entityplayer = (EntityPlayer) entity;
		int s;
		int li = getMaxDamage() - itemstack.getItemDamage();
		boolean lflag = cycleBolt(itemstack);
		boolean lflag_barst = cycleBrast(itemstack);
		boolean var5 = entityplayer.capabilities.isCreativeMode|| EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, itemstack) > 0;
		Item item = itemstack.getItem();
		NBTTagCompound nbt = itemstack.getTagCompound();
		
		if(itemstack.hasTagCompound()) {
			this.gunbase_recoil(itemstack, world, entity, i, flag, 0);
			this.gunbase_reload(itemstack, world, entity, i, flag);
			this.gunbase_lockon(itemstack, world, entity, i, flag);
		}
		
		boolean gethand = false;
		if(itemstack == entityplayer.getHeldItemOffhand()) {
			gethand = true;
		}else if(flag){
			gethand = true;
		}
		if (gethand) {//开枪时身体后退
			entityplayer.motionX = entityplayer.motionX * this.motion;
			//entityplayer.motionY = entityplayer.motionY * 0.1;
			entityplayer.motionZ = entityplayer.motionZ * this.motion;
		}
		
		if (!itemstack.isEmpty() && entityplayer != null) {//配件判定
			if(itemstack.getItem() instanceof ItemGunBase) {
				ItemGunBase gun = (ItemGunBase) itemstack.getItem();
				this.Attachment(gun, itemstack, world, entityplayer, i, flag);
			}
		}
		//this.Fire_AR(itemstack, world, entityplayer, li, flag);
		super.onUpdate(itemstack, world, entity, i, flag);
	}

	@Override
	public byte getCycleCount(ItemStack pItemstack) {
		return (byte) (this.cycle);
		//return (byte)this.cycle;
		//return 0;
	}

	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityLivingBase par3EntityPlayer,
			int par4) {
	}
}
