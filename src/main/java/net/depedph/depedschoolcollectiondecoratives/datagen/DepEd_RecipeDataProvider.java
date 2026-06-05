package net.depedph.depedschoolcollectiondecoratives.datagen;

import net.depedph.depedschoolcollectiondecoratives.DepEDSchoolCollectionDecoratives;
import net.depedph.depedschoolcollectiondecoratives.blocks.DepEd_OreBlocks;
import net.depedph.depedschoolcollectiondecoratives.items.DepEd_Ingredients;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;

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
                .unlockedBy(getHasName(DepEd_Ingredients.DEPED_NUGGET.get()), has(DepEd_Ingredients.DEPED_NUGGET))
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
    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, DepEDSchoolCollectionDecoratives.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }
}
