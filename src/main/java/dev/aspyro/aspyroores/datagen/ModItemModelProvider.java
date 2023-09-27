package dev.aspyro.aspyroores.datagen;

import dev.aspyro.aspyroores.AspyroOres;
import dev.aspyro.aspyroores.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AspyroOres.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ASPYRIUM_COMPOUND);
        simpleItem(ModItems.ASPYRIUM_DUST);
        simpleItem(ModItems.ASPYRIUM_INGOT);
        simpleItem(ModItems.ASPYRIUM_STICK);
        simpleItem(ModItems.RAW_ASPYRIUM);
        simpleItem(ModItems.SINJ_GEM);
        simpleItem(ModItems.QUIXELAN_GEM);

        handheldItem(ModItems.ASPYRIUM_AXE);
        handheldItem(ModItems.ASPYRIUM_HAMMER);
        handheldItem(ModItems.ASPYRIUM_HOE);
        handheldItem(ModItems.ASPYRIUM_PICKAXE);
        handheldItem(ModItems.ASPYRIUM_SHOVEL);
        handheldItem(ModItems.ASPYRIUM_SWORD);
        handheldItem(ModItems.IRON_HAMMER);
        handheldItem(ModItems.DIAMOND_HAMMER);
        handheldItem(ModItems.NETHERITE_HAMMER);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AspyroOres.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(AspyroOres.MOD_ID, "item/" + item.getId().getPath()));
    }
}
