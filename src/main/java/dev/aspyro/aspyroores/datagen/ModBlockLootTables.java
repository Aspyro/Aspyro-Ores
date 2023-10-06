package dev.aspyro.aspyroores.datagen;

import dev.aspyro.aspyroores.block.ModBlocks;
import dev.aspyro.aspyroores.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    private static final LootItemCondition.Builder HAS_IRON_HAMMER =
            MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModItems.IRON_HAMMER.get()));
    private static final LootItemCondition.Builder HAS_ASPYRIUM_HAMMER =
            MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModItems.ASPYRIUM_HAMMER.get()));
    private static final LootItemCondition.Builder HAS_DIAMOND_HAMMER =
            MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModItems.DIAMOND_HAMMER.get()));
    private static final LootItemCondition.Builder HAS_NETHERITE_HAMMER =
            MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModItems.NETHERITE_HAMMER.get()));

    private static final LootItemCondition.Builder HAS_NO_HAMMER =
            HAS_IRON_HAMMER.or(HAS_ASPYRIUM_HAMMER)
                    .or(HAS_DIAMOND_HAMMER)
                    .or(HAS_NETHERITE_HAMMER)
                    .invert();

    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        add(ModBlocks.ASPYRIUM_ORE.get(), block ->
                   LootTable.lootTable()
                           .withPool(LootPool.lootPool()
                                   .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                                   .setRolls(ConstantValue.exactly(1.0F))
                                   .add(LootItem.lootTableItem(
                                           ModItems.RAW_ASPYRIUM.get()).setWeight(15)
                                           )
                                   .add(LootItem.lootTableItem(
                                           ModItems.ASPYRIUM_DUST.get()).setWeight(50)
                                           )
                                   .add(LootItem.lootTableItem(Items.AIR).setWeight(35))
                                   .when(HAS_IRON_HAMMER)
                           )
                           .withPool(LootPool.lootPool()
                                   .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                                   .setRolls(ConstantValue.exactly(1.0F))
                                   .add(LootItem.lootTableItem(ModItems.RAW_ASPYRIUM.get())
                                           .setWeight(20)
                                           )
                                   .add(LootItem.lootTableItem((ModItems.ASPYRIUM_DUST.get()))
                                           .setWeight(60)
                                           )
                                   .add(LootItem.lootTableItem(Items.AIR)
                                           .setWeight(20))
                                   .when(HAS_ASPYRIUM_HAMMER)
                           )
                           .withPool(LootPool.lootPool()
                                   .setRolls(ConstantValue.exactly(1.0F))
                                   .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                                   .add(LootItem.lootTableItem(ModItems.RAW_ASPYRIUM.get())
                                           .setWeight(25)
                                           )
                                   .add(LootItem.lootTableItem(ModItems.ASPYRIUM_DUST.get())
                                           .setWeight(70)
                                   )
                                   .add(LootItem.lootTableItem(Items.AIR)
                                           .setWeight(5))
                                   .when(HAS_DIAMOND_HAMMER)
                           )
                           .withPool(LootPool.lootPool()
                                   .setRolls(ConstantValue.exactly(1.0F))
                                   .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                                   .add(LootItem.lootTableItem(ModItems.RAW_ASPYRIUM.get())
                                           .setWeight(18)
                                           )
                                   .add(LootItem.lootTableItem(ModItems.ASPYRIUM_DUST.get())
                                           .setWeight(80))
                                   .add(LootItem.lootTableItem(Items.AIR)
                                           .setWeight(2))
                                   .when(HAS_NETHERITE_HAMMER)
                           )
                           .withPool(LootPool.lootPool()
                                   .setRolls(ConstantValue.exactly(0.1F))
                                   .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                                   .add(LootItem.lootTableItem(ModItems.RAW_ASPYRIUM.get())
                                           .setWeight(18)
                                           )
                                   .add(LootItem.lootTableItem(ModItems.ASPYRIUM_DUST.get())
                                           .setWeight(80))
                                   .add(LootItem.lootTableItem(Items.AIR)
                                           .setWeight(2))
                                   .when(HAS_NETHERITE_HAMMER)
                           )
                           .withPool(LootPool.lootPool()
                                   .setRolls(ConstantValue.exactly(1.0F))
                                   .add(LootItem.lootTableItem(ModItems.RAW_ASPYRIUM.get())
                                       .setWeight(100)
                                           .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                                   )
                                   .when(HAS_NO_HAMMER)
                           )
        );
        //add(ModBlocks.ASPYRIUM_ORE.get(), block -> createOreDrop(ModBlocks.ASPYRIUM_ORE.get(), ModItems.RAW_ASPYRIUM.get()));
        add(ModBlocks.SINJ_ORE.get(), block -> createOreDrop(ModBlocks.SINJ_ORE.get(), ModItems.SINJ_GEM.get()));
        add(ModBlocks.QUIXELAN_ORE.get(), block -> createOreDrop(ModBlocks.QUIXELAN_ORE.get(), ModItems.QUIXELAN_GEM.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
