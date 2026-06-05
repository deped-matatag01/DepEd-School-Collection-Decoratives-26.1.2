package net.depedph.depedschoolcollectiondecoratives.creativetabs;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_Blocks;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_OreBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DepEd_BlocksTab {
    public static final DeferredRegister<CreativeModeTab> DEPED_DSCD_BLOCKS_TAB = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, DepEDSchoolCollectionDecoratives.MOD_ID);

    public static final Supplier<CreativeModeTab> DEPED_BLOCKS_TAB = DEPED_DSCD_BLOCKS_TAB.register("deped_blocks_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(DepEd_Blocks.DEPED_BLOCK.get())).title(Component.translatable("creativetabgroup.dscd26.deped_blocks_tab"))
            .displayItems((itemDisplayParameters, output) -> {

                //deped blocks
                output.accept(DepEd_Blocks.DEPED_BLOCK);
                output.accept(DepEd_Blocks.DEPED_STAIRS);
                output.accept(DepEd_Blocks.DEPED_SLAB);
                output.accept(DepEd_Blocks.DEPED_WALL);
                output.accept(DepEd_Blocks.DEPED_BUTTON);
                output.accept(DepEd_Blocks.DEPED_PRESSURE_PLATE);

                output.accept(DepEd_Blocks.GMATHS_BLOCK);
                output.accept(DepEd_Blocks.GMATHS_STAIRS);
                output.accept(DepEd_Blocks.GMATHS_SLAB);
                output.accept(DepEd_Blocks.GMATHS_WALL);
                output.accept(DepEd_Blocks.GMATHS_BUTTON);
                output.accept(DepEd_Blocks.GMATHS_PRESSURE_PLATE);

                output.accept(DepEd_Blocks.GMANHS_BLOCK);

                //deped decorative blocks
                output.accept(DepEd_Blocks.THE_GMATHS_TORCH);
                output.accept(DepEd_Blocks.THE_GMATHS_TORCH_MK_II);

                //ores and raw blocks
                output.accept(DepEd_OreBlocks.DEPED_ORE);
                output.accept(DepEd_OreBlocks.GMATHS_ORE);
                output.accept(DepEd_OreBlocks.GMANHS_ORE);

                output.accept(DepEd_OreBlocks.DEEPSLATE_DEPED_ORE);
                output.accept(DepEd_OreBlocks.DEEPSLATE_GMATHS_ORE);
                output.accept(DepEd_OreBlocks.DEEPSLATE_GMANHS_ORE);

                output.accept(DepEd_OreBlocks.RAW_DEPED_BLOCK);
                output.accept(DepEd_OreBlocks.RAW_GMATHS_BLOCK);
                output.accept(DepEd_OreBlocks.RAW_GMANHS_BLOCK);

            }).build());

    public static void register_dscdblockstab(IEventBus eventBus) {
        DEPED_DSCD_BLOCKS_TAB.register(eventBus);
    }
}
