package user11681.limitless.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ItemStack.class, priority = 500)
public abstract class ItemStackMixin {
    @Redirect(method = "addEnchantment", at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/CompoundTag;putShort(Ljava/lang/String;S)V"))
    protected void removeLimit(final CompoundTag compoundTag, final String key, final short value, final Enchantment enchantment, final int level) {
        compoundTag.putInt("lvl", level);
    }
}
