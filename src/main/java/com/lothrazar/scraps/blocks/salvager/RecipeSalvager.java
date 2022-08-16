package com.lothrazar.scraps.blocks.salvager;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lothrazar.scraps.ScrapModMain;
import com.lothrazar.scraps.content.ScrapModRegistry;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class RecipeSalvager implements Recipe<TileSalvager> {

  private final ResourceLocation id;
  //  private ItemStack result = ItemStack.EMPTY;
  int ingredientCount = 1;
  private NonNullList<Ingredient> ingredients = NonNullList.create();
  private NonNullList<Ingredient> output = NonNullList.create();

  public RecipeSalvager(ResourceLocation id, Ingredient in, int ingredientSize, NonNullList<Ingredient> output) {
    this.id = id;
    if (in.isEmpty() || ingredientSize < 0 || ingredientSize > 64) {
      throw new IllegalArgumentException("salvager recipe requires valid item and count number for the ingredient.  " + id);
    }
    ingredients.add(in);
    this.output = output;
    this.ingredientCount = ingredientSize;
  }

  @Override
  public ResourceLocation getId() {
    return id;
  }

  @Override
  public boolean isSpecial() {
    return true;
  }

  @Override
  public boolean matches(TileSalvager inv, Level worldIn) {
    try {
      return matches(inv.inputSlots.getStackInSlot(0), ingredients.get(0));
    }
    catch (ClassCastException e) {
      return false;
    }
  }

  public boolean matches(ItemStack current, Ingredient ing) {
    if (ing == Ingredient.EMPTY) {
      //it must be empty
      return current.isEmpty();
    }
    if (current.isEmpty()) {
      return ing == Ingredient.EMPTY;
    }
    return ing.test(current) && current.getCount() >= this.ingredientCount;
  }

  public ItemStack[] ingredientAt(int slot) {
    Ingredient ing = at(slot);
    return ing.getItems();
  }

  public Ingredient at(int slot) {
    return ingredients.get(slot);
  }

  @Override
  public NonNullList<Ingredient> getIngredients() {
    return ingredients;
  }

  @Override
  public ItemStack getResultItem() {
    return ItemStack.EMPTY;
  }

  @Override
  public RecipeType<?> getType() {
    return ScrapModRegistry.RECIPE.get();
  }

  @Override
  public RecipeSerializer<?> getSerializer() {
    return ScrapModRegistry.RECIPE_S.get();
  }

  public static class SerializeCrusher extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<RecipeSalvager> {

    public SerializeCrusher() {}

    /**
     * The fluid stuff i was helped out a ton by looking at this https://github.com/mekanism/Mekanism/blob/921d10be54f97518c1f0cb5a6fc64bf47d5e6773/src/api/java/mekanism/api/SerializerHelper.java#L129
     */
    @Override
    public RecipeSalvager fromJson(ResourceLocation recipeId, JsonObject json) {
      try {
        Ingredient inputFirst = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient"));
        // 
        //        ItemStack resultStack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
        ShapelessRecipe lol;
        NonNullList<Ingredient> nonnulllist = itemsFromJson(GsonHelper.getAsJsonArray(json, "results"));
        RecipeSalvager r = new RecipeSalvager(recipeId, inputFirst, json.get("count").getAsInt(), nonnulllist);
        return r;
      }
      catch (Exception e) {
        ScrapModMain.LOGGER.error("Error loading recipe" + recipeId, e);
        return null;
      }
    }

    private static NonNullList<Ingredient> itemsFromJson(JsonArray json) {
      NonNullList<Ingredient> nonnulllist = NonNullList.create();
      for (int i = 0; i < json.size(); ++i) {
        Ingredient ingredient = Ingredient.fromJson(json.get(i));
        if (net.minecraftforge.common.ForgeConfig.SERVER.skipEmptyShapelessCheck.get() || !ingredient.isEmpty()) {
          nonnulllist.add(ingredient);
        }
      }
      return nonnulllist;
    }

    @Override
    public RecipeSalvager fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
      //input first
      Ingredient ingredient = Ingredient.fromNetwork(buffer);
      int ingredientCount = buffer.readInt();
      //results
      int resultSize = buffer.readVarInt();
      NonNullList<Ingredient> results = NonNullList.withSize(resultSize, Ingredient.EMPTY);
      for (int j = 0; j < results.size(); ++j) {
        results.set(j, Ingredient.fromNetwork(buffer));
      }
      RecipeSalvager r = new RecipeSalvager(recipeId, ingredient, ingredientCount, results);
      return r;
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, RecipeSalvager recipe) {
      //ingredient first
      recipe.ingredients.get(0).toNetwork(buffer);
      buffer.writeInt(recipe.ingredientCount);
      //results
      buffer.writeVarInt(recipe.output.size()); // resultSize
      for (Ingredient ingredient : recipe.output) {
        ingredient.toNetwork(buffer);
      }
    }
  }

  @Override
  public ItemStack assemble(TileSalvager t) {
    return ItemStack.EMPTY;
  }

  @Override
  public boolean canCraftInDimensions(int width, int height) {
    return width <= 1 && height <= 1;
  }
}
