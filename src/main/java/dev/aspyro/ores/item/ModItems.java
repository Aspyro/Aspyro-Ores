package dev.aspyro.ores.item;

import dev.aspyro.ores.Ores;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Ores.MOD_ID);

    public static final RegistryObject<Item> ASPYRIUM_INGOT = ITEMS.register("aspyrium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ASPYRIUM_COMPOUND = ITEMS.register("aspyrium_compound",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
