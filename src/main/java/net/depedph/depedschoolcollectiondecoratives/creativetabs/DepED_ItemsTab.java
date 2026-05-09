package net.depedph.depedschoolcollectiondecoratives.creativetabs;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_CoreItems;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_Ingredients;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DepED_ItemsTab {
    public static final DeferredRegister<CreativeModeTab> DEPED_DSCD_ITEMS_TAB = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, DepEDSchoolCollectionDecoratives.MOD_ID);

    public static final Supplier<CreativeModeTab> DEPED_ITEMS_TAB = DEPED_DSCD_ITEMS_TAB.register("deped_items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(DepEd_CoreItems.DEPED_CORE.get())).title(Component.translatable("creativetabgroup.dscd26.deped_items_tab"))
            .displayItems((itemDisplayParameters, output) -> {

                //core items
                output.accept(DepEd_CoreItems.DEPED_CORE);
                output.accept(DepEd_CoreItems.GMATHS_CORE);
                output.accept(DepEd_CoreItems.GMANHS_CORE);

                //raw mats
                output.accept(DepEd_Ingredients.RAW_DEPED);
                output.accept(DepEd_Ingredients.RAW_GMATHS);
                output.accept(DepEd_Ingredients.RAW_GMANHS);

                output.accept(DepEd_Ingredients.DEPED_INGOT);
                output.accept(DepEd_Ingredients.GMATHS_INGOT);
                output.accept(DepEd_Ingredients.GMANHS_INGOT);

                output.accept(DepEd_Ingredients.DEPED_NUGGET);
                output.accept(DepEd_Ingredients.GMATHS_NUGGET);
                output.accept(DepEd_Ingredients.GMANHS_NUGGET);

            }).build());

    public static void register_dscditemstab(IEventBus eventBus) {
        DEPED_DSCD_ITEMS_TAB.register(eventBus);
    }
}
