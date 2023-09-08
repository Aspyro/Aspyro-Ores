package dev.aspyro.ores.item.custom;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

import javax.annotation.Nonnull;

public class HammerItem extends PickaxeItem {
    public HammerItem(Tier tier, int itemDamageBaseline, float attackSpeedModifier, Properties properties) {
        super(tier, itemDamageBaseline, attackSpeedModifier, properties);
    }

    @Override
    public ItemStack getCraftingRemainingItem(@Nonnull ItemStack stack) {
        ItemStack container = stack.copy();
        if(container.hurt(1, RandomSource.createNewThreadLocalInstance(), null)) {
            return ItemStack.EMPTY;
        }
        else {
            return container;
        }
    }

    @Override
    public boolean hasCraftingRemainingItem(@Nonnull ItemStack stack)
    {
        return true;
    }
}
