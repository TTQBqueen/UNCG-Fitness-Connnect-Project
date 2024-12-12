package com.UNCG_Fitness.UNCG_Fitness_Connect.API;

import com.UNCG_Fitness.UNCG_Fitness_Connect.API.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/motivational-quotes")
    public String showQuotePage(Model model) {
        // Fetch the quote
        String motivationalQuote = quoteService.getMotivationalQuote();

        // Add it to the model
        model.addAttribute("quote", motivationalQuote);

        return "index";
    }
}