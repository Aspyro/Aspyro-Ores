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

    public static CreativeModeTab ORES_CREATIVE_TAB;
    public static CreativeModeTab TOOLS_CREATIVE_TAB;
    public static CreativeModeTab MISC_CREATIVE_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {

        ORES_CREATIVE_TAB = event.registerCreativeModeTab(
                new ResourceLocation(Ores.MOD_ID, "aspyro_ores_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.ASPYRIUM_INGOT.get()))
                        .title(Component.translatable("creativemodetab.aspyro_ores_tab")));

        TOOLS_CREATIVE_TAB = event.registerCreativeModeTab(
                new ResourceLocation(Ores.MOD_ID, "aspyro_tools_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.ASPYRIUM_INGOT.get()))
                        .title(Component.translatable("creativemodetab.aspyro_tools_tab")));

        MISC_CREATIVE_TAB = event.registerCreativeModeTab(
                new ResourceLocation(Ores.MOD_ID, "aspyro_misc_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.ASPYRIUM_INGOT.get()))
                        .title(Component.translatable("creativemodetab.aspyro_misc_tab")));
    }
}
