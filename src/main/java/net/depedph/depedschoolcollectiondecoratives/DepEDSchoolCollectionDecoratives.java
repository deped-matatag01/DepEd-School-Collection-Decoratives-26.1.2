package net.depedph.depedschoolcollectiondecoratives;

import net.depedph.depedschoolcollectiondecoratives.creativetabs.DepED_ItemsTab;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_Ingredients;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_CoreItems;

import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(DepEDSchoolCollectionDecoratives.MOD_ID)

public class DepEDSchoolCollectionDecoratives {
    public static final String MOD_ID = "dscd26";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DepEDSchoolCollectionDecoratives(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        //Items
        DepEd_CoreItems.register_dscditems(modEventBus);
        DepEd_Ingredients.register_dscdingredients(modEventBus);

        //Blocks

        //Creative Tabs
        DepED_ItemsTab.register_dscditemstab(modEventBus);

        //Tags

        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        //minerals
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(DepEd_Ingredients.RAW_DEPED);
            event.accept(DepEd_Ingredients.RAW_GMATHS);
            event.accept(DepEd_Ingredients.RAW_GMANHS);

            event.accept(DepEd_Ingredients.DEPED_INGOT);
            event.accept(DepEd_Ingredients.GMATHS_INGOT);
            event.accept(DepEd_Ingredients.GMANHS_NUGGET);

            event.accept(DepEd_Ingredients.DEPED_NUGGET);
            event.accept(DepEd_Ingredients.GMATHS_NUGGET);
            event.accept(DepEd_Ingredients.GMANHS_NUGGET);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
