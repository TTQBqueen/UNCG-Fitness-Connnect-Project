package com.UNCG_Fitness.UNCG_Fitness_Connect.API;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class QuoteService {

    private static final String API_URL = "https://zenquotes.io/api/random";

    public String getMotivationalQuote() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            // Fetch the API response and map to an array of String
            QuoteResponse[] response = restTemplate.getForObject(API_URL, QuoteResponse[].class);
            if (response != null && response.length > 0) {
                return response[0].getQ(); // Return the quote text
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Stay positive and keep going!"; // Default fallback quote
    }

    // Inner class to map only the "q" field
    static class QuoteResponse {
        private String q;

        public String getQ() {
            return q;
        }

        public void setQ(String q) {
            this.q = q;
        }
    }
}
