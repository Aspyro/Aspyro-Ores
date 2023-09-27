package dev.aspyro.aspyroores.datagen;

import dev.aspyro.aspyroores.block.ModBlocks;
import dev.aspyro.aspyroores.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        add(ModBlocks.ASPYRIUM_ORE.get(), block -> createOreDrop(ModBlocks.ASPYRIUM_ORE.get(), ModItems.RAW_ASPYRIUM.get()));
        add(ModBlocks.SINJ_ORE.get(), block -> createOreDrop(ModBlocks.SINJ_ORE.get(), ModItems.SINJ_GEM.get()));
        add(ModBlocks.QUIXELAN_ORE.get(), block -> createOreDrop(ModBlocks.QUIXELAN_ORE.get(), ModItems.QUIXELAN_GEM.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
