package com.example.interviewembed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Review {
    private String text;
    private String date;
    private String rating;

    public Review(String text, String date, String rating) {
        this.text = text;
        this.date = date;
        this.rating = rating;
    }
}

