package dev.aspyro.ores.datagen;

import dev.aspyro.ores.Ores;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ores.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}