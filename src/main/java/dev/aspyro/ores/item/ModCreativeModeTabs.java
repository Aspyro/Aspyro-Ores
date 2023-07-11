package dev.aspyro.ores.item;

import dev.aspyro.ores.Ores;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ores.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {

    public static CreativeModeTab ASPYRO_ORES_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        ASPYRO_ORES_TAB = event.registerCreativeModeTab(new ResourceLocation(Ores.MOD_ID, "aspyro_ores_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.ASPYRIUM_INGOT.get()))
                        .title(Component.translatable("creativemodetab.aspyro_ores_tab")));
    }
}
