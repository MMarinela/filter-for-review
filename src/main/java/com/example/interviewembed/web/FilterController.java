package com.example.interviewembed.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filter")
public class FilterController {

    @GetMapping
    public String getReviewsPage(@RequestParam(required = false) String error, HttpServletRequest req, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "filter";
    }

    @PostMapping
    public String addReview(@RequestParam String rating,
                            @RequestParam Integer minimum_rating,
                            @RequestParam String order_by_date,
                            @RequestParam String prioritize_by_text) {

            //TO DO:
            //Filter Function with parameters rating, minimum_rating, order_by_date, prioritize_by_text

            return "redirect:/filter/filter-reviews";
    }

    @GetMapping("/filter-reviews")
    public String getFilterReview(@RequestParam(required = false) String error, HttpServletRequest req, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        //TO DO:
        //Present reviews into table

        return "filter-reviews";
    }
}

