package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject jsonObject=new JSONObject(json);
            JSONObject jo1=jsonObject.getJSONObject("name");
            String name=jo1.getString("mainName");

            JSONArray jsonAlsoKnownAs=jo1.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs=new ArrayList<>();
            for (int i=0;i<jsonAlsoKnownAs.length();i++)
            {
                alsoKnownAs.add((String) jsonAlsoKnownAs.get(i));
            }

            JSONArray jsonArray1=jsonObject.getJSONArray("ingredients");
            List<String> ingredients=new ArrayList<>();
            for (int i=0;i<jsonArray1.length();i++)
            {
                ingredients.add((String) jsonArray1.get(i));
            }
            String description=jsonObject.getString("description");
            String image=jsonObject.getString("image");
            String placeOfOrigin=jsonObject.getString("placeOfOrigin");
            Sandwich sandwich=new Sandwich(name,alsoKnownAs,placeOfOrigin,description,image,ingredients);
            return sandwich;
        } catch (JSONException e) {
            Log.e("JsonUtils","exception"+e);
            e.printStackTrace();
        }
        return null;
    }
}
