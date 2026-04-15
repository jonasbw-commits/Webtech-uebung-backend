package com.example.demo;

import java.util.List;

public class DeckEntity {

    private String name;
    private List<CardEntity> cards;

    public DeckEntity(String name, List<CardEntity> cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }
    public List<CardEntity> getCards() {
        return cards;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCards(List<CardEntity> cards) {
        this.cards = cards;
    }

}
