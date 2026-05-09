package net.depedph.depedschoolcollectiondecoratives.blocks;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_CoreItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class DepEd_Blocks {
    public static final DeferredRegister.Blocks  DEPED_BLOCKS = DeferredRegister.createBlocks(DepEDSchoolCollectionDecoratives.MOD_ID);

    public static final DeferredBlock<Block> DEPED_BLOCK = registerBlock("deped_block", properties -> new Block(
            properties.strength(1f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GMATHS_BLOCK = registerBlock("block_of_gmaths", properties -> new Block(
            properties.strength(1f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GMANHS_BLOCK = registerBlock("block_of_gmanhs", properties -> new Block(
            properties.strength(1f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = DEPED_BLOCKS.registerBlock(name, function); registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        DepEd_CoreItems.DSCD_ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register_dscdblocks(IEventBus eventBus) {
        DEPED_BLOCKS.register(eventBus);
    }
}
