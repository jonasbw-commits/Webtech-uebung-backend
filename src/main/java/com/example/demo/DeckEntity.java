package com.example.demo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="decks")
public class DeckEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CardEntity> cards;

    public DeckEntity() {}

    public DeckEntity(String name, List<CardEntity> cards) {
        this.name = name;
        this.cards = cards;
    }

    public Long getId() { return id; }

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
