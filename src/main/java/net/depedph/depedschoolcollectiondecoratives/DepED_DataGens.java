package net.depedph.depedschoolcollectiondecoratives;

import net.depedph.depedschoolcollectiondecoratives.datagen.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(modid = DepEDSchoolCollectionDecoratives.MOD_ID)
public class DepED_DataGens {

    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new DepEd_ModelProvider(packOutput));
        generator.addProvider(true, new DepEd_BlockTagsDataProvider(packOutput, lookupProvider));
        generator.addProvider(true, new DepEd_ItemTagsDataProvider(packOutput, lookupProvider));
        generator.addProvider(true, new DepEd_RecipeDataProvider.DSCD_RecipeRunner(packOutput, lookupProvider));

        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(
                DepEd_LootTableDataProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
    }
}
