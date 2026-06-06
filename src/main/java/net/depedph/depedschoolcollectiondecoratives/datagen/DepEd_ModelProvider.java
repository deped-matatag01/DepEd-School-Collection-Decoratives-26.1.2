package net.depedph.depedschoolcollectiondecoratives.datagen;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_Blocks;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_OreBlocks;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_WoodenBlocks;
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

        //deped blocks
        blockModels.family(DepEd_Blocks.DEPED_BLOCK.get())
                .stairs(DepEd_Blocks.DEPED_STAIRS.get())
                .slab(DepEd_Blocks.DEPED_SLAB.get())
                .wall(DepEd_Blocks.DEPED_WALL.get())
                .button(DepEd_Blocks.DEPED_BUTTON.get())
                .pressurePlate(DepEd_Blocks.DEPED_PRESSURE_PLATE.get());

        blockModels.family(DepEd_Blocks.GMATHS_BLOCK.get())
                .stairs(DepEd_Blocks.GMATHS_STAIRS.get())
                .slab(DepEd_Blocks.GMATHS_SLAB.get())
                .wall(DepEd_Blocks.GMATHS_WALL.get())
                .button(DepEd_Blocks.GMATHS_BUTTON.get())
                .pressurePlate(DepEd_Blocks.GMATHS_PRESSURE_PLATE.get());

        blockModels.createTrivialCube(DepEd_Blocks.GMANHS_BLOCK.get());

        //deped decorative blocks
        blockModels.createTrivialCube(DepEd_Blocks.THE_GMATHS_TORCH.get());
        blockModels.createTrivialCube(DepEd_Blocks.THE_GMATHS_TORCH_MK_II.get());

        //ores and raw blocks
        blockModels.createTrivialCube(DepEd_OreBlocks.DEPED_ORE.get());
        blockModels.createTrivialCube(DepEd_OreBlocks.GMATHS_ORE.get());
        blockModels.createTrivialCube(DepEd_OreBlocks.GMANHS_ORE.get());

        blockModels.createTrivialCube(DepEd_OreBlocks.DEEPSLATE_DEPED_ORE.get());
        blockModels.createTrivialCube(DepEd_OreBlocks.DEEPSLATE_GMATHS_ORE.get());
        blockModels.createTrivialCube(DepEd_OreBlocks.DEEPSLATE_GMANHS_ORE.get());

        blockModels.createTrivialCube(DepEd_OreBlocks.RAW_DEPED_BLOCK.get());
        blockModels.createTrivialCube(DepEd_OreBlocks.RAW_GMATHS_BLOCK.get());
        blockModels.createTrivialCube(DepEd_OreBlocks.RAW_GMANHS_BLOCK.get());

        //wooden blocks
        blockModels.family(DepEd_WoodenBlocks.WHITE_OAK_PLANKS.get())
                .stairs(DepEd_WoodenBlocks.WHITE_OAK_STAIRS.get())
                .slab(DepEd_WoodenBlocks.WHITE_OAK_SLAB.get())
                .wall(DepEd_WoodenBlocks.WHITE_OAK_WALL.get())
                .fence(DepEd_WoodenBlocks.WHITE_OAK_FENCE.get())
                .fenceGate(DepEd_WoodenBlocks.WHITE_OAK_FENCE_GATE.get())
                .button(DepEd_WoodenBlocks.WHITE_OAK_BUTTON.get())
                .pressurePlate(DepEd_WoodenBlocks.WHITE_OAK_PRESSURE_PLATE.get());
    }
}
