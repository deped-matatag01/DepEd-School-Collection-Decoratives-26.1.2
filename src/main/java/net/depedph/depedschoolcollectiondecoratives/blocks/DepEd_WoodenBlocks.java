package net.depedph.depedschoolcollectiondecoratives.blocks;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_Ingredients;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class DepEd_WoodenBlocks {
    public static final DeferredRegister.Blocks  DEPED_WOODEN_BLOCKS = DeferredRegister.createBlocks(DepEDSchoolCollectionDecoratives.MOD_ID);

    //White wooden variants
    public static final DeferredBlock<Block> WHITE_OAK_PLANKS = registerBlock("white_oak_planks", properties -> flammableBlock(
            properties.strength(2f, 3f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> WHITE_OAK_STAIRS = registerBlock("white_oak_stairs", properties -> flammableStairs(DepEd_Blocks.DEPED_BLOCK.get().defaultBlockState(),
            properties.strength(2f, 3f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> WHITE_OAK_SLAB = registerBlock("white_oak_slab", properties -> flammableSlab(
            properties.strength(2f, 3f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> WHITE_OAK_WALL = registerBlock("white_oak_wall", properties -> flammableWall(
            properties.strength(2f, 3f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> WHITE_OAK_FENCE = registerBlock("white_oak_fence", properties -> flammableFence(
            properties.strength(2f, 3f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> WHITE_OAK_FENCE_GATE = registerBlock("white_oak_fence_gate", properties -> flammableFenceGate(WoodType.OAK,
            properties.strength(2f, 3f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> WHITE_OAK_BUTTON = registerBlock("white_oak_button", properties -> new ButtonBlock(BlockSetType.OAK, 20, properties
            .noCollision().strength(2f, 3f).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> WHITE_OAK_PRESSURE_PLATE = registerBlock("white_oak_pressure_plate", properties -> new PressurePlateBlock(BlockSetType.OAK, properties
            .mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS)
            .noCollision().strength(3f, 3f).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));

    private static final int FLAMMABILITY = 20;
    private static final int FIRE_SPREAD = 5;

    private static BlockBehaviour.Properties woodProps(Block base) {
        return BlockBehaviour.Properties.ofFullCopy(base).strength(2f, 3f).sound(SoundType.WOOD);
    }

    private static Block flammableBlock(BlockBehaviour.Properties props) {
        return new Block(props) {
            @Override public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return true; }
            @Override public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return FLAMMABILITY; }
            @Override public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return FIRE_SPREAD; }
        };
    }

    private static StairBlock flammableStairs(BlockState baseState, BlockBehaviour.Properties props) {
        return new StairBlock(baseState, props) {
            @Override public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return true; }
            @Override public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return FLAMMABILITY; }
            @Override public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return FIRE_SPREAD; }
        };
    }

    private static SlabBlock flammableSlab(BlockBehaviour.Properties props) {
        return new SlabBlock(props) {
            @Override public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return true; }
            @Override public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return FLAMMABILITY; }
            @Override public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return FIRE_SPREAD; }
        };
    }

    private static WallBlock flammableWall(BlockBehaviour.Properties props) {
        return new WallBlock(props) {
            @Override public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return true; }
            @Override public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return FLAMMABILITY; }
            @Override public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return FIRE_SPREAD; }
        };
    }

    private static FenceBlock flammableFence(BlockBehaviour.Properties props) {
        return new FenceBlock(props) {
            @Override public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return true; }
            @Override public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return FLAMMABILITY; }
            @Override public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return FIRE_SPREAD; }
        };
    }

    private static FenceGateBlock flammableFenceGate(WoodType woodType, BlockBehaviour.Properties props) {
        return new FenceGateBlock(woodType, props) {
            @Override public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return true; }
            @Override public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return FLAMMABILITY; }
            @Override public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction dir) { return FIRE_SPREAD; }
        };
    }

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
