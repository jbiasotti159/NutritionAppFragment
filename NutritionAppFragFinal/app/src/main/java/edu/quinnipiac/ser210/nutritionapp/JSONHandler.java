package edu.quinnipiac.ser210.nutritionapp;

/*
    Jillian Biasotti
    3/22/2018
    Nutritional App Project
 */
import org.json.JSONException;
import org.json.JSONObject;

//Handler to pull in information from JSON and make it readable

public class JSONHandler {

    public String getFoodData(String JSONString) throws JSONException{
        String item_name,brand_name,item_description,nf_ingredient_statement,nf_calories,nf_calories_from_fat,nf_sodium,nf_total_carbohydrate, nf_sugars, nf_protein;

                JSONObject foodData = new JSONObject(JSONString);

                item_name = foodData.getString("item_name");
                brand_name = foodData.getString("brand_name");
                item_description = foodData.getString("item_description");
                nf_ingredient_statement = foodData.getString("nf_ingredient_statement");
                nf_calories = foodData.getString("nf_calories");
                nf_calories_from_fat = foodData.getString("nf_calories_from_fat");
                nf_sodium = foodData.getString("nf_sodium");
                nf_total_carbohydrate = foodData.getString("nf_total_carbohydrate");
                nf_sugars = foodData.getString("nf_sugars");
                nf_protein = foodData.getString("nf_protein");


                String toset = "" + item_name + " " + brand_name
                + "\nItem Description: " + item_description + "\n"
                + "\nIngredient Statement: " + nf_ingredient_statement + "\n"
                + "\nCalories: " + nf_calories + "\n"
                + "\nCalories From Fat: " + nf_calories_from_fat + "\n"
                + "\nSodium: " + nf_sodium + "\n"
                + "\nTotal Carbohydrates:" + nf_total_carbohydrate + "\n"
                + "\nSugars: " + nf_sugars + "\n"
                + "\nProteins: " + nf_protein;
                return toset;

        }
    }

