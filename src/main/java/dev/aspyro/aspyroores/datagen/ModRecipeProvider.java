package dev.aspyro.aspyroores.datagen;

import dev.aspyro.aspyroores.AspyroOres;
import dev.aspyro.aspyroores.item.ModItems;
import dev.aspyro.aspyroores.util.ModTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        // Aspyrium Ingot
        SmithingTransformRecipeBuilder.smithing(Ingredient.EMPTY, Ingredient.of(Items.IRON_INGOT),
                Ingredient.of(ModItems.ASPYRIUM_COMPOUND.get()), RecipeCategory.MISC, ModItems.ASPYRIUM_INGOT.get())
                .unlocks("has_aspyrium_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.ASPYRIUM_INGOT.get()).build()))
                .save(consumer, new ResourceLocation(AspyroOres.MOD_ID, getItemName(ModItems.ASPYRIUM_INGOT.get())));

        // Aspyrium Dust
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ASPYRIUM_DUST.get(), 1)
                .requires(ModItems.RAW_ASPYRIUM.get())
                .requires(ModTags.Items.HAMMER)
                .unlockedBy("has_iron_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(Items.IRON_INGOT).build()))
                .save(consumer);

        // Aspyrium Compound
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ASPYRIUM_COMPOUND.get(), 1)
                .requires(ModItems.ASPYRIUM_DUST.get())
                .requires(Items.GLOWSTONE_DUST)
                .unlockedBy("has_iron_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(Items.IRON_INGOT).build()))
                .save(consumer);

        // Aspyrium Upgraded Sticks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ASPYRIUM_STICK.get(), 4)
                .requires(ModItems.ASPYRIUM_COMPOUND.get(), 5)
                .requires(Items.STICK, 4)
                .unlockedBy("has_planks", inventoryTrigger(ItemPredicate.Builder.item().of(ItemTags.PLANKS).build()))
                .save(consumer);

        // Iron Hammer
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_HAMMER.get())
                .define('I', Items.IRON_INGOT).define('S', Items.STICK)
                .pattern("III").pattern("ISI").pattern(" S ")
                .unlockedBy("has_iron_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(Items.IRON_INGOT).build()))
                .save(consumer);

        // Aspyrium Hammer
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ASPYRIUM_HAMMER.get())
                .define('A', ModItems.ASPYRIUM_INGOT.get()).define('I', Items.IRON_INGOT).define('S', Items.STICK)
                .pattern("AIA").pattern("ASA").pattern(" S ")
                .unlockedBy("has_aspyrium_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.ASPYRIUM_INGOT.get()).build()))
                .save(consumer);

        // Diamond Hammer
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_HAMMER.get())
                .define('A', ModItems.ASPYRIUM_INGOT.get()).define('D', Items.DIAMOND).define('S', Items.STICK)
                .pattern("ADA").pattern("ASA").pattern(" S ")
                .unlockedBy("has_aspyrium_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.ASPYRIUM_INGOT.get()).build()))
                .unlockedBy("has_diamond", inventoryTrigger(ItemPredicate.Builder.item().of(Items.DIAMOND).build()))
                .save(consumer);

        // Netherite Hammer
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NETHERITE_HAMMER.get())
                .define('D', Items.DIAMOND).define('N', Items.NETHERITE_INGOT).define('S', ModItems.ASPYRIUM_STICK.get())
                .pattern("NDN").pattern("DSD").pattern(" S ")
                .unlockedBy("has_netherite_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(Items.NETHERITE_INGOT).build()))
                .save(consumer);

        // Aspyrium Axe
        axe(consumer, ModItems.ASPYRIUM_AXE.get(), ModItems.ASPYRIUM_INGOT.get());

        // Aspyrium Hoe
        hoe(consumer, ModItems.ASPYRIUM_HOE.get(), ModItems.ASPYRIUM_INGOT.get());

        // Aspyrium Pickaxe
        pickaxe(consumer, ModItems.ASPYRIUM_PICKAXE.get(), ModItems.ASPYRIUM_INGOT.get());

        // Aspyrium Shovel
        shovel(consumer, ModItems.ASPYRIUM_SHOVEL.get(), ModItems.ASPYRIUM_INGOT.get());

        // Aspyrium Sword
        sword(consumer, ModItems.ASPYRIUM_SWORD.get(), ModItems.ASPYRIUM_INGOT.get());
    }

    protected static void pickaxe(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .define('M', material)
                .define('S', Items.STICK)
                .pattern("MMM")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_" + getItemName(material),
                        inventoryTrigger(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer);
    }

    protected static void sword(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .define('M', material)
                .define('S', Items.STICK)
                .pattern(" M ")
                .pattern(" M ")
                .pattern(" S ")
                .unlockedBy("has_" + getItemName(material),
                        inventoryTrigger(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer);
    }

    protected static void axe(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .define('M', material)
                .define('S', Items.STICK)
                .pattern("MM ")
                .pattern("MS ")
                .pattern(" S ")
                .unlockedBy("has_" + getItemName(material),
                        inventoryTrigger(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer);
    }

    protected static void hoe(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .define('M', material)
                .define('S', Items.STICK)
                .pattern("MM ")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_" + getItemName(material),
                        inventoryTrigger(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer);
    }

    protected static void shovel(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .define('M', material)
                .define('S', Items.STICK)
                .pattern(" M ")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_" + getItemName(material),
                        inventoryTrigger(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer);
    }

}
