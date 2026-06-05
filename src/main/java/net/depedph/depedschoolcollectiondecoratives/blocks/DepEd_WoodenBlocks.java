package net.depedph.depedschoolcollectiondecoratives.blocks;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_Ingredients;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class DepEd_WoodenBlocks {
    public static final DeferredRegister.Blocks  DEPED_WOODEN_BLOCKS = DeferredRegister.createBlocks(DepEDSchoolCollectionDecoratives.MOD_ID);



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = DEPED_WOODEN_BLOCKS.registerBlock(name, function); registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        DepEd_Ingredients.DSCD_INGREDIENTS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register_dscdblocks(IEventBus eventBus) {
        DEPED_WOODEN_BLOCKS.register(eventBus);
    }
}
