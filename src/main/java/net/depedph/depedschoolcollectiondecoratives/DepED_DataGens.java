package net.depedph.depedschoolcollectiondecoratives;

import net.depedph.depedschoolcollectiondecoratives.datagen.DepED_ModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = DepEDSchoolCollectionDecoratives.MOD_ID)
public class DepED_DataGens {

    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        generator.addProvider(true, new DepED_ModelProvider(packOutput));
    }
}
