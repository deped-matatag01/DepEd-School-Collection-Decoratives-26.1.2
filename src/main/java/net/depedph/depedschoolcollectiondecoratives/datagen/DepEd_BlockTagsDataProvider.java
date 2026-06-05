package net.depedph.depedschoolcollectiondecoratives.datagen;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_Blocks;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_OreBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class DepEd_BlockTagsDataProvider extends BlockTagsProvider {
    public DepEd_BlockTagsDataProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, DepEDSchoolCollectionDecoratives.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        //mines with specific tools
        tag(BlockTags.MINEABLE_WITH_PICKAXE)

                //deped blocks
                .add(DepEd_Blocks.DEPED_BLOCK.get())
                .add(DepEd_Blocks.DEPED_STAIRS.get())
                .add(DepEd_Blocks.DEPED_SLAB.get())
                .add(DepEd_Blocks.DEPED_WALL.get())
                .add(DepEd_Blocks.DEPED_BUTTON.get())
                .add(DepEd_Blocks.DEPED_PRESSURE_PLATE.get())

                .add(DepEd_Blocks.GMATHS_BLOCK.get())
                .add(DepEd_Blocks.GMATHS_STAIRS.get())
                .add(DepEd_Blocks.GMATHS_SLAB.get())
                .add(DepEd_Blocks.GMATHS_WALL.get())
                .add(DepEd_Blocks.GMATHS_BUTTON.get())
                .add(DepEd_Blocks.GMATHS_PRESSURE_PLATE.get())

                .add(DepEd_Blocks.GMATHS_BLOCK.get())

                //deped decorative blocks
                .add(DepEd_Blocks.THE_GMATHS_TORCH.get())
                .add(DepEd_Blocks.THE_GMATHS_TORCH_MK_II.get())

                //deped ores and raw blocks
                .add(DepEd_OreBlocks.DEPED_ORE.get())
                .add(DepEd_OreBlocks.GMATHS_ORE.get())
                .add(DepEd_OreBlocks.GMANHS_ORE.get())

                .add(DepEd_OreBlocks.DEEPSLATE_DEPED_ORE.get())
                .add(DepEd_OreBlocks.DEEPSLATE_GMATHS_ORE.get())
                .add(DepEd_OreBlocks.DEEPSLATE_GMANHS_ORE.get())

                .add(DepEd_OreBlocks.RAW_DEPED_BLOCK.get())
                .add(DepEd_OreBlocks.RAW_GMATHS_BLOCK.get())
                .add(DepEd_OreBlocks.RAW_GMANHS_BLOCK.get());

        tag(BlockTags.MINEABLE_WITH_AXE);

                //deped wooden blocks

        tag(BlockTags.MINEABLE_WITH_HOE);

                //yes-o ez destructible block

        //requires specific tools to mine
        tag(BlockTags.NEEDS_STONE_TOOL)

                .add(DepEd_Blocks.DEPED_BLOCK.get())
                .add(DepEd_Blocks.DEPED_STAIRS.get())
                .add(DepEd_Blocks.DEPED_SLAB.get())
                .add(DepEd_Blocks.DEPED_WALL.get())
                .add(DepEd_Blocks.DEPED_BUTTON.get())
                .add(DepEd_Blocks.DEPED_PRESSURE_PLATE.get())

                .add(DepEd_OreBlocks.DEPED_ORE.get())
                .add(DepEd_OreBlocks.DEEPSLATE_DEPED_ORE.get())
                .add(DepEd_OreBlocks.RAW_DEPED_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)

                .add(DepEd_Blocks.GMATHS_BLOCK.get())
                .add(DepEd_Blocks.GMATHS_STAIRS.get())
                .add(DepEd_Blocks.GMATHS_SLAB.get())
                .add(DepEd_Blocks.GMATHS_WALL.get())
                .add(DepEd_Blocks.GMATHS_BUTTON.get())
                .add(DepEd_Blocks.GMATHS_PRESSURE_PLATE.get())

                .add(DepEd_OreBlocks.GMATHS_ORE.get())
                .add(DepEd_OreBlocks.DEEPSLATE_GMATHS_ORE.get())
                .add(DepEd_OreBlocks.RAW_GMATHS_BLOCK.get())

                .add(DepEd_Blocks.THE_GMATHS_TORCH.get())
                .add(DepEd_Blocks.THE_GMATHS_TORCH_MK_II.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)

                .add(DepEd_Blocks.GMANHS_BLOCK.get());

        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)

                .add(DepEd_OreBlocks.GMANHS_ORE.get())
                .add(DepEd_OreBlocks.DEEPSLATE_GMANHS_ORE.get())
                .add(DepEd_OreBlocks.RAW_GMANHS_BLOCK.get());

        //block tags
        tag(BlockTags.STAIRS)
                .add(DepEd_Blocks.DEPED_STAIRS.get())
                .add(DepEd_Blocks.GMATHS_STAIRS.get());

        tag(BlockTags.SLABS)
                .add(DepEd_Blocks.DEPED_SLAB.get())
                .add(DepEd_Blocks.GMATHS_SLAB.get());

        tag(BlockTags.WALLS)
                .add(DepEd_Blocks.DEPED_WALL.get())
                .add(DepEd_Blocks.GMATHS_WALL.get());

        tag(BlockTags.STONE_BUTTONS)
                .add(DepEd_Blocks.DEPED_BUTTON.get())
                .add(DepEd_Blocks.GMATHS_BUTTON.get());

        tag(BlockTags.STONE_PRESSURE_PLATES)
                .add(DepEd_Blocks.DEPED_PRESSURE_PLATE.get())
                .add(DepEd_Blocks.GMATHS_PRESSURE_PLATE.get());

        //wooden block tags
        tag(BlockTags.PLANKS);

        tag(BlockTags.WOODEN_STAIRS);

        tag(BlockTags.WOODEN_SLABS);

        tag(BlockTags.WOODEN_FENCES);

        tag(BlockTags.FENCE_GATES);

        tag(BlockTags.WOODEN_BUTTONS);

        tag(BlockTags.WOODEN_PRESSURE_PLATES);
    }
}
