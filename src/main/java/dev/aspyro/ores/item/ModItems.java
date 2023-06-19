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

    // RESOURCES
    public static final RegistryObject<Item> ASPYRIUM_INGOT = ITEMS.register("aspyrium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ASPYRIUM_COMPOUND = ITEMS.register("aspyrium_compound",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASPYRIUM_DUST = ITEMS.register("aspyrium_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ASPYRIUM = ITEMS.register("raw_aspyrium",
            () -> new Item(new Item.Properties()));

    // TOOLS

    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASPYRIUM_HAMMER = ITEMS.register("aspyrium_hammer",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_HAMMER = ITEMS.register("netherite_hammer",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASPYRIUM_STICK = ITEMS.register("aspyrium_stick",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASPYRIUM_AXE = ITEMS.register("aspyrium_axe",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASPYRIUM_PICKAXE = ITEMS.register("aspyrium_pickaxe",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASPYRIUM_HOE = ITEMS.register("aspyrium_hoe",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASPYRIUM_SHOVEL = ITEMS.register("aspyrium_shovel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASPYRIUM_SWORD = ITEMS.register("aspyrium_sword",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
