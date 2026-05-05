package net.depedph.depedschoolcollectiondecoratives.datagen;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_Items;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class DepED_ModelProvider extends ModelProvider {
    public DepED_ModelProvider(PackOutput output) {
        super(output, DepEDSchoolCollectionDecoratives.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        //super.registerModels(blockModels, itemModels);

        itemModels.generateFlatItem(DepEd_Items.DEPED_CORE.get(), ModelTemplates.FLAT_ITEM);
    }
}
