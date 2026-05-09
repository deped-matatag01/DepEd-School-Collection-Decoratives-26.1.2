package net.depedph.depedschoolcollectiondecoratives.creativetabs;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_Blocks;
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

                output.accept(DepEd_Blocks.DEPED_BLOCK);
                output.accept(DepEd_Blocks.GMATHS_BLOCK);
                output.accept(DepEd_Blocks.GMANHS_BLOCK);

            }).build());

    public static void register_dscdblockstab(IEventBus eventBus) {
        DEPED_DSCD_BLOCKS_TAB.register(eventBus);
    }
}
