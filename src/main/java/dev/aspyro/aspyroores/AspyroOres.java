package dev.aspyro.aspyroores;

import com.mojang.logging.LogUtils;
import dev.aspyro.aspyroores.block.ModBlocks;
import dev.aspyro.aspyroores.item.ModCreativeModeTabs;
import dev.aspyro.aspyroores.item.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AspyroOres.MOD_ID)
public class AspyroOres
{
    public static final String MOD_ID = "aspyroores";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public AspyroOres()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if(event.getTab() == ModCreativeModeTabs.ORES_CREATIVE_TAB)
        {
            event.accept(ModBlocks.ASPYRIUM_ORE);
            event.accept(ModItems.RAW_ASPYRIUM);
            event.accept(ModItems.ASPYRIUM_DUST);
            event.accept(ModItems.ASPYRIUM_COMPOUND);
            event.accept(ModItems.ASPYRIUM_INGOT);

            event.accept(ModBlocks.SINJ_ORE);
            event.accept(ModItems.SINJ_GEM);

            event.accept(ModBlocks.QUIXELAN_ORE);
            event.accept(ModItems.QUIXELAN_GEM);

        }

        if(event.getTab() == ModCreativeModeTabs.TOOLS_CREATIVE_TAB) {
            event.accept(ModItems.IRON_HAMMER);
            event.accept(ModItems.ASPYRIUM_HAMMER);
            event.accept(ModItems.DIAMOND_HAMMER);
            event.accept(ModItems.NETHERITE_HAMMER);

            event.accept(ModItems.ASPYRIUM_SHOVEL);
            event.accept(ModItems.ASPYRIUM_PICKAXE);
            event.accept(ModItems.ASPYRIUM_AXE);
            event.accept(ModItems.ASPYRIUM_HOE);
            event.accept(ModItems.ASPYRIUM_SWORD);

            event.accept(ModItems.IRON_CHESTPLATE_WITH_SINJ_GEM);
            event.accept(ModItems.GOLD_CHESTPLATE_WITH_SINJ_GEM);
            event.accept(ModItems.DIAMOND_CHESTPLATE_WITH_SINJ_GEM);
            event.accept(ModItems.NETHERITE_CHESTPLATE_WITH_SINJ_GEM);
        }

        if(event.getTab() == ModCreativeModeTabs.MISC_CREATIVE_TAB) {
            event.accept(ModItems.ASPYRIUM_STICK);
        }

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
