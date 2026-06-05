package net.depedph.depedschoolcollectiondecoratives.datagen;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_Blocks;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_CoreItems;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_Ingredients;
import net.depedph.depedschoolcollectiondecoratives.tags.DepEd_Tags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class DepEd_ItemTagsDataProvider extends ItemTagsProvider {
    public DepEd_ItemTagsDataProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, DepEDSchoolCollectionDecoratives.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        //Custom Tag Items
        tag(DepEd_Tags.DepEdItemTags.DEPED_INGOTS)
                .add(DepEd_Ingredients.DEPED_INGOT.get())
                .add(DepEd_Ingredients.GMATHS_INGOT.get())
                .add(DepEd_Ingredients.GMANHS_INGOT.get());
        tag(Tags.Items.INGOTS)
                .add(DepEd_Ingredients.DEPED_INGOT.get())
                .add(DepEd_Ingredients.GMATHS_INGOT.get())
                .add(DepEd_Ingredients.GMANHS_INGOT.get());

        tag(DepEd_Tags.DepEdItemTags.DEPED_NUGGETS)
                .add(DepEd_Ingredients.DEPED_NUGGET.get())
                .add(DepEd_Ingredients.GMATHS_NUGGET.get())
                .add(DepEd_Ingredients.GMANHS_NUGGET.get());
        tag(Tags.Items.NUGGETS)
                .add(DepEd_Ingredients.DEPED_NUGGET.get())
                .add(DepEd_Ingredients.GMATHS_NUGGET.get())
                .add(DepEd_Ingredients.GMANHS_NUGGET.get());

        tag(DepEd_Tags.DepEdItemTags.DEPED_RAW_MATERIALS)
                .add(DepEd_Ingredients.RAW_DEPED.get())
                .add(DepEd_Ingredients.RAW_GMATHS.get())
                .add(DepEd_Ingredients.RAW_GMANHS.get());
        tag(Tags.Items.RAW_MATERIALS)
                .add(DepEd_Ingredients.RAW_DEPED.get())
                .add(DepEd_Ingredients.RAW_GMATHS.get())
                .add(DepEd_Ingredients.RAW_GMANHS.get());

        tag(DepEd_Tags.DepEdItemTags.DEPED_CORES)
                .add(DepEd_CoreItems.DEPED_CORE.get())
                .add(DepEd_CoreItems.GMATHS_CORE.get())
                .add(DepEd_CoreItems.GMANHS_CORE.get());

        //normal stone items
        tag(ItemTags.STAIRS)
                .add(DepEd_Blocks.DEPED_STAIRS.asItem())
                .add(DepEd_Blocks.GMATHS_STAIRS.asItem());

        tag(ItemTags.SLABS)
                .add(DepEd_Blocks.DEPED_SLAB.asItem())
                .add(DepEd_Blocks.GMATHS_SLAB.asItem());

        tag(ItemTags.WALLS)
                .add(DepEd_Blocks.DEPED_WALL.asItem())
                .add(DepEd_Blocks.GMATHS_WALL.asItem());

        tag(ItemTags.STONE_BUTTONS)
                .add(DepEd_Blocks.DEPED_BUTTON.asItem())
                .add(DepEd_Blocks.GMATHS_BUTTON.asItem());

        //Flammability Wooden Items
        tag(ItemTags.PLANKS);

        tag(ItemTags.WOODEN_STAIRS);

        tag(ItemTags.WOODEN_SLABS);

        tag(ItemTags.WOODEN_FENCES);

        tag(ItemTags.FENCE_GATES);

        tag(ItemTags.WOODEN_BUTTONS);

        tag(ItemTags.WOODEN_PRESSURE_PLATES);
    }
}
