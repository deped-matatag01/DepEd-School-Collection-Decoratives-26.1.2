package net.depedph.depedschoolcollectiondecoratives.items;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DepEd_Ingredients {
    public static final DeferredRegister.Items DSCD_INGREDIENTS = DeferredRegister.createItems(DepEDSchoolCollectionDecoratives.MOD_ID);

    public static final DeferredItem<Item> RAW_DEPED = DSCD_INGREDIENTS.registerSimpleItem("raw_deped");
    public static final DeferredItem<Item> RAW_GMATHS = DSCD_INGREDIENTS.registerSimpleItem("raw_gmaths");
    public static final DeferredItem<Item> RAW_GMANHS = DSCD_INGREDIENTS.registerSimpleItem("raw_gmanhs");

    public static final DeferredItem<Item> DEPED_INGOT = DSCD_INGREDIENTS.registerSimpleItem("deped_ingot");
    public static final DeferredItem<Item> GMATHS_INGOT = DSCD_INGREDIENTS.registerSimpleItem("gmaths_ingot");
    public static final DeferredItem<Item> GMANHS_INGOT = DSCD_INGREDIENTS.registerSimpleItem("gmanhs_ingot");

    public static final DeferredItem<Item> DEPED_NUGGET = DSCD_INGREDIENTS.registerSimpleItem("deped_nugget");
    public static final DeferredItem<Item> GMATHS_NUGGET = DSCD_INGREDIENTS.registerSimpleItem("gmaths_nugget");
    public static final DeferredItem<Item> GMANHS_NUGGET = DSCD_INGREDIENTS.registerSimpleItem("gmanhs_nugget");

    public static void register_dscdingredients(IEventBus eventBus) {
        DSCD_INGREDIENTS.register(eventBus);
    }
}