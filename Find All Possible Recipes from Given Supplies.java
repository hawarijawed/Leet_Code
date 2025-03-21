/*
You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. A recipe can also be an ingredient for other recipes, i.e., ingredients[i] may contain a string that is in recipes.

You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.

Return a list of all the recipes that you can create. You may return the answer in any order.

Note that two recipes may contain each other in their ingredients
*/
class Solution {

    public List<String> findAllRecipes(
        String[] recipes,
        List<List<String>> ingredients,
        String[] supplies
    ) {
        List<String> possibleRecipes = new ArrayList<>();
        // Track if ingredient/recipe can be made
        Map<String, Boolean> canMake = new HashMap<>();
        // Map recipe name to its index in ingredients list
        Map<String, Integer> recipeToIndex = new HashMap<>();

        // Mark all initial supplies as available
        for (String supply : supplies) {
            canMake.put(supply, true);
        }

        // Create recipe to index mapping
        for (int idx = 0; idx < recipes.length; idx++) {
            recipeToIndex.put(recipes[idx], idx);
        }

        // Try to make each recipe using DFS
        for (String recipe : recipes) {
            checkRecipe(
                recipe,
                ingredients,
                new HashSet<String>(),
                canMake,
                recipeToIndex
            );
            if (canMake.get(recipe)) {
                possibleRecipes.add(recipe);
            }
        }

        return possibleRecipes;
    }

    private void checkRecipe(
        String recipe,
        List<List<String>> ingredients,
        Set<String> visited,
        Map<String, Boolean> canMake,
        Map<String, Integer> recipeToIndex
    ) {
        // Return if we already know if recipe can be made
        if (canMake.containsKey(recipe) && canMake.get(recipe)) {
            return;
        }

        // Not a valid recipe or cycle detected
        if (!recipeToIndex.containsKey(recipe) || visited.contains(recipe)) {
            canMake.put(recipe, false);
            return;
        }

        visited.add(recipe);

        // Check if we can make all required ingredients
        List<String> neededIngredients = ingredients.get(
            recipeToIndex.get(recipe)
        );
        for (String ingredient : neededIngredients) {
            checkRecipe(
                ingredient,
                ingredients,
                visited,
                canMake,
                recipeToIndex
            );
            if (!canMake.get(ingredient)) {
                canMake.put(recipe, false);
                return;
            }
        }

        // All ingredients can be made
        canMake.put(recipe, true);
    }
}
