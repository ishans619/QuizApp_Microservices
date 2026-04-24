package com.telusko.quizapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class JokeService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getJoke(){
        String url = "https://v2.jokeapi.dev/joke/Any";

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if(response.get("type").equals("single")){
            return response.get("joke").toString();
        }
        else{
            return response.get("setup") + " _ " + response.get("delivery");
        }
    }
}
