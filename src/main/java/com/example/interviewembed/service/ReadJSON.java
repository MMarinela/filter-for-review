package com.example.interviewembed.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.interviewembed.model.Review;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSON {
    @SuppressWarnings("unchecked")
    public static List<Review> main(String[] args)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("reviews.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray reviewsList = (JSONArray) obj;
            System.out.println(reviewsList);
            List<Review> reviews = new ArrayList<>();
            for (Object review : reviewsList) {
            reviews.add(parseReviewObject((JSONObject) review));
            return reviews;
        }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Review parseReviewObject(JSONObject reviewObject)
    {
        String rating = (String) reviewObject.get("rating");

        String reviewText = (String) reviewObject.get("reviewText");

        String reviewCreatedOnDate = (String) reviewObject.get("reviewCreatedOnDate");

        Review review_object= new Review(rating, reviewText, reviewCreatedOnDate);
           return review_object;
    }
}