package dev.aspyro.aspyroores.item;

import dev.aspyro.aspyroores.AspyroOres;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AspyroOres.MOD_ID);

    // RESOURCES
    public static final RegistryObject<Item> ASPYRIUM_INGOT = ITEMS.register("aspyrium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ASPYRIUM_COMPOUND = ITEMS.register("aspyrium_compound",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASPYRIUM_DUST = ITEMS.register("aspyrium_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ASPYRIUM = ITEMS.register("raw_aspyrium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SINJ_GEM = ITEMS.register("sinj_gem",
            () -> new Item(new Item.Properties()));

    // ARMORS
    public static final RegistryObject<Item> IRON_CHESTPLATE_WITH_SINJ_GEM = ITEMS.register("iron_chestplate_with_sinj_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_CHESTPLATE_WITH_SINJ_GEM = ITEMS.register("gold_chestplate_with_sinj_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_CHESTPLATE_WITH_SINJ_GEM = ITEMS.register("diamond_chestplate_with_sinj_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_CHESTPLATE_WITH_SINJ_GEM = ITEMS.register("netherite_chestplate_with_sinj_gem",
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
            () -> new AxeItem(Tiers.IRON, 6, -3.1f, new Item.Properties().durability(384)));
    public static final RegistryObject<Item> ASPYRIUM_PICKAXE = ITEMS.register("aspyrium_pickaxe",
            () -> new PickaxeItem(Tiers.IRON, 1, -2.8F, new Item.Properties().durability(384)));
    public static final RegistryObject<Item> ASPYRIUM_HOE = ITEMS.register("aspyrium_hoe",
            () -> new HoeItem(Tiers.IRON, -2, -1.0F, new Item.Properties().durability(384)));
    public static final RegistryObject<Item> ASPYRIUM_SHOVEL = ITEMS.register("aspyrium_shovel",
            () -> new ShovelItem(Tiers.IRON, 1.5F, -3F, new Item.Properties().durability(384)));
    public static final RegistryObject<Item> ASPYRIUM_SWORD = ITEMS.register("aspyrium_sword",
            () -> new SwordItem(Tiers.IRON, 3, -2.4F, new Item.Properties().durability(384)));

    public static final RegistryObject<Item> QUIXELAN_GEM = ITEMS.register("quixelan_gem",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
