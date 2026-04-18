package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {
    
    @GetMapping
    public List<CardEntity> getAllCards(){
        List<CardEntity> cards = new ArrayList<>();
        cards.add(new CardEntity("el algoritmo", "der Algorithmus", false));
        cards.add(new CardEntity("el bucle", "die Schleife", false));
        cards.add(new CardEntity("la base de data", "die Datenbank", false));
        return cards;
    }
}
