package net.depedph.depedschoolcollectiondecoratives.datagen;

import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_Blocks;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_OreBlocks;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_WoodenBlocks;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_Ingredients;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;
import java.util.stream.Stream;

public class DepEd_LootTableDataProvider extends BlockLootSubProvider {
    public DepEd_LootTableDataProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        //deped blocks
        dropSelf(DepEd_Blocks.DEPED_BLOCK.get());
        dropSelf(DepEd_Blocks.DEPED_STAIRS.get());
        add(DepEd_Blocks.DEPED_SLAB.get(), this::createSlabItemTable);
        dropSelf(DepEd_Blocks.DEPED_WALL.get());
        dropSelf(DepEd_Blocks.DEPED_BUTTON.get());
        dropSelf(DepEd_Blocks.DEPED_PRESSURE_PLATE.get());

        dropSelf(DepEd_Blocks.GMATHS_BLOCK.get());
        dropSelf(DepEd_Blocks.GMATHS_STAIRS.get());
        add(DepEd_Blocks.GMATHS_SLAB.get(), this::createSlabItemTable);
        dropSelf(DepEd_Blocks.GMATHS_WALL.get());
        dropSelf(DepEd_Blocks.GMATHS_BUTTON.get());
        dropSelf(DepEd_Blocks.GMATHS_PRESSURE_PLATE.get());

        dropSelf(DepEd_Blocks.GMANHS_BLOCK.get());

        //deped decorative blocks
        dropSelf(DepEd_Blocks.BAKED_SUGARCANE_BLOCK.get());
        dropSelf(DepEd_Blocks.SUGARCANE_BLOCK.get());
        dropSelf(DepEd_Blocks.THE_GMATHS_TORCH.get());
        dropSelf(DepEd_Blocks.THE_GMATHS_TORCH_MK_II.get());
        dropSelf(DepEd_Blocks.YES_O.get());

        //ore and raw blocks
        add(DepEd_OreBlocks.DEPED_ORE.get(), createMultipleOreDrops(DepEd_OreBlocks.DEPED_ORE.get(), DepEd_Ingredients.RAW_DEPED.get(), 1, 4));
        add(DepEd_OreBlocks.DEEPSLATE_DEPED_ORE.get(), createMultipleOreDrops(DepEd_OreBlocks.DEEPSLATE_DEPED_ORE.get(), DepEd_Ingredients.RAW_DEPED.get(), 1, 4));
        add(DepEd_OreBlocks.GMATHS_ORE.get(), createMultipleOreDrops(DepEd_OreBlocks.GMATHS_ORE.get(), DepEd_Ingredients.RAW_GMATHS.get(), 1, 4));
        add(DepEd_OreBlocks.DEEPSLATE_GMATHS_ORE.get(), createMultipleOreDrops(DepEd_OreBlocks.DEEPSLATE_GMATHS_ORE.get(), DepEd_Ingredients.RAW_GMATHS.get(), 1, 4));
        add(DepEd_OreBlocks.GMANHS_ORE.get(), createMultipleOreDrops(DepEd_OreBlocks.GMANHS_ORE.get(), DepEd_Ingredients.RAW_GMANHS.get(), 1, 4));
        add(DepEd_OreBlocks.DEEPSLATE_GMANHS_ORE.get(), createMultipleOreDrops(DepEd_OreBlocks.DEEPSLATE_GMANHS_ORE.get(), DepEd_Ingredients.RAW_GMANHS.get(), 1, 4));

        dropSelf(DepEd_OreBlocks.RAW_DEPED_BLOCK.get());
        dropSelf(DepEd_OreBlocks.RAW_GMATHS_BLOCK.get());
        dropSelf(DepEd_OreBlocks.RAW_GMANHS_BLOCK.get());

        //wooden blocks
        dropSelf(DepEd_WoodenBlocks.WHITE_OAK_PLANKS.get());
        dropSelf(DepEd_WoodenBlocks.WHITE_OAK_STAIRS.get());
        add(DepEd_WoodenBlocks.WHITE_OAK_SLAB.get(), this::createSlabItemTable);
        dropSelf(DepEd_WoodenBlocks.WHITE_OAK_WALL.get());
        dropSelf(DepEd_WoodenBlocks.WHITE_OAK_FENCE.get());
        dropSelf(DepEd_WoodenBlocks.WHITE_OAK_FENCE_GATE.get());
        dropSelf(DepEd_WoodenBlocks.WHITE_OAK_BUTTON.get());
        dropSelf(DepEd_WoodenBlocks.WHITE_OAK_PRESSURE_PLATE.get());

    }

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(block,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Stream.of(

                DepEd_Blocks.DEPED_BLOCKS.getEntries().stream(),
                DepEd_OreBlocks.DEPED_ORE_BLOCKS.getEntries().stream(),
                DepEd_WoodenBlocks.DEPED_WOODEN_BLOCKS.getEntries().stream()

        ).flatMap(stream -> stream.map(Holder::value))::iterator;
    }
}
