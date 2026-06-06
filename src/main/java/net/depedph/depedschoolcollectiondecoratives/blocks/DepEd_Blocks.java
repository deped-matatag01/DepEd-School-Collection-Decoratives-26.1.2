package net.depedph.depedschoolcollectiondecoratives.blocks;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_CoreItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class DepEd_Blocks {
    public static final DeferredRegister.Blocks  DEPED_BLOCKS = DeferredRegister.createBlocks(DepEDSchoolCollectionDecoratives.MOD_ID);

    //deped blocks
    public static final DeferredBlock<Block> DEPED_BLOCK = registerBlock("deped_block", properties -> new Block(
            properties.strength(1f, 1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEPED_STAIRS = registerBlock("deped_stairs", properties -> new StairBlock(DepEd_Blocks.DEPED_BLOCK.get().defaultBlockState(),
            properties.strength(1f, 1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEPED_SLAB = registerBlock("deped_slab", properties -> new SlabBlock(
            properties.strength(1f, 1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEPED_WALL = registerBlock("deped_wall", properties -> new WallBlock(
            properties.strength(1f, 1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEPED_BUTTON = registerBlock("deped_button", properties -> new ButtonBlock(BlockSetType.STONE, 20, properties
            .requiresCorrectToolForDrops().noCollision().strength(1f, 0.75f).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> DEPED_PRESSURE_PLATE = registerBlock("deped_pressure_plate", properties -> new PressurePlateBlock(BlockSetType.STONE, properties
            .mapColor(MapColor.TERRACOTTA_WHITE).forceSolidOn().instrument(NoteBlockInstrument.BASS)
            .requiresCorrectToolForDrops().noCollision().strength(1f, 0.75f).pushReaction(PushReaction.DESTROY)));

    //gmaths blocks
    public static final DeferredBlock<Block> GMATHS_BLOCK = registerBlock("block_of_gmaths", properties -> new Block(
            properties.strength(1f, 1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GMATHS_STAIRS = registerBlock("gmaths_stairs", properties -> new StairBlock(DepEd_Blocks.GMATHS_BLOCK.get().defaultBlockState(),
            properties.strength(1f, 1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GMATHS_SLAB = registerBlock("gmaths_slab", properties -> new SlabBlock(
            properties.strength(1f, 1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GMATHS_WALL = registerBlock("gmaths_wall", properties -> new WallBlock(
            properties.strength(1f, 1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GMATHS_BUTTON = registerBlock("gmaths_button", properties -> new ButtonBlock(BlockSetType.STONE, 20, properties
            .requiresCorrectToolForDrops().noCollision().strength(1f, 0.75f).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> GMATHS_PRESSURE_PLATE = registerBlock("gmaths_pressure_plate", properties -> new PressurePlateBlock(BlockSetType.STONE, properties
            .mapColor(MapColor.TERRACOTTA_WHITE).forceSolidOn().instrument(NoteBlockInstrument.BASS)
            .requiresCorrectToolForDrops().noCollision().strength(1f, 0.75f).pushReaction(PushReaction.DESTROY)));

    //gmanhs blocks
    public static final DeferredBlock<Block> GMANHS_BLOCK = registerBlock("block_of_gmanhs", properties -> new Block(
            properties.strength(1f, 1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    //deped decorative blocks
    public static final DeferredBlock<Block> BAKED_SUGARCANE_BLOCK =registerBlock("baked_sugarcane_block", properties -> new Block(
            properties.strength(1.5f, 3f).lightLevel(state -> 15).sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> SUGARCANE_BLOCK =registerBlock("sugarcane_block", properties -> new Block(
            properties.strength(1.5f, 3f).lightLevel(state -> 15).sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> THE_GMATHS_TORCH =registerBlock("the_gmaths_torch", properties -> new Block(
            properties.strength(1f, 1.5f).lightLevel(state -> 7).requiresCorrectToolForDrops().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> THE_GMATHS_TORCH_MK_II =registerBlock("the_gmaths_torch_mk_ii", properties -> new Block(
            properties.strength(1.5f, 3f).lightLevel(state -> 15).requiresCorrectToolForDrops().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> YES_O =registerBlock("yes_o", properties -> new Block(
            properties.strength(0.9f, 0.5f).lightLevel(state -> 15).sound(SoundType.CHERRY_LEAVES)));

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
