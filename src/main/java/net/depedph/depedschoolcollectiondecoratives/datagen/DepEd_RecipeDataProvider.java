package net.depedph.depedschoolcollectiondecoratives.datagen;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_Blocks;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_OreBlocks;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_WoodenBlocks;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_CoreItems;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_Ingredients;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DepEd_RecipeDataProvider extends RecipeProvider {
    public DepEd_RecipeDataProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class DSCD_RecipeRunner extends RecipeProvider.Runner {

        public DSCD_RecipeRunner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new DepEd_RecipeDataProvider(registries, output);
        }

        @Override
        public String getName() {
            return "DSCD Recipe Giver";
        }
    }

    @Override
    protected void buildRecipes() {

        //Materials - DepED ingredients
        List<ItemLike> DEPED_MINERAL_SMELTABLES = List.of(
                DepEd_Ingredients.RAW_DEPED,
                DepEd_OreBlocks.DEPED_ORE,
                DepEd_OreBlocks.DEEPSLATE_DEPED_ORE);

        oreSmelting(DEPED_MINERAL_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, DepEd_Ingredients.DEPED_INGOT.get(), 0.25f, 200, "deped_ingot_smeltables");
        oreBlasting(DEPED_MINERAL_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, DepEd_Ingredients.DEPED_INGOT.get(), 0.5f, 100, "deped_ingot_smeltables");

        shapeless(RecipeCategory.MISC, DepEd_Ingredients.DEPED_NUGGET.get(), 9)
                .requires(DepEd_Ingredients.DEPED_INGOT)
                .unlockedBy(getHasName(DepEd_Ingredients.DEPED_INGOT.get()), has(DepEd_Ingredients.DEPED_INGOT))
                .group("deped_nuggets")
                .save(output, "dscd26:deped_nugget_from_deped_ingot");

        shaped(RecipeCategory.MISC, DepEd_Ingredients.DEPED_INGOT.get(), 1)
                .pattern("DDD")
                .pattern("DDD")
                .pattern("DDD")
                .define('D', DepEd_Ingredients.DEPED_NUGGET.get())
                .unlockedBy(getHasName(DepEd_Ingredients.DEPED_NUGGET.get()), has(DepEd_Ingredients.DEPED_NUGGET))
                .group("deped_ingots")
                .save(output, "dscd26:deped_ingot_from_deped_nugget");

        shapeless(RecipeCategory.MISC, DepEd_Ingredients.RAW_DEPED.get(), 9)
                .requires(DepEd_OreBlocks.RAW_DEPED_BLOCK)
                .unlockedBy(getHasName(DepEd_OreBlocks.RAW_DEPED_BLOCK.get()), has(DepEd_OreBlocks.RAW_DEPED_BLOCK))
                .group("deped_raw_materials")
                .save(output, "dscd26:raw_deped_from_raw_deped_block");

        shaped(RecipeCategory.MISC, DepEd_OreBlocks.RAW_DEPED_BLOCK.get(), 1)
                .pattern("DDD")
                .pattern("DDD")
                .pattern("DDD")
                .define('D', DepEd_Ingredients.RAW_DEPED.get())
                .unlockedBy(getHasName(DepEd_Ingredients.RAW_DEPED.get()), has(DepEd_Ingredients.RAW_DEPED))
                .group("deped_rawblocky_materials")
                .save(output, "dscd26:raw_deped_block_from_raw_deped");

        //DepED Block Decoratives
        shaped(RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.DEPED_BLOCK.get(), 1)
                .pattern("WSW")
                .pattern("SCS")
                .pattern("WSW")
                .define('W', ItemTags.STONE_CRAFTING_MATERIALS)
                .define('C', DepEd_CoreItems.DEPED_CORE)
                .define('S', DepEd_Ingredients.DEPED_INGOT)
                .unlockedBy(getHasName(DepEd_CoreItems.DEPED_CORE.get()), has(DepEd_CoreItems.DEPED_CORE))
                .group("deped_block")
                .save(output);
        stairBuilder(DepEd_Blocks.DEPED_STAIRS, Ingredient.of(DepEd_Blocks.DEPED_BLOCK))
                .unlockedBy(getHasName(DepEd_Blocks.DEPED_BLOCK.get()), has(DepEd_Blocks.DEPED_BLOCK))
                .group("deped_stairs")
                .save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.DEPED_SLAB.get(), DepEd_Blocks.DEPED_BLOCK.get());
        wall(RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.DEPED_WALL.get(), DepEd_Blocks.DEPED_BLOCK.get());
        buttonBuilder(DepEd_Blocks.DEPED_BUTTON.get(), Ingredient.of(DepEd_Blocks.DEPED_BLOCK.get()))
                .unlockedBy(getHasName(DepEd_Blocks.DEPED_BLOCK.get()), has(DepEd_Blocks.DEPED_BLOCK))
                .group("deped_buttons")
                .save(output);
        pressurePlate(DepEd_Blocks.DEPED_PRESSURE_PLATE.get(), DepEd_Blocks.DEPED_BLOCK.get());

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DepEd_Blocks.DEPED_BLOCK), RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.DEPED_STAIRS, 2)
                .unlockedBy(getHasName(DepEd_Blocks.DEPED_BLOCK.get()), has(DepEd_Blocks.DEPED_BLOCK))
                .save(output, "dscd26:deped_stairs_from_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DepEd_Blocks.DEPED_BLOCK), RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.DEPED_SLAB, 2)
                .unlockedBy(getHasName(DepEd_Blocks.DEPED_BLOCK.get()), has(DepEd_Blocks.DEPED_BLOCK))
                .save(output, "dscd26:deped_slab_from_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DepEd_Blocks.DEPED_BLOCK), RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.DEPED_WALL, 2)
                .unlockedBy(getHasName(DepEd_Blocks.DEPED_BLOCK.get()), has(DepEd_Blocks.DEPED_BLOCK))
                .save(output, "dscd26:deped_wall_from_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DepEd_Blocks.DEPED_BLOCK), RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.DEPED_BUTTON, 2)
                .unlockedBy(getHasName(DepEd_Blocks.DEPED_BLOCK.get()), has(DepEd_Blocks.DEPED_BLOCK))
                .save(output, "dscd26:deped_button_from_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DepEd_Blocks.DEPED_BLOCK), RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.DEPED_PRESSURE_PLATE, 2)
                .unlockedBy(getHasName(DepEd_Blocks.DEPED_BLOCK.get()), has(DepEd_Blocks.DEPED_BLOCK))
                .save(output, "dscd26:deped_pressure_plate_from_stonecutting");

        //Materials - GMATHS ingredients
        List<ItemLike> GMATHS_MINERAL_SMELTABLES = List.of(
                DepEd_Ingredients.RAW_GMATHS,
                DepEd_OreBlocks.GMATHS_ORE,
                DepEd_OreBlocks.DEEPSLATE_GMATHS_ORE);

        oreSmelting(GMATHS_MINERAL_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, DepEd_Ingredients.GMATHS_INGOT.get(), 0.25f, 200, "deped_ingot_smeltables");
        oreBlasting(GMATHS_MINERAL_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, DepEd_Ingredients.GMATHS_INGOT.get(), 0.5f, 100, "deped_ingot_smeltables");

        shapeless(RecipeCategory.MISC, DepEd_Ingredients.GMATHS_NUGGET.get(), 9)
                .requires(DepEd_Ingredients.GMATHS_INGOT)
                .unlockedBy(getHasName(DepEd_Ingredients.GMATHS_INGOT.get()), has(DepEd_Ingredients.GMATHS_INGOT))
                .group("deped_nuggets")
                .save(output, "dscd26:gmaths_nugget_from_gmaths_ingot");

        shaped(RecipeCategory.MISC, DepEd_Ingredients.GMATHS_INGOT.get(), 1)
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', DepEd_Ingredients.GMATHS_NUGGET.get())
                .unlockedBy(getHasName(DepEd_Ingredients.GMATHS_NUGGET.get()), has(DepEd_Ingredients.GMATHS_NUGGET))
                .group("deped_ingots")
                .save(output, "dscd26:gmaths_ingot_from_gmaths_nugget");

        shapeless(RecipeCategory.MISC, DepEd_Ingredients.RAW_GMATHS.get(), 9)
                .requires(DepEd_OreBlocks.RAW_GMATHS_BLOCK)
                .unlockedBy(getHasName(DepEd_OreBlocks.RAW_GMATHS_BLOCK.get()), has(DepEd_OreBlocks.RAW_GMATHS_BLOCK))
                .group("deped_raw_materials")
                .save(output, "dscd26:raw_gmaths_from_raw_gmaths_block");

        shaped(RecipeCategory.MISC, DepEd_OreBlocks.RAW_GMATHS_BLOCK.get(), 1)
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', DepEd_Ingredients.RAW_GMATHS.get())
                .unlockedBy(getHasName(DepEd_Ingredients.RAW_GMATHS.get()), has(DepEd_Ingredients.RAW_GMATHS))
                .group("deped_rawblocky_materials")
                .save(output, "dscd26:raw_gmaths_block_from_raw_gmaths");

        //GMATHS Block Decoratives
        shaped(RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.GMATHS_BLOCK.get(), 1)
                .pattern("WSW")
                .pattern("SCS")
                .pattern("WSW")
                .define('W', Items.NETHERRACK)
                .define('C', DepEd_CoreItems.GMATHS_CORE)
                .define('S', ItemTags.SLABS)
                .unlockedBy(getHasName(DepEd_CoreItems.GMATHS_CORE.get()), has(DepEd_CoreItems.GMATHS_CORE))
                .group("deped_block")
                .save(output);
        stairBuilder(DepEd_Blocks.GMATHS_STAIRS, Ingredient.of(DepEd_Blocks.GMATHS_BLOCK))
                .unlockedBy(getHasName(DepEd_Blocks.GMATHS_BLOCK.get()), has(DepEd_Blocks.GMATHS_BLOCK))
                .group("deped_stairs")
                .save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.GMATHS_SLAB.get(), DepEd_Blocks.GMATHS_BLOCK.get());
        wall(RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.GMATHS_WALL.get(), DepEd_Blocks.GMATHS_BLOCK.get());
        buttonBuilder(DepEd_Blocks.GMATHS_BUTTON.get(), Ingredient.of(DepEd_Blocks.GMATHS_BLOCK.get()))
                .unlockedBy(getHasName(DepEd_Blocks.GMATHS_BLOCK.get()), has(DepEd_Blocks.GMATHS_BLOCK))
                .group("deped_buttons")
                .save(output);
        pressurePlate(DepEd_Blocks.GMATHS_PRESSURE_PLATE.get(), DepEd_Blocks.GMATHS_BLOCK.get());

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DepEd_Blocks.GMATHS_BLOCK), RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.GMATHS_STAIRS, 2)
                .unlockedBy(getHasName(DepEd_Blocks.GMATHS_BLOCK.get()), has(DepEd_Blocks.GMATHS_BLOCK))
                .save(output, "dscd26:gmaths_stairs_from_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DepEd_Blocks.GMATHS_BLOCK), RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.GMATHS_SLAB, 2)
                .unlockedBy(getHasName(DepEd_Blocks.GMATHS_BLOCK.get()), has(DepEd_Blocks.GMATHS_BLOCK))
                .save(output, "dscd26:gmaths_slab_from_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DepEd_Blocks.GMATHS_BLOCK), RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.GMATHS_WALL, 2)
                .unlockedBy(getHasName(DepEd_Blocks.GMATHS_BLOCK.get()), has(DepEd_Blocks.GMATHS_BLOCK))
                .save(output, "dscd26:gmaths_wall_from_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DepEd_Blocks.GMATHS_BLOCK), RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.GMATHS_BUTTON, 2)
                .unlockedBy(getHasName(DepEd_Blocks.GMATHS_BLOCK.get()), has(DepEd_Blocks.GMATHS_BLOCK))
                .save(output, "dscd26:gmaths_button_from_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DepEd_Blocks.GMATHS_BLOCK), RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.GMATHS_PRESSURE_PLATE, 2)
                .unlockedBy(getHasName(DepEd_Blocks.GMATHS_BLOCK.get()), has(DepEd_Blocks.GMATHS_BLOCK))
                .save(output, "dscd26:gmaths_pressure_plate_from_stonecutting");

        //White wood types
        shaped(RecipeCategory.BUILDING_BLOCKS, DepEd_WoodenBlocks.WHITE_OAK_PLANKS.get(), 8)
                .pattern("PPP")
                .pattern("PCP")
                .pattern("PPP")
                .define('P', ItemTags.PLANKS)
                .define('C', Items.WHITE_DYE)
                .unlockedBy("has_wooden_planks", has(ItemTags.PLANKS))
                .save(output);
        stairBuilder(DepEd_WoodenBlocks.WHITE_OAK_STAIRS, Ingredient.of(DepEd_WoodenBlocks.WHITE_OAK_PLANKS))
                .unlockedBy(getHasName(DepEd_WoodenBlocks.WHITE_OAK_PLANKS.get()), has(DepEd_WoodenBlocks.WHITE_OAK_PLANKS))
                .group("deped_colored_stairs")
                .save(output);

        slab(RecipeCategory.BUILDING_BLOCKS, DepEd_WoodenBlocks.WHITE_OAK_SLAB.get(), DepEd_WoodenBlocks.WHITE_OAK_PLANKS.get());
        wall(RecipeCategory.BUILDING_BLOCKS, DepEd_WoodenBlocks.WHITE_OAK_WALL.get(), DepEd_WoodenBlocks.WHITE_OAK_PLANKS.get());

        fenceBuilder(DepEd_WoodenBlocks.WHITE_OAK_FENCE.get(), Ingredient.of(DepEd_WoodenBlocks.WHITE_OAK_PLANKS.get()))
                .unlockedBy(getHasName(DepEd_WoodenBlocks.WHITE_OAK_PLANKS.get()), has(DepEd_WoodenBlocks.WHITE_OAK_PLANKS))
                .group("deped_colored_fence")
                .save(output);
        fenceGateBuilder(DepEd_WoodenBlocks.WHITE_OAK_FENCE_GATE.get(), Ingredient.of(DepEd_WoodenBlocks.WHITE_OAK_PLANKS.get()))
                .unlockedBy(getHasName(DepEd_WoodenBlocks.WHITE_OAK_PLANKS.get()), has(DepEd_WoodenBlocks.WHITE_OAK_PLANKS))
                .group("deped_colored_fence_gate")
                .save(output);

        buttonBuilder(DepEd_WoodenBlocks.WHITE_OAK_BUTTON.get(), Ingredient.of(DepEd_WoodenBlocks.WHITE_OAK_PLANKS.get()))
                .unlockedBy(getHasName(DepEd_WoodenBlocks.WHITE_OAK_PLANKS.get()), has(DepEd_WoodenBlocks.WHITE_OAK_PLANKS))
                .group("deped_buttons")
                .save(output);
        pressurePlate(DepEd_WoodenBlocks.WHITE_OAK_PRESSURE_PLATE.get(), DepEd_WoodenBlocks.WHITE_OAK_PLANKS.get());

        //Misc Recipes
        shapeless(RecipeCategory.MISC, Items.SUGAR_CANE, 9)
                .requires(DepEd_Blocks.SUGARCANE_BLOCK)
                .unlockedBy("has_sugar_cane", has(Items.SUGAR_CANE))
                .save(output, "dscd26:sugar_cane_from_sugarcane_block");

        shapeless(RecipeCategory.MISC, Items.SUGAR, 27)
                .requires(DepEd_Blocks.BAKED_SUGARCANE_BLOCK)
                .unlockedBy("has_baked_sugarcane_block", has(DepEd_Blocks.BAKED_SUGARCANE_BLOCK))
                .save(output, "dscd26:sugar_from_baked_sugarcane_block");

        shaped(RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.YES_O, 16)
                .pattern("LFL")
                .pattern("MCM")
                .pattern("LFL")
                .define('F', ItemTags.FLOWERS)
                .define('L', ItemTags.LEAVES)
                .define('C', DepEd_CoreItems.GMATHS_CORE)
                .define('M', Items.BONE_MEAL)
                .unlockedBy(getHasName(DepEd_CoreItems.GMATHS_CORE), has(DepEd_CoreItems.GMATHS_CORE))
                .save(output);

        List<ItemLike> SUGAR_CANE_BAKEABLES = List.of(
                DepEd_Blocks.SUGARCANE_BLOCK
        );

        oreSmelting(SUGAR_CANE_BAKEABLES, RecipeCategory.FOOD, CookingBookCategory.FOOD, DepEd_Blocks.BAKED_SUGARCANE_BLOCK.get(), 0.25f, 200, "baked_sugarcane_block");

        shaped(RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.THE_GMATHS_TORCH, 4)
                .pattern("PLP")
                .pattern("LCL")
                .pattern("PLP")
                .define('P', Tags.Items.NUGGETS_IRON)
                .define('C', ItemTags.BUTTONS)
                .define('L', Items.LANTERN)
                .unlockedBy("has_buttons", has(ItemTags.BUTTONS))
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.THE_GMATHS_TORCH, 16)
                .pattern("PLP")
                .pattern("LCL")
                .pattern("PLP")
                .define('P', ItemTags.PLANKS)
                .define('C', DepEd_CoreItems.DEPED_CORE)
                .define('L', Items.LANTERN)
                .unlockedBy(getHasName(DepEd_CoreItems.DEPED_CORE), has(DepEd_CoreItems.DEPED_CORE))
                .save(output, "dscd26:the_gmaths_torch_bulk_recipe");

        shaped(RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.THE_GMATHS_TORCH_MK_II, 4)
                .pattern("PLP")
                .pattern("LCL")
                .pattern("PLP")
                .define('P', Tags.Items.NUGGETS_GOLD)
                .define('C', ItemTags.BUTTONS)
                .define('L', Items.LANTERN)
                .unlockedBy("has_buttons", has(ItemTags.BUTTONS))
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, DepEd_Blocks.THE_GMATHS_TORCH_MK_II, 16)
                .pattern("PLP")
                .pattern("LCL")
                .pattern("PLP")
                .define('P', ItemTags.PLANKS)
                .define('C', DepEd_CoreItems.GMATHS_CORE)
                .define('L', DepEd_Blocks.THE_GMATHS_TORCH)
                .unlockedBy(getHasName(DepEd_Blocks.THE_GMATHS_TORCH), has(DepEd_Blocks.THE_GMATHS_TORCH))
                .save(output, "dscd26:the_gmaths_torch_mk_ii_bulk_recipe");
    }


    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables, RecipeCategory craftingCategory,
        CookingBookCategory cookingCategory, ItemLike result, float experience, int cookingTime, String group, String fromDesc) { for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, DepEDSchoolCollectionDecoratives.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }
}
