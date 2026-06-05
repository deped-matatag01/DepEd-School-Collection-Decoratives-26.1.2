package net.depedph.depedschoolcollectiondecoratives.blocks;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_Ingredients;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class DepEd_OreBlocks {
    public static final DeferredRegister.Blocks  DEPED_ORE_BLOCKS = DeferredRegister.createBlocks(DepEDSchoolCollectionDecoratives.MOD_ID);

    //ores
    public static final DeferredBlock<Block> DEPED_ORE = registerBlock("deped_ore", properties -> new Block(
            properties.strength(1.5f, 2.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_DEPED_ORE = registerBlock("deepslate_deped_ore", properties -> new Block(
            properties.strength(3f, 5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> GMATHS_ORE = registerBlock("gmaths_ore", properties -> new Block(
            properties.strength(2f, 3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_GMATHS_ORE = registerBlock("deepslate_gmaths_ore", properties -> new Block(
            properties.strength(4f, 6f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> GMANHS_ORE = registerBlock("gmanhs_ore", properties -> new Block(
            properties.strength(2.5f, 4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_GMANHS_ORE = registerBlock("deepslate_gmanhs_ore", properties -> new Block(
            properties.strength(5f, 8f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    //raw blocks
    public static final DeferredBlock<Block> RAW_DEPED_BLOCK = registerBlock("raw_deped_block", properties -> new Block(
            properties.strength(1.5f, 2f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> RAW_GMATHS_BLOCK = registerBlock("raw_gmaths_block", properties -> new Block(
            properties.strength(3f, 4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> RAW_GMANHS_BLOCK = registerBlock("raw_gmanhs_block", properties -> new Block(
            properties.strength(4.5f, 6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = DEPED_ORE_BLOCKS.registerBlock(name, function); registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        DepEd_Ingredients.DSCD_INGREDIENTS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register_dscdblocks(IEventBus eventBus) {
        DEPED_ORE_BLOCKS.register(eventBus);
    }
}
