package net.depedph.depedschoolcollectiondecoratives.creativetabs;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_WoodenBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DepEd_WoodenBlocksTab {
    public static final DeferredRegister<CreativeModeTab> DEPED_DSCD_WOODEN_BLOCKS_TAB = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, DepEDSchoolCollectionDecoratives.MOD_ID);

    public static final Supplier<CreativeModeTab> DEPED_WOODEN_BLOCKS_TAB = DEPED_DSCD_WOODEN_BLOCKS_TAB.register("deped_wooden_blocks_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(DepEd_WoodenBlocks.WHITE_OAK_PLANKS.get())).title(Component.translatable("creativetabgroup.dscd26.deped_wooden_blocks_tab"))
            .displayItems((itemDisplayParameters, output) -> {

                //White colored planks
                output.accept(DepEd_WoodenBlocks.WHITE_OAK_PLANKS);
                output.accept(DepEd_WoodenBlocks.WHITE_OAK_STAIRS);
                output.accept(DepEd_WoodenBlocks.WHITE_OAK_SLAB);
                output.accept(DepEd_WoodenBlocks.WHITE_OAK_WALL);
                output.accept(DepEd_WoodenBlocks.WHITE_OAK_FENCE);
                output.accept(DepEd_WoodenBlocks.WHITE_OAK_FENCE_GATE);
                output.accept(DepEd_WoodenBlocks.WHITE_OAK_BUTTON);
                output.accept(DepEd_WoodenBlocks.WHITE_OAK_PRESSURE_PLATE);

                //Light gray colored planks

                //Gray colored planks

                //Black colored planks

                //Brown colored planks

                //Red colored planks

                //Orange colored planks

                //Yellow colored planks

                //Lime colored planks

                //Green colored planks

                //Cyan colored planks

                //Light blue colored planks

                //Blue colored planks

                //Purple colored planks

                //Magenta colored planks

                //Pink colored planks

            }).build());

    public static void register_dscdwoodenblockstab(IEventBus eventBus) {
        DEPED_DSCD_WOODEN_BLOCKS_TAB.register(eventBus);
    }
}
