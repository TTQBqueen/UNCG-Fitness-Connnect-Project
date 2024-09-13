package com.csc340.csc340HW2;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class Controller {

    Map<Integer, Joke> JokeDatabase = new HashMap<>();
//    @GetMapping("/joke")
//    public Object Joke(@RequestParam(value = "id", defaultValue = "random") String Joke) {
//        try {
//            String url = "https://api.chucknorris.io/jokes/random";
//            RestTemplate restTemplate = new RestTemplate();
//            ObjectMapper mapper = new ObjectMapper();
//
//            String jsonListResponse = restTemplate.getForObject(url, String.class);
//            JsonNode root = mapper.readTree(jsonListResponse);
//
//
//            //Extract relevant info from the response and use it for what you want, in this case build a Fruit object
//            return new Joke(root.get("id").asText(), root.get("url").asText(), root.get("value").asText());
//        } catch (JsonProcessingException ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE,
//                    null, ex);
//            return "error in /joke";
//        }
//    }
//}
//
private final RestTemplate restTemplate = new RestTemplate();
@GetMapping("/joke")
public Joke getJoke(@RequestParam(value = "id", defaultValue = "random") String id) {
    try {
        String url = "https://api.chucknorris.io/jokes/random";
        // Fetch the joke from the API
        Joke joke = restTemplate.getForObject(url, Joke.class);

        if (joke != null) {
            return joke;
        } else {
            throw new RuntimeException("Joke not found.");
        }
    } catch (Exception ex) {
        // Log the error and return a meaningful response
        return new Joke("Error", "N/A", "An error occurred while fetching the joke.");
    }
}
}