package net.depedph.depedschoolcollectiondecoratives.datagen;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_Blocks;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_CoreItems;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_Ingredients;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class DepEd_ModelProvider extends ModelProvider {
    public DepEd_ModelProvider(PackOutput output) {
        super(output, DepEDSchoolCollectionDecoratives.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        //core items
        itemModels.generateFlatItem(DepEd_CoreItems.DEPED_CORE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DepEd_CoreItems.GMATHS_CORE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DepEd_CoreItems.GMANHS_CORE.get(), ModelTemplates.FLAT_ITEM);

        //raw mats
        itemModels.generateFlatItem(DepEd_Ingredients.RAW_DEPED.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DepEd_Ingredients.RAW_GMATHS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DepEd_Ingredients.RAW_GMANHS.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(DepEd_Ingredients.DEPED_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DepEd_Ingredients.GMATHS_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DepEd_Ingredients.GMANHS_INGOT.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(DepEd_Ingredients.DEPED_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DepEd_Ingredients.GMATHS_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DepEd_Ingredients.GMANHS_NUGGET.get(), ModelTemplates.FLAT_ITEM);

        //blocks
        blockModels.createTrivialCube(DepEd_Blocks.DEPED_BLOCK.get());
        blockModels.createTrivialCube(DepEd_Blocks.GMATHS_BLOCK.get());
        blockModels.createTrivialCube(DepEd_Blocks.GMANHS_BLOCK.get());

        //ores

        //wooden blocks
    }
}
