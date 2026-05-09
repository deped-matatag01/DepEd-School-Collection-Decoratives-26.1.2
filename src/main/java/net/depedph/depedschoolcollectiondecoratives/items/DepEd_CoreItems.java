package net.depedph.depedschoolcollectiondecoratives.items;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DepEd_CoreItems {
    public static final DeferredRegister.Items DSCD_ITEMS = DeferredRegister.createItems(DepEDSchoolCollectionDecoratives.MOD_ID);

    //School Seals
    public static final DeferredItem<Item> DEPED_CORE = DSCD_ITEMS.registerItem("deped_core", properties -> new Item(properties.rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> GMATHS_CORE = DSCD_ITEMS.registerItem("gmaths_core", properties -> new Item(properties.rarity(Rarity.RARE)));
    public static final DeferredItem<Item> GMANHS_CORE = DSCD_ITEMS.registerItem("gmanhs_core", properties -> new Item(properties.rarity(Rarity.EPIC)));

    public static void register_dscditems(IEventBus eventBus) {
        DSCD_ITEMS.register(eventBus);
    }
}
