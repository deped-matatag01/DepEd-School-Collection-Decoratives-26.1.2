package net.depedph.depedschoolcollectiondecoratives;

import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_Blocks;
import net.depedph.depedschoolcollectiondecoratives.creativetabs.DepEd_BlocksTab;
import net.depedph.depedschoolcollectiondecoratives.creativetabs.DepEd_ItemsTab;
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
        DepEd_Blocks.register_dscdblocks(modEventBus);

        //Creative Tabs
        DepEd_ItemsTab.register_dscditemstab(modEventBus);
        DepEd_BlocksTab.register_dscdblockstab(modEventBus);

        //Tags

        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

            //raw minerals
            event.accept(DepEd_Ingredients.RAW_DEPED.get());
            event.accept(DepEd_Ingredients.RAW_GMATHS.get());
            event.accept(DepEd_Ingredients.RAW_GMANHS.get());

            event.accept(DepEd_Ingredients.DEPED_INGOT.get());
            event.accept(DepEd_Ingredients.GMATHS_NUGGET.get());
            event.accept(DepEd_Ingredients.GMANHS_INGOT.get());

            event.accept(DepEd_Ingredients.DEPED_NUGGET.get());
            event.accept(DepEd_Ingredients.GMATHS_INGOT.get());
            event.accept(DepEd_Ingredients.GMANHS_NUGGET.get());

        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
