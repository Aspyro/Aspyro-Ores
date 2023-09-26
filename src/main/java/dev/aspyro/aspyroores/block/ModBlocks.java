package dev.aspyro.aspyroores.block;

import dev.aspyro.aspyroores.AspyroOres;
import dev.aspyro.aspyroores.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AspyroOres.MOD_ID);

    public static final RegistryObject<Block> ASPYRIUM_ORE = registerBlock("aspyrium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SINJ_ORE = registerBlock("sinj_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.0F).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
