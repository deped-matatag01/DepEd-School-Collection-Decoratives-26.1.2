package net.depedph.depedschoolcollectiondecoratives.tags;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DepEd_Tags {
    public static class DepEdBlockTags {

        public static final TagKey<Block> WALL_FLAMMABILITY = createBlockTag("wall_flammability");

        private static TagKey<Block> createBlockTag(String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(DepEDSchoolCollectionDecoratives.MOD_ID, name));
        }
    }

    public static class DepEdItemTags {

        public static final TagKey<Item> DEPED_INGOTS = createItemTag("deped_ingots");
        public static final TagKey<Item> DEPED_NUGGETS = createItemTag("deped_nuggets");
        public static final TagKey<Item> DEPED_RAW_MATERIALS = createItemTag("deped_raw_materials");

        public static final TagKey<Item> DEPED_CORES = createItemTag("deped_cores");
        public static final TagKey<Item> DEPED_CORE_UPGRADES = createItemTag("deped_core_upgrades");

        public static final TagKey<Item> DEPED_CORE_UPGRADE_TEMPLATES = createItemTag("deped_core_upgrade_templates");
        public static final TagKey<Item> GMANHS_CORE_UPGRADES = createItemTag("gmanhs_core_upgrades");
        public static final TagKey<Item> KVA_SBO_CORE_UPGRADES = createItemTag("kva_sbo_core_upgrades");
        public static final TagKey<Item> UPHG_CCS_CORE_UPGRADES = createItemTag("uphg_ccs_core_upgrades");
        public static final TagKey<Item> UPHL_CCS_CORE_UPGRADES = createItemTag("uphl_ccs_core_upgrades");

        private static TagKey<Item> createItemTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(DepEDSchoolCollectionDecoratives.MOD_ID, name));
        }
    }
}
